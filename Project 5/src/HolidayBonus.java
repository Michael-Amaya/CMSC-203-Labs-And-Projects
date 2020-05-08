/** Collection of methods that calculates the holiday bonus based on 2d arrays
 * 
 * @author Michael Amaya
 *
 */
public class HolidayBonus {
	
	/** Calculates the holiday bonus for multiple categories
	 * 
	 * @param data The 2d array to work with
	 * @param high The bonus for the highest in its category
	 * @param low The bonus for the lowest in the category
	 * @param other The bonus for all other in the category
	 * @return An array with bonuses for the categories
	 */
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		double[] bonus = new double[data.length]; // Create bonus array to hold the bonuses for every category
		
		// Loop through every row
		for (int i = 0; i < data.length; i++) {
			// Loop through every column
			for (int k = 0; k < data[i].length; k++) {
				// Check if the current column in the data with row i is the highest in its column
				if (data[i][k] > 0) {
					if (data[i][k] == TwoDimRaggedArrayUtility.getHighestInColumn(data, k))
						// If it is, add a high bonus to the current row i
						bonus[i] += high;
					// If not, check if it's the lowest in its column
					else if (data[i][k] == TwoDimRaggedArrayUtility.getLowestInColumn(data, k))
						// If it is, add a low bonus to the current row i
						bonus[i] += low;
					else
					// If it's neither the highest or the lowest, then give it the other bonus
						bonus[i] += other;
					}
			}
			
		}
		
		// Return the bonus array with the calculated bonuses
		return bonus;
	}
	
	/** Calculates the total of all bonuses for every category
	 * 
	 * @param data The 2d array to be queried
	 * @param high The bonus for the category with the highest sales
	 * @param low The bonus for the category with the lowest sales
	 * @param other The bonus for all other categories
	 * @return The total of all bonuses for all categories
	 */
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		double[] bonus = new double[data.length]; // Create bonus array to hold the bonuses for every category
		double sum = 0;
		
		// Loop through every row
		for (int i = 0; i < data.length; i++) {
			// Loop through every column
			for (int k = 0; k < data[i].length; k++)
				// Check if the data is above 0 before calculating the bonus
				if (data[i][k] > 0) {
					// Check if the current column in the data with row i is the highest in its column
					if (data[i][k] == TwoDimRaggedArrayUtility.getHighestInColumn(data, k))
						// If it is, add a high bonus to the current row i
						bonus[i] += high;
					// If not, check if it's the lowest in its column
					else if (data[i][k] == TwoDimRaggedArrayUtility.getLowestInColumn(data, k))
						// If it is, add a low bonus to the current row i
						bonus[i] += low;
					else
						// If it's neither the highest or the lowest, then give it the other bonus
						bonus[i] += other;
				}
			
		}
		
		// Loop through the bonus array
		for (int i = 0; i < bonus.length; i++)
			// Add every value in the bonus to the sum
			sum += bonus[i];
		
		// Return the sum of the array
		return sum;
	}
}
