package Figure;

import Figure.Circle;
import Figure.Figure;
import Figure.Square;
import Figure.Triangle;

public class Main {

    public static void main(String[] args) {
        Figure[] f = {
                new Circle(5.0),
                new Square(5.0),
                new Triangle(5.0, 6.0, 7.0)};

        sumSquare(f);
    }
    
    public static void sumSquare(Figure[] figures){
        double sumS = 0;
        for (Figure f : figures) {
            sumS += f.square();
        }
        System.out.println("Сума площин всіх фігур = " + sumS);
    }
}
