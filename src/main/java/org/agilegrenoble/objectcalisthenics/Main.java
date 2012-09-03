package org.agilegrenoble.objectcalisthenics;

import java.util.ArrayList;
import java.util.List;

import org.agilegrenoble.objectcalisthenics.quality.DegradingQuality;

public class Main {

	public static void main(String[] args) {
		System.out.println("OMGHAI!");
		List<Item> items = new ArrayList<Item>();
		items.add(new NormalItem("+5 Dexterity Vest", new SellIn(10), new DegradingQuality(20)));
		items.add(new NormalItem("Aged Brie", new SellIn(2), new DegradingQuality(0)));
		items.add(new NormalItem("Elixir of the Mongoose", new SellIn(5), new DegradingQuality(7)));
		items.add(new Sulfuras());
		items.add(new NormalItem("Backstage passes to a TAFKAL80ETC concert", new SellIn(15), new DegradingQuality(20)));
		items.add(new NormalItem("Conjured Mana Cake", new SellIn(3), new DegradingQuality(6)));
		new Inn(items).updateQuality();
	}

}
