package com.epsi.SalleReserver;

import com.epsi.SalleReserver.Entity.Reservation;
import com.epsi.SalleReserver.Entity.Room;
import com.epsi.SalleReserver.Entity.User;
import com.epsi.SalleReserver.Repository.ReservationRepository;
import com.epsi.SalleReserver.Repository.RoomRepository;
import com.epsi.SalleReserver.Repository.UserRepository;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;


@SpringBootApplication
public class SalleReserverApplication {

	public static void main(String[] args) {SpringApplication.run(SalleReserverApplication.class, args);}

	@Bean
	CommandLineRunner initDatabase(RoomRepository roomRepository, UserRepository userRepository, ReservationRepository reservationRepository) {

		return args -> {
			Faker faker = new Faker();
			List<User> users = new ArrayList<>();
			List<Room> rooms = new ArrayList<>();

			for (int i = 0; i < 20; i++) {
				// For Room
				String roomName = faker.lorem().word();
				String imageLink = faker.internet().url();
				int capacity = faker.number().numberBetween(10, 100);
				String equipements = faker.lorem().sentence();
				Room room = new Room(roomName, imageLink, capacity, equipements);
				room = roomRepository.save(room);
				rooms.add(room);

				// For User
				String username = faker.name().username();
				String password = faker.internet().password();
				String email = faker.internet().emailAddress();
				User user = new User(username, password, email);
				user = userRepository.save(user);
				users.add(user);
			}

			for (int i = 0; i < 20; i++) {
				// For Reservation
				Date dateReservation = faker.date().future(30, TimeUnit.DAYS);
				LocalDateTime heureDebut = LocalDateTime.now().plusDays(faker.number().numberBetween(1, 30));
				LocalDateTime heureFin = heureDebut.plusHours(faker.number().numberBetween(1, 5));

				Set<User> reservationUsers = new HashSet<>();
				reservationUsers.add(users.get(i));

				Reservation reservation = new Reservation();
				reservation.setUtilisateurs(reservationUsers);
				reservation.setRoom(rooms.get(i));
				reservation.setDateReservation(dateReservation);
				reservation.setHeureDebut(heureDebut);
				reservation.setHeureFin(heureFin);

				reservationRepository.save(reservation);
			}
		};
	}

}
