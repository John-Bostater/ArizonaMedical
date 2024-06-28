/****************************************************************************************
[Contributors]:
	- John Bostater
		
	- Tristan Andrade

	- Austin Mayhew

	- Ryan Clark

	- Juan Rosas Jr.

 	
[Description]:
	This file contains code for creating/displaying the necessary Scenes/Pages
	for the GUI. The code also perfo


[Functionality]:

	[Patient]
		//Description here


	[Staff]
		//Description here


[Aspect Ratio/Dimension of Graphical User Interface]: 
	- [4:3]	-->   [1024 x 768]	--	{Width x Height}


[Files Created/Used within the program for storing/loading data]:
	- PatientAccounts.txt 	
		{Contains: FirstName, LastName, DOB, Insurance Info, Contact Info}


	- VisitSummary.txt
		{Contains the visit summary (saved visit form's will write to here)}


	- Messages.txt:		Viewable by:	 Doctor, Nurse, Patient
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



		//NEWW!!!
		boolean accountCreated = false;
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
	      //==========================================================================================================================
	        Label header0 = new Label("Welcome");
	        header0.setStyle("-fx-font-size: 55px; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-family: 'Times New Roman';");
	         
	        Label header1 = new Label("Select Login");
	        header1.setStyle("-fx-font-size: 32px; -fx-text-fill: white; -fx-font-family: 'Times New Roman';");
	      //==========================================================================================================================
	        
	         
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
	      //=============================================================================================================  
           	//Vertical Box
           	  VBox buttonsSection = new VBox(20, patientLogin, staffLogin, exitProg);
            
            //Set the dimensions of the Buttons
           	  //[Width x Height]
           	    patientLogin.setPrefSize(120, 50);  
           	    patientLogin.setMaxSize(120, 50);
           	    patientLogin.setMinSize(120, 50);
	          //[Width x Height]
           	    staffLogin.setPrefSize(120, 50);  
           	    staffLogin.setMaxSize(120, 50);
           	    staffLogin.setMinSize(120, 50);
           	  //[Width x Height]
           	    exitProg.setPrefSize(70, 40);  
           	    exitProg.setMaxSize(70, 40);
           	    exitProg.setMinSize(70, 40);          
		          
              //Set text Size within buttons
  	            patientLogin.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-font-family: 'Times New Roman';");
				staffLogin.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-font-family: 'Times New Roman';");
				exitProg.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-font-family: 'Times New Roman';");
              
              //Set padding
              	buttonsSection.setAlignment(Pos.CENTER);
              	buttonsSection.setPadding(new Insets(10, 0, 10, 0));
                    
            //Set up the main layout of the GUI 
			  VBox mainLayout = new VBox(20, header0, azMedLogo, header1, buttonsSection);
			  mainLayout.setPadding(new Insets(10));
	        //Set all of the relevant Labels, Photos, and Buttons into center alignment
	      	  mainLayout.setAlignment(Pos.CENTER);
			//Set the background color of the Welcome page to a dark gray
			  mainLayout.setStyle("-fx-background-color: #3A3A3A;");
	      //=============================================================================================================  
	              
	         
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

	        
	  	  //Necessary File Check:	[PatientAccounts.txt]	[VisitSummary.txt]	[Messages.txt]
          //================================================================================================================
			//Check to see if the file(s) exist. If not, create it.
			try {
				//List all of the required files for the system to run
				  File patientAccounts = new File("PatientAccounts.txt");
				  File visitSummary = new File("VisitSummary.txt");
				  File messages = new File("Messages.txt");

				//TO DO!!!!
				//THere is an error with the if-branch below where if one of the files already exists
				//It is still overwritten by the 'else-branch' we need to prevent this!!!
				//OR!!!
				//	It won't be an issue because you are using the run.bat which is automatically
				//	Deleting the "PatientAccounts.txt" upon running of the batch script

				//Check to see if the file already exists and if it does not, create it
				if(patientAccounts.exists() && visitSummary.exists()) {
					//File Already exists, do nothing
					System.out.println("Both File Exists!");
				}
				//Files do not exist
				else {
				  //Create the files if they do not exist
				  	FileWriter fileWriter0 = new FileWriter("PatientAccounts.txt");
					FileWriter fileWriter1 =  new FileWriter("VisitSummary.txt");
					FileWriter fileWriter2 = new FileWriter("Messages.txt");

				  //Write the Leading text(s) to the respective files
				  	fileWriter0.write("Patient Accounts:\n\n");
					fileWriter1.write("");
					fileWriter2.write("");


				  //Close the fileWriter(s)
				  	fileWriter0.close();
					fileWriter1.close();
					fileWriter2.close();
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
		  //============================================================================================
			//Label
			  Label header0 = new Label("Select User");
				//Set the Font of the Label
		          header0.setStyle("-fx-font-size: 42px; -fx-font-weight: bold; -fx-text-fill: white");

			//Nurse Button
			  Button nurseButton = new Button("Nurse");
	  			//Set the dimensions of the Buttons
		        //[Width x Height]
			  	  nurseButton.setPrefSize(100, 40);  
		          nurseButton.setMaxSize(100, 40);
		          nurseButton.setMinSize(100, 40);
	            //Set the Font of the Button's text
		          nurseButton.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-font-family: 'Times New Roman';");

			//Doctor Button
			  Button doctorButton = new Button("Doctor");
			  //Format stuff below!!
	  			//Set the dimensions of the Buttons
		        //[Width x Height]
			  	  doctorButton.setPrefSize(110, 40);  
		          doctorButton.setMaxSize(110, 40);
		          doctorButton.setMinSize(110, 40);
	            //Set the Font of the Button's text
		          doctorButton.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-font-family: 'Times New Roman';");


			//Go Back	[Main Page]
			  Button goBack = new Button("Go Back");
				//Set the dimensions of the Buttons
		        //[Width x Height]
			  	  goBack.setPrefSize(125, 40);  
		          goBack.setMaxSize(125, 40);
		          goBack.setMinSize(125, 40);
	            //Set the Font of the Button's text
		          goBack.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-font-family: 'Times New Roman';");
		  //=====================================================================


		  //Action-Event Handling
		  //======================================================================================
			//Nurse Login  --> Create/Use Nurse Portal
			  nurseButton.setOnAction(e -> {
				//Idea:  May have to deallocate objects before new page...

				//Load Nurse Portal Object/Class to display / use the portal
				  nurseView = new NursePortal(primeStage, welcomePage);

				//Call upon the object method for displaying/using the main page for the Nurse
				  nurseView.displayPortal();
			  });


			//Doctor Login --> Create/Use Doctor Portal
			  doctorButton.setOnAction(e -> {
				//Load Nurse Portal Object/Class to display / use the portal
				  doctorView = new DoctorPortal(primeStage, welcomePage);

				//Call upon the object method for displaying/using the main page for the Doctor
				  doctorView.displayPortal();
			  });


			//Go Back (Set all of the global variables to 'null' and go back)
			  goBack.setOnAction(e -> {
				//Run the main page again
				  runProgram();
			  });
		  //======================================================================================


		  //Scene & Alignments
		  //============================================================================
			//VBox for ordering items
			  VBox buttonBox = new VBox(20, header0, nurseButton, doctorButton, goBack);
			  	//Align the vbox elements to be in the middle???
				  buttonBox.setAlignment(Pos.CENTER);
			  	//Set the Background color of the page
				  buttonBox.setStyle("-fx-background-color: #3A3A3A;");

			//Scene for the 
			  Scene staffPage = new Scene(buttonBox, 1024, 768);
		  //============================================================================


		  //Display the scene created
			primeStage.setScene(staffPage);
			primeStage.show();
		}


	  //Create Account	[Patient]		//UPDATED: og had just "patientCredentials" {1 parameter}
		private void createAccount(String patientCredentials, String phoneNum, String insuranceProv, String pharmacyProv) {
		  //Append the patients Credentials to the "PatientAccounts.txt"
		
		  //[DEBUG!!]	
		  	System.out.println("All the other strings: \n" + "\t[Phone Number]: " + phoneNum);


			try {
			  //Load [PatientAccounts.txt] for writing		
				FileWriter fileWriter = new FileWriter("PatientAccounts.txt", true);
			  //[Note]:  'true' in the second parameter tells the fileWriter the file already exists
			    
				
			  //Append the new Patient's name to the .txt file
			    fileWriter.append(patientCredentials + "\n");

				//Add more patient info??? (I.e. add the default vals: PhoneNum = XXX-XXX-XXXX)

			 
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
          //===============================================================================================================
			//Relevant Buttons for the Login/New Account Page 
			
			//Log in
			  Button patientLogin = new Button("Log in");
	  			//Set the dimensions of the Buttons
		        //[Width x Height]
			  	  patientLogin.setPrefSize(100, 45);  
		          patientLogin.setMaxSize(100, 45);
		          patientLogin.setMinSize(100, 45);
	            //Set the Font of the Button's text
		          patientLogin.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-font-family: 'Times New Roman';");
			
		    //Create Account
			  Button newPatient = new Button("Create Account");
	  			//Set the dimensions of the Buttons
		        //[Width x Height]
			  	  newPatient.setPrefSize(195, 45);  
		          newPatient.setMaxSize(195, 45);
		          newPatient.setMinSize(195, 45);
		        //Set the Font of the Button's text
		          newPatient.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-font-family: 'Times New Roman';");
		    
			
			//NEW BUTTON
			//This will create the new account with the inputted credentials
			  Button confirmAccount = new Button("Confirm");
				//Set the dimensions of the button
				  //Code here


		    //Go Back      
		      Button goBack = new Button("Go back");
				//Set the dimensions of the Buttons
				//[Width x Height]
					goBack.setPrefSize(120, 45);  
					goBack.setMaxSize(120, 45);
					goBack.setMinSize(120, 45);
				//Set the Font of the Button's text
					goBack.setStyle("-fx-font-size: 24px; -fx-font-family: 'Times New Roman';");      


			//NEW BUTTON TO EXIT THE PAGE (Leaves less ambiguity in language)
			//REPLACE ALL goBack with our new Exit button & vice versa
			  Button exitPage = new Button("Exit Page");

          //===============================================================================================================
			  

		  //Text Boxes
		  //================================================================================
			//Create text boxes for the Credentials the user will be entering
			
			//First Name
			  TextArea firstNameTxt = new TextArea();
				//Set the dimensions of the text box
		        //[Width x Height]
			  	  firstNameTxt.setPrefSize(200, 35);  
 		          firstNameTxt.setMaxSize(200, 35);
		          firstNameTxt.setMinSize(200, 35);
				//Set the size of the text
				  firstNameTxt.setStyle("-fx-font-size: 16px;");

	        //Last Name
	          TextArea lastNameTxt = new TextArea();
				//Set the dimensions of the text box
		        //[Width x Height]
			  	  lastNameTxt.setPrefSize(200, 35);  
		          lastNameTxt.setMaxSize(200, 35);
		          lastNameTxt.setMinSize(200, 35);
				//Set the size of the text
				  lastNameTxt.setStyle("-fx-font-size: 16px;");
		          

		    //Date Of Birth    
		      //(Broken up into three text boxes (MM/DD/YYYY)
		      //Month
 		        TextArea monthTxt = new TextArea();
		        //Set the dimensions of the text box
 		        //[Width x Height]
 		          monthTxt.setPrefSize(75, 35);  
 		          monthTxt.setMaxSize(75, 35);
		          monthTxt.setMinSize(75, 35);
				//Set the size of the text
				  monthTxt.setStyle("-fx-font-size: 16px;");

	          //Day
 		        TextArea dayTxt = new TextArea();
		        //Set the dimensions of the text box
 		        //[Width x Height]
 		          dayTxt.setPrefSize(75, 35);  
 		          dayTxt.setMaxSize(75, 35);
		          dayTxt.setMinSize(75, 35);
				//Set the size of the text
				  dayTxt.setStyle("-fx-font-size: 16px;");

	          //Year
 		        TextArea yearTxt = new TextArea();
		        //Set the dimensions of the text box
 		        //[Width x Height]
 		          yearTxt.setPrefSize(100, 35);  
 		          yearTxt.setMaxSize(100, 35);
		          yearTxt.setMinSize(100, 35);
				//Set the size of the text
				  yearTxt.setStyle("-fx-font-size: 16px;");


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
              TextArea insuranceTxt = new TextArea("<Insurance Provider>");
              //Set the dimensions of the text area/box
                insuranceTxt.setPrefSize(250, 40);
                insuranceTxt.setMinSize(250, 40);
                insuranceTxt.setMaxSize(250, 40);
              //Set the size of the text in the text box
                insuranceTxt.setStyle("-fx-font-size: 18px;");


          	//Pharmacy Provider
              TextArea pharmacyTxt = new TextArea("<Pharmaceutical Provider>");
            	//Set the dimensions of the text area/box
                  pharmacyTxt.setPrefSize(300, 40);
                  pharmacyTxt.setMinSize(300, 40);
                  pharmacyTxt.setMaxSize(300, 40);
                //Set the size of the text in the text box
                  pharmacyTxt.setStyle("-fx-font-size: 18px;");
	      //================================================================================
		       
	          
	      //Labels & Headers 
		  //================================================================================
			//Labels for organizing userInput
	          Label header = new Label("Patient Login");
	          //Set Font
	            header.setStyle("-fx-font-size: 38px; -fx-font-weight: bold; -fx-text-fill: white;");
	            //header.setAlignment(Pos.CENTER);
	            
	        //Labels relating to the user Credentials
	        //-------------------------------------------------
	          //First Name
	            Label firstNameLbl = new Label("First Name:");
	            //Set Font
	              firstNameLbl.setStyle("-fx-font-size: 26px; -fx-font-weight: bold");          
	              
	          //Last Name
	            Label lastNameLbl = new Label("Last Name:");
	            //Set Font
	              lastNameLbl.setStyle("-fx-font-size: 26px; -fx-font-weight: bold");
	          
	          		
	          //Date of Birth 
	            Label dobLbl = new Label("Date of Birth:");
	            //Set Font
	          	  dobLbl.setStyle("-fx-font-size: 26px; -fx-font-weight: bold");

		        //Separate: MM / DD / YYYY
	 	          Label dobSep0 = new Label("/");
		          Label dobSep1 = new Label("/");
		         	 //Set Font
		            	dobSep0.setStyle("-fx-font-size: 26px; -fx-font-weight: bold");
		            	dobSep1.setStyle("-fx-font-size: 26px; -fx-font-weight: bold");
			  
		            
		      //New account Text
		        Label accText = new Label("New Patient?");
				  //Set the font & size
		        	accText.setStyle("-fx-font-size: 24px; -fx-text-fill: white;");

		        	
		 	  //DOB format guide for user
				Label dobFrmtLbl = new Label("\t\t\t(MM / DD / YYYY)");
				dobFrmtLbl.setStyle("-fx-font-size: 26px; -fx-font-weight: bold");
				dobFrmtLbl.setAlignment(Pos.CENTER);


			  //NEW LABELS & HEADERS!! {Phone Num, Insurance, Pharmacy}
			  //Phone Number
            	Label phoneNumLbl = new Label("Phone Number:");
              	  //Set font of Text
                	phoneNumLbl.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
			  
			  //Digit seperators for the phone number
				Label phoneDash0 = new Label("-");
				  //Set the font of the Label
					phoneDash0.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
				
				Label phoneDash1 = new Label("-");
				  //Set the font of the Label
					phoneDash1.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
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
          		  credContainer.setPrefSize(500,250);
          		  credContainer.setMaxSize(500,250);
          		  credContainer.setMinSize(500,250);
				//NEW, Set the alignment of the cred container
				  credContainer.setAlignment(Pos.CENTER);
		          
          	  //This will position the Vbox correctly 
          		HBox credSection = new HBox(credContainer);
          		credSection.setAlignment(Pos.CENTER);
          		credSection.setPadding(new Insets(25));
	              //Set the Background color of the credentials box & the border radii
				  	credContainer.setStyle("-fx-background-color: lightblue; -fx-background-radius: 10;");
   	        //-------------------------------------------------------------------------
	          
          		
	        //Functional Buttons Section:  [Login]  &  [New Account]
          	//-------------------------------------------------------------------------
          	  //Place all of the functionality buttons into a VBox		//NEW: include the notification message?
          	  VBox buttonContainer = new VBox(10, patientLogin, accText, newPatient, exitPage);
          	    //Alignment
          	      buttonContainer.setAlignment(Pos.CENTER);
				//Set the background color to gray??
				   

			  //NEW!!!	[If a new account has been created display the relevant message!]
			    if(accountCreated){
				  //Set the notification text notifying the user their account has been successfully created
					notificationTxt = new Label("*Account Successfully Created.\n  You may proceed to login.");
					//Set the color of the text
						notificationTxt.setStyle("-fx-text-fill: white;");

					buttonContainer.getChildren().add(notificationTxt);
				}
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
	        	  

			  //UPDATE THE NOTIFCATION TEXT TO DISPLAY: Required text box missing or incorrect
			  //if any of the text field are empty!!
			  //Check that all textFields have an entry & their minimum text length is met 
			  //Use this knowledge to construct a simple if-branch
			  //The user has not entered the minimum amount of chars do not make an account
				if(    firstNameTxt.getText().length() == 0  
					|| lastNameTxt.getText().length() == 0
					|| monthTxt.getText().length() != 2
					|| dayTxt.getText().length() != 2
					|| yearTxt.getText().length() != 4 
				){
				  //Update the flag so the user cannot proceed to making a new account
				  //validEntry = false;

				  //Notify the user of their mistake if they have not already been
					if(!isNotified){
					  //Notify user that their entry is invalid
						notificationTxt = new Label("*Required text box is missing or invalid");
						  //Set the color of the text
							notificationTxt.setStyle("-fx-text-fill: white;");

					  //Add the notification to the page
						buttonContainer.getChildren().add(notificationTxt);
					  
					  //Update the flag (User will be notified only once)
						isNotified = true;
					}
				}
				else{
				  //Remove the old notification if it exists
					buttonContainer.getChildren().remove(notificationTxt);

				  //Disable the notification??
				    isNotified = false;
				}


	        	//[DEBUG PRINT] Delete when done
	        	  //System.out.println("Creds: " + patientCredentials);
	        
	        	//Successful Login
	        	//Check to see if the entered credentials exist/match that of an existing Patient Account (Loaded from .txt file) 
	        	if(checkCredentials(patientCredentials)){
	        	  //Update global variables before proceeding to new Scene
					isNotified = false;
	        		
		          //Create and Display the patient Portal
		        	PatientPortal patientPort = new PatientPortal(patientCredentials, primeStage, welcomePage);
		        	patientPort.displayPortal();
	            }
				//Unsuccessful Login
				else{
				  //Make sure the user is only notified of their mistake once
				  if(!isNotified){
					//Add notification text to inform user
					  notificationTxt = new Label("*Account does not exist");
						//Set the color of the text
						  notificationTxt.setStyle("-fx-text-fill: white;");

					//Add the notification text to the Page
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
	        	

				//NEW!!
				//SEt the flag to false??
				isNotified = false;

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
				//[This code would have to be implemented here...]

			  //Make a "Create Account method that returns the Scene"

			  //Make the user text entry box bigger
			  	credContainer.setPrefSize(500,400);
			  	credContainer.setMinSize(500,400);
			  	credContainer.setMaxSize(500,400);



			  //Add the HBox(s) for the new account entry info!!
			  	HBox phoneNumSection = new HBox(5, phoneNumLbl, phoneNum0, phoneDash0, phoneNum1, phoneDash1, phoneNum2);	//Move this up to its proper section above??


			  //Add new text boxes to the credentials container
			  	credContainer.getChildren().add(phoneNumSection);


			  //Remove all of the buttons from the container & load the new one's relevant to the Login page
			  	buttonContainer.getChildren().clear();

			  //Add the relevant buttons for account creation to the container
				buttonContainer.getChildren().add(confirmAccount);
				buttonContainer.getChildren().add(goBack);
	        });
	      


			//Confirm the Account data entered to be written to the PatientAccounts.txt
			confirmAccount.setOnAction(e -> {
			
				//Add the no


				//This might make my computer explode !!
			  //Compile the credentials entered by the Patient/User
			  //Compile into one string to be passed into PatientPortal Constructor 
				String patientCredentials =   firstNameTxt.getText().replaceAll("\\s", "") + "," 
	        			  					  + lastNameTxt.getText().replaceAll("\\s", "") + "," 
	        			  					  + monthTxt.getText().replaceAll("\\s", "") + "/" 
	        			  					  + dayTxt.getText().replaceAll("\\s", "") + "/" 
	        			  					  + yearTxt.getText().replaceAll("\\s", "");
			  //[Every String contains a regex for removing all whitespace via: ("\\s", "")
			  //This helps to make the program more Robust

			  
			  //These String are passed to the new createAccount method!!!
				String phoneNumber = phoneNum0.getText() + "-" + phoneNum1.getText() + "-" + phoneNum2.getText();
				String insuranceProvider = insuranceTxt.getText();
				String pharmacyProvider = pharmacyTxt.getText();
				

			  //Flag to make sure the user has correctly entered their data to the field
			    boolean validEntry = true;


			  //Check that all textFields have an entry & their minimum text length is met 
  			  //Use this knowledge to construct a simple if-branch
			  //The user has not entered the minimum amount of chars do not make an account
			    if(    firstNameTxt.getText().length() == 0  
					|| lastNameTxt.getText().length() == 0
					|| monthTxt.getText().length() != 2
					|| dayTxt.getText().length() != 2
					|| yearTxt.getText().length() != 4 
				  ){
					//Update the flag so the user cannot proceed to making a new account
					  validEntry = false;

					//Notify the user of their mistake if they have not already been
					if(!isNotified){
					  //Notify user that their entry is invalid
					    notificationTxt = new Label("*Required text box is missing or invalid");
						  //Set the color of the text
						  	notificationTxt.setStyle("-fx-text-fill: white;");

					  //Add the notification to the page
						buttonContainer.getChildren().add(notificationTxt);
					  //Update the flag (User will be notified only once)
					    isNotified = true;
					}
 			    }
			  //[Note for later]: If you want to make this more verbose you can write it out so the user
			  //			is notified which of the text fields/box(s) needs to be adjusted or filled out


			  //Create a New Account!
	        	if(!checkCredentials(patientCredentials) && validEntry) {
					//Remove any previous Notifications
					  //buttonContainer.getChildren().remove(notificationTxt);


					//[HERE!!]
					//UPDATE THIS METHOD BELOW SO THAT IT ALSO TAKES our new text boxes we created: [Phone#: 3 text boxes] [Insurance: 1 text] [pharmacy: 1 text]
					//NEW
					  createAccount(patientCredentials, phoneNumber, insuranceProvider, pharmacyProvider);


	        		//Account does not exist, create a new Patient Account with the credentials entered
	        		 //OLD!! createAccount(patientCredentials);


					//REmove all of the buttosn again to add[Notifcation Txt] [Login] [Go Back]
					  buttonContainer.getChildren().clear();


					//Set the notificationtext to something nEW!!
					if(!isNotified){
					  //Set the notification text and place it into the box
						notificationTxt = new Label("*Account Successfully Created\nYou may Proceed to Login");
						  //Set the style of the label
						  	notificationTxt.setStyle("-fx-font-size: 18px; -fx-text-fill: white;");

					  //Add the notification to page
						buttonContainer.getChildren().add(notificationTxt);

					  //Update the flag
						isNotified = true;
					}
					
					//Add the functionality to Login or go back
					  buttonContainer.getChildren().add(patientLogin);
					  buttonContainer.getChildren().add(goBack);
	        	}
	          //Account already exists
	        	else {
					//Notify the user that the account credentials already exist

					//If-branch to make sure the user isn't being notified to much
					if(!isNotified){
					  //Update the notification text/label and add it to the GUI Display
						notificationTxt = new Label("*Account already exists, you may proceed to login.");
						  //Set the color of the text
						  	notificationTxt.setStyle("-fx-text-fill: white;");

					  //Clear the functionality container & any other notifications
					  	buttonContainer.getChildren().clear();
					
					  //Add the login button/function
						buttonContainer.getChildren().add(patientLogin);

					  //Add the button/function to go back to the login page
						buttonContainer.getChildren().add(goBack);

					  //Set the color of the text
						buttonContainer.getChildren().add(notificationTxt);

					  //User has been notified
					    isNotified = true;	
					}
	        	}        	


			});


	        //Go back to the Patient Login Page (this button is used in "Create Account")
	        goBack.setOnAction(e -> {
			  //Update Notification Flag to false
			    isNotified = false;

	          //Go back to the Patient Login Page
			  	patientLogin();
	        });


	        //Go back to the Welcome Page
	        exitPage.setOnAction(e -> {
			  //Update Notification Flag to false
			    isNotified = false;

			  //Update the Account creation flag
			  	//accountCreated = false;

	          //Go back to the Welcome Page from the 'Patient Login/New Account Page'
	    	    runProgram();
	        });
		  //================================================================================
		

	      //Compile the Main Layout of the loginPage
           	VBox mainLayout = new VBox(header, credSection, buttonContainer);
           	mainLayout.setAlignment(Pos.CENTER);
			  //Set the background color of the page
			  	mainLayout.setStyle("-fx-background-color: #3A3A3A;");
       	  
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