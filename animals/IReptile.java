package animals;

/**
 * Interface for reptiles.
 */
public interface IReptile {
	
	public static final int MAX_SPEED = 5; //static to change
    /**
     * Speeds up the reptile, but not beyond the maximum speed.
     * param speed the amount to speed up
     * return true if the speed was increased, false otherwise
     */
	public boolean speedUp(int speed);
}
