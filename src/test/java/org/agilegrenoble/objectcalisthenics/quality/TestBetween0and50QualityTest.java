package org.agilegrenoble.objectcalisthenics.quality;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Random;

import org.agilegrenoble.objectcalisthenics.items.Item;
import org.fest.assertions.api.Assertions;
import org.junit.Before;
import org.junit.Test;


public class TestBetween0and50QualityTest {
    private Random random = null;

    @Before
    public void setup() {
        random = new Random();
    }

    @Test
    public void increaseQuality_ShouldIncreaseQualityByTheGivenValue(){
        // Given
        Quality quality = quality(6);
        
        int value = random.nextInt();
        
        // When
        quality.increase(value);
        
        // Then
        Quality expectedQuality = quality(6 + value);
        Assertions.assertThat(quality).isEqualTo(expectedQuality);
    }
    
    @Test
    public void decreaseQuality_ShouldDecreaseQualityByTheGivenValue(){
        // Given
        int startQuality = random.nextInt(51);
        Quality quality = quality(startQuality);
        
        int value = random.nextInt();
        
        // When
        quality.decrease(value);
        
        // Then
        int expectedQuality = startQuality - value;
        Assertions.assertThat(quality).isEqualTo(quality(expectedQuality));
    }
    
    @Test
    public void resetQualityToZero_ShouldResetQualityToZero()
    {
        // Given
        int startQuality = random.nextInt();
        Quality quality = quality(startQuality);

        
        // When
        quality.resetToZero();
        
        // Then
        Assertions.assertThat(quality).isEqualTo(quality(0));
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
