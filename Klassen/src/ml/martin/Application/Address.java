/**
 * 
 */
package ml.martin.Application;

/**
 * @author martin
 *
 */
public class Address {
	// private static Attribute

	// private Attribute
	private int id;
	private String vorName;
	private String nachName;
	private String strassenName;
	private String hausNummer;
	private int postleitzahl;
	private String ortsname;
	private boolean endkunde;
	
	// public setter /getter
	/**
	 * @return the id
	 */
	public int getID() {
		return this.id;
	}

	/**
	 * @param vorName the vorName to set
	 */
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * @return the vorName
	 */
	public String getVorName() {
		return this.vorName;
	}

	/**
	 * @param vorName the vorName to set
	 */
	public void setVorName(String vorName) {
		this.vorName = vorName;
	}

	/**
	 * @return the nachName
	 */
	public String getNachName() {
		return this.nachName;
	}

	/**
	 * @param nachName the nachName to set
	 */
	public void setNachName(String nachName) {
		this.nachName = nachName;
	}

	/**
	 * @return the strassenName
	 */
	public String getStrassenName() {
		return this.strassenName;
	}

	/**
	 * @param strassenName the strassenName to set
	 */
	public void setStrassenName(String strassenName) {
		this.strassenName = strassenName;
	}

	/**
	 * @return the hausNummer
	 */
	public String getHausNummer() {
		return this.hausNummer;
	}

	/**
	 * @param hausNummer the hausNummer to set
	 */
	public void setHausNummer(String hausNummer) {
		this.hausNummer = hausNummer;
	}

	/**
	 * @return the postleitzahl
	 */
	public int getPostleitzahl() {
		return this.postleitzahl;
	}

	/**
	 * @param postleitzahl the postleitzahl to set
	 */
	public void setPostleitzahl(int postleitzahl) {
		this.postleitzahl = postleitzahl;
	}

	/**
	 * @return the ortsname
	 */
	public String getOrtsname() {
		return this.ortsname;
	}

	/**
	 * @param ortsname the ortsname to set
	 */
	public void setOrtsname(String ortsname) {
		this.ortsname = ortsname;
	}

	/**
	 * 
	 * @return Endkunde ja oder nein
	 */
	public boolean getEndkunde() {
		return this.endkunde;
	}
	/**
	 * 
	 * @param endkunde Setzen ob die Addresse zueinem Endkunden gehoert.
	 */
	public void setEndkunde(boolean endkunde) {
		this.endkunde=endkunde;
	}
	
	
	// Konstruktoren ohne Parameter, mit std Parametern
	/**
	 * Konstruktor mit statischer Initialisierung aller Attribute
	 */
	public Address() {
		this.setID(0);// NYI
		this.setVorName("Michael");
		this.setNachName("Tester");
		this.setStrassenName("Teststrasse");
		this.setHausNummer("12a");
		this.setPostleitzahl(23);
		this.setOrtsname("Puselhausen");
		this.setEndkunde(true);
	}

	/**
	 * Konstruktor mit parameteriserter Initialisierung bis auf Endkunde. Es wird immer 
	 * ein nicht Endkunde angelegt.
	 * @param vorName
	 * @param nachName
	 * @param strassenName
	 * @param hausNummer
	 * @param postleitzahl
	 * @param ortsName
	 */
	public Address(String vorName, String nachName, String strassenName, String hausNummer, int postleitzahl,
			String ortsName ) {
		this(vorName, nachName, strassenName, hausNummer, postleitzahl, ortsName, false);
	}
	/**
	 * Konstruktor mit parameteriserter Initialisierung bis auf Endkunde und Nachname.
	 * @param nachName
	 * @param strassenName
	 * @param hausNummer
	 * @param postleitzahl
	 * @param ortsName
	 */
	public Address(String nachName, String strassenName, String hausNummer, int postleitzahl,
			String ortsName ) {
		this("", nachName, strassenName, hausNummer, postleitzahl, ortsName, false);
	}
	/**
	 * Konstruktor mit parameteriserter Initialisierung aller Attribute.
	 * @param vorName
	 * @param nachName
	 * @param strassenName
	 * @param hausNummer
	 * @param postleitzahl
	 * @param ortsName
	 * @param endkunde
	 */
	public Address(String vorName, String nachName, String strassenName, String hausNummer, int postleitzahl,
			String ortsName, boolean endkunde) {
		this.setVorName(vorName);
		this.setNachName(nachName);
		this.setStrassenName(strassenName);
		this.setHausNummer(hausNummer);
		this.setPostleitzahl(postleitzahl);
		this.setOrtsname(ortsName);
		this.setEndkunde(endkunde);	
	}
	

	@Override
	public String toString() {
		return "Address [" + (vorName != null ? "vorName=" + this.getVorName() + ", " : "")
				+ (nachName != null ? "nachName=" + this.getNachName() + ", " : "")
				+ (strassenName != null ? "strassenName=" + this.getStrassenName() + ", " : "")
				+ (hausNummer != null ? "hausNummer=" + this.getHausNummer() + ", " : "") + "postleitzahl="
				+ this.getPostleitzahl() + ", ortsname=" + this.getOrtsname() + "]";
	}

	// Standartmethoden toString() equals() hash()

	// methoden allegemein
	public void printAddress() {
		System.out.println(
				(vorName != null ?   this.getVorName() + "  " : "")
				+ (nachName != null ?  this.getNachName() + "  " : "")
				+ (strassenName != null ?  this.getStrassenName() + "  " : "")
				+ (hausNummer != null ?  this.getHausNummer() + "  " : "") 
				+  String.format("%05d",  this.getPostleitzahl()) + " " + this.getOrtsname()
				);

	}
}
