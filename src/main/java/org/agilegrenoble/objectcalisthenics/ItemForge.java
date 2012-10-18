package org.agilegrenoble.objectcalisthenics;

import org.agilegrenoble.objectcalisthenics.Ageing.BackStagePassAgeing;
import org.agilegrenoble.objectcalisthenics.Ageing.DecayWithAge;
import org.agilegrenoble.objectcalisthenics.Ageing.ImproveWithAge;
import org.agilegrenoble.objectcalisthenics.items.BackStagePass;
import org.agilegrenoble.objectcalisthenics.items.Item;
import org.agilegrenoble.objectcalisthenics.items.NormalItem;
import org.agilegrenoble.objectcalisthenics.items.Sulfuras;
import org.agilegrenoble.objectcalisthenics.quality.Between0and50Quality;
import org.agilegrenoble.objectcalisthenics.quality.Quality;

public class ItemForge {

    public Item anAgedBrie_thatImprovesWithTime(int daysUntilBestBeforeDate, int startQuality) {
        return anAgedBrie_thatImprovesWithTime(daysUntilBestBeforeDate, new Between0and50Quality(startQuality));
    }

    public Item anAgedBrie_thatImprovesWithTime(int daysUntilBestBeforeDate, Quality quality) {
        return new NormalItem("Aged Brie", 
                new ImproveWithAge(daysUntilBestBeforeDate), quality);
    }
    
    public Item aSulfuras_isAMagicItemThatNeverChanges() {
        return new Sulfuras();
    }

    public Item anItem_thatDecaysWithTime(String name, int daysUntilBestBeforeDate, int startQuality) {
        return anItem_thatDecaysWithTime(name, daysUntilBestBeforeDate, new Between0and50Quality(startQuality));
    }

    public Item anItem_thatDecaysWithTime(String itemName, int startAge, Quality quality) {
        return new NormalItem(itemName, 
                new DecayWithAge(startAge), quality);
    }
    
    public BackStagePass aBackstagePass_thatImprovesUntilTheConcertDate(int daysUntilConcert, int startQuality) {
        return aBackstagePass_thatImprovesUntilTheConcertDate(daysUntilConcert, new Between0and50Quality(startQuality));
    }
    public BackStagePass aBackstagePass_thatImprovesUntilTheConcertDate(int daysUntilConcert, Quality quality) {
        return new BackStagePass(quality, new BackStagePassAgeing(daysUntilConcert));
    }


}
