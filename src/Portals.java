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

	  - [4:3]	-->   [1024 x 768]
	 
	
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



/* [TO DO]:
  	 
  	 - [6/19/24]:
  	
		[Functional requirements]

		+ NOTES THAT ARE RANDOM BUT I NEED TO WRITE DOWN
		  
		  For the [Create account button] when it is pressed remove the objects from the scene using 
		  .getChildren.remove() related to logging in and then .getChildren.add() new/more text boxes 
		  for Insurance, Contact info, etc.
		

		[Non-functional requirements]

	 	+ You might have to make the LoginPage and Create account Page separate pages?
		  [That way patient can enter insurance info, contact number, etc.]
		  
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



//Portal Object/Class 
public class Portals {
	//This object contains: 
	//						WelcomePage, PatientPortal, NursePortal, DoctorPortal, PatientLogin, StaffLogin


	//Data of the Portals Object/Class
	//-----------------------------------------------------------------
	  //Primary Stage 
		private Stage primeStage;
		//[This is the Screen that Displays all of the Pages/Scenes created in Phase-1 document]
		
	  //Welcome Page (First Page/Scene of Program)
		private Scene welcomePage;
	 
	  //Arizona Medical Logo Image
		private Image azMedLogo;
		
	  //New Idea
		//Note text??  {Make this a global notification so that when }
		private Label notificationTxt;
		private boolean isNotified;   
		//^^Used to ensure notification messages arent added too many times
	//-----------------------------------------------------------------
	    


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
			      //PatientLogin patientLog = new PatientLogin();
			        	
		        //Load the Page/Scene	
			      //For login, the correct credentials must be entered in order to proceed to the actual 'Patient Portal'
          	      //patientLog.patientLogin();
		      
			  	  //NEW
				  patientLogin();
			  
			  });
		          
		  
		        
		    //Login Page/Scene for the Staff
	          staffLogin.setOnAction(e -> {
	        	//From the Scene loaded here the user will select the Portal they would like to use {Nurse or Doctor}
		        	  
				//CALL UPON THE STAFF LOGIN SCENE FUNCTION OR WHATEVER TF
				//HERE BRO



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
          //Set the private Stage of Portals {helps us to switch scenes easier}
            primeStage = primaryStage;
		  //Update the private boolean for notifications
		    isNotified = false; 
	}
	//------------------------------------------------------------------------------------------------------------------
	


	//Method(s) of the Portals Object/Class
	//------------------------------------------------------------------------------------------------------------------
	  //Starts the Program at the Welcome Page
	    public void runProgram() {
		  //From the Welcome Page the user can navigate to the 'login page' for Patient and Staff
		  //The 'Login Page' will take the User to the respective Portal
		  //If the user is to Logout 
			
		  //Set the Scene of the Stage & Display it
			primeStage.setScene(welcomePage);
			primeStage.show();
		}


	  //Displays the Staff Login Page
	  	private void staffLogin(){
		  //Debug
		    Label yes = new Label("YESES");

		  //Scene to be returned
			Scene loginPage = new Scene(yes, 800, 600);

		  //Create and return the scene with two buttons ()
			//return loginPage;
		}


	  //Create Account
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


	  //Log into account
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
	        	  String patientCredentials =   firstNameTxt.getText().replaceAll("\\s", "") + " " 
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
	        		
		          //Create and Display the patient Portal
		        	PatientPortal patientPort = new PatientPortal(patientCredentials);
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


	          //Compile the credentials entered by the Patient/User
	        	//Compile into one string to be passed into PatientPortal Constructor 
	        	  String patientCredentials =   firstNameTxt.getText().replaceAll("\\s", "") + " " 
	        			  					  + lastNameTxt.getText().replaceAll("\\s", "") + "," 
	        			  					  + monthTxt.getText().replaceAll("\\s", "") + "/" 
	        			  					  + dayTxt.getText().replaceAll("\\s", "") + "/" 
	        			  					  + yearTxt.getText().replaceAll("\\s", "");
	        	  //[Every String contains a regex for removing all whitespace (Makes program more Robust)]


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
	

	  
	//Objects/Class(s)
	//--------------------------------------------------------------------------------------------------------

	  //Patient Portal
	  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		class PatientPortal{
		  //Buttons/Methods:		
		  //		[Change Patient Information]	[View Previous Visits]	[Messages]	[Logout]


		  //Patient's data (Will be loaded upon the 'Login' button being hit in the Patient "Login/New Account Page" {loaded from Welcome Page})
		  //--------------------------------------------------
				private String fullName = "";	//Ex: "John Smith"
				private String dateOfBirth = "";
				private String phoneNumber = "";
				private String insuranceInfo = "";
				private String pharmacyInfo = "";
				//private boolean logout = false;
		  //--------------------------------------------------
				
		
		  //Default Constructor (DELETE this piece of code when done debugging!!) 
		  //------------------------------------	
			//public PatientPortal() {}
		  //------------------------------------
			

		  //Constructor
		  //------------------------------------------------------------------------------
			public PatientPortal(String patientCredentials){
			//Take apart the userCredentials String using delimeters
			//Update the Patient's data with the following broken up data
			
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
			private void displayPortal() {
			//Debug thing
				System.out.println("Login Successful!!");
				
				
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
  //--------------------------------------------------------------------------------------------------------
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