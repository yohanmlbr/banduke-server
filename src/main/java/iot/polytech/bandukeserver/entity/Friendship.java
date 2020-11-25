package iot.polytech.bandukeserver.entity;

import lombok.Data;
import javax.persistence.*;
import java.sql.Date;


@Data
@Entity
@Table(name = "friendship", schema = "banduke", catalog = "")
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfollower", nullable = false)
    private long idfollower;

    @Basic
    @Column(name = "idfollowed", nullable = false)
    private long idfollowed;

    @Basic
    @Column(name = "followingdate", nullable = false)
    private Date followingdate;

}