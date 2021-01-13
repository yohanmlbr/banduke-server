package iot.polytech.bandukeserver.entity.request;

import lombok.Data;

@Data
public class EditUser {
    private long id;
    private String firstname;
    private String lastname;
    private String motorcycle;
}