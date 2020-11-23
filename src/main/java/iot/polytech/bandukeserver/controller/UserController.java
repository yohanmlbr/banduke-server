package iot.polytech.bandukeserver.controller;

import iot.polytech.bandukeserver.entity.request.UserProfile;
import iot.polytech.bandukeserver.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserService us;

    @GetMapping("/{id}")
    public UserProfile getUserProfil(@PathVariable int id){
        return us.getUserProfile(id);
    }

    @GetMapping("/list")
    public List<UserProfile> getUserProfil(@RequestParam(defaultValue = "") String name){
        return us.getUsersProfile(name);
    }
}

