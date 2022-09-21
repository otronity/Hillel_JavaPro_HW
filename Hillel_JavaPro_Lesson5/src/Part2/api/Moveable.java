package part2.api;

import part2.barrier.Barrier;

public interface Moveable {

    boolean run(Barrier barrier);

    boolean jump(Barrier barrier);

}
