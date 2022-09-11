package Part2.api;

import Part2.Barrier.Barrier;

public interface Moveable {

    boolean run(Barrier barrier);

    boolean jump(Barrier barrier);

}
