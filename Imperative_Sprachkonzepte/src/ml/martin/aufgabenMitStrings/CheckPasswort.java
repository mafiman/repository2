/**
 * Passwort Checker Klasse, Manuelle tests,
 */
package ml.martin.aufgabenMitStrings;

/**
 * @author martin
 *
 */
public class CheckPasswort {
	public void checkPasswort() {
	}

	/**
	 * Hilfskonstruktion, Grenzen der Bereiche für die Werte
	 */
	final Grenzen[] bereiche = { new Grenzen(65, 90), // Grossbuchstaben
			new Grenzen(97, 122), // Kleinbuchstaben
			new Grenzen(48, 57) };// Ziffern

	/**
	 * Methode die testen kann ob ein testWert in den Grenzen einer der angegebenen
	 * Grenzen ist.
	 * 
	 * @param grenzen  Array von Grenzen, die getestet werden sollen.
	 * @param testWert Zu testender Wert
	 * @return
	 */
	private boolean isIntInGrenzen(Grenzen[] grenzen, int testWert) {
		boolean retVal = false;

		for (Grenzen grenze : grenzen) {
			if (testWert >= grenze.unterGrenze && testWert <= grenze.oberGrenze) {
				retVal = true;
				break;
			}
		}
		return retVal;
	}

	// Test über Handarbeit
    /**
     * Testmethode, zum Debuggen der einzelnen Logik Teile.
     * @return
     */
	public boolean testLogik() {
		String passwort = "12Ha45#";
		@SuppressWarnings("unused")
		int retVal = simpleCheck(passwort);
		@SuppressWarnings("unused")
		boolean testVal = enthaeltGrossBuchstabe(passwort);
		testVal = enthaeltKleinBuchstabe(passwort);
		testVal = enthaeltSonderzeichen(passwort);
		testVal = enthaeltZiffer(passwort);

		return true;
	}

	private boolean enthaeltGrossBuchstabe(String passwort) {
		boolean retVal = false;
		// Grossbuchstaben ASCII 65-90
		Grenzen[] grossbuchstabenGrenzenArray = { bereiche[0] };
		int asciiOfCharakter = 0;
		for (int index = 0; index < passwort.length(); index++) {
			asciiOfCharakter = passwort.charAt(index);
			if (isIntInGrenzen(grossbuchstabenGrenzenArray, asciiOfCharakter)) {
				// gefunden
				retVal = true;
				break;
			}
		}

		return retVal;
	}

	private boolean enthaeltKleinBuchstabe(String passwort) {
		boolean retVal = false;
		// Kleinbuchstaben ASCII 97-122
		Grenzen[] kleinbuchstabenGrenzenArray = { bereiche[1] };
		int asciiOfCharakter = 0;
		for (int index = 0; index < passwort.length(); index++) {
			asciiOfCharakter = passwort.charAt(index);
			if (isIntInGrenzen(kleinbuchstabenGrenzenArray, asciiOfCharakter)) {
				// gefunden
				retVal = true;
				break;
			}
		}
		return retVal;
	}

	private boolean enthaeltSonderzeichen(String passwort) {
		boolean retVal = false;
		// Keine Ziffer, keine Buchstaben gross und kein, kein 32 und kein 127
		// Also Test ob das jeweilige Zeichen nicht in einem der Grenzen liegt
		int asciiOfCharakter = 0;
		for (int index = 0; index < passwort.length(); index++) {
			asciiOfCharakter = passwort.charAt(index);
			if (!isIntInGrenzen(bereiche, asciiOfCharakter)) {
				// gefunden
				retVal = true;
				break;
			}
		}

		return retVal;
	}

	private boolean enthaeltZiffer(String passwort) {
		boolean retVal = false;
		// Ziffern 48 - 57
		Grenzen[] ziffernGrenzenArray = { bereiche[2] };
		int asciiOfCharakter = 0;
		for (int index = 0; index < passwort.length(); index++) {
			asciiOfCharakter = passwort.charAt(index);
			if (isIntInGrenzen(ziffernGrenzenArray, asciiOfCharakter)) {
				// gefunden
				retVal = true;
				break;
			}
		}
		return retVal;
	}

	/**
	 * Check ob das Passwort aus dem Parameter sicher ist, dh mehr als 10 Zeichen
	 * lang. Wenn es nicht sicher ist wird die Anzahl der Zeichen die zu 10 Zeichen
	 * fehlt zurück gegeben.
	 * 
	 * @param passwort
	 * @return 0 Passwort sicher, >0 Anzahl der fehlenden Zeichen.
	 */
	public int simpleCheck(String passwort) {
		int retVal = 0;
		 
		retVal = 10 - passwort.length();
		return (retVal < 0) ? 0 : retVal;
	}

	/**
	 * Check ob Passwort mindestens einen Grossbuchstaben und eine Ziffer enthält.
	 * Mit dem Parameter @param sollAuchAuf10ZiffernGetestetWerden kann man
	 * einstellen, ob zusätzlich auf mindestens 10 Zeichen geachtet werden soll.
	 * 
	 * @param passwort
	 * @param sollAuchAuf10ZiffernGetestetWerden Soll zusätzlich auf mindestens 10
	 *                                           Zeichen geachtet werden
	 * @return 0 falls Sicher, -1 falls nicht Klein/Grossbuchstabe vorhanden, >0
	 *         Anzahl Zeichen die zu 10 Zeichen fehlen (falls eingestellt)
	 */
	public int grossBuchstabeZifferCheck(String passwort, boolean sollAuchAuf10ZiffernGetestetWerden) {
		int retVal = -1;
		if (enthaeltGrossBuchstabe(passwort) & enthaeltZiffer(passwort)) {
			retVal = 0;
		}
		if (sollAuchAuf10ZiffernGetestetWerden && retVal==0) {
			retVal = simpleCheck(passwort);
		}

		return retVal;
	}

	/**
	 * Check ob es einen Großbuchstaben,einen kleinen Buchstaben, eine Ziffer und
	 * ein Sonderzeichen enthält.
	 * 
	 * @param passwort
	 * @param sollAuchAuf10ZiffernGetestetWerden
	 * @return 0 falls Sicher, -1 falls nicht sicher, >0 Anzahl Zeichen die zu 10
	 *         Zeichen fehlen (falls eingestellt)
	 */
	public int grossBuchstabeZifferKleinbuchstabeSonderzeichenCheck(String passwort,
			boolean sollAuchAuf10ZiffernGetestetWerden) {
		int retVal = -1; 
		if (    enthaeltGrossBuchstabe(passwort) & 
				enthaeltZiffer(passwort) & 
				enthaeltKleinBuchstabe(passwort)&
				enthaeltSonderzeichen(passwort)) {
			retVal = 0;
		}
		if (sollAuchAuf10ZiffernGetestetWerden && retVal==0 ) {
			retVal = simpleCheck(passwort);
		}
		return retVal;
	}
}
/**
 * Hilfsklasse für ober und untergrenzen von Bereichen
 * 
 * @author martin
 *
 */
class Grenzen {
	int unterGrenze = 32;
	int oberGrenze = 127;

	Grenzen(int unterGrenze, int oberGrenze) {
		this.unterGrenze = unterGrenze;
		this.oberGrenze = oberGrenze;
	}
}