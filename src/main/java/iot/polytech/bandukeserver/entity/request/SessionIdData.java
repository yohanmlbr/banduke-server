package iot.polytech.bandukeserver.entity.request;

import iot.polytech.bandukeserver.entity.Session;
import lombok.Data;

@Data
public class SessionIdData {
    private long id;
    private long userId;
    private String name;

    public SessionIdData(Session s){
        id=s.getId();
        userId=s.getUserId();
        name=s.getName();
    }
}
