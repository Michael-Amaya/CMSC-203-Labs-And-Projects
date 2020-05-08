import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**	Work with 2 dimensional arrays and manipulate them
 * 
 * @author Michael Amaya
 *
 */
public final class TwoDimRaggedArrayUtility {

	/** Gets the average of the entire array
	 * 
	 * @param data The 2d array to be queried
	 * @return The average of the array
	 */
	public static double getAverage(double[][] data) {
		double sum = 0;	// The sum of the entire array
		int count = 0;	// The number of items of the array
		
		// Loop through all rows of the array
		for (int i = 0; i < data.length; i++)
			// Loop through each number in the array
			for (int k = 0; k < data[i].length; k++) {
				// Add 1 to count for the average calculation and add the current data to the sum
				count++;
				sum += data[i][k];
			}
		
		// Average formula: the sum / the count of items
		return sum / count;
	}
	
	/** Gets the total of a column in a 2d array
	 * 
	 * @param data The array to be queried
	 * @param col The column to check
	 * @return The total of the column
	 */
	public static double getColumnTotal(double[][] data, int col) {
		double sum = 0;	// The sum of the column
		
		// Loop through the length of the array
		// Make sure that the col is in bounds
		for (int i = 0; i < data.length; i++) {
			// If it's true, then add the current data col into the sum
			if ( col < data[i].length) {
				sum += data[i][col];
			}
		}
		
		// If the col is not in bounds, then just ignore it, it'd be 0 anyways
		
		// Return the column sum
		return sum;
	}
	
	/** Gets the highest number in the 2d array
	 * 
	 * @param data The array to be queried
	 * @return The highest number in the array
	 */
	public static double getHighestInArray(double[][] data) {
		double highest = data[0][0]; // Hold the highest in array, 0, 0 is just a starter
		
		// Loop through all rows
		for (int i = 0; i < data.length; i++)
			// Loop through all columns
			for (int k = 0; k < data[i].length; k++) 
				// Check if the current item is bigger than the current highest
				if (data[i][k] > highest)
					// If it is, set that as the highest
					highest = data[i][k];
		
		// Return the computed highest
		return highest;
	}
	
	/** Gets the highest number in a column
	 * 
	 * @param data The 2d array to be queried
	 * @param col The column to check
	 * @return The highest number in the column
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		double highest = Double.MIN_VALUE; // Highest with a starting point as the first row with passed column
		// Loop through the rows
		for (int i = 0; i < data.length; i++)
			// Check if the column is in bounds
			if (col < data[i].length) {
				// If it is, check if the current data is higher than the current higher
				if (data[i][col] > highest) 
					// If it is, set that as the highest
					highest = data[i][col];
			}
			
		// Return computed highest
		return highest;
	}
	
	/** Gets the index of the highest in the column
	 * 
	 * @param data The 2d array to be queried
	 * @param col The column to check
	 * @return The highest number in the column requested of the array
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double highest = data[0][col]; // Highest with a starting point as the first row with passed column
		int highestIndex = 0;
		
		// Loop through the rows
		for (int i = 0; i < data.length; i++)
			// Check if the column is in bounds
			if (col < data[i].length)
				// If it is, check if the current data is higher than the current higher
				if (data[i][col] > highest) {
					// If it is, set that as the highest and set the index
					highest = data[i][col];
					highestIndex = i;
				}
			
		// Return computed highest index
		return highestIndex;
	}
	
	/** Gets the highest number in the row
	 * 
	 * @param data The 2d array to be queried
	 * @param row The row to check
	 * @return The highest number in the row submitted
	 */
	public static double getHighestInRow(double[][] data, int row) {
		double highest = data[row][0]; // Highest with a starting point of the first item in the row selected
		
		// Loop through the columns in the row selected
		for (int i = 0; i < data[row].length; i++) 
			// Check if the current column in the row is the higher than the current highest
			if (data[row][i] > highest) 
				// If it is, set that as the highest
				highest = data[row][i];
		
		// Return the computed highest
		return highest;
	}
	
	/** Gets the index of the highest number in the row
	 * 
	 * @param data The 2d array to be queried
	 * @param row The row to check in the array
	 * @return The index with the highest number in the row of the array
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		double highest = data[row][0]; // Highest with a starting point of the first item in the row selected
		int highestIndex = 0;
		
		// Loop through the columns in the row selected
		for (int i = 0; i < data[row].length; i++) 
			// Check if the current column in the row is the higher than the current highest
			if (data[row][i] > highest)  {
				// If it is, set that as the highest and set the index to i
				highest = data[row][i];
				highestIndex = i;
			}
		
		// Return the computed highest
		return highestIndex;
	}
	
	/** Gets the lowest number in the array
	 * 
	 * @param data The 2d array to be queried
	 * @return The lowest number in the array
	 */
	public static double getLowestInArray(double[][] data) {
		double lowest = data[0][0]; // Hold lowest with starting point at the first item in array
		
		// Loop through every row
		for (int i = 0; i < data.length; i++)
			// Loop through each column
			for (int k = 0; k < data[i].length; k++)
				// Check if the current data is lower than the current lowest
				if (data[i][k] < lowest)
					// If it is, set that as the lowest in the array
					lowest = data[i][k];
		
		// Return the computed lowest in array
		return lowest;
	}
	
	
	/** Gets the lowest number in the column
	 * 
	 * @param data The 2d array to be queried
	 * @param col The column to check for in the 2d array
	 * @return The lowest item in the 2d array
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		double lowest = Double.MAX_VALUE; // Hold lowest with starting point at the first row with selected column
		
		// Loop through the rows 
		for (int i = 0; i < data.length; i++) 
			// Check if the column is in bounds
			if (col < data[i].length)
				// If it is, check if the current data is less than the lowest
				if (data[i][col] < lowest)
					// If it is, set the lowest to the current data
					lowest = data[i][col];
		
		// Return the calculated lowest
		return lowest;
	}
	
	/** Gets the index of the lowest number in a column
	 * 
	 * @param data The 2d array to be queried
	 * @param col The column to check over
	 * @return The index with the lowest number in the selected column
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double lowest = data[0][col]; // Hold lowest with starting point at the first row with selected column
		int lowestIndex = 0; // Lowest index starter
		
		// Loop through the rows 
		for (int i = 0; i < data.length; i++) 
			// Check if the column is in bounds
			if (col < data[i].length)
				// If it is, check if the current data is less than the lowest
				if (data[i][col] < lowest) {
					// If it is, set the lowest to the current data and set the index to i
					lowest = data[i][col];
					lowestIndex = i;
				}
		
		// Return the calculated lowest
		return lowestIndex;
	}
	
	/** Gets The lowest in the row
	 * 
	 * @param data The 2d array to be queried
	 * @param row The row to check
	 * @return The lowest number in the row requested
	 */
	public static double getLowestInRow(double[][] data, int row) {
		double lowest = data[row][0]; // Holds lowest, starting at the first item in the row selected
		
		// Loop through the columns in the row selected
		for (int i = 0; i < data[row].length; i++)
			// Check if the current data in the row is less than the lowest
			if (data[row][i] < lowest)
				// if it is, set the lowest to the current data
				lowest = data[row][i];
		
		// Return the computed lowest
		return lowest;
	}
	
	/** Gets the index of the lowest number in the row
	 * 
	 * @param data The 2d array to be queried
	 * @param row The row to check
	 * @return The index of the lowest number in the row
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		double lowest = data[row][0]; // Holds lowest, starting at the first item in the row selected
		int lowestIndex = 0; // Starting point for lowest index
		
		// Loop through the columns in the row selected
		for (int i = 0; i < data[row].length; i++)
			// Check if the current data in the row is less than the lowest
			if (data[row][i] < lowest) {
				// if it is, set the lowest to the current data and the index to i
				lowest = data[row][i];
				lowestIndex = i;
			}
		
		// Return the computed lowest
		return lowestIndex;
	}
	 
	/** Gets the total of the row
	 * 
	 * @param data The 2d array to be queried
	 * @param row The row to check
	 * @return The total of the entire row selected
	 */
	public static double getRowTotal(double[][] data, int row) {
		double sum = 0;
		
		// Loop through the columns in the row
		for (int i = 0; i < data[row].length; i++)
			// Add the columns in to the sum
			sum += data[row][i];
		
		// Return the sum of the row's columns
		return sum;
	}
	
	/** Gets the total of the entire array
	 * 
	 * @param data The 2d array to be queried
	 * @return The total of every number in the array
	 */
	public static double getTotal(double[][] data) {
		double sum = 0;	// The sum of the entire array
		
		// Loop through all rows of the array
		for (int i = 0; i < data.length; i++)
			// Loop through each number in the array
			for (int k = 0; k < data[i].length; k++) {
				// Add the current data into the sum
				sum += data[i][k];
			}
		
		// Like the average, but just getting the sum is all
		return sum;
	}
	
	/** Reads a file and converts it to a 2d array
	 * 
	 * @param file The file to be read
	 * @return A 2d array with the contents of the file
	 */
	public static double[][] readFile(java.io.File file) {
		int numRows = 0;					// Number of rows in the file
		String nextLine;					// The next line in the file
		Scanner dataReader;					// The scanner used to read the data
		double[][] data = new double[0][];	// Random initialization to get rid of errors, will get this if theres an error
		
		// Make sure file even exists!
		try {
			// Get number of rows first
			dataReader = new Scanner(file);
			while (dataReader.hasNextLine()) {
				numRows++;
				dataReader.nextLine();
			}
			
			// Reset the dataReader
			dataReader.close();
			
			// Reread file, but fill contents of array
			dataReader = new Scanner(file);
			
			// Make a data field with the correct number of rows
			data = new double[numRows][];
			
			// Loop through the length of the data or how many rrows
			for (int i = 0; i < numRows; i++) {
				
				// Array to hold the numbers in the line
				String[] nextNumbers;
				
				// Get the next line
				nextLine = dataReader.nextLine();
				
				// Put the numbers individually
				nextNumbers = nextLine.split(" ");
				
				// Create another array inside the array with the length of the numbers array
				data[i] = new double[nextNumbers.length];
				
				// Loop through the length of the numbers array
				for (int k = 0; k < nextNumbers.length; k++) {
					// Put the double into the two dimensional array
					data[i][k] = Double.parseDouble(nextNumbers[k]);
				}
			}
			
		// Catch an error if the file wasn't found, just print the stack trace
		// But this shouldn't happen since a file dialog is being used..
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		}
		
		// Return the data, whether or not it failed
		return data;
	}
	
	/** Writes the data to a file
	 * 
	 * @param data The 2d array to be queried
	 * @param outputFile Where to dump the array
	 */
	public static void writeToFile(double[][] data, java.io.File outputFile) {
		// Catch an error when writing the file
		try {
			
			// File writer where to write the file
			FileWriter fileWriter = new FileWriter(outputFile);
			
			// Loop through the rows
			for (int i = 0; i < data.length; i++) {
				// Loop through the columns
				for(int k = 0; k < data[i].length; k++) {
					// Write the current value and add a space in order to separate values
					fileWriter.write(data[i][k] + " ");
				}
				
				// Add a new line once the row is done being written
				fileWriter.write('\n');
			}
			
			// Close fileWriter to preserve memory
			fileWriter.close();
		
		// Catch any error that may have occurred
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
