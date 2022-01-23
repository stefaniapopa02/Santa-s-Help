package DesignPatterns;

import enums.Category;
import main.Child;
import main.Gift;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StrategyId implements StrategyForAssGifts {

    private final double maxPrice = 100000;

    /**
     * @param children
     * @param santaGifts
     * @return
     */
    @Override
    public List<Child> assGifts(final List<Child> children, final List<Gift> santaGifts) {
        Collections.sort(children);
        for (Child iterChild : children) {
            iterChild.setReceivedGifts(findTheGift(iterChild, santaGifts));
        }

        return children;
    }

    /**
     * @param child
     * @param santaGifts
     * @return
     */
    @Override
    public List<Gift> findTheGift(final Child child, final List<Gift> santaGifts) {
        List<Gift> gifts = new ArrayList<>();

        double budget = child.getBudget();

        for (Category cat : child.getGiftsPreferences()) {
            Gift theCheapest = new Gift();
            Double cheapest = maxPrice;
            for (Gift gift : santaGifts) {
                if (gift.getCategory().equals(cat)) {
                    if (gift.getPrice() < cheapest && gift.getQuantity() > 0) {
                        cheapest = gift.getPrice();
                        theCheapest = gift;
                    }
                }
            }
            if (cheapest != maxPrice) {
                if (budget >= theCheapest.getPrice()) {
                    budget -= theCheapest.getPrice();
                    int quantity = theCheapest.getQuantity();
                    theCheapest.setQuantity(quantity - 1);
                    gifts.add(theCheapest);
                }
            }
        }
        return gifts;
    }
}
