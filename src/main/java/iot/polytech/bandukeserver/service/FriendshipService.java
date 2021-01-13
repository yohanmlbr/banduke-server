package iot.polytech.bandukeserver.service;

import iot.polytech.bandukeserver.entity.Friendship;
import iot.polytech.bandukeserver.entity.request.ApiResponse;
import iot.polytech.bandukeserver.entity.request.UserIdData;
import iot.polytech.bandukeserver.repository.FriendshipRepository;
import iot.polytech.bandukeserver.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FriendshipService {

    private FriendshipRepository fr;

    public List<Friendship> getFriendshipsByUserId(long id){
        return fr.findByFollowerid(id);
    }

    public ApiResponse addFriend(long followerid, long followedid){
        Friendship f = new Friendship();
        f.setFollowerid(followerid);
        f.setFollowedid(followedid);
        f.setFollowingdate(new Date(System.currentTimeMillis()));
        fr.save(f);
        return new ApiResponse(true,"Friend "+followedid+" added succesfully","");
    }

    public ApiResponse deleteFriend(long followerid, long followedid){
        Friendship f = fr.findByFolloweridAndFollowedid(followerid, followedid);
        fr.delete(f);
        return new ApiResponse(true,"Friend "+followedid+" deleted succesfully","");
    }

    public ApiResponse isFriend(long id, long friend){
        Friendship f = fr.findByFolloweridAndFollowedid(id, friend);
        if(f!=null){
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            return new ApiResponse(true,"User "+friend+" is a friend",df.format(f.getFollowingdate()));
        }
        else{
            return new ApiResponse(false,"User "+friend+" is not a friend","");
        }
    }
}