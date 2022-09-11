package Part2.Member;

import Part2.Barrier.Barrier;

public class Human extends Member {

    public Human(String name, int height, int length) {
        super(name, height, length);
    }

    @Override
    public boolean run(Barrier barrier) {
        return super.run(barrier);
    }

    @Override
    public boolean jump(Barrier barrier) {
        return super.jump(barrier);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }
}
