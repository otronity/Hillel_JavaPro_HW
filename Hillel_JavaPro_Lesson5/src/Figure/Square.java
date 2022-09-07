package Figure;

public class Square extends Figure{

    private double border;

    public Square(double border) {
        this.border = border;
    }

    @Override
    public double square() {
        double s = border * border;
        System.out.println("Площа квадрата  = " + s);
        return s;
    }

    @Override
    public double getBorder() {
        return border;
    }

    @Override
    public void setBorder(double border) {
        this.border = border;
    }
}

