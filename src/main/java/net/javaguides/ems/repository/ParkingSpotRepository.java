package net.javaguides.ems.repository;

import net.javaguides.ems.entity.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpot , Long> {

    Optional<ParkingSpot> findByEmployeeId(Long employeeId);

}
