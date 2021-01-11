package iot.polytech.bandukeserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;



@Data
@Entity
@Table(name = "session", schema = "banduke", catalog = "")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT")
    private long id;

    @Basic
    @Column(name = "userid", nullable = false, columnDefinition = "BIGINT")
    private long userId;

    @Basic
    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(50)")
    private String name;

    @Column(name = "starttime", nullable = false, columnDefinition = "DATETIME")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Column(name = "endtime", nullable = false, columnDefinition = "DATETIME")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @Basic
    @Column(name = "duration", nullable = false, columnDefinition = "BIGINT")
    private long duration;

    @Basic
    @Column(name = "content", nullable = false, columnDefinition = "json")
    @JsonRawValue
    private SessionContent content;
}
