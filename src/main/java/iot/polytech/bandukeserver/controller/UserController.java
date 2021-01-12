package iot.polytech.bandukeserver.controller;

import iot.polytech.bandukeserver.entity.request.UserDetails;
import iot.polytech.bandukeserver.entity.request.UserIdData;
import iot.polytech.bandukeserver.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserService us;

    @GetMapping("/{id}")
    public UserDetails getUserDetails(@PathVariable int id){
        return us.getUserDetailsById(id);
    }

    @PutMapping("/{id}")
    public UserDetails updateUserProfile(@PathVariable long id,
                                        @RequestBody UserDetails newProfile){
        return us.updateUserDetails(id, newProfile);
    }

    @DeleteMapping
    public UserIdData deactivateUserProfile(HttpServletRequest req){
        String token = req.getHeader("Authorization").replace("Bearer ","");
        return us.deactivateUserProfile(token);
    }


    @GetMapping("/list")
    public List<UserIdData> getUsersProfile(@RequestParam(defaultValue = "") String username){
        return us.getUsersIdData(username);
    }


}

