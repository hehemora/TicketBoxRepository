package mainpack.TicketBox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mainpack.TicketBox.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
