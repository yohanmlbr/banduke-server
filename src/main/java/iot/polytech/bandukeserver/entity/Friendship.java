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
    @Column(name = "id", nullable = false)
    private long id;

    @Basic
    @Column(name = "followerid", nullable = false)
    private long followerid;

    @Basic
    @Column(name = "followedid", nullable = false)
    private long followedid;

    @Basic
    @Column(name = "followingdate", nullable = false)
    private Date followingdate;
}