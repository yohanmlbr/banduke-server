package iot.polytech.bandukeserver.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user", schema = "banduke")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT")
    private long id;

    @Basic
    @Column(name = "username",unique = true, nullable = false, length = 100, columnDefinition = "VARCHAR(100)")
    private String username;

    @Basic
    @Column(name = "password", nullable = false, length = 200, columnDefinition = "VARCHAR(200)")
    private String password;

    @Basic
    @Column(name = "firstname", nullable = false, length = 30, columnDefinition = "VARCHAR(30)")
    private String firstname;

    @Basic
    @Column(name = "lastname", nullable = false, length = 30, columnDefinition = "VARCHAR(30)")
    private String lastname;

    @Basic
    @Column(name = "activated", nullable = false, columnDefinition = "BOOLEAN")
    private boolean activated=true;

}
