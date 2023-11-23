package org.example;

import org.example.serial_service.Serial;
import org.example.serial_service.SerialService;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

//mvn clean jaxws:wsimport

public class Main_threads {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8081/SerialService?wsdl");
        SerialService serialService = new SerialService(url);

        MyRunnable myRunnable = new MyRunnable(1, serialService);
        MyRunnable myRunnable1 = new MyRunnable(4, serialService);
        new Thread(myRunnable1).start();
        new Thread(myRunnable).start();
    }
}