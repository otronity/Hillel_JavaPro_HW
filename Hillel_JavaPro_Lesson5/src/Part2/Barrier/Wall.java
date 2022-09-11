package Part2.Barrier;

import Part2.Member.Member;

public class Wall extends Barrier {

    private int length;
    final String nameBarrier = "стена";

    public Wall(int hight) {
        this.length = hight;
    }

    @Override
    public boolean overcome(Member member) {
        return member.jump(this);
    }

    @Override
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
