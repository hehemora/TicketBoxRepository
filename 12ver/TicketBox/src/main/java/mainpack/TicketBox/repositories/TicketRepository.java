package mainpack.TicketBox.repositories;

import mainpack.TicketBox.models.Ticket;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByRoute(String route);
}
