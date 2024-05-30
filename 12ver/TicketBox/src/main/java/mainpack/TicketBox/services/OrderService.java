package mainpack.TicketBox.services;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mainpack.TicketBox.models.Order;
import mainpack.TicketBox.models.Ticket;
import mainpack.TicketBox.models.User;
import mainpack.TicketBox.repositories.OrderRepository;
import mainpack.TicketBox.repositories.TicketRepository;
// import mainpack.TicketBox.repositories.TicketRepository;
import mainpack.TicketBox.repositories.UserRepository;

import java.security.Principal;
// import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;
    public void saveOrder(Principal principal, Order order, User user, Ticket ticket, Long id){
        // ticket.setUser(getUserByPrincipal(principal));
        ticket = ticketRepository.findById(id).orElse(null);
        ticket.minusone();
        ticketRepository.save(ticket);
        log.info("Saving new {}", order);
        // order.setuserid(user.getId());
        order.assignToUser(userRepository.findByEmail(principal.getName()));
        order.assignToTicket(ticket);
        // order.setticketid(ticket.getId());
        orderRepository.save(order);
    }
    public boolean isticketnull(Ticket ticket, Long id){
        ticket = ticketRepository.findById(id).orElse(null);
        if (ticket.iszero())
        {
            return true;
        }
        else{
            return false;
        }
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    public void deleteOrder(Long id, Ticket ticket){
        ticket.plusone();
        ticketRepository.save(ticket);
        orderRepository.deleteById(id);
    }
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}
