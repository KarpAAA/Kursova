package Data;

import java.io.Serializable;

public record Car(String mark, String color, double price, double efficiency) implements Serializable {


    public Car(String mark, String color, double price, double efficiency) {
        this.mark = mark;
        this.color = color;
        this.price = price;
        this.efficiency = efficiency;

    }


    public int getId() {
        return this.hashCode();
    }

    @Override
    public int hashCode() {
        return (int) (mark.hashCode() + color.hashCode() + price + efficiency);
    }

    @Override
    public String mark() {
        return mark;
    }

    @Override
    public String color() {
        return color;
    }

    @Override
    public double price() {
        return price;
    }

    @Override
    public double efficiency() {
        return efficiency;
    }
}
