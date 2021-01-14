package iot.polytech.bandukeserver.utils;

import iot.polytech.bandukeserver.entity.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class SessionParser {

    /*Sample session data :

        Starttime#2021-01-13T21:41:44.000+0000
     year, mon, DoW, hour, min, sec        lat1, lon2, alt3, spd4          X5, Y6, Z7       X8, Y9, Z10    dist11, den+12, den-13
        ~~~~~~~~~~~~TIME~~~~~~~~~~~~ ---------------GPS----------------- ______ACCL_____ ======GYRO====== +++++CALC+++++
        2021-01-13T21:42:01.859+0000,0.0000000000,0.0000000000,0.00,0.00,-3.17,2.36,3.20,-0.04,-0.05,0.92,0.00,0.00,0.00
        2021-01-13T21:42:02.040+0000,0.0000000000,0.0000000000,0.00,0.00,-3.15,2.40,3.22,-0.03,-0.05,0.92,0.00,0.00,0.00
        2021-01-13T21:42:02.220+0000,0.0000000000,0.0000000000,0.00,0.00,-3.19,2.31,3.22,-0.04,-0.05,0.92,0.00,0.00,0.00
        2021-01-13T21:42:02.400+0000,0.0000000000,0.0000000000,0.00,0.00,-3.21,2.34,3.24,-0.04,-0.05,0.92,0.00,0.00,0.00
        2021-01-13T21:42:02.580+0000,0.0000000000,0.0000000000,0.00,0.00,-3.20,2.29,3.24,-0.04,-0.05,0.92,0.00,0.00,0.00
        2021-01-13T21:42:02.763+0000,0.0000000000,0.0000000000,0.00,0.00,-3.18,2.29,3.27,-0.04,-0.05,0.92,0.00,0.00,0.00*/

    public static Session parseSession(String rawData, long userId) throws ParseException {
        Session s = new Session();
        s.setUserId(userId);

        SessionContent sc = new SessionContent();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

        String line = "";
        Calendar cal = Calendar.getInstance();

        Scanner input = new Scanner(rawData);
        if (input.hasNextLine()) {
            String firstLine = input.nextLine();
            String[] firstLineSplitted = firstLine.split("#");
            Date start = sf.parse(firstLineSplitted[1]);
            s.setStartTime(start);
            System.out.println(start);
        }
        while (input.hasNextLine()) {
            line = input.nextLine();
            String[] data = line.split(",");

            cal.setTime(sf.parse(data[0]));

            GpsData gpsData = new GpsData();
            gpsData.setGpsTime(cal.getTime());
            gpsData.setGpsLat(Double.valueOf(data[1]));
            gpsData.setGpsLon(Double.valueOf(data[2]));
            gpsData.setGpsAlt(Double.valueOf(data[3]));
            gpsData.setGpsSpeed(Double.valueOf(data[4]));
            sc.addGpsData(gpsData);

            AccData accData = new AccData();
            accData.setAccTime(cal.getTime());
            accData.setAccX(Double.valueOf(data[5]));
            accData.setAccY(Double.valueOf(data[6]));
            accData.setAccZ(Double.valueOf(data[7]));
            sc.addAccData(accData);

            GyrData gyrData = new GyrData();
            gyrData.setGyrTime(cal.getTime());
            gyrData.setGyrX(Double.valueOf(data[8]));
            gyrData.setGyrY(Double.valueOf(data[9]));
            gyrData.setGyrZ(Double.valueOf(data[10]));
            sc.addGyrData(gyrData);

            CalculatedData calcData = new CalculatedData();
            calcData.setCalcTime(cal.getTime());
            calcData.setDistTot(Double.valueOf(data[11]));
            calcData.setDenivPos(Double.valueOf(data[12]));
            calcData.setDenivNeg(Double.valueOf(data[13]));
            sc.addCalcData(calcData);

        }
        input.close();

        s.setContent(sc);
        s.setEndTime(cal.getTime());
        s.setDuration(ChronoUnit.MINUTES.between(s.getStartTime().toInstant(), s.getEndTime().toInstant()));
        s.setName(sf.format(cal.getTime()));


        return s;
    }
}
