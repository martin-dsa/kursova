package xxj.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xxj.project.model.CancelledFlight;

@Repository
public interface CancelledFlightRepository extends JpaRepository<CancelledFlight, Integer> {
}
