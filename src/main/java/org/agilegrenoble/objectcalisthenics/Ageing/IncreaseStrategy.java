package org.agilegrenoble.objectcalisthenics.Ageing;

import org.agilegrenoble.objectcalisthenics.quality.Quality;

public interface IncreaseStrategy {
    void apply(Quality quality);
    
    public class ResetToZero implements IncreaseStrategy {
        public void apply(Quality quality) {
            quality.resetToZero();
        }
    }
    public class IncreaseByOne implements IncreaseStrategy {
        public void apply(Quality quality) {
            quality.increase();
        }
    }
    public class IncreaseByTwo implements IncreaseStrategy {
        public void apply(Quality quality) {
            quality.increase();
            quality.increase();
        }
    }
    public class IncreaseByThree implements IncreaseStrategy {
        public void apply(Quality quality) {
            quality.increase();
            quality.increase();
            quality.increase();
        }
    }
}
