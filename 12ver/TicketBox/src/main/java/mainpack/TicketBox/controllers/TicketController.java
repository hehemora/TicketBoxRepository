package mainpack.TicketBox.controllers;
import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import mainpack.TicketBox.models.Order;
import mainpack.TicketBox.models.Ticket;
import mainpack.TicketBox.models.User;
import mainpack.TicketBox.services.OrderService;
import mainpack.TicketBox.services.TicketService;

@Controller
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;
    private final OrderService orderService;

    @GetMapping("/")
    public String tickets(@RequestParam(name = "searchWord", required = false) String route, Principal principal, Model model) {
        model.addAttribute("tickets", ticketService.listTickets(route));
        model.addAttribute("user", ticketService.getUserByPrincipal(principal));
        model.addAttribute("searchWord", route);
        return "tickets";
    }

    @GetMapping("/ticket/{id}")
    public String ticketInfo(@PathVariable Long id, Model model, Principal principal){
        model.addAttribute("ticket", ticketService.getTicketById(id));
        model.addAttribute("user", ticketService.getUserByPrincipal(principal));
        return "ticket-info";
    }

    @PostMapping("/ticket/create")
    public String createTicket(Ticket ticket, Principal principal){
        ticketService.saveTicket(principal, ticket);
        return "redirect:/";
    }

    @PostMapping("/ticket/delete/{id}")
    public String deleteTicket(@PathVariable Long id){
        ticketService.deleteTicket(id);
        return "redirect:/";
    }
    @PostMapping("ticket/buy/{id}")
    public String buyTicket(@PathVariable Long id, Ticket ticket, Principal principal, Order order, Model model, User user){
        // model.addAttribute("ticket", ticket);
        // model.addAttribute("user", user);
        // ticketService.saveTicket(principal, ticket);
        // userService.saveUser(principal, user);
        if (orderService.isticketnull(ticket, id) == true)
        {
            return "notickets";
        }
        else{
            orderService.saveOrder(principal, order, user, ticket, id);
            return "purchase";
        } 
    }
    @GetMapping("/my/tickets")
    public String userTickets(Principal principal, Model model) {
        User user = ticketService.getUserByPrincipal(principal);
        model.addAttribute("user", user);
        model.addAttribute("searchWord", user.getId());
        List<Order> orders = user.getOrders();
        // for(int i = 0; i< orders.size(); i++) {
        //     Order order = orders.get(i);
        // }
        model.addAttribute("orders", orders);
        return "my-tickets";
    }
    @PostMapping("/order/delete/{id}")
    public String deleteOrder(@PathVariable Long id, Principal principal, Model model){
        User user = ticketService.getUserByPrincipal(principal);
        model.addAttribute("user", user);
        Order order = orderService.getOrderById(id);
        Ticket ticket = order.getticket();
        orderService.deleteOrder(id, ticket);
        return "confirm";
    }

    @PostMapping("/order/print/{id}")
    public String printOrder(@PathVariable Long id, Principal principal, Model model){
        User user = ticketService.getUserByPrincipal(principal);
        model.addAttribute("user", user);
        Order order = orderService.getOrderById(id);
        model.addAttribute("order", order);
        // Ticket ticket = order.getticket();
        return "print";
    }
}
