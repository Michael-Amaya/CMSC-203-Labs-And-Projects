/** Property class keeps track of a Property, its plot, city,
 *  owner, propertyName, and rentAmount
 * 
 * @author Michael Amaya
 *
 */
public class Property {
	private String city;			// City of the property
	private String owner;			// Owner of the property
	private String propertyName;	// Name of the property
	private double rentAmount;		// Rent of the property
	private Plot plot;				// Plot of the property
	
	/** Blank constructor to set default values to the class
	 * 
	 */
	public Property() {
		city = "";
		owner = "";
		propertyName = "";
		rentAmount = 0;
		plot = new Plot();
	}
	
	/** Copy constructor to copy values from one property to another
	 * 
	 * @param p The property to get the info from
	 */
	public Property(Property p) {
		city = p.city;
		owner = p.owner;
		propertyName = p.propertyName;
		rentAmount = p.rentAmount;
		plot = p.plot;
	}
	
	/** Constructor, A property with Property attributes, create a blank plot
	 * 
	 * @param propertyName	The name of the property
	 * @param city			The city the property is located in
	 * @param rentAmount	The rent for the property
	 * @param owner			The owner of the property
	 */
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.city = city;
		this.owner = owner;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
		plot = new Plot();
	}
	
	/** Constructor, A property with Property values, and custom Plot
	 * 
	 * @param propertyName	The name of the property
	 * @param city			The city the property is located in
	 * @param rentAmount	The rent for the property
	 * @param owner			The owner of the property
	 * @param x				The x of the plot
	 * @param y				The y of the plot
	 * @param width			 The width of the plot
	 * @param depth			
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.city = city;
		this.owner = owner;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
		plot = new Plot(x,y,width,depth);
	}
	
	/** Gets the city the property is located in
	 * 
	 * @return The value of city
	 */
	public String getCity() {
		return city;
	}
	
	/** Gets the property's owner
	 * 
	 * @return The value of owner
	 */
	public String getOwner() {
		return owner;
	}
	
	/** Gets the property's name
	 * 
	 * @return The value of propertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}
	
	/** Gets the rent amount of the property
	 * 
	 * @return The value of rentAmount
	 */
	public double getRentAmount() {
		return rentAmount;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	/** Sets the owner to what the user input
	 * 
	 * @param owner What to set owner to
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	/** Sets the name of the property to what the user put
	 * 
	 * @param propertyName What to set the propertyName to
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	/** Method that returns the attributes for Property
	 * 
	 * @return Returns attributes for Property
	 * 
	 */
	@Override
	public String toString() {
		return "Property Name: " + propertyName + "\n"
				+ "Located in " + city + "\n"
				+ "Belonging to: " + owner + "\n"
				+ "Rent amount: " + rentAmount;
	}
	
	/** Gets the plot for the property
	 * 
	 * @return The reference to plot
	 */
	public Plot getPlot() {
		return plot;
	}
	
	/** Sets the plot to what the user input
	 *  
	 * @param plot What to set plot to
	 */
	public void setPlot(Plot plot) {
		this.plot = plot;
	}
}
