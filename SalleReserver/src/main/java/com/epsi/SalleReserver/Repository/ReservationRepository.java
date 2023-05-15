package com.epsi.SalleReserver.Repository;

import com.epsi.SalleReserver.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
