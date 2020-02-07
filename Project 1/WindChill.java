import java.util.Scanner;

public class WindChill {

	public static void main(String[] args) {
		// Formula for the Wind Chill Temperature Index:
		// WTC = 35.74 + .6215T - 35.75v^.16 + .4275tv^.16
		
		// Declare constant variables
		final double FIRST_PART = 35.74;
		final double SECOND_PART = .6215;
		final double THIRD_PART = 35.75;
		final double FOURTH_PART = .4275;
		final double EXPONENT = .16;
		
		// Declare input and calculation variables
		double temperature, windVelocity, wtc, raisedWindVelocity;
		Scanner input = new Scanner(System.in);
		
		// Output the header
		System.out.println("Wind Chill Calculator\n");
		
		// Prompt the user to put a temperature, store it into variable temperature
		System.out.print("Enter the temperature in Fahrenheit (must be >= -45 and <= 40): ");
		temperature = input.nextDouble();
		
		// Prompt the user for the wind velocity, store it in variable windVelocity.
		System.out.print("Enter the wind velocity in miles per hour (speed) (must be >= 5 and <= 60): ");
		windVelocity = input.nextDouble();
		
		// Close the input as to reserve memory
		input.close();
		
		// Calculate what v^.16 is where v is windVelocity, put it in variable raisedWindVelocity
		raisedWindVelocity = Math.pow(windVelocity, EXPONENT);
		
		// Plug everything into the formula, store in result
		wtc = FIRST_PART + (SECOND_PART * temperature) - (THIRD_PART * raisedWindVelocity)
				+ (FOURTH_PART * temperature * raisedWindVelocity);
		
		// Display information to user.
		System.out.printf("\nWind chill temperature: %.2f degrees Fahrenheit\n", wtc);
		
		//Display my name: Michael Amaya
		System.out.println("\nProgrammer: Michael Amaya");
	}
}
