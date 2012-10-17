package org.agilegrenoble.objectcalisthenics.Ageing.backstagepass;

import java.util.NavigableMap;
import java.util.TreeMap;

import org.agilegrenoble.objectcalisthenics.Ageing.Ageing;
import org.agilegrenoble.objectcalisthenics.Ageing.backstagepass.IncreaseStrategy.IncreaseBy;
import org.agilegrenoble.objectcalisthenics.Ageing.backstagepass.IncreaseStrategy.ResetToZero;
import org.agilegrenoble.objectcalisthenics.quality.Quality;

public class BackStagePassAgeing extends Ageing {

    private NavigableMap<Integer,IncreaseStrategy> strategies;

    public BackStagePassAgeing(int daysBeforeConcert) {
        super(daysBeforeConcert);
        strategies = new TreeMap<Integer, IncreaseStrategy>() {{
            put(Integer.MIN_VALUE, new ResetToZero());
            put(0, new IncreaseBy(3));
            put(5, new IncreaseBy(2));
            put(10, new IncreaseBy(1));
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