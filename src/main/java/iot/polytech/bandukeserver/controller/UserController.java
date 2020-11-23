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

    @PostMapping("/{id}")
    public UserProfile updateUserProfile(@PathVariable long id,
                                       @RequestBody UserProfil newProfile){
        return us.updateUserProfile(id, newProfile);
    }

    @DeleteMapping("/{id}")
    public UserProfile deactivateUserProfile(@PathVariable long id){
        return us.deactivateUserProfile(id);
    }


    @GetMapping("/list")
    public List<UserProfile> getUsersProfile(@RequestParam(defaultValue = "") String username){
        return us.getUsersProfile(username);
    }

    @GetMapping("/friends/{id}")
    public List<UserProfil> getUserFriendsList(@PathVariable long id) {
        return us.getUserFriendsList(id); }

    @PostMapping("/friend/{id}")
    public UserProfil addFriend(@PathVariable long id) {
        return us.addFriend(id); }

    @DeleteMapping("/friend/{id}")
    public UserProfil deleteFriend(@PathVariable long id) {
        return us.deleteFriend(id); }


}

