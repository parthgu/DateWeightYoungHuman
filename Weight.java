import java.io.Serializable;

public class Weight implements Comparable, Cloneable, Serializable{
	
	private int lbs;
	private int ounces;
	
	// no arg constructor
	public Weight() {
		this.lbs = 0;
		this.ounces = 0;
	}
	
	// one arg constructor
	public Weight(int lbs) {
		if(!(lbs < 0))
			this.lbs = lbs;
		else {
			System.out.println("Error: Given weight is under 0. Weight is set to 0.");
			this.lbs = 0;
		}
	}
	
	// constructor
	public Weight(int lbs, int ounces) {
		int ouncesInPounds = ounces / 16;
		lbs += ouncesInPounds;
		ounces %= 16;
		if(ounces < 0) {
			lbs -= 1;
			ounces = 16 + ounces;
		}
		
		if(!(lbs < 0)) {
			this.lbs = lbs;
			this.ounces = ounces;
		}
		else {
			System.out.println("Error: Given weight is under 0. Weight is set to 0.");
			this.lbs = 0;
			this.ounces = 0;
		}
			

	}
	
	// copy constructor
	private Weight(Weight other) {
		this(other.lbs, other.ounces);
	}

	/**
	 * getLbs
	 * -----------
	 * PRE: Weight is not null
	 * POST: Returns lbs as an integer
	 */
	public int getLbs() {
		return lbs;
	}

	/**
	 * setLbs
	 * -----------
	 * PRE: Parameter is positive
	 * POST: Sets lbs to the passed integer
	 */
	public void setLbs(int lbs) {
		if(lbs >= 0) {
			this.lbs = lbs;
		}
		else {
			System.out.println("Given weight less than 0. Did not set weight.");
		}
	}

	/**
	 * getOunces
	 * -----------
	 * PRE: Weight is not null
	 * POST: Returns ounces as an integer
	 */
	public int getOunces() {
		return ounces;
	}

	/**
	 * setOunces
	 * -----------
	 * PRE: The parameter in ounces combined with lbs is positive
	 * POST: Sets ounces to the passed integer
	 */
	public void setOunces(int ounces) {
		int ouncesInPounds = ounces / 16;
		if(ouncesInPounds + this.lbs < 0) {
			System.out.println("Given weight result in weight below 0. Did not change weight.");
			return;
		}
		if(ounces < 0) {
			this.lbs -= 1;
			this.ounces = 16 - ounces;
		}
		else {
			this.lbs += ouncesInPounds;
			this.ounces = ounces % 16;
		}
	}
	
	/**
	 * setWeight
	 * -----------
	 * PRE: lbs and ounces combined must be positive
	 * POST: sets weight's lbs and ounces in simplified version
	 */
	public void setWeight(int lbs, int ounces) {
		int ouncesInPounds = ounces / 16;
		lbs += ouncesInPounds;
		ounces %= 16;
		if(ounces < 0) {
			lbs -= 1;
			ounces = 16 + ounces;
		}
		
		if(lbs >= 0) {
			this.lbs = lbs;
			this.ounces = ounces;
		}
		else {
			System.out.println("Given weight result in weight below 0. Did not change weight.");
		}
	}
	
	/**
	 * getWeight
	 * -----------
	 * PRE: Weight is not null
	 * POST: returns double of weight in lbs
	 */
	public double getWeight() {
		return Double.valueOf(this.lbs) + (Double.valueOf(this.ounces) / 16);
	}
	
	/**
	 * add (one arg)
	 * -----------
	 * PRE: Parameter combined with current weight must be positive
	 * POST: Current weight will add the passed parameter (lbs)
	 */
	public void add(int lbs) {
		if(this.lbs + lbs >= 0) {
			this.lbs += lbs;
		}
		else {
			System.out.println("Added weight combines for under 0. Did not add weight.");
		}
		
	}
	
	/**
	 * add (two args)
	 * -----------
	 * PRE: Parameter combined with current weight must be positive
	 * POST: Current weight will add the passed parameters
	 */
	public void add(int lbs, int ounces) {
		int ouncesInPounds = ounces / 16;
		lbs += ouncesInPounds;
		ounces %= 16;
		if(ounces < 0) {
			lbs -= 1;
			ounces = 16 + ounces;
		}
		
		if(this.lbs + lbs >= 0) {
			this.lbs += lbs;
			this.ounces += ounces;
		}
	}
	
	/**
	 * add(Weight)
	 * -----------
	 * PRE: other is not null
	 * POST: adds the other weight onto this instance's weight
	 */
	public void add(Weight other) {
		this.add(other.lbs, other.ounces);
	}
	
	/**
	 * equals
	 * -----------
	 * PRE: This weight and parameter must not be null
	 * POST: Returns true if weights are equal, returns false if not equal
	 */
	public boolean equals(Weight other) {
		if(this.lbs == other.lbs &&
				this.ounces == other.ounces)
			return true;
		else
			return false;
	}
	
	/**
	 * toString
	 * -----------
	 * PRE: Weight is not null
	 * POST: Returns string form of weight. ex. "5 lbs. 14 oz."
	 */
	public String toString() {
		return this.lbs + " lbs. " + this.ounces + " oz.";
	}
	
	/**
	 * clone
	 * -----
	 * Returns deep copy of Weight
	 */
	@Override
	public Weight clone() {
		return new Weight(this.lbs, this.ounces);
	}
	
	/**
	 * compareTo
	 * ---------
	 * PRE: o is not null
	 * POST: returns -2 if o is not of type Weight,
	 * 		 return -1 if this weight less than other weight
	 * 		 returns 0 if weights are equal
	 * 		 returns 1 if this weight is greater than other weight
	 */
	@Override
	public int compareTo(Object o) {
		if(o.getClass() != this.getClass())
			return -2;
		Weight other = (Weight) o;
		if(this.equals(other))
			return 0;
		if(this.lbs < other.lbs)
			return -1;
		else if(this.lbs == other.lbs && this.ounces < other.ounces)
			return -1;
		return 1;
	}
}
