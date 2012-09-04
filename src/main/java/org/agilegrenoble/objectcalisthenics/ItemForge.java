package org.agilegrenoble.objectcalisthenics;

import org.agilegrenoble.objectcalisthenics.Ageing.BackStagePassAgeing;
import org.agilegrenoble.objectcalisthenics.Ageing.SellIn;
import org.agilegrenoble.objectcalisthenics.items.Item;
import org.agilegrenoble.objectcalisthenics.items.NormalItem;
import org.agilegrenoble.objectcalisthenics.items.Sulfuras;
import org.agilegrenoble.objectcalisthenics.quality.DegradingQuality;
import org.agilegrenoble.objectcalisthenics.quality.ImprovingQuality;

public class ItemForge {

    public Item agedBrieThatImprovesWithTime(int daysUntilBestBeforeDate, int startQuality) {
        return new NormalItem("Aged Brie", new SellIn(daysUntilBestBeforeDate), new ImprovingQuality(startQuality));
    }

    public Item backstagePassThatImprovesUntilTheConcertDate() {
        return new NormalItem("Backstage passes to a TAFKAL80ETC concert", new BackStagePassAgeing(15), new DegradingQuality(20));
    }

    public Item aSulfuras_isAMagicItemThatNeverChanges() {
        return new Sulfuras();
    }

    public Item aNormalItem(String string, int daysUntilBestBeforeDate, int startQuality) {
        return new NormalItem("+5 Dexterity Vest", new SellIn(daysUntilBestBeforeDate), new DegradingQuality(startQuality));
    }

    public Item backstagePassThatImprovesUntilTheConcertDate(int quality, int daysUntilConcert) {
        return new NormalItem("Backstage passes to a TAFKAL80ETC concert", new BackStagePassAgeing(daysUntilConcert), new ImprovingQuality(quality));
    }

}
