/**
 * Aufgabe 3: Befüllen von Arrays und Berechnungen
Legen Sie ein Array eines beliebigen, ganzzahligen Datentyps mit der Größe 10 an. Füllen Sie das
Array mit Zufallszahlen.
Lassen Sie das Array ausgeben.
Vertauschen Sie alle Zahlen im Array miteinander, d.h. die erste Zahl wird zur letzten Zahl, die zweite
Zahl wird zur vorletzten Zahl, usw. Führen Sie den Tausch so durch, dass Sie kein weiteres Array
anlegen müssen.
 */
package ml.martin.AufgabeTag11;

/**
 * @author martin
 *
 */
public class Aufgabe3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int ANZAHL_WERTE = 10;
		int[] aufgabeArray = new int[ANZAHL_WERTE];

		for (int index = 0; index < 10; index++) {
			aufgabeArray[index] = index + 1;
		}
		System.out.println("Ausgabe vor vertauschen Array:");
		for (int valueAusgabe : aufgabeArray) {
			System.out.println(valueAusgabe);
		}
		System.out.println("-----------------");

		// Vertauschen der Werte,
		// 9 mit 0
		// 8 mit 1
		int tmpValue = 0;
		int index2 = 0;
		for (int index = 0; index < 5; index++) {
			index2 = aufgabeArray.length - 1 - index;
			System.out.println("Wert aus " + index + " vertauschen mit Wert aus " + index2);
			// Austauschen der Werte
			tmpValue = aufgabeArray[index2];
			aufgabeArray[index2] = aufgabeArray[index];
			aufgabeArray[index] = tmpValue;
		}

		System.out.println("Ausgabe nach vertauschen Array:");
		for (int valueAusgabe : aufgabeArray) {
			System.out.println(valueAusgabe);
		}
		System.out.println("-----------------");

	}

}
