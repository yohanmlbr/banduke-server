package iot.polytech.bandukeserver.controller;

import iot.polytech.bandukeserver.entity.Session;
import iot.polytech.bandukeserver.entity.SessionContent;
import iot.polytech.bandukeserver.entity.request.ApiResponse;
import iot.polytech.bandukeserver.entity.request.SessionIdData;
import iot.polytech.bandukeserver.service.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/session")
public class SessionController {

    private SessionService ss;

    @GetMapping("/list")
    public List<SessionIdData> getSessions(){
        return ss.getSessions();
    }

    @GetMapping("/list/{id}")
    public List<SessionIdData> getSessionsByUserId(@PathVariable long id){
        return ss.getSessionsByUserId(id);
    }

    @PostMapping("/add")
    public Session addSession(@RequestBody Session s){
        return ss.addSession(s);
    }

    @GetMapping("/{id}")
    public Session getSessionById(@PathVariable long id){
        return ss.getSessionById(id);
    }

    @GetMapping("/{id}/content")
    public SessionContent getSessionContentById(@PathVariable long id){
        return ss.getSessionContentById(id);
    }

    @PutMapping("/{id}/rename")
    public ApiResponse getSessionById(@PathVariable long id, @RequestBody String newName){
        return ss.renameSessionById(id,newName);
    }


}
