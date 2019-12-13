import java.util.Date;

public class DriverLicense extends Card {
	private String expiration_year;

	public DriverLicense (String n, String expiration) {
		super (n);
		expiration_year = expiration;
	}

	public String format () {
		return super.format () + ", EXP: ";
	}

	public boolean isExpired () {
		int year = new Date ().getYear ();
		int exp_year = Integer.valueOf (expiration_year);

		return exp_year < year;
	}

	public String toString () {
		return this.getClass () + "[name=" + super.getName () + "][expiration=" + expiration_year + "]";
	}

	public boolean equals (Card other) {
		return this.toString ().equals (other.toString ());
	}
}
