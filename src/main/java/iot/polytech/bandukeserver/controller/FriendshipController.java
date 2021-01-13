package iot.polytech.bandukeserver.controller;

import iot.polytech.bandukeserver.entity.Friendship;
import iot.polytech.bandukeserver.entity.request.UserIdData;
import iot.polytech.bandukeserver.service.FriendshipService;
import iot.polytech.bandukeserver.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/friends")
public class FriendshipController {

    private FriendshipService fs;
    private UserService us;

    @GetMapping("/{id}")
    public List<UserIdData> getFriendsByUserId(@PathVariable long id) {
        return us.getFriendsUsersByUserId(id); }

    @PostMapping("/{id}/add/{friend}")
    public boolean addFriend(@PathVariable long id, @PathVariable long friend) {
        return fs.addFriend(id, friend); }

    @DeleteMapping("/{id}/delete/{friend}")
    public boolean deleteFriend(@PathVariable long id, @PathVariable long friend) {
        return fs.deleteFriend(id, friend);
    }

    @GetMapping("/{id}/isFriend/{friend}")
    public boolean isFriend(@PathVariable long id, @PathVariable long friend){
        return fs.isFriend(id,friend);
    }
}

