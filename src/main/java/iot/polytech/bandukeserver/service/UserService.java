package iot.polytech.bandukeserver.service;

import iot.polytech.bandukeserver.entity.Friendship;
import iot.polytech.bandukeserver.entity.User;
import iot.polytech.bandukeserver.entity.request.EditUser;
import iot.polytech.bandukeserver.entity.request.SignUpUser;
import iot.polytech.bandukeserver.entity.request.UserDetails;
import iot.polytech.bandukeserver.entity.request.UserIdData;
import iot.polytech.bandukeserver.exception.RessourceException;
import iot.polytech.bandukeserver.repository.SessionRepository;
import iot.polytech.bandukeserver.repository.UserRepository;
import iot.polytech.bandukeserver.config.JwtTokenUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository ur;
    private SessionService ss;
    private FriendshipService fs;

    public UserIdData getUserIdData(long id){
        User u = ur.findById(id).orElseThrow(
                () -> new RessourceException("User", "id", id)
        );
        return  convertUserToUID(u);
    }

    public List<UserIdData> getUsersIdData(String name){
        List<UserIdData> upl = new ArrayList<>();
        if(name.equals("")){
            List<User> users = ur.findAll();
            for(User u : users) {
                upl.add(convertUserToUID(u));
            }
        }
        else{
            List<User> users = ur.findByUsernameContains(name);
            for(User u : users) {
                upl.add(convertUserToUID(u));
            }
        }
        return upl;
    }

    public User signUpUser(SignUpUser request){
        User user = new User();
        user.setUsername(request.getUsername());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setMotorcycle(request.getMotorcycle());
        return ur.save(user);
    }

    private UserIdData convertUserToUID(User u){
        UserIdData uid = new UserIdData();
        uid.setId(u.getId());
        uid.setUsername(u.getUsername());
        uid.setFirstname(u.getFirstname());
        return uid;
    }

    public EditUser updateUserDetails(EditUser newProfile) {
        User u = ur.findById(newProfile.getId()).orElseThrow(
                () -> new RessourceException("User", "id", newProfile.getId())
        );
        u.setFirstname(newProfile.getFirstname());
        u.setLastname(newProfile.getLastname());
        u.setMotorcycle(newProfile.getMotorcycle());
        ur.save(u);
        return  newProfile;
    }

    public UserIdData deactivateUserProfile(String token) {
        JwtTokenUtil tu=new JwtTokenUtil();
        String userString=tu.getUsernameFromToken(token);
        User u= ur.findByUsername(userString);
        u.setActivated(false);
        return convertUserToUID(ur.save(u));
    }

    public UserIdData getUserIdDataByUsername(String username){
        User u= ur.findByUsername(username);
        if(u!=null)
            return convertUserToUID(u);
        else
            return null;
    }

    public UserDetails getUserDetailsById(long id){
        UserDetails ud = new UserDetails();
        User u = ur.findById(id).orElseThrow(
                () -> new RessourceException("User", "id", id)
        );
        ud.setId(u.getId());
        ud.setUsername(u.getUsername());
        ud.setLastname((u.getLastname()));
        ud.setFirstname(u.getFirstname());
        ud.setMotorcycle(u.getMotorcycle());
        int nbSessions=ss.getSessionsByUserId(u.getId()).size();
        ud.setNbsessions(nbSessions);
        int nbFriends=getFriendsUsersByUserId(u.getId()).size();
        ud.setNbfriends(nbFriends);
        return ud;
    }

    public List<UserIdData> getFriendsUsersByUserId(long id){
        List<UserIdData> friends = new ArrayList<>();
        List<Friendship> friendships = fs.getFriendshipsByUserId(id);
        for(Friendship f : friendships){
            friends.add(getUserIdData(f.getFollowedid()));
        }
        return friends;

    }

}