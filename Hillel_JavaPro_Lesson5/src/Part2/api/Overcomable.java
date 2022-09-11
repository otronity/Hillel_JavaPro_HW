package Part2.api;

import Part2.Member.Member;

public interface Overcomable {

    default boolean overcome(Member member) {
        System.out.println("Проходження перешкоди");
        return true;
    }
}
