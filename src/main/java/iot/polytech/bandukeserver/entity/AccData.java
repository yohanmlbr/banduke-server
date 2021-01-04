package iot.polytech.bandukeserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class AccData {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date accTime;
    private double accX;
    private double accY;
    private double accZ;
}
