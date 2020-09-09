/**
 * Aufgabe 1: Befüllen von Arrays
Legen Sie jeweils ein Array eines beliebigen, ganzzahligen Datentyps der Größe 10 an. Füllen Sie das
Array mit
a) den Zahlen von 1 bis 10 (in dieser Reihenfolge) mittels einer Schleife.
b) den Zahlen von 10 bis 1 (in dieser Reihenfolge) mittels einer Schleife.
c) Zufallszahlen mittels einer Schleife.
Geben Sie das Array nach jeder Füllung wieder aus.
Hinweis: Für die Erzeugung der Zufallszahlen verwenden Sie Methoden der Klasse Random oder
Math.
 */
package ml.martin.AufgabeTag11;

/**
 * @author martin
 *
 */
public class Aufgabe1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		int[] aufgabeArray= new int[10];
		 
		 for (int index=0;index<10; index++) {
			 aufgabeArray[index]=index+1;
		 }
		 System.out.println("Ausgabe a) Array:");
		 for(int valueAusgabe:aufgabeArray ) {
			 System.out.println(valueAusgabe);
		 }
		 System.out.println("-----------------");
		 
		 int value=10;
		 for (int index=0;index<10; index++) {
			 aufgabeArray[index]=value;
			 value--;
		 }
		 System.out.println("Ausgabe b) Array:");
		 for(int valueAusgabe:aufgabeArray ) {
			 System.out.println(valueAusgabe);
		 }
		 System.out.println("-----------------");

		 //int randomInt = (int)Math.round( (Math.random()*10));
		 for (int index=0;index<10; index++) {
			 aufgabeArray[index]= (int)Math.round( (Math.random()*10));
		 }
		 System.out.println("Ausgabe c) Array:");
		 for(int valueAusgabe:aufgabeArray ) {
			 System.out.println(valueAusgabe);
		 }
		 System.out.println("-----------------");
	}
	

}
