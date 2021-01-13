package iot.polytech.bandukeserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.persistence.Embeddable;
import java.util.Date;

@Data
@Embeddable
@JsonPropertyOrder({"gpsTime", "gpsLat", "gpsLon", "gpsAlt", "gpsSpeed"})
public class GpsData {
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date gpsTime;
    private double gpsLat;
    private double gpsLon;
    private double gpsAlt;
    private double gpsSpeed;
}
