package iot.polytech.bandukeserver.controller;

import iot.polytech.bandukeserver.entity.User;
import iot.polytech.bandukeserver.entity.request.UserProfile;
import iot.polytech.bandukeserver.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @PutMapping("/{id}")
    public UserProfile updateUserProfile(@PathVariable long id,
                                       @RequestBody UserProfile newProfile){
        return us.updateUserProfile(id, newProfile);
    }

    @DeleteMapping
    public UserProfile deactivateUserProfile(HttpServletRequest req){
        String token = req.getHeader("Authorization").replace("Bearer ","");
        return us.deactivateUserProfile(token);
    }


    @GetMapping("/list")
    public List<UserProfile> getUsersProfile(@RequestParam(defaultValue = "") String username){
        return us.getUsersProfile(username);
    }

    @GetMapping("/friends")
    public List<UserProfile> getUserFriendsList() {
        return us.getUserFriendsList(); }

    @PostMapping("/friend/{id}")
    public UserProfile addFriend(@PathVariable long id) {
        return us.addFriend(id); }

    @DeleteMapping("/friend/{id}")
    public UserProfile deleteFriend(@PathVariable long id) {
        return us.deleteFriend(id); }


}

