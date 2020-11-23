package iot.polytech.bandukeserver.entity.request;

import lombok.Data;

@Data
public class SignUpUserRequest {

    private String email;
    private String password;
    private String name;
    private String surname;
}