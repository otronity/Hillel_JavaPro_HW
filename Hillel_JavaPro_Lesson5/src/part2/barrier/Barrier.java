package part2.barrier;

import part2.member.Member;
import part2.api.Overcomable;

public class Barrier implements Overcomable {

    private int length;
    private static String nameBarrier = "перешкода";

    @Override
    public boolean overcome(Member member) {
        System.out.println("Проходження перешкоди");
        return true;
    }

    public String getNameBarrier() {
        return nameBarrier;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
