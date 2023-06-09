package main;

import enums.Category;
import enums.Cities;

import java.util.List;

public class OutputChild {
    private int id;
    private String lastName;
    private String firstName;
    private Cities city;
    private Integer age;

    private List<Category> giftsPreferences;
    private Double averageScore;
    private List<Double> niceScoreHistory;
    private Double assignedBudget;
    private List<OutputGift> receivedGifts;

    /**
     * @param id
     * @param lastName
     * @param firstName
     * @param city
     * @param age
     * @param giftPreferences
     * @param averageScore
     * @param niceScoreHistory
     * @param assignedBudget
     * @param receivedGifts
     */
    public OutputChild(final int id, final String lastName, final String firstName,
                       final Cities city, final int age, final List<Category> giftPreferences,
                       final double averageScore, final List<Double> niceScoreHistory,
                       final double assignedBudget, final List<OutputGift> receivedGifts) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.age = age;
        this.giftsPreferences = giftPreferences;
        this.averageScore = averageScore;
        this.niceScoreHistory = niceScoreHistory;
        this.assignedBudget = assignedBudget;
        this.receivedGifts = receivedGifts;
    }

    /**
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(final int id) {
        this.id = id;
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
    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    /**
     * @param giftsPreferences
     */
    public void setGiftsPreferences(final List<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
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
    public double getAssignedBudget() {
        return assignedBudget;
    }

    /**
     * @param assignedBudget
     */
    public void setAssignedBudget(final double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    /**
     * @return
     */
    public List<OutputGift> getReceivedGifts() {
        return receivedGifts;
    }

    /**
     * @param receivedGifts
     */
    public void setReceivedGifts(final List<OutputGift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }
}
