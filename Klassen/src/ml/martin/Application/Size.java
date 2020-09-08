package ml.martin.Application;

public class Size {
	 /**
	  * Laenge
	  */
		private double length;
		/**
		 * Breite
		 */
		private double width;
		/**
		 * Hoehe 
		 */
		private double height;

		/**
		 * @return the length
		 */
		public double getLength() {
			return this.length;
		}

		/**
		 * @param length the length to set
		 */
		public void setLength(double length) {
			this.length = length;
		}

		/**
		 * @return the width
		 */
		public double getWidth() {
			return this.width;
		}

		/**
		 * @param width the width to set
		 */
		public void setWidth(double width) {
			this.width = width;
		}

		/**
		 * @return the height
		 */
		public double getHeight() {
			return this.height;
		}

		/**
		 * @param height the height to set
		 */
		public void setHeight(double height) {
			this.height = height;
		}

		/**
		 * Konstruktor mit 0 in jeder Dimension.
		 */
		public Size() {
			this.setHeight(0);
			this.setLength(0);
			this.setWidth(0);
		}

		/**
		 * Konstruktor der die Abmessungen in jeder Dimension als Parameter erwartet.
		 * @param height
		 * @param width
		 * @param length
		 */
		public Size( double height,double width, double length  ) {
			this.setHeight(height);
			this.setLength(length);
			this.setWidth(width);
		}
		
		/**
		 * String der Abmessungen und der Masseinheiten.
		 */
		@Override
		public String toString() {
			return (this.getLength() + "cm x" + this.getWidth() + "cm x" + getHeight() + "cm");
		}
		/**
		 * Ausfuehrliche Ausgabe der Abmessungen mit Angabe von Dimension und Masseinheit.
		 * @return
		 */
		public String toStringExtra() {
			return ("Laenge: " + this.getLength() + "cm x Breite: " + this.getWidth() + "cm x Hoehe:" + this.getHeight()
					+ "cm");
		}
}
