package Service;

import database.InmemoryPhoneDatabase;
import entities.Phone;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TurkcePhoneService implements PhoneService {
    Scanner scanner = new Scanner(System.in);
    InmemoryPhoneDatabase inmemoryDatabase;

    public TurkcePhoneService() {
        inmemoryDatabase = new InmemoryPhoneDatabase();

    }


    @Override
    public void save() {
        System.out.println("Lutfen eklemek istediginiz telefonun adini giriniz");
        String bilgisayarAd = scanner.next();
        System.out.println("Lutfen eklemek istedginiz telefonun rengini giriniz");
        String bilgisayarRenk = scanner.next();
        System.out.println("Lutfen eklemek istediginiz telefonun aciklamasini giriniz");
        String bilgisayarAciklama = scanner.next();
        System.out.println("Lutfen eklemek istedginiz telefonun kamera cozunurlugunu giriniz");
        String kamPiksel = scanner.next();
        System.out.println("Lutfen eklemek istediginiz telefonun fiyatini giriniz");
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
        System.out.println("Lutfen degistirmek istediginiz telefonun id sini giriniz");
        long id = scanner.nextLong();
        Phone phone = new Phone();
        for (Phone each :
                inmemoryDatabase.phoneList()) {
            if (each.getId()==id) {
                phone = each;
            }
            System.out.println("Lutfen telefonun yeni adini giriniz");
            String computerName = scanner.next();
            System.out.println("Lutfen telefonun yeni rengini giriniz");
            String computerColor = scanner.next();
            System.out.println("Lutfen telefonun yeni kamera pikselini giriniz");
            String camPixel = scanner.next();
            System.out.println("Lutfen telefonun fiyatini giriniz");
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
        System.out.println("Silmek istediginiz bilgisayarin idsini giriniz.");
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
        System.out.println("Yapmak isledigniz islemi seciniz" +
                "\n1.telefonlari filtreleyin" +
                "\n2.telefon ekleyin" +
                "\n3.telefonu guncelleyin" +
                "\n4.telefonu silin");

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
        System.out.println("anamenu 1" +
                "\n cikis 2");
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
        System.out.println("Tum telefonlari gormek icin 1'e");
        System.out.println("Fiyata gore telefonlari siralamak icin 2 ye");
        System.out.println("Indirim oranina gore telefonlari siralamak icin 3'e");
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
                System.out.println("bu hizmeti sunamiyoruz suan");
            default:
                computerFilter();


        }

    }

}


