package iot.polytech.bandukeserver.controller;

import iot.polytech.bandukeserver.config.JwtTokenUtil;
import iot.polytech.bandukeserver.entity.TokenResponse;
import iot.polytech.bandukeserver.entity.request.LogInUser;
import iot.polytech.bandukeserver.entity.request.SignUpUser;
import iot.polytech.bandukeserver.entity.request.UserIdData;
import iot.polytech.bandukeserver.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;
    private UserService us;


    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LogInUser liu){
        try {
            System.out.println("User tries to login : "+liu.getUsername()+" "+liu.getPassword());
            UserDetails userDetails= appelAuthentication(liu.getUsername(), liu.getPassword());
            final String token = jwtTokenUtil.generateToken(userDetails);
            UserIdData up=us.getUserIdDataByUsername(liu.getUsername());
            return ResponseEntity.ok(new TokenResponse(token,up));
        } catch (Exception e) {
            return ResponseEntity.ok(new TokenResponse("",null));
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpUser suu){
            us.signUpUser(suu);
            LogInUser liu = new LogInUser(suu);
        try {
            return createAuthenticationToken(liu);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    private UserDetails appelAuthentication(String email, String password) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            return (UserDetails) authentication.getPrincipal();
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
