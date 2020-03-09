


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare six buttons, a label, and a textfield
	//  declare two HBoxes
	Button helloBtn;
	Button howdyBtn;
	Button chineseBtn;
	Button clearBtn;
	Button exitBtn;
	Button spanishBtn;
	
	Label feedBackLbl;
	TextField feedBackTxt;
	
	HBox buttonHBox;
	HBox feedBackHBox;
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager dataManager;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		helloBtn = new Button("Hello");
		howdyBtn = new Button("Howdy");
		chineseBtn = new Button("Chinese");
		spanishBtn = new Button("Spanish");
		clearBtn = new Button("Clear");
		exitBtn = new Button("Exit");
		
		// Set the on action to the button handler private class
		helloBtn.setOnAction(new ButtonHandler());
		howdyBtn.setOnAction(new ButtonHandler());
		chineseBtn.setOnAction(new ButtonHandler());
		spanishBtn.setOnAction(new ButtonHandler());
		clearBtn.setOnAction(new ButtonHandler());
		exitBtn.setOnAction(new ButtonHandler());
		
		feedBackLbl = new Label("Feedback: ");
		
		feedBackTxt = new TextField();
		
		buttonHBox = new HBox(10);
		feedBackHBox = new HBox(10);
		
		// Set margins for the vboxes
		VBox.setMargin(buttonHBox, new Insets(10,10,10,10));
		VBox.setMargin(feedBackHBox, new Insets(10,10,10,10));
		
		// set the alignment
		buttonHBox.setAlignment(Pos.CENTER);
		feedBackHBox.setAlignment(Pos.CENTER);
		
		// Change the font size of the whole pane with CSS
		this.setStyle("-fx-font-size: 24px;");
		
		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
		
		dataManager = new DataManager();
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
		
		buttonHBox.getChildren().addAll(
				helloBtn,
				howdyBtn,
				chineseBtn,
				spanishBtn,
				clearBtn,
				exitBtn);
		
		feedBackHBox.getChildren().addAll(
				feedBackLbl,
				feedBackTxt);
		
		this.getChildren().addAll(feedBackHBox, buttonHBox);
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent>{

		// Handle method for handling button presses
		@Override
		public void handle(ActionEvent e) {
			// Check if it's the hello button, if it is, set the text to the getHello() method
			if(e.getTarget().equals(helloBtn)) {
				feedBackTxt.setText(dataManager.getHello());
				
			// Check if it's the howdy button, if it is set the text to the getHowdy() method
			} else if(e.getTarget().equals(howdyBtn)) {
				feedBackTxt.setText(dataManager.getHowdy());
				
			// Check if the button is the chinese button, if it is, set the text to the getChinese() method
			} else if(e.getTarget().equals(chineseBtn)) {
				feedBackTxt.setText(dataManager.getChinese());
				
			// Check if it's the exit button, if it is, close the application
			} else if(e.getTarget().equals(exitBtn)) {
				Platform.exit();
				System.exit(0);
				
			// Check if it's the clear button, if it is, set the text field to nothing
			} else if (e.getTarget().equals(clearBtn)) {
				feedBackTxt.setText("");
				
			// Check if it's the spanish button, if it is, set the text to the getSpanish() method.
			} else if (e.getTarget().equals(spanishBtn)) {
				feedBackTxt.setText(dataManager.getSpanish());
				
			}
			
		}
		
	}
}
	
