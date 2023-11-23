package org.example;

import org.example.serial_service.Serial;
import org.example.serial_service.SerialService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MyRunnable implements Runnable {
    private final int option;
    private final SerialService serialService;

    public MyRunnable(Integer option, SerialService serialService){
        this.option = option;
        this.serialService = serialService;
    }

    public void run(){
//        System.out.print(" 1 - Select\n 2 - Insert\n 3 - Update\n 4 - Delete\n 5 - Exit\n");
        System.out.printf("Your option: %d \n", option);
        switch (option) {
            case 1:
                synchronized (serialService) {
                    List<org.example.serial_service.Serial> serials = serialService.getSerialWebServicePort().getSerial();
                    System.out.println("All fields");
                    for (Serial serial : serials) {
                        System.out.println(serial.getId() + " Title: " + serial.getTitle() + ", Character: " + serial.getCharacter()
                                + ", Episodes: " + serial.getEpisodes() + ", Seasons: " + serial.getSeasons()
                                + ", Year: " + serial.getYear());
                    }
                    System.out.println("\nTotal serials: " + serials.size());
                }
                break;
            case 2:
//                        System.out.print("Add title: ");
//                        String title = scanString.nextLine();
//                        System.out.print("Add character separated by comma: ");
//                        String character = scanString.nextLine();
//                        System.out.print("Add number of seasons: ");
//                        int seasons = in.nextInt();
//                        System.out.print("Add number of episodes: ");
//                        int episodes = in.nextInt();
//                        System.out.print("Add preview date (ex. 16.11.2004): ");
//                        String year = scanString.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                Date date = null;
                try {
                    date = dateFormat.parse("16.11.2004");
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(dateFormat.format(date));
                synchronized (serialService) {
                    String response = serialService.getSerialWebServicePort().insertSerial("The 100", "Lexa", 4, 4, date);
                    System.out.println("The row insert, choose 1 to show table");
                    System.out.println("Id: " + response);
                }
                break;
            case 3:
//                        System.out.print("Which row update, enter id: ");
//                        int id = in.nextInt();
//                        System.out.print("Update title? (press Enter to skip)");
//                        String newTitle = scanString.nextLine();
//                        System.out.print("Update character? (press Enter to skip)");
//                        String newCharacter = scanString.nextLine();
//                        System.out.print("Update number of seasons? (press 0 to skip)");
//                        int newSeasons = in.nextInt();
//                        System.out.print("Update number of episodes? (press 0 to skip)");
//                        int newEpisodes = in.nextInt();
//                        System.out.print("Update preview date (ex. 16.11.2004): ");
                String newYear = "16.11.2004";//scanString.nextLine();
                //                    System.out.print(newYear);
                SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd.MM.yyyy");
                Date date1 = null;
                try {
                    date1 = (newYear != null && !newYear.trim().isEmpty()) ? dateFormat1.parse(newYear) : new Date(0);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                synchronized (serialService) {
                    String updateResponse = serialService.getSerialWebServicePort().
                            updateSerial(2, "", "", 0, 0, date1);
                    System.out.println("The row update, choose 1 to show table");
                    System.out.println("Response: Update " + updateResponse);
                }
                break;
            case 4:
                System.out.print("Which row delete, enter id: ");
                int deleteId = 5;
                synchronized (serialService) {
                    Integer deleteResponse = serialService.getSerialWebServicePort().
                            deleteSerial(deleteId);
                    System.out.println("Response: Delete " + deleteResponse);
                }
                break;
            //            case 5:
            //                break;
            default:
                break;
        }
    }
}