package database;

import entities.Computer;

import java.util.ArrayList;
import java.util.List;

public class InmemoryComputerDatabase {

    Computer computer = new Computer();
    List < Computer > computerList;

    public InmemoryComputerDatabase() {
        computerList=new ArrayList<>();
        Computer computer = new Computer();
        computer.setName("MacOs");
        computer.setColor("Silver");
        computer.setPrice(12345.99);
        computer.setDisplayCard("256");
        computerList.add(computer);
        Computer computer2= new Computer();
        computer2.setName("Hp");
        computer2.setDisplayCard("128");
        computer2.setColor("siyah");
        computerList.add(computer2);
    }
    public List<Computer>computerList(){
        return computerList;
    }
    public void computerSaveList(Computer computer){
        computerList.add(computer);
    }
    public void remove(Computer computer) {
        computerList.remove(computer);
    }
    public void update() {  }
}


