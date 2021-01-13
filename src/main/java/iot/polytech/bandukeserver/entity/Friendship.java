package iot.polytech.bandukeserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "friendship", schema = "banduke")
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT")
    private long id;

    @Basic
    @Column(name = "followerid", nullable = false, columnDefinition = "BIGINT")
    private long followerid;

    @Basic
    @Column(name = "followedid", nullable = false, columnDefinition = "BIGINT")
    private long followedid;

    @Column(name = "followingdate", nullable = false, columnDefinition = "DATETIME")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date followingdate;
}