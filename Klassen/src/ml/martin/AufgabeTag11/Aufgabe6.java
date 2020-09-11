/**
 * Aufgabe 6: Lottozahlen und Häufigkeiten
Schreiben Sie ein Programm, das für das Lottospiel „6 aus 49“ einen Tipp vorschlägt, 
das heißt, sechs zufällige Zahlen in einem Array speichert und anschließend ausgibt. 
Die Zahlen müssen nicht sortiert sein.
Bei einem Lottotipp darf keine Zahl doppelt vorkommen. 
 */
package ml.martin.AufgabeTag11;

import java.util.Arrays;
import java.util.Random;

public class Aufgabe6 {

	public static void main(String[] args) {

		final int TIPZAHLEN_OBERGRENZE = 49;
		final int ANZAHL_TIPZAHLEN = 36;
		// Array vorbereiten
		int[] lottoZahlen = new int[ANZAHL_TIPZAHLEN];
		System.out.println("Lottozahlen vorbereiten.");
		new Aufgabe6().lottoArrayGenerieren(lottoZahlen, TIPZAHLEN_OBERGRENZE);
		System.out.println("Lottozahlen Tip ist:" + Arrays.toString(lottoZahlen));

	}

	/**
	 * Methode generiert in ein uebergebenes Array eine Mege Zufallszahlen mit der
	 * Obergrenze, die als zweiter Parameter angegeben ist.
	 * 
	 * @param lottoTip
	 * @param zahlenObergrenze
	 */
	public void lottoArrayGenerieren(int[] lottoTip, int zahlenObergrenze) {
		// Lottotip soll die Zahlen erhalten die Zufällig generiert worden sind
		// Keine Zahl soll doppelt vorkommen.
		Random rnd = new Random();
		// Zufallszahl die eventuell eingetragen wird

		int tipAnwaerter = rnd.nextInt(zahlenObergrenze + 1);
		int anzahlDurchlaeufe = lottoTip.length;

		lottoTip[0] = tipAnwaerter;
		boolean foundDoublette = false;

		for (int index = 1; index < anzahlDurchlaeufe; index++) {

			do {
				tipAnwaerter = rnd.nextInt(zahlenObergrenze + 1);
				// nachsehen, ob bereits vorhanden
				foundDoublette = isValueInArray(tipAnwaerter, index, lottoTip);
				// Debugausgabe.
				//System.out.println("Gefunden:" + foundDoublette + " DoublettenWert:" + tipAnwaerter);
			} while (foundDoublette);

			lottoTip[index] = tipAnwaerter;

		} // end for

	}// end methode

	/**
	 * Durchsucht das uebergebene int Array nach dem SearchVal int.
	 * Das Array wird nur bis zum Eintrag searchGrenze durchsucht, weil wir in diesem Fall 
	 * das Array von unten auffüllen.
	 * @param searchVal
	 * @param searchGrenze
	 * @param searchedArray
	 * @return
	 */
	private boolean isValueInArray(int searchVal, int searchGrenze, int[] searchedArray) {
		boolean retVal = false;

		for (int index = 0; index < searchGrenze; index++) {
			if (searchVal == searchedArray[index]) {
				// bereits vorhanden, suche abbrechen
				retVal = true;
				break;
			}
		} // end for suchen

		return retVal;
	}

}
