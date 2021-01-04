package iot.polytech.bandukeserver.repository;

import iot.polytech.bandukeserver.entity.Friendship;
import iot.polytech.bandukeserver.entity.User;
import iot.polytech.bandukeserver.entity.compositepk.FriendshipPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendshipRepository extends JpaRepository<Friendship, FriendshipPK> {

    List<Friendship> findByIdfollower(User follower);

    List<Friendship> findByIdfollowed(User followed);

    List<Friendship> findByIdfollowerAAndIdfollowed(User follower, User followed);



}