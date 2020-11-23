package iot.polytech.bandukeserver.service;

import iot.polytech.bandukeserver.entity.User;
import iot.polytech.bandukeserver.entity.request.SignUpUserRequest;
import iot.polytech.bandukeserver.entity.request.UserProfil;
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

    public UserProfil getUserProfil(long id){
        User u = userRepository.findById(id).orElseThrow(
                () -> new RessourceException("User", "id", id)
        );
        return  uToUp(u);
    }

    public List<UserProfil> getUsersProfil(String name){
        List<UserProfil> upl = new ArrayList<>();
        for(User u : userRepository.findAll()){
            if(name.equals("")){
                upl.add(uToUp(u));
            }
            else if(u.getUsername().contains(name)){
                upl.add(uToUp(u));
            }
        }
        return upl;
    }



    public void signUpUser(SignUpUserRequest request){
        User user = new User();
        user.setUsername(request.getEmail());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        userRepository.save(user);
    }

    private UserProfil uToUp(User u){
        UserProfil up = new UserProfil();
        up.setUsername(u.getUsername());
        up.setFirstname(u.getFirstname());
        up.setLastname(u.getLastname());
        return up;
    }
}