package com.labs.client;

import com.labs.client.serial_service.Serial;
import com.labs.client.serial_service.SerialService;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

public class Client {
    public void serviceRequest(String accessPoint) throws MalformedURLException {
        URL url = new URL(accessPoint);
        //URL url = new URL("http://localhost:8081/SerialService?wsdl");
        //URL url = new URL("http://localhost:8080/J2EE-19042791983083601946.0-SNAPSHOT/serialService?wsdl");
        SerialService serialService = new SerialService(url);
        List<Serial> serials = serialService.getSerialWebServicePort().getSerial();
        System.out.println("All fields");
        for (Serial serial : serials) {
            System.out.println("Title: " + serial.getTitle() + ", Character: " + serial.getCharacter()
                    + ", Episodes: " +  serial.getEpisodes() + ", Seasons: " + serial.getSeasons()
                    + ", Year: " + serial.getYear());
        }
        System.out.println("\nTitle where seasons more when 4");
        for (Serial serial : serials) {
            if (serial.getSeasons() >= 4) {
                System.out.println(serial.getTitle() + ", Seasons: " + serial.getSeasons());
            }
        }
        System.out.println("\nCharacter where episodes less when 40");
        for (Serial serial : serials) {
            if (serial.getEpisodes() <= 40) {
            System.out.println("Character: " + serial.getCharacter() + ", Episodes: " +  serial.getEpisodes());
            }
        }
        System.out.println("\nTitle and character where episodes more 50 and seasons less 6");
        for (Serial serial : serials) {
            if (serial.getEpisodes() >= 50 && serial.getSeasons() <= 6) {
                System.out.println("Title: " + serial.getTitle() + ", Character: " + serial.getCharacter());
            }
        }
        System.out.println("\nTitle and character where year equals 2011");
        for (Serial serial : serials) {
            Date year = serial.getYear();
            String date = new SimpleDateFormat("dd-MM-yyyy").format(year);
            String y = date.substring(date.length() - 4);
            if (y.equals("2011")) {
                System.out.println("Title: " + serial.getTitle() + ", Character: " + serial.getCharacter()
                        + ", Year: " + date);
            }
        }
        System.out.println("\nTotal serials: " + serials.size());
    }
}