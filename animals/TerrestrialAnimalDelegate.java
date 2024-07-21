package animals;

import Olympics.Medal;
import animals.Animal.Gender;
import mobility.Point;

public class TerrestrialAnimalDelegate implements ITerrestrialAnimals {

	private int noLegs;
	private Animal animal;
    public TerrestrialAnimalDelegate(Animal animal) {
        this.animal = animal;
    }
	public TerrestrialAnimalDelegate() {
		
	}
	public TerrestrialAnimalDelegate(Point location, double totalDistance, String name, Gender gender, double weight,
			double speed, Medal[] medals, double diveDept, String areaOfLiving) {
		// TODO Auto-generated constructor stub
	}
	public int getNoLegs() {
		// TODO Auto-generated method stub
		return noLegs;
	}
	public String toString() {
        return "TerrestrialAnimalsD{" +
                super.toString() +
                ", noLegs: " + getNoLegs() +
                '}';
 }
	 public boolean equals(Object other) {
		 
	     if (this == other)
	         return true;
	     if (!super.equals(other))
	         return false;
         if (!(other instanceof TerrestrialAnimalDelegate))
             return false;
	 return getNoLegs() ==((TerrestrialAnimalDelegate) other).getNoLegs();
	    }


}
