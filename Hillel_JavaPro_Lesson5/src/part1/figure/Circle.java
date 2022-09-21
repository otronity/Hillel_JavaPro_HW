package part1.figure;

public class Circle extends Figure {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double square() {
        double s = Math.PI * Math.pow(radius, 2);
        System.out.println("Площа круга  = " + s);
        return s;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
