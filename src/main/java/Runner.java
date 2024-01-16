import Service.*;
import controller.ComputerController;
import controller.PhoneController;
import database.InmemoryComputerDatabase;
import entities.Computer;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        run();


    }
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        ComputerController computerController = new ComputerController();
        PhoneController phoneController = new PhoneController();

        System.out.println("dil seciniz " +
                "1. for English" +
                "2. for Turkish");
        String deger = null;
        try {
            deger = scanner.next();
        } catch (Exception e) {
            run();
        }
        if (deger.equals("1")) {
            ComputerService computerService =new EnglishComputerService();
            PhoneService phoneService = new EngilshPhoneService();
            System.out.println("1 for Computer" +
                    "\n 2 for Phone");
            String option = null;
            try {
                option = scanner.next();
            } catch (Exception e) {
                run();
            }
            switch (option){
                case "1":
                    computerController.calistir(computerService);
                    break;
                case "2":
                    phoneController.calistir(phoneService);
                    break;
                default: run();
            }

        } else if (deger.equals("2")) {
            ComputerService computerService = new TurkceComputerService();
            PhoneService phoneService = new TurkcePhoneService();

            System.out.println("1 bilgisyar icin" +
                    "\n 2 telefon icin");
            String option = null;
            try {
                option = scanner.next();
            } catch (Exception e) {
                run();
            }
            switch (option){
                case "1":
                    computerController.calistir(computerService);
                    break;
                case "2":
                    phoneController.calistir(phoneService);
                    break;
                default: run();
            }

        } else {
            run();

        }

    }

}
