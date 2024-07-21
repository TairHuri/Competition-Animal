package animals;
import Graphics.CompetitionPanel;
import Graphics.ZooPanel;
import Olympics.Medal;
import animals.Animal.Orientation;
import mobility.ILocation;
import mobility.Point;

/**
 * Abstract class representing terrestrial animals, extending the Animal class.
 */
public abstract class TerrestrialAnimals extends Animal implements ITerrestrialAnimals {
	private int noLegs;  // The number of legs of the terrestrial animal
	
	
    /**
     * Constructor for TerrestrialAnimals with default values.
     * Initializes fields with default values.
     *
     * @param point   the initial location of the animal.
     * @param i       a parameter for the point
     * @param string  a parameter for the point
     * @param female  a parameter for the point
     * @param j       a parameter for the point
     * @param d       a parameter for the point
     * @param noLegs2   a parameter for the point
     * @param medals       a parameter for the point
     */
	public TerrestrialAnimals(String string,double i, double j, int d,int noLegs2, ZooPanel z) {
		super(new Point(0,0));
		noLegs = 5;
	}
    /**
     * Constructor for TerrestrialAnimals with parameters.
     *
     * @param location      the initial location of the animal.
     * @param totalDistance the total distance the animal has moved.
     * @param name          the name of the animal.
     * @param gender        the gender of the animal.
     * @param weight        the weight of the animal.
     * @param speed         the speed of the animal.
     * @param medals        the medals the animal has won.
     * @param noLegs        the number of legs of the terrestrial animal.
     */
	// Constructor with parameters
	public TerrestrialAnimals(Point location, double totalDistance, String name, Gender gender, double weight, double speed,Medal[] medals,int noLegs,int size, int id, ILocation loc,Orientation orientation,int maxEnergy,int energyPerMeter,CompetitionPanel pan) {
        super(location, totalDistance, name, gender, weight, speed, medals, noLegs, noLegs, loc, orientation, noLegs, noLegs, pan);
        this.noLegs = noLegs;
	}
	
    public TerrestrialAnimals(String name, int speed, int energyAmount) {
        super(name, "Terrestrial", "T", speed, energyAmount);
    }

    /**
     * Gets the number of legs of the terrestrial animal.
     *
     * @return the number of legs.
     */
	public int getNoLegs() {
	    	return noLegs;
     }
    /**
     * Abstract method to be implemented by subclasses to return the sound the terrestrial animal makes.
     *
     * @return the sound of the terrestrial animal.
     */
	protected abstract String getSound();
	    
	    /**
	     * Returns a string representation of the terrestrial animal.
	     *@Override
	     * @return a string representation including all fields.
	     */
	public String toString() {
	        return "TerrestrialAnimals{" +
	                super.toString() +
	                ", noLegs: " + getNoLegs() +
	                '}';
	 }
	    /**
	     * Compares this terrestrial animal to another object for equality.
	     *@Override
	     * @param obj the object to compare to.
	     * @return true if the objects are equal, false otherwise.
	     */
    
	 public boolean equals(Object obj) {
		 
	     if (this == obj)
	         return true;
	     if (!super.equals(obj))
	         return false;
         if (!(obj instanceof TerrestrialAnimals))
             return false;
         TerrestrialAnimals other = (TerrestrialAnimals) obj;
	 return getNoLegs() == other.getNoLegs();
	    }   


}
