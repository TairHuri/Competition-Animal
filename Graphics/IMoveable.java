package Graphics;

import mobility.Point;

public interface IMoveable {
	
    public String getAnimaleName();
	public double getSpeed();
	public boolean move(Point p);
}

