package iot.polytech.bandukeserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class GpsData {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date gpsTime;
    private double gpsLat;
    private double gpsLon;
}
