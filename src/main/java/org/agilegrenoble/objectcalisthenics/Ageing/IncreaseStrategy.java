package org.agilegrenoble.objectcalisthenics.Ageing;

import org.agilegrenoble.objectcalisthenics.quality.Quality;

public interface IncreaseStrategy {
    void applyTo(Quality quality);
    
    public class ResetToZero implements IncreaseStrategy {
        public void applyTo(Quality quality) {
            quality.resetToZero();
        }
    }
    public class IncreaseByOne implements IncreaseStrategy {
        public void applyTo(Quality quality) {
            quality.increase();
        }
    }
    public class IncreaseByTwo implements IncreaseStrategy {
        public void applyTo(Quality quality) {
            quality.increase();
            quality.increase();
        }
    }
    public class IncreaseByThree implements IncreaseStrategy {
        public void applyTo(Quality quality) {
            quality.increase();
            quality.increase();
            quality.increase();
        }
    }
}
