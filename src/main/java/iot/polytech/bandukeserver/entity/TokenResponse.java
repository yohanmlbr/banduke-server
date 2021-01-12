package iot.polytech.bandukeserver.entity;

import iot.polytech.bandukeserver.entity.request.UserIdData;
import lombok.Data;

import java.io.Serializable;

@Data
public class TokenResponse implements Serializable {
    private String token;
    private UserIdData userProfile;

    public TokenResponse(String t, UserIdData up){
        token=t;
        userProfile=up;
    }
}

