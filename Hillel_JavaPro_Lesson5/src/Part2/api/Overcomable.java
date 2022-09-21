package part2.api;

import part2.member.Member;

public interface Overcomable {

    default boolean overcome(Member member) {
        System.out.println("Проходження перешкоди");
        return true;
    }
}
