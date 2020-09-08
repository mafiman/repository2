/**
 * 
 */
package ml.martin.Application;

/**
 * @author martin
 *
 */
public class Application {

	/**
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("Application Version 01 start");

//		System.out.println("Adresse anlegen und Testausgabe.");
//		// Schritt 1, Adresse anlegen und Testausgabe
//		Address address01 = new Address();
//		address01.printAddress();
//		
//		System.out.println("\nSchritt 2, Fahrzeugtest.");
//		// Schritt 2, Fahrzeugtest.
//		MotorVehicle mot01= new MotorVehicle();
//		mot01.printMotorVehicle();
//		
//		System.out.println("\nTest 2");
//		MotorVehicle m02= new MotorVehicle(new Size(1, 2, 3), 1500, "Lada", 
//				"Herbert Koslowski", 
//				new Address(), 
//				new Address("Auto Müller", "GmbH", "Teststrasse", "12", 44309, "Bochum", false)
//				);
//		m02.printMotorVehicle();
//		System.out.println(" Genauere Abmessungen: "+ m02.getDimensions().toStringExtra());

		System.out.println("\nTest Application Hauptprogramm");

		Address autohersteller = new Address("Autohersteller",  "Autoplatz", "1", 11111, "Autostadt");
		Address autohaus01 = new Address("Peter", "Musterautohaus", "Spielstrasse", "15", 76534, "Bretterbach");
		Address autohaus02 = new Address("Eva", "Musterautohaus", "Milchstrasse", "14", 90234, "Galazien");
		Address autohaus03 = new Address("Luca", "Musterautohaus", "Marktplatz", "2", 80888, "München");

		MotorVehicle car01 = new MotorVehicle(new Size(300, 150, 150), 1300, "JEEP", "", autohersteller, autohaus02);
		MotorVehicle car02 = new MotorVehicle(new Size(350, 130, 130), 1100, "SPORTSCAR", "", autohersteller,
				autohaus03);
		MotorVehicle car03 = new MotorVehicle(new Size(453, 178, 150), 1400, "", "", autohersteller, autohaus01);

		System.out.println("Ausgabetest der drei Fahrzeuge:");
		System.out.println("Fahrzeug 1");
		car01.printMotorVehicle();
		System.out.println(" Genauere Abmessungen: "+ car01.getDimensions().toStringExtra());
		System.out.println("\nFahrzeug 2");
		car02.printMotorVehicle();
		// System.out.println(" Genauere Abmessungen: "+ car02
		// .getDimensions().toStringExtra());
		System.out.println("\nFahrzeug 3");
		car03.printMotorVehicle();
		// System.out.println(" Genauere Abmessungen: "+ car03
		// .getDimensions().toStringExtra());

		System.out.println("\nApplication Test ende.");
	}

	public Application() {
	}
	
}
