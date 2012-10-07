package org.agilegrenoble.objectcalisthenics.quality;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Random;

import org.agilegrenoble.objectcalisthenics.items.Item;
import org.junit.Before;
import org.junit.Test;


public class TestBetween0and50QualityTest {
    private Random random = null;

    @Before
    public void setup() {
        random = new Random();
    }

    @Test
    public void quality_never_exceeds_50() {
        // Given
        int maxQuality = 50;
        Quality quality = quality(maxQuality);

        // When
        repeatIncreaseQuality(quality, random.nextInt(10));

        // Then
        assertThat(quality).isEqualTo(quality(maxQuality));
    }

    @Test
    public void quality_is_never_negative() {
        // Given
        int minQuality = 0;
        Quality quality = quality(minQuality);

        // When
        repeatDecreaseQuality(quality, random.nextInt(10));

        // Then
        assertThat(quality).isEqualTo(quality(minQuality));
    }


    private void repeatDecreaseQuality(Quality quality, int repetitions) {
        for (int i = 0; i < repetitions; i++) {
            quality.decrease();
        }
        
    }

    private void repeatIncreaseQuality(Quality quality, int repetitions) {
        for (int i = 0; i < repetitions; i++) {
            quality.increase();
        }
        
    }

    private Quality quality(int amount) {
        return new Between0and50Quality(amount);
    }


}
