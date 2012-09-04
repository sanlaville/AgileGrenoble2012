package org.agilegrenoble.objectcalisthenics.Ageing;

import org.agilegrenoble.objectcalisthenics.quality.Quality;

public class NoAgeing extends Ageing {

    public NoAgeing(int daysBefore) {
        super(daysBefore);
    }

    @Override
    public void advanceOneDay(Quality quality) {
        // well nothing happens of course !!
    }
    
}