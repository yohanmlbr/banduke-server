package iot.polytech.bandukeserver.entity;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.MappedSuperclass;
import java.util.List;

@Data
public class SessionContent {
    private List<GpsData> gpsData;
    private List<AccData> accData;
    private List<GyrData> gyrData;
}
