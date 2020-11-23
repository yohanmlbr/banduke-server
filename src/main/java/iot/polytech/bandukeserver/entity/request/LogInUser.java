package iot.polytech.bandukeserver.entity.request;

import lombok.Data;

@Data
public class LogInUser {

    private String username;
    private String password;

    public LogInUser(SignUpUser suu){
        this.username=suu.getUsername();
        this.password=suu.getPassword();
    }

}
