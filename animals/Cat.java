package animals;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Graphics.CompetitionPanel;
import Graphics.ZooPanel;
import Olympics.Medal;
import animals.Animal.Orientation;
import mobility.ILocation;
import mobility.Point;
/**
 * Class representing a cat, a terrestrial animal.
 */

public class Cat extends TerrestrialAnimals{
	private boolean Castrated;  // Whether the cat is castrated or not
    private BufferedImage catImage; // Image of the cat
    private static final String CAT_IMAGE_PATH = "C:\\Users\\Student\\Downloads\\GUI\\graphics2 (1)\\graphics2\\cat1.png"; // Path to the cat image

    /**
     * Default constructor for Cat.
     * Initializes fields with default values.
     * @param zooPanel 
     * @param energyPerMeter 
     * @param maxEnergy 
     * @param speed 
     * @param weight 
     * @param name 
     */
    public Cat(String name, double weight, double speed, int maxEnergy, int energyPerMeter, ZooPanel zooPanel) {
    	super(name, speed, speed, energyPerMeter, energyPerMeter, zooPanel);
        this.Castrated = false;
        loadCatImage(); // Load the image when creating a Cat
    }
    /**
     * Constructor with parameters for Cat.
     * 
     * @param location       the initial location of the cat.
     * @param totalDistance  the total distance the cat has moved.
     * @param name           the name of the cat.
     * @param gender         the gender of the cat.
     * @param weight         the weight of the cat.
     * @param speed          the speed of the cat.
     * @param position       the current position of the cat.
     * @param noLegs         the number of legs the cat has.
     * @param castrated      whether the cat is castrated or not.
     */
    public Cat(Point location, double totalDistance, String name, Gender gender, double weight, double speed,Medal[] medals, int noLegs, boolean castrated,int size, int id, ILocation loc,Orientation orientation,int maxEnergy,int energyPerMeter,CompetitionPanel pan) {
        super(location, totalDistance, name, gender, weight, speed,medals,  noLegs,size, id,  loc,orientation,maxEnergy,energyPerMeter, pan);
        this.Castrated = castrated;
        this.setMedal(medals); 
        loadCatImage(); // Load the image when creating a Cat
    }
    private void loadCatImage() {
        try {
            catImage = ImageIO.read(new File(CAT_IMAGE_PATH));
            if (catImage == null) {
                System.out.println("Image could not be read.");
            }
        } catch (IOException e) {
            System.out.println("Cannot load cat image");
        }
    }
    @Override
    public void drawObject(Graphics g) {
        if (catImage != null) {
            g.drawImage(catImage,  location.getX(), location.getY()-size/10, size*2, size, pan);
        } else {
            System.out.println("Cat image not loaded");
        }
    }
    /**
     * Gets whether the cat is castrated or not.
     * 
     * @return true if the cat is castrated, false otherwise.
     */
	public boolean getCastrated() {
		return Castrated; 
	}
    /**
     * Sets whether the cat is castrated or not.
     * 
     * @param castrated the new castrated status.
     */
    public void setCastrated(boolean Castrated) {
        this.Castrated = Castrated;
    }
    /**
     * Returns the sound the cat makes.
     *@Override
     * @return the sound "Meow".
     */
    
    public Cat(String name, int speed, int energyAmount) {
        super(name, speed, energyAmount);
        setType("Cat");
    }
    

	protected String getSound() {
		return "Meow";
	}
    /**
     * Returns a string representation of the cat.
     *@Override
     * @return a string representation including all fields.
     */
    
	public String toString() {
		  return "Cat: " + super.toString()
	        +   ", Castrated: " + getCastrated();
	}
	
    /**
     * Compares this cat to another object for equality.
     *@Override
     * @param other the object to compare to.
     * @return true if the objects are equal, false otherwise.
     */
    
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!super.equals(other))
            return false;
        if (!(other instanceof Cat))
            return false;
    
        return ((Cat) other).Castrated == Castrated;
    }

}
