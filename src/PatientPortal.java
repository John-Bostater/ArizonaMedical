/****************************************************************************************
//[Contributors]:
    - John Bostater
 	  
    - Tristan Andrade

    - Austin Mayhew

    - Ryan Clark

    - Juan Rosas Jr.

 	
//[Description]:
    This file contains the relevant code for creating the Patient Portal.
 
    Upon a successful login by the user, the main page of the portal will be displayed

    From this Portal the Patient/User can use the following functionality


  [Change Patient Information]:
    This functional feature of the Patient Portal is 

  
  [View Previous Visits]:



  [Messages]:


  
  [Logout]:

  
	
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
    //Methods:		
    //		[Change Patient Information]	[View Previous Visits]	[Messages]	[Logout]

    //Patient's data (Will be loaded upon the 'Login' button being hit in the Patient "Login/New Account Page" {loaded from Welcome Page})
    //--------------------------------------------------        
      //Stage for displaying the relevant Scene(s)
        private Stage primeStage;
      
      //Load Welcome Scene & all of its functionality
        private Scene welcomePage;

      //Patient Information
        private String fullName = "";	//Ex: "John Smith"
        private String dateOfBirth = "";
        private String phoneNumber = "";
        private String insuranceInfo = "";
        private String pharmacyInfo = "";
    //--------------------------------------------------
        

    //Default Constructor (DELETE this piece of code when done debugging!!) 
    //------------------------------------	
      //public PatientPortal() {}
    //------------------------------------
    

    //Constructor
    //------------------------------------------------------------------------------
      public PatientPortal(String patientCredentials, Stage primaryStage, Scene welcomePg){
        //Take apart the userCredentials String using delimeters
        //Update the Patient's data with the following broken up data

        //Welcome Page that was created in Portals.java
          welcomePage = welcomePg;

        //Set the primary stage for displaying Scenes
          primeStage = primaryStage;

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
            //Set the dimensions of the Button
           	  //[Width x Height]
           	    changePatientInfo.setPrefSize(100, 50);  
           	    changePatientInfo.setMaxSize(100, 50);
           	    changePatientInfo.setMinSize(100, 50);
	          //[Width x Height]
           	    changePatientInfo.setPrefSize(100, 50);  
           	    changePatientInfo.setMaxSize(100, 50);
           	    changePatientInfo.setMinSize(100, 50);


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

        //==================================================================


        //Labels/Text
        //==================================================================
            Label header0 = new Label("Welcome!");
            //Set the font of header
            header0.setStyle("-fx-font-size: 42px; -fx-font-weight: bold;");

            Label text0 = new Label("What would you like to do today?");
            //Set the font of text
            text0.setStyle("-fx-font-size: 18px;");
        //==================================================================


        //Action-Event Handling
        //========================================================================================================
          //Change Patient Information
            changePatientInfo.setOnAction(e -> {
              //Load the scene/method
                primeStage.setScene(changePatientInfo());
              //Display the Scene created
                primeStage.show();
            });


          //View Previous Visits
            viewPreviousVisits.setOnAction(e -> {
              //This will load a scene that has the DROPDOWN menu
              //Refer to code in [etc] for usage...
            });


          //Messages
            messageInbox.setOnAction(e -> {
              //This will also use the DROPDOWN menu...  [For the doctor actually]

            });


          //Logout
            signOut.setOnAction(e -> {
              //Set the stage to the Welcome page and run
                primeStage.setScene(welcomePage);
                primeStage.show();
            });
        //========================================================================================================


        //Align the buttons, text, etc.
        //========================================================================================================
          //Alignment box for all of the text, buttons, etc.
            VBox alignBox0 = new VBox(25, header0, text0, changePatientInfo, viewPreviousVisits, messageInbox, signOut);

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


    //Methods below will either return of use primeStage to set the scene upon button activation


    //Change Patient Information {Scene}
      private Scene changePatientInfo(){
        //You can exit this Scene via the Button "Exit"

        //Labels
        //=====================================================================
          //Contact Information
            Label contactInfoLbl = new Label("Contact Information:");
              //Set font of Text
                contactInfoLbl.setStyle("-fx-font-size: 20px;");


          //Phone Number
            Label phoneNumLbl = new Label("Phone Number:");
              //Set font of Text
                phoneNumLbl.setStyle("-fx-font-size: 18px;");


          //Insurance Information
            Label insuranceInfoLbl = new Label("Insurance Information:");
              //Set font of Text
                insuranceInfoLbl.setStyle("-fx-font-size: 20px;");


          //Pharmaceutical Information
            Label pharmacyInfoLbl = new Label("Pharmaceutical Information:");
              //Set font of Text
                pharmacyInfoLbl.setStyle("-fx-font-size: 20px;");
        //=====================================================================
        

        //Buttons
        //==========================================================
          //Update Information (Saves to .txt file: PatientInfo.txt)
            Button updateInfo = new Button("Update Information");
              //Set the Dimensions & text of the button

          //Exit,   This will run the displayPortal() Method!!
            Button exitPage = new Button("Exit");
              //Set the Dimensions & text of the button
        //==========================================================


        //Action-Event Handling
        //==========================================================
          //Update the Information Entered into the text fields
            updateInfo.setOnAction(e -> {
              //Relevant code below...
                //
            });


          //Exit the 'Update Information' page
            exitPage.setOnAction(e -> {
              //[For the future...] 
              //we may have to set objects to null 
              //before jumping into a new 'display portal'

              //Runs 'displayPortal()' to traverse back page
                displayPortal();
            });
        //==========================================================


        //Alignment of Buttons, Labels, etc.
        //================================================================================
          //Helps align all buttons, text boxes, etc.
            HBox alignBox0 = new HBox(20, contactInfoLbl, insuranceInfoLbl, pharmacyInfoLbl);
              //Align the Hbox
                alignBox0.setAlignment(Pos.CENTER);

          //The second HBox will contain the three VBox(s) with black borders around them
            //HBox alignBox1 = new HBox(20, );


          //The third HBox will encapsulate the buttons
            HBox buttonsSection = new HBox(20, updateInfo, exitPage);


          //DEBUG VBOX
            VBox theBs = new VBox(alignBox0, buttonsSection);
        //================================================================================

        //Build the Scene
          Scene mainLayout = new Scene(theBs, 1024, 768);

        //Return the Scene
          return mainLayout;
      }
    

    //View Previous Visits {Scene}
    //You can exit this method via the Button "Exit"
    
    
    //Messages {Scene}
    //You can exit this method/scene via the Button "Exit"
    
    
    //Logout {runs the function:  runProgram() }

    //------------------------------------------------------------------------------


    //Private functions {really methods but I'm not calling them that here LoL!}
      //This function is for 
      
}	



//[Etc]:
//--------------------------------------------------------------------------------------------------------
//[TEMPLATE/BOILER-PLATE CODE FOR DropDown menu/ComboBox]
/*
//Refreshing on string array!
//-----
System.out.print("Enter Capacity: ");
Scanner scanner = new Scanner(System.in);
int userInput = scanner.nextInt();


//---------------------------------------------------------------------------------------------------------------------
//[Relevant Code for Project {CSE-360 Summer}]

//New ComboBox (Dropdown Selection)
ComboBox<String> dropSelect = new ComboBox<>();
//(We will be using a String array to store the unique PatientIds & Names to be displayed/useable within the ComboBox)
//[Below Code]: Adding Strings to the ComboBox manually
//dropSelect.getItems().addAll("Selection #1", "Selection #2", "Selection #3");


//This will be the list generated from reading the relevant .txt file for loading patient names & dob
String[] patientList = new String[userInput];
//We will most likely be creating a method or function that reads from a small .txt file
//to get the patients names (Unique Patient name & Dob per line?? so we use file.read.nextLine()??)
//that simply has the patients' full name & dob? (PatientList.txt??)
//	[Note: we will have other .txt files for storing the patient data, this smaller .txt file could
//			be a little faster to read from??]


//Fill the String array & print success/progress
//[Pointless code for our Project (do not include)]
for(int i = 0; i < userInput; i++){
	//Add the string to the shit
	patientList[i] = "Yes#" + i;

	//Print from the yes array!
	System.out.println("yes[" + i + "] == " + patientList[i]);
}

//Close the scanner
scanner.close();
//-----


//Add our String array to the ComboBox, (Add options to dropdown menu)
//[This will have to be adapted and will be used in the: doctor portal (view patient data), messaging board, etc.]
dropSelect.getItems().addAll(patientList);


//Create new Vertical Box to display the ComboBox
VBox root = new VBox();
root.getChildren().add(dropSelect);

// Create a scene with the VBox layout
Scene scene = new Scene(root, 300, 200);

// Set the scene to the stage and show the stage
primaryStage.setScene(scene);
primaryStage.setTitle("ComboBox Example");
primaryStage.show();


HBox rootMe = new HBox();
Scene scene3 = new Scene(rootMe, 400, 500);



//Handler for selection/action on the CheckBox Object (Dropdown menu)
dropSelect.setOnAction(event -> {
	String selectedScene = dropSelect.getSelectionModel().getSelectedItem();
	
	//Switch-case statement for the event of "Selecting patient"
	switch (selectedScene) {
		case "Yes#4":
			
			primaryStage.setScene(scene3);
			primaryStage.show();
		
			break;
			
		case "Yes#1":
			
			break;
	}
});
*/	
//--------------------------------------------------------------------------------------------------------