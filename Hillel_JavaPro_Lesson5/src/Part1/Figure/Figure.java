package Part1.Figure;

import Part1.api.Squareable;

public class Figure implements Squareable {

    private double border;

    @Override
    public double square() {
        return 0;
    }

    public void setBorder(double border) {
        this.border = border;
    }

    public double getBorder() {
        return border;
    }
}
