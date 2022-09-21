package part1;

import part1.figure.Circle;
import part1.figure.Figure;
import part1.figure.Square;
import part1.figure.Triangle;

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
