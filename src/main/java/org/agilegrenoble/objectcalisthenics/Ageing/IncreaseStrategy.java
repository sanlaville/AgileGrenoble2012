package org.agilegrenoble.objectcalisthenics.Ageing;

import org.agilegrenoble.objectcalisthenics.quality.Quality;

public interface IncreaseStrategy {
    void applyTo(Quality quality);
    
    public class ResetToZero implements IncreaseStrategy {
        public void applyTo(Quality quality) {
            quality.resetToZero();
        }
    }
    public class IncreaseBy implements IncreaseStrategy {
        private int step;
        public IncreaseBy(int step) {
            this.step = step;
        }
        public void applyTo(Quality quality) {
            quality.increase(step);
        }
    }
}
