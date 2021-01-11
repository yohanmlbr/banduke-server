package iot.polytech.bandukeserver.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
@JsonPropertyOrder({"gpsData", "accData", "gyrData"})
public class SessionContent {
    private List<GpsData> gpsData;
    private List<AccData> accData;
    private List<GyrData> gyrData;

    public SessionContent() {
        this.gpsData = new LinkedList<>();
        this.accData = new LinkedList<>();
        this.gyrData = new LinkedList<>();
    }

    public SessionContent(List<GpsData> gpsData, List<AccData> accData, List<GyrData> gyrData) {
        this.gpsData = gpsData;
        this.accData = accData;
        this.gyrData = gyrData;
    }

    public List<GpsData> getGpsData() {
        return gpsData;
    }

    @JsonAnySetter
    public void setGpsData(List<GpsData> gpsData) {
        this.gpsData = gpsData;
    }

    @JsonAnySetter
    public void addGpsData(GpsData toAdd) {
        this.gpsData.add(toAdd);
    }

    public List<AccData> getAccData() {
        return accData;
    }

    @JsonAnySetter
    public void setAccData(List<AccData> accData) {
        this.accData = accData;
    }

    @JsonAnySetter
    public void addAccData(AccData toAdd) {
        this.accData.add(toAdd);
    }

    public List<GyrData> getGyrData() {
        return gyrData;
    }

    @JsonAnySetter
    public void setGyrData(List<GyrData> gyrData) {
        this.gyrData = gyrData;
    }

    @JsonAnySetter
    public void addGyrData(GyrData toAdd) {
        this.gyrData.add(toAdd);
    }
}
