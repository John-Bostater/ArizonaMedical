/****************************************************************************************
[Contributors]:
  - John Bostater
  
  - Tristan Andrade

  - Austin Mayhew

  - Ryan Clark

  - Juan Rosas Jr.

 	
[Description]:
  //Write description here...


[Functionality]:

  [New Visit Form]:
    //Text here...
  

  [Messages]:
    //Text here...
  

  [Logout]:
    //This will load the welcomePage scene
  
	
[Aspect Ratio/Dimension of Graphical User Interface]: 

  - [4:3]	-->   [1024 x 768]	--	{Width x Height}
	 
	
[Files Created/Used within the program for storing/loading data]:	  
  - //here...
***************************************************************************************/


//Relevant Java & JavaFX Libraries
//-----------------------------------------------
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

//File I/O
import java.io.*;	//FileWriter for file writing
import java.util.*;	//Scanner for file reading
//-----------------------------------------------

//[VERY IMPORTANT NOTE FOR THE FUTURE/LATER in writing this program]
//  Consider making the buttons of the mainPage [New Visit Form] [Messages] [Logout]
//  Private data of the NursePortal Object & instantiate them in the NursePortal Constructor
//  This way they can be used later in the Doctor Portal Methods???
//  This probably won't work but once you have a working program you are comfortable with plz consider it
//  [It could also help create less allocations on the heap???]


public class NursePortal{
    //Private Data & Variables
    //------------------------------------------
      //Stage used to display the Scenes/Methods
        private Stage primeStage;

      //Welcome Page (Used upon logout)
        private Scene welcomePage;

      //Since the Doctor portal extends the NursePortal we will need to use this ID to differentiate them
        private String staffId;

      //There may be no more??
        //This is a new dumb idea but i want to try it out
          VBox vertical0;

        //Make the buttons Private variables!!??!?!?
          Button newVisitButton;
    //------------------------------------------


    //Constructor
    //------------------------------------------------------------------------------
      public NursePortal(Stage primaryStage, Scene welcomeScene){
        //Set the private variables...
          primeStage = primaryStage;
          welcomePage = welcomeScene;
          staffId = "Nurse";
      }
    //------------------------------------------------------------------------------


    //[New Visit Form]      [Messages]      [Logout]

    //Methods
    //------------------------------------------------------------------------------
      public void displayPortal(){
        //Create the scene: Buttons, Action-Event, Alignment, Scene...

        //Labels/Headers
        //===========================================================================
          //Welcome
            Label header0 = new Label("Welcome!");
              //Set Font & size of text
                header0.setStyle("-fx-font-size: 42px; -fx-font-weight: bold; -fx-text-fill: white;");

          //What would you like to do today??
            Label header1 = new Label("What would you like to do today?");
              //Set Font & size of text
                header1.setStyle("-fx-font-size: 20px; -fx-text-fill: white;");
        //===========================================================================


        //Buttons
        //===========================================================================
          //New Visit Form
            //Original...
            //Button newVisitButton = new Button("New Visit Form");
              newVisitButton = new Button("New Visit Form");
              //Set the Dimensions of the Button
                newVisitButton.setPrefSize(200, 40);
                newVisitButton.setMinSize(200, 40);
                newVisitButton.setMaxSize(200, 40);
              //Set the Font size of the text
                newVisitButton.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-font-family: 'Times New Roman';");

          //Messages
            Button messageButton = new Button("Messages");
              //Set the Dimensions of the Button
                messageButton.setPrefSize(150, 45);
                messageButton.setMinSize(150, 45);
                messageButton.setMaxSize(150, 45);
              //Set the Font size of the text
                messageButton.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-font-family: 'Times New Roman';");

          //Logout
            Button logoutButton = new Button("Logout");
              //Set the Dimensions of the Button
                logoutButton.setPrefSize(125, 45);
                logoutButton.setMinSize(125, 45);
                logoutButton.setMaxSize(125, 45);
              //Set the Font size of the text
                logoutButton.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-font-family: 'Times New Roman';");
        //===========================================================================


        //Action-Event Handling
        //===========================================================================
          //New Visit Form      [This will save to:  "PatientSummary.txt"  <-- rename this .txt file]
            newVisitButton.setOnAction(e -> {
              //stuff here
                //code there
            });


          //Messages
            messageButton.setOnAction(e -> {
              //stuff here
                //code there
            });


          //Logout
            logoutButton.setOnAction(e -> {
              //Load the welcome page and display it    [Side Note: deallocate items??]
                primeStage.setScene(welcomePage);
                primeStage.show();
            });
        //===========================================================================


        //Alignment
        //===========================================================================================
          //Vertically align the Buttons/Functionality of the Nurse Portal
            //Original
            //VBox vertical0 = new VBox(20, header0, header1, newVisitButton, messageButton, logoutButton);

            //NEW
            vertical0 = new VBox(20, header0, header1, newVisitButton, messageButton, logoutButton);
              //Alignment
                vertical0.setAlignment(Pos.CENTER);

          //Horizontally align the Vertical alignment of buttons and labels/texts
            HBox horizontal0 = new HBox(vertical0);
              //Alignment
                horizontal0.setAlignment(Pos.CENTER);
              //Set the background color of the scene
                horizontal0.setStyle("-fx-background-color: #3A3A3A;");
        //===========================================================================================


        //Build the Scene
          Scene mainLayout = new Scene(horizontal0, 1024, 768);

        //Display the Scene
          primeStage.setScene(mainLayout);
          primeStage.show();
      }
    //------------------------------------------------------------------------------
}