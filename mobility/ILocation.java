package mobility;

/**
 * The ILocatable interface defines methods for getting and setting location.
 */
public interface ILocation {	
    /**
     * Gets the current location.
     * @return the current location.
     */
	public Point getLocation();
    /**
     * Sets the current location.
     * @param point the new location.
     * @return true if the location was set successfully, false otherwise.
     */
	Boolean setLocation(Point point);
}
