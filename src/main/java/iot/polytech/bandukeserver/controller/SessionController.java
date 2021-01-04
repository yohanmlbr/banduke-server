package iot.polytech.bandukeserver.controller;

import iot.polytech.bandukeserver.entity.Session;
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
    public List<Session> getSessions(){
        return ss.getSessions();
    }

    @PostMapping("/add")
    public Session addSession(@RequestBody Session s){
        return ss.addSession(s);
    }
}
