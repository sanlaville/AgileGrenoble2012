package org.agilegrenoble.objectcalisthenics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.agilegrenoble.objectcalisthenics.items.Item;
import org.agilegrenoble.objectcalisthenics.items.NormalItem;
import org.junit.Test;
import org.mockito.Mockito;

public class InnTest {

	@Test
	public void updateQuality_WithAnEmptyList_ShouldDoNothing() {
		// Given
		List<Item> items = new ArrayList<Item>();

		Inn inn = new Inn(items);

		// When
		inn.updateQuality();

		// Then
	}

	@Test
	public void updateQuality_WithAtLeastOneItem_ShouldCall_updateQualityOnEveryItem() {
		// Given
		Random random = new Random();
		int nbItems = random.nextInt(20) + 1; 
		List<Item> items = new ArrayList<Item>();
		NormalItem currentItem = null;
		for (int i = 0; i < nbItems; i++) {
			currentItem = Mockito.mock(NormalItem.class);
			items.add(currentItem);
		}
		
		Inn inn = new Inn(items);

		// When
		inn.updateQuality();

		// Then
		for (Item item : items) {
		    Mockito.verify(item).updateQuality();
        }
	}
}
