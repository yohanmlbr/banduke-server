package iot.polytech.bandukeserver.controller;

import iot.polytech.bandukeserver.entity.Friendship;
import iot.polytech.bandukeserver.entity.request.UserProfile;
import iot.polytech.bandukeserver.service.FriendshipService;
import iot.polytech.bandukeserver.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/friends")
public class FriendshipController {

    private FriendshipService fs;


    @GetMapping("/{id}")
    public List<UserProfile> getFriendsByUserId(@PathVariable long id) {
        return fs.getFriendsByUserId(id); }

    @PostMapping("/{id}/add/{friend}")
    public Friendship addFriend(@PathVariable long id, @PathVariable long friend) {
        return fs.addFriend(id, friend); }

    @DeleteMapping("/{id}/delete/{friend}")
    public void deleteFriend(@PathVariable long id, @PathVariable long friend) {
        fs.deleteFriend(id, friend);
    }
}

