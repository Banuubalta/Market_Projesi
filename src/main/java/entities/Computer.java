package entities;

public class Computer extends ElectronikProduct{

    private String displayCard;

    public Computer() {
    }

    public Computer(String displayCard) {
        this.displayCard = displayCard;
    }

    public Computer(String color, String displayCard) {
        super(color);
        this.displayCard = displayCard;
    }

    public Computer(long id, String name, double price, String comment, String color, String displayCard) {
        super(id, name, price, comment, color);
        this.displayCard = displayCard;
    }

    public String getDisplayCard() {
        return displayCard;
    }

    public void setDisplayCard(String displayCard) {
        this.displayCard = displayCard;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "displayCard='" + displayCard + '\'' +
                '}';
    }
}







