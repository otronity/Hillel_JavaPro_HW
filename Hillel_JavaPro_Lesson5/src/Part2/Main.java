package Part2;

import Part2.Barrier.Barrier;
import Part2.Barrier.Track;
import Part2.Barrier.Wall;
import Part2.Member.Cat;
import Part2.Member.Human;
import Part2.Member.Member;
import Part2.Member.Robot;

public class Main {

    public static void main(String[] args) {

        Member[] members = {
                new Human("Human", 5, 12),
                new Robot("Robot", 3, 20),
                new Cat("Cat", 5, 10)
        };

        Barrier[] barrier = {
                new Track(10),
                new Wall(5),
                new Track(5)
        };


        for (Member m : members) {
            for (Barrier b : barrier) {
                if (!b.overcome(m)) {
                    break;
                }
            }
        }

    }
}
