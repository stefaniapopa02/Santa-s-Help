package main;

import java.util.List;

public class Input {
    private Integer numberOfYears;
    private Double santaBudget;
    private InitialData initialData;
    private List<AnnualChange> annualChanges;

    /**
     *
     */
    public Input() {
    }

    /**
     * @param numberOfYear
     * @param santaBudget
     * @param initialData
     * @param annualChanges
     */
    public Input(final int numberOfYear, final Double santaBudget, final InitialData initialData,
                 final List<AnnualChange> annualChanges) {
        this.numberOfYears = numberOfYear;
        this.santaBudget = santaBudget;
        this.initialData = initialData;
        this.annualChanges = annualChanges;
    }

    /**
     * @return
     */
    public int getNumberOfYears() {
        return numberOfYears;
    }

    /**
     * @param numberOfYears
     */
    public void setNumberOfYears(final int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    /**
     * @return
     */
    public Double getSantaBudget() {
        return santaBudget;
    }

    /**
     * @param santaBudget
     */
    public void setSantaBudget(final Double santaBudget) {
        this.santaBudget = santaBudget;
    }

    /**
     * @return
     */
    public InitialData getInitialData() {
        return initialData;
    }

    /**
     * @param initialData
     */
    public void setInitialData(final InitialData initialData) {
        this.initialData = initialData;
    }

    /**
     * @return
     */
    public List<AnnualChange> getAnnualChanges() {
        return annualChanges;
    }

    /**
     * @param annualChanges
     */
    public void setAnnualChanges(final List<AnnualChange> annualChanges) {
        this.annualChanges = annualChanges;
    }
}




