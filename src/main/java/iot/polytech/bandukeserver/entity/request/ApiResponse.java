package iot.polytech.bandukeserver.entity.request;

import lombok.Data;

@Data
public class ApiResponse {
    private boolean success;
    private String message;
    private String element;

    public ApiResponse(boolean s, String m, String e){
        success=s;
        message=m;
        element=e;
    }
}
