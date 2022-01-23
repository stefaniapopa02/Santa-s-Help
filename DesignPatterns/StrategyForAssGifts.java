package DesignPatterns;

import main.Child;
import main.Gift;

import java.util.List;

public interface StrategyForAssGifts {

    /**
     * @param children
     * @param santaGifts
     * @return
     */
    List<Child> assGifts(List<Child> children, List<Gift> santaGifts);

    /**
     * @param child
     * @param santaGifts
     * @return
     */
    List<Gift> findTheGift(Child child, List<Gift> santaGifts);
}
