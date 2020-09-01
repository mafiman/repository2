package ml.martin.aufgabe_Piratespeecher;

import java.util.Scanner;

/**
 * Erzeugen Sie ein Kommandozeilen Programm, wo der Benutzer einen Text eingeben
 * kann. In diesem Text sollen alle a, e, i, o und u gegen arr, err, irr, orr
 * und urr getauscht werden. Der Text soll danach ausgegeben werden. Das
 * Programm soll sich wiederholen, bis der Benutzer „Ende“ eintippt.
 */

public class Aufgabe_Piratespeecher {
	static final char[] piratisableCharacters = { 'a', 'e', 'i', 'o', 'u' };
	// Jedes a e i o u sollte piratised werden
			// in haus sollte es keine piratisierung geben au eu ou ei ie haus
			// -> haus
			// Nicht zu piratisieren:
			 
// 	// au ae
	// ei
	// ie
	// ou oe
	// uu ua
	static final char[] ausnahmeNachA = { 'a', 'u', 'e', 'r' };
	static final char[] ausnahmeVorA = { 'a' };
	static final char[] ausnahmeNachE = { 'i', 'e', 'r' };
	static final char[] ausnahmeVorE = { 'i', 'e' };
	static final char[] ausnahmeNachI = { 'e', 'i', 'r' };
	static final char[] ausnahmeVorI = { 'a', 'e', 'i', 'r' };

	static final char[] ausnahmeNachO = { 'o', 'u', 'r' };
	static final char[] ausnahmeVorO = { 'o', 'u', 'r' };

	static final char[] ausnahmeNachU = { 'u', 'e', 'r' };
	static final char[] ausnahmeVorU = { 'o', 'u', 'a', 'r' };

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String eingabeText = "";
		String piratisedText = "";
		do {
			System.out.println(
					"Bitte einen Satz eingeben, der in Piratensprache umgewandelt werden soll. 'ende' zum Beenden.");
			eingabeText = scanner.nextLine();
			if (!eingabeText.toLowerCase().equals("ende")) {
				piratisedText = piratiseText(eingabeText);
				System.out.println(piratisedText);
			}

		} while (!eingabeText.toLowerCase().equals("ende"));
		System.out.println("Auf wiedersehen.");
	}

	private static String piratiseTextSimple(String textToConvert) {
		// every a e i o u should be a piratised character

		textToConvert = textToConvert.replace("a", "arr");
		textToConvert = textToConvert.replace("e", "err");
		textToConvert = textToConvert.replace("i", "irr");
		textToConvert = textToConvert.replace("o", "orr");
		textToConvert = textToConvert.replace("u", "urr");
		return textToConvert;
	}

	private static String piratiseText(String textToConvert) {
		String retText = "";
		char charAtCharIndex = ' ';
		boolean isCharacterPiratisable = false; // Ist das Zeichen zu berücksichtigen?
		boolean isThereAnExemption = false; // Ausnahme Fall?
		
		for (int charIndex = 0; charIndex < textToConvert.length(); charIndex++) {
			charAtCharIndex = textToConvert.charAt(charIndex);
		
			isCharacterPiratisable = false;
			for (char testChar : piratisableCharacters) {

				if (charAtCharIndex == testChar) {
					isCharacterPiratisable = true;
					break;
				}
			} // end for each paritisable chars

			isThereAnExemption = false;
			if (isCharacterPiratisable) {
				// should we convert?
				isThereAnExemption = shouldConvert(charIndex, textToConvert);
				//System.out.println("Ausnahme:" + isThereAnExemption);
			}
			if (isCharacterPiratisable && !isThereAnExemption) {
				// convert at index
				retText = retText + charAtCharIndex + "rr";
			} else {
				retText = retText + charAtCharIndex;
			}

		} // end for each character in textToConvert

		return retText;
	}

	static boolean shouldConvert(int indexToTest, String TextToConvert) {
		boolean retVal = false;
		char characterAtIntextToTest = TextToConvert.charAt(indexToTest);
		boolean testeZeichenVorAktuellem = true;
		boolean testeZeichenNachAktuellem = true;
		// Obacht bei erstem und letztem Zeichen
		if (indexToTest == 0) {
			// erstes Zeichen
			// nicht das Zeichen davor testen
			testeZeichenVorAktuellem = false;

		} else if (indexToTest + 1 == TextToConvert.length()) {
			// nicht das Zeichen danach testen
			testeZeichenNachAktuellem = false;
		}

		char characterNachZuTestendemZeichen = ' ';
		char characterVorZuTestendemZeichen = ' ';

		if (testeZeichenNachAktuellem) {
			characterNachZuTestendemZeichen = TextToConvert.charAt(indexToTest + 1);
		}
		if (testeZeichenVorAktuellem) {
			characterVorZuTestendemZeichen = TextToConvert.charAt(indexToTest - 1);
		}

		switch (characterAtIntextToTest) {
			case 'a':
				if (testeZeichenNachAktuellem) {
					for (char characterAusAusnahmeArray : ausnahmeNachA) {
						if (characterNachZuTestendemZeichen == characterAusAusnahmeArray) {
							retVal = true;
							break;
						}
					}
				}
				if (testeZeichenVorAktuellem) {
					for (char characterAusAusnahmeArray : ausnahmeVorA) {
						if (characterVorZuTestendemZeichen == characterAusAusnahmeArray) {
							retVal = true;
							break;
						}
					}
				}
				break;
			case 'e':
				if (testeZeichenNachAktuellem) {
					for (char characterAusAusnahmeArray : ausnahmeNachE) {
						if (characterNachZuTestendemZeichen == characterAusAusnahmeArray) {
							retVal = true;
							break;
						}
					}
				}
				if (testeZeichenVorAktuellem) {

					for (char characterAusAusnahmeArray : ausnahmeVorE) {
						if (characterVorZuTestendemZeichen == characterAusAusnahmeArray) {
							retVal = true;
							break;
						}
					}
				}
				break;
			case 'i':
				if (testeZeichenNachAktuellem) {
					for (char characterAusAusnahmeArray : ausnahmeNachI) {
						if (characterNachZuTestendemZeichen == characterAusAusnahmeArray) {
							retVal = true;
							break;
						}
					}
				}
				if (testeZeichenVorAktuellem) {

					for (char characterAusAusnahmeArray : ausnahmeVorI) {
						if (characterVorZuTestendemZeichen == characterAusAusnahmeArray) {
							retVal = true;
							break;
						}
					}
				}
				break;
			case 'o':
				if (testeZeichenNachAktuellem) {
					for (char characterAusAusnahmeArray : ausnahmeNachO) {
						if (characterNachZuTestendemZeichen == characterAusAusnahmeArray) {
							retVal = true;
							break;
						}
					}
				}
				if (testeZeichenVorAktuellem) {
					for (char characterAusAusnahmeArray : ausnahmeVorO) {
						if (characterVorZuTestendemZeichen == characterAusAusnahmeArray) {
							retVal = true;
							break;
						}
					}
				}
				break;
			case 'u':
				if (testeZeichenNachAktuellem) {
					for (char characterAusAusnahmeArray : ausnahmeNachU) {
						if (characterNachZuTestendemZeichen == characterAusAusnahmeArray) {
							retVal = true;
							break;
						}
					}
				}
				if (testeZeichenVorAktuellem) {

					for (char characterAusAusnahmeArray : ausnahmeVorU) {
						if (characterVorZuTestendemZeichen == characterAusAusnahmeArray) {
							retVal = true;
							break;
						}
					}
				}
				break;
			default:
				retVal = false;
				break;
		}// end of switch

		return retVal;
	}

}
