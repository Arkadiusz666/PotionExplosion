package components;

/**
 * Created by AKrzos on 2016-08-23.
 */
public enum Color {
    RED,
    BLUE,
    BLACK,
    YELLOW;

    @Override
    public String toString() {
        if (this.equals(RED)) return "RED   ";
        if (this.equals(BLACK)) return "BLACK ";
        if (this.equals(BLUE)) return "BLUE  ";
        return "YELLOW";
    }


}
