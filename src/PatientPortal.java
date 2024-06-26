/****************************************************************************************
[Contributors]:
  - John Bostater
  
  - Tristan Andrade

  - Austin Mayhew

  - Ryan Clark

  - Juan Rosas Jr.

 	
[Description]:
  This file contains the relevant code for creating the Patient Portal.

  Upon a successful login by the user, the main page of the portal will be displayed

  From this Portal the Patient/User can use the following functionality


[Functionality]: 

  [Change Patient Information]:
    This functional feature of the Patient Portal is 

  
  [View Previous Visits]:



  [Messages]:


  
  [Logout]:

  
	
[Aspect Ratio/Dimension of Graphical User Interface]: 

  - [4:3]	-->   [1024 x 768]	--	{Width x Height}

	
[Files Created/Used within the program for storing/loading data]:	  
  - PatientAccounts.txt 	
      {Contains: FirstName, LastName, DOB, Insurance Info, Contact Info}
    
  - VisitSummary.txt
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
      //NEW!!!
      //Use Patient Credentials as a "key" for finding 
      //info within .txt files easily
        private String patientCredentials;


      //Stage for displaying the relevant Scene(s)
        private Stage primeStage;
      
      //Load Welcome Scene & all of its functionality
        private Scene welcomePage;

      //Patient Information
        //private String fullName = "";	//Ex: "John Smith"
        //private String dateOfBirth = "";
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
      public PatientPortal(String patientCreds, Stage primaryStage, Scene welcomePg){
        //Take apart the userCredentials String using delimeters
        //Update the Patient's data with the following broken up data

        //Welcome Page that was created in Portals.java
          welcomePage = welcomePg;

        //Set the primary stage for displaying Scenes
          primeStage = primaryStage;

        //Set the patients credentials
          patientCredentials = patientCreds;


        //Full Name (First & Last Name)
        //  int pos = patientCredentials.indexOf(",");
        //  fullName = patientCredentials.substring(0, pos);
                    
        //Date of Birth
        //  dateOfBirth = patientCredentials.substring(pos + 1, patientCredentials.length());

        //FIX THIS UP OR JUST MAKE THE PATIENT ACCOUNT CREATION FORM REQUIRE IT!!
        //Set default values to the unentered information??
        //  phoneNumber = "XXX-XXX-XXXX";
            
        //Set default values to the unentered information??
        //  insuranceInfo = "<Insurance Information>";
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
           	    changePatientInfo.setPrefSize(250, 40);  
           	    changePatientInfo.setMaxSize(250, 40);
           	    changePatientInfo.setMinSize(250, 40);
              //Set the Font of the Button's text
                changePatientInfo.setStyle("-fx-font-size: 18px;");

        //View Previous Visits 
            Button viewPreviousVisits = new Button("View Previous Visits");
            //Set the dimensions of the Buttons
              //[Width x Height]
                viewPreviousVisits.setPrefSize(200, 40);  
                viewPreviousVisits.setMaxSize(200, 40);
                viewPreviousVisits.setMinSize(200, 40);
              //Set the Font of the Button's text
                viewPreviousVisits.setStyle("-fx-font-size: 18px;");

        //Messages
            Button messageInbox = new Button("Messages");
            //Set the dimensions of the Buttons
              //[Width x Height]
                messageInbox.setPrefSize(125, 40);  
                messageInbox.setMaxSize(125, 40);
                messageInbox.setMinSize(125, 40);
              //Set the Font of the Button's text
                messageInbox.setStyle("-fx-font-size: 18px;");

        //Logout	
            Button signOut = new Button("Logout");	
            //Set the dimensions of the Buttons
              //[Width x Height]
                signOut.setPrefSize(100, 40);  
                signOut.setMaxSize(100, 40);
                signOut.setMinSize(100, 40);
              //Set the Font of the Button's text
                signOut.setStyle("-fx-font-size: 18px;");
        //==================================================================


        //Labels/Text
        //==================================================================
          //Welcome!
            Label header0 = new Label("Welcome!");
             //Set the font of header
               header0.setStyle("-fx-font-size: 42px; -fx-font-weight: bold;");

          //What would you  like to do today?
            Label text0 = new Label("What would you like to do today?");
              //Set the font of text
                text0.setStyle("-fx-font-size: 18px;");
        //==================================================================


        //Action-Event Handling
        //=============================================================================
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
              //Load the View Previous Visits Page
                primeStage.setScene(previousVisits());

              //Display the Scene
                primeStage.show();
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
        //=============================================================================


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




    //Methods below will either return Scene or use primeStage to set the Scene upon button activation

    //Change Patient Information {Scene}
      private Scene changePatientInfo(){
        //You can exit this Scene via the Button "Exit"

        //Labels
        //==============================================================================
          //Contact Information
            Label contactInfoLbl = new Label("Contact Information:");
              //Set font of Text
                contactInfoLbl.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");


          //Phone Number
            Label phoneNumLbl = new Label("Phone Number:");
              //Set font of Text
                phoneNumLbl.setStyle("-fx-font-size: 20px;");


          //Digit seperators for the phone number
            Label phoneDash0 = new Label("-");
              //Set the font of the Label
                phoneDash0.setStyle("-fx-font-size: 20px;");
            
            Label phoneDash1 = new Label("-");
              //Set the font of the Label
                phoneDash1.setStyle("-fx-font-size: 20px;");


          //Insurance Information
            Label insuranceInfoLbl = new Label("Insurance Information:");
              //Set font of Text
                insuranceInfoLbl.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

          //Insurance Information {Specifier text}
            Label insuranceInfoLbl0 = new Label("Insurance Provider:");
              //Set font of Text
                insuranceInfoLbl0.setStyle("-fx-font-size: 20px;");


          //Pharmaceutical Information
            Label pharmacyInfoLbl = new Label("Pharmaceutical Information:");
              //Set font of Text
                pharmacyInfoLbl.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

          //Pharmacy Information {Specifier text}
            Label pharmacyInfoLbl0 = new Label("Pharmacy Provider:");
              //Set font of Text
                pharmacyInfoLbl0.setStyle("-fx-font-size: 20px;");
        //==============================================================================
        

        //Buttons
        //==========================================================
          //Update Information (Saves to .txt file: PatientInfo.txt)
            Button updateInfo = new Button("Update Information");
              //Set the Dimensions & text of the button
              //[Width x Height]
    			  	  updateInfo.setPrefSize(200, 40);  
		            updateInfo.setMaxSize(200, 40);
		            updateInfo.setMinSize(200, 40);
		          //Set the Font of the Button's text
		            updateInfo.setStyle("-fx-font-size: 20px;");

          //Exit,   This will run the displayPortal() Method!!
            Button exitPage = new Button("Exit");
              //Set the Dimensions & text of the button
              //[Width x Height]
    			  	  exitPage.setPrefSize(150, 40);  
		            exitPage.setMaxSize(150, 40);
		            exitPage.setMinSize(150, 40);
		          //Set the Font of the Button's text
		            exitPage.setStyle("-fx-font-size: 20px;");

        //==========================================================


        //Text Boxes
        //==============================================================================
          //3 text boxes for the phone number...
          //Phone Number
            //First three Digits
            TextArea phoneNum0 = new TextArea("XXX");
              //Set the dimensions of the text area/box
                phoneNum0.setPrefSize(60, 40);
                phoneNum0.setMinSize(60, 40);
                phoneNum0.setMaxSize(60, 40);
              //Set the size of the text in the text box
                phoneNum0.setStyle("-fx-font-size: 18px;");

            //Second three Digits
            TextArea phoneNum1 = new TextArea("XXX");
              //Set the dimensions of the text area/box
                phoneNum1.setPrefSize(60, 40);
                phoneNum1.setMinSize(60, 40);
                phoneNum1.setMaxSize(60, 40);
              //Set the size of the text in the text box
                phoneNum1.setStyle("-fx-font-size: 18px;");

            //Final four Digits
            TextArea phoneNum2 = new TextArea("XXXX");
              //Set the dimensions of the text area/box
                phoneNum2.setPrefSize(70, 40);
                phoneNum2.setMinSize(70, 40);
                phoneNum2.setMaxSize(70, 40);
              //Set the size of the text in the text box
                phoneNum2.setStyle("-fx-font-size: 18px;");


          //Insurance Provider
            TextArea insuranceTxt = new TextArea();
              //Set the dimensions of the text area/box
                insuranceTxt.setPrefSize(250, 40);
                insuranceTxt.setMinSize(250, 40);
                insuranceTxt.setMaxSize(250, 40);

          //Pharmacy Provider
            TextArea pharmacyTxt = new TextArea();
              //Set the dimensions of the text area/box
                pharmacyTxt.setPrefSize(250, 40);
                pharmacyTxt.setMinSize(250, 40);
                pharmacyTxt.setMaxSize(250, 40);
        //==============================================================================


        //Action-Event Handling
        //==========================================================
          //Update the Information Entered into the text fields
            updateInfo.setOnAction(e -> {
              //Relevant code below...
                //

                //This will open the "PatientAccounts.txt" for reading & writing

                //We will use the flag to put on the "brakes"

                //Once the scanner reads the line containing the Patient's credentials 
                //We will activate our flag to start writing/collecting the other relevant info

                //Contact Information Data Write (take the line & only update changed text)
                //Collect the old information & use .contains()
                  //here...

                //use try{}catch(IOException e){}
              
              //Open the file "PatientAccounts.txt"
                try{
                  //Create a File object to check for files existence
                    File patientAccounts = new File("PatientAccounts.txt");

                  //Scanner for file reading
                    Scanner fileReader = new Scanner(patientAccounts);

                  //File writer for writing/updating the Patient's information

                  //Flag for collecting data
                    boolean patientFound = false;

                  //Start reading the File
                  while(fileReader.hasNextLine()){
                    //Put the Line read into a string for us to manipulate
                      String line = fileReader.nextLine();
                  }


                }
                //If the file DNE error will be caught
                catch(IOException x){
                  //Error Catch print
                    System.out.println("File does NOT exist!.!"); 
                }
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
        //========================================================================================
          //Labels
           // HBox horizontal0 = new HBox(20, contactInfoLbl, insuranceInfoLbl, pharmacyInfoLbl);
              //Align the Hbox
             //   horizontal0.setAlignment(Pos.CENTER);

          //Buttons
            HBox buttonsSection = new HBox(20, updateInfo, exitPage);
              //Set the alignment of the HBox containing the functionality
                buttonsSection.setAlignment(Pos.CENTER);
    
      
          //Contact Info:
            //Horizontally align the text fields & labels of the Phone Number entry
              HBox horizontal1 = new HBox(5, phoneNum0, phoneDash0, phoneNum1, phoneDash1, phoneNum2);

            //Vertically align the phoneNumLbl & horizontal1
              VBox vertical0 = new VBox(10, contactInfoLbl, phoneNumLbl, horizontal1);


          //Insurance Info:
            //Vertical alignment box
              VBox vertical1 = new VBox(10, insuranceInfoLbl, insuranceInfoLbl0, insuranceTxt);
          

          //Pharmacy Info:
            //Vertical alignment box
              VBox vertical2 = new VBox(10, pharmacyInfoLbl, pharmacyInfoLbl0, pharmacyTxt);


          //Align the sections: [Contact Info, Insurance Info, Pharmaceutical Info]
            HBox sectionAlignment = new HBox(20, vertical0, vertical1, vertical2);
              //Set the alignment of the Hbox
                sectionAlignment.setAlignment(Pos.CENTER);
      

          //Final Alignment/Main Layout
            VBox vertical3 = new VBox(50, sectionAlignment, buttonsSection);
              //Set the alignment of the Vertical box
                vertical3.setAlignment(Pos.CENTER);
        //========================================================================================


        //Build the Scene
          Scene mainLayout = new Scene(vertical3, 1024, 768);

        //Return the Scene
          return mainLayout;
      }
    

    //View Previous Visits {Scene}
      private Scene previousVisits(){
        //This will have a dropwn down menu and only one button for exiting

        //Labels
        //======================================================================
          //Select visit to view
            Label header0 = new Label("Select Visit to view:");
              //Set size of text
                header0.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");

          //Visit summary
            Label header1 = new Label("Visit Summary:");
              //Set size of text
                header1.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");
        //======================================================================


        //Buttons
        //==============================================
          Button exitPage = new Button("Exit");
            //Set the Dimensions and text of the button
              exitPage.setPrefSize(75, 40);
              exitPage.setMinSize(75, 40);
              exitPage.setMaxSize(75, 40);
            //Set the font & size
              exitPage.setStyle("-fx-font-size: 20px;");
        //==============================================


        //NEW?DEBUG
        System.out.println("Patient Credentials: " + patientCredentials);


        //DropDown Menu 
        //==========================================================================================
          //Create the dropDown menu object
            ComboBox<String> dropSelect = new ComboBox<>();
              //Set the Dimensions of the drop down menu
              //[Width x Height]
                dropSelect.setPrefSize(200, 30);
                dropSelect.setMinSize(200, 30);
                dropSelect.setMaxSize(200, 30);
              //NEW
              //Set the font of the text within
                dropSelect.setStyle("-fx-font-size: 16px;");

   
          //String array that contains all of the exam dates
            String[] examDates = new String[10];   //We could either use the default
            //Max amount of exams per Patient is 10


          //Instantiate the string array
            for(short i = 0; i < 10; i++){
              //New shit
                examDates[i] = "";
            }


          //Fill the ComboBox with all of the Visit Dates via: PatientSummary.txt
            try{
              //Open: PatientInfo.txt
              //Read the File with a scanner (easier to get Line by Line)
                Scanner fileReader = new Scanner(new File("VisitSummary.txt"));

              //Flag that "puts on the brakes" of the fileReader so it will
                boolean patientFound = false;
              //NEW
                short counter = 0;

             //Read the file Line-by-Line and compare the strings for a match
               while(fileReader.hasNextLine()) {
                 //Gather and store the 
                   String line = fileReader.nextLine(); //Starts at the first line of text in .txt file

                  //DEBUG
                   //System.out.println("Line: " + line);
                   //System.out.println("Patient")

                 //If-branch will activate data collection once the patient is found via their credentials
                   if(line.contains("Patient: " + patientCredentials) && !patientFound){
                     //Debug print
                       System.out.println("Patient has been found!");

                     //Move to the next line
                       line = fileReader.nextLine();

                     //Activate the flag
                       patientFound = true;
                   }

                 //Collect all of the exam dates
                   if(line.contains("Date: ") && patientFound){
                    //Collect the exam date
                      examDates[counter] += line.substring(6, line.length());

                    //increment counter
                      counter++;
                   }
                 //Finished collecting all of the exam dates
                   else{
                     if(line.contains("Patient: ") && patientFound){
                        //break the reading loop
                          break;
                     }
                   }
                }

              //Close the fileReader
                fileReader.close();
            }
            catch(IOException e){
              //Error Print
                System.out.println("File Not Found!!");
            }


          //Add all of the exam Dates to the ComboBox
            for(int i = 0; i < 10; i++){
              //Add exam dates
                if(examDates[i] != ""){
                  //Add the Exam date to the box
                    dropSelect.getItems().add(examDates[i]);
                }
              //Else, help the garbage collector
                else{
                  //Set the empty slots to null
                    examDates[i] = null;
                }
            }
        //==========================================================================================

        //Text Boxes
        //=================================================================================
          //This text box will display the visit summary of the visit date selected
            TextArea visitSummary = new TextArea("<Select a Visit to be Displayed>");

          //Set the textBox size and text style??
            visitSummary.setStyle("-fx-font-weight: 18px");
            //[Width x Height]
              visitSummary.setPrefSize(800, 550);  
              visitSummary.setMaxSize(800, 550);
              visitSummary.setMinSize(800, 550);
            //Set the Font of the Button's text
              visitSummary.setStyle("-fx-font-size: 18px;");
        //=================================================================================


        //Action-Event Handling
        //=====================================================
          //Exit
            exitPage.setOnAction(e -> {
              //Load the Patient Portal page/scene
                displayPortal();
            });
        //=====================================================


        //Alignment
        //=================================================================
          //So far this alignment is concurrent with that of Phase1

          //Horizontally align the Dropdown select & Exit button
            HBox functContainer = new HBox(525, dropSelect, exitPage);

          //Vertically align the Header 0 Label and the button container box
            VBox vertical0 = new VBox(header0, functContainer);

          //Vertically alignment of header and text box
            VBox vertical1 = new VBox(10, header1, visitSummary);

          //Set the alignment of the HBox
            //horizontal0.setAlignment(Pos.CENTER);

          //Final Box for alignment
            //HBox horizontal0 = new HBox(20, functContainer, vertical0);

          //Final Adjustment VBox
            VBox vertical2 = new VBox(vertical0, vertical1);
          
          //Set the alignment of the VBox
            vertical2.setAlignment(Pos.CENTER);

          //Set the alignment of the final box to be concurrent with the center of the page
            vertical2.setAlignment(Pos.CENTER);

          //Horizontally align the VBox [Final box & adjustment]
            HBox horizontal0 = new HBox(vertical2);

          //Set the adjustment
            horizontal0.setAlignment(Pos.CENTER);        
        //=================================================================


        //Setup Scene
          Scene mainLayout = new Scene(horizontal0, 1024, 768);
        //Return Scene
          return mainLayout;
      }
    

      //Messages {Scene}
      //You can exit this method/scene via the Button "Exit"
        //private Scene messagePage(){

        //}
    //------------------------------------------------------------------------------


    //Private functions {really methods but I'm not calling them that here LoL!}
    //------------------------------------------------------------------------------
      //Function for gathering the examination dates (used in: View Previous Visits)
        //private void examinationDates(){
          //Should this return the shit??

        //}
    //------------------------------------------------------------------------------  
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