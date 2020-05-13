package lesson5.backPack;

public class Junk {

    private final int weight;
    private final int price;
    private final String name;

    public Junk(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Junk{" +
                "weight=" + weight +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}' + '\n';
    }
}
