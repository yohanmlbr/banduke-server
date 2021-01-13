package iot.polytech.bandukeserver.service;

import iot.polytech.bandukeserver.entity.Friendship;
import iot.polytech.bandukeserver.entity.request.UserIdData;
import iot.polytech.bandukeserver.repository.FriendshipRepository;
import iot.polytech.bandukeserver.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FriendshipService {

    private FriendshipRepository fr;

    public List<Friendship> getFriendshipsByUserId(long id){
        return fr.findByFollowerid(id);
    }

    public boolean addFriend(long followerid, long followedid){
        Friendship f = new Friendship();
        f.setFollowerid(followerid);
        f.setFollowedid(followedid);
        f.setFollowingdate(new Date(System.currentTimeMillis()));
        fr.save(f);
        return true;
    }

    public boolean deleteFriend(long followerid, long followedid){
        Friendship f = fr.findByFolloweridAndFollowedid(followerid, followedid);
        fr.delete(f);
        return true;
    }

    public boolean isFriend(long id, long friend){
        Friendship f = fr.findByFolloweridAndFollowedid(id, friend);
        return f != null;
    }
}