/** Plots are rectangles that are on an an x and y plane.
 * 
 * @author Michael Amaya
 *
 */
public class Plot {
	private int x;		// The x of the plot
	private int y;		// The y of the plot
	private int width;	//
	private int depth;	//
	
	/** Blank constructor with a default plot
	 * 
	 */
	public Plot() {
		this(0,0,1,1);
	}
	
	/** Copy constructor that gets the attributes of the plot and puts it to this one.
	 * 
	 * @param p The plot to get the attributes from
	 */
	public Plot(Plot p){
		this(p.getX(),p.getY(),p.getWidth(),p.getDepth());
	}
	
	/** Constructor that puts all values of the plot
	 * 
	 * @param x			The x value of the plot
	 * @param y			The y value of the plot
	 * @param width		The width of the plot
	 * @param depth		The depth of the plot
	 */
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	/** Set the x value of the plot
	 * 
	 * @param x What to set X to
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/** Set the y value of the plot
	 * 
	 * @param y What to set Y to
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/** Set the width of the plot
	 * 
	 * @param width What to set the width to
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/** Set the depth of the plot
	 * 
	 * @param depth What to set depth to
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	/** Get the X value of the plot
	 * 
	 * @return The value of x
	 */
	public int getX() {
		return x;
	}
	
	/** Get the Y value of the plot
	 * 
	 * @return The value of y
	 */
	public int getY() {
		return y;
	}
	
	/** Gets the width of the plot
	 * 
	 * @return The value of width
	 */
	public int getWidth() {
		return width;
	}
	
	/** Gets the depth of the plot 
	 * 
	 * @return The value of depth
	 */
	public int getDepth() {
		return depth;
	}
	
	/** Check is this plot overlaps another plot
	 * 
	 * @param plot The plot to compare against
	 * @return True of false depending if the plot overlaps or not.
	 */
	public boolean overlaps(Plot plot) {
		// First rectangle 2 points
		int bottomLeft1X = x;
		int bottomLeft1Y = y;
		
		int topRight1X = x + width;
		int topRight1Y = y + depth;
		
		// Second rectangle 2 points
		int bottomLeft2X = plot.getX();
		int bottomLeft2Y = plot.getY();
		
		int topRight2X = plot.getX() + plot.getWidth();
		int topRight2Y = plot.getY() + plot.getDepth();
		
		// Check the points of rectangle 1 against rectangle2
		// If the first rectangles bottom point X is less than the second rectangles top X, then the rectangle is somewhere
		// left of the right most point of rectangle 2.
		// Return true if the rectangle is inside another rectangle
		if(bottomLeft1X < topRight2X) 
			if(topRight1X > bottomLeft2X)
				if(bottomLeft1Y < topRight2Y) 
					if(topRight1Y > bottomLeft2Y)
						return true;
		
		// Return false if it's not overlapping
		return false;
	}
	
	/** Check is the plot passed in is inside of this plot.
	 * 
	 * @param plot Plot to compare against, will check if plot passed is inside THIS plot
	 * @return True or false depending if this plot contains the plot passed
	 */
	public boolean encompasses(Plot plot) {
		// Essentially checking if all the points are in the less than the outer rectangle (or this)
		if ((plot.getX() >= x) && (plot.getY() >= y) 
			&& ((plot.getX() + plot.getWidth()) <= (x + width))
			&& ((plot.getY() +  plot.getDepth()) <= (y + depth))
			)
				return true;
		
		return false;
	}
	
	/** Gets the information of the plot
	 * 
	 * @return The attributes of the plot
	 */
	public String toString() {
		return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
		
	}
}
