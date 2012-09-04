package org.agilegrenoble.objectcalisthenics;

import java.util.ArrayList;
import java.util.List;

import org.agilegrenoble.objectcalisthenics.Ageing.DecayWithAge;
import org.agilegrenoble.objectcalisthenics.items.Item;
import org.agilegrenoble.objectcalisthenics.items.NormalItem;
import org.agilegrenoble.objectcalisthenics.quality.DegradingQuality;

public class Main {

	public static void main(String[] args) {
		System.out.println("OMGHAI!");
		ItemForge forge = new ItemForge();
		List<Item> items = new ArrayList<Item>();
		items.add(forge.anAgedBrie_thatImprovesWithTime(2, 0));
		items.add(forge.aSulfuras_isAMagicItemThatNeverChanges());
		items.add(forge.aBackstagePass_thatImprovesUntilTheConcertDate(15, 20));
		items.add(forge.anItem_thatDecaysWithTime("+5 Dexterity Vest", 10, 20));
		items.add(forge.anItem_thatDecaysWithTime("Elixir of the Mongoose", 5, 7));
		items.add(new NormalItem("Conjured Mana Cake", new DecayWithAge(3), new DegradingQuality(6)));
		new Inn(items).updateQuality();
	}

}
