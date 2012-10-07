package org.agilegrenoble.objectcalisthenics.Ageing;

import java.util.NavigableMap;
import java.util.TreeMap;

import org.agilegrenoble.objectcalisthenics.Ageing.IncreaseStrategy.IncreaseByOne;
import org.agilegrenoble.objectcalisthenics.Ageing.IncreaseStrategy.IncreaseByThree;
import org.agilegrenoble.objectcalisthenics.Ageing.IncreaseStrategy.IncreaseByTwo;
import org.agilegrenoble.objectcalisthenics.Ageing.IncreaseStrategy.ResetToZero;
import org.agilegrenoble.objectcalisthenics.quality.Quality;

public class BackStagePassAgeing extends Ageing {

    public BackStagePassAgeing(int daysBeforeConcert) {
        super(daysBeforeConcert);
    }

    public void advanceOneDay(Quality quality) {

        NavigableMap<Integer, IncreaseStrategy> strategies = new TreeMap<Integer, IncreaseStrategy>() {{
           put(Integer.MIN_VALUE, new ResetToZero());
           put(0, new IncreaseByThree());
           put(5, new IncreaseByTwo());
           put(10, new IncreaseByOne());
        }};
        
        strategies.lowerEntry(daysBefore).getValue().apply(quality);
        
        updateDaysBefore();
    }
}