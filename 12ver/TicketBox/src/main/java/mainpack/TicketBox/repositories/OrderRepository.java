package mainpack.TicketBox.repositories;
import mainpack.TicketBox.models.Order;


// import java.util.List;
// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}