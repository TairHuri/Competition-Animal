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
 * Class representing a dog, a terrestrial animal.
 */
public class Dog extends TerrestrialAnimals {
	private String breed;// The breed of the dog
    private BufferedImage dogImage; // Image of the cat
    private static final String DOG_IMAGE_PATH = "C:\\Users\\Student\\Downloads\\GUI\\graphics2 (1)\\graphics2\\dog1.png"; // Path to the cat image

    /**
     * Default constructor for Dog.
     * Initializes fields with default values.
     * @param zooPanel 
     * @param energyPerMeter 
     * @param maxEnergy 
     * @param speed 
     * @param weight 
     * @param name 
     */
	public Dog(String name, double weight, double speed, int maxEnergy, int energyPerMeter, ZooPanel zooPanel) {

    	super(name, speed, speed, energyPerMeter, energyPerMeter, zooPanel);
        this.breed ="Racial";
	}
	
    /**
     * Constructor with parameters for Dog.
     * 
     * @param location       the initial location of the dog.
     * @param totalDistance  the total distance the dog has moved.
     * @param name           the name of the dog.
     * @param gender         the gender of the dog.
     * @param weight         the weight of the dog.
     * @param speed          the speed of the dog.
     * @param position       the current position of the dog.
     * @param noLegs         the number of legs the dog has.
     * @param breed          the breed of the dog.
     */
    public Dog(Point location, double totalDistance, String name, Gender gender, double weight, double speed,Medal[] medals,  int noLegs, String breed,int size, int id, ILocation loc,Orientation orientation,int maxEnergy,int energyPerMeter,CompetitionPanel pan ) {
        super(location, totalDistance, name, gender, weight, speed,medals, noLegs,size, id,loc,orientation,maxEnergy,energyPerMeter, pan);
        this.breed = breed;
        this.setMedal(medals); 
    }
    
    public Dog(String name, int speed, int energyAmount) {
        super(name, speed, energyAmount);
        setType("Dog");
    }
    
    /**
     * Gets the breed of the dog.
     * 
     * @return the breed of the dog.
     */
    public String getBreed() {
        return breed;
    }
    /**
     * Returns the sound the dog makes.
     *@Override
     * @return the sound "Woof Woof".
     */
    
    protected String getSound() {
        return "Woof Woof";
    }
    /**
     * Returns a string representation of the dog.
     * @Override
     * @return a string representation including all fields.
     */
   
    public String toString() {
        return "Dog: " + super.toString()
        +   ", breed: " + getBreed();
    }
    /**
     * Compares this dog to another object for equality.
     *@Override
     * @param obj the object to compare to.
     * @return true if the objects are equal, false otherwise.
     */
    private void loadDogImage() {
        try {
            dogImage = ImageIO.read(new File(DOG_IMAGE_PATH));
            if (dogImage == null) {
                System.out.println("Image could not be read.");
            }
        } catch (IOException e) {
            System.out.println("Cannot load cat image");
        }
    }
    @Override
    public void drawObject(Graphics g) {
        if (dogImage != null) {
            g.drawImage(dogImage,  location.getX(), location.getY()-size/10, size*2, size, pan);
        } else {
            System.out.println("Cat image not loaded");
        }
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof Dog))
            return false;
        Dog other = (Dog) obj;
        return getNoLegs() == other.getNoLegs() && getBreed().equals(other.getBreed());
    }
}
