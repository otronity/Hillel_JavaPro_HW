package part2.barrier;

import part2.member.Member;

public class Track extends Barrier {

    private int length;
    final static String nameBarrier = "беговая дорожка";

    public Track(int length) {
        this.length = length;
    }

    @Override
    public boolean overcome(Member member) {
        return member.run(this);
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
