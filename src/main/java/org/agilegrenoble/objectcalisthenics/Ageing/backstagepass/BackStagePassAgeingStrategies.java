package org.agilegrenoble.objectcalisthenics.Ageing.backstagepass;

import java.util.NavigableMap;
import java.util.TreeMap;

import org.agilegrenoble.objectcalisthenics.Ageing.backstagepass.IncreaseStrategy.IncreaseByOne;
import org.agilegrenoble.objectcalisthenics.Ageing.backstagepass.IncreaseStrategy.IncreaseByThree;
import org.agilegrenoble.objectcalisthenics.Ageing.backstagepass.IncreaseStrategy.IncreaseByTwo;
import org.agilegrenoble.objectcalisthenics.Ageing.backstagepass.IncreaseStrategy.ResetToZero;

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