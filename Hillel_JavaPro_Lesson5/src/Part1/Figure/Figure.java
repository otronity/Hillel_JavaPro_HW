package part1.figure;

import part1.api.Squareable;

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
