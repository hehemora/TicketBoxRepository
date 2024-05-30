package mainpack.TicketBox.services;

import lombok.RequiredArgsConstructor;
// import mainpack.TicketBox.models.User;
import mainpack.TicketBox.repositories.UserRepository;

// import java.util.stream.Collectors;

// import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    // @Override
    // public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    //     User user = userRepository.findByEmail(email);
    //     if (user != null) {
    //         return new org.springframework.security.core.userdetails.User(user.getEmail(),
    //                 user.getPassword(),
    //                 user.getRoles().stream()
    //                         .map((role) -> new SimpleGrantedAuthority(role.getAuthority()))
    //                         .collect(Collectors.toList()));
    //     } else {
    //         throw new UsernameNotFoundException("Invalid email or password");
    //     }
    // }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
    }
}