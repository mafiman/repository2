/*
 * Aufgabe:
 * Schreiben Sie ein Programm mit den Variablen „vorname“ und „nachname“ jeweils
 * vom Typ „string“. Initialisieren Sie diese beiden Variablen mit Ihrem Vor-
 * und Nachnamen. 
 * Erzeugen Sie eine weitere Variable „name“. Der Inhalt dieser
 * Variablen soll die Kombination aus der Variablen vorname und der Variablen
 * nachname sein. Geben Sie den Inhalt dieser Variablen aus. 
 * Erweitern Sie das Programm anschließend so, dass es die Länge des Vornamens, 
 * des Nachnamens und des kompletten Namens ausgibt.
 * Erweitern Sie das obige Programm um eine Variable „kuerzel“. 
 * Diese Variable soll Ihre Initialen enthalten. Ermitteln
 * Sie diese Initialen aus den Variablen „vorname“ und Nachname.
 */ 
package ml.martin.aufgabenMitStrings;

/**
 * @author martin
 *
 */

public class Aufgabe1 {

	private static String vorname;
	private static String nachname;
	private static String name;

	/**
	 *  
	 */
	public static void main(String[] args) {
		vorname = "Martin";
		nachname = "Fitzke";
		name = vorname + " " + nachname;
		String kuerzel;
		
		System.out.println("Mein Name ist " + name);
		
		System.out.println("Die Länge meines Vornamens ist:"+ vorname.length());
		System.out.println("Die Länge meines Nachnamens ist:"+ nachname.length());
		System.out.println("Die Länge meines ganzen Namens ist:"+ name.length());
		
		kuerzel = ""+vorname.charAt(0) + "."+ nachname.charAt(0)+".";
		System.out.println("Mein Kürzel ist: "+ kuerzel);
	}

}
