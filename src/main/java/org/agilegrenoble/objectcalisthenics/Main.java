package org.agilegrenoble.objectcalisthenics;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		System.out.println("OMGHAI!");
		List<Item> items = new ArrayList<Item>();
		items.add(new NormalItem("+5 Dexterity Vest", new SellIn(10), new Quality(20)));
		items.add(new BrieItem(new SellIn(2),  new Quality(0)));
		items.add(new NormalItem("Elixir of the Mongoose",  new SellIn(5),  new Quality(7)));
		items.add(new SulfurasItem( new SellIn(0),  new Quality(80)));
		items.add(new BackstageItem( new SellIn(15),  new Quality(20)));
		new Inn(items).updateQuality();
	}

}
