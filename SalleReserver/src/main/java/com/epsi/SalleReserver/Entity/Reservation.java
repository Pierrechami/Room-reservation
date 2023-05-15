package com.epsi.SalleReserver.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Reservation {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_reservation")
    private int id;

    @ManyToMany
    @JoinTable(
            name = "reservation_utilisateur",
            joinColumns = @JoinColumn(name = "Id_reservation"),
            inverseJoinColumns = @JoinColumn(name = "Id_user"))
    private Set<User> utilisateurs;

    @ManyToOne
    @JoinColumn(name="Id_room")
    private Room room;

    @Column(name = "date_reservation")
    private Date dateReservation;

    @Column(name = "heure_debut")
    private LocalDateTime heureDebut;

    @Column(name = "heure_fin")
    private LocalDateTime heureFin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<User> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(Set<User> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public LocalDateTime getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalDateTime heureDebut) {
        this.heureDebut = heureDebut;
    }

    public LocalDateTime getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(LocalDateTime heureFin) {
        this.heureFin = heureFin;
    }
}
