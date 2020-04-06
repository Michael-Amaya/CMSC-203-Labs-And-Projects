/** ManagementCompany handles many plots and makes sure that they don't overlap when adding
 * 
 * @author mikea
 *
 */
public class ManagementCompany {
	private final int MAX_PROPERTY = 5;	// The maximum amount of properties per company
	private double mgmFeePer;				// The management fee
	private String name;					// The name of the company
	private Property[] properties;			// Array to hold all properties in company
	private String taxID;					// The tax ID for the company
	private final int MGMT_WIDTH = 10;		// The max width for the company plot
	private final int MGMT_DEPTH = 10;		// The max depth for the company plot
	private Plot plot;						// The plot for the company
	
	/** Blank constructor to set default plot and attributed
	 * 
	 */
	public ManagementCompany() {
		mgmFeePer = 0;
		name = "";
		taxID = "";
		plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	
	/** Constructor with attributes regarding the ManagementCompany
	 *  With a default plot
	 * 
	 * @param name		The name of the company
	 * @param taxID		The tax ID of the company
	 * @param mgmFee	The management fee of the company
	 */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	
	/** Constructor that sets attributes for the company and plot
	 * 
	 * @param name		The name of the company
	 * @param taxID		The tax ID of the company
	 * @param mgmFee	The management fee for the company
	 * @param x			The x of the plot
	 * @param y			The y of the plot
	 * @param width		The width of the plot
	 * @param depth		The depth of the plot
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		plot = new Plot(x,y, width,depth);
		properties = new Property[MAX_PROPERTY];
	}
	 
	/** Copy constructor that copies attributes from another company
	 * 
	 * @param otherCompany	The other company to copy from
	 */
	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.plot = otherCompany.plot;
		this.properties = otherCompany.properties;
	}
	
	/** Add a property to the array by copying the property provided
	 * 
	 * @param property	Copy a property and add it to the array
	 * @return	If the property is null, return -2. If the property overlaps an existing property, return -4
	 * 			If the property array is already full, return -1. If the property is not inside the company plot, return -3
	 * 			If the property is added, return the index where the property was placed
	 */
	public int addProperty(Property property) {
		// Hold a temporary property
		Property tempProperty;
		
		// Try to make a property with what was provided, if it's null, return -2
		try {
			tempProperty = new Property(property.getPropertyName(), property.getCity(), property.getRentAmount(), property.getOwner(), 
					property.getPlot().getX(), property.getPlot().getY(), property.getPlot().getWidth(), property.getPlot().getDepth());
		} catch (Exception e) {
			return -2;
		}
		
		// Set a counter to get the next index of the array
		int counter = 0;
		
		// Loop through the properties. If the property at the index isn't null, add 1 to counter. If the property overlaps
		// Something else in the array, return -4
		for(Property prop : properties)
			if(prop != null) {
				counter ++;
				if(prop.getPlot().overlaps(tempProperty.getPlot())) {
					return -4;
				}
			}
		
		// Check if the array is full, if it is, return -1
		if(counter > MAX_PROPERTY - 1) {
			return -1;
		}
		
		// If the property is inside the company plot, put the property in the array and return the index
		if(plot.encompasses(tempProperty.getPlot())) {
			properties[counter] = tempProperty;
			
			tempProperty = null;
			return counter;
		}
		
		// If it's not in the plot, return -3
		return -3;
	}
	
	/** Add a property with a default plot
	 * 
	 * @param name	The name of the property
	 * @param city	The city of the property
	 * @param rent	The rent of the property
	 * @param owner	The owner of the property
	 * @return		If the property is null, return -2. If the property overlaps an existing property, return -4
	 * 				If the property array is already full, return -1. If the property is not inside the company plot, return -3
	 * 				If the property is added, return the index where the property was placed
	 */
	public int addProperty(String name, String city, double rent, String owner) {
		// Hold a temporary property
		Property tempProperty;
		
		// Try to make a property with what was provided, if it's null, return -2
		try {
			tempProperty = new Property(name, city, rent, owner);
		} catch (Exception e) {
			return -2;
		}
		
		// Set a counter to get the next index of the array
		int counter = 0;
		
		// Loop through the properties. If the property at the index isn't null, add 1 to counter. If the property overlaps
		// Something else in the array, return -4
		for(Property prop : properties)
			if(prop != null) {
				counter ++;
				if(prop.getPlot().overlaps(tempProperty.getPlot())) {
					return -4;
				}
			}
		
		// Check if the array is full, if it is, return -1
		if(counter > MAX_PROPERTY - 1)
			return -1;
		
		// If the property is inside the company plot, put the property in the array and return the index
		if(plot.encompasses(tempProperty.getPlot())) {
			
			properties[counter] = tempProperty;
			
			tempProperty = null;
			return counter;
		}
		
		// If it's not in the plot, return -3
		return -3;
	}
	
	/** Add a property with a custom plot
	 * 
	 * @param name	The name of the property
	 * @param city	The city of the property
	 * @param rent	The rent of the property
	 * @param owner	The owner of the property
	 * @param x		The x of the plot
	 * @param y		The y of the plot
	 * @param width	The width of the plot
	 * @param depth	The depth of the plot
	 * @return		If the property is null, return -2. If the property overlaps an existing property, return -4
	 * 				If the property array is already full, return -1. If the property is not inside the company plot, return -3
	 * 				If the property is added, return the index where the property was placed
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		// Hold a temporary property
		Property tempProperty;
		
		// Try to make a property with what was provided, if it's null, return -2
		try {
			tempProperty = new Property(name, city, rent, owner, x, y, width, depth);
		} catch (Exception e) {
			return -2;
		}
		
		// Set a counter to get the next index of the array
		int counter = 0;
		
		// Loop through the properties. If the property at the index isn't null, add 1 to counter. If the property overlaps
				// Something else in the array, return -4
		for(Property prop : properties)
			if(prop != null) {
				counter ++;
				if(prop.getPlot().overlaps(tempProperty.getPlot())) {
					return -4;
				}
			}
		
		// Check if the array is full, if it is, return -1
		if(counter > MAX_PROPERTY - 1)
			return -1;
		
		// If the property is inside the company plot, put the property in the array and return the index
		if(plot.encompasses(tempProperty.getPlot())) {;
			
			properties[counter] = tempProperty;
			
			tempProperty = null;
			return counter;
		}
		
		// If it's not in the plot, return -3
		return -3;
	}
	
	/** Display the property at the index provided
	 * 
	 * @param i	What index to get the property at
	 * @return	The property information at index i
	 */
	public String displayPropertyAtIndex(int i) {
		return properties[i].toString();
	}
	
	/** Gets the max property limit
	 * 
	 * @return The value of MAX_PROPERTY
	 */
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	
	/** Gets the property with the max rent
	 * 
	 * @return The property information with the max rent
	 */
	public String maxRentProp() {
		// Hold the max rent amount
		double max = 0;
		// Set the default property
		Property prop1 = properties[0];
		// Loop through all properties and if it's not null, check if the max is bigger than the current rentAmount
		// If it is, set the max and property
		for(Property prop : properties) {
			if(prop != null) {
				if(prop.getRentAmount() > max) {
					max = prop.getRentAmount();
					prop1 = prop;
				}
			}
		}
		
		// Return the max property
		return prop1.toString();
	}
	
	/** Gets the index with the max rent amount
	 * 
	 * @return The index at which there is the max rent
	 */
	public int maxRentPropertyIndex() {
		// Variables to hold the 
		double max = 0;
		int maxIndex = 0;
		int counter = 0;
		
		// Loop through all the properties. If it's not null, then check the max against the current property maxRentAmount
		// Return the max index after it found the max
		for(Property prop : properties) {
			if(prop != null) {
				if(prop.getRentAmount() > max) {
					max = prop.getRentAmount();
					maxIndex = counter;
				}
				
				counter++;
			}
		}
		
		// Return the max index
		return maxIndex;
	}
	
	/**	Gets the whole properties array attributes
	 * 
	 * @return The attributes of all properties
	 * 
	 */
	public String toString() {
		StringBuilder allProperties = new StringBuilder();
		for (Property prop : properties)
			if(prop != null)
				allProperties.append(prop.toString()).append("\n\n");
		
		return allProperties.toString();
	}
	
	/** Loop through all properties and add to get the sum
	 * 
	 * @return The sum of all property rent
	 */
	public double totalRent() {
		double sum = 0;
		for (Property prop : properties)
			if (prop != null)
				sum += prop.getRentAmount();
		return sum;
	}
	
	/** Gets the plot the Management company is using
	 * 
	 * @return The reference to the company's plot
	 */
	public Plot getPlot() {
		return plot;
	}
	
	/** Sets the company plot
	 * 
	 * @param plot The plot to set the company's to
	 */
	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	
	/** Gets the name of the company
	 * 
	 * @return The value of name
	 */
	public String getName() {
		return name;
	}
	
	/** Sets the name to what was passed
	 * 
	 * @param name What to set the name to
	 */
	public void setName(String name) {
		this.name = name;
	}
}
