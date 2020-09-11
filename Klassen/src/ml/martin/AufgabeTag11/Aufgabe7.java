/**
 * Aufgabe 7: Lottozahlen und Häufigkeiten
Erstellen Sie ein int-Array mit mindestens 5000 Elementen. 
Füllen Sie dieses Array mit Zufallszahlen
mit Zahlen zwischen 0 und 9. 
Legen Sie ein weiteres Array an, in dem Sie die Häufigkeit der Zahlen
von 0 bis 9 des ersten Arrays zählen (d.h. wie oft kommt z.B. die 0 in dem ersten Array vor, 
wie oftdie 1, usw.). Geben Sie anschließend den Inhalt des zweiten Arrays 
auf dem Bildschirm aus.

Beispielhafte Ausgabe:
Häufigkeit von 0 ist 497
Häufigkeit von 1 ist 510
Häufigkeit von 2 ist 511
Häufigkeit von 3 ist 509
Häufigkeit von 4 ist 525
Häufigkeit von 5 ist 502
Häufigkeit von 6 ist 471
Häufigkeit von 7 ist 514
Häufigkeit von 8 ist 484
Häufigkeit von 9 ist 477 
 */
package ml.martin.AufgabeTag11;


import java.util.Random;

/**
 * @author martin
 *
 */
public class Aufgabe7 {

	/**
	 *  
	 */
	public static void main(String[] args) {
		
		final int TIPZAHLEN_OBERGRENZE = 9;
		final int ANZAHL_TIPZAHLEN = 50000;
		// Array vorbereiten
		int[] lottoZahlen = new int[ANZAHL_TIPZAHLEN];
		int[] lottoAuswertung = new int[TIPZAHLEN_OBERGRENZE+1];
		Aufgabe7 aufgabe = new  Aufgabe7();
		
		System.out.println("Lottozahlen vorbereiten.");
		aufgabe.lottoArrayGenerieren(lottoZahlen, TIPZAHLEN_OBERGRENZE);
		
		System.out.println("Lottozahlen Verteilung auswerten");
		aufgabe.verteilungErmitteln(lottoZahlen, lottoAuswertung);
		
		// Ausgabe der Haeufigkeiten
		int indexTipzahlen=0;
		for(int haeufigkeit: lottoAuswertung) {
			System.out.println("Haeufigkeit von "+indexTipzahlen+ " ist "+haeufigkeit);
			indexTipzahlen++;
		}
		
		// Gegentest:
		System.out.print("\nGegentest, Summe der Haeufigkeiten:");
		int summe= 0;
		for (int index:lottoAuswertung) {
			summe+=index;
		}
		System.out.println(summe);
		
		System.out.println("Fertig.");
	}
	
	/**
	 * Methode generiert in ein uebergebenes Array eine Mege Zufallszahlen mit der
	 * Obergrenze, die als zweiter Parameter angegeben ist.
	 * Diesmal mit erlaubten Doubletten
	 * 
	 * @param lottoTip
	 * @param zahlenObergrenze
	 */
	public void lottoArrayGenerieren(int[] lottoTip, int zahlenObergrenze) {
		// Lottotip soll die Zahlen erhalten die Zufällig generiert worden sind
		Random rnd = new Random();
		int anzahlDurchlaeufe = lottoTip.length;
		for (int index = 0; index < anzahlDurchlaeufe; index++) {
			// Zufallszahl die eingetragen wird
			lottoTip[index] =  rnd.nextInt(zahlenObergrenze + 1);		
		} // end for
	}// end methode
	/**
	 * Verteilung der Zahlen im Lottozahlen Array berechnen.
	 * @param lottoZahlen Die gezogenen Zahlen
	 * @param lottoAuswertung Die Auswertung, wie haeufig die Zahl des index
	 * in den gezogenen Zahlen vorkommt.
	 */
	public void verteilungErmitteln(int []lottoZahlen, int[] lottoAuswertung) {
		// auswertung MUSS kleiner lottoTip sein,
		// beide muessen >0 sein
		if ((lottoZahlen.length<lottoAuswertung.length)|| 
				lottoAuswertung.length==1 || 
				lottoZahlen.length==1) {
			return;
		}
		
		for (int index=0; index<lottoZahlen.length; index++) {
			lottoAuswertung[lottoZahlen[index]]++; 
		}
			
	}// end methode
	
}
