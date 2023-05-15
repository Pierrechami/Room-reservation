package com.epsi.SalleReserver.Repository;

import com.epsi.SalleReserver.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
