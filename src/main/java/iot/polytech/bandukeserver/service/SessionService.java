package iot.polytech.bandukeserver.service;

import iot.polytech.bandukeserver.entity.Session;
import iot.polytech.bandukeserver.repository.SessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SessionService {

    private SessionRepository sr;

    public List<Session> getSessions(){
        return sr.findAll();
    }

    public Session addSession(Session s){
        return sr.save(s);
    }

    public List<Session> getSessionsByUserId(long id){
        return sr.getByUserId(id);
    }


}