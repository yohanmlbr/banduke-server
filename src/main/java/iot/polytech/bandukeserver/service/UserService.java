package iot.polytech.bandukeserver.service;

import iot.polytech.bandukeserver.entity.User;
import iot.polytech.bandukeserver.entity.request.SignUpUserRequest;
import iot.polytech.bandukeserver.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void signUpUser(SignUpUserRequest request){
        User user = new User();
        user.setUsername(request.getEmail());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        userRepository.save(user);
    }
}