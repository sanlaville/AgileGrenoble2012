package org.agilegrenoble.objectcalisthenics;

import java.util.List;

import org.agilegrenoble.objectcalisthenics.items.Item;

public class Inn {
	private List<Item> items;

	public Inn(List<Item> initialItems) {
		items = initialItems;
	}

	public void updateQuality() {
		int nbitems = items.size();
		for (int i = 0; i < nbitems; i++) {
			items.get(i).updateQuality();
		}
	}

}
