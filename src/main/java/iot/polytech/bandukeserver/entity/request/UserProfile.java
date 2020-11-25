package iot.polytech.bandukeserver.entity.request;

import lombok.Data;

@Data
public class UserProfile {

    private long id;
    private String username;
    private String firstname;
    private String lastname;
    private boolean activated;
}
