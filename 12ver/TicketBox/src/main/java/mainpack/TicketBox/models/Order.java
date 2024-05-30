package mainpack.TicketBox.models;

// import java.util.List;

import jakarta.persistence.*;
// import lombok.Data;
@Entity
@Table(name="orders")
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    // @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    public void assignToUser(User user) {
        user.orders.add(this);
        this.user = user;
    }
    public void assignToTicket(Ticket ticket) {
        ticket.orders.add(this);
        this.ticket=ticket;
    }
    // public Ticket getticket(){
    //     return ticket;
    // }

    public Long getid(){
        return id;
    }
    public Ticket getticket(){
        return ticket;
    }
    

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "ticket_id")
    // private Ticket ticket;

    // @Column(name = "user_id")
// private Long user_id;

    // public void setuserid(Long id){
    //     this.user_id=id;
    // }


    // @Column(name = "ticket_id")
    // private Long ticket_id;

    // public void setticketid(Long id){
    //     this.ticket_id=id;
}
