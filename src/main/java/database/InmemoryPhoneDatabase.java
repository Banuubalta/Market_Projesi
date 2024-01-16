package database;

import entities.Phone;

import java.util.ArrayList;
import java.util.List;

public class InmemoryPhoneDatabase {

    List<Phone> phoneList;

    public InmemoryPhoneDatabase() {
        phoneList= new ArrayList<>();

        Phone phone2 = new Phone( );
        phone2.setId(2);
        phone2.setName("Samsung");
        phone2.setColor("siyah");
        phone2.setComment("iyi kamera");
        phone2.setPrice(12321);
        phone2.setCamPIxel("12");
        phoneList.add(phone2);
        Phone phone3 = new Phone( );
        phone3.setId(3);
        phone3.setName("Samsung");
        phone3.setColor("siyah");
        phone3.setComment("iyi kamera");
        phone3.setPrice(12321);
        phone3.setCamPIxel("12");
        phoneList.add(phone3);

        Phone phone4 = new Phone( );
        phone4.setId(4);
        phone4.setName("I Phone");
        phone4.setColor("Mavi");
        phone4.setComment("iyi kamera");
        phone4.setPrice(1233);
        phone4.setCamPIxel("12");
        phoneList.add(phone4);
        Phone phone5 = new Phone( );
        phone5.setId(5);
        phone5.setName("Xiaomi");
        phone5.setColor("beyaz");
        phone5.setComment(" 2 yil garantili");
        phone5.setPrice(1000);
        phone5.setCamPIxel("10");
        phoneList.add(phone5);


    }
    public List<Phone> phoneList(){
        return phoneList;
    }

}

