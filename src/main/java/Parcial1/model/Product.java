package Parcial1.model;

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int price;

    private String name;




    public int getPrice() {
        return price;
    }

    public void setPrice(int id) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
