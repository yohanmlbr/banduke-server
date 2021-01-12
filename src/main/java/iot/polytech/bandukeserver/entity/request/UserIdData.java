package iot.polytech.bandukeserver.entity.request;

import lombok.Data;

@Data
public class UserIdData {

    private long id;
    private String username;
    private String firstname;
    private String lastname;
}
