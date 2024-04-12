package com.tipu.spring_security.service;
import com.tipu.spring_security.entity.User;
import com.tipu.spring_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;


    public void save(Map<String, String> reqMap) {
        User user = new User();
        user.setName(reqMap.get("name"));
        user.setUsername(reqMap.get("username"));
        user.setEmail(reqMap.get("email"));
        String password = reqMap.get("password");
        user.setPassword(encoder.encode(password));
        userRepository.save(user);
    }
}
