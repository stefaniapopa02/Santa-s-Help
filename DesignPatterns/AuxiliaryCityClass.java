package DesignPatterns;

import enums.Cities;

public class AuxiliaryCityClass {
    private Cities city;
    private Double averageCityScore;

    /**
     * @param city
     * @param averageCityScore
     */
    public AuxiliaryCityClass(final Cities city, final Double averageCityScore) {
        this.city = city;
        this.averageCityScore = averageCityScore;
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
    public Double getAverageCityScore() {
        return averageCityScore;
    }

    /**
     * @param averageCityScore
     */
    public void setAverageCityScore(final Double averageCityScore) {
        this.averageCityScore = averageCityScore;
    }
}
