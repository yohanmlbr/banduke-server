package iot.polytech.bandukeserver.entity.request;

import lombok.Data;

@Data
public class SignUpUserRequest {

    private String email;
    private String password;
    private String firstname;
    private String lastname;
}