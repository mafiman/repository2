/**
 * Bauernhofsimulator 1.0
 * Bisher möglich: Kuehe bearbeiten.
 */
package martin.bauerhofSimulator;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author martin
 *
 */
public class BauerhofSimulator {

	/**
	 * 
	 */

	/**
	 * Die Herde der Kuehe.
	 */
	private static ArrayList<Kuh> kuhHerde = null;

	/**
	 * Das aktuelle Menue.
	 */
	private static int actualMenue = 0;
	/**
	 * Das letzte dargestellte Menue.
	 */
	private static int lastMenue = 0;
	/**
	 * Scanner zum Einlesen der Benutzerentscheidungen.
	 */
	static Scanner scanner = null;

	/**
	 * Wert der jeweils groesstmoeglichen Entscheidung.
	 */
	private static int maxDecisionValue;

	public static void main(String[] args) {
		//

		scanner = new Scanner(System.in);
		kuhHerde = new ArrayList<Kuh>();

		// Begüssung anzeigen
		displayGreeting();
		int benutzerEntscheidung = -1;
		// solange der benutzer nicht aufhoeren moechte und das Hauptmenue
		// angezeigt wird ( sonst will er nur aus dem Untermenue,
		// weiter machen
		while (!(benutzerEntscheidung == 0 && lastMenue == 0 && actualMenue == 0)) {
			displayMenue();
			// entscheidungen begrenzen
			if (actualMenue == 0) {
				maxDecisionValue = 2;
			} else {
				maxDecisionValue = 7;
			}
			benutzerEntscheidung = getUserDecision(maxDecisionValue);
			whatToDo(benutzerEntscheidung);

		}
	}

	/**
	 * Zeige die Begruessung an.
	 */
	private static void displayGreeting() {
		System.out.println("Willkommen beim Bauernhof Simulator (BS).");
		System.out.println("Du kannst bislang mit den folgenden Tieren etwas tun:");
		System.out.println("Kuh");
	}

	/**
	 * Was moechte der Benutzer tun?
	 * 
	 * @return 0 - maxDecisionVal -> Benutzerentscheidung -1 -> kein scanner, vorher
	 *         unbedingt initialisieren -2 -> Keine Zahl eingegeben -3 -> Wert
	 *         ausserhalb der Möglichkeiten
	 */
	private static int getUserDecision(int maxDecisionVal) {
		int retVal = 0;
		if (scanner == null) {
			System.err.println("Achtung, kein scanner definiert");
			retVal = -1;
		} else {
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
		} // end kein scanner

		return retVal;
	}

	/**
	 * Anzeige des Hauptmenues
	 */
	private static void displayMainMenue() {
		// Anzeige des Haupt Menue für den Benutzer

		System.out.println("0 - Beenden");
		System.out.println("1 - Kuehe verwalten");
		System.out.println("2 - Arbeiten verrichten");
	}

	/**
	 * Anzeige des Menues fuer Kuehe
	 */
	private static void displayKuhMenue() {
		// Anzeige des Kuh Menue für den Benutzer
		System.out.println("0 - Beenden");
		System.out.println("1 - Kuh anlegen");
		System.out.println("2 - Kuh erschiessen");
		System.out.println("3 - Kuh melken");
		System.out.println("4 - Kuh füttern");
		System.out.println("5 - Kuh ausführen");
		System.out.println("6 - Kuh anzeigen");
		System.out.println("7 - Alle Kuehe anzeigen");
	}

	/**
	 * Aktionen aus dem Kuh Menue.
	 * 
	 * @param entscheidung
	 */
	private static void doKuhMenue(int entscheidung) {

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
				doAnlegen();
				break;
			case 2:
				doEntfernen();
				break;
			case 3:
				doMelken();
				break;
			case 4:
				doFuettern();
				break;
			case 5:
				doAusfuehren();
				break;
			case 6:
				doEineKuhAnzeigen();
				break;
			case 7:
				doAlleKueheAnzeigen();
				break;
		}// end switch

	}

	/**
	 * Aktionen aus dem Main Menue.
	 * 
	 * @param entscheidung
	 */
	private static void doMainMenue(int entscheidung) {
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
	private static void displayMenue() {
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

	private static void whatToDo(int entscheidung) {
		// nach dem Menue und der Entscheidung des Benutzers
		// dinge tun.

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

	/**
	 * Suche den Index der Kuh mit der Ohrnummer.
	 * 
	 * @param gesuchteOhrnummer
	 *
	 * @return index der Kuh mit der Nummer, oder -1
	 */
	private static int sucheKuhIndexMitOhrnummer(int gesuchteOhrnummer) {
		int kuhIndex = -1;
		for (int index = 0; index < kuhHerde.size(); index++) {
			if (kuhHerde.get(index).getMarkenNummer() == gesuchteOhrnummer) {
				System.out.println("Tier gefunden.");

				kuhIndex = index;
				break;
			}
		}
		return kuhIndex;
	}

	private static void doFuettern() {
		System.out.println("Kuh fuettern:");
		System.out.println("Bitte die Ohrnummer angeben:");
		int gesuchteOhrnummer = Integer.valueOf(scanner.nextLine());

		System.out.println("Bitte die menge Kuhfutter angeben:");
		float zuFuetterndeMenge = Float.valueOf(scanner.nextLine());
		int kuhIndex = sucheKuhIndexMitOhrnummer(gesuchteOhrnummer);
		if (kuhIndex != -1) {
			System.out.println("Soll die Kuh mit der Nr." + gesuchteOhrnummer + " gefüttert werden?");
			if (askJaNein()) {
				float gewicht = kuhHerde.get(kuhIndex).fressen(zuFuetterndeMenge);
				System.out.println("Das Tier ist gefuettert worden und wiegt nun " + gewicht + ".");
			} else {
				System.out.println("OK, dann nicht.");
			}
		} else {
			System.out.println("Tier mit dieser Markennummer nicht gefunden.");
		}

	}

	private static void doAusfuehren() {
		System.out.println("Kuh ausfuehren:");
		System.out.println("Bitte die Ohrnummer angeben:");
		int gesuchteOhrnummer = Integer.valueOf(scanner.nextLine());

		System.out.println("Bitte die gelaufene Strecke angeben:");
		float streckeZuLaufen = Float.valueOf(scanner.nextLine());
		int kuhIndex = sucheKuhIndexMitOhrnummer(gesuchteOhrnummer);
		if (kuhIndex != -1) {
			System.out.println("Ist die Kuh mit der Nr." + gesuchteOhrnummer + " ausgefuehrt worden?");
			if (askJaNein()) {
				float gewicht = kuhHerde.get(kuhIndex).laufen(streckeZuLaufen);
				System.out.println("Das Tier ist ausgeführt worden und wiegt nun " + gewicht + ".");
			} else {
				System.out.println("OK, dann nicht.");
			}
		} else {
			System.out.println("Tier mit dieser Markennummer nicht gefunden.");
		}

	}

	private static void doMelken() {
		System.out.println("Kuh melken:");
		System.out.println("Bitte die Ohrnummer angeben:");
		int gesuchteOhrnummer = Integer.valueOf(scanner.nextLine());

		System.out.println("Bitte die zu melkenden Liter angeben:");
		float zuMelkendeLiter = Float.valueOf(scanner.nextLine());

		int kuhIndex = sucheKuhIndexMitOhrnummer(gesuchteOhrnummer);
		if (kuhIndex != -1) {
			System.out.println("Soll die Kuh mit der Nr." + gesuchteOhrnummer + " gemolken werden?");
			if (askJaNein()) {
				float gemolkeneLiter = kuhHerde.get(kuhIndex).melken(zuMelkendeLiter);
				System.out.println("Das Tier ist um " + gemolkeneLiter + " gemolken worden.");
			} else {
				System.out.println("OK, dann nicht.");
			}
		} else {
			System.out.println("Tier mit dieser Markennummer nicht gefunden.");
		}
	}

	private static void doAnlegen() {
		System.out.println("Kuh anlegen:");
		System.out.println("Bitte die Ohrnummer angeben:");
		int ohrnr = Integer.valueOf(scanner.nextLine());

		System.out.println("Bitte den namen angeben(Berta):");
		String kuhName = scanner.nextLine();
		if (kuhName.length() == 0) {
			kuhName = "Berta";
		}

		System.out.println("Bitte den HauptFarbe angeben(schwarz):");
		String hauptFarbe = scanner.nextLine();
		if (hauptFarbe.length() == 0) {
			hauptFarbe = "Schwarz";
		}

		System.out.println("Bitte den FleckFarbe angeben(weiss):");
		String fleckenFarbe = scanner.nextLine();
		if (fleckenFarbe.length() == 0) {
			fleckenFarbe = "Weiss";
		}

		System.out.println("Bitte den Gewicht angeben(100):");
		String inputString = scanner.nextLine();
		if (inputString.length() == 0) {
			inputString = "100";
		}
		float gewicht = Float.valueOf(inputString);

		System.out.println("Bitte den Milchmenge angeben(90):");
		inputString = scanner.nextLine();
		if (inputString.length() == 0) {
			inputString = "90";
		}
		float milchMenge = Float.valueOf(inputString);

		Kuh neuesTier = new Kuh(ohrnr);
		neuesTier.setFleckenfarbe(fleckenFarbe);
		neuesTier.setHauptfarbe(hauptFarbe);
		neuesTier.setGewicht(gewicht);
		neuesTier.setName(kuhName);
		neuesTier.setMilchmenge(milchMenge);

		System.out.println("Soll die Kuh so angelegt werden?");
		System.out.println(neuesTier);

		if (askJaNein()) {

			kuhHerde.add(neuesTier);
			System.out.println("Das Tier ist nun in deiner Herde.");
		} else {
			System.out.println("OK, dann nicht.");
		}
	}

	private static void doEntfernen() {
		System.out.println("Kuh entfernen:");
		System.out.println("Bitte die Ohrnummer angeben:");
		int gesuchteOhrnummer = Integer.valueOf(scanner.nextLine());
		int kuhIndex = sucheKuhIndexMitOhrnummer(gesuchteOhrnummer);
		if (kuhIndex != -1) {
			System.out.println("Soll die Kuh entfernt werden?");
			if (askJaNein()) {
				kuhHerde.remove(kuhIndex);
				System.out.println("Das Tier ist nun nicht mehr in deiner Herde.");
			} else {
				System.out.println("OK, dann nicht.");
			}
		} else {
			System.out.println("Tier mit dieser Markennummer nicht gefunden.");
		}

	}

	private static void doEineKuhAnzeigen() {
		System.out.println("Kuh anzeigen:");
		System.out.println("Bitte die Ohrnummer angeben:");
		int gesuchteOhrnummer = Integer.valueOf(scanner.nextLine());
		int kuhIndex = sucheKuhIndexMitOhrnummer(gesuchteOhrnummer);
		if (kuhIndex != -1) {
			System.out.println("Kuhdaten:" + kuhHerde.get(kuhIndex));

		} else {
			System.out.println("Tier mit dieser Markennummer nicht gefunden.");
		}
	}

	private static void doAlleKueheAnzeigen() {
		System.out.println("Alle Kuehe anzeigen:");
		if (kuhHerde.size() == 0) {
			System.out.println("Es gibt noch keine Tiere in der Kuhherde.");
		} else {
			kuhHerde.forEach(tier -> System.out.println(tier));
		}

	}

	/**
	 * Frage anzeigen und Antwort auf jJ oder nN testen
	 * 
	 * @return
	 */
	private static boolean askJaNein() {
		BufferedReader brReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Antworte mit Ja (j oderJ) oder Nein (n oder N):");
		boolean retVal = false;
		int iInputCharacter;
		try {
			iInputCharacter = brReader.read();
			if (iInputCharacter == 106 || iInputCharacter == 74) {
				// iWhatToSay = 2; // ja
				retVal = true;
			} else if (iInputCharacter == 110 || iInputCharacter == 78) {
				// iWhatToSay = 1; // nein
				retVal = false;
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

		return retVal;
	}
}
