package org.agilegrenoble.objectcalisthenics.rules;

import java.util.NavigableMap;
import java.util.TreeMap;

import org.agilegrenoble.objectcalisthenics.Quality;
import org.agilegrenoble.objectcalisthenics.SellIn;

public class UpdateQualityDependingOnSellIn implements IBusinessRule {

	protected NavigableMap<Integer, IBusinessRule> businessRules = new TreeMap<Integer, IBusinessRule>();
	protected SellIn sellIn = null;

	public UpdateQualityDependingOnSellIn(SellIn sellIn, Quality quality) {

		this.sellIn = sellIn;
		businessRules.put(0, new DropQualityToZero(quality));
		businessRules.put(1,new IncreaseQualityByThree(quality));
		businessRules.put(6, new IncreaseQualityByTwo(quality));
		businessRules.put(11,new IncreaseQualityByOne(quality));
	}

	@Override
	public void execute() {
		IBusinessRule businessRuleDependingOnSellIn = findBusinessRuleDependingOnSellIn();
		businessRuleDependingOnSellIn.execute();
	}

	public IBusinessRule findBusinessRuleDependingOnSellIn() {
		assert sellIn.value() >= 0 : "sellIn must be greater or equals to 0";
		
		Integer key = businessRules.floorKey(sellIn.value());
		IBusinessRule businessRuleDependingOnSellIn = businessRules.get(key);

		return businessRuleDependingOnSellIn;
	}

}
