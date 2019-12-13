public class IDCard extends Card {
	private String id_number;

	public IDCard (String n, String id) {
		super (n);
		id_number = id;
	}

	public String format () {
		return super.format() + ", ID: " + id_number;
	}

	public String toString () {
		return this.getClass () + "[name=" + super.getName () + "][id=" + id_number + "]";
	}

	public boolean equals (Card other) {
		return this.toString ().equals (other.toString ());
	}
}
