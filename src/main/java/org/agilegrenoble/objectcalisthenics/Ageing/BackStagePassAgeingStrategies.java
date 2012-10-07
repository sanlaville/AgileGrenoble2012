package org.agilegrenoble.objectcalisthenics.Ageing;

import java.util.NavigableMap;
import java.util.TreeMap;

import org.agilegrenoble.objectcalisthenics.Ageing.IncreaseStrategy.IncreaseByOne;
import org.agilegrenoble.objectcalisthenics.Ageing.IncreaseStrategy.IncreaseByThree;
import org.agilegrenoble.objectcalisthenics.Ageing.IncreaseStrategy.IncreaseByTwo;
import org.agilegrenoble.objectcalisthenics.Ageing.IncreaseStrategy.ResetToZero;

public class BackStagePassAgeingStrategies {
    private NavigableMap<Integer, IncreaseStrategy> strategies;

    public BackStagePassAgeingStrategies() {
        strategies = new TreeMap<Integer, IncreaseStrategy>() {{
            put(Integer.MIN_VALUE, new ResetToZero());
            put(0, new IncreaseByThree());
            put(5, new IncreaseByTwo());
            put(10, new IncreaseByOne());
        }};

    }

    public IncreaseStrategy getFor(int daysBefore) {
        return strategies.lowerEntry(daysBefore).getValue();
    }

}