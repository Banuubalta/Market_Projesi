package controller;

import Service.PhoneService;

public class PhoneController {
    public void calistir(PhoneService phoneService){
        try {
            phoneService.option();
        } catch (Exception e) {
            calistir(phoneService);
        }



    }
}


