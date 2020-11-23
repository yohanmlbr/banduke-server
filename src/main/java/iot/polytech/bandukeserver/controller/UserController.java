package iot.polytech.bandukeserver.controller;

import iot.polytech.bandukeserver.entity.request.UserProfil;
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
    public UserProfil getUserProfil(@PathVariable int id){
        return us.getUserProfil(id);
    }

    @GetMapping("/list")
    public List<UserProfil> getUserProfil(@RequestParam(defaultValue = "") String name){
        return us.getUsersProfil(name);
    }
}

