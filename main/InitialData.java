package main;

import java.util.List;

public class InitialData {
    private List<Child> children;
    private List<Gift> santaGiftsList;

    /**
     *
     */
    public InitialData() {
    }

    /**
     * @param initialChildren
     * @param initialGifts
     */
    public InitialData(final List<Child> initialChildren, final List<Gift> initialGifts) {
        this.children = initialChildren;
        this.santaGiftsList = initialGifts;
    }

    /**
     * @return
     */
    public List<Child> getChildren() {
        return children;
    }

    /**
     * @param children
     */
    public void setChildren(final List<Child> children) {
        this.children = children;
    }

    /**
     * @return
     */
    public List<Gift> getSantaGiftsList() {
        return santaGiftsList;
    }

    /**
     * @param santaGiftsList
     */
    public void setSantaGiftsList(final List<Gift> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }
}
