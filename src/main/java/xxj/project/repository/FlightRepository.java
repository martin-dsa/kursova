package xxj.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xxj.project.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
}
