package xxj.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xxj.project.model.SeatsHasSchedule;

@Repository
public interface SeatsHasScheduleRepository extends JpaRepository<SeatsHasSchedule, Integer> {
}
