package org.agilegrenoble.objectcalisthenics;

public class Item {
	protected String name;
	protected int sellIn;
	public Quality data;

    public Item(String name, int sellIn, int quality) {
		this.name = name;
		this.data = new Quality(quality);
		this.sellIn = sellIn;
	}

	/**
	 * Update quality for the item
	 * 
	 */
	public void updateQuality() {
		if (!name.equals("Aged Brie")
				&& !name.equals("Backstage passes to a TAFKAL80ETC concert")) {
			if (data.getQuality() > 0) {
				if (!name.equals("Sulfuras, Hand of Ragnaros")) {
					data.decrease(1);
				}
			}
		} else {
			if (data.getQuality() < 50) {
				data.increase(1);

				if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
					if (sellIn < 11) {
						if (data.getQuality() < 50) {
							data.increase(1);
						}
					}

					if (sellIn < 6) {
						if (data.getQuality() < 50) {
							data.increase(1);
						}
					}
				}
			}
		}

		if (!name.equals("Sulfuras, Hand of Ragnaros")) {
			decreaseSellIn(1);
		}

		if (sellIn < 0) {
			if (!name.equals("Aged Brie")) {
				if (!name.equals("Backstage passes to a TAFKAL80ETC concert")) {
					if (data.getQuality() > 0) {
						if (!name.equals("Sulfuras, Hand of Ragnaros")) {
							data.decrease(1);
						}
					}
				} else {
					data.resetToZero();
				}
			} else {
				if (data.getQuality() < 50) {
					data.increase(1);
				}
			}
		}
	}

	/**
	 * Decrease sellIn by the given value
	 * 
	 * @param value
	 *            integer by which the sellIn should be increased.
	 */
	protected void decreaseSellIn(int value) {
		sellIn -= value;
	}
}
