package iot.polytech.bandukeserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;



@Data
@Entity
@Table(name = "session", schema = "banduke")
@JsonPropertyOrder({"id", "userid", "name", "starttime", "endtime", "duration", "content", "gpsData", "accData", "gyrData", "calcData"})

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
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Column(name = "endtime", nullable = false, columnDefinition = "DATETIME")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @Basic
    @Column(name = "duration", nullable = false, columnDefinition = "BIGINT")
    private long duration;

    @Embedded
    private SessionContent content;
}
