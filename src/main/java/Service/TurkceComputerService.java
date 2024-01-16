package Service;

import database.InmemoryComputerDatabase;
import entities.Computer;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TurkceComputerService implements ComputerService{
    Scanner scanner = new Scanner(System.in);
    InmemoryComputerDatabase inmemoryComputerDatabase;

    public TurkceComputerService() {
        inmemoryComputerDatabase  = new InmemoryComputerDatabase();

    }

    @Override
    public void save() {
        System.out.println("Lutfen eklemek istediginiz bilgisayarin adini giriniz");
        String bilgisayarAd= scanner.next();
        System.out.println("Lutfen eklemek istedginiz bilgisayarin rengini giriniz");
        String bilgisayarRenk= scanner.next();
        System.out.println("Lutfen eklemek istediginiz bilgisayarin aciklamasini giriniz");
        String bilgisayarAciklama= scanner.next();
        System.out.println("Lutfen eklemek istedginiz bilgisayarin ekran kartini giriniz");
        String bilgisayarEkranKarti= scanner.next();
        System.out.println("Lutfen eklemek istediginiz bilgisayarin fiyatini giriniz");
        double bilgisayarFiyat= scanner.nextDouble();

        Computer computer = new Computer();
            computer.setName(bilgisayarAd);
            computer.setColor(bilgisayarRenk);
            computer.setComment(bilgisayarAciklama);
            computer.setDisplayCard(bilgisayarEkranKarti);
            computer.setPrice(bilgisayarFiyat);

        }
    @Override
    public void update() {
        System.out.println("degistirmek istedigniz bilgisayar id'si.");
        long id = scanner.nextLong();
        Computer computer = new Computer();
        for (Computer each :
                inmemoryComputerDatabase.computerList()) {
            if (each.getId()==id) {
                computer = each;
            }
            String computerName = null;
            String computerColor = null;
            String computerDisplayCard = null;
            double computerWeight = 0;
            double computerPrice = 0;
            try {
                System.out.println("Marka");
                computerName = scanner.next();
                System.out.println("Renk");
                computerColor = scanner.next();
                System.out.println("Ekran karti");
                computerDisplayCard = scanner.next();
                System.out.println("Ağırlık");
                computerWeight = scanner.nextDouble();
                System.out.println("Fiyati");
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
        System.out.println("Silmek istedigniz bilgisayar id'sini giriniz.");
        long id = 0;
        try {
            id = scanner.nextLong();
        } catch (Exception e) {
            remove();
        }
        Computer computer = new Computer();

        for (Computer each :
                inmemoryComputerDatabase.computerList()) {
            if (each.getId()==id) {
                computer = each;
            }
        }
        inmemoryComputerDatabase.computerList().remove(computer);
    }

@Override
    public void option() {
        System.out.println("islem seciniz" +
                "\n1.bilgisaylari filtrele" +
                "\n2.Bilgisayar ekle" +
                "\n3.Bilgisayar guncelle" +
                "\n4.Bilgisayar sil");

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
            default:option();

        }
    }
    @Override
    public void newOption() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("anamenu icin 1" +
                "\n cikmak icin 2");
        String secenek = null;
        try {
            secenek = scanner1.next();
        } catch (Exception e) {
            newOption();
        }
        if (secenek.equals("1")){
            option();
        }else {
            System.out.println("islem bitti");
        }
    }

    public void computerFilter () {
        System.out.println("1.Tum bilgisayarlari gor");
        System.out.println("2. Fiyata gore sirala");
        System.out.println("3. indirim oranina gore sirala ");
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
                System.out.println("Suan hizmet veremiyoruz.");
            default:
                computerFilter();


        }


    }
    }