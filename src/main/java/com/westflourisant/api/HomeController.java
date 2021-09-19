package com.westflourisant.api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> getUser () {
        return this.userService.getUser();
    }

    @GetMapping("/")
    public String home () {
        return "Hello World";
    }

    @PostMapping("/users")
    public User saveUser (@RequestBody User user) {
        return this.userService.saveUser(user);
    }

    @PutMapping("/users/{userId}")
    public User deleteUser (@RequestBody User user, @PathVariable String userId) {
        System.out.println("userId====>" + userId);
        return this.userService.updateUser(user, userId);
    }

    @DeleteMapping("/users/{userId}")
    public User deleteUser (@PathVariable String userId) {
        return this.userService.deleteUser(userId);
    }
}
