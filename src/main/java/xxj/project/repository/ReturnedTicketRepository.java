package xxj.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xxj.project.model.ReturnedTicket;

@Repository
public interface ReturnedTicketRepository extends JpaRepository<ReturnedTicket, Integer> {
}
