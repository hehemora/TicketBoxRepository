package mainpack.TicketBox.models;
import java.util.HashSet;
import java.util.Set;

// import jakarta.persistence.*;
import jakarta.persistence.*;
// import lombok.AllArgsConstructor;
import lombok.Data;
// import lombok.NoArgsConstructor;
// import java.util.Collection;

@Entity
@Table(name="tickets")
@Data
// @AllArgsConstructor
// @NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="route")
    private String route;
    @Column(name="price")
    private int price;
    @Column(name="day")
    private String day;
    @Column(name="startend")
    private String startend;
    @Column(name="startstaion")
    private String startstation;
    @Column(name="endstation")
    private String endstation;
    @Column(name="seatsleft")
    private int seatsleft;
    // @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    // @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "ticket_id"))
    // @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    // @JoinColumn
    // private User user;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ticket", cascade = CascadeType.MERGE, orphanRemoval = true)
    public Set<Order> orders = new HashSet<Order>(0);

    public void minusone() {
        seatsleft -= 1;
    }
    public void plusone() {
        seatsleft += 1;
    }
    public boolean iszero() {
        if (seatsleft == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

