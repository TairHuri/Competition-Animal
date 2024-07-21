package mobility;



/**
 * The Point class represents a point in a 2D space with non-negative coordinates.
 */
public class Point implements Cloneable  {
	private int x;// x coordinate
	private int y;// y coordinate
    public static final int min_x=0;
    public static final int max_x=800;
    public static final int min_y=0;
    public static final int max_y=600;

    /**
     * Default constructor for Point.
     * Initializes the point at (0, 0).
     */
	public Point() {
		this.x = 0;
		this.y = 0;
	}
    /**
     * Copy constructor for Point.
     * Creates a new Point object with coordinates copied from another Point object.
     *
     * @param other the other Point object to copy from.
     */
    public Point(Point other) {
        this.x = other.x;
        this.y = other.y;
    }
	
    /**
     * Constructor with parameters.
     * @param x the x coordinate.
     * @param y the y coordinate.
     * @throws IllegalArgumentException if coordinates are negative.
     */
	public Point(int x, int y) {
		if(x >= 0 && y >= 0) {
			this.x = x;
			this.y = y;
		}
		else {
            throw new IllegalArgumentException("Coordinates must be non-negative.");
        }			

	}
	
    /**
     * Gets the x coordinate.
     * return the x coordinate.
     */
	public int getX() {return x;}
	
    /**
     * Gets the y coordinate of the point.
     *
     * @return the y coordinate.
     */
	public int getY() {return y;}
	
    /**
     * Sets the x coordinate.
     * @param x the x coordinate.
     * @return true if the coordinate is set successfully, false otherwise.
     */
    public boolean setx(int x)
    {
        if(x<min_x || x>max_x)
            return false;

        this.x=x;
        return true;
    }
	
    /**
     * Sets the y coordinate.
     * @param y the y coordinate.
     * @return true if the coordinate is set successfully, false otherwise.
     */
    public boolean sety(int y)
    {
        if(y<min_y||y>max_y)
            return false;

        this.y=y;
        return true;
    }
	 
    public boolean setpoint(int x,int y)
    {
        if(!checkBoundaries(new Point(x,y)))
            return false;

        this.x=x;
        this.y=y;

        return true;
    }
    public boolean setpoint(Point other)
    {
        if(!checkBoundaries(other))
            return false;

        this.x=other.x;
        this.y=other.y;

        return true;
    }
    public static boolean checkBoundaries(Point p) { return p.x >= min_x && p.x <= max_x && p.y >= min_y && p.y <= max_y;}
	    /**
	     * Returns a string representation of the point.
	     * @return a string representation of the point.
	     *  @Override
	     */
	public String toString() {
	        return "Point{" +
	                "x=" + x +
	                ", y=" + y +
	                '}';
	}
	
    /**
     * Checks if this point is equal to another object.
     * @param obj the other object.
     * @return true if they are equal, false otherwise.
     * @Override
     */
	public boolean equals(Object other) {
		boolean ans = false;
		if(other instanceof Point) {
			ans = (x == ((Point)other).x && y == ((Point)other).y);
		}
		return ans;
	}
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}//class Point





