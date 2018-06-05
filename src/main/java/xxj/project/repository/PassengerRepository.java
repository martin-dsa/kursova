package xxj.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xxj.project.model.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
}
