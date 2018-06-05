package xxj.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xxj.project.model.DelayedFlight;

@Repository
public interface DelayedFlightRepository extends JpaRepository<DelayedFlight, Integer> {
}
