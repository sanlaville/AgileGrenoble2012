package org.agilegrenoble.objectcalisthenics;

import java.util.List;

public class Inn {
	private List<NormalItem> items;

	public Inn(List<NormalItem> initialItems) {
		items = initialItems;
	}

	public void updateQuality() {
		int nbitems = items.size();
		for (int i = 0; i < nbitems; i++) {
			items.get(i).updateQuality();
		}
	}

}
