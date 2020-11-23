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
    public UserProfil getUserProfil(@PathVariable long id){
        return us.getUserProfil(id);
    }

    @PostMapping("/{id}")
    public UserProfil updateUserProfil(@PathVariable long id,
                                       @RequestBody UserProfil newProfile){
        return us.updateUserProfile(id, newProfile);
    }

    @DeleteMapping("/{id}")
    public UserProfil deactivateUserProfil(@PathVariable long id){
        return us.deactivateUserProfile(id);
    }


    @GetMapping("/list")
    public List<UserProfil> getUserProfil(@RequestParam(defaultValue = "") String username){
        return us.getUsersProfil(username);
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

