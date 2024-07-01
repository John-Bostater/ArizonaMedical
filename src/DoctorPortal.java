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

  [Patient Visit Form]:
    //Text here...


  [View Patient Records]
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


//NEW IDEA!!
//  This class extends the NursePortal?? since they have somewhat similar functions???
//  [You can overload & overwrite methods]

public class DoctorPortal extends NursePortal{
	//This object contains: 
	//  [Patient Visit Form]    [View Patient Records]  [Messages]  [Logout]

	//Data of the Portals Object/Class
	//-------------------------------------------------------------------------------------------
	  //All of the 'protected' Data from the NursePortal Class is shared with the Doctor Class
	//-------------------------------------------------------------------------------------------


	//Constructor (since they are all kinda the same yanno?)
	//-------------------------------------------------------------------------------------------
	  public DoctorPortal(Stage primaryStage, Scene welcomeScene){
		//Call upon the same constructor of the NursePortal (since they act similar)
		  super(primaryStage, welcomeScene);
		  this.staffId = "Doctor";
	  }
	//-------------------------------------------------------------------------------------------


	//Methods
	//-------------------------------------------------------------------------------------------
	  //We will be using the same methods to that of the NursePortal but we will override them
	  //that way we can manipulate aspect of the stuff that we want to or whatever
	  //Display portal that has the same name....
	  

	  //Display the Main Page
	  @Override
	    public void displayPortal(){
		  //Set the Buttons, Labels, Action-Event, etc.  [In the future this may be moved to the constructor?]

		  //Labels
		  //========================================================================
			//Welcome!
			  Label welcomeLbl = new Label("Welcome!");
			  	//Set the style & font of the label
				  //Code here..
			
			//What would you like to do today?
			  Label header0 = new Label("What would you like to do today?");
			  	//Set the style & font of the label
				  //Code here...
		  //========================================================================


		  //Buttons
		  //========================================================================
			//Patient Visit Form
			  Button patientVisitForm = new Button("Patient Visit Form");
			  	//Set the dimension & font of the button
				   //code here...
			//The action - event handling for this button will call upon the newVisitForm() method


			//View Patient Records
			  Button viewPatientRecords = new Button("View Patient Records");
			  	//Set the dimension & font of the button
				   //code here...


			//Messages
			  Button messagesButton = new Button("Messages");
			  	//Set the dimension & font of the button
				   //code here...


			//Logout
			  Button goBack = new Button("Logout");
			  	//Set the dimension & font of the button
				   //code here...
		  //========================================================================


		  //Action-Event Handling
		  //========================================================================
			//Patient Visit Form
			  patientVisitForm.setOnAction(e -> {
				//Load the newVisitForm() method
				  this.primeStage.setScene(this.newVisitForm());
				
				//Display the scene
				  this.primeStage.show();
			  });


			//View Patient Records


			//Messages


			//Logout
		  //========================================================================


		  //Alignment
		  //========================================================================
		  	
			//Final Horizontal Alignment
				HBox finalHorizontal = new HBox(patientVisitForm);

		  //========================================================================


		  //Set the Scene & Display it
		
		  //Build the Scene
			Scene mainLayout = new Scene(finalHorizontal , 1024, 768);

		  //Display the Scene
		  	this.primeStage.setScene(mainLayout);
			this.primeStage.show();
		}

	

	//Conduct Examination Page
	  @Override
	  protected Scene conductExam(String patientCredentials){
		//Labels
		//===========================================================================
		  //Doctor's Exam
		  	Label doctorsExamLbl = new Label("Doctor's Exam:");
			  //Set the size & font
			  	doctorsExamLbl.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white;");

		  //Prescription
			Label prescriptionLbl = new Label("Prescription");

		  //Prescription Script
		  	Label prescriptionScript = new Label("Prescription Script");
			  //Set the size & font
			  	prescriptionScript.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");	


		  //Current Patient Credentials (Maybe swtich this to "Patient Name??")
			Label currentPatientCredsLbl = new Label("Current Patient:");
			  //Set the size & font
			  	currentPatientCredsLbl.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
		  //[NOTE!!!]
		  //Next to this text label should be a text box with the patient's credentials loaded into it!!


		   //Current Patients Pharmacy

			//DEBUG!!!
			//System.out.println("Patient Credentials for [Conduct Exam]: \n\t" + patientCredentials);


		  //Debug Label
			Label debugLbl = new Label("It Worked!!!");
		//===========================================================================


		//Buttons
		//=================================================================================================
		  //Submit Exam
			Button submitExam = new Button("Submit Examination");
			  //

		  //Send Prescription
		  	Button sendPrescription = new Button("Send Prescription");
			  //


		  //Exit
		  	Button goBack = new Button("Exit");
			  //Set the dimension & font of the button

		//=================================================================================================


		//Action-Event Handling
		//=================================================================================================
		  //find the patient via the dropdown menu credentials &

		  //Submit Exam
			submitExam.setOnAction(e -> {
			  //Code here...

			});


		  //Send Prescription



		  //Exit
		    goBack.setOnAction(e -> {
			  //Call upon the "newVistForm" method 
			
			  //Set the Scene
				this.primeStage.setScene(this.newVisitForm());
			
			  //Display the Scene
			  	this.primeStage.show();
			});
		//=================================================================================================


		//Alignments
		//==========================================================================
		  HBox debugAlign = new HBox(10, debugLbl, goBack);
		  debugAlign.setAlignment(Pos.CENTER);
		//==========================================================================


		//Build the Conduct Exam Scene
		  Scene examScene = new Scene(debugAlign, 1024, 768);

		//Return the Conduct Exam Scene
		  return examScene;
	  }



	  //Methods you already have...  (these can be reference within the Action Event buttons you created)
		//	[Messages]
		//	[Logout]
	//-------------------------------------------------------------------------------------------
}