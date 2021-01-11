package iot.polytech.bandukeserver.repository;

import iot.polytech.bandukeserver.entity.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendshipRepository extends JpaRepository<Friendship, Integer> {

    List<Friendship> findByFollowerid(long follower);

    List<Friendship> findByFollowedid(long followed);

    Friendship findByFolloweridAndFollowedid(long follower, long followed);
}