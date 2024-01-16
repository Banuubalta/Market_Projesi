package entities;

public class ElectronikProduct extends Product{

    private String color;
    private double weight;

    public ElectronikProduct() {
    }

    public ElectronikProduct(String color) {
        this.color = color;
    }

    public ElectronikProduct(long id, String name, double price, String comment, String color) {
        super(id, name, price, comment);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "ElectronikProduct{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}


