/**
 * 
 */
package martin.bauerhofSimulator;

import java.util.Objects;

/**
 * @author martin
 * Reihenfolge Attribute, Getter/Setter, Konstruktoren, Standartmehoden, Eigene Methoden
 */
public class Kuh {

	private int markenNummer;
	private String name;
	private String hauptfarbe;
	private String fleckenfarbe;
	private float milchmenge;
	private float gewicht;

	/**
	 * 
	 * @return Die Markennummer der Kuh
	 */
	public int getMarkenNummer() {
		return this.markenNummer;
	}

	/**
	 * 
	 * @param markenNummer Zu setzende Markennummer
	 */
	public void setMarkenNummer(int markenNummer) {
		this.markenNummer = markenNummer;
	}

	/**
	 * 
	 * @return den Namen der Kuh
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Setzt den Name der Kuh
	 * 
	 * @param Name der zu setzende Name Kuh
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return die hauptfarbe
	 */
	public String getHauptfarbe() {
		return this.hauptfarbe;
	}

	/**
	 * @param hauptfarbe die zu setzende hauptfarbe
	 */
	public void setHauptfarbe(String hauptfarbe) {
		this.hauptfarbe = hauptfarbe;
	}

	/**
	 * @return die fleckenfarbe
	 */
	public String getFleckenfarbe() {
		return this.fleckenfarbe;
	}

	/**
	 * @param fleckenfarbe zu setzende fleckenfarbe
	 */
	public void setFleckenfarbe(String fleckenfarbe) {
		this.fleckenfarbe = fleckenfarbe;
	}

	/**
	 * @return die noch vorhandene milchmenge
	 */
	public float getMilchmenge() {
		return this.milchmenge;
	}

	/**
	 * @param milchmenge die zu setzende milchmenge
	 */
	public void setMilchmenge(float milchmenge) {
		if (milchmenge < 0) {
			System.out.println("Milchmenge nicht unter 0 fallen lassen.");
			return;
		}
		this.milchmenge = milchmenge;
	}

	/**
	 * @return das gewicht
	 */
	public float getGewicht() {
		return this.gewicht;
	}

	/**
	 * @param gewicht das zu setzende gewicht
	 */
	public void setGewicht(float gewicht) {
		if (gewicht <= 0) {
			System.out.println("");
		}
		this.gewicht = gewicht;
	}

	@Override
	public String toString() {
		return "Kuh [" + "Markennummer=" + this.getMarkenNummer() +", "
	            + (this.name != null ? "name=" + this.getName() + ", " : "")
				+ (this.hauptfarbe != null ? "hauptfarbe=" + this.getHauptfarbe() + ", " : "")
				+ (this.fleckenfarbe != null ? "fleckenfarbe=" + this.getFleckenfarbe() + ", " : "") 
				+ "milchmenge=" + this.getMilchmenge()
				+ ", gewicht=" + this.getGewicht() + "]";
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(fleckenfarbe, gewicht, hauptfarbe, milchmenge, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kuh other = (Kuh) obj;

		return Objects.equals(getFleckenfarbe(), other.fleckenfarbe)
				&& Float.floatToIntBits(getGewicht()) == Float.floatToIntBits(other.gewicht)
				&& Objects.equals(getHauptfarbe(), other.hauptfarbe)
				&& Float.floatToIntBits(getMilchmenge()) == Float.floatToIntBits(other.milchmenge)
				&& Objects.equals(getName(), other.name) && (getMarkenNummer() == other.getMarkenNummer());
	}

	/**
	 * Konstruktor ohne Parameter
	 */
	public Kuh() {
		//this.setMarkenNummer(MetaKuh.getNaechsteFreieMarkenNummer() );
		// Kaskadierender Aufruf
		this(MetaKuh.getNaechsteFreieMarkenNummer());
	}
	public Kuh(int markenNummer) {
		this.setMarkenNummer(markenNummer);
		this.setName("Hilde");
		this.setHauptfarbe("Braun");
		this.setFleckenfarbe("Weiss");
		this.setMilchmenge(100);
		this.setGewicht(650);
	}
	/**
	 * 
	 * @param melkMenge
	 * @return
	 */
	public float melken(float melkMenge) {
		this.setMilchmenge(this.getMilchmenge() - melkMenge);
		return this.getMilchmenge();
	}

	/**
	 * 
	 * @param futterMenge
	 * @return
	 */
	public float fressen(float futterMenge) {
		if (futterMenge>0) {
		this.setGewicht(this.getGewicht() + (futterMenge*0.5f));
		this.setMilchmenge(this.getMilchmenge() + (futterMenge*0.5f) );
		}
		return this.getGewicht();
	}

	/**
	 * 
	 * @param streckeZuLaufen
	 * @return
	 */
	public float laufen(float streckeZuLaufen) {
		this.setGewicht(this.getGewicht() - (streckeZuLaufen*0.5f));
		return this.getGewicht();
	}

}
