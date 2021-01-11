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

    @Basic
    @Column(name = "starttime", nullable = false, columnDefinition = "DATE")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @Basic
    @Column(name = "endtime", nullable = false, columnDefinition = "DATE")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    @Basic
    @Column(name = "duration", nullable = false, columnDefinition = "BIGINT")
    private long duration;

    @Basic
    @Column(name = "content", nullable = false, columnDefinition = "json")
    @JsonRawValue
    private SessionContent content;
}
