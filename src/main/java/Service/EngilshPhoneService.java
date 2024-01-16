package Service;

import database.InmemoryPhoneDatabase;
import entities.Phone;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EngilshPhoneService implements PhoneService {
    Scanner scanner = new Scanner(System.in);
    InmemoryPhoneDatabase inmemoryDatabase;

    public EngilshPhoneService() {
        inmemoryDatabase = new InmemoryPhoneDatabase();

    }


    @Override
    public void save() {
        System.out.println("Please enter the file name you want to select");
        String bilgisayarAd = scanner.next();
        System.out.println("Please enter the color of the phone you want to add.");
        String bilgisayarRenk = scanner.next();
        System.out.println("Please enter the description you want to add");
        String bilgisayarAciklama = scanner.next();
        System.out.println("Please enter the camera resolution of the phone you want to add.");
        String kamPiksel = scanner.next();
        System.out.println("Please enter the price of the phone you want to add");
        double bilgisayarFiyat = scanner.nextDouble();

        Phone phone = new Phone();
        phone.setName(bilgisayarAd);
        phone.setColor(bilgisayarRenk);
        phone.setComment(bilgisayarAciklama);
        phone.setCamPIxel(kamPiksel);
        phone.setPrice(bilgisayarFiyat);
        phone.setId(phone.getId());

        inmemoryDatabase.phoneList().add(phone);
        System.out.println("success");
    }

    @Override
    public void update() {
        System.out.println("Please enter the ID of the phone you want to change.");
        long id = scanner.nextLong();
        Phone phone = new Phone();
        for (Phone each :
                inmemoryDatabase.phoneList()) {
            if (each.getId()==id) {
                phone = each;
            }
            System.out.println("Please enter the new name of the phone");
            String computerName = scanner.next();
            System.out.println("Please enter the new color of the phone");
            String computerColor = scanner.next();
            System.out.println("Please enter the new camera pixel of the phone");
            String camPixel = scanner.next();
            System.out.println("Please enter the price of the phone");
            double computerPrice = scanner.nextDouble();

            phone.setName(computerName);
            phone.setColor(computerColor);
            phone.setCamPIxel(camPixel);
            phone.setPrice(computerPrice);
            System.out.println("success");
        }


    }

    @Override
    public void remove() {
        System.out.println("Enter the ID of the computer you want to delete.");
        long id = scanner.nextLong();
        Phone phone = new Phone();

        for (Phone each :
                inmemoryDatabase.phoneList()) {
            if (each.getId()==id){
                phone = each;
            }
        }
        inmemoryDatabase.phoneList().remove(phone);
        System.out.println("success");
    }

    @Override
    public void option() {
        System.out.println("Select the action you want to perform" +
                "\n1.filter phones" +
                "\n2.add phone" +
                "\n3.update phone" +
                "\n4.wipe the phone");

        String option = scanner.next();
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
            default:option();

        }
    }

    @Override
    public void newoption() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("main menu 1" +
                "\n " + "exit 2");
        String secenek = null;
        try {
            secenek = scanner1.next();
        } catch (Exception e) {
            newoption();
        }
        if (secenek.equals("1")){
            option();
        }else {
            System.out.println("exit");
        }
    }
    public void computerFilter () {
        System.out.println("To see all phones 1'e");
        System.out.println("To sort phones by price 2 ye");
        System.out.println("To sort phones by discount rate 3'e");
        String deger = scanner.next();

        switch (deger) {
            case "1":
                System.out.println(inmemoryDatabase.phoneList());
                break;
            case "2":

                List<Phone> phoneList = inmemoryDatabase.phoneList().stream().sorted(Comparator.comparingDouble(Phone::getPrice)).collect(Collectors.toList());
                for (Phone each :
                        phoneList) {
                    System.out.println(each);
                }
                break;
            case "3":
                System.out.println("We cannot offer this service at the moment");
            default:
                computerFilter();


        }

    }

}
