package org.agilegrenoble.objectcalisthenics;

import java.util.List;

public class Inn {
	private List<Item> items;

	public Inn(List<Item> initialItems) {
		items = initialItems;
	}

	public void updateQuality() {
		for (int i = 0; i < items.size(); i++) {
			updateQuality(items.get(i));
		}
	}

	/** Update quality for given item
	 * 
	 * @param item the item to update. Must be not null;
	 */
	private void updateQuality(Item item) {
		if (!item.getName().equals("Aged Brie")
				&& !item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
			if (item.getQuality() > 0) {
				if (!item.getName()
						.equals("Sulfuras, Hand of Ragnaros")) {
					item.setQuality(item.getQuality() - 1);
				}
			}
		} else {
			if (item.getQuality() < 50) {
				item.setQuality(item.getQuality() + 1);

				if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
					if (item.getSellIn() < 11) {
						if (item.getQuality() < 50) {
							item.setQuality(
									item.getQuality() + 1);
						}
					}

					if (item.getSellIn() < 6) {
						if (item.getQuality() < 50) {
							item.setQuality(
									item.getQuality() + 1);
						}
					}
				}
			}
		}

		if (!item.getName().equals("Sulfuras, Hand of Ragnaros")) {
			item.setSellIn(item.getSellIn() - 1);
		}

		if (item.getSellIn() < 0) {
			if (!item.getName().equals("Aged Brie")) {
				if (!item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
					if (item.getQuality() > 0) {
						if (!item.getName()
								.equals("Sulfuras, Hand of Ragnaros")) {
							item.setQuality(
									item.getQuality() - 1);
						}
					}
				} else {
					item.setQuality(
							item.getQuality()
									- item.getQuality());
				}
			} else {
				if (item.getQuality() < 50) {
					item.setQuality(item.getQuality() + 1);
				}
			}
		}
	}
}
