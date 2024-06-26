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


//Portal Object/Class 
public class Portals {
	//This object contains: 
	//	[WelcomePage]	[PatientPortal]	[NursePortal]	[DoctorPortal]	[PatientLogin]	[StaffLogin]


	//Data of the Portals Object/Class
	//-------------------------------------------------------------------------------------------
	  //Primary Stage 
		private Stage primeStage;
		//[This is the Screen that Displays all of the Pages/Scenes created in Phase-1 document]
		
	  //Welcome Page (First Page/Scene of Program)
		private Scene welcomePage;
	 
	  //Arizona Medical Logo Image
		//private Image azMedLogo;
		
	  //Notification Text
		private Label notificationTxt;

	  //Notification Flag
		private boolean isNotified;   
		//^^Used to ensure notification messages arent added too many times

	  //Portal Objects	[Note]: this is so they can be easliy deallocated/set to null for runProgram()
	    private PatientPortal patientView;
		private NursePortal nurseView;
		private DoctorPortal doctorView;
	//-------------------------------------------------------------------------------------------


	//Constructor of the Portals Object/Class
	//------------------------------------------------------------------------------------------------------------------
	  public Portals(Stage primaryStage){
		//Pass the primaryStage <Stage> Object/Class in Main.java so the User can seemlessly transition between pages
		//Seemless transitions will be achieved by setting the private variable primeStage 	
		//This will also make the "Logout" buttons within the Patient, Nurse & Doctor portal return us to the "Welcome Page"
		//Initialize the welcomePage Scene (This will be "global" and can be referenced by the other Scene methods)
	
		  
		//Welcome Page Scene          
		  //The 'Welcome Page' is the "Portal to the Portals", so to speak.
          //i.e.  We will navigate to the other portals from here {Patient, Nurse Doctor}
        
		  //Header(s)/Label(s): 
	      //================================================================
	        Label header0 = new Label("Welcome");
	        header0.setStyle("-fx-font-size: 42px; -fx-font-weight: bold;");
	         
	        Label header1 = new Label("Select Login");
	        header1.setStyle("-fx-font-size: 26px;");
	      //================================================================
	        
	         
	      //Navigation buttons for Main Page:
	      //=============================================================================================
	        //Create buttons for navigating TO the portals {Patient, Nurse, Doctor} & exiting the program
	          Button patientLogin = new Button("Patient");
	          Button staffLogin = new Button("Staff");
	          Button exitProg = new Button("Exit");
		       
	          Button nurseLogin = new Button("Nurse");		//Create NursePortal Object --> [nurseMainPage]
	          Button doctorLogin = new Button("Doctor");	//Create DoctorPortal Object --> [docMainPage]
	      //=============================================================================================
	       
               
          //Load Logo onto Main Page:
          //=============================================================================================
            //Load the image
           	  Image logoImg = new Image(getClass().getResourceAsStream("azMedical.png"));
	           
           	//Create an ImageView to display the image
           	  ImageView imageView = new ImageView(logoImg);
	           
           	//Adjust the size of the ImageView
           	  imageView.setFitWidth(500);
           	  imageView.setFitHeight(500);
           	  imageView.setPreserveRatio(true);
	           
           	//Add the image into a StackPane ("Picture Frame")
           	  StackPane azMedLogo = new StackPane();
           	  azMedLogo.getChildren().add(imageView);
          //=============================================================================================  
			
          
          //Vertically align the elements 
          //=============================================================================================  
           	//Vertical Box
           	  VBox buttonsSection = new VBox(20, patientLogin, staffLogin, exitProg);
            
            //Set the dimensions of the Buttons
           	  //[Width x Height]
           	    patientLogin.setPrefSize(100, 50);  
           	    patientLogin.setMaxSize(100, 50);
           	    patientLogin.setMinSize(100, 50);
	          //[Width x Height]
           	    staffLogin.setPrefSize(100, 50);  
           	    staffLogin.setMaxSize(100, 50);
           	    staffLogin.setMinSize(100, 50);
           	  //[Width x Height]
           	    exitProg.setPrefSize(60, 50);  
           	    exitProg.setMaxSize(60, 50);
           	    exitProg.setMinSize(60, 50);          
		          
              //Set text Size within buttons
  	            patientLogin.setStyle("-fx-font-size: 20px;");
				staffLogin.setStyle("-fx-font-size: 20px;");
				exitProg.setStyle("-fx-font-size: 18px;");
              
              //Set padding
              	buttonsSection.setAlignment(Pos.CENTER);
              	buttonsSection.setPadding(new Insets(10, 0, 10, 0));
                    
            //Set up the main layout of the GUI 
			  VBox mainLayout = new VBox(20, header0, azMedLogo, header1, buttonsSection);
			  mainLayout.setPadding(new Insets(10));
	        //Set all of the relevant Labels, Photos, and Buttons into center alignment
	      	  mainLayout.setAlignment(Pos.CENTER);
	      //=============================================================================================  
	              
	         
	      //Action Event Handling  {Welcome Page}
	      //================================================================================================================
		    //Login/New Account Page/Scene for the Patient
	          patientLogin.setOnAction(e -> {
		        //Call upon the patientLogin method {Method of Portals Object/Class}
				  patientLogin();
			  });
		          
		        
		    //Login Page/Scene for the Staff
	          staffLogin.setOnAction(e -> {
				//Call upon the staff login page that shows: [Nurse] --> NursePortal  &&  [Doctor] --> DoctorPortal
				  staffLogin(); 
	          });        
		        
		        
	        //End the program (More of a debug thing but why not keep it)
	          exitProg.setOnAction(e -> {
	        	  //return
	        	  welcomePage = null;
	        	  primeStage.close();	        	 
	          });
		
	        //Create the welcomePage Scene	//[4x3] aspect ratio
	          welcomePage = new Scene(mainLayout, 1024, 768);          
	      //================================================================================================================

	        
	  	  //Necessary File Check
          //================================================================================================================
			//Check to see if the file(s) exist. If not, create it.
			try {
				//List all of the required files for the system to run
				File patientAccounts = new File("PatientAccounts.txt");
				
				//Check to see if the file already exists and if it does not, create it
				if(patientAccounts.exists()) {
					//File Already exists, do nothing
					System.out.println("File Exists!");
				}
				else {
				//Create the file
					FileWriter fileWriter = new FileWriter("PatientAccounts.txt");
					
				//Write the Leading text in the file
					fileWriter.write("Patient Accounts:\n\n");
					
				//Close the fileWriter
					fileWriter.close();
				}
			}
			//Catch any File I/O errors
			catch(IOException e) {
				System.out.println("File Does not exist");
			}
		  //================================================================================================================
					

		//Set the attributes/private data of the Portals object        
		//================================================================================================================			
		  //Set the private Stage of Portals {helps us to switch scenes easier}
			primeStage = primaryStage;
		  //Update the private boolean for notifications
			isNotified = false; 	
		//================================================================================================================
	}
	//------------------------------------------------------------------------------------------------------------------
	


	//Method(s) of the Portals Object/Class
	//------------------------------------------------------------------------------------------------------------------
	  //Starts the Program at the Welcome Page
	    public void runProgram() {
		  //From the Welcome Page the user can navigate to the 'login page' for Patient and Staff
		  //The 'Login Page' will take the User to the respective Portal
		  //If the user is to Logout 

		  //[New Idea]:
		  //Update all of the other portal objects to null 
		  //This will [deconstruct our old objects]
			patientView = null;
			nurseView = null;
			doctorView = null;			
			//azMedLogo = null;

		  //Set the Scene of the Stage & Display it
			primeStage.setScene(welcomePage);
			primeStage.show();
		}


	  //Login --> [Staff]
	  	private void staffLogin(){
		  //This scene will only have two buttons (Nurse) && (Doctor)
		  //When the user clicks the respective button a new portal object will be added
		  //to the global variables

		  //Buttons && Labels
		  //======================================================================
			//Label
			  Label header0 = new Label("Select User");
				//Set the Font of the Label
		          header0.setStyle("-fx-font-size: 42px; -fx-font-weight: bold;");

			//Nurse Button
			  Button nurseButton = new Button("Nurse");
	  			//Set the dimensions of the Buttons
		        //[Width x Height]
			  	  nurseButton.setPrefSize(75, 40);  
		          nurseButton.setMaxSize(75, 40);
		          nurseButton.setMinSize(75, 40);
	            //Set the Font of the Button's text
		          nurseButton.setStyle("-fx-font-size: 18px;");

			//Doctor Button
			  Button doctorButton = new Button("Doctor");
			  //Format stuff below!!
	  			//Set the dimensions of the Buttons
		        //[Width x Height]
			  	  doctorButton.setPrefSize(80, 40);  
		          doctorButton.setMaxSize(80, 40);
		          doctorButton.setMinSize(80, 40);
	            //Set the Font of the Button's text
		          doctorButton.setStyle("-fx-font-size: 18px;");


			//Go Back	[Main Page]
			  Button goBack = new Button("Go Back");
				//Set the dimensions of the Buttons
		        //[Width x Height]
			  	  goBack.setPrefSize(100, 40);  
		          goBack.setMaxSize(100, 40);
		          goBack.setMinSize(100, 40);
	            //Set the Font of the Button's text
		          goBack.setStyle("-fx-font-size: 18px;");
		  //=====================================================================


		  //Scene & Alignments
		  //=====================================================================
			//VBox for ordering items
			  VBox buttonBox = new VBox(20, header0, nurseButton, doctorButton, goBack);
			  //Align the vbox elements to be in the middle???
				buttonBox.setAlignment(Pos.CENTER);

			//Scene for the 
			  Scene staffPage = new Scene(buttonBox, 1024, 768);
		  //=====================================================================


		  //Action-Event Handling
		  //======================================================================================
			//Nurse Login  --> Create/Use Nurse Portal
			  nurseButton.setOnAction(e -> {
				//Load Nurse Portal Object/Class to display / use the portal
				  nurseView = new NursePortal();

				//Call upon the object method for displaying/using the main page for the Nurse
				  //nurseView.runPortal();
			  });


			//Doctor Login --> Create/Use Doctor Portal
			  doctorButton.setOnAction(e -> {
				//Load Nurse Portal Object/Class to display / use the portal
				  doctorView = new DoctorPortal();

				//Call upon the object method for displaying/using the main page for the Doctor
				  //doctorView.runPortal();
			  });


			//Go Back (Set all of the global variables to 'null' and go back)
			  goBack.setOnAction(e -> {
				//Run the main page again
				  runProgram();
			  });
		  //======================================================================================

		  //Display the scene created
			primeStage.setScene(staffPage);
			primeStage.show();
		}


	  //Create Account	[Patient]
		private void createAccount(String patientCredentials) {
		  //Append the patients Credentials to the "PatientAccounts.txt"
		
			try {
			  //Load [PatientAccounts.txt] for writing		
				FileWriter fileWriter = new FileWriter("PatientAccounts.txt", true);
			  //[Note]:  'true' in the second parameter tells the fileWriter the file already exists
			    
				
			  //Append the new Patient's name to the .txt file
			    fileWriter.append(patientCredentials + "\n");
			 
			  //Close the file Writer
			    fileWriter.close();
			    
			}
			//File Does not exist error catch
			catch(IOException e) {
			  //Error Statement
				System.out.println("Error!, File does not exist");
			}
		}


	  //Login --> [Patient]
		private void patientLogin(){		
		  //Buttons
          //==========================================================
			//Relevant Buttons for the Login/New Account Page 
			
			//Log in
			  Button patientLogin = new Button("Log in");
	  			//Set the dimensions of the Buttons
		        //[Width x Height]
			  	  patientLogin.setPrefSize(75, 40);  
		          patientLogin.setMaxSize(75, 40);
		          patientLogin.setMinSize(75, 40);
	            //Set the Font of the Button's text
		          patientLogin.setStyle("-fx-font-size: 18px;");
			
		    //Create Account
			  Button newPatient = new Button("Create Account");
	  			//Set the dimensions of the Buttons
		        //[Width x Height]
			  	  newPatient.setPrefSize(160, 40);  
		          newPatient.setMaxSize(160, 40);
		          newPatient.setMinSize(160, 40);
		        //Set the Font of the Button's text
		          newPatient.setStyle("-fx-font-size: 18px;");
		    
		    //Go Back      
		      Button goBack = new Button("Go back");
				//Set the dimensions of the Buttons
				//[Width x Height]
					goBack.setPrefSize(100, 40);  
					goBack.setMaxSize(100, 40);
					goBack.setMinSize(100, 40);
				//Set the Font of the Button's text
					goBack.setStyle("-fx-font-size: 16px;");      
		  //==========================================================
	 	    
			  
		  //Text Boxes
		  //================================================================================
			//Create text boxes for the Credentials the user will be entering
			
			//First Name
			  TextArea firstNameTxt = new TextArea();
				//Set the dimensions of the text box
		        //[Width x Height]
			  	  firstNameTxt.setPrefSize(150, 25);  
 		          firstNameTxt.setMaxSize(150, 25);
		          firstNameTxt.setMinSize(150, 25);
			          
	        //Last Name
	          TextArea lastNameTxt = new TextArea();
				//Set the dimensions of the text box
		        //[Width x Height]
			  	  lastNameTxt.setPrefSize(150, 25);  
		          lastNameTxt.setMaxSize(150, 25);
		          lastNameTxt.setMinSize(150, 25);
		          
		    //Date Of Birth    
		      //(Broken up into three text boxes (MM/DD/YYYY)
		      //Month
 		        TextArea monthTxt = new TextArea();
		        //Set the dimensions of the text box
 		        //[Width x Height]
 		          monthTxt.setPrefSize(30, 25);  
 		          monthTxt.setMaxSize(30, 25);
		          monthTxt.setMinSize(30, 25);
		          
	          //Day
 		        TextArea dayTxt = new TextArea();
		        //Set the dimensions of the text box
 		        //[Width x Height]
 		          dayTxt.setPrefSize(30, 25);  
 		          dayTxt.setMaxSize(30, 25);
		          dayTxt.setMinSize(30, 25);
		          

	          //Year
 		        TextArea yearTxt = new TextArea();
		        //Set the dimensions of the text box
 		        //[Width x Height]
 		          yearTxt.setPrefSize(43, 25);  
 		          yearTxt.setMaxSize(43, 25);
		          yearTxt.setMinSize(43, 25);        
	      //================================================================================
		       
	          
	      //Labels & Headers 
		  //================================================================================
			//Labels for organizing userInput
	          Label header = new Label("Patient Login");
	          //Set Font
	            header.setStyle("-fx-font-size: 38px; -fx-font-weight: bold;");
	            //header.setAlignment(Pos.CENTER);
	            
	        //Labels relating to the user Credentials
	        //-------------------------------------------------
	          //First Name
	            Label firstNameLbl = new Label("First Name:");
	            //Set Font
	              firstNameLbl.setStyle("-fx-font-size: 20px;");          
	              
	          //Last Name
	            Label lastNameLbl = new Label("Last Name:");
	            //Set Font
	              lastNameLbl.setStyle("-fx-font-size: 20px;");
	          
	          		
	          //Date of Birth 
	            Label dobLbl = new Label("Date of Birth:");
	            //Set Font
	          	  dobLbl.setStyle("-fx-font-size: 20px;");

		        //Separate: MM / DD / YYYY
	 	          Label dobSep0 = new Label("/");
		          Label dobSep1 = new Label("/");
		          //Set Font
		            dobSep0.setStyle("-fx-font-size: 20px;");
		            dobSep1.setStyle("-fx-font-size: 20px;");
			  
		            
		      //New account Text
		        Label accText = new Label("New Patient?");
		        accText.setStyle("-fx-font-size: 24px;");

		        	
		 	  //DOB format guide for user
				Label dobFrmtLbl = new Label("\t\t\t(MM / DD / YYYY)");
				dobFrmtLbl.setStyle("-fx-font-size: 18px;");
				dobFrmtLbl.setAlignment(Pos.CENTER);
			//-------------------------------------------------
	      //================================================================================      


		  //VBox & HBox Alignments the main Layout of the program
	      //===================================================================================================
	        //Credentials Section
	        //-------------------------------------------------------------------------
	          //Alignment HBox(s) for the Text Box entries
	        	HBox firstNameBox = new HBox(5, firstNameLbl, firstNameTxt);
        		HBox lastNameBox = new HBox(5, lastNameLbl, lastNameTxt);
        		HBox DOBbox = new HBox(5, dobLbl, monthTxt, dobSep0, dayTxt, dobSep1, yearTxt);
		        
        	  //This will encapsulate all of the HBoxs for Patient Credentials 
        		VBox credContainer = new VBox(5, firstNameBox, lastNameBox, DOBbox, dobFrmtLbl);
        		//Set the dimensions & create a border around the credential container VBox
        		  credContainer.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-padding: 10;");  
          		  credContainer.setPrefSize(300,150);
          		  credContainer.setMaxSize(300,150);
          		  credContainer.setMinSize(300,150);
		          
          	  //This will position the Vbox correctly 
          		HBox credSection = new HBox(credContainer);
          		credSection.setAlignment(Pos.CENTER);
          		credSection.setPadding(new Insets(25));
	            //Places a Border around the Credsection box
   	        //-------------------------------------------------------------------------
	          
          		
	        //Functional Buttons Section:  [Login]  &  [New Account]
          	//-------------------------------------------------------------------------
          	  //Place all of the functionality buttons into a VBox		//NEW: include the notification message?
          	  VBox buttonContainer = new VBox(10, patientLogin, accText, newPatient, goBack);
          	    //Alignment
          	      buttonContainer.setAlignment(Pos.CENTER);
	        //-------------------------------------------------------------------------
          //===================================================================================================

          
	      //Action Event Handling  {Button Usage}
	      //================================================================================			  
	        //Log into the Patient Account 
  	        patientLogin.setOnAction(e -> {
	    	  //Call upon the "Check Credentials" Method to compare the users credentials to
	          //That in the .txt file  "Patients.txt"
	          //{THE USER CANNOT PROCEED IF CREDENTIALS INCORRECT [use if-branch]}
	    
	        	
	        	//Compile into one string to be passed into PatientPortal Constructor 
	        	  String patientCredentials =   firstNameTxt.getText().replaceAll("\\s", "") + "," 
	        			  					  + lastNameTxt.getText().replaceAll("\\s", "") + "," 
	        			  					  + monthTxt.getText().replaceAll("\\s", "") + "/" 
	        			  					  + dayTxt.getText().replaceAll("\\s", "") + "/" 
	        			  					  + yearTxt.getText().replaceAll("\\s", "");
	        	  //[Every String contains a regex for removing all whitespace (Makes program more Robust)]
	        	  
	        	  
	        	//[DEBUG PRINT] Delete when done
	        	  //System.out.println("Creds: " + patientCredentials);
	        
	        	//Successful Login
	        	//Check to see if the entered credentials exist/match that of an existing Patient Account (Loaded from .txt file) 
	        	if(checkCredentials(patientCredentials)){
	        	  //Update global variables before proceeding to new Scene
					isNotified = false;
	        		
		          //Create and Display the patient Portal		{NEW ADDITION TO ENDs}
		        	PatientPortal patientPort = new PatientPortal(patientCredentials, primeStage, welcomePage);
		        	patientPort.displayPortal();
	            }
				//Unsuccessful Login
				else{
				  //Make sure the user is only notified of their mistake once
				  if(!isNotified){
					//Add notification text to inform user
						notificationTxt = new Label("*Account does not exist");
						buttonContainer.getChildren().add(notificationTxt);

					//Update Notification flag
						isNotified = true;
				  }
				}
	       });
		          
		          
		  //Create a new Account
	        newPatient.setOnAction(e -> {
	          //This will Create a new Account with the credentials the user has entered
	        	//HAVE TEXT THAT NOTIFIES THE USER OF THE NEW ACCOUNT CREATED AND HOW THEY 
	        	//CAN ENTER HIT the LOGIN button TO proceed to the patient portal
	        	
				//[New Idea]
				/*
					//Have the new Account Button Change the Credentials container to include
						Contact info (phone number), insurance info, pharmacy info, etc.

					//Labels
					Label contactLbl = new Label("Phone Number: ");
					...

					//Add the Labels and Text Boxes to the credentials container
					credContainer.getChildren().add(contactLbl);
					...

					//You will have to update the container size for the new text box fields
					credContainer.setPrefSize(300,200);
					credContainer.setMaxSize(300,200);
					credContainer.setMinSize(300,200);
				*/


			  //Add new text boxes to the Create account section for the user to enter
			  //Do this via the credSection.getChildren().addAll()
				//Label debugLbl = new Label("DEBUG!!");

			  //Make sure these elements only get added once!!

			  //EXAMPLE [Conform this to your needs]
				//credContainer.getChildren().add(debugLbl);



	          //Compile the credentials entered by the Patient/User
	        	//Compile into one string to be passed into PatientPortal Constructor 
	        	  String patientCredentials =   firstNameTxt.getText().replaceAll("\\s", "") + "," 
	        			  					  + lastNameTxt.getText().replaceAll("\\s", "") + "," 
	        			  					  + monthTxt.getText().replaceAll("\\s", "") + "/" 
	        			  					  + dayTxt.getText().replaceAll("\\s", "") + "/" 
	        			  					  + yearTxt.getText().replaceAll("\\s", "");
	        	  //[Every String contains a regex for removing all whitespace (Makes program more Robust)]

			  
			  //Patient Information String that will contain: phonenumber, insuranceInfo, pharmacyInfo
				//It will collect these from the new text fields/boxes you have added
				  String patientInfo = "Placeholder text";


			  //Flag to make sure the user has correctly entered their data to the field
			    boolean validEntry = true;


			  //Check that all textFields have an entry & their minimum text length is met 
  			  //Use this knowledge to construct a simple if-branch
			  //The user has not entered the minimum amount of chars do not make an account
			    if(    firstNameTxt.getText().length() == 0  
					|| lastNameTxt.getText().length() == 0
					|| monthTxt.getText().length() < 2
					|| dayTxt.getText().length() < 2
					|| yearTxt.getText().length() < 4 
				  ){
					//Update the flag so the user cannot proceed to making a new account
					  validEntry = false;

					//Notify the user of their mistake if they have not already been
					if(!isNotified){
					  //Notify user that their entry is invalid
					    notificationTxt = new Label("*Required text box is missing or invalid");
						buttonContainer.getChildren().add(notificationTxt);
					  //Update the flag (User will be notified only once)
					    isNotified = true;
					}
 			    }
			  //[Note for later]: If you want to make this more verbose you can write it out so the user
			  //			is notified which of the text fields/box(s) needs to be adjusted or filled out


			  //If the credentials entered do not exist, then a new account is created
	        	if(!checkCredentials(patientCredentials) && validEntry) {
					//Remove any previous Notifications
					  buttonContainer.getChildren().remove(notificationTxt);

	        		//Account does not exist, create a new Patient Account with the credentials entered
	        		  createAccount(patientCredentials);

					//Notify the user that the account is already created
					  notificationTxt = new Label("*Account Successfully Created.\n  You may proceed to login.");
					  buttonContainer.getChildren().add(notificationTxt);

					//Update notification flag
					  isNotified = true;
	        	}
	          //Account already exists
	        	else {
					//Notify the user that the account credentials already exist

					//If-branch to make sure the user isn't being notified to much
					if(!isNotified){
					  //Update the notification text/label and add it to the GUI Display
						notificationTxt = new Label("*Account already exists, you may proceed to login.");
						buttonContainer.getChildren().add(notificationTxt);

					  //User has been notified
					    isNotified = true;	
					}
	        	}        	
	        });
	      
	        //Go back to the Welcome Page
	        goBack.setOnAction(e -> {
			  //Update Notification Flag to false
			    isNotified = false;

	          //Go back to the Welcome Page from the 'Patient Login/New Account Page'
	    	    runProgram();
	        });
		  //================================================================================
		

	      //Compile the Main Layout of the loginPage
           	VBox mainLayout = new VBox(header, credSection, buttonContainer);
           	mainLayout.setAlignment(Pos.CENTER);
       	  
          //Create the Scene that displays the "Patient Login/New Account Page"
          	Scene loginPage = new Scene(mainLayout, 1024, 768);
		          
          //Display the Login/Create account page
          	primeStage.setScene(loginPage);
            primeStage.show();		              
		}
	     

		//Check Credentials (returns true if entered credentials match a real Patient account from .txt)
		  private boolean checkCredentials(String patientCredentials) {
			
			//Open the file Containing all of the patient names  {PatientAccounts.txt}
			try {
				//Read the File with a scanner (easier to get Line by Line)
				  Scanner fileReader = new Scanner(new File("PatientAccounts.txt"));
				  
				//Read the file Line-by-Line and compare the strings for a match
				  while(fileReader.hasNextLine()) {

					  //Compare the credentials Entered with all of the accounts listed in the .txt file
					   if(fileReader.nextLine().contains(patientCredentials)) {
						 //Match Found!
						   
						 //Close the fileReader
						   fileReader.close();
						
						 //Patient's account exists!
						   return true;
					   }
				  }
				  
				  //Close the fileReader
				    fileReader.close();
			}
			//Catch any Errors in File I/O
			catch (IOException e) {
			  //Error Statement
				System.out.println("Error!, File does not exist");
				
			  //Error Opening File (Returns False)
				return false;
			}
			
			//No matches found, return false
			  return false;
		}
	//--------------------------------------------------------------------------------------------------------
}