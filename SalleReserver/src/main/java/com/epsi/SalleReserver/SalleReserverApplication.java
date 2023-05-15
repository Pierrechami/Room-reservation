package com.epsi.SalleReserver;

import com.epsi.SalleReserver.Repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SalleReserverApplication {

}
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {SpringApplication.run(SalleReserverApplication.class, args);}

	@PostConstruct
	public void init() {


	}
}
