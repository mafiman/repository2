/**
 Aufgabe 4: Suchen im Array
Schreiben Sie eine Anwendung, die 100.000 Zufallszahlen zwischen 0 und 50.000 in ein Array
schreibt. Der Anwender soll eine zu suchende Zahl eingeben und die Anwendung soll im Array nach
der Zahl suchen. Fangen Sie fehlerhafte Eingaben der gesuchten Zahl auf die obere und untere
Zahlengrenze ab.
Es wird ausgegeben: „Ja, die Zahl ist im Array“ oder „Nein, die Zahl ist nicht im Array“.
Programmieren Sie die Suche als eine sequentielle Suche, d.h. fangen Sie beim ersten Array-Element
an und vergleichen es mit dem gesuchten Wert. Falls es nicht das gesuchte Element ist, gehen Sie
zum nächsten Array-Element usw.
Zusätze:
Geben Sie die Stelle (d.h. den Index) aus, an dem die Zahl gefunden wurde.
Brechen Sie die Schleife ab, wenn die gesuchte Zahl im Array gefunden wurde.
Alternativ: Suchen Sie alle vorkommen einer Zahl im Array, bzw. fragen Sie den Nutzer, ob nach
weiteren Vorkommen gesucht werden soll, falls die gesuchte Zahl gefunden wurde.
 */
package ml.martin.AufgabeTag11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author martin
 *
 */
public class Aufgabe4 {

	/**
	 * 
	 */
	public static void main(String[] args) {
		new Aufgabe4().benutzeSuche();
		
	}// end main
	
	public void benutzeSuche() {
		// Anzahl der Werde im Array
		final int ANZAHL_WERTE = 100_000;
		// Maximalwert der Zahlen 
		final double MAX_WERT = 50_000;
		
		double[] aufgabeArray = new double[ANZAHL_WERTE];

		/**
		 * Text den der Benutzer eingibt, um eine Zahl einzugeben. Oder q.
		 */
		String inputText = "";

		double inputZahl = 0;
		Scanner scanner = new Scanner(System.in);
		/**
		 * Suche beenden, wenn der Benutzer q eingibt.
		 */
		boolean endSearch = false;
		
		/**
		 * Suche mit einem Wert im Array fotsetzen, wenn der Benutzer j/J eingibt.
		 */
		boolean continueSearch = true;
		
		/**
		 * Wo soll die Suche starten, bei erweiterter Suche wird die Suche nach dem
		 * letzten Auftauchen fortgesetzt.
		 */
		int startSearchIndex = 0;	
		
		/**
		 * Nutzen der Hilfsklasse, erleichtert die Uebergabe von Werten in die Suchmethode.
		 */
		FoundValue foundValue = new FoundValue();

		/**
		 * Suchmodus, einer von bisher zwei Moeglichkeiten.
		 */
		SearchModus ourModus = SearchModus.WITHEXTRAS;// SearchModus.MINIMAL;
		
		// Werte generieren
		for (int index = 0; index < ANZAHL_WERTE; index++) {
			aufgabeArray[index] = Math.round((Math.random() * MAX_WERT));
		}
		System.out.println("Array erzeugt mit " + ANZAHL_WERTE + " Werten.");

		System.out.println("-----------------");

		// Damit wir etwas finden koennen, willkuerlich bei Position 200 den Wert
		// ausgeben.
		System.out.println("Cheatvalue bei Index 200:" + aufgabeArray[200]);

		do {
			System.out.println("Bitte eine Zahl zwischen 0 und " + MAX_WERT + " oder q eingeben:");
			inputText = scanner.nextLine();

			// Abbrechen der Suche wenn 'q' oder nichts eingegeben wird
			if (inputText.equalsIgnoreCase("q") || inputText.isEmpty()) {
				endSearch = true;
			} else {
				endSearch = false;
				// Haben wir nur Zahlen oder einen Punkt
				inputText = inputText.replace(",", ".");
				if (inputText.matches("[0-9\\.]+")) {
					try {
						inputZahl = Double.parseDouble(inputText);
						if (inputZahl >= 0 && inputZahl <= MAX_WERT) {
							System.out.println("Suche nach der Zahl:" + inputText);
							// Soll bei der erweiterten Suche weiteres Vorkommen gesucht werden?
							// Abfrage wird in dieser Schleife gemacht, solange nicht n eingegeben wird oder
							// kein weiteres Vorkommen moeglich ist.
							do {
								System.out.println(
										searchNumber(
												aufgabeArray, 
												startSearchIndex, 
												inputZahl, 
												ourModus, 
												foundValue));
								
								if (foundValue.foundPosition) {
									if (ourModus.equals(SearchModus.WITHEXTRAS)) {
										System.out.println("Soll weiter gesucht werden?");
										continueSearch = askJaNein();
										if (continueSearch) {
											// Suche da weiterlaufen lassen wo wir was gefunden hatten
											// ausser die Position war die letzte Position im Array, dann nicht weiter machen.
											if (foundValue.foundIndex == aufgabeArray.length) {
												continueSearch=false;
											}else
											{
												startSearchIndex = foundValue.foundIndex + 1;
											}
										}
									} else if (ourModus.equals(SearchModus.MINIMAL)) {
										continueSearch = false;
									}
								} else {
									// keine Zahl gefunden. keine Entscheidung ob wir weiter suchen sollen
									// notwendig.
									System.out.println("Keine weitere Zahl gefunden, abbruch dieser Suche.");
									continueSearch = false;
								}
							} while (continueSearch);
						} else {
							System.out.println("Bitte eine Zahl zwischen 0 und " + MAX_WERT + " suchen lassen.");
						}

					} catch (Exception e) {
						System.err.println(
								"Bei der Eingabe der Zahl ist etwas schief gegagen. Bitte noch einmal eingeben.");
					}

				} // end if inputString ist Zahl oder Punkt

			} // end if suchen der Zahl und kein quit
			startSearchIndex=0;
			foundValue.reset();
			System.out.println("-----------------");
		} while (!endSearch);
	}// end benutzeSuche

	/**
	 * Nummer in einem uebergebenen Array von doulbes suchen.
	 * 
	 * @param aufgabeArray Uebergebenes Array mit zu durchsuchenden Werten
	 * @param startIndex   Ab wo gesucht werden soll. Am Anfang 0, spaeter nach der
	 *                     Stelle weiter suchen, wo wir aufgehoert hatten.
	 * @param searchZahl   Die zu suchende Zahl-
	 * @param searchModus  Welcher Suchmodus. Siehe SearchModus.
	 * @param foundValue   FoundValue um Daten besser übergeben zu können.
	 * @return String mit Text zur Suche.
	 */
	private String searchNumber(
			double[] aufgabeArray, 
			int startIndex, 
			double searchZahl,
			SearchModus searchModus, 
			FoundValue foundValue) {
		String retVal = "Zahl nicht gefunden.";
		foundValue.foundPosition = false;
		
		// Einmal pro Durchlauf konvertieren.
		long searchVal = Double.doubleToLongBits(searchZahl);

		for (int index = startIndex; index < aufgabeArray.length; index++) {// double aktZahl : aufgabeArray) {
			double aktZahl = aufgabeArray[index];
			if (Double.doubleToLongBits(aktZahl) == searchVal) {
				// gleiche Zahl gefunden.
				foundValue.foundIndex = index;
				foundValue.foundValue = searchZahl;
				foundValue.foundPosition = true;
				// Ausgabe abhängig vom Suchmodus
				if (searchModus.equals(SearchModus.MINIMAL)) {
					retVal = "Zahl gefunden";
					break;
				} else if (searchModus.equals(SearchModus.WITHEXTRAS)) {
					retVal = "Zahl gefunden an Position:" + index;
					break;
				}

			} // end if gefunden
		} // end for all numbers

		return retVal;
	}// end searchNumber

	/**
	 * Frage anzeigen und Antwort auf jJ oder nN testen
	 * 
	 * @return true bei Ja false bei Nein
	 */
	private boolean askJaNein() {
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

	/**
	 * Suchmodus fuer den Suchalgorithmus
	 * 
	 * @author martin
	 *
	 */
	enum SearchModus {
		/**
		 * Ausgabe das die Zahl gefunden worden ist.
		 * 
		 */
		MINIMAL,
		/**
		 * Ausgabe das die Zahl gefunden worden ist, plus die Moeglichkeit fortzufahren
		 * und nach weiteren Vorkommen zu suchen.
		 */
		WITHEXTRAS;
	}// end enum

	/**
	 * FoundValue hilft bei der Auswertung, ob die Zahl gefunden worden ist.
	 * foundPosition ist der Index der gefundenen Zahl foundValue ist die gesuchte
	 * und gefundenen Zahl foundPosition gibt an, ob wir wirklich etwas gefunden
	 * haben, oder ob wir mit der Suche durch sind.
	 * 
	 * @author martin
	 *
	 */
	class FoundValue {
		/**
		 * der Index der gefundenen Zahl
		 */
		public int foundIndex = 0;
		/**
		 * ist die gesuchte und gefundenen Zahl
		 */
		public double foundValue = 0;
		/**
		 * Gibt an, ob wir wirklich etwas gefunden haben (true) oder nicht(false);
		 */
		public boolean foundPosition = false;
		
		/**
		 * Auf den Ursprung zurueck setzen.
		 */
		public void reset() {
			foundIndex=0;
			foundValue=0;
			foundPosition=false;
		}
	}// end class FoundValue

}// end class
