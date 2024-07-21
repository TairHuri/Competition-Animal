package animals;
import java.awt.ComponentOrientation;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import Graphics.CompetitionPanel;
import Graphics.IAnimal;
import Graphics.IDrawable;
import Graphics.IMoveable;
import Olympics.Medal;
import animals.Animal.Orientation;
import mobility.ILocation;
import mobility.Mobile;
import mobility.Point;
/**
 * Abstract class representing an animal.
 */
public abstract class Animal extends Mobile implements ILocation, IAnimal, IClonable , IMoveable, IDrawable  {
    private String name;// The name of the animal
    private Gender gender;// The gender of the animal
    private double weight;// The weight of the animal
    private double speed;// The speed of the animal
    private Medal[] medals;// The medals won by the animal
    private String category;
    private String type;
    private IMoveable IM;
    private IDrawable ID;
    private IClonable IC;
    
	protected int size;
    private int id;
    
	private ILocation loc;
	
	public enum Orientation {EAST,SOUTH,WEST,NORTH}
	private Orientation orientation;
	private int maxEnergy;
	private int energyPerMeter;
	
	protected CompetitionPanel pan;
	private BufferedImage img1, img2, img3, img4;
    protected Point location;
	private double distance;
    protected int x;
    protected int y;
    protected String direction;
    protected String imageFilePath;
    private BufferedImage image; // Add image attribute
    
    
    /**
     * Enum representing the gender of the animal.
     */
    public enum Gender {MALE, FEMALE, HERMAPHRODITE}
    /**
     * Default constructor for Animal.
     * Initializes fields with default values.
     */
    public Animal() {
        super(new Point(0, 0), 0);
        this.name = "Dog";
        this.gender = Gender.MALE;
        this.weight = 55.5;
        this.speed = 0.0;
        this.medals = new Medal[0]; // Initialize with an empty array  
        this.size = 65; // Default size
        this.maxEnergy = 100; // Default max energy
    }
    
    public Animal(Point position) {
    	super(position);
        this.name = "Dog";
        this.gender = Gender.MALE;
        this.weight = 55.5;
        this.speed = 0.0;
        this.medals = new Medal[2]; // Initialize with an empty array
        medals[0] = new Medal(); // Initialize each medal with a default constructor
        medals[1] = new Medal(); 
    
    }
    
    /**
     * Constructor for Animal.
     * @param name the name of the animal
     * @param gender the gender of the animal
     * @param weight the weight of the animal
     * @param speed the speed of the animal
     * @param location the initial location of the animal
     * @param medals2 
     * @param position the position of the animal
     */
    public Animal(Point location ,double totalDistance , String name, Gender gender, double weight, double speed, Medal[] medals2,
    		int size, int id, ILocation loc,Orientation orientation,int maxEnergy,int energyPerMeter,CompetitionPanel pan ) {
        super(location,totalDistance);
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.speed = speed;
        this.medals = new Medal[0]; // Initialize with an empty array
        this.size = 65; // Default size
        this.id = id;
        this.loc = loc;
        this.orientation = orientation;
        this.maxEnergy = 100; // Default max energy
        this.energyPerMeter = energyPerMeter;
        this.pan = pan;
        this.location = location;
    }
    /**
     * Copy constructor for Animal.
     * @param other the Animal to copy from
     */
   
    public Animal(Animal other) {
        super(other.getLocation1(), other.getDistance());
        this.name = other.name;
        this.gender = other.gender;
        this.weight = other.weight;
        this.speed = other.speed;
        this.medals = new Medal[other.medals.length];
        for (int i = 0; i < other.medals.length; i++) {
            this.medals[i] = new Medal(other.medals[i]);
        }
        this.size = 65;
        this.id = other.id;
        this.loc = other.loc;
        this.orientation = other.orientation;
        this.maxEnergy = 100;
        this.energyPerMeter = other.energyPerMeter;
        this.pan = other.pan;
        this.location = other.location;
    }
    
    public Animal(String name, String category, String type, int speed, int energyAmount) {
        this.name = name;
        this.category = category;
        this.type = type;
        this.speed = speed;
        this.maxEnergy = energyAmount;
        this.distance = 0;
        this.energyPerMeter = 0;
    }


    /**
     * Sets the medals for the animal.
     *
     * @param medals the medals to set.
     */
    protected void setMedal(Medal []medals) {
        this.medals = new Medal[medals.length];
        for (int i = 0; i < medals.length; i++) {
            this.medals[i] = new Medal(medals[i]);
        }
    }

	/**
     * Gets the name of the animal.
     * @return the name of the animal.
     */
    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }
    // Get methods
    public int getSize() {
        return size;
    }
    public double getDistance() {
        return distance;
    }

    public int getId() {
        return id;
    }

    public ILocation getLoc() {
        return loc;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public double getEnergyPerMeter() {
        return energyPerMeter;
    }

    public CompetitionPanel getPan() {
        return pan;
    }

    public Point getLocation1() {
        return location;
    }
    /**
     * Gets the gender of the animal.
     * @return the gender of the animal.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Gets the weight of the animal.
     * @return the weight of the animal.
     */
    public double getWeight() {
        return weight;
    }
    
    
    public void setEnergyAmount(int energyAmount) {
        this.energyPerMeter = energyAmount;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
    
    public void setEnergyConsumption(int energyConsumption) {
        this.maxEnergy = energyConsumption;
    }
    /**
     * Gets the speed of the animal.
     * @return the speed of the animal.
     */
    public double getSpeed() {
        return speed;
    }
    /**
     * Sets the speed of the animal.
     *
     * @param speed the speed to set.
     */
    protected void setSpeed(double speed) {
    	this.speed = speed;
    }
	protected void setType(String type) {
		// TODO Auto-generated method stub
		this.type = type;
	}
    
    /**
     * Gets the medals of the animal.
     * return the medals of the animal.
     */
    public Medal[] getMedals() {
        return medals.clone();
    }
    
    /**
     * Makes the animal sound.
     */
    public final void makeSound() {
        System.out.println("Animal " + getName() + " said " + getSound());
    }
    
    /**
     * Gets the unique sound of the animal.
     * @return the sound of the animal
     */
    protected abstract String getSound();
    
    /**
     * Returns a string representation of the animal.
     *@Override
     * @return a string representation of the animal.
     */
    
    public String toString() {
        return "Animal " +
                "name: " + getName() +
                ", gender: " + getGender() +
                ", weight: " + getWeight() +
                ", speed: " + getSpeed() +
                ", medals: " + Arrays.toString(medals) +
                ", position: " + getLocation1() +
                "size: " + getSize() +
                ", id: '" + getId()  +
                ", loc: " + getLoc() +
                ", orientation: " + getOrientation() +
                ", maxEnergy: " + getMaxEnergy() +
                ", energyPerMeter: " + getEnergyPerMeter() +
                ", pan: " + getPan()  +
                ", location: " + getLocation1();
    }
    /**
     * Compares this animal to another object for equality.
     *
     * @param other the object to compare to.
     * @return true if the objects are equal, false otherwise.
     */
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!super.equals(other))
            return false;
        if (!(other instanceof Animal))
            return false;
       
        return ((name == ((Animal) other).getName()) &&
                gender == ((Animal) other).gender &&  weight == ((Animal) other).weight && speed == ((Animal) other).speed&& size == ((Animal) other).size && id == ((Animal) other).id && 
                loc == ((Animal) other).loc && orientation == ((Animal) other).orientation && maxEnergy == ((Animal) other).maxEnergy && energyPerMeter == ((Animal) other).energyPerMeter && pan == ((Animal) other).pan && location == ((Animal) other).location &&
                Arrays.equals(medals, ((Animal) other).medals));
    }
    public boolean eat(int energy) {
        if (energy <= 0) {
            return false;
        }
        maxEnergy = Math.min(maxEnergy + energy, maxEnergy);
        return true;
    }
    public String getAnimaleName() {
    	return name;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public Point getLocation() {
    	return loc.getLocation();
    }
	public Boolean setLocation(Point point) {
		if(location != null) {
			double distance = calcDistance(location);
			this.location=location;
			addTotalDistance(distance);
			return true;
		}
		return false;
	}
    

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

	
	 public boolean move(Point p) {
	        double distance = calcDistance(p);
	        double energyRequired = distance * energyPerMeter;
	        if (energyRequired <= maxEnergy) {
	            location = p;
	            maxEnergy -= energyRequired;
	            return true;
	        }
	        return false;
	 }
	 public void loadImages(String nm) {
	       try {
	            img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH + nm + "_east.png"));
	            img2 = ImageIO.read(new File(IDrawable.PICTURE_PATH + nm + "_south.png"));
	            img3 = ImageIO.read(new File(IDrawable.PICTURE_PATH + nm + "_west.png"));
	            img4 = ImageIO.read(new File(IDrawable.PICTURE_PATH + nm + "_north.png"));
	        } catch (IOException e) {
	            System.out.println("Cannot load images for " + nm);
	        }
	 }
	 public void drawObject (Graphics g)
	 {
	    if(orientation==Orientation.EAST) // animal move to the east side
	 	g.drawImage(img1, location.getX(), location.getY()-size/10, size*2, size, pan);
	 else if(orientation==Orientation.SOUTH) // animal move to the south side
	 	g.drawImage(img2, location.getX(), location.getY()-size/10, size, size, pan);
	 else if(orientation==Orientation.WEST) // animal move to the west side
	 	g.drawImage(img3, location.getX(), location.getY()-size/10, size*2, size, pan);
	    else if(orientation==Orientation.NORTH) // animal move to the north side
	 	g.drawImage(img4, location.getX()-size/2, location.getY()-size/10, size, size*2, pan);   
	 }

	public void setInitialLocation(Point initialLocation) {
		// TODO Auto-generated method stub
		
	}


    
}
