package xxj.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xxj.project.model.Seats;

@Repository
public interface SeatsRepository extends JpaRepository<Seats, Integer> {
}
