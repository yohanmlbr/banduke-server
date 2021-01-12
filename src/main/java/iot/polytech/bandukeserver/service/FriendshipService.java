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
    private UserService us;

    public List<UserIdData> getFriendsByUserId(long id){
        List<UserIdData> friends = new ArrayList<>();

        List<Friendship> friendships = fr.findByFollowerid(id);
        for(Friendship f : friendships){
            friends.add(us.getUserIdData(f.getFollowedid()));
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