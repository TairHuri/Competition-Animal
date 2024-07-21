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
 * Class representing a dolphin, a water animal.
 */
public class Dolphin extends WaterAnimal{
    /**
     * Enum representing the type of water the dolphin inhabits.
     */
	public enum WaterType {SEA, SWEET}
	
	private WaterType waterType;// The type of water the dolphin inhabits
    private BufferedImage dolphinImage; // Image of the cat
    private static final String DOLPHIN_IMAGE_PATH = "C:\\Users\\Student\\Downloads\\GUI\\graphics2 (1)\\graphics2\\dolphin1.png"; // Path to the cat image

    /**
     * Default constructor for Dolphin.
     * Initializes fields with default values.
     * @param zooPanel 
     * @param energyPerMeter 
     * @param maxEnergy 
     * @param speed 
     * @param weight 
     * @param name 
     */
	public Dolphin(String name, double weight, double speed, int maxEnergy, int energyPerMeter, ZooPanel zooPanel) {
        super(new Point(0, 50), 0, "Dolphin", Gender.FEMALE, 200.0, 20.0,new Medal(), 10.7);
        this.waterType = WaterType.SWEET;
	}
	
    /**
     * Constructor for Dolphin with parameters.
     * @param location the initial location of the dolphin.
     * @param totalDistance the total distance the dolphin has moved.
     * @param name the name of the dolphin.
     * @param gender the gender of the dolphin.
     * @param weight the weight of the dolphin.
     * @param speed the speed of the dolphin.
     * @param diveDept the maximum depth the dolphin can dive.
     * @param waterType the water type of the dolphin.
     */
    public Dolphin(Point location, double totalDistance, String name, Gender gender, double weight, double speed,Medal[] medals, double diveDept, WaterType waterType,int size, int id, ILocation loc,Orientation orientation,int maxEnergy,int energyPerMeter,CompetitionPanel pan) {
        super(location, totalDistance, name, gender, weight, speed,medals, diveDept,size, id,  loc,orientation,maxEnergy, energyPerMeter, pan);
        this.waterType = waterType;
        this.setMedal(medals); 
    }
    
    public Dolphin(String name, int speed, int energyAmount) {
        super(name, speed, energyAmount);
        setType("Dolphin");
    }
    private void loaddolphinImage() {
        try {
            dolphinImage = ImageIO.read(new File(DOLPHIN_IMAGE_PATH));
            if (dolphinImage == null) {
                System.out.println("Image could not be read.");
            }
        } catch (IOException e) {
            System.out.println("Cannot load cat image");
        }
    }
    @Override
    public void drawObject(Graphics g) {
        if (dolphinImage != null) {
            g.drawImage(dolphinImage,  location.getX(), location.getY()-size/10, size*2, size, pan);
        } else {
            System.out.println("Cat image not loaded");
        }
    }

    /**
     * Gets the water type of the dolphin.
     * @return the water type.
     */
    public WaterType getWaterType() {
        return waterType;
    }

    /**
     * Sets the water type of the dolphin.
     * @param waterType the new water type.
     */
    public void setWaterType(WaterType waterType) {
        this.waterType = waterType;
    }
    

    /**
     * Returns the sound the dolphin makes.
     *
     * @return the sound "Click-click".
     */
    protected String getSound() {
    	return " Click-click ";
    }
    
    /**
     * Returns a string representation of the dolphin.
     *@Override
     * @return a string representation including all fields.
     */
    
    public String toString() {
        return "Dolphin: " +
                super.toString() +
                ", WaterType: '" + getWaterType();
    }
    /**
     * Compares this dolphin to another object for equality.
     *@Override
     * @param other the object to compare to.
     * @return true if the objects are equal, false otherwise.
     */

    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!super.equals(other))
            return false;
        if (!(other instanceof  Dolphin))
            return false;
        
        return waterType == ((Dolphin)other).getWaterType();
    }

}

