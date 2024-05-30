package mainpack.TicketBox.services;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mainpack.TicketBox.models.Ticket;
import mainpack.TicketBox.models.User;
import mainpack.TicketBox.repositories.TicketRepository;
import mainpack.TicketBox.repositories.UserRepository;

import java.security.Principal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    // private List<Ticket> tickets = new ArrayList<>();
//    private long ID = 0;
//    {
//        tickets.add(new Ticket(++ID, "TestRoute1", 800, "10.09.23", "18:00-20:00"));
//        tickets.add(new Ticket(++ID, "TestRoute2", 750, "11.09.23", "17:30-19:00"));
//    }

    public List<Ticket> listTickets(String route) {
        // List<Ticket> tickets = ticketRepository.findAll();
        if (route != null) return ticketRepository.findByRoute(route);
        return ticketRepository.findAll();
    }

    // public void saveCount(Principal principal, Ticket ticket){
    //     // ticket.setUser(getUserByPrincipal(principal));
    //     ticket.minusone();
    //     ticketRepository.save(ticket);
    // }

    public void saveTicket(Principal principal, Ticket ticket){
        // ticket.setUser(getUserByPrincipal(principal));
        log.info("Saving new {}", ticket);
        ticketRepository.save(ticket);
    }
    // public void buyTicket(Principal principal, Ticket ticket){
    //     ticket.setUser(getUserByPrincipal(principal));
    //     ticketRepository.save(ticket);
    // }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    public void deleteTicket(Long id){
        ticketRepository.deleteById(id);
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }
}
