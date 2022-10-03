import java.io.Serializable;

public class YoungHuman implements Comparable , Cloneable, Serializable{
	//YoungHuman x is less than YoungHuman y if x's birthday is before y's ( x is older than y )
	private Weight currentWeight;
	private Date birthDate;
	private Date lastCheckUpDate;
	private String firstName;
	private String lastName;
	
	// constructor
	public YoungHuman(Weight weight, Date birthDate, 
			String firstName, String lastName) {
		this.currentWeight = weight.clone();
		this.birthDate = birthDate.clone();
		this.lastCheckUpDate = null;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	// copy constructor
	private YoungHuman(YoungHuman toCopy) {
		this.currentWeight = toCopy.currentWeight.clone();
		this.birthDate = toCopy.birthDate.clone();
		if(toCopy.lastCheckUpDate != null)
			this.lastCheckUpDate = toCopy.lastCheckUpDate.clone();
		this.firstName = toCopy.firstName;
		this.lastName = toCopy.lastName;
	}
	
	/**
	 * getBirthDate
	 * -----------
	 * PRE: YoungHuman is not null
	 * POST: returns the date of the YoungHuman's birthday
	 */
	public Date getBirthDate() {
		return this.birthDate.clone();
	}
	
	/**
	 * getLastCheckUpDate
	 * -----------
	 * PRE: YoungHuman is not null
	 * POST: Returns the date of the last check up if there is one. If there isn't returns null
	 */
	public Date getLastCheckUpDate() {
		if(this.lastCheckUpDate != null)
			return this.lastCheckUpDate.clone();
		else
			return null;
	}
	
	/**
	 * getName
	 * -----------
	 * PRE: YoungHuman is not null
	 * POST: Returns the string of YoungHuman's name. ex. "Parth Gupta"
	 */
	public String getName() {
		return this.firstName + " " + this.lastName;
	}
	
	/**
	 * hasHadCheckUp
	 * -----------
	 * PRE: YoungHuman is not null
	 * POST: Returns true if YoungHuman has had a check-up. False if not
	 */
	public boolean hasHadCheckUp() {
		if(this.lastCheckUpDate != null)
			return true;
		return false;
	}
	
	/**
	 * setCheckUp
	 * -----------
	 * PRE: YoungHuman is not null
	 * POST: sets the lastCheckUpDate to the passed date
	 */
	public void setCheckUp(Date dateOfCheckUp) {
		if(this.birthDate.compareTo(dateOfCheckUp) == -1)
			this.lastCheckUpDate = dateOfCheckUp.clone();
		else {
			System.out.println("Given check-up date is before the birth-date. Check-up date was not changed.");
		}
	}
	
	/**
	 * unsetCheckUp
	 * -----------
	 * PRE: YoungHuman is not null
	 * POST: Sets lastCheckUpDate to null
	 */
	public void unsetCheckUp() {
		this.lastCheckUpDate = null;
	}
	
	/**
	 * setBirthDate
	 * -----------
	 * PRE: YoungHuman is not null
	 * POST: Sets the YoungHuman's birthday to the passed date
	 */
	public void setBirthDate(Date birthDate) {
		if(birthDate.compareTo(Date.currentDate) == -1)
			this.birthDate = birthDate.clone();
		else
			System.out.println("Given birth-date was not in correct range. Birth-Date was not changed.");
	}
	
	/**
	 * setWeight
	 * -----------
	 * PRE: YoungHuman is not null
	 * POST: Sets YoungHuman's weight to the passed weight
	 */
	public void setWeight(Weight amount) {
		this.currentWeight = amount.clone();
	}
	
	/**
	 * getWeight
	 * ----------- 
	 * PRE: YoungHuman is not null
	 * POST: Returns the weight of the YoungHuman 
	 */
	public Weight getWeight() {
		return this.currentWeight.clone();
	}
	
	/**
	 * setName
	 * -----------
	 * PRE: YoungHuman is not null
	 * POST: Sets the name of the YoungHuman to the passed strings. (firstName, lastName)
	 */
	public void setName(String first, String last) {
		this.firstName = first;
		this.lastName = last;
		
	}
	
	/**
	 * toString
	 * -----------
	 * PRE: YoungHuman is not null
	 * POST: Returns a string representation of the YoungHuman. ex. "Parth Gupta, 2 lbs. 5 oz. birth date: 11/11/2020, last check-up: 1/1/2021"
	 */
	public String toString() {
		if(this.hasHadCheckUp())
			return this.getName() + ", " + this.currentWeight.toString() 
				+ " birth date: " + this.birthDate.toString() + ", last check-up: " 
					+ this.lastCheckUpDate.toString();
		else
			return this.getName() + ", " + this.currentWeight.toString() 
			+ " birth date: " + this.birthDate.toString() + ", has not had a check-up";
	}
	
	/**
	 * equals
	 * -----------
	 * PRE: YoungHuman and parameter are not null
	 * POST: Returns true if parameter has the same attributes as the YoungHuman. Returns false if not
	 */
	public boolean equals(Object other) {
		if(!(other instanceof YoungHuman))
			return false;
		YoungHuman otherYoungHuman = (YoungHuman)other;
		if(this.currentWeight.equals(otherYoungHuman.currentWeight) &&
				this.birthDate.equals(otherYoungHuman.birthDate) &&
				this.firstName.equals(otherYoungHuman.firstName) &&
				this.lastName.equals(otherYoungHuman.lastName)) {
			if(this.birthDate == null && otherYoungHuman.birthDate == null)
				return true;
			else if(this.birthDate.equals(otherYoungHuman.birthDate))
				return true;
		}
		return false;
	}
	
	/**
	 * clone
	 * -----
	 * Returns a deep copy of YoungHuman
	 */
	@Override
	public YoungHuman clone() {
		return new YoungHuman(this.currentWeight, this.birthDate, this.firstName, this.lastName);
	}
	
	/**
	 * compareTo
	 * ---------
	 * PRE: o is not null
	 * POST: returns -2 if o is not of type YoungHuman,
	 * 		 return -1 if this YoungHuman is older than other YoungHuman
	 * 		 returns 0 if birth-dates are equal
	 * 		 returns 1 if this YoungHuman is younger than other YoungHuman
	 */
	@Override
	public int compareTo(Object o) {
		if(o.getClass() != this.getClass())
			return -2;
		YoungHuman other = (YoungHuman) o;
		if(this.equals(other))
			return 0;
		if(this.birthDate.compareTo(other.birthDate) == -1)
			return -1;
		return 1;
	}
}
