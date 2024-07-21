package mobility;
/**
 * The Mobile class is an abstract class representing an object that can move in space.
 */
public abstract class Mobile implements ILocation{
	
	private Point location; // Current location
	private double totalDistance ; // Distance the object traveled, [>0]
    /**
     * Default constructor for Mobile.
     * Initializes fields with default values.
     */
	public Mobile() {
		this.location = new Point(0,0);
		this.totalDistance = 0;
	}
	public Mobile(Point position) {
		this.location = new Point(0,0);
		this.totalDistance = 0;
	}
	
	   /**
     * Constructor with parameters.
     *
     * @param location     the initial location.
     * @param totalDistance the total distance traveled.
     */
	public Mobile(Point location, double totalDistance) {
		this.location = location;
		if(totalDistance > 0) {
		this.totalDistance = totalDistance;
		}
		
	} // Constructor(location)
	
    /**
     * Gets the total distance traveled by the mobile object.
     *
     * @return the total distance traveled.
     */
	public double getDistance() {
		return totalDistance;
	}
	
    /**
     * Gets the current location.
     * @return the current location.
     */
	public Point getLocation() {
		return location;
	}
	
    /**
     * Sets the location.
     * @param location the new location.
     * @return true if the location is set successfully, false otherwise.
     */
	public Boolean setLocation(Point location) {
		if(location != null) {
			double distance = calcDistance(location);
			this.location=location;
			addTotalDistance(distance);
			return true;
		}
		return false;
	}
	
	
    /**
     * Calculates the distance between the current location and another point.
     * @param point the other point.
     * @return the distance between the current location and the other point.
     */
	public double calcDistance(Point point) {
		if(point == null) {
			return 0;
		}
	    return Math.sqrt(Math.pow(point.getX() - this.location.getX(), 2) + Math.pow(point.getY() - this.location.getY(), 2));
	    }
		//Distance between object to the point move(Point): double – returns distance traveled (0 if non)
	
    /**
     * Adds distance to the total distance traveled.
     * param distance the distance to add.
     */
	public void addTotalDistance(double AddDistance) {
		if (AddDistance > 0) {
		this.totalDistance += AddDistance;
		// increases after movement
		}
	}
	
    /**
     * Moves to a new location.
     * param point the new location.
     * return the distance traveled.
     */
	public boolean move(Point Move) {
		double distance = calcDistance(Move);
		if(setLocation(Move)) {
			addTotalDistance(distance);
			return true;
		}
		return false;
	}
	
    /**
     * Returns a string representation of the mobile object.
     * return a string representation of the mobile object.
     * Override
     */
    
	public String toString() {
		  return "Mobile{" +
	                "location: " + getLocation() +
	                ", totalDistance: " + getDistance() +
	                '}';
	}
	
    /**
     * Checks if this object is equal to another object.
     * param other the other object.
     * return true if they are equal, false otherwise.
     * Override
     */
   
	public boolean equals(Object other) {
		if (!(other instanceof Mobile)) {
			return false;
		}
		
    return (location == (((Mobile)other).location) 
    		&& totalDistance ==((Mobile)other).totalDistance);
	}
}
	