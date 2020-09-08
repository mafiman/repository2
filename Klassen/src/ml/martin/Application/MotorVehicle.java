/**
 * 
 */
package ml.martin.Application;

/**
 * @author martin
 *
 */
public class MotorVehicle {
	// private static Attribute

	// private Attribute
	private Size dimensions;
	private double weight;
	private String brand;
	private String customer;
	private Address startAddress;
	private Address destinationAddress;

	// public setter /getter
	/**
	 * @return the dimensions
	 */
	public Size getDimensions() {
		return this.dimensions;
	}

	/**
	 * @param dimensions the dimensions to set
	 */
	public void setDimensions(Size dimensions) {
		this.dimensions = dimensions;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return this.weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return this.brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the customer
	 */
	public String getCustomer() {
		return this.customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	/**
	 * @return the startAddress
	 */
	public Address getStartAddress() {
		return this.startAddress;
	}

	/**
	 * @param startAddress the startAddress to set
	 */
	public void setStartAddress(Address startAddress) {
		this.startAddress = startAddress;
	}

	/**
	 * @return the destinationAddress
	 */
	public Address getDestinationAddress() {
		return this.destinationAddress;
	}

	/**
	 * @param destinationAddress the destinationAddress to set
	 */
	public void setDestinationAddress(Address destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	// Konstruktoren ohne Parameter, mit std Parametern
	/**
	 * Konstruktor mit statischer Initialisierung 
	 */
	public MotorVehicle() {
		this.setDimensions(new Size());
		this.setCustomer( "Heinz Strunk");
		this.setStartAddress(new Address());
		this.setDestinationAddress(new Address());
		this.setBrand("Testfahrzeug");
		this.setWeight(1000);
	}
/**
 * Konstruktor mit parameteriserter Initialisierung 
 * @param dimensions
 * @param weight
 * @param brand
 * @param customer
 * @param startAddress
 * @param destinationAddress
 */
	public MotorVehicle(Size dimensions, double weight, String brand, 
			String customer,
			Address startAddress,
			Address destinationAddress 
			) {

		this.setDimensions(dimensions);
		this.setCustomer(customer);
		this.setStartAddress(startAddress);
		this.setDestinationAddress(destinationAddress);
		this.setBrand(brand);
		this.setWeight(weight);
	}

	// Standartmethoden toString() equals() hash()

	// methoden allegemein
	public void  printMotorVehicle() {
		System.out.println("Größe des Fahrzeugs: "+
			this.getDimensions().getLength()+"cm x "+
			this.getDimensions().getWidth()+"cm x "+
			this.getDimensions().getHeight()+"cm");
		System.out.println("Gewicht: "+this.getWeight()+" kg");
		System.out.println("Automarke: "+this.getBrand());
		System.out.print("Absenderadresse: ");
		this.getStartAddress().printAddress();
		System.out.print("Zieladresse: ");
		this.getDestinationAddress().printAddress();
	}

}
