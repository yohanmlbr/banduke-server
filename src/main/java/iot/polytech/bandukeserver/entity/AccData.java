package iot.polytech.bandukeserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.Date;

@Data
@JsonPropertyOrder({"accTime", "accX", "accY", "accZ"})
public class AccData {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date accTime;
    private double accX;
    private double accY;
    private double accZ;
}
