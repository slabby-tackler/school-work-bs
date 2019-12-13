public class CallingCard extends Card {
	private String card_number;
	private String pin;

	public CallingCard (String n, String card_num, String pin_num) {
		super (n);
		card_number = card_num;
		pin = pin_num;
	}

	public String format () {
		return super.format () + ", Card Number: " + card_number + ", PIN: " + pin;
	}

	public String toString () {
		return this.getClass () + "[name=" + super.getName () + "[number=" + card_number + ",pin=" + pin + "]";
	}

	public boolean equals (Card other) {
		return this.toString ().equals (other.toString ());
	}
}
