package iot.polytech.bandukeserver.entity.request;

import lombok.Data;

@Data
public class UserDetails {
    private long id;
    private String username;
    private String firstname;
    private String lastname;
    private String motorcycle;
    private int nbsessions;
}