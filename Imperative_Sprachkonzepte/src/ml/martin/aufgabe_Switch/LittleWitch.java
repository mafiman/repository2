/**
 * 
 */
package ml.martin.aufgabe_Switch;

/**
 * Erstellen Sie im Folgenden ein Programm namens LittleWitch.java, das die
 * Vormittagsgestaltung der kleinen Hexe gemäß eines bekannten Kindergedichtes
 * beschreibt.
 * 
 * @a Definieren Sie sich dazu eine ganzzahlige Variable namens „clock“, deren
 *    Wert der Reihe nach die Uhrzeiten zwischen 6 und 12 Uhr durchläuft.
 *
 * @b Halten Sie Ihre Ausgabeanweisungen frei von Redundanzen.
 * 
 * @c Verwenden Sie soweit sinnvoll eine Auswahl-Anweisung, um das Verhalten der
 *    kleinen Hexe in Abhängigkeit der aktuellen Uhrzeit festzulegen.
 * 
 * @d Das Programm soll die folgende Ausgabe erzeugen:
 * 
 *    Morgens früh um 6 kommt die kleine Hex. 
 *    Morgens früh um 7 schabt sie gelbe
 *    Rüben. 
 *    Morgens früh um 8 wird Kaffee gemacht. 
 *    Morgens früh um 9 geht sie
 *    in die Scheun'. 
 *    Morgens früh um 10 hackt sie Holz und Spän'. 
 *    Feuert an um 11, 
 *    kocht dann bis um 12: Fröschebein und Krebs und Fisch. Hurtig Kinder
 *    kommt zu Tisch!
 */
public class LittleWitch {
	static String[] aufgabenMittel= { 
			"kommt die kleine Hex"
			, "schabt sie gelbe Rüben"
			, "wird Kaffee gemacht"
			,"geht sie in die Scheun'"
			, "hackt sie Holz und Spän'"
			,""
			,"Fröschebein und Krebs und Fisch.\r\nHurtig Kinder kommt zu Tisch" 
			};
	
	
	public static void main(String[] args) {
		ausgabeArbeitsPlan();
	}

	private static void ausgabeArbeitsPlan() {
		// Uhrzeit zwischen 6 und 12 Uhr inkl.
		for (int clock = 6; clock <= 12; clock++) {
			System.out.println(ausgabeZurUhrzeit(clock)); 
		}
	}

	private static String ausgabeZurUhrzeit(int actClock) {
		String retVal ="";
		retVal= prefixAusgabe(actClock) + actClock + getAufgabenText(actClock);
		return retVal;
	}
	
	private static String prefixAusgabe(int actClock) {
		String retVal= "Morgens früh ";
		if(actClock==11) {
			retVal="Feuert an ";
		}else if (actClock==12)
		{
			retVal="kocht dann bis ";
		}
		retVal += "um ";
		return retVal;
	}

	private static String postfixAusgabe(int actClock) {
		String retVal=".";
		if (actClock==11) {
			retVal=",";
		}else if (actClock==12) {
			retVal="!";
		}
		return retVal;
	}
	
	private static String getAufgabenText(int actClock) {
		String retVal = "\n";
		switch (actClock) {
			case 6:
				retVal += aufgabenMittel[0];
				break;
			case 7:
				retVal += aufgabenMittel[1];
				break;
			case 8:
				retVal += aufgabenMittel[2];
				break;
			case 9:
				retVal += aufgabenMittel[3];
				break;
			case 10:
				retVal += aufgabenMittel[4];
				break;
			case 11:
				retVal = aufgabenMittel[5];
				break;
			case 12:
				retVal += aufgabenMittel[6]; 
				break;
			default:
				retVal = "Keine Aufgabe";
				break;
		}
		retVal+= postfixAusgabe(actClock);
		return retVal;
	}
}
