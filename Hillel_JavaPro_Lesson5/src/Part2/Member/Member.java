package part2.member;

import part2.barrier.Barrier;
import part2.api.Moveable;

public class Member implements Moveable {

    String name;
    int height;
    int length;

    public Member(String name, int height, int length) {
        this.name = name;
        this.height = height;
        this.length = length;
    }

    @Override
    public boolean run(Barrier barrier) {
        boolean result = true;
        if (barrier.getLength() <= length) {
            System.out.println("Участник " + name + " прошел препятствие " + barrier.getNameBarrier() +
                    " на дистанции " + barrier.getLength());
        }
        if (barrier.getLength() > length) {
            System.out.println("Участник " + name + " НЕ прошел препятствие " + barrier.getNameBarrier() +
                    " на дистанции " + barrier.getLength());
            result = false;
        }
        return result;
    }

    @Override
    public boolean jump(Barrier barrier) {
        boolean result = true;
        if (barrier.getLength() <= height) {
            System.out.println("Участник " + name + " прошел препятствие " + barrier.getNameBarrier() +
                    " высотой " + barrier.getLength());
        }
        if (barrier.getLength() > height) {
            System.out.println("Участник " + name + " НЕ прошел препятствие " + barrier.getNameBarrier() +
                    " высотой " + barrier.getLength());
            result = false;
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
