package iot.polytech.bandukeserver.controller;

import iot.polytech.bandukeserver.entity.User;
import iot.polytech.bandukeserver.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserService us;

    @GetMapping("/list")
    public List<User> getUsers(){
        return us.getUsers();
    }

}

