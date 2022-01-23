package DesignPatterns;

import enums.CityStrategyEnum;

public class StrategyFactory {
    private CityStrategyEnum strategyEnum;

    /**
     * @param sstrategyEnum
     * @return
     */
    public StrategyForAssGifts instanceStrategy(final CityStrategyEnum sstrategyEnum) {
        return switch (sstrategyEnum) {
            case NICE_SCORE_CITY -> new StrategyNiceScoreCity();
            case ID -> new StrategyId();
            case NICE_SCORE -> new StrategyNiceScore();
        };
    }

    /**
     * @param strategyEnum
     */
    public StrategyFactory(final CityStrategyEnum strategyEnum) {
        this.strategyEnum = strategyEnum;
    }

    /**
     * @return
     */
    public CityStrategyEnum getStrategyEnum() {
        return strategyEnum;
    }

    /**
     * @param strategyEnum
     */
    public void setStrategyEnum(final CityStrategyEnum strategyEnum) {
        this.strategyEnum = strategyEnum;
    }
}
