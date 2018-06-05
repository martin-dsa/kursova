package xxj.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xxj.project.model.Brigade;

@Repository
public interface BrigadeRepository extends JpaRepository<Brigade, Integer> {
}
