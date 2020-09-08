/**
 * Klasse enthaelt Handling Methoden um Kuh Objekte zu verarbeiten
 */
package martin.bauerhofSimulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author martin
 *
 */
public class MetaKuh {

	/**
	 * Die Herde der Kuehe.
	 */
	private static ArrayList<Kuh> kuhHerde = null;

	public MetaKuh() {
		kuhHerde = new ArrayList<Kuh>();
	}

	/**
	 * Suche den Index der Kuh mit der MarkenNummer.
	 * 
	 * @param gesuchteMarkenNummermer
	 *
	 * @return index der Kuh mit der Nummer, oder -1
	 */
	public int sucheKuhIndexMitMarkenNummer(int gesuchteMarkenNummer) {
		int kuhIndex = -1;
		for (int index = 0; index < kuhHerde.size(); index++) {
			if (kuhHerde.get(index).getMarkenNummer() == gesuchteMarkenNummer) {
				System.out.println("Tier gefunden.");

				kuhIndex = index;
				break;
			}
		}
		return kuhIndex;
	}

	public void doFuettern() {
		System.out.println("Kuh fuettern:");
		int gesuchteMarkenNummer = askForMarkenNummer();
		int kuhIndex = sucheKuhIndexMitMarkenNummer(gesuchteMarkenNummer);
		if (kuhIndex != -1) {
			float zuFuetterndeMenge = askForFloat("Bitte die menge Kuhfutter angeben");
			System.out.println("Soll die Kuh mit der Nr." + gesuchteMarkenNummer + " gefuettert werden?");
			if (askJaNein()) {
				float gewicht = kuhHerde.get(kuhIndex).fressen(zuFuetterndeMenge);
				System.out.println("Das Tier ist gefuettert worden und wiegt nun " + gewicht + "kg.");
				System.out
						.println("Ausserdem hat das Tier " + kuhHerde.get(kuhIndex).getMilchmenge() + " Liter Milch.");
			} else {
				System.out.println("OK, dann nicht.");
			}
		} else {
			System.out.println("Tier mit dieser Markennummer nicht gefunden.");
		}
	}

	public void doAusfuehren() {

		System.out.println("Kuh ausfuehren:");
		int gesuchteMarkenNummer = askForMarkenNummer();
		int kuhIndex = sucheKuhIndexMitMarkenNummer(gesuchteMarkenNummer);
		if (kuhIndex != -1) {
			float streckeZuLaufen = askForFloat("Bitte die gelaufene Strecke angeben");
			System.out.println("Ist die Kuh mit der Nr." + gesuchteMarkenNummer + " ausgefuehrt worden?");
			if (askJaNein()) {
				float gewicht = kuhHerde.get(kuhIndex).laufen(streckeZuLaufen);
				System.out.println("Das Tier ist ausgeführt worden und wiegt nun " + gewicht + "kg.");
			} else {
				System.out.println("OK, dann nicht.");
			}
		} else {
			System.out.println("Tier mit dieser Markennummer nicht gefunden.");
		}
	}

	public void doMelken() {

		System.out.println("Kuh melken:");
		int gesuchteMarkenNummer = askForMarkenNummer();
		int kuhIndex = sucheKuhIndexMitMarkenNummer(gesuchteMarkenNummer);
		if (kuhIndex != -1) {
			float zuMelkendeLiter = askForFloat("Bitte die zu melkenden Liter angeben");
			System.out.println("Soll die Kuh mit der Nr." + gesuchteMarkenNummer + " gemolken werden?");
			if (askJaNein()) {
				float gemolkeneLiter = kuhHerde.get(kuhIndex).melken(zuMelkendeLiter);
				System.out.println("Das Tier ist hat nun noch " + gemolkeneLiter + " Liter Milch.");
			} else {
				System.out.println("OK, dann nicht.");
			}
		} else {
			System.out.println("Tier mit dieser Markennummer nicht gefunden.");
		}
	}

	public void doAnlegen() {

		System.out.println("Kuh anlegen:");

		int markenNummer = askForMarkenNummer();
		int kuhIndex = sucheKuhIndexMitMarkenNummer(markenNummer);
		if (kuhIndex != -1) {
			System.err.println("Ein Tier mit dieser Markennummer gibt es bereits.");
			System.err.println("Bitte eine andere Markennummer aussuchen.");
		} else {
			String kuhName = askForString("Bitte den namen angeben", "Berta");
			String hauptFarbe = askForString("Bitte die Hauptfarbe angeben", "schwarz");
			String fleckenFarbe = askForString("Bitte die Fleckfarbe angeben", "weiss");
			float gewicht = askForFloat("Bitte das Gewicht angeben", 100);
			float milchMenge = askForFloat("Bitte die Milchmenge angeben", 90);

			Kuh neuesTier = new Kuh(markenNummer);
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
		} // end else if markennummer bereits vorhanden
	}

	public void doEntfernen() {
		System.out.println("Kuh entfernen:");
		int gesuchteMarkenNummer = askForMarkenNummer();
		int kuhIndex = sucheKuhIndexMitMarkenNummer(gesuchteMarkenNummer);
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

	public void doEineKuhAnzeigen() {
		System.out.println("Kuh anzeigen:");
		int gesuchteMarkenNummer = askForMarkenNummer();
		int kuhIndex = sucheKuhIndexMitMarkenNummer(gesuchteMarkenNummer);
		if (kuhIndex != -1) {
			System.out.println("Kuhdaten:" + kuhHerde.get(kuhIndex));

		} else {
			System.out.println("Tier mit dieser Markennummer nicht gefunden.");
		}
	}

	public void doAlleKueheAnzeigen() {
		System.out.println("Alle Kuehe anzeigen:");
		if (kuhHerde.size() == 0) {
			System.out.println("Es gibt noch keine Tiere in der Kuhherde.");
		} else {
			kuhHerde.forEach(tier -> System.out.println(tier));
		}

	}

	/**
	 * Generiert Testkuehe
	 * 
	 * @param i Anzahl der Testkuehe
	 */
	public void doGenerateTestKuehe(int i) {
		//
		for (int index = 0; index < i; index++) {
			MetaKuh.kuhHerde.add(new Kuh());
		}
		System.out.println("Angelegt wurden " + i + " Kuehe.");
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
		boolean repeat = false;
		do {
			try {
				iInputCharacter = brReader.read();
				if (iInputCharacter == 106 || iInputCharacter == 74) {
					// iWhatToSay = 2; // ja
					retVal = true;
					repeat = false;
				} else if (iInputCharacter == 110 || iInputCharacter == 78) {
					// iWhatToSay = 1; // nein
					retVal = false;
					repeat = false;
				} else {
					// wiederholen der Abfrage, ungueltiges Zeichen
					repeat = true;
					System.out.println("Bitte nur mit Ja/ja oder Nein/nein antworten.");
					brReader.readLine();
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		} while (repeat == true);

		return retVal;
	}

	private int askForInt(String thingToAsk) {
		int retVal = 0;
		boolean wertEingegeben = false;
		Scanner scanner = new Scanner(System.in);
		while (!wertEingegeben) {
			System.out.println(thingToAsk);
			try {
				retVal = Integer.valueOf(scanner.nextLine());
				wertEingegeben = true;
			} catch (Exception e) {
				System.err.println("Bei der Eingabe ist etwas schief gegangen. Bitte noch einmal versuchen.");
				wertEingegeben = false;
			}
		}
		return retVal;
	}

	private float askForFloat(String thingToAsk, float defaultWert) {
		boolean wertEingegeben = false;
		float retVal = 0f;
		Scanner scanner = new Scanner(System.in);
		if (!Float.isNaN(defaultWert)) {
			// defaultwert angegeben, mit in die Frage aufnehmen
			thingToAsk += "[" + defaultWert + "]:";
		} else {
			thingToAsk += ":";
		}
		while (!wertEingegeben) {
			System.out.println(thingToAsk);
			try {
				if (Float.isNaN(defaultWert)) {
					// Ohne defaultwert muss eine Zahl eingegeben werden
					retVal = Float.valueOf(scanner.nextLine());
				} else {
					// wenn es einen defaultWert gibt,
					// dann kann der Benutzer auch einfach auf Enter druecken.
					String inputString = scanner.nextLine();
					if (inputString.length() == 0 || inputString.isEmpty()) {
						retVal = defaultWert;
					} else {
						retVal = Float.valueOf(scanner.nextLine());
					}
				}

				wertEingegeben = true;
			} catch (Exception e) {
				System.err.println("Bei der Eingabe ist etwas schief gegangen. Bitte noch einmal versuchen.");
				wertEingegeben = false;
			}
		}
		return retVal;
	}

	private Float askForFloat(String thingToAsk) {
		float retVal = askForFloat(thingToAsk, Float.NaN);
		return retVal;
	}

	private String askForString(String thingToAsk, String defaultWert) {
		String retVal = "";
		boolean wertEingegeben = false;
		Scanner scanner = new Scanner(System.in);

		if (defaultWert != null) {
			// defaultwert angegeben, mit in die Frage aufnehmen
			thingToAsk += "[" + defaultWert + "]:";
		} else {
			thingToAsk += ":";
		}
		while (!wertEingegeben) {
			System.out.println(thingToAsk);
			try {
				retVal = scanner.nextLine();
				if (retVal.isEmpty()) {
					if (defaultWert != null) {
						retVal = defaultWert;
						wertEingegeben = true;
					} else {
						// kein defaultwert vorhanden und
						// trotzdem nichts eingegeben
						wertEingegeben = false;
					}
				} else {
					// etwas ist eingegeben, egal ob es defaultwert gibt
					wertEingegeben = true;
				}

			} catch (Exception e) {
				System.err.println("Bei der Eingabe ist etwas schief gegangen. Bitte noch einmal versuchen.");
				wertEingegeben = false;
			}
		}

		return retVal;
	}

	private String askForString(String thingToAsk) {
		return askForString(thingToAsk, null);
	}

	private int askForMarkenNummer() {
		return askForInt("Bitte die MarkenNummer angeben:");
	}

	/**
	 * Besorge die naechstmoegliche Markennummer der Kuhherde.
	 * 
	 * @return Groesstmoegliche MarkenNummer +1.
	 */
	public static int getNaechsteFreieMarkenNummer() {
		//
		int retVal = 0;

		for (Kuh tier : MetaKuh.kuhHerde) {
			if (retVal < tier.getMarkenNummer()) {
				// retVal wird zu der MarkenNummer des aktuellen Tieres.
				retVal = tier.getMarkenNummer();
			}
		}
		// Hier enthalet retVal die groesste MarkenNummer
		retVal++; // das ist die nachstmoegliche Markennummer (eine groesser als die
					// groesstmoegliche.

		return retVal;
	}

}
