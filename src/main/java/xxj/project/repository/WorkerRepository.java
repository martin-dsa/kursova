package xxj.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xxj.project.model.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {
}
