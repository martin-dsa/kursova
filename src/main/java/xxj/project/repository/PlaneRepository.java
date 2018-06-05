package xxj.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xxj.project.model.Plane;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Integer> {
}
