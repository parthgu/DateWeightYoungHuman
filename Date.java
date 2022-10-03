import java.io.Serializable;

public class Date implements Comparable, Cloneable, Serializable{
	private int month, year, day;
	
	public static final Date currentDate = new Date(4, 26, 2022); // final Date of the current date
	
	// no arg constructor
	public Date() {
		this.month = 4;
		this.year = 2022;
		this.day = 26;
	}
	
	// constructor
	public Date(int month, int day, int year) {
		if(month <= 12 && month >= 1) {
			this.month = month;
		}
		else {
			System.out.println("Invalid month given. Set month to 1");
			this.month = 1;
		}
		
		if(day <= 31 && day >= 1) {
			this.day = day;
		}
		else {
			System.out.println("Invalid day given. Set day to 1");
			this.day = 1;
		}
		
		if(year <= 2024 && year >= 2014) {
			this.year = year;
		}
		else {
			System.out.println("Invalid year given. Set year to 2014");
			this.year = 2014;
		}
	}

	// copy constructor
	private Date(Date other) {
		this(other.month, other.day, other.year);
	}
	
	
	/**
	 * getMonth
	 * -----------
	 * PRE: Date is not null.
	 * POST: returns the month of the date as an integer (1-12)
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * setMonth
	 * -----------
	 * PRE: Parameter is between 1-12
	 * POST: Sets the month of the date to the passed integer
	 */
	public void setMonth(int month) {
		if(month <= 12 && month >= 1) {
			this.month = month;
		}
		else {
			System.out.println("Invalid month given. Set month to 1");
			this.month = 1;
		}
	}

	/**
	 * getYear
	 * -----------
	 * PRE: Date is not null
	 * POST: Returns the year of the date (2014 - 2024)
	 */
	public int getYear() {
		return year;
	}

	/**
	 * setYear
	 * -----------
	 * PRE: Parameter is between 2014-2024
	 * POST: Sets the year of the date to the passed integer
	 */
	public void setYear(int year) {
		if(year <= 2024 && year >= 2014) {
			this.year = year;
		}
		else {
			System.out.println("Invalid year given. Set year to 2014");
			this.month = 2014;
		}
	}

	/**
	 * getDay
	 * -----------
	 * PRE: Date is not null
	 * POST: Returns the day of the month (1-31)
	 */
	public int getDay() {
		return day;
	}

	/**
	 * setDay
	 * -----------
	 * PRE: Parameter is between 1-31
	 * POST: Sets the day of the month to the passed integer
	 */
	public void setDay(int day) {
		if(day <= 31 && day >= 1) {
			this.day = day;
		}
		else {
			System.out.println("Invalid day given. Set day to 1");
			this.day = 1;
		}
	}
	
	/**
	 * equals
	 * -----------
	 * PRE: Date is not null
	 * POST: Returns true if the parameter is equal to the date, returns false if not equal
	 */
	public boolean equals(Object o) {
		if(!(o instanceof Date))
			return false;
		
		Date other = (Date)o;
		if(this.month == other.month &&
				this.day == other.day &&
				this.year == other.year)
			return true;
		else
			return false;
	}
	
	/**
	 * toString
	 * -----------
	 * PRE: Date is not null
	 * POST: returns string form of date. ex. "4/20/2022
	 */
	public String toString() {
		return this.month + "/" + this.day + "/" + this.year;
	}

	/**
	 * isEarlierThan
	 * -----------
	 * PRE: Date is not null, and parameter is not null
	 * POST: Returns true if parameter is after the Date, and returns false if parameter is before the date
	 */
	private boolean isEarlierThan(Date other) {
		if(this.year < other.year) {
			return true;
		}
		else if(this.month < other.month) {
			return true;
		}
		else if(this.day < other.day) {
			return true;
		}
			return false;
	}
	
	/**
	 * clone
	 * -----
	 * Returns a deep copy of the Date
	 */
	@Override
	public Date clone() {
		return new Date(this.month, this.day, this.year);
	}
	
	/**
	 * compareTo
	 * ---------
	 * PRE: o is not null
	 * POST: returns -2 if o is not of type Date,
	 * 		 return -1 if this date is before other date
	 * 		 returns 0 if dates are equal
	 * 		 returns 1 if this date is after other date
	 */
	@Override
	public int compareTo(Object o) {
		if(o.getClass() != this.getClass())
			return -2;
		Date other = (Date) o;
		if(this.equals(other))
			return 0;
		if(this.isEarlierThan(other))
			return -1;
		return 1;
	}
}
