
package Olympics;

/**
 * The Medal class represents a medal with its type, tournament, and year.
 */

public class Medal{
    
	private TypesOfMedals typeMedal;// Type of the medal (GOLD, SILVER, BRONZE)
	private String tournament;// The tournament where the medal was won
	private int year;// The year the medal was won
	
	public enum TypesOfMedals {BRONZE, SILVER, GOLD} 
	
	 /**
     * Default constructor setting default values.
     */
	public Medal() {
        this.typeMedal = TypesOfMedals.GOLD;
        this.tournament = "World war";
        this.year = 2021;
	}
    /**
     * Constructor with parameters.
     * @param type the type of the medal.
     * @param tournament the tournament where the medal was won.
     * @param year the year the medal was won.
     */
	public Medal(TypesOfMedals type, String tournament, int year) {
        this.typeMedal = type;
        this.tournament = tournament;
        this.year = year;
     }
    /**
     * Gets the year the medal was won.
     * @return the year.
     */
	public int getYear() {
		return year;
	}
    /**
     * return the type of the medal.
     */
	public TypesOfMedals getType() {
	        return typeMedal;
	}
	
    /**
     * Gets the tournament where the medal was won.
     * return the tournament.
     */
    public String getTournament() {
        return tournament;
    }
    
    /**
     * Copy constructor.
     * param other the medal to copy from.
     */
    public Medal(Medal other) {
        this.typeMedal = other.typeMedal;
        this.tournament = other.tournament;
        this.year = other.year;
    }
    
    /**
     * Checks if this medal is equal to another object.
     * param other object.
     * return true if they are equal, false otherwise.
     */
    public boolean equals(Object other) {
    	if(this == other) 
    		return true;
    	return ((other instanceof Medal ) && (typeMedal == ((Medal)other).getType()) &&
    			(tournament == ((Medal)other).getTournament()) && (year == ((Medal)other).getYear())); 			
    }
    
    /**
     * Returns a string representation of the medal.
     */
    public String toString() {
    	return "Medal type: " + getType()  
    			+", Tournament: " + getTournament()
    			+", Year: " + getYear() ;
    }
}//class Medal