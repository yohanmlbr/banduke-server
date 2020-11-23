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
            List<User> users = userRepository.findAll();
            for(User u : users) {
                upl.add(uToUp(u));
            }
        }
        else{
            List<User> users = userRepository.findByUsernameContains(name);
            for(User u : users) {
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
        up.setId(u.getId());
        up.setUsername(u.getUsername());
        up.setFirstname(u.getFirstname());
        up.setLastname(u.getLastname());
        return up;
    }
}