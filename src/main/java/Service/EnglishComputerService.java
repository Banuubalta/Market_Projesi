package Service;

import database.InmemoryComputerDatabase;
import entities.Computer;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnglishComputerService implements ComputerService {
    Scanner scanner = new Scanner(System.in);
    InmemoryComputerDatabase inmemoryComputerDatabase;

    public EnglishComputerService() {
        inmemoryComputerDatabase = new InmemoryComputerDatabase();

    }

    @Override
    public void save() {
        System.out.println("Please enter the name of the phone you want to add");
        String bilgisayarAd = scanner.next();
        System.out.println("Please enter the color of the computer you want to add");
        String bilgisayarRenk = scanner.next();
        System.out.println("Please enter the description of the computer you want to add.");
        String bilgisayarAciklama = scanner.next();
        System.out.println("Please enter the video card of the computer you want to add.");
        String bilgisayarEkranKarti = scanner.next();
        System.out.println("Please enter the price of the computer you want to add.");
        double bilgisayarFiyat = scanner.nextDouble();

        Computer computer = new Computer();
        computer.setName(bilgisayarAd);
        computer.setColor(bilgisayarRenk);
        computer.setComment(bilgisayarAciklama);
        computer.setDisplayCard(bilgisayarEkranKarti);
        computer.setPrice(bilgisayarFiyat);

    }

    @Override
    public void update() {
        System.out.println("Please enter the ID of the computer you want to change.");
        long id = scanner.nextLong();
        Computer computer = new Computer();
        for (Computer each :
                inmemoryComputerDatabase.computerList()) {
            if (each.getId() == id) {
                computer = each;
            }
            String computerName = null;
            String computerColor = null;
            String computerDisplayCard = null;
            double computerWeight = 0;
            double computerPrice = 0;
            try {
                System.out.println("Brand");
                computerName = scanner.next();
                System.out.println("Color");
                computerColor = scanner.next();
                System.out.println("DisplayCard");
                computerDisplayCard = scanner.next();
                System.out.println("Weight");
                computerWeight = scanner.nextDouble();
                System.out.println("Price");
                computerPrice = scanner.nextDouble();
            } catch (Exception e) {
                update();
            }


            computer.setName(computerName);
            computer.setColor(computerColor);
            computer.setPrice(computerPrice);
            computer.setDisplayCard(computerDisplayCard);
            computer.setWeight(computerWeight);

        }

    }

    @Override
    public void remove() {
        System.out.println("Enter the computer ID you want to delete.");
        long id = 0;
        try {
            id = scanner.nextLong();
        } catch (Exception e) {
            remove();
        }
        Computer computer = new Computer();

        for (Computer each :
                inmemoryComputerDatabase.computerList()) {
            if (each.getId() == id) {
                computer = each;
            }
        }
        inmemoryComputerDatabase.computerList().remove(computer);
    }

    @Override
    public void option() {
        System.out.println("choose action" +
                "\n1.filter computers" +
                "\n2.Add computer" +
                "\n3.Update computer" +
                "\n4.delete computer");

        String option = null;
        try {
            option = scanner.next();
        } catch (Exception e) {
            option();
        }
        switch (option) {
            case "1":
                computerFilter();
                break;
            case "2":
                save();
                break;
            case "3":
                update();
                break;
            case "4":
                remove();
            default:
                option();

        }
    }

    @Override
    public void newOption() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("for anamenu 1" +
                "\n to go out 2");
        String secenek = null;
        try {
            secenek = scanner1.next();
        } catch (Exception e) {
            newOption();
        }
        if (secenek.equals("1")) {
            option();
        } else {
            System.out.println("transaction is over");
        }
    }

    public void computerFilter() {
        System.out.println("1.All my computers");
        System.out.println("2. Sort by price");
        System.out.println("3. sort by discount rate ");
        String deger = null;
        try {
            deger = scanner.next();
        } catch (Exception e) {
            computerFilter();
        }

        switch (deger) {
            case "1":
                System.out.println(inmemoryComputerDatabase.computerList());
                break;
            case "2":
                List<Computer> computerList = inmemoryComputerDatabase.computerList().stream().sorted(Comparator.comparingDouble(Computer::getPrice)).collect(Collectors.toList());
                for (Computer each :
                        computerList) {
                    System.out.println(each);
                }
                break;
            case "3":
                System.out.println("We cannot provide service at the moment.");
            default:
                computerFilter();


        }


    }
}