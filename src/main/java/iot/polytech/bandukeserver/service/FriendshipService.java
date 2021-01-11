package iot.polytech.bandukeserver.service;

import iot.polytech.bandukeserver.entity.Friendship;
import iot.polytech.bandukeserver.entity.Session;
import iot.polytech.bandukeserver.entity.request.UserProfile;
import iot.polytech.bandukeserver.repository.FriendshipRepository;
import iot.polytech.bandukeserver.repository.SessionRepository;
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
    private UserRepository ur;

    public List<UserProfile> getFriendsByUserId(long id){
        List<UserProfile> friends = new ArrayList<>();

        UserService us=new UserService(ur);

        List<Friendship> friendships = fr.findByFollowerid(id);
        for(Friendship f : friendships){
            friends.add(us.getUserProfile(f.getFollowedid()));
        }
        return friends;
    }

    public Friendship addFriend(long followerid, long followedid){
        Friendship f = new Friendship();
        f.setFollowerid(followerid);
        f.setFollowedid(followedid);
        f.setFollowingdate(new Date(System.currentTimeMillis()));
        return fr.save(f);
    }

    public void deleteFriend(long followerid, long followedid){
        Friendship f = fr.findByFolloweridAndFollowedid(followerid, followedid);
        fr.delete(f);
    }
}