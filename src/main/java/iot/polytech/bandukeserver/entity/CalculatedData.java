package iot.polytech.bandukeserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.persistence.Embeddable;
import java.util.Date;

@Data
@Embeddable
@JsonPropertyOrder({"calcTime", "distTot", "denivPos", "denivNeg"})
public class CalculatedData {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date calcTime;
    private double distTot;
    private double denivPos;
    private double denivNeg;
}
