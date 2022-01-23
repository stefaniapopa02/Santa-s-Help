package main;

import enums.Category;
import enums.ElvesType;

import java.util.List;

public class ChildUpdate {
    private Integer id;
    private Double niceScore;
    private List<Category> giftsPreferences;
    private ElvesType elf;

    /**
     * @param id
     * @param niceScore
     * @param giftsPreferences
     * @param elf
     */
    public ChildUpdate(final Integer id, final Double niceScore,
                       final List<Category> giftsPreferences, final ElvesType elf) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
        this.elf = elf;
    }

    /**
     *
     */
    public ChildUpdate() {
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
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * @return
     */
    public Double getNiceScore() {
        return niceScore;
    }

    /**
     * @param niceScore
     */
    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
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
    public ElvesType getElf() {
        return elf;
    }

    /**
     * @param elf
     */
    public void setElf(final ElvesType elf) {
        this.elf = elf;
    }
}
