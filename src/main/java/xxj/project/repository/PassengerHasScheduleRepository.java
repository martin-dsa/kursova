package xxj.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xxj.project.model.PassengerHasSchedule;

@Repository
public interface PassengerHasScheduleRepository extends JpaRepository<PassengerHasSchedule, Integer> {
}
