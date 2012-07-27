package org.agilegrenoble.objectcalisthenics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.mockito.Mockito;

public class InnTest {

	@Test
	public void updateQuality_WithAnEmptyList_ShouldDoNothing() {
		// Given
		List<Item> items = Mockito.mock(List.class);
		Mockito.when(items.size()).thenReturn(0);

		Inn inn = new Inn(items);

		// When
		inn.updateQuality();

		// Then
		Mockito.verify(items).size();
		Mockito.verifyNoMoreInteractions(items);
	}

	@Test
	public void updateQuality_WithAtLeastOneItem_ShouldCall_updateQualityOnEveryItem() {
		// Given
		Random random = new Random();
		int nbItems = random.nextInt(20) + 1; 
		List<Item> items = Mockito.mock(List.class);
		List<Item> itemsForVerify = new ArrayList<Item>(nbItems);
		Item currentItem = null;
		Mockito.when(items.size()).thenReturn(nbItems);
		for (int i = 0; i < nbItems; i++) {
			currentItem = Mockito.mock(Item.class);
			itemsForVerify.add(currentItem);
			Mockito.when(items.get(i)).thenReturn(currentItem);
		}
		
		Inn inn = new Inn(items);

		// When
		inn.updateQuality();

		// Then
		for (int i = 0; i < nbItems; i++) {
			Mockito.verify(items).get(i);
			Mockito.verify(itemsForVerify.get(i)).updateQuality();
		}
		Mockito.verify(items).size();
		Mockito.verifyNoMoreInteractions(items);
	}
}
