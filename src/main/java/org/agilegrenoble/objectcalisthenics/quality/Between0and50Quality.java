package org.agilegrenoble.objectcalisthenics.quality;

public class Between0and50Quality implements Quality {

    protected int quality;

    public Between0and50Quality(int quality) {
        this.quality = quality;
    }


    /* (non-Javadoc)
     * @see org.agilegrenoble.objectcalisthenics.quality.Quality#getQuality()
     */
    public int getQuality() {
        return quality;
    }

    /* (non-Javadoc)
     * @see org.agilegrenoble.objectcalisthenics.quality.Quality#decrease(int)
     */
    public void decrease(int value) {
        if (quality > 0)
            quality -= value;
    }

    /* (non-Javadoc)
     * @see org.agilegrenoble.objectcalisthenics.quality.Quality#increase(int)
     */
    public void increase(int value) {
        if (quality < 50)
            quality += value;
    }
    
    /* (non-Javadoc)
     * @see org.agilegrenoble.objectcalisthenics.quality.Quality#increase()
     */
    public void increase() {
        increase(1);
    }
    
    /* (non-Javadoc)
     * @see org.agilegrenoble.objectcalisthenics.quality.Quality#decrease()
     */
    public void decrease() {
        decrease(1);
    }

    /* (non-Javadoc)
     * @see org.agilegrenoble.objectcalisthenics.quality.Quality#resetToZero()
     */
    public void resetToZero() {
        quality = 0;
    }
    

}