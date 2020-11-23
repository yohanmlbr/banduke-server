package iot.polytech.bandukeserver.service;

import iot.polytech.bandukeserver.entity.User;
import iot.polytech.bandukeserver.entity.request.SignUpUser;
import iot.polytech.bandukeserver.entity.request.UserProfile;
import iot.polytech.bandukeserver.exception.RessourceException;
import iot.polytech.bandukeserver.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public UserProfile getUserProfile(long id){
        User u = userRepository.findById(id).orElseThrow(
                () -> new RessourceException("User", "id", id)
        );
        return  uToUp(u);
    }

    public List<UserProfile> getUsersProfile(String name){
        List<UserProfile> upl = new ArrayList<>();
        if(name.equals("")){
            for(User u : userRepository.findAll()) {
                upl.add(uToUp(u));
            }
        }
        else{
            for(User u : userRepository.findByUsernameContains(name)) {
                upl.add(uToUp(u));
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
        return userRepository.save(user);
    }

    private UserProfile uToUp(User u){
        UserProfile up = new UserProfile();
        up.setUsername(u.getUsername());
        up.setFirstname(u.getFirstname());
        up.setLastname(u.getLastname());
        return up;
    }

    public UserProfil updateUserProfile(long id, UserProfil newProfile) {
        User u = userRepository.findById(id).orElseThrow(
                () -> new RessourceException("User", "id", id)
        );
        u.setFirstname(newProfile.getFirstname());
        u.setLastname(newProfile.getLastname());
        userRepository.save(u);
        return  uToUp(u);
    }

    public UserProfil deactivateUserProfile(long id) {
        //TODO
        return null;
    }

    public List<UserProfil> getUserFriendsList(long id) {
        //TODO
        return null;
    }

    public UserProfil addFriend(long id) {
        //TODO
        return null;
    }

    public UserProfil deleteFriend(long id) {
        //TODO
        return null;
    }
}