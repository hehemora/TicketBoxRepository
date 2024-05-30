package mainpack.TicketBox.models;

import java.util.ArrayList;
import java.util.Collection;
// import jakarta.persistence.OneToOne;
// import jakarta.persistence.CascadeType;
// import jakarta.persistence.FetchType;
import java.util.HashSet;
import java.util.List;
// import java.util.List;
// import java.util.List;
import java.time.LocalDateTime;
import java.util.Set;
import mainpack.TicketBox.models.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "name")
    private String name;
    @Column(name = "initials")
    private String initials;
    @Column(name = "active")
    private boolean active;
    // @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(name = "password", length = 1000)
    private String password;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();
    // @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    // private List<Ticket> tickets = new ArrayList<>();
    private LocalDateTime dateOfCreated;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.MERGE, orphanRemoval = true)
    public List<Order> orders = new ArrayList<>();
    // @ElementCollection(targetClass = Order.class, fetch = FetchType.EAGER)
    // @CollectionTable(name = "orders", joinColumns = @JoinColumn(name = "user_id"))


    @PrePersist
    private void init(){
        dateOfCreated = LocalDateTime.now();
    }

    // public void addTicketToUser(Ticket ticket) {
    //     ticket.setUser(this);
    //     tickets.add(ticket);
    // }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public boolean isAdmin() {return roles.contains(Role.ROLE_ADMIN);}
   

    @Override
    public String getUsername(){
        return email;
    }

    
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return roles;
    }
}
