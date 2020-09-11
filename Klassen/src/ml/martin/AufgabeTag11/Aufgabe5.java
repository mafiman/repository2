
/**
	@Aufgabe 5: Wechselgeld ausgeben
	Schreiben Sie ein Programm, welches für z.B. einen Getränkeautomaten die Art und Anzahl der
	Münzen ermittelt, die für die Auszahlung des Wechselgeldes benötigt wird.
	Ein Beispiel:
	Ein Kunde kauft ein Getränk für 35 Cent, bezahl aber durch den Einwurf einer 1 Euro Münze. Das
	Restgeld entspricht 65 Cent und muss ausgezahlt werden. Idealerweise erfolgt dies in folgenden
	Münzen:
	1 x 50 Cent
	1 x 10 Cent
	1 x 5 Cent
	Gehen Sie davon aus, dass Sie für das Programm einen idealen Automaten mit unendlich vielen
	Münzen jeder Sorte zur Verfügung haben. Erstellen Sie das Programm so, dass es vom Anwender
	direkt den Restgeldbetrag in Cent abfragt und dann die Folge der zu zahlenden Münzen ausgibt.
	Die Ausgabe könnte so aussehen:
 */
package ml.martin.AufgabeTag11;

import java.util.Scanner;

/**
 * @author martin
 *
 */
public class Aufgabe5 {

	/**
	 *  
	 */
	public static void main(String[] args) {

		new Aufgabe5().teileRestbetragAuf();
		System.out.println("Ende des Aufteilens.");
	}

	/**
	 * Aufteilen eines Betrages, der vom Benutzer erfragt wird, in einzelne Muenzen.
	 */
	public void teileRestbetragAuf() {
		// aufzuteilender Restbetrag
		int restBetrag = erfrageRestbetrag();
		// Start des Aufteilens
		splitteSummeInMuenzen(restBetrag, KleingeldMuenzen.CENT_200);

	}

	/**
	 * Abfragen der Summe die Aufzuteilen ist. Nicht abgefangen werden Fehleingaben
	 * 
	 * @return Int Summe der Muenzen insgesamt.
	 */
	private int erfrageRestbetrag() {
		System.out.println("Bitte geben Sie den Restbetrag in Cent ein:");
		String inputText = new Scanner(System.in).nextLine();
		int restBetrag = 0;

		int inputZahl = Integer.parseInt(inputText);
		if (inputZahl >= 0) {
			System.out.println("Aufzuteilender Betrag:" + inputText+ " Cent");
			restBetrag = inputZahl;
		} else {
			System.out.println("Bitte eine Restsumme angeben.");
		}
		return restBetrag;
	}

	/**
	 * Suche der Summe in einzelne Muenzen rekursiv
	 * 
	 * @param summe  Aufzusplittende Summe
	 * @param muenze Muenzgroesse
	 */
	private void splitteSummeInMuenzen(int summe, KleingeldMuenzen muenze) {
		// suche nach der Anzahl muenze in summe
		// und dem Restwert
		int rest = summe % muenze.getMuenzWert();
		int anzahl = (summe - rest) / muenze.getMuenzWert();

		// System.out.println("Muenze:"+ muenze +" Anzahl:"+anzahl+" rest:"+rest);
		if (anzahl > 0) {
			// Ausgabe der Kombination
			System.out.println(String.format("%4s  x %8s",  anzahl , muenze.getBezeichnung()));
		}

		if (rest > 0) {
			if (muenze == KleingeldMuenzen.CENT_1) {
				// fertig, rest in 1 cent stuecken
			} else {
				KleingeldMuenzen naechstKleinereMuenze = muenze.getNaechstkleinereMuenze();
				// naechst kleinere muenze nehmen
				splitteSummeInMuenzen(rest, naechstKleinereMuenze);
			}

		} // end rest >0
			// rest = 0, Alles aufgeteilt

	}

	/**
	 * Kleingeldmuenzen und ihr Wert in Cent
	 * 
	 * @author martin
	 *
	 */
	enum KleingeldMuenzen {
		CENT_1(1), CENT_2(2), CENT_5(5), CENT_10(10), CENT_20(20), CENT_50(50), CENT_100(100), CENT_200(200);

		private int muenzWert;
		private String bezeichnung;

		KleingeldMuenzen(int muenzWert) {
			this.muenzWert = muenzWert;
			if (muenzWert<100) {
			this.bezeichnung = "" + muenzWert + " Cent";
			}else		{
				this.bezeichnung = "" + (int) (muenzWert/100) + " Euro";
			}
		}

		/**
		 * Wert der Muenze
		 * 
		 * @return Wert als Integer
		 */
		public int getMuenzWert() {
			return this.muenzWert;
		}

		/**
		 * Bezeichnung der Muenze inkl Cent.
		 * 
		 * @return Bezeichnung als String.
		 */
		public String getBezeichnung() {
			return this.bezeichnung;
		}

		/**
		 * Zu dieser Muenze wird die naechst kleinere gesucht. Bei 1 Cent Muenzen wird
		 * eine NULL zurück gegeben.
		 * 
		 * @return
		 */
		public KleingeldMuenzen getNaechstkleinereMuenze() {
			KleingeldMuenzen retval = null;
			switch (this) {
				case CENT_200:
					retval = KleingeldMuenzen.CENT_100;
					break;
				case CENT_100:
				retval = KleingeldMuenzen.CENT_50;
					break;
				case CENT_50:
					retval = KleingeldMuenzen.CENT_20;
					break;
				case CENT_20:

					retval = KleingeldMuenzen.CENT_10;
					break;
				case CENT_10:

					retval = KleingeldMuenzen.CENT_5;
					break;
				case CENT_5:

					retval = KleingeldMuenzen.CENT_2;
					break;
				case CENT_2:

					retval = KleingeldMuenzen.CENT_1;
					break;
				case CENT_1:

					break;
			}
			return retval;
		}// end getNaechstKleinereMuenze
	}

}
