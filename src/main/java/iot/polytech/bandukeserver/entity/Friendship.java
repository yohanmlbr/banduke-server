package iot.polytech.bandukeserver.entity;

import iot.polytech.bandukeserver.entity.compositepk.FriendshipPK;
import lombok.Data;
import javax.persistence.*;
import java.sql.Date;


@Data
@Entity
@IdClass(FriendshipPK.class)
@Table(name = "friendship", schema = "banduke")
public class Friendship {

    @Id
    @ManyToMany
    @JoinColumn(name = "idfollower", referencedColumnName = "id", nullable = false)
    private User idfollower;

    @Id
    @ManyToMany
    @JoinColumn(name = "idfollower", referencedColumnName = "id", nullable = false)
    private long idfollowed;

    @Basic
    @Column(name = "followingdate", nullable = false)
    private Date followingdate;

}