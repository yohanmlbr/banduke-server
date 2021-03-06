package iot.polytech.bandukeserver.repository;

import iot.polytech.bandukeserver.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> getByUserId(long id);
    Session getById(long id);
}