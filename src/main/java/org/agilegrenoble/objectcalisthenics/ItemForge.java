package org.agilegrenoble.objectcalisthenics;

import org.agilegrenoble.objectcalisthenics.Ageing.DecayWithAge;
import org.agilegrenoble.objectcalisthenics.Ageing.ImproveWithAge;
import org.agilegrenoble.objectcalisthenics.Ageing.backstagepass.BackStagePassAgeing;
import org.agilegrenoble.objectcalisthenics.items.Item;
import org.agilegrenoble.objectcalisthenics.items.NormalItem;
import org.agilegrenoble.objectcalisthenics.items.Sulfuras;
import org.agilegrenoble.objectcalisthenics.quality.Between0and50Quality;
import org.agilegrenoble.objectcalisthenics.quality.Quality;

public class ItemForge {

    public Item anAgedBrie_thatImprovesWithTime(int daysUntilBestBeforeDate, int startQuality) {
        return new NormalItem("Aged Brie", 
                new ImproveWithAge(daysUntilBestBeforeDate), new Between0and50Quality(startQuality));
    }

    public Item aSulfuras_isAMagicItemThatNeverChanges() {
        return new Sulfuras();
    }

    public Item anItem_thatDecaysWithTime(String name, int daysUntilBestBeforeDate, int startQuality) {
        return new NormalItem(name, 
                new DecayWithAge(daysUntilBestBeforeDate), new Between0and50Quality(startQuality));
    }

    public Item aBackstagePass_thatImprovesUntilTheConcertDate(int daysUntilConcert, int startQuality) {
        return new NormalItem("Backstage passes to a TAFKAL80ETC concert", 
                new BackStagePassAgeing(daysUntilConcert), new Between0and50Quality(startQuality));
    }
    public Item aBackstagePass_thatImprovesUntilTheConcertDate(int daysUntilConcert, Quality quality) {
        return new NormalItem("Backstage passes to a TAFKAL80ETC concert", 
                new BackStagePassAgeing(daysUntilConcert), quality);
    }

    public Item anItem_thatDecaysWithTime(String itemName, int startAge, Quality quality) {
        return new NormalItem(itemName, 
                new DecayWithAge(startAge), quality);
    }

}