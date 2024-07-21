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
 * Class representing a pigeon, an air animal.
 */
public class Pigeon extends AirAnimal{
	private String family;// The family of the pigeon
    private BufferedImage pigeonImage; // Image of the cat
    private static final String PIGEON_IMAGE_PATH = "C:\\Users\\Student\\Downloads\\GUI\\graphics2 (1)\\graphics2\\pigeon.png"; // Path to the cat image

    /**
     * Default constructor for Pigeon.
     * Initializes fields with default values.
     * @param zooPanel 
     * @param energyPerMeter 
     * @param maxEnergy 
     * @param speed 
     * @param weight 
     * @param name 
     */
    public Pigeon(String name, double weight, double speed, int maxEnergy, int energyPerMeter, ZooPanel zooPanel) {
        super(new Point(0, 0), 0, "Pigeon", Gender.MALE, 0.3, 60.0,new Medal(), 0.75);
        this.family = "Aptenodytes";
        
    }
	

    /**
     * Constructor for Pigeon with parameters.
     * @param location the initial location of the pigeon.
     * @param totalDistance the total distance the pigeon has flown.
     * @param name the name of the pigeon.
     * @param gender the gender of the pigeon.
     * @param weight the weight of the pigeon.
     * @param speed the speed of the pigeon.
     * @param wingspan the wingspan of the pigeon.
     * @param family the family of the pigeon.
     */
    public Pigeon(Point location, double totalDistance, String name, Gender gender, double weight, double speed,Medal [] medals, String family,double wingspan,int size, int id, ILocation loc,Orientation orientation,int maxEnergy,int energyPerMeter,CompetitionPanel pan) {
        super(location, totalDistance, name, gender, weight, speed,medals, wingspan, size,  id,  loc, orientation,maxEnergy,energyPerMeter,pan);
        this.family = family;
        this.setMedal(medals); 
    }
    public Pigeon(String name, int speed, int energyAmount) {
        super(name, speed, energyAmount);
        setType("Pigeon");
    }
    private void loadPigeonImage() {
        try {
            pigeonImage = ImageIO.read(new File(PIGEON_IMAGE_PATH));
            if (pigeonImage == null) {
                System.out.println("Image could not be read.");
            }
        } catch (IOException e) {
            System.out.println("Cannot load cat image");
        }
    }
    @Override
    public void drawObject(Graphics g) {
        if (pigeonImage != null) {
            g.drawImage(pigeonImage,  location.getX(), location.getY()-size/10, size*2, size, pan);
        } else {
            System.out.println("Cat image not loaded");
        }
    }
    /**
     * Gets the family of the pigeon.
     * @return the family.
     */
	public String getFamily() {
		return family;
	}
	
    /**
     * Returns the sound the pigeon makes.
     *@Override
     * @return the sound "Arr-rar-rar-rar-raah".
     */
	protected String getSound() {
		return " Arr-rar-rar-rar-raah "; 
	}
	
	
    /**
     * Returns a string representation of the pigeon.
     *@Override
     * @return a string representation including all fields.
     */
    public String toString() {
        return "Pigeon: " +
                super.toString() +
                ", family: " + getFamily();
             
    }
    /**
     * Compares this pigeon to another object for equality.
     *@Override
     * @param other the object to compare to.
     * @return true if the objects are equal, false otherwise.
     */
    
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!super.equals(other))
            return false;
        if (!(other instanceof Pigeon))
            return false;
     
        return ((Pigeon) other).family == family;
    }
	
}
