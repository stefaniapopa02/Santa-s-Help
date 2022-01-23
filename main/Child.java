package main;

import DesignPatterns.AgeCategory;
import DesignPatterns.ChildrenFactory;
import enums.Category;
import enums.Cities;
import enums.ElvesType;

import java.util.ArrayList;
import java.util.List;

public class Child extends ChildUpdate implements Comparable<Child>, AgeCategory {
    private String lastName;
    private String firstName;
    private Integer age;
    private Cities city;
    private Double niceScoreBonus;

    private List<Double> niceScoreHistory = new ArrayList<Double>();
    private Double averageScore;
    private Double budget;
    private List<Gift> receivedGifts;

    private final int baby = 5;
    private final int kid = 12;
    private final int teen = 18;
    private final int purityScore = 10;
    private final int oneHundred = 100;

    /**
     * @param id
     * @param niceScore
     * @param giftPreferences
     * @param elf
     * @param lastName
     * @param firstName
     * @param age
     * @param city
     * @param niceScoreBonus
     */
    public Child(final int id, final double niceScore, final List<Category> giftPreferences,
                 final ElvesType elf, final String lastName, final String firstName,
                 final int age, final Cities city, final Double niceScoreBonus) {
        super(id, niceScore, giftPreferences, elf);
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.niceScoreBonus = niceScoreBonus;
    }

    /**
     *
     */
    public Child() {
        super();
    }


    /**
     * @param builder
     * @param id
     * @param niceScore
     * @param giftsPreferences
     * @param elf
     */
    private Child(final ChildBuilder builder, final Integer id, final Double niceScore,
                  final List<Category> giftsPreferences, final ElvesType elf) {
        super(id, niceScore, giftsPreferences, elf);
        this.city = builder.city;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.age = builder.age;
        this.niceScoreHistory = builder.niceScoreHistory;
        this.averageScore = builder.averageScore;
        this.budget = builder.budget;
        this.receivedGifts = builder.receivedGifts;
        this.niceScoreBonus = niceScoreBonus;
    }


    /**
     * @param c
     * @return
     */
    @Override
    public int compareTo(final Child c) {
        return this.getId() - c.getId();
    }

    /**
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(final int age) {
        this.age = age;
    }

    /**
     * @return
     */
    public Cities getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(final Cities city) {
        this.city = city;
    }

    /**
     * @return
     */
    public Double getNiceScoreBonus() {
        return niceScoreBonus;
    }

    /**
     * @param niceScoreBonus
     */
    public void setNiceScoreBonus(final Double niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
    }

    /**
     * @return
     */
    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    /**
     * @param niceScoreHistory
     */
    public void setNiceScoreHistory(final List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    /**
     * @return
     */
    public double getAverageScore() {
        return averageScore;
    }

    /**
     * @param averageScore
     */
    public void setAverageScore(final double averageScore) {
        this.averageScore = averageScore;
    }

    /**
     * @return
     */
    public double getBudget() {
        return budget;
    }

    /**
     * @param budget
     */
    public void setBudget(final double budget) {
        this.budget = budget;
    }

    /**
     * @return
     */
    public List<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    /**
     * @param receivedGifts
     */
    public void setReceivedGifts(final List<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }


    /**
     * @return
     */
    public String getAgeCategory() {
        if (age < baby) {
            return ChildrenFactory.createChild(ChildrenFactory.AgeCategory.BABY);
        } else if ((age >= baby) && (age < kid)) {
            return ChildrenFactory.createChild(ChildrenFactory.AgeCategory.KID);
        } else if ((age >= kid) && (age <= teen)) {
            return ChildrenFactory.createChild(ChildrenFactory.AgeCategory.TEEN);
        } else {
            return ChildrenFactory.createChild(ChildrenFactory.AgeCategory.YOUNG_ADULT);
        }
    }

    /**
     * @return
     */
    public double mediaAritmetica() {
        double res = 0.0;
        for (int i = 0; i < niceScoreHistory.size(); i++) {
            res += niceScoreHistory.get(i);
        }
        res /= niceScoreHistory.size();

        return res;
    }

    /**
     * @return
     */
    public double mediaPonderata() {
        double res = 0.0;
        int p;
        int sumP = 0;

        for (int i = 0; i < niceScoreHistory.size(); i++) {
            p = i + 1;
            res += niceScoreHistory.get(i) * p;
            sumP += p;
        }

        res /= sumP;

        return res;
    }

    /**
     *
     */
    public void setScore() {
        if (this.getAgeCategory().equals("Baby")) {
            this.setAverageScore(purityScore);
        } else if (this.getAgeCategory().equals("Kid")) {
            double temp = this.mediaAritmetica();
            temp += temp * niceScoreBonus / oneHundred;
            if (temp > purityScore) {
                this.setAverageScore(purityScore);
            } else {
                this.setAverageScore(temp);
            }
        } else if (this.getAgeCategory().equals("Teen")) {
            double temp = this.mediaPonderata();
            temp += temp * niceScoreBonus / oneHundred;
            if (temp > purityScore) {
                this.setAverageScore(purityScore);
            } else {
                this.setAverageScore(temp);
            }
        }
    }


    public static class ChildBuilder {
        private Cities city;
        private String lastName;
        private String firstName;
        private int age;
        private List<Double> niceScoreHistory;
        private double averageScore;
        private double budget;
        private List<Gift> receivedGifts;
        private Integer id;
        private Double niceScore;
        private List<Category> giftsPreferences;
        private ElvesType elf;


        private Double niceScoreBonus = 0.0;   //optional

        /**
         * @param city
         * @param lastName
         * @param firstName
         * @param age
         * @param niceScoreHistory
         * @param averageScore
         * @param budget
         * @param receivedGifts
         * @param id
         * @param niceScore
         * @param giftsPreferences
         * @param elf
         */
        public ChildBuilder(final Cities city, final String lastName, final String firstName,
                            final int age, final List<Double> niceScoreHistory,
                            final double averageScore, final double budget,
                            final List<Gift> receivedGifts, final Integer id,
                            final Double niceScore, final List<Category> giftsPreferences,
                            final ElvesType elf) {
            this.city = city;
            this.lastName = lastName;
            this.firstName = firstName;
            this.age = age;
            this.niceScoreHistory = niceScoreHistory;
            this.averageScore = averageScore;
            this.budget = budget;
            this.receivedGifts = receivedGifts;
            this.id = id;
            this.niceScore = niceScore;
            this.giftsPreferences = giftsPreferences;
            this.elf = elf;
        }

        /**
         * @param nniceScoreBonus
         * @return
         */
        public ChildBuilder bonusNiceScore(final Double nniceScoreBonus) {
            this.niceScoreBonus = nniceScoreBonus;
            return this;
        }

        /**
         * @return
         */
        public Child build() {
            return new Child(this, id, niceScore, giftsPreferences, elf);
        }
    }

}
