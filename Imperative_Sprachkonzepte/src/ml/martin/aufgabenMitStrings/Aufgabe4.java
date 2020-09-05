/**
Aufgabe:
Schreiben Sie ein Programm, das den Benutzer nach einem Kennwort fragt. Dieses Kennwort soll
sicher sein. 
Zunächst bezeichnen wir ein Kennwort als sicher, wenn es mindestens 10 Zeichen
beinhaltet. Schreiben Sie eine Funktion, die überprüft, ob das Kennwort diese Anforderung erfüllt. 
Im Hauptprogramm soll dieses Ergebnis ausgewertet werden. 
Falls es nicht sicher ist, teilen Sie dem Benutzer mit, wie viele Zeichen fehlen.

- Erweitern Sie das Kennwortprogramm. Dazu verschärfen wir die Regeln für ein sicheres Kennwort.
Als sicher gilt nun ein Kennwort, das aus mindestens einem Großbuchstaben und einer Ziffer besteht.
Die Länge spielt nun keine Rolle mehr.
- Erweitern Sie die Funktion, so dass diese nun prüft, ob im Kennwort sowohl ein Großbuchstabe als
auch eine Ziffer steht.
- Erweitern Sie das Programm nun so, dass die Funktion prüft, ob das Kennwort 10 Zeichen lang ist
und mindestens einen Großbuchstaben und eine Ziffer enthält. Testen Sie die Funktion wieder.

Zusatzaufgabe: Erweitern Sie die Funktion so, dass auch ein Kleinbuchstabe und ein Sonderzeichen
enthalten sein muss.  

Sonderzeichen sind dabei alle Zeichen aus der ASCII Tabelle, die keine Buchstaben sind.

 */
package ml.martin.aufgabenMitStrings;

import java.util.Scanner;

/**
 * @author martin
 *
 */
public class Aufgabe4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//
		CheckPasswort passwortChecker = new CheckPasswort();
		String passwort;
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Bitte geben sie ein Passwort mit 10 Zeichen oder mehr zum Test ein:");
		passwort = scanner.nextLine();

		// Testklasse instanzieren
		int fehlendeZeichen = passwortChecker.simpleCheck(passwort);
		
		//// Test zum Debuggen der Logikmethoden
		//passwortChecker.testLogik();
		//passwortChecker.testLogikRegEx();
		
		//Simpler Test: 10 Zeichen
		if (fehlendeZeichen == 0) {
			System.out.println("Das Passwort ist sicher, es hat mindestens 10 Zeichen.");
		} else {
			System.out.println("Das Passwort ist unsicher, es fehlen " + fehlendeZeichen + " Zeichen.");
		}
		System.out.println("------------");
		
		// Check aufGrossbuchstabe und Ziffer
		fehlendeZeichen = passwortChecker.grossBuchstabeZifferCheck(passwort, false);
		if (fehlendeZeichen == 0) {
			System.out.println("Das Passwort ist sicher, es enthält einen Grossbuchstaben und eine Ziffer.");
		} else {
			System.out.println("Das Passwort ist unsicher, \nes müssen mindestens ein Grossbuchstabe und "
					+ "mindestens eine Ziffer enthalten sein.");
		}
		System.out.println("------------");
		// Check aufGrossbuchstabe und Ziffer und mindestens 10 Zeichen lang
		fehlendeZeichen = passwortChecker.grossBuchstabeZifferCheck(passwort, true);
		if (fehlendeZeichen == 0) {
			System.out.println("Das Passwort ist sicher, es enthält einen Grossbuchstaben und "
					+ "eine Ziffer und ist mindestens 10 Ziffern lang."

			);
		} else {
			System.out.println("Das Passwort ist unsicher, es muss mindestens 10 zeichen lang sein, \n"+
		            "es müssen mindestens ein Grossbuchstabe und "
					+ "mindestens eine Ziffer enthalten sein.");
		}
		
		System.out.println("------------");
		
		// Check aufGrossbuchstabe und Ziffer  und
		// kleinbuchstabe und
		// ein Sonderzeichen.
		fehlendeZeichen = passwortChecker.grossBuchstabeZifferKleinbuchstabeSonderzeichenCheck(passwort, false);
		if (fehlendeZeichen == 0) {
			System.out.println("Das Passwort ist sicher, es enthält mindestens "+
		"\n einen Grossbuchstaben, einen Kleinbuchstaben und "
					+ "eine Ziffer und ein Sonderzeichen."

			);
		} else {
			System.out.println(
					"Das Passwort ist unsicher, es fehlen müssen mindestens ein Grossbuchstabe,"+
			        "\n ein Kleinbuchstabe, ein Sonderzeichen und "
					+ "mindestens eine Ziffer enthalten.");
		}

		System.out.println("------------");
		
		// Check auf Grossbuchstabe und Ziffer und mindestens 10 Zeichen lang und
		// kleinbuchstabe und
		// ein Sonderzeichen.
		fehlendeZeichen = passwortChecker.grossBuchstabeZifferKleinbuchstabeSonderzeichenCheck(passwort, true);
		if (fehlendeZeichen == 0) {
			System.out.println("Das Passwort ist sicher, es enthält mindestens "+
		"\n einen Grossbuchstaben, einen Kleinbuchstaben und "
					+ "eine Ziffer und ein Sonderzeichen und ist mindestens 10 Ziffern lang."

			);
		} else {
			System.out.println(
					"Das Passwort ist unsicher, es fehlen müssen mindestens ein Grossbuchstabe,"+
			        "\n ein Kleinbuchstabe, ein Sonderzeichen und "
					+ "mindestens eine Ziffer enthalten \n und es muss min. 10 Ziffern lang sein.");
		}

	}

}



