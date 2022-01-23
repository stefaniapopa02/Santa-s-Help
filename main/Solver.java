package main;

import DesignPatterns.StrategyFactory;
import DesignPatterns.StrategyForAssGifts;
import enums.Category;
import enums.CityStrategyEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static enums.ElvesType.BLACK;
import static enums.ElvesType.PINK;
import static enums.ElvesType.YELLOW;


public final class Solver {

    private static Solver instance = null;

    private Solver() {
    }

    /**
     * @return
     */
    public static Solver getInstance() {
        if (instance == null) {
            instance = new Solver();
        }
        return instance;
    }

    private final int teen = 18;
    private final double maxPrice = 100000;
    private final double thirtyBudgetConstant = 30;
    private final double hundredBudgetConstant = 100;

    /**
     * @param category
     * @param santaGifts
     * @return
     */
    public Gift yellowGift(final Category category, final List<Gift> santaGifts) {
        Gift theCheapest = new Gift();
        Double cheapest = maxPrice;
        for (Gift gift : santaGifts) {
            if (gift.getCategory().equals(category)) {
                if (gift.getPrice() < cheapest) {
                    cheapest = gift.getPrice();
                    theCheapest = gift;
                }
            }
        }

        if (cheapest != maxPrice) {
            if (theCheapest.getQuantity() > 0) {
                int quantity = theCheapest.getQuantity();
                theCheapest.setQuantity(quantity - 1);
                return theCheapest;
            }
        }
        return null;
    }


    /**
     * @param list
     * @return
     */
    public List<Double> deepCopyHistory(final List<Double> list) {
        List<Double> dclist = new ArrayList<>();
        for (Double d : list) {
            Double element = d;
            dclist.add(element);
        }
        return dclist;
    }

    /**
     * @param child
     * @return
     */
    public Child setUpForANewChild(final Child child) {
        child.getNiceScoreHistory().add(child.getNiceScore());
        child.setScore();
        return child;
    }

    /**
     * @param oldPreferences
     * @param newPreferences
     * @return
     */
    public List<Category> updatePreferences(final List<Category> oldPreferences,
                                            final List<Category> newPreferences) {
        List<Category> updateGiftPref = new ArrayList<>(newPreferences);

        if (newPreferences.size() > 0) {
            for (Category oldPref : oldPreferences) {
                for (Category newPref : newPreferences) {
                    if (!oldPref.equals(newPref)) {
                        updateGiftPref.add(oldPref);
                    }
                }
            }
        } else {
            updateGiftPref.addAll(oldPreferences);
        }
        Set<Category> set = new LinkedHashSet<>();
        set.addAll(updateGiftPref);
        List<Category> updateGiftList = new ArrayList<>(set);

        return updateGiftList;
    }

    /**
     * @param santaBudget
     * @param children
     * @param gifts
     */
    public void setUpBudgetGifts(final double santaBudget, final List<Child> children,
                                 final List<Gift> gifts) {
        Collections.sort(children);
        double sumAverageScore = 0.0;
        for (Child childIter : children) {
            sumAverageScore += childIter.getAverageScore();
        }
        double budgetUnit = santaBudget / sumAverageScore;
        for (Child iterChild : children) {
            double childBudget = iterChild.getAverageScore() * budgetUnit;
            if (childBudget >= 0) {
                if (iterChild.getElf().equals(BLACK)) {
                    childBudget -= childBudget * thirtyBudgetConstant / hundredBudgetConstant;
                } else if (iterChild.getElf().equals(PINK)) {
                    childBudget += childBudget * thirtyBudgetConstant / hundredBudgetConstant;
                }
                iterChild.setBudget(childBudget);
            }
        }
    }

    /**
     * @param santaBudget
     * @param children
     */
    public void setUpBudget(final double santaBudget, final List<Child> children) {
        Collections.sort(children);
        double sumAverageScore = 0.0;
        for (Child childIter : children) {
            sumAverageScore += childIter.getAverageScore();
        }
        double budgetUnit = santaBudget / sumAverageScore;
        for (Child iterChild : children) {
            double childBudget = iterChild.getAverageScore() * budgetUnit;
            if (childBudget >= 0) {
                if (iterChild.getElf().equals(BLACK)) {
                    childBudget -= childBudget * thirtyBudgetConstant / hundredBudgetConstant;
                } else if (iterChild.getElf().equals(PINK)) {
                    childBudget += childBudget * thirtyBudgetConstant / hundredBudgetConstant;
                }
                iterChild.setBudget(childBudget);
            }
        }
    }


    /**
     * @param input
     * @param annualChange
     * @return
     */
    public ARound anotherRound(final Input input, final AnnualChange annualChange) {
        List<Child> oldChildrenList = input.getInitialData().getChildren();
        List<Child> children = new ArrayList<>();

        for (Child child : oldChildrenList) {
            int a = child.getAge() + 1;
            if (a <= teen) {
                child.setAge(a);
                children.add(child);
                child.setScore();

                for (ChildUpdate childUpdate : annualChange.getChildrenUpdates()) {
                    if (Objects.equals(child.getId(), childUpdate.getId())) {
                        if (childUpdate.getNiceScore() != null) {
                            child.getNiceScoreHistory().add(childUpdate.getNiceScore());
                            child.setScore();
                        }
                        List<Category> oldPref = child.getGiftsPreferences();
                        List<Category> newPref = childUpdate.getGiftsPreferences();
                        List<Category> newPreferences = updatePreferences(oldPref, newPref);
                        child.setGiftsPreferences(newPreferences);

                        child.setElf(childUpdate.getElf());
                    }
                }


            }
        }

        for (Child child : annualChange.getNewChildren()) {
            if (child.getAge() <= teen) {
                children.add(setUpForANewChild(child));
                input.getInitialData().getChildren().add(child);
            }
        }

        for (Gift gift : annualChange.getNewGifts()) {
            input.getInitialData().getSantaGiftsList().add(gift);
        }

        input.setSantaBudget(annualChange.getNewSantaBudget());

        setUpBudget(input.getSantaBudget(), children);

        StrategyFactory strategyFactory = new StrategyFactory(annualChange.getStrategy());
        StrategyForAssGifts strategy = strategyFactory.instanceStrategy(annualChange.getStrategy());
        List<Child> updatedChildren = strategy.assGifts(children,
                input.getInitialData().getSantaGiftsList());

        for (Child iterChild : updatedChildren) {
            if (iterChild.getElf().equals(YELLOW)) {
                if ((iterChild.getReceivedGifts().size() == 0)
                        && (iterChild.getGiftsPreferences().size() != 0)) {
                    Category prefCat = iterChild.getGiftsPreferences().get(0);
                    Gift yellowG = yellowGift(prefCat, input.getInitialData().getSantaGiftsList());
                    if (yellowG != null) {
                        iterChild.getReceivedGifts().add(yellowG);
                    }
                }
            }
        }

        List<OutputChild> outputChildren;
        Collections.sort(children);
        outputChildren = outputChildren(children);

        ARound aRoundList = new ARound();
        aRoundList.setChildren(outputChildren);

        return aRoundList;

    }

    /**
     * @param gifts
     * @return
     */
    public List<OutputGift> outputGifts(final List<Gift> gifts) {
        List<OutputGift> outputGiftList = new ArrayList<>();
        for (Gift iterGift : gifts) {
            OutputGift newG = new OutputGift(iterGift.getProductName(), iterGift.getPrice(),
                    iterGift.getCategory());
            outputGiftList.add(newG);
        }
        return outputGiftList;
    }


    /**
     * @param children
     * @return
     */
    public List<OutputChild> outputChildren(final List<Child> children) {
        List<OutputChild> outputList = new ArrayList<OutputChild>();
        for (Child child : children) {
            OutputChild outputChild = new OutputChild(child.getId(), child.getLastName(),
                    child.getFirstName(), child.getCity(), child.getAge(),
                    child.getGiftsPreferences(), child.getAverageScore(),
                    deepCopyHistory(child.getNiceScoreHistory()), child.getBudget(),
                    outputGifts(child.getReceivedGifts()));
            outputList.add(outputChild);
        }
        return outputList;
    }

    /**
     * @param input
     * @return
     */
    public AllRounds solve(final Input input) {
        AllRounds result = new AllRounds();

        int numberOfYears = input.getNumberOfYears();
        double santaBudget = input.getSantaBudget();
        InitialData initialData = input.getInitialData();

        List<AnnualChange> annualChanges = new ArrayList<>(input.getAnnualChanges());

        List<Child> initialList = initialData.getChildren();
        List<Gift> gifts = initialData.getSantaGiftsList();


        List<Child> childrenn = new ArrayList<>();
        for (Child iter : initialList) {
            if (iter.getAge() <= teen) {
                childrenn.add(setUpForANewChild(iter));
            }
        }
        setUpBudget(santaBudget, childrenn);

        List<Child> children = new ArrayList<>();
        for (Child c : childrenn) {
            Child h = new Child.ChildBuilder(c.getCity(), c.getLastName(),
                    c.getFirstName(), c.getAge(), c.getNiceScoreHistory(),
                    c.getAverageScore(), c.getBudget(), c.getReceivedGifts(),
                    c.getId(),
                    c.getNiceScore(), c.getGiftsPreferences(),
                    c.getElf()).bonusNiceScore(c.getNiceScoreBonus()).build();
            children.add(h);
        }


        StrategyFactory strategyFactory = new StrategyFactory(CityStrategyEnum.ID);
        StrategyForAssGifts strategy = strategyFactory.instanceStrategy(CityStrategyEnum.ID);
        List<Child> updatedChildren = strategy.assGifts(children,
                input.getInitialData().getSantaGiftsList());
        updatedChildren.removeIf(child -> child.getAge() > teen);

        for (Child iterChild : updatedChildren) {
            if (iterChild.getElf().equals(YELLOW)) {
                if ((iterChild.getReceivedGifts().size() == 0)
                        && (iterChild.getGiftsPreferences().size() != 0)) {
                    Category prefCat = iterChild.getGiftsPreferences().get(0);
                    Gift yellowG = yellowGift(prefCat, gifts);
                    if (yellowG != null) {
                        iterChild.getReceivedGifts().add(yellowG);
                    }
                }
            }
        }

        children = updatedChildren;

        Collections.sort(children);

        List<OutputChild> outputChildren;
        outputChildren = outputChildren(children);

        ARound aRoundList = new ARound();
        aRoundList.setChildren(outputChildren);

        List<ARound> allRounds = new ArrayList<>();
        allRounds.add(aRoundList);
        result.setAnnualChildren(allRounds);

        for (int i = 0; i < numberOfYears; i++) {
            ARound round = anotherRound(input, annualChanges.get(i));

            allRounds.add(round);
            result.setAnnualChildren(allRounds);
        }

        return result;

    }

}
