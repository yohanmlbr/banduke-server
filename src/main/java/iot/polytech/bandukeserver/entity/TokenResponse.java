package iot.polytech.bandukeserver.entity;

import iot.polytech.bandukeserver.entity.request.UserProfile;
import lombok.Data;

import java.io.Serializable;

@Data
public class TokenResponse implements Serializable {
    private String token;
    private UserProfile userProfile;

    public TokenResponse(String t, UserProfile up){
        token=t;
        userProfile=up;
    }
}

