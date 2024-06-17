//This file contains the S


/* [Usage within Main]
  	    // Step 1: Instantiate the outer class (Portals)
        Portals portals = new Portals();
        
        // Step 2: Instantiate the inner class (patientPortal) using the outer class instance
        Portals.patientPortal portal = portals.new patientPortal();
        
        // Step 3: Call the helloThere method
        portal.helloThere();
 */


//Relevant JavaFX libraries
//-----------------------------------
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
//-----------------------------------


//Object/Class containing: WelcomePage, PatientPortal, NursePortal, DoctorPortal
public class Portals {
	//Private Data declarations		
	  //Primary Stage 
		private Stage primeStage;
		//[This is the Screen that Displays all of the Pages/Scenes created in Phase-1 document]
		
	  //Welcome Page (First Page/Scene of Program)
		private Scene welcomePage;
	  
	  //Button that brings the User back to the Welcome Page (Starting Page)
	    private Button logOut;
		//This will be used amongst all three portals {Patient, Nurse, Doctor}

	    
	//Method(s) of the Portals Object/Class
	  //Starts the Program at the Welcome Page
			void runProgram() {
			//From the Welcome Page the user can navigate to the 'login page' for Patient and Staff
			//The 'Login Page' will take the User to the respective Portal
			//If the user is to Logout 
			
			//Set the Scene of the Stage & Display it
			primeStage.setScene(welcomePage);
			primeStage.show();
		}

	  
		
	//Constructor of the Portals Object/Class
	public Portals(Stage primaryStage){
		//Pass the primaryStage <Stage> Object/Class in Main.java so the User can seemlessly transition between pages
		//Seemless transitions will be achieved by setting the private variable primeStage 
		
		//This will also make the "Logout" buttons within the Patient, Nurse & Doctor portal return us to the "Welcome Page"
		//Initialize the welcomePage Scene (This will be "global" and can be referenced by the other Scene methods)
	
		
		
		//Welcome Page Scene
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
          //The 'Welcome Page' is the "Portal to the Portals", so to speak.
          //i.e.  We will navigate to the other portals from here {Patient, Nurse Doctor}
        
		  //Header(s)/Label(s): 
	      //================================================================
	        Label header0 = new Label("Welcome");
	        header0.setStyle("-fx-font-size: 38px; -fx-font-weight: bold;");
	         
	        Label header1 = new Label("Select Login");
	        header1.setStyle("-fx-font-size: 24px;");
	      //================================================================
	        
	         
	      //Navigation buttons for Main Page:
	      //=============================================================================================
	        //Create buttons for navigating TO the portals {Patient, Nurse, Doctor}
	          Button patientLogin = new Button("Patient");
	          Button staffLogin = new Button("Staff");
	          Button nurseLogin = new Button("Nurse");		//Create NursePortal Object --> [nurseMainPage]
	          Button doctorLogin = new Button("Doctor");	//Create DoctorPortal Object --> [docMainPage]
	      //=============================================================================================
	       
          //DEBUG BUTTON (DELETE ME)  {Used to see heap Sizze}
            Button exitProg = new Button("Exit");
	           
	           
          //Load Logo onto Main Page:
          //=============================================================================================
            //Load the image
           	  Image image = new Image(getClass().getResourceAsStream("azMedical.png"));
	           
           	//Create an ImageView to display the image
           	  ImageView imageView = new ImageView(image);
	           
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
            
           	//Alignment, Padding, and Set size of buttons
            //Set size of the Buttons
              patientLogin.setPrefSize(100, 100);
              staffLogin.setPrefSize(100, 100);
              
            //Set text Size within buttons
              patientLogin.setStyle("-fx-font-size: 14px;");
              staffLogin.setStyle("-fx-font-size: 14px;");
              
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
	      //-----------------------------------------------------------------------------------------------------------
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
		  //-----------------------------------------------------------------------------------------------------------
	    
		        
	      //Create the welcomePage Scene
	        welcomePage = new Scene(mainLayout, 800, 600);          
	    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	        
	   
	    //NEW [THIS MAY NOT WORK]
		//Set Up the Logout Button & its Action Event Handling? (to be used later)
	    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	        
	     
	        
	    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
	    
	      
	        
        //Set the private Stage of Portals {helps us to switch scenes easier}
          primeStage = primaryStage;
	}

	
	//Object for the Patient Login Page / Creating a New patient account
	class PatientLogin{
		//Constructor
		//(this will be used in Main for "logging into" the account with the data the user entered {name & dob})
		public PatientLogin(){}
		
		
		//Login Page to proceed to the Patient Portal
		//The user can also create a new Accoutn from here!!! (That will load a new Scene)
		void patientLogin(){
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
	 	 	  Button goBack = new Button("Go back");
			  Button newPatient = new Button("New Patient Account");
			  Button patientLogin = new Button("Log in");
			  
			//Set the alignment of the button
			  goBack.setAlignment(Pos.CENTER);
			    
			//HBox for the Buttons 
			  VBox box0 =  new VBox(20, goBack, newPatient, patientLogin);          
		  //==========================================================
	 	    
			
			  
		  //Text Boxes
		  //================================================================================
			//Create text boxes for the    
			  TextArea firstName = new TextArea();
			//Set the dimensions of the text box
	          firstName.setPrefHeight(25);
	          firstName.setPrefWidth(100);
	      //================================================================================
			
	          
	         
	      //Action Event Handling
	      //================================================================================			  
	        //Create a new Account
	        newPatient.setOnAction(e -> {
	          //This will Create a new Account with the credentials the user has entered
	        	//HAVE TEXT THAT NOTIFIES THE USER OF THE NEW ACCOUNT CREATED AND HOW THEY 
	        	//CAN ENTER HIT the LOGIN button TO proceed to the patient portal
	        	
	          //
	        	
	        	
	        });

	          
	          
	        //Log into the Patient Account 
	        patientLogin.setOnAction(e -> {
	    	  //Call upon the "Check Credentials" Method to compare the users credentials to
	          //That in the .txt file  "Patients.txt"
	          //{THE USER CANNOT PROCEED IF CREDENTIALS INCORRECT [use if-branch]}
	        	
	        	
	          //Create and Display the patient Portal
	        	PatientPortal patientPort = new PatientPortal();
	        	patientPort.displayPortal();
	       });
	     

	        
	        //Go back to the Welcome Page
	        goBack.setOnAction(e -> {
	    	  //Go back to the Welcome Page from the 'Patient Login/New Account Page'
	    	    runProgram();
	        });
		  //================================================================================
		    
	     
	        
	      //Alignment			  
	      //=====================================================================
	        //NEW
	        
	        //firstName.setPadding(new Insets(20));
	        //firstName.setAlignment(Pos.CENTER);
	        
	        
	        VBox vertAlign = new VBox(10, box0, firstName);
	        
	          
	          
	          
	        //Create the Scene that displays the "Patient Login/New Account Page"
	          Scene loginPage = new Scene(vertAlign, 800, 600);
		        
	        
  	        //Display the Login/Create account page
	          primeStage.setScene(loginPage);
	          primeStage.show();		       
	        
	          //DEBUG PRINT
	          //System.out.println("WTFFFFF");
		  //=====================================================================

		}
			
		
		
		//[Methods to include]
		  //Check Credentials (returns true if entered credentials match a real Patient account from .txt)
		
		  //Create Account(String patientCredentials)
		
	}
	
	
	//Buttons/Methods:		
	//		[Change Patient Information]	[View Previous Visits]	[Messages]	[Logout]
	class PatientPortal{
	  //Patient's data (Will be loaded upon the 'Login' button being hit in the Patient "Login/New Account Page" {loaded from Welcome Page})
	  //------------------------------------
		private String fullName = "";
		private String dateOfBirth = "";
		private String phoneNumber = "";
		private boolean logout = false;
	  //------------------------------------
			
	
	  //Default Constructor (Delete this piece of code when done debugging!!) 
		public PatientPortal() {
			
		}
		
		
	  //Constructor
		public PatientPortal(String userCredentials){
		  //Take apart the userCredentials String using delimeters
		  // and set the following strings in  "Patient's data"
			
			
		}
		
		 
	  //Methods
		//Display the Patient Portal Scene
		public void displayPortal() {
		  //DEBUG
			Button thisBs = new Button("Debug Button");
			VBox buttonsPage = new VBox(20, thisBs);
			Scene someBs = new Scene(buttonsPage, 800, 600);
			
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
		  //Function for 
		
	}
	
	
	//Buttons/Methods:
	//		[New Visit Form]	[Messages]	[Logout]
	class NursePortal{
		
	}
	
	
	
	//Buttons/Methods:
	//		[Patient Visit Form]	[View Patient Records]	[Messages]	[Logout]
	class DoctorPortal{
		
	}
}
