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
			  Label header0= new Label("Welcome!");
			  	//Set the style & font of the label
				  header0.setStyle("-fx-font-size: 48px; -fx-font-weight: bold; -fx-text-fill: white;");
			
			//What would you like to do today?
			  Label header1 = new Label("What would you like to do today?");
			  	//Set the style & font of the label
				  header1.setStyle("-fx-font-size: 22px; -fx-text-fill: white;");
		  //========================================================================


		  //Buttons
		  //========================================================================
			//Patient Visit Form
			  Button patientVisitForm = new Button("Patient Visit Form");
				//Set the Dimensions of the Button
				  patientVisitForm.setPrefSize(275, 50);
				  patientVisitForm.setMinSize(275, 50);
				  patientVisitForm.setMaxSize(275, 50);
				//Set the Font size of the text
				  patientVisitForm.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-font-family: 'Times New Roman';");

			//The action - event handling for this button will call upon the newVisitForm() method

			//View Patient Records
			  Button viewPatientRecords = new Button("View Patient Records");
				//Set the Dimensions of the Button
				  viewPatientRecords.setPrefSize(300, 50);
				  viewPatientRecords.setMinSize(300, 50);
				  viewPatientRecords.setMaxSize(300, 50);
				//Set the Font size of the text
				  viewPatientRecords.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-font-family: 'Times New Roman';");

			//Messages
			  Button messagesButton = new Button("Messages");
				//Set the Dimensions of the Button
				  messagesButton.setPrefSize(150, 50);
				  messagesButton.setMinSize(150, 50);
				  messagesButton.setMaxSize(150, 50);
				//Set the Font size of the text
				  messagesButton.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-font-family: 'Times New Roman';");


			//Logout
			  Button goBack = new Button("Logout");
				//Set the Dimensions of the Button
				  goBack.setPrefSize(125, 50);
				  goBack.setMinSize(125, 50);
				  goBack.setMaxSize(125, 50);
				//Set the Font size of the text
				  goBack.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-font-family: 'Times New Roman';");
		  //========================================================================


		  //Action-Event Handling
		  //========================================================================
			//Patient Visit Form
			  patientVisitForm.setOnAction(e -> {
				//Load the newVisitForm() method
				  this.primeStage.setScene(newVisitForm());
				
				//Display the scene
				  this.primeStage.show();
			  });


			//View Patient Records
			  viewPatientRecords.setOnAction(e -> {
				//Call upon the method
				  //this.primeStage.setScene();


			  });


			//Messages
			  messagesButton.setOnAction(e -> {
				//Call upon the SuperClass messages method
				  //this.primeStage.setScene(this.messagePage());

				//Display the Scene
				 //  this.primeStage.show();
			  });


			//Logout
			  goBack.setOnAction(e -> {
				//Load & display the welcome page
				  primeStage.setScene(this.welcomePage);

				//Display the Scene
				  primeStage.show();
			  });
		  //========================================================================


		  //Alignment
		  //========================================================================
			//Vertical alignmnet of the buttons, labels & functionality
			  VBox vertical0 = new VBox(20, header0, header1, patientVisitForm, viewPatientRecords, messagesButton, goBack);
				//Set the alignment of the VBox
				  vertical0.setAlignment(Pos.CENTER);

		  	
			//Final Horizontal Alignment
			  HBox finalHorizontal = new HBox(vertical0);
				//Set the background color & other features
				  finalHorizontal.setStyle("-fx-background-color: #3A3A3A;");
				//Set the horizontal alignment
				  finalHorizontal.setAlignment(Pos.CENTER);
		  //========================================================================


		  //Set the Scene & Display it
		
		  //Build the Scene
			Scene mainLayout = new Scene(finalHorizontal , 1024, 768);

		  //Display the Scene
		  	this.primeStage.setScene(mainLayout);
			this.primeStage.show();
		}

	
	//Patient Visit Form
	//Conduct Examination Page
	  @Override
	  protected Scene conductExam(String patientCredentials){
		//Break apart the patientCredentials String & derive a fullName from it
		  String fullName = patientCredentials.substring(0, patientCredentials.indexOf("/")-3).replaceAll(",", "");
			//^This string will be used a lot in here

		//Labels
		//===========================================================================
		  //Doctor's Exam
		  	Label doctorsExamLbl = new Label("Doctor's Exam:");
			  //Set the size & font
			  	doctorsExamLbl.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white;");

		  //Prescription
			Label prescriptionLbl = new Label("Prescription");
			  //Set the size & font
			  	prescriptionLbl.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white;");

		  //Prescription Script
		  	Label prescriptionScriptLbl = new Label("Prescription Script:");
			  //Set the size & font
			  	prescriptionScriptLbl.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");	


		  //Current Patient Credentials (Maybe swtich this to "Patient Name??")
			Label currentPatientCredsLbl = new Label("Current Patient:");
			  //Set the size & font
			  	currentPatientCredsLbl.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
			  //[Note]:
			  //	Next to this text label should be a text box with the patient's credentials loaded into it!!


		  //Patient's Pharmaceutical Provider
			Label pharmacyProvLbl = new Label("Patient's Pharmaceutical Provider:");
			  //Set the size & font
			  	pharmacyProvLbl.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");


		  //Doctor's Digital Signature
		  	Label signatureLbl = new Label("Doctor Signature:");
			  //Set the size & font
			  	signatureLbl.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
		//===========================================================================


		//Text Boxes
		//=====================================================================================================
		  //Physical Exam & Other Notes
			TextArea doctorsExamTxt = new TextArea("<Physical Examination & Other Notes>");
			  //Set the style of the text within the box
			  	doctorsExamTxt.setStyle("-fx-font-size: 16px;");

			  //Set the dimension & style of the text area
			  	doctorsExamTxt.setPrefSize(600, 500);
			  	doctorsExamTxt.setMinSize(600, 500);
			  	doctorsExamTxt.setMaxSize(600, 500);
			  //Clear the Text Box upon the user clicking it for data entrance
			  	doctorsExamTxt.setOnMouseClicked(event -> {
				  //Clear the default text in the Text Box
				  	doctorsExamTxt.clear();
				});


		  //Patient's Name
		  //Display the current patient's name
			TextArea patientNameTxt = new TextArea(fullName);
			  //Set the dimension & style of the text area
			  	patientNameTxt.setPrefSize(175, 50);
			  	patientNameTxt.setMinSize(175, 50);
			  	patientNameTxt.setMaxSize(175, 50);
			  //Clear the Text Box upon the user clicking it for data entrance



		  //Prescription Script
			TextArea prescriptionScriptTxt = new TextArea("<Prescription Name and Dose>");
			  //Set the dimension & style of the text area
			  	prescriptionScriptTxt.setPrefSize(250, 300);
			  	prescriptionScriptTxt.setMinSize(250, 300);
			  	prescriptionScriptTxt.setMaxSize(250, 300);
			  //Clear the Text Box upon the user clicking it for data entrance
			  	prescriptionScriptTxt.setOnMouseClicked(event -> {
				  //Clear the default text in the Text Box
				  	prescriptionScriptTxt.clear();
				});
			  //Set the font size of the Text Box
			  	prescriptionScriptTxt.setStyle("-fx-font-size: 16px;");
			


		  //Current Patient's Pharmacy (Load the text from \t\t[Insurance Provider] from "PatientAccounts".txt)
			TextArea currentProvTxt = new TextArea("<Load from .txt file>");
			  //Set the dimension & style of the text area
			  	currentProvTxt.setPrefSize(250, 35);
			  	currentProvTxt.setMinSize(250, 35);
			  	currentProvTxt.setMaxSize(250, 35);
			  //Clear the Text Box upon the user clicking it for data entrance
			  	currentProvTxt.setOnMouseClicked(event -> {
				  //Clear the default text in the Text Box
				  	currentProvTxt.clear();
				});
			  //Set the font size of the Text Box
			  	currentProvTxt.setStyle("-fx-font-size: 16px;");


		  //Digital Signature
		  	TextArea signatureTxt = new TextArea();
			  //Set the dimension & style of the text area
			  	signatureTxt.setPrefSize(250, 35);
			  	signatureTxt.setMinSize(250, 35);
			  	signatureTxt.setMaxSize(250, 35);
			  //Clear the Text Box upon the user clicking it for data entrance
			  	signatureTxt.setOnMouseClicked(event -> {
				  //Clear the default text in the Text Box
				  	signatureTxt.clear();
				});
			  //Set the font size of the Text Box
			  	signatureTxt.setStyle("-fx-font-size: 16px;");
		//=====================================================================================================


		//Buttons
		//=================================================================================================
		  //Submit Exam
			Button submitExam = new Button("Submit Examination");
			  //Set the dimensions & style of thee button
				submitExam.setPrefSize(225, 45);  
           	    submitExam.setMaxSize(225, 45);
           	    submitExam.setMinSize(225, 45);
			  //Set the style
			  	submitExam.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-font-family: 'Times New Roman';");


		  //Send Prescription
		  	Button sendPrescription = new Button("Send Prescription");
			  //Set the dimensions & style of thee button
				sendPrescription.setPrefSize(200, 45);  
           	    sendPrescription.setMaxSize(200, 45);
           	    sendPrescription.setMinSize(200, 45);
			  //Set the style
			  	sendPrescription.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-font-family: 'Times New Roman';");
	

		  //Exit
		  	Button goBack = new Button("Exit");
			  //Set the dimensions & style of thee button
				goBack.setPrefSize(75, 45);  
           	    goBack.setMaxSize(75, 45);
           	    goBack.setMinSize(75, 45);
			  //Set the style
			  	goBack.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-font-family: 'Times New Roman';");
		//=================================================================================================


		//Action-Event Handling
		//=================================================================================================
		  //find the patient via the dropdown menu credentials &

		  //Submit Exam
			submitExam.setOnAction(e -> {
				
			  //Catch any IO Errors in file writing
				try{
				  //File Writer
				  	FileWriter fileWriter = new FileWriter(fullName + "VisitSummarys.txt", true);

				  //Append the text to the end of the .txt file
					fileWriter.append("[Doctor's Exam]:\n" + doctorsExamTxt.getText().trim() + "\n\n");


				  //Close the file writer
				  	fileWriter.close();
				}
				catch(IOException a){
				  //Do Nothing...
				}

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
		  //Vertical aligments of Recording Exam [Update Summary] & [Exit]


		  //Horizontal alignments of [Submit Exam] & [Exit]
		  	HBox horizontal0 = new HBox(20, submitExam, goBack);
			  //Set the alignment of the buttons!!
			  	horizontal0.setAlignment(Pos.CENTER);


		  //Doctors Exam Txt (Background color set)
		  	VBox doctorsExamBox = new VBox(doctorsExamTxt);
			  //Set the size of the Box (this way we can have a consistent formatting)
			  	doctorsExamBox.setPrefSize(625, 525);
			  	doctorsExamBox.setMinSize(625, 525);
			  	doctorsExamBox.setMaxSize(625, 525);
			  //Set the background color & dimension of the box
			  	doctorsExamBox.setStyle("-fx-background-color: lightblue; -fx-background-radius: 10;");
			  //NEW!!!
			  //Set the alignment of the text box within??
			  	doctorsExamBox.setAlignment(Pos.CENTER);


		  //Doctors Exam
			VBox vertical0 = new VBox(5, doctorsExamLbl, doctorsExamBox, horizontal0);
			  //Set the Alignment
			  	vertical0.setAlignment(Pos.CENTER);


		  //Prescription Box
			VBox prescriptionBox = new VBox(10, prescriptionScriptLbl, prescriptionScriptTxt, pharmacyProvLbl, currentProvTxt, signatureLbl, signatureTxt);
			  //Set the Alignment
			  	prescriptionBox.setAlignment(Pos.CENTER);
			  //Set the size of the Box (this way we can have a consistent formatting)
			  	prescriptionBox.setPrefSize(275, 525);
			  	prescriptionBox.setMinSize(275, 525);
			  	prescriptionBox.setMaxSize(275, 525);
			  //Set the background color & dimension of the box
			  	prescriptionBox.setStyle("-fx-background-color: lightblue; -fx-background-radius: 10;");


		  //Prescription
		  	VBox vertical1 = new VBox(5, prescriptionLbl, prescriptionBox, sendPrescription);
			  //Set the alignment of the items within
				vertical1.setAlignment(Pos.CENTER);
		  

		  //Encapsulating HBox (Contains: vertical0 & vertical1)
			HBox finalHorizontal = new HBox(20, vertical0, vertical1);
			  //Set the alignment of the HBox
			  	finalHorizontal.setAlignment(Pos.CENTER);
			  //Set the background color of the entire Scene/Page
			  	finalHorizontal.setStyle("-fx-background-color: #3A3A3A;");
		//==========================================================================


		//Build the Conduct Exam Scene
		  Scene examScene = new Scene(finalHorizontal, 1024, 768);

		//Return the Conduct Exam Scene
		  return examScene;
	  }


	//View Patient Records
	  private Scene viewPatientRecords(){
		//Labels, Buttons, Text Boxes, Alignment, Action-Event Handling, Scene

		//Labels
		//



		//Build the Scene
		  //Scene mainLayout = new Scene(1024, 768);

		//Return the Scene
		  return null;
	  }




	  //Methods you already have...  (these can be reference within the Action Event buttons you created)
		//	[Messages]
		//	[Logout]
	//-------------------------------------------------------------------------------------------
}