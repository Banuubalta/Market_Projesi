package controller;

import Service.ComputerService;

import java.util.Scanner;

public class ComputerController { Scanner scanner = new Scanner(System.in);
    public void calistir(ComputerService computerService){
        try {
            computerService.option();
        } catch (Exception e) {
            calistir(computerService);
        }



    }

}


