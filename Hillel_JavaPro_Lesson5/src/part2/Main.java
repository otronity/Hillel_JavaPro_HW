package part2;

import part2.barrier.Barrier;
import part2.barrier.Track;
import part2.barrier.Wall;
<<<<<<< HEAD:Hillel_JavaPro_Lesson5/src/Part2/Main.java
import part2.member.Human;
import part2.member.Cat;
=======
import part2.member.Cat;
import part2.member.Human;
>>>>>>> 12897fc (rename packages):Hillel_JavaPro_Lesson5/src/part2/Main.java
import part2.member.Member;
import part2.member.Robot;

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
