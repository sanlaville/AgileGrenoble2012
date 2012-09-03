package org.agilegrenoble.objectcalisthenics;

public class Item {
	protected String name;
	public SellIn sellIn;
    protected Quality quality;

    public Item(String name, int sellIn, int quality) {
		this.name = name;
		this.quality = new Quality(quality);
		this.sellIn = new SellIn(sellIn);
	}

	/**
	 * Update quality for the item
	 * 
	 */
	public void updateQuality() {
		if (!name.equals("Aged Brie")
				&& !name.equals("Backstage passes to a TAFKAL80ETC concert")) {
			if (quality.getQuality() > 0) {
				if (!name.equals("Sulfuras, Hand of Ragnaros")) {
					quality.decrease(1);
				}
			}
		} else {
			if (quality.getQuality() < 50) {
				quality.increase(1);

				if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
					if (sellIn.getSellIn() < 11) {
						if (quality.getQuality() < 50) {
							quality.increase(1);
						}
					}

					if (sellIn.getSellIn() < 6) {
						if (quality.getQuality() < 50) {
							quality.increase(1);
						}
					}
				}
			}
		}

		if (!name.equals("Sulfuras, Hand of Ragnaros")) {
			sellIn.decreaseSellIn();
		}

		if (sellIn.getSellIn() < 0) {
			if (!name.equals("Aged Brie")) {
				if (!name.equals("Backstage passes to a TAFKAL80ETC concert")) {
					if (quality.getQuality() > 0) {
						if (!name.equals("Sulfuras, Hand of Ragnaros")) {
							quality.decrease(1);
						}
					}
				} else {
					quality.resetToZero();
				}
			} else {
				if (quality.getQuality() < 50) {
					quality.increase(1);
				}
			}
		}
	}
}
