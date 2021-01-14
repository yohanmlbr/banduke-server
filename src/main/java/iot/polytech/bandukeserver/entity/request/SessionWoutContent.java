package iot.polytech.bandukeserver.entity.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import iot.polytech.bandukeserver.entity.Session;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class SessionWoutContent {
    private long id;
    private long userId;
    private String name;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    private long duration;

    public SessionWoutContent(Session s){
        id=s.getId();
        userId=s.getUserId();
        name=s.getName();
        startTime=s.getStartTime();
        endTime=s.getEndTime();
        duration=s.getDuration();
    }
}
