package org.example;

import org.example.serial_service.Serial;
import org.example.serial_service.SerialService;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import java.util.Scanner;

//mvn clean jaxws:wsimport

public class Main {
    public static void main(String[] args) throws MalformedURLException, ParseException {
        URL url = new URL("http://localhost:8081/SerialService?wsdl");
        SerialService serialService = new SerialService(url);
        Scanner in = new Scanner(System.in);
        Scanner scanString = new Scanner(System.in);
        while (true) {
            System.out.print(" 1 - Select\n 2 - Insert\n 3 - Update\n 4 - Delete\n 5 - Exit\n");
            int option = in.nextInt();
            System.out.printf("Your option: %d \n", option);
            switch (option) {
                case 1:
                    List<Serial> serials = serialService.getSerialWebServicePort().getSerial();
                    System.out.println("All fields");
                    for (Serial serial : serials) {
                        System.out.println(serial.getId() + " Title: " + serial.getTitle() + ", Character: " + serial.getCharacter()
                                + ", Episodes: " +  serial.getEpisodes() + ", Seasons: " + serial.getSeasons()
                                + ", Year: " + serial.getYear());
                    }
//                    System.out.println("\nTitle where seasons more when 4");
//                    for (Serial serial : serials) {
//                        if (serial.getSeasons() >= 4) {
//                            System.out.println(serial.getTitle() + ", Seasons: " + serial.getSeasons());
//                        }
//                    }
//                    System.out.println("\nCharacter where episodes less when 40");
//                    for (Serial serial : serials) {
//                        if (serial.getEpisodes() <= 40) {
//                            System.out.println("Character: " + serial.getCharacter() + ", Episodes: " +  serial.getEpisodes());
//                        }
//                    }
//                    System.out.println("\nTitle and character where episodes more 50 and seasons less 6");
//                    for (Serial serial : serials) {
//                        if (serial.getEpisodes() >= 50 && serial.getSeasons() <= 6) {
//                            System.out.println("Title: " + serial.getTitle() + ", Character: " + serial.getCharacter());
//                        }
//                    }
//                    System.out.println("\nTitle and character where year equals 2011");
//                    for (Serial serial : serials) {
//                        Date year = serial.getYear();
//                        String date = new SimpleDateFormat("dd-MM-yyyy").format(year);
//                        String y = date.substring(date.length() - 4);
//                        if (y.equals("2011")) {
//                            System.out.println("Title: " + serial.getTitle() + ", Character: " + serial.getCharacter()
//                                    + ", Year: " + date);
//                        }
//                    }
                    System.out.println("\nTotal serials: " + serials.size());
                    break;
                case 2:
                    System.out.print("Add title: ");
                    String title = scanString.nextLine();
                    System.out.print("Add character separated by comma: ");
                    String character = scanString.nextLine();
                    System.out.print("Add number of seasons: ");
                    int seasons = in.nextInt();
                    System.out.print("Add number of episodes: ");
                    int episodes = in.nextInt();
                    System.out.print("Add preview date (ex. 16.11.2004): ");
                    String year = scanString.nextLine();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                    try {
                        dateFormat.setLenient(false);
                        Date date = dateFormat.parse(year);
                        String response = serialService.getSerialWebServicePort().insertSerial(title,character,seasons, episodes,date);
                        System.out.println("The row insert, choose 1 to show table");
                        System.out.println("Id: " + response);
                    } catch (Throwable str) {
                        System.out.println(str.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Which row update, enter id: ");
                    int id = in.nextInt();
                    System.out.print("Update title? (press Enter to skip)");
                    String newTitle = scanString.nextLine();
                    System.out.print("Update character? (press Enter to skip)");
                    String newCharacter = scanString.nextLine();
                    System.out.print("Update number of seasons? (press 0 to skip)");
                    int newSeasons = in.nextInt();
                    System.out.print("Update number of episodes? (press 0 to skip)");
                    int newEpisodes = in.nextInt();
                    System.out.print("Update preview date (ex. 16.11.2004): ");
                    String newYear = scanString.nextLine();
//                    System.out.print(newYear);
                    SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd.MM.yyyy");
                    dateFormat1.setLenient(false);
                    Date date1 = (newYear != null && !newYear.trim().isEmpty()) ? dateFormat1.parse(newYear) : new Date(0);
                    try {
                        String updateResponse = serialService.getSerialWebServicePort().
                            updateSerial(id,newTitle,newCharacter,newSeasons, newEpisodes, date1);
                        System.out.println("The row update, choose 1 to show table");
                        System.out.println("Response: Update " + updateResponse);
                    } catch (Throwable str) {
                        System.out.println(str.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Which row delete, enter id: ");
                    int deleteId = in.nextInt();
                    try {
                        Integer deleteResponse = serialService.getSerialWebServicePort().
                                deleteSerial(deleteId);
                        System.out.println("Response: Delete " + deleteResponse);
                        break;
                    } catch (Throwable str) {
                        System.out.println(str.getMessage());
                    }
                    break;
                default:
                    break;
            }
            if (option == 5) break;
        }
        scanString.close();
        in.close();
    }
}