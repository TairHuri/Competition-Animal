package animals;

import Graphics.CompetitionPanel;
import Olympics.Medal;
import animals.Animal.Gender;
import animals.Animal.Orientation;
import mobility.ILocation;
import mobility.Point;
/**
 * The AirAnimal class represents an animal that can fly.
 * It is an abstract class that extends the Animal class.
 */

public abstract class AirAnimal extends Animal {
    /**
     * The wingspan of the AirAnimal.
     */
	private double wingspan;
	

    /**
     * Constructs a new AirAnimal with default parameters.
     *
     * @param location      the initial location of the animal.
     * @param totalDistance the total distance the animal has traveled.
     * @param name          the name of the animal.
     * @param gender        the gender of the animal.
     * @param weight        the weight of the animal.
     * @param speed         the speed of the animal.
     * @param medals        the medals the animal has won.
     * @param wingspan      the wingspan of the animal.
     */
  
	public AirAnimal(Point location, double totalDistance, String name, Gender gender, double weight, double speed, Medal medals, double wingspan2) {
		super(new Point(0,100));

		wingspan = 5.5;// Set the default wingspan
		// TODO Auto-generated constructor stub
	}

    /**
     * Constructs a new AirAnimal with specified parameters.
     *
     * @param location      the initial location of the animal.
     * @param totalDistance the total distance the animal has traveled.
     * @param name          the name of the animal.
     * @param gender        the gender of the animal.
     * @param weight        the weight of the animal.
     * @param speed         the speed of the animal.
     * @param medals        the medals the animal has won.
     * @param wingspan      the wingspan of the animal.
     */
  
    // Constructor with parameters
    public AirAnimal(Point location, double totalDistance, String name, Gender gender, double weight, double speed,Medal[] medals, double wingspan,int size, int id, ILocation loc,Orientation orientation,int maxEnergy,int energyPerMeter,CompetitionPanel pan) {
        super(location, totalDistance, name, gender, weight, speed,medals, energyPerMeter, energyPerMeter, loc, orientation, energyPerMeter, energyPerMeter, pan);// Initialize the superclass with given parameters
        this.wingspan = wingspan;// Set the wingspan
    }
    
    public AirAnimal(String name, int speed, int energyAmount) {
        super(name, "Air", "A", speed, energyAmount);
    }
    /**
     * Gets the wingspan of the AirAnimal.
     *
     * @return the wingspan of the AirAnimal.
     */

    protected double getWingspan() {
    	return wingspan;
    	
    }
    
    /**
     * Gets the sound made by the AirAnimal.
     *
     * @return the sound made by the AirAnimal.
     */
	protected abstract String getSound();
    
    /**
     * Returns a string representation of the AirAnimal.
     *@Override
     * @return a string representation of the AirAnimal.
     */
    public String toString() {
        return "AirAnimal{" +
                super.toString() +
                ", wingspan: " + getWingspan() +
                '}';
    }
    /**
     * Compares this AirAnimal to another object for equality.
     *@Override
     * @param other the object to compare to.
     * @return true if the objects are equal, false otherwise.
     */
    public boolean equals(Object other) {
        if (this == other)// Check if the objects are the same instance
            return true;
        if (!super.equals(other))// Use the superclass's equals method for initial checks
            return false;
        if (!(other instanceof AirAnimal))// Check if the other object is an instance of AirAnimal
            return false;
        return ((AirAnimal) other).wingspan == wingspan;// Compare wingspan values
    }

}
