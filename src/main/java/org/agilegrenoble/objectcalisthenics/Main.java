package org.agilegrenoble.objectcalisthenics;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		System.out.println("OMGHAI!");
		List<Item> items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", new SellIn(10), new Quality(20)));
		items.add(new Item("Aged Brie", new SellIn(2), new Quality(0)));
		items.add(new Item("Elixir of the Mongoose", new SellIn(5), new Quality(7)));
		items.add(new Item("Sulfuras, Hand of Ragnaros", new SellIn(0), new Quality(80)));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", new SellIn(15), new Quality(20)));
		items.add(new Item("Conjured Mana Cake", new SellIn(3), new Quality(6)));
		new Inn(items).updateQuality();
	}

}
