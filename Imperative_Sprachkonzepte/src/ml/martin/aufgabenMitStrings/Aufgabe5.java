/**
 * Aufgabe5 aus den Aufgaben mit Strings.
 * Schreiben Sie ein Programm, das die ASCII-Tabelle ausgibt.
 * (Format vorgegeben)
 */
package ml.martin.aufgabenMitStrings;

/**
 * @author martin
 *
 */
public class Aufgabe5 {

	/**
	 *  
	 */
	public static void main(String[] args) {

		String ueberschriftLinks = "Dezimalzahlen";
		
		String ueberschriftRechts = "Zeichen";
		
		String formatStringInnen = "%" + ueberschriftLinks.length() + "s  %-" + ueberschriftRechts.length() + "s ";

		String formatStringKombination = formatStringInnen + " | " + formatStringInnen;

		String ueberschrift = String.format(formatStringKombination, ueberschriftLinks, ueberschriftRechts,
				ueberschriftLinks, ueberschriftRechts);
		
		System.out.println(ueberschrift);

		int cRechts;
		String charLinks, charRechts;
		for (int cLinks = 32; cLinks <= 79; cLinks++) {
			cRechts = cLinks + 48;
			if (cLinks != 32) {
				charLinks = "" + ((char) cLinks);
			} else {
				charLinks = "Space";
			}
			if (cRechts != 127) {
				charRechts = "" + ((char) cRechts);
			} else {
				charRechts = "DEL";
			}

			System.out.println(String.format(formatStringKombination, cLinks, charLinks, cRechts, charRechts));

		}

	}

}
