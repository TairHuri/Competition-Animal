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
import mobility.ILocation;
import mobility.Point;

/**
 * Class representing a snake.
 */
public class Snake extends TerrestrialAnimals implements IReptile{
	private Poisonous poisonous;// The poisonous level of the snake
	private double length; // The length of the snake
    private BufferedImage snakeImage; // Image of the cat
    private static final String SNAKE_IMAGE_PATH = "C:\\Users\\Student\\Downloads\\GUI\\graphics2 (1)\\graphics2\\snake2.png"; // Path to the cat image

    /**
     * Enum representing the poisonous level of the snake.
     */
	public enum Poisonous{LOW,BENONI, HIGH}
	
    /**
     * Default constructor for Snake.
     * Initializes fields with default values.
     */

    /**
     * Constructor with parameters for Snake.
     * 
     * @param location     the initial location of the snake.
     * @param totalDistance  the total distance the snake has moved.
     * @param name         the name of the snake.
     * @param gender       the gender of the snake.
     * @param weight       the weight of the snake.
     * @param speed        the speed of the snake.
     * @param position     the current position of the snake.
     * @param poisonous    the poisonous level of the snake.
     * @param length       the length of the snake.
     */
    public Snake(Point location, double totalDistance, String name, Gender gender, double weight, double speed,Medal[] medals, int noLegs,Poisonous poisonous, double length,int size, int id, ILocation loc,Orientation orientation,int maxEnergy,int energyPerMeter,CompetitionPanel pan) {
        super(location, totalDistance, name, gender, weight, speed,medals, noLegs,size,  id, loc, orientation,maxEnergy,energyPerMeter, pan);
        this.poisonous = poisonous;
        this.length = length;
        this.setMedal(medals); 
    }
	
    public Snake(String name, double weight, double speed, int maxEnergy, int energyPerMeter, ZooPanel zooPanel) {
		// TODO Auto-generated constructor stub
    	super(name, speed, speed, energyPerMeter, energyPerMeter, zooPanel);
	}
    
    public Snake(String name, int speed, int energyAmount) {
        super(name, speed, energyAmount);
        setType("Snake");
    }
    private void loadSnakeImage() {
        try {
            snakeImage = ImageIO.read(new File(SNAKE_IMAGE_PATH));
            if (snakeImage == null) {
                System.out.println("Image could not be read.");
            }
        } catch (IOException e) {
            System.out.println("Cannot load cat image");
        }
    }
    @Override
    public void drawObject(Graphics g) {
        if (snakeImage != null) {
            g.drawImage(snakeImage,  location.getX(), location.getY()-size/10, size*2, size, pan);
        } else {
            System.out.println("Cat image not loaded");
        }
    }
	/**
     * Gets the poisonous level of the snake.
     * 
     * @return the poisonous level.
     */
	public Poisonous getPoisonous() {
		return poisonous; 
	}
	
    /**
     * Sets the poisonous level of the snake.
     * 
     * @param poisonous the new poisonous level.
     */
    protected void setPoisonous(Poisonous poisonous) {
        this.poisonous = poisonous;
    }
    
    /**
     * Gets the length of the snake.
     * 
     * @return the length of the snake.
     */
    public double getLength() {
        return length;
    }
    
    /**
     * Sets the length of the snake.
     * 
     * @param length the new length.
     */
    public void setLength(double length) {
        this.length = length;
    }
    /**
     * Returns the sound the snake makes.
     *@Override
     * @return the sound "ssssssss".
     */
    protected String getSound() {
    	return " ssssssss ";
    }
    /**
     * Returns a string representation of the snake.
     *@Override
     * @return a string representation including all fields.
     */
    public  String toString() {
        return "Snake: " + super.toString()
        +   ", length: " + getLength() 
        + ", ifPoisonous: " + getPoisonous();
    }
    /**
     * Compares this snake to another object for equality.
     *@Override
     * @param other the object to compare to.
     * @return true if the objects are equal, false otherwise.
     */
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!super.equals(other))
            return false;
        if (!(other instanceof Snake))
            return false;
        return getPoisonous() == ((Snake) other).getPoisonous() && getLength() == ((Snake) other).getLength();
    }
    /**
     * Implementation of the speedUp method from the IReptile interface.
     * Speeds up the snake, but not beyond the maximum speed.
     * @Override
     * @param speed the amount to speed up.
     * @return true if the speed was increased, false otherwise.
     */
   
    public boolean speedUp(int speed) {
        double currentSpeed = getSpeed();
        if (currentSpeed + speed <= IReptile.MAX_SPEED) {
            setSpeed(currentSpeed + speed);
            return true;
        } else {
            setSpeed(IReptile.MAX_SPEED);
            return false;
        }
    }

}
