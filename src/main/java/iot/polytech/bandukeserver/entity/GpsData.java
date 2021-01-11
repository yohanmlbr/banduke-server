package iot.polytech.bandukeserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.Date;

@Data
@JsonPropertyOrder({"gpsTime", "gpsLat", "gpsLon"})
public class GpsData {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date gpsTime;
    private double gpsLat;
    private double gpsLon;
}
