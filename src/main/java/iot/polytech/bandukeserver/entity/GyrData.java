package iot.polytech.bandukeserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.Date;

@Data
@JsonPropertyOrder({"gyrTime", "gyrX", "gyrY", "gyrZ"})
public class GyrData {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date gyrTime;
    private double gyrX;
    private double gyrY;
    private double gyrZ;
}
