/*
 	//[Contributors]:
 	  - John Bostater
 	  
 	  - <Name here>
 	  
 	  - ...
 	  
 	  - <Name here>
 	  
 	
 	//[Description]:
	  This file contains code for creating/displaying the necessary Scenes/Pages
	  for the GUI. The code also perfo
	
	
	//[Aspect Ratio/Dimension of Graphical User Interface]: 

	  - [4:3]	-->   [1024, 768]
	 
	
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
//*/



/* [TO DO]:
  	 
  	 - [6/18/24]:
  	 	
  	 	+ You might have to make the LoginPage and Create account Page separate pages?
  	 	  
  	 	+ Make a receptionist portal? for Scheduling and Deleting Patient Accounts?
  	 
*/



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



//Object/Class containing: WelcomePage, PatientPortal, NursePortal, DoctorPortal, PatientLogin, StaffLogin
public class Portals {
	//Data of the Portals Object/Class
	//--------------------------------
	  //Primary Stage 
		private Stage primeStage;
		//[This is the Screen that Displays all of the Pages/Scenes created in Phase-1 document]
		
	  //Welcome Page (First Page/Scene of Program)
		private Scene welcomePage;
	 
	  //Arizona Medical Logo Image
		private Image azMedLogo;
		
	  //New Idea
		//Go back button here??
	//--------------------------------
		
	    
	//Method(s) of the Portals Object/Class
	//------------------------------------------------------------------------------------------------------------------
	  //Starts the Program at the Welcome Page
	    void runProgram() {
		//From the Welcome Page the user can navigate to the 'login page' for Patient and Staff
		//The 'Login Page' will take the User to the respective Portal
		//If the user is to Logout 
			
		  //Set the Scene of the Stage & Display it
			primeStage.setScene(welcomePage);
			primeStage.show();
		}
	//------------------------------------------------------------------------------------------------------------------

	  
		
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
           	  azMedLogo = new Image(getClass().getResourceAsStream("azMedical.png"));
	           
           	//Create an ImageView to display the image
           	  ImageView imageView = new ImageView(azMedLogo);
	           
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
		        //Create the new patient portal object
	        	  //PatientPortal userPatient = new PatientPortal();
			        	  
		    	//Create the Patient Login/New Account Page
			      PatientLogin patientLog = new PatientLogin();
			        	
			      
		        //Load the Page/Scene	
			      //For login, the correct credentials must be entered in order to proceed to the actual 'Patient Portal'
          	      patientLog.patientLogin();
		      });
		          
		  
		        
		    //Login Page/Scene for the Staff
	          staffLogin.setOnAction(e -> {
	        	//From the Scene loaded here the user will select the Portal they would like to use {Nurse or Doctor}
		        	  
	        	//Load the Scene that contains Buttons that will lead to the two Portal options {Nurse or Doctor}
		        	  
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
	        	fileWriter.write("Patient Accounts:\n");
	        	
	          //Close the fileWriter
	        	fileWriter.close();
	        }
	      }
	      //Catch any File I/O errors
	      catch(IOException e) {
	    	  System.out.println("File Does not exist");
	      }
	        
	        
        //================================================================================================================
	        
	        
	        
        //Set the private Stage of Portals {helps us to switch scenes easier}
          primeStage = primaryStage;
	  }
	//------------------------------------------------------------------------------------------------------------------
	
	  
	//Objects/Class(s)
	//
	//Object for the Patient Login Page / Creating a New patient account
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	class PatientLogin{
	  	
	  //Constructor
	  //------------------------------------------------------------------------------
		//(this will be used in Main for "logging into" the account with the data the user entered {name & dob})
		public PatientLogin(){}
	  //------------------------------------------------------------------------------
	
		
	  //Methods
	  //--------------------------------------------------------------------------------------------------------
		//Login Page to proceed to the Patient Portal
		//The user can also create a new Accoutn from here!!! (That will load a new Scene)
		public void patientLogin(){
	  	  //"patientCredentials" String will be constructed from the textBoxes(0-n) next to the labels: 
			//	[firstName]: {textBox0}, 
			//	[lastName]:  {textBox1} 
			//	[DOB]: 		 {textBox2}, 
			//	[etc.]:		 {textBoxN}
			//Refer to Project Phase 1 for visual
		
		  //For LOGIN function/feature
		    //Compare the patient's created credentials against the .txt file
		    //containing patient names & dob (if no match reprompt/no login)

			
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

		        //Separate: DD / MM / YY
	 	          Label dobSep0 = new Label("/");
		          Label dobSep1 = new Label("/");
		          //Set Font
		            dobSep0.setStyle("-fx-font-size: 20px;");
		            dobSep1.setStyle("-fx-font-size: 20px;");
			  
		            
		      //New account Text
		        Label accText = new Label("New Patient?");
		        accText.setStyle("-fx-font-size: 24px;");

		        //Note text??
		          Label noteTxt0 = new Label("Credentials entered will be used to create a new account");
		            
		        	
		        //DOB format guide for user
		          Label dobFrmtLbl = new Label("\t\t      (MM / DD / YYYY)");	//Fix this?!
		          dobFrmtLbl.setStyle("-fx-font-size: 18px;");
		          dobFrmtLbl.setAlignment(Pos.CENTER);
		    //-------------------------------------------------
	      //================================================================================      
	          
	          
	      //Action Event Handling  {Button Usage}
	      //================================================================================			  
	        //Create a new Account
	        newPatient.setOnAction(e -> {
	          //This will Create a new Account with the credentials the user has entered
	        	//HAVE TEXT THAT NOTIFIES THE USER OF THE NEW ACCOUNT CREATED AND HOW THEY 
	        	//CAN ENTER HIT the LOGIN button TO proceed to the patient portal
	        	
	          //Compile the credentials entered by the Patient/User
	        	//Compile into one string to be passed into PatientPortal Constructor 
	        	  String patientCredentials =   firstNameTxt.getText().replaceAll("\\s", "") + "," 
	        			  					  + lastNameTxt.getText().replaceAll("\\s", "") + "," 
	        			  					  + monthTxt.getText().replaceAll("\\s", "") + "/" 
	        			  					  + dayTxt.getText().replaceAll("\\s", "") + "/" 
	        			  					  + yearTxt.getText().replaceAll("\\s", "");
	        	  //[Every String contains a regex for removing all whitespace (Makes program more Robust)]
	        	
	        	
	          //Check to see if the Account already exists (if it does the new account will NOT be created)
	        	if(!checkCredentials(patientCredentials)) {
	        		//Account does not exist, create a new Patient Account with the credentials entered
	        		  createAccount(patientCredentials);
	        	}
	          //Account already exists!
	        	else {
	        		//Print statement (have a message entity display when this happens?)
	        		  System.out.println("Account Already Exists!");
	        	}
	        	
	        	
	        });

	          
	          
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
	        	  System.out.println("Creds: " + patientCredentials);
	        
	        	  
	        	//Check to see if the entered credentials exist/match that of an existing Patient Account (Loaded from .txt file) 
	        	if(checkCredentials(patientCredentials)){
		          //Create and Display the patient Portal
		        	PatientPortal patientPort = new PatientPortal(patientCredentials);
		        	patientPort.displayPortal();
	            }
	       });
	     

	        
	        //Go back to the Welcome Page
	        goBack.setOnAction(e -> {
	          //Go back to the Welcome Page from the 'Patient Login/New Account Page'
	    	    runProgram();
	        });
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
          	  //Place all of the functionality buttons into a VBox
          	  VBox buttonContainer = new VBox(10, patientLogin, accText, newPatient, goBack);
          	    //Alignment
          	      buttonContainer.setAlignment(Pos.CENTER);
	        //-------------------------------------------------------------------------
          //===================================================================================================


	     //Compile the Main Layout of the loginPage
           VBox mainLayout = new VBox(header, credSection, buttonContainer);
           mainLayout.setAlignment(Pos.CENTER);
       	  
         //Create the Scene that displays the "Patient Login/New Account Page"
           Scene loginPage = new Scene(mainLayout, 1024, 768);
		          
         //Display the Login/Create account page
           primeStage.setScene(loginPage);
           primeStage.show();		              
	     //=====================================================================
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
					   if(fileReader.nextLine() == patientCredentials) {
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
		
		
	    //Create Account(String patientCredentials)
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
		//--------------------------------------------------------------------------------------------------------
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	
	
	//This will simply contain the methods for traversi
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	class StaffLogin{
		
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	
	
	//Buttons/Methods:		
	//		[Change Patient Information]	[View Previous Visits]	[Messages]	[Logout]
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	class PatientPortal{
	  //Patient's data (Will be loaded upon the 'Login' button being hit in the Patient "Login/New Account Page" {loaded from Welcome Page})
	  //------------------------------------
		private String fullName = "";
		private String dateOfBirth = "";
		private String phoneNumber = "";
		private String insuranceInfo = "";
		private boolean logout = false;
	  //------------------------------------
			
	
	  //Default Constructor (Delete this piece of code when done debugging!!) 
	  //------------------------------------	
		public PatientPortal() {}
  	  //------------------------------------
		
	  //Constructor
	  //------------------------------------------------------------------------------
	    public PatientPortal(String userCredentials){
		  //Take apart the userCredentials String using delimeters
		  // and set the following strings in  "Patient's data"
			
			
		}
	  //------------------------------------------------------------------------------
		 
	  //Methods
	  //------------------------------------------------------------------------------
		//Creates & Displays the Patient Portal Scene		
	      //[NEW NOTE: this method will be used for every "exit" button within the other methods below]
		public void displayPortal() {
		 //DEBUG
		   Button hereHe = new Button("Debug button");
			
		 //Load the Patient Portal scene to be displayed
		   Scene someBs = new Scene(hereHe, 800, 600);
			
			
		  //Set the primary/main Scene and displays it
 		    primeStage.setScene(someBs);
		    primeStage.show();
	    }
		
		
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
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	
	
	//Nurse Portal Object/Class
	//Buttons/Methods:
	//		[New Visit Form]	[Messages]	[Logout]
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	class NursePortal{
		
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	
	
	//Doctor Portal Object/Class
	//Buttons/Methods:
	//		[Patient Visit Form]	[View Patient Records]	[Messages]	[Logout]
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	class DoctorPortal{
		
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}