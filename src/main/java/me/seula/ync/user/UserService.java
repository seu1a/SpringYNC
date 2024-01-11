package me.seula.ync.user;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity create(String username, String email, String password) {
        UserEntity user = new UserEntity();

        user.setUsername(username);
        user.setEmail(email);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        user.setPassword(passwordEncoder.encode(password));

        userRepository.save(user);

        return user;
    }

}
