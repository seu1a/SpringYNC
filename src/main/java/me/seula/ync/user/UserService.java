package me.seula.ync.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptEncoder;

    public UserEntity create(String username, String email, String password) {
        UserEntity user = new UserEntity();

        user.setUsername(username);
        user.setEmail(email);

        user.setPassword(bCryptEncoder.encode(password));

        userRepository.save(user);

        return user;
    }

}
