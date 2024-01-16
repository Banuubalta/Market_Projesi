package entities;

public class Phone extends ElectronikProduct {
    private String camPIxel ="belirtilmemis";

    public Phone() {
    }

    public Phone(String camPIxel) {
        this.camPIxel = camPIxel;
    }

    public Phone(String color, String camPIxel) {
        super(color);
        this.camPIxel = camPIxel;
    }

    public Phone(long id, String name, double price, String comment, String color, String camPIxel) {
        super(id, name, price, comment, color);
        this.camPIxel = camPIxel;
    }

    public String getCamPIxel() {
        return camPIxel;
    }

    public void setCamPIxel(String camPIxel) {
        this.camPIxel = camPIxel;
    }

    @Override
    public String toString() {
        return super.toString() +
                "camPIxel='" + camPIxel + '\'' +
                '}';
    }
}



