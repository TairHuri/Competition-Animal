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
 * Class representing a whale, a water animal.
 */
public class Whale extends WaterAnimal{
	private String foodType; // The type of food the whale consumes 
    private BufferedImage whaleImage; // Image of the cat
    private static final String WHALE_IMAGE_PATH = "C:\\Users\\Student\\Downloads\\GUI\\graphics2 (1)\\graphics2\\whale.png"; // Path to the cat image

    /**
     * Default constructor for Whale.
     * Initializes fields with default values.
     * @param zooPanel 
     * @param energyPerMeter 
     * @param maxEnergy 
     * @param speed 
     * @param weight 
     * @param name 
     */
	public Whale(String name, double weight, double speed, int maxEnergy, int energyPerMeter, ZooPanel zooPanel) {
        super(new Point(0, 0), 50, "Whale", Gender.FEMALE, 10000.0, 3.0, new Medal(),300);
        this.foodType = "Prey";
	}
	
    /**
     * Constructor for Whale with parameters.
     * @param location the initial location of the whale.
     * @param totalDistance the total distance the whale has moved.
     * @param name the name of the whale.
     * @param gender the gender of the whale.
     * @param weight the weight of the whale.
     * @param speed the speed of the whale.
     * @param diveDept the maximum depth the whale can dive.
     * @param foodType the food type of the whale.
     */
    public Whale(Point location, double totalDistance, String name, Gender gender, double weight, double speed,Medal [] medals, double diveDept, String foodType,int size, int id, ILocation loc,Orientation orientation,int maxEnergy,int energyPerMeter,CompetitionPanel pan) {
        super(location, totalDistance, name, gender, weight, speed,medals, diveDept,size, id,  loc,orientation,maxEnergy,energyPerMeter, pan);
        this.setMedal(medals); 
        this.foodType = foodType;
    } 

    public Whale(String name, int speed, int energyAmount) {
        super(name, speed, energyAmount);
        setType("Whale");
    }
    private void loadWhaleImage() {
        try {
            whaleImage = ImageIO.read(new File(WHALE_IMAGE_PATH));
            if ( whaleImage== null) {
                System.out.println("Image could not be read.");
            }
        } catch (IOException e) {
            System.out.println("Cannot load cat image");
        }
    }
    @Override
    public void drawObject(Graphics g) {
        if (whaleImage != null) {
            g.drawImage(whaleImage,  location.getX(), location.getY()-size/10, size*2, size, pan);
        } else {
            System.out.println("Cat image not loaded");
        }
    }
    /**
     * Gets the food type of the whale.
     * @return the food type.
     */
    public String getfoodType() {
        return foodType;
    }
    
    /**
     * Sets the food type of the whale.
     * @param foodType the new food type.
     */
    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }
    /**
     * Returns the unique sound of the whale.
     * @Override
     * @return the sound of the whale.
     */
    
    protected String getSound() {
        return " Splash " ;
    }
    /**
     * Returns a string representation of the whale.
     * @Override
     * @return a string representation of the whale.
     */
    
    public String toString() {
        return "Whale: " +
                super.toString() +
                ", foodType: '" + getfoodType();
    }

    /**
     * Checks if this whale is equal to another object.
     * @Override
     * @param other the object to compare to.
     * @return true if the objects are equal, false otherwise.
     */
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!super.equals(other))
            return false;
        if (!(other instanceof Whale))
            return false;
        
        return foodType == ((Whale)other).foodType;
    }
    
    
}
