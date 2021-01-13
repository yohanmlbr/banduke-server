package iot.polytech.bandukeserver.service;

import iot.polytech.bandukeserver.entity.Session;
import iot.polytech.bandukeserver.entity.SessionContent;
import iot.polytech.bandukeserver.entity.request.ApiResponse;
import iot.polytech.bandukeserver.entity.request.SessionIdData;
import iot.polytech.bandukeserver.repository.SessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SessionService {

    private SessionRepository sr;

    public List<SessionIdData> getSessions(){
        List<Session> sessions = sr.findAll();
        List<SessionIdData> ssid = new ArrayList<>();
        for(Session s : sessions){
            ssid.add(new SessionIdData(s));
        }
        return ssid;
    }

    public Session addSession(Session s){
        return sr.save(s);
    }

    public List<SessionIdData> getSessionsByUserId(long id){
        List<Session> sessions = sr.getByUserId(id);
        List<SessionIdData> ssid = new ArrayList<>();
        for(Session s : sessions){
            ssid.add(new SessionIdData(s));
        }
        return ssid;
    }

    public Session getSessionById(long id){
        return sr.getById(id);
    }

    public SessionContent getSessionContentById(long id){
        return sr.getById(id).getContent();
    }

    public ApiResponse renameSessionById(long id, String newName){
        Session s = sr.getById(id);
        s.setName(newName);
        sr.save(s);
        return new ApiResponse(true,"Session "+id+" renamed succesfully",newName);
    }


}