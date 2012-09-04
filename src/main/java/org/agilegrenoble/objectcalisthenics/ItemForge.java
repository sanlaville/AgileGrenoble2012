package org.agilegrenoble.objectcalisthenics;

import org.agilegrenoble.objectcalisthenics.Ageing.BackStagePassAgeing;
import org.agilegrenoble.objectcalisthenics.Ageing.SellIn;
import org.agilegrenoble.objectcalisthenics.items.Item;
import org.agilegrenoble.objectcalisthenics.items.NormalItem;
import org.agilegrenoble.objectcalisthenics.items.Sulfuras;
import org.agilegrenoble.objectcalisthenics.quality.DegradingQuality;
import org.agilegrenoble.objectcalisthenics.quality.ImprovingQuality;

public class ItemForge {

    public Item anAgedBrie_thatImprovesWithTime(int daysUntilBestBeforeDate, int startQuality) {
        return new NormalItem("Aged Brie", new SellIn(daysUntilBestBeforeDate), new ImprovingQuality(startQuality));
    }

    public Item aSulfuras_isAMagicItemThatNeverChanges() {
        return new Sulfuras();
    }

    public Item anItem_thatDecaysWithTime(String name, int daysUntilBestBeforeDate, int startQuality) {
        return new NormalItem(name, new SellIn(daysUntilBestBeforeDate), new DegradingQuality(startQuality));
    }

    public Item aBackstagePass_thatImprovesUntilTheConcertDate(int daysUntilConcert, int startQuality) {
        return new NormalItem("Backstage passes to a TAFKAL80ETC concert", new BackStagePassAgeing(daysUntilConcert), new ImprovingQuality(startQuality));
    }

}
