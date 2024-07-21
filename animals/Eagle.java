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
 * Class representing an eagle, an air animal.
 */
public class Eagle extends AirAnimal {
	private double  altitudeOfFlight;// The flight altitude of the eagle
	private static final double MAX_ALTITUDE = 1000;// Maximum altitude the eagle can fly
    private BufferedImage eagleImage; // Image of the cat
    private static final String EAGLE_IMAGE_PATH = "C:\\Users\\Student\\Downloads\\GUI\\graphics2 (1)\\graphics2\\eagle1.png"; // Path to the cat image

    /**
     * Default constructor for Eagle.
     * Initializes fields with default values.
     * @param zooPanel 
     * @param energyPerMeter 
     * @param maxEnergy 
     * @param speed 
     * @param weight 
     * @param name 
     */
    public Eagle(String name, double weight, double speed, int maxEnergy, int energyPerMeter, ZooPanel zooPanel) {
        super(new Point(0, 100), 0, "Eagle", Gender.MALE, 6.0, 50.0,new Medal(), 2.0);
        this.altitudeOfFlight = 555;
    }

    /**
     * Constructor for Eagle with parameters.
     * @param location the initial location of the eagle.
     * @param totalDistance the total distance the eagle has flown.
     * @param name the name of the eagle.
     * @param gender the gender of the eagle.
     * @param weight the weight of the eagle.
     * @param speed the speed of the eagle.
     * @param wingspan the wingspan of the eagle.
     * @param altitudeOfFlight the flight altitude of the eagle.
     */
    public Eagle(Point location, double totalDistance, String name, Gender gender, double weight, double speed,Medal[] medals, double wingspan, double altitudeOfFlight,int size, int id, ILocation loc,Orientation orientation,int maxEnergy,int energyPerMeter,CompetitionPanel pan) {
        super(location, totalDistance, name, gender, weight, speed,medals, wingspan,size,id, loc, orientation, maxEnergy, energyPerMeter, pan);
        this.setMedal(medals); 
        if (altitudeOfFlight > MAX_ALTITUDE) {
        	this.altitudeOfFlight = MAX_ALTITUDE;
        }
        else {
        	this.altitudeOfFlight = altitudeOfFlight;
        }
    }
    public Eagle(String name, int speed, int energyAmount) {
        super(name, speed, energyAmount);
        setType("Eagle");
    }
    private void loadEagleImage() {
        try {
            eagleImage = ImageIO.read(new File(EAGLE_IMAGE_PATH));
            if (eagleImage == null) {
                System.out.println("Image could not be read.");
            }
        } catch (IOException e) {
            System.out.println("Cannot load cat image");
        }
    }
    @Override
    public void drawObject(Graphics g) {
        if (eagleImage != null) {
            g.drawImage(eagleImage,  location.getX(), location.getY()-size/10, size*2, size, pan);
        } else {
            System.out.println("Cat image not loaded");
        }
    }

    /**
     * Gets the flight altitude of the eagle.
     * @return the flight altitude.
     */
	public double getaltitudeOfFlight() {
		return altitudeOfFlight;
	}
	
    /**
     * Sets the flight altitude of the eagle.
     * Limits the altitude to the maximum allowed altitude.
     *
     * @param altitudeOfFlight the new flight altitude.
     */
    public void setAltitudeOfFlight(double altitudeOfFlight) {
        if (altitudeOfFlight > MAX_ALTITUDE) {
            this.altitudeOfFlight = MAX_ALTITUDE;
        } else {
            this.altitudeOfFlight = altitudeOfFlight;
        }
    }
    /**
     * Returns the sound the eagle makes.
     *@Override
     * @return the sound "Clack-wack-chack".
     */
    
	protected String getSound() {
		return " Clack-wack-chack ";
	}
	
    /**
     * Returns a string representation of the eagle.
     *@Override
     * @return a string representation including all fields.
     */
    
    public String toString() {
        return "Eagle: " +
                super.toString() +
                ", altitudeOfFlight: " + getaltitudeOfFlight();
             
    }

    /**
     * Compares this eagle to another object for equality.
     *@Override
     * @param other the object to compare to.
     * @return true if the objects are equal, false otherwise.
     */
    
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!super.equals(other))
            return false;
        if (!(other instanceof Eagle))
            return false;
     
        return ((Eagle) other).altitudeOfFlight == altitudeOfFlight;
    }

}
