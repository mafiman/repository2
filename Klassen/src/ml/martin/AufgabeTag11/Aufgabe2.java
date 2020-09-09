/**
 * Aufgabe 2: Befüllen von Arrays und Berechnungen
 Legen Sie ein Array eines beliebigen, ganzzahligen Datentyps mit beliebiger Größe an. Füllen Sie das
Array mit Zufallszahlen.
Führen Sie dann folgende Berechnungen durch:
1. berechnen Sie die Summe aller Zahlen in dem Array
2. berechnen Sie den Mittelwert aller Zahlen im Array und geben diesen aus
3. finden Sie die kleinste Zahl im Array
4. finden Sie die größte Zahl im Array
Hinweis: Verwenden Sie Methoden der Klasse Math. 
 */
package ml.martin.AufgabeTag11;

/**
 * @author martin
 *
 */
public class Aufgabe2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int ANZAHL_WERTE = 10;
		int[] aufgabeArray = new int[ANZAHL_WERTE];
		for (int index = 0; index < ANZAHL_WERTE; index++) {
			aufgabeArray[index] = (int) Math.round((Math.random() * 100));
		}
		System.out.println("Ausgabe Array:");

		// Berechnung der ggesuchten Werte
		// Summe aller Zahlen im Array:
		int summe = 0;
		int average = 0;
		int max = 0;
		int min = 100;

		for (int valueAusgabe : aufgabeArray) {
			System.out.println(valueAusgabe);
			summe = summe + valueAusgabe;
			// Minimum berechnen
			min=Math.min( min , valueAusgabe);
//			if (min >= valueAusgabe) {
//				min = valueAusgabe;
//			}

			// maximum berechnen
			max=Math.max( max , valueAusgabe);
//			if (max <= valueAusgabe) {
//				max = valueAusgabe;
//			}
		}
		average = (int) Math.round(summe / ANZAHL_WERTE);

		System.out.println("-----------------");
		System.out.println("Summe aller Werte im Array:" + summe);
		System.out.println("Mittelwert aller Werte im Array:" + average);
		System.out.println("Maximalwert aller Werte im Array:" + max);
		System.out.println("Minimalwert aller Werte im Array:" + min);

	}

}
