package DesignPatterns;

public final class ChildrenFactory {
    /**
     *
     */
    private ChildrenFactory() {

    }

    public enum AgeCategory {
        BABY,
        KID,
        TEEN,
        YOUNG_ADULT
    }

    /**
     * @param ageCategory
     * @return
     */
    public static String createChild(final AgeCategory ageCategory) {
        return switch (ageCategory) {
            case BABY -> "Baby";
            case KID -> "Kid";
            case TEEN -> "Teen";
            case YOUNG_ADULT -> "Young Adult";
        };
    }
}
