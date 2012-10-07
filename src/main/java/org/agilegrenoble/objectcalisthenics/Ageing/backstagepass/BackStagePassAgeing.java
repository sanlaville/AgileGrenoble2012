package org.agilegrenoble.objectcalisthenics.Ageing.backstagepass;

import java.util.NavigableMap;
import java.util.TreeMap;

import org.agilegrenoble.objectcalisthenics.Ageing.Ageing;
import org.agilegrenoble.objectcalisthenics.Ageing.backstagepass.IncreaseStrategy.IncreaseByOne;
import org.agilegrenoble.objectcalisthenics.Ageing.backstagepass.IncreaseStrategy.IncreaseByThree;
import org.agilegrenoble.objectcalisthenics.Ageing.backstagepass.IncreaseStrategy.IncreaseByTwo;
import org.agilegrenoble.objectcalisthenics.Ageing.backstagepass.IncreaseStrategy.ResetToZero;
import org.agilegrenoble.objectcalisthenics.quality.Quality;

public class BackStagePassAgeing extends Ageing {

    private NavigableMap<Integer,IncreaseStrategy> strategies;

    public BackStagePassAgeing(int daysBeforeConcert) {
        super(daysBeforeConcert);
        strategies = new TreeMap<Integer, IncreaseStrategy>() {{
            put(Integer.MIN_VALUE, new ResetToZero());
            put(0, new IncreaseByThree());
            put(5, new IncreaseByTwo());
            put(10, new IncreaseByOne());
        }};
    }

    public void advanceOneDay(Quality quality) {
        strategy().applyTo(quality);
        updateDaysBefore();
    }

    private IncreaseStrategy strategy() {
        return strategies.lowerEntry(daysBefore).getValue();
    }
}