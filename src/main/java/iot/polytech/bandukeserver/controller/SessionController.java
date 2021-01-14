package iot.polytech.bandukeserver.controller;

import iot.polytech.bandukeserver.entity.*;
import iot.polytech.bandukeserver.entity.request.ApiResponse;
import iot.polytech.bandukeserver.entity.request.SessionIdData;
import iot.polytech.bandukeserver.entity.request.SessionWoutContent;
import iot.polytech.bandukeserver.service.SessionService;
import iot.polytech.bandukeserver.utils.SessionParser;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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

    @PostMapping("{userIdStr}/add")
    public ResponseEntity<Session> addSession(@RequestBody String rawData, @PathVariable String userIdStr){
        try {
            long userId = Long.valueOf(userIdStr);
            if (userId <= 0) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(ss.addSession(SessionParser.parseSession(rawData, userId)));
        } catch (ParseException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    public SessionWoutContent getSessionById(@PathVariable long id){
        return ss.getSessionById(id);
    }

    @GetMapping("/{id}/content")
    public SessionContent getSessionContentById(@PathVariable long id){
        return ss.getSessionContentById(id);
    }

    @GetMapping("/{id}/content/gps")
    public List<GpsData> getSessionContentGpsDataById(@PathVariable long id){
        return ss.getSessionContentGpsDataById(id);
    }

    @GetMapping("/{id}/content/acc")
    public List<AccData> getSessionContentAccDataById(@PathVariable long id){
        return ss.getSessionContentAccDataById(id);
    }

    @GetMapping("/{id}/content/gyr")
    public List<GyrData> getSessionContentGyrDataById(@PathVariable long id){
        return ss.getSessionContentGyrDataById(id);
    }

    @GetMapping("/{id}/content/calc")
    public List<CalculatedData> getSessionContentCalcDataById(@PathVariable long id){
        return ss.getSessionContentCalcDataById(id);
    }

    @PutMapping("/{id}/rename")
    public ApiResponse getSessionById(@PathVariable long id, @RequestBody String newName){
        return ss.renameSessionById(id,newName);
    }


}
