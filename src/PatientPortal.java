/****************************************************************************************
 	//[Contributors]:
      - John Bostater
 	  
      - Tristan Andrade

      - Austin Mayhew

      - Ryan Clark

      - Juan Rosas Jr.

 	
 	//[Description]:
	  This file contains code for creating/displaying the necessary Scenes/Pages
	  for the GUI. The code also perfo
	
	
	//[Aspect Ratio/Dimension of Graphical User Interface]: 

	  - [4:3]	-->   [1024 x 768]	--	{Width x Height}
	 
	
	//[Files Created/Used within the program for storing/loading data]:
	  
	  - PatientAccounts.txt 	
	  		{Contains: FirstName, LastName, DOB, Insurance Info, Contact Info}
	  
	  - PatientData.txt
	  		{Used for saving the patients data: [Insurance], [Contact], [etc.]}
	  
	  - PatientVisits
			{Saved Patient Visit Information??}
	  
	  - Messages.txt
			{Used for communication between parties}
						  [New chats are added linearly (by nextLine();)]
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



public class PatientPortal{
  //Buttons/Methods:		
  //		[Change Patient Information]	[View Previous Visits]	[Messages]	[Logout]


        //Patient's data (Will be loaded upon the 'Login' button being hit in the Patient "Login/New Account Page" {loaded from Welcome Page})
        //--------------------------------------------------
            private String fullName = "";	//Ex: "John Smith"
            private String dateOfBirth = "";
            private String phoneNumber = "";
            private String insuranceInfo = "";
            private String pharmacyInfo = "";

            //New!!
            Stage primeStage;

            //private boolean logout = false;
        //--------------------------------------------------
            
    
        //Default Constructor (DELETE this piece of code when done debugging!!) 
        //------------------------------------	
        //public PatientPortal() {}
        //------------------------------------
        

        //Constructor
        //------------------------------------------------------------------------------
        public PatientPortal(String patientCredentials, Stage primeStage0){
        //Take apart the userCredentials String using delimeters
        //Update the Patient's data with the following broken up data

            //NEW {set the primestage}
            primeStage = primeStage0;

        //Full Name (First & Last Name)
            int pos = patientCredentials.indexOf(",");
            fullName = patientCredentials.substring(0, pos);
                
        //Date of Birth
            dateOfBirth = patientCredentials.substring(pos + 1, patientCredentials.length());

        //FIX THIS UP OR JUST MAKE THE PATIENT ACCOUNT CREATION FORM REQUIRE IT!!
        //Set default values to the unentered information??
            phoneNumber = "XXX-XXX-XXXX";
        
        //Set default values to the unentered information??
            insuranceInfo = "<Insurance Information>";

        }
        //------------------------------------------------------------------------------



        //Buttons	{These will load the methods with the same name}
        //------------------------------------------------------------------------------
        //Change Patient Information {Scene}
        //You can exit this method via the Button "Exit"
        
        
        //View Previous Visits {Scene}
        //You can exit this method via the Button "Exit"
        
        
        //Messages {Scene}
        //You can exit this method/scene via the Button "Exit"
        
        
        //Logout {runs the function:  runProgram() }
        
        
        //Miscellanious (private functions)
        //Check the Credentials entered into the patient login 
        //------------------------------------------------------------------------------



        //Methods
        //------------------------------------------------------------------------------
        //Creates & Displays the Patient Portal Scene		
        //[NEW NOTE: this method will be used for every "exit" button within the other methods below]
        public void displayPortal() {
            //Debug Print
            System.out.println("Login Successful!!");
            
            //Buttons
            //==================================================================
            //Change Patient Information
                Button changePatientInfo = new Button("Change Patient Information");
                //Set the Font and Size of the button



            //View Previous Visits 
                Button viewPreviousVisits = new Button("View Previous Visits");
                //Set the Font and Size of the button


                //(^^ use a dropdown menu!!! for navigating/seeing available visits)


            //Messages
                Button messageInbox = new Button("Messages");
                //Set the Font and Size of the button


            //Logout	
                Button signOut = new Button("Logout");	
                //Set the Font and Size of the button

                //^^This will take user back to Welcome page
            //==================================================================


            //Labels/Text
            //==================================================================
            Label header0 = new Label("Welcome!");
                //Set the font of header
                header0.setStyle("-fx-font-size: 38px; -fx-font-weight: bold;");

            Label text0 = new Label("What would you like to do today?");
                //Set the font of text
                text0.setStyle("-fx-font-size: 18px;");
            //==================================================================


            //Align the buttons, text, etc.
            //========================================================================================================
            //Alignment box for all of the text, buttons, etc.
                VBox alignBox0 = new VBox(header0, text0, changePatientInfo, viewPreviousVisits, messageInbox, signOut);

            //Set the alignment of the VBox for the Scene
                alignBox0.setAlignment(Pos.CENTER);
            //========================================================================================================


            //Make the Scene, set the scene, and display it
            //Load the Patient Portal scene to be displayed
            Scene mainScene = new Scene(alignBox0, 1024, 768);
            
            //Set the primary/main Scene and displays it
            primeStage.setScene(mainScene);
            primeStage.show();
        }

        //Change Patient Information {Scene}
        //You can exit this method via the Button "Exit"
        
        
        //View Previous Visits {Scene}
        //You can exit this method via the Button "Exit"
        
        
        //Messages {Scene}
        //You can exit this method/scene via the Button "Exit"
        
        
        //Logout {runs the function:  runProgram() }

        //------------------------------------------------------------------------------

        //Action Event Handling
        //------------------------------------------------------------------------------
        //Change Patient Information {Scene}
        //You can exit this method via the Button "Exit"
        
        
        //View Previous Visits {Scene}
        //You can exit this method via the Button "Exit"
        
        
        //Messages {Scene}
        //You can exit this method/scene via the Button "Exit"
        
        
        //Logout {runs the function:  runProgram() }
        
        
        //Miscellanious (private functions)
        //Check the Credentials entered into the patient login 
        //------------------------------------------------------------------------------
}	