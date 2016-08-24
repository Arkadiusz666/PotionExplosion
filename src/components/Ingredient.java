package components;

/**
 * Created by AKrzos on 2016-08-23.
 */
public class Ingredient {
    private final Color color;

    public Ingredient(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color + " ";
    }
}
