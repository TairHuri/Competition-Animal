package animals;

import Graphics.CompetitionPanel;
import Olympics.Medal;
import animals.Animal.Gender;
import animals.Animal.Orientation;
import mobility.ILocation;
import mobility.Point;

/**
 * Abstract class representing a water animal.
 */

public abstract class WaterAnimal extends Animal implements IWaterAnimal {
	private double diveDept; // The maximum depth the water animal can dive
	private static final double MAX_DIVE = -800 ;// The maximum allowed dive depth
	
	public WaterAnimal(Point location, double totalDistance, String name, Gender gender, double weight, double speed, Medal medals, double d) {
		super(new Point(0,100));
		diveDept = -80;
	}
    /**
     * Constructor with parameters for WaterAnimal.
     * 
     * @param location       the initial location of the animal.
     * @param totalDistance  the total distance the animal has moved.
     * @param name           the name of the animal.
     * @param gender         the gender of the animal.
     * @param weight         the weight of the animal.
     * @param speed          the speed of the animal.
     * @param position       the current position of the animal.
     * @param diveDept       the maximum depth the animal can dive.
     */
    // Constructor with parameters
    public WaterAnimal(Point location, double totalDistance, String name, Gender gender, double weight, double speed,Medal []medals, double diveDept,int size, int id, ILocation loc,Orientation orientation,int maxEnergy,int energyPerMeter,CompetitionPanel pan) {
        super(location, totalDistance, name, gender, weight, speed, medals, energyPerMeter, energyPerMeter, loc, orientation, energyPerMeter, energyPerMeter, pan);
        this.diveDept = diveDept;
    }
    public WaterAnimal(String name, int speed, int energyAmount) {
        super(name, "Water", "W", speed, energyAmount);
    }

    /**
     * Gets the dive depth of the animal.
     * 
     * @return the dive depth.
     */
    public double getdiveDept() {
    	return diveDept;
    	
    }
    /**
     * Gets the unique sound of the water animal.
     * 
     * @return the sound of the animal.
     */
	protected abstract String getSound();
	
	   /**
     * Makes the animal dive deeper, but not deeper than its MAX_DIVE value.
     * 
     * @param depth the depth to dive.
     */
    public void Dive(double depth) {
        if (this.diveDept - depth < MAX_DIVE) {
            this.diveDept = MAX_DIVE;
        } else {
            this.diveDept -= depth;
        }
    }
	
    /**
     * Returns a string representation of the water animal.
     * @Override
     * @return a string representation of the water animal.
     */
    public String toString() {
        return "WaterAnimal{" +
                super.toString() +
                ", diveDept: " + getdiveDept() +
                '}';
    }
    /**
     * Checks if this water animal is equal to another object.
     * @Override
     * @param obj the object to compare to.
     * @return true if the objects are equal, false otherwise.
     */
    
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof WaterAnimal))
            return false;
        WaterAnimal other = (WaterAnimal) obj;
        return diveDept == other.diveDept;
    }
}
