package animals;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Graphics.CompetitionPanel;
import Graphics.ZooPanel;
import Olympics.Medal;
import animals.Animal.Gender;
import animals.Animal.Orientation;
import animals.Snake.Poisonous;
import mobility.ILocation;
import mobility.Point;
/**
 * Class representing an alligator, a water animal.
 */
public class Alligator extends Animal implements IWaterAnimal, ITerrestrialAnimals, IReptile  {
    /**
     * The area where the alligator lives.
     */
	private String AreaOfLiving ;
	private TerrestrialAnimalDelegate terrestrialA;
	private WaterAnimalDelegate waterA;
    private BufferedImage alligatorImage; // Image of the cat
    private static final String ALLIGATOR_IMAGE_PATH = "C:\\Users\\Student\\Downloads\\GUI\\graphics2 (1)\\graphics2\\alligator1.png"; // Path to the cat image

	/**
     * Default constructor for Alligator.
     * Initializes fields with default values.
     */
	public Alligator() {	
		 // Initialize the superclass with default values
        super(new Point(0,100));
		this.AreaOfLiving = "Lake";// Default area of living
	    this.terrestrialA = new TerrestrialAnimalDelegate();
	    this.waterA = new WaterAnimalDelegate();
	}
	
    /**
     * Constructor for Alligator with parameters.
     * @param location the initial location of the alligator.
     * @param totalDistance the total distance the alligator has moved.
     * @param name the name of the alligator.
     * @param gender the gender of the alligator.
     * @param weight the weight of the alligator.
     * @param speed the speed of the alligator.
     * @param diveDept the maximum depth the alligator can dive.
     * @param areaOfLiving the area of living of the alligator.
     */
    public Alligator(Point location, double totalDistance, String name, Gender gender, double weight, double speed,Medal [] medals, double diveDept,String AreaOfLiving,int noLegs,int size, int id, ILocation loc,Orientation orientation,int maxEnergy,int energyPerMeter,CompetitionPanel pan) {
    	// Initialize the superclass with given parameters
    	super(location, totalDistance, name, gender, weight, speed, medals, energyPerMeter, energyPerMeter, loc, orientation, energyPerMeter, energyPerMeter, pan);
        this.AreaOfLiving = AreaOfLiving;// Set the area of living
        this.setMedal(medals);// Set the medals 
        this.terrestrialA = new TerrestrialAnimalDelegate(this);
        this.waterA = new WaterAnimalDelegate(this);
    }
    
    public Alligator(String name, double weight, double speed, int maxEnergy, int energyPerMeter, ZooPanel zooPanel) {
		super();
	}

    public Alligator(String name, int speed, int energyAmount) {
        super(name, "Wather and Terrestrial", "T", speed, energyAmount);
    }
    private void loadWhaleImage() {
        try {
            alligatorImage = ImageIO.read(new File(ALLIGATOR_IMAGE_PATH));
            if (alligatorImage == null) {
                System.out.println("Image could not be read.");
            }
        } catch (IOException e) {
            System.out.println("Cannot load cat image");
        }
    }
    @Override
    public void drawObject(Graphics g) {
        if (alligatorImage != null) {
            g.drawImage(alligatorImage,  location.getX(), location.getY()-size/10, size*2, size, pan);
        } else {
            System.out.println("Cat image not loaded");
        }
    }
	/**
     * Gets the area of living of the alligator.
     * @return the area of living.
     */
    public String getAreaOfLiving() {
    	return AreaOfLiving;
    }
    
    /**
     * Sets the area of living of the alligator.
     * @param areaOfLiving the new area of living.
     */
    public void setAreaOfLiving(String AreaOfLiving) {
        this.AreaOfLiving = AreaOfLiving;
    }
    
    /**
     * Gets the sound made by the alligator.
     *
     * @return the sound made by the alligator.
     */
    protected String getSound() {
    	return "Roar";
    }
    
    /**
     * Returns a string representation of the alligator.
     *@Override
     * @return a string representation of the alligator.
     */
    
    public String toString() {
    	return "Alligator: " + super.toString()
    	+ ", AreaOfLiving: " + getAreaOfLiving(); 
    }
    
    /**
     * Compares this alligator to another object for equality.
     *@Override
     * @param other the object to compare to.
     * @return true if the objects are equal, false otherwise.
     */
    
    public boolean equal(Object other) {
    	if(other == this) {// Check if the objects are the same instance
    		return true;
    	}
        if (!super.equals(other))
            return false;// Use the superclass's equals method for initial checks
    	if(!(other instanceof Alligator)) {// Check if the other object is an instance of Alligator
    		return false;
    	}
    	return getAreaOfLiving() == ((Alligator)other).getAreaOfLiving();// Compare AreaOfLiving values
    	}
    
    /**
     * Implementation of the speedUp method from the IReptile interface.
     * Speeds up the snake, but not beyond the maximum speed.
     * 
     * @param speed the amount to speed up.
     * @return true if the speed was increased, false otherwise.
     */
    @Override
    public boolean speedUp(int speed) {
        double currentSpeed = getSpeed();
        if (currentSpeed + speed <= IReptile.MAX_SPEED) {
            setSpeed(currentSpeed + speed); // Increase speed within limit
            return true;
        } else {
            setSpeed(IReptile.MAX_SPEED);// Set to max speed if limit exceeded
            return false;
        }
    }

	@Override
	public int getNoLegs() {return terrestrialA.getNoLegs();}

	@Override
	public double getdiveDept() {
		// TODO Auto-generated method stub
		return waterA.getdiveDept();
	}

	@Override
	public void Dive(double depth) {
		waterA.Dive(depth);
	}

	@Override
	public boolean move(Point p) {
		// TODO Auto-generated method stub
		return false;
	}


}
