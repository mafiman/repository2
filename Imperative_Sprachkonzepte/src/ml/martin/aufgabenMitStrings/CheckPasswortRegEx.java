/**
 * Passwort checker Klasse mit regulären Ausdrücken.
 */
package ml.martin.aufgabenMitStrings;

/**
 * @author martin
 *
 */
public class CheckPasswortRegEx {
	// Pattern Klasse nehmen.
	// Patter testPattern = Pattern
	// Reguläre Ausdrücke
	@SuppressWarnings("unused")
	public boolean testLogikRegEx() {
		String passwort = "12345hH7890";
		int retVal = simpleCheck(passwort);
		boolean testVal = enthaeltGrossBuchstabeRegEx(passwort);
		testVal = enthaeltKleinBuchstabeRegEx(passwort);
		testVal = enthaeltSonderzeichenRegEx(passwort);
		testVal = enthaeltZifferRegEx(passwort);
		return true;
	}

	@SuppressWarnings("unused")
	public boolean testLogik2RegEx() {
		String passwort = "Wart";
		String regex = "[^o]+";
		boolean retVal = passwort.matches(regex);
		return true;
	}

	private boolean enthaeltGrossBuchstabeRegEx(String passwort) {
		boolean retVal = false;
		String regex = "(.)*([A-Z])(.)*";
		retVal = passwort.matches(regex);

		return retVal;
	}

	private boolean enthaeltKleinBuchstabeRegEx(String passwort) {
		boolean retVal = false;
		String regex = "(.)*([a-z])(.)*";
		retVal = passwort.matches(regex);
		return retVal;
	}

	private boolean enthaeltSonderzeichenRegEx(String passwort) {
		boolean retVal = false;
		String regex = "(.)*([^a-zA-Z0-9])(.)*";
		retVal = passwort.matches(regex);
		return retVal;
	}

	private boolean enthaeltZifferRegEx(String passwort) {
		boolean retVal = false;
		String regex = "(.)*(\\d)(.)*"; // [0-9]";
		retVal = passwort.matches(regex);
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
		if (enthaeltGrossBuchstabeRegEx(passwort) & enthaeltZifferRegEx(passwort)) {
			retVal = 0;
		}
		if (sollAuchAuf10ZiffernGetestetWerden && retVal == 0) {
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
		if (enthaeltGrossBuchstabeRegEx(passwort) & enthaeltZifferRegEx(passwort)
				& enthaeltKleinBuchstabeRegEx(passwort) & enthaeltSonderzeichenRegEx(passwort)) {
			retVal = 0;
		}
		if (sollAuchAuf10ZiffernGetestetWerden && retVal == 0) {
			retVal = simpleCheck(passwort);
		}
		return retVal;
	}
}
