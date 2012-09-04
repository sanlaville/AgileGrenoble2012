package org.agilegrenoble.objectcalisthenics;

import java.util.ArrayList;
import java.util.List;

import org.agilegrenoble.objectcalisthenics.Ageing.SellIn;
import org.agilegrenoble.objectcalisthenics.items.Item;
import org.agilegrenoble.objectcalisthenics.items.NormalItem;
import org.agilegrenoble.objectcalisthenics.quality.DegradingQuality;

public class Main {

	public static void main(String[] args) {
		System.out.println("OMGHAI!");
		ItemForge forge = new ItemForge();
		List<Item> items = new ArrayList<Item>();
		items.add(forge.agedBrieThatImprovesWithTime(2, 0));
		items.add(forge.aSulfuras_isAMagicItemThatNeverChanges());
		items.add(forge.backstagePassThatImprovesUntilTheConcertDate());
		items.add(forge.aNormalItem("+5 Dexterity Vest", 10, 20));
		items.add(forge.aNormalItem("Elixir of the Mongoose", 5, 7));
		items.add(new NormalItem("Conjured Mana Cake", new SellIn(3), new DegradingQuality(6)));
		new Inn(items).updateQuality();
	}

}
