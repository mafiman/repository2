/**
 * 
 */
package martin.bauerhofSimulator;

import java.util.Scanner;

/**
 * @author martin
 *
 */
public class MenueVerwaltung {
	/**
	 * 
	 */
	private static MetaKuh metaKuh = new MetaKuh();

	/**
	 * Das aktuelle Menue.
	 */
	private static int actualMenue = 0;
	/**
	 * Das letzte dargestellte Menue.
	 */
	private static int lastMenue = 0;

	/**
	 * Wert der jeweils groesstmoeglichen Entscheidung.
	 */
	private static int maxDecisionValue;

	/**
	 * Methode um die Menueverwaltung zu starten und 
	 * den BauernhofSimulator laufen zu lassen.
	 */
	public void starteMenueVerwaltung() {

		// Begrüssung anzeigen
		displayGreeting();
		int benutzerEntscheidung = -1;
		// solange der benutzer nicht aufhoeren moechte und das Hauptmenue
		// angezeigt wird ( sonst will er nur aus dem Untermenue,
		// weiter machen
		while (!(benutzerEntscheidung == 0 && lastMenue == 0 && actualMenue == 0)) {
			displayMenue();
			// Entscheidungen begrenzen
			if (actualMenue == 0) {
				maxDecisionValue = 2;
			} else {
				maxDecisionValue = 8;
			}
			benutzerEntscheidung = getUserDecision(maxDecisionValue);
			whatToDo(benutzerEntscheidung);
		}
		displayGoodBy();
	}

	/**
	 * Zeige die Begruessung an.
	 */
	private void displayGreeting() {
		System.out.println("Willkommen beim Bauernhof Simulator (BS).");
		System.out.println("Du kannst bislang mit den folgenden Tieren etwas tun:");
		System.out.println("Kuh");
	}

	/**
	 * Zeige Verabschiedung an.
	 */
	private void displayGoodBy()	{
		System.out.println();
		System.out.println("Auf Wiedersehen, bis zum naechsten Mal beim Bauernhof Simulator (BS).");
	}
	/**
	 * Was moechte der Benutzer tun?
	 * 
	 * @return 0 - maxDecisionVal -> Benutzerentscheidung -2 -> Keine Zahl
	 *         eingegeben -3 -> Wert ausserhalb der Möglichkeiten
	 */
	private int getUserDecision(int maxDecisionVal) {
		Scanner scanner = new Scanner(System.in);
		int retVal = 0;

		System.out.println("Was moechtest du tun?:");
		String entscheidung = scanner.nextLine();
		// Auswerten wenn eine gültige Entscheidung gefallen ist.
		if (!entscheidung.matches("[0-9]+")) {
			// Hilfe ausgeben, nochmal Menue und Abfrage
			retVal = -2;
		} else {
			// welche entscheidung:
			int decisionValue = Integer.valueOf(entscheidung);
			if (decisionValue > maxDecisionVal || decisionValue < 0) {
				// ein illegaler Wert wurde eingegeben
				retVal = -3;
			} else {
				// Die Entscheidung des Benutzers steht fest
				retVal = decisionValue;
			} // end Entscheidung steht fest
		} // end ungueltige Entscheidung

		return retVal;
	}

	/**
	 * Anzeige des Hauptmenues
	 */
	private void displayMainMenue() {
		// Anzeige des Haupt Menue für den Benutzer
		System.out.println("0 - Beenden");
		System.out.println("1 - Kuehe verwalten");
		System.out.println("2 - Arbeiten verrichten");
	}

	/**
	 * Anzeige des Menues fuer Kuehe
	 */
	private void displayKuhMenue() {
		// Anzeige des Kuh Menue für den Benutzer
		System.out.println("0 - Beenden");
		System.out.println("1 - Kuh anlegen");
		System.out.println("2 - Kuh erschiessen");
		System.out.println("3 - Kuh melken");
		System.out.println("4 - Kuh fuettern");
		System.out.println("5 - Kuh ausfuehren");
		System.out.println("6 - Kuh anzeigen");
		System.out.println("7 - Alle Kuehe anzeigen");
		System.out.println("8 - Test-Kuehe anlegen");
	}

	/**
	 * Aktionen aus dem Kuh Menue.
	 * 
	 * @param entscheidung
	 */
	private void doKuhMenue(int entscheidung) {

		// 0 beenden
		// 1 anlegen
		// 2 entfernen
		// 3 melken
		// 4 fuettern
		// 5 ausfuehren
		// 6 eine anzeigen
		// 7 alle anzeigen
		switch (entscheidung) {
			case 1:
				metaKuh.doAnlegen();
				break;
			case 2:
				metaKuh.doEntfernen();
				break;
			case 3:
				metaKuh.doMelken();
				break;
			case 4:
				metaKuh.doFuettern();
				break;
			case 5:
				metaKuh.doAusfuehren();
				break;
			case 6:
				metaKuh.doEineKuhAnzeigen();
				break;
			case 7:
				metaKuh.doAlleKueheAnzeigen();
				break;
			case 8:
				metaKuh.doGenerateTestKuehe(5);
				break;
		}// end switch

	}

	/**
	 * Aktionen aus dem Main Menue.
	 * 
	 * @param entscheidung
	 */
	private void doMainMenue(int entscheidung) {
		// 0 - beenden
		// 1 Kuh menue
		// 2 something
		switch (entscheidung) {
			case 1:
				System.out.println("Kuhehe verwalten:");
				actualMenue = 1;
				break;
			case 2:
				System.out.println("Hier kommt noch nichts");
				break;
		}
	}

	/**
	 * Zeige das jeweils aktuelle Menue an. Und setze das letzte Menue auf den
	 * jeweiligen Wert.
	 */
	private void displayMenue() {
		System.out.println();
		switch (actualMenue) {
			case 0:
				lastMenue = 0;
				displayMainMenue();
				break;
			case 1:
				lastMenue = 1;
				displayKuhMenue();
				break;
			case 2:
				displayGreeting();
				break;
		}
	}

	private void whatToDo(int entscheidung) {
		// nach dem Menue und der Entscheidung des Benutzers
		// Dinge tun.

		if (entscheidung == 0) {
			// aktuelles Menue beenden
			actualMenue = 0;
		} else {
			// Dinge aus dem Menue machen
			if (actualMenue == 0) {
				doMainMenue(entscheidung);
			} else if (actualMenue == 1) {
				doKuhMenue(entscheidung);
			}

		}

	}

}
