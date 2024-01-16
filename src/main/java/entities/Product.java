package entities;

public class Product {

    private long id;
    private  String name ;
    private  double price ;

    private String comment;

    public Product() {


    }

    public Product(long id, String name, double price, String comment) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", comment='" + comment + '\'' +
                '}';
    }
}