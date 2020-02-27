package _solution;

// Import necessary stuff for JavaFX alerts to work
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

// Import decimal format and Random class for formatting and getting random numbers
import java.text.DecimalFormat;
import java.util.Optional;
import java.util.Random;

import javafx.application.Application;

// Extends application for JavaFX
public class Birthday extends Application{

	// Start the application. launch calls start.
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// Setup alert message variables
		Alert welcomeMessage = new Alert(AlertType.INFORMATION);
		Alert extraAlert;
		
		// Setup input dialog variables
		TextInputDialog input = new TextInputDialog();
		
		// Setup the toychoice, child's name, age, total, and the loop variables
		String childName = "Canceled";
		String toyChoice = "Canceled";
		DecimalFormat dollar = new DecimalFormat("#,##0.00");
		double total = 0;
		int childAge = 0;
		boolean goAgain = false;
		boolean addAnotherToy = false;
		
		// Setup Toy object
		Toy toy;
		
		// Show welcome message.
		welcomeMessage.setTitle("Welcome!");
		welcomeMessage.setContentText("Welcome to the Toy Company!");
		welcomeMessage.showAndWait();
		
		// This loop will ask if the user wants to put in another toy
		do {
		
			// This loop will confirm if the toy is age appropriate.
			do {
				// Get the name of the child
				input.setTitle("Name?");
				input.setContentText("What is the name of the child?");
				Optional<String> result = input.showAndWait();
				if(result.isPresent())
					childName = result.get();
				
				// Get the age of the child
				input = new TextInputDialog();
				input.setTitle("Age?");
				input.setContentText("What is the age of the child?");
				result = input.showAndWait();
				if(result.isPresent())
					childAge = Integer.parseInt(result.get());
				
				// Get the toy choice of the child
				input = new TextInputDialog();
				input.setTitle("Select toy");
				input.setContentText("Select a toy: \n"
						+ "plushie\n"
						+ "blocks\n"
						+ "book\n"
						+ "");
				result = input.showAndWait();
				if(result.isPresent()) {
					toyChoice = result.get();
				}
				
				// Create new Toy object with the information you got
				toy = new Toy(toyChoice,childAge);
				
				// Do this if the toy is not age appropriate
				if(!toy.ageOK()) {
					// Create new alert to confirm
					Alert confirmAlert = new Alert(AlertType.CONFIRMATION);
					
					// Set title and content of confirmation alert
					confirmAlert.setTitle("Please confirm!");
					confirmAlert.setContentText("The toy is not age appropriate, do you want to "
							+ "continue?");
					
					// Set the buttons to yes or no.
					ButtonType yesOption = new ButtonType("Yes");
					ButtonType noOption = new ButtonType("No");
					
					// Add the buttons to the alert.
					confirmAlert.getButtonTypes().setAll(yesOption, noOption);
					
					// Get the response of the button
					Optional<ButtonType> option = confirmAlert.showAndWait();
					if(option.get() == yesOption) {
						// If the user is sure, don't go again, go the next part
						goAgain = false;
					} else if (option.get() == noOption) {
						// If user isn't sure, go back and restart the process
						goAgain = true;
					} else {
						// Just in case the user clicked the x button, it will go again.
						goAgain = true;
					}
				}
				
			// Loop again if the user selected no or clicked x.
			} while(goAgain);
			
			// Ask user if they want a balloon by creating new alert.
			extraAlert = new Alert(AlertType.CONFIRMATION);
			extraAlert.setTitle("Balloon?");
			extraAlert.setContentText("Do you want to add a balloon with the gift?");
			
			// Create buttons for alert.
			ButtonType yesOption = new ButtonType("Yes");
			ButtonType noOption = new ButtonType("No");
			
			// Set alert buttons
			extraAlert.getButtonTypes().setAll(yesOption,noOption);
			
			// Check if the user pressed yes
			Optional<ButtonType> option = extraAlert.showAndWait();
			if(option.get() == yesOption) {
				// If they did, add a balloon
				toy.addBalloon("yes");
			}
			
			// Change alert to add a card
			extraAlert.setTitle("Card?");
			extraAlert.setContentText("Do you want to add a card with the gift?");
			
			// Get the answer from the user
			option = extraAlert.showAndWait();
			if(option.get() == yesOption) {
				// Add a card if the user pressed yes.
				toy.addCard("yes");
			}
			
			// Show the user what they got for the child
			System.out.println("The gift for " + childName + " " + childAge + " is " + toyChoice + " " + dollar.format(toy.getCost()));
			
			// Add to the total cost
			total += toy.getCost();
			
			// Ask the user if they want another toy.
			extraAlert.setTitle("Another toy?");
			extraAlert.setContentText("Do you want another toy?");
			
			// Get the user's answer
			option = extraAlert.showAndWait();
			if (option.get() == yesOption) {
				// Set variable to reloop through everything
				// and reset other variables so you don't get names popping up again
				addAnotherToy = true;
				input = new TextInputDialog();
				toy = null;
				childName = "Canceled";
				toyChoice = "Canceled";
			} else {
				// If they pressed no or x, it will not add another toy.
				addAnotherToy = false;
			}
		// Do this again if the user selected yes above.
		} while(addAnotherToy);
		
		// Get random number for order number
		Random orderNumberR = new Random(System.currentTimeMillis());
		int orderNumber = 10000 + orderNumberR.nextInt(20000);
		
		// Show the user the total of the order
		System.out.println("The total cost of your order is " + dollar.format(total) + " Order number is " + orderNumber);
		
		// Print name
		System.out.println("Programmer: Michael Amaya");
	}

}
