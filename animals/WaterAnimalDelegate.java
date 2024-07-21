package animals;

import Olympics.Medal;
import animals.Animal.Gender;
import mobility.Point;

public class WaterAnimalDelegate implements IWaterAnimal{
	private Animal animal;
	private double diveDept; // The maximum depth the water animal can dive
	private static final double MAX_DIVE = -800 ;// The maximum allowed dive depth
    public WaterAnimalDelegate(Animal animal) {
        this.animal = animal;
    }
	public WaterAnimalDelegate() {
	}

	public WaterAnimalDelegate(Point location, double totalDistance, String name, Gender gender, double weight,
			double speed, Medal[] medals, double diveDept2, String areaOfLiving) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getdiveDept() {
		return diveDept;
	}

	@Override
	public void Dive(double depth) {
        if (depth <= MAX_DIVE) {
            System.out.println(animal.getName() + " is diving to " + depth + " meters.");
        } else {
            System.out.println(animal.getName() + " cannot dive deeper than " + MAX_DIVE + " meters.");
        }
	}
	
    public String toString() {
        return "WaterAnimalD{" +
                super.toString() +
                ", diveDept: " + getdiveDept() +
                '}';
    }
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!super.equals(other))
            return false;
        if (!(other instanceof WaterAnimalDelegate))
            return false;
        return diveDept == ((WaterAnimalDelegate) other).getdiveDept();
    }

}
