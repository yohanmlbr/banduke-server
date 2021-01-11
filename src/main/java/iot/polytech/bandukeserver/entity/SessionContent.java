package iot.polytech.bandukeserver.entity;

import lombok.Data;

import java.util.List;

@Data
public class SessionContent {
    private List<GpsData> gpsData;
    private List<AccData> accData;
    private List<GyrData> gyrData;
}
