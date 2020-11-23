package iot.polytech.bandukeserver.entity.request;

import lombok.Data;

@Data
public class SignUpUser {

    private String username;
    private String password;
    private String firstname;
    private String lastname;
}