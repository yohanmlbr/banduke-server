package iot.polytech.bandukeserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class GyrData {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date gyrTime;
    private double gyrX;
    private double gyrY;
    private double gyrZ;
}
