package xxj.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xxj.project.model.MedicalExam;

@Repository
public interface MedicalExamRepository extends JpaRepository<MedicalExam, Integer> {
}
