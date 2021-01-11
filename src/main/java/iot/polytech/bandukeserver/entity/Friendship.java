package iot.polytech.bandukeserver.entity;

import lombok.Data;
import javax.persistence.*;
import java.sql.Date;


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

    @Basic
    @Column(name = "followingdate", nullable = false, columnDefinition = "DATE")
    private Date followingdate;
}