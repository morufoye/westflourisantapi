package com.westflourisant.api;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUser () {
        return this.userRepository.findAll();
    }

    public User saveUser (User user) {
        return this.userRepository.save(user);
    }

    public User deleteUser (String userId) {
        Optional<User> optionalUser = this.userRepository.findById(Long.parseLong(userId));
        if(optionalUser.isPresent()) {
            User u = optionalUser.get();
            this.userRepository.delete(u);
            return  u;
        }
        throw new RuntimeException("User not Found");
    }

    public User updateUser (User user, String id) {
        Optional<User> optionalUser = this.userRepository.findById(Long.parseLong(id));
        if(optionalUser.isPresent()) {
            User u = optionalUser.get();
            u.setLastName(user.getLastName());
            u.setFirstName(user.getFirstName());
            this.userRepository.save(u);
            return  u;
        }
        throw new RuntimeException("User not Found");
    }
}
