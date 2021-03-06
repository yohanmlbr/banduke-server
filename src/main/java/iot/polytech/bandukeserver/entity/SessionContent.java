package iot.polytech.bandukeserver.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.LinkedList;
import java.util.List;

@Data
@Embeddable
@JsonPropertyOrder({"gpsData", "accData", "gyrData", "calcData"})
public class SessionContent {
    @Column(nullable = false, columnDefinition = "json")
    private List<GpsData> gpsData;
    @Column(nullable = false, columnDefinition = "json")
    private List<AccData> accData;
    @Column(nullable = false, columnDefinition = "json")
    private List<GyrData> gyrData;
    @Column(nullable = false, columnDefinition = "json")
    private List<CalculatedData> calcData;

    public SessionContent() {
        this.gpsData = new LinkedList<>();
        this.accData = new LinkedList<>();
        this.gyrData = new LinkedList<>();
        this.calcData = new LinkedList<>();
    }

    public void addGpsData(GpsData toAdd) {
        this.gpsData.add(toAdd);
    }

    public void addAccData(AccData toAdd) {
        this.accData.add(toAdd);
    }

    public void addGyrData(GyrData toAdd) {
        this.gyrData.add(toAdd);
    }

    public void addCalcData(CalculatedData toAdd) {
        this.calcData.add(toAdd);
    }
}
