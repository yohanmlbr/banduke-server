package iot.polytech.bandukeserver.service;

import iot.polytech.bandukeserver.entity.*;
import iot.polytech.bandukeserver.entity.request.ApiResponse;
import iot.polytech.bandukeserver.entity.request.SessionIdData;
import iot.polytech.bandukeserver.entity.request.SessionWoutContent;
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

    public SessionWoutContent getSessionById(long id){
        return new SessionWoutContent(sr.getById(id));
    }

    public SessionContent getSessionContentById(long id){
        return sr.getById(id).getContent();
    }

    public List<GpsData> getSessionContentGpsDataById(long id){
        return sr.getById(id).getContent().getGpsData();
    }

    public List<AccData> getSessionContentAccDataById(long id){
        return sr.getById(id).getContent().getAccData();
    }

    public List<GyrData> getSessionContentGyrDataById(long id){
        return sr.getById(id).getContent().getGyrData();
    }

    public List<CalculatedData> getSessionContentCalcDataById(long id){
        return sr.getById(id).getContent().getCalcData();
    }

    public ApiResponse renameSessionById(long id, String newName){
        Session s = sr.getById(id);
        newName=newName.replaceAll(String.valueOf('"'),"");
        s.setName(newName);
        sr.save(s);
        return new ApiResponse(true,"Session "+id+" renamed succesfully",newName);
    }


}