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

  [New Visit Form]:
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

//[VERY IMPORTANT NOTE FOR THE FUTURE/LATER in writing this program]
//  Consider making the buttons of the mainPage [New Visit Form] [Messages] [Logout]
//  Private data of the NursePortal Object & instantiate them in the NursePortal Constructor
//  This way they can be used later in the Doctor Portal Methods???
//  This probably won't work but once you have a working program you are comfortable with plz consider it
//  [It could also help create less allocations on the heap???]


public class NursePortal{
  //Private Data & Variables
  //------------------------------------------
    //Stage used to display the Scenes/Methods
      private Stage primeStage;

    //Welcome Page (Used upon logout)
      private Scene welcomePage;

    //Since the Doctor portal extends the NursePortal we will need to use this ID to differentiate them
      private String staffId;


    //There may be no more??
      //This is a new dumb idea but i want to try it out
        // VBox vertical0;
  //------------------------------------------


  //Constructor
  //------------------------------------------------------------------------------
    public NursePortal(Stage primaryStage, Scene welcomeScene){
      //Set the private variables...
        primeStage = primaryStage;
        welcomePage = welcomeScene;
        staffId = "Nurse";
    }
  //------------------------------------------------------------------------------


  //[New Visit Form]      [Messages]      [Logout]

  //Methods
  //------------------------------------------------------------------------------
    //Run the Main Portal page for the Nurse Portal & all of its functionality
    public void displayPortal(){
      //Create the scene: Buttons, Action-Event, Alignment, Scene...

      //Labels/Headers
      //===========================================================================
        //Welcome
          Label header0 = new Label("Welcome!");
            //Set Font & size of text
              header0.setStyle("-fx-font-size: 42px; -fx-font-weight: bold; -fx-text-fill: white;");

        //What would you like to do today??
          Label header1 = new Label("What would you like to do today?");
            //Set Font & size of text
              header1.setStyle("-fx-font-size: 20px; -fx-text-fill: white;");
      //===========================================================================


      //Buttons
      //===========================================================================
        //New Visit Form
          Button newVisitButton = new Button("New Visit Form");
            newVisitButton = new Button("New Visit Form");
            //Set the Dimensions of the Button
              newVisitButton.setPrefSize(200, 45);
              newVisitButton.setMinSize(200, 45);
              newVisitButton.setMaxSize(200, 45);
            //Set the Font size of the text
              newVisitButton.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-font-family: 'Times New Roman';");

        //Messages
          Button messageButton = new Button("Messages");
            //Set the Dimensions of the Button
              messageButton.setPrefSize(150, 45);
              messageButton.setMinSize(150, 45);
              messageButton.setMaxSize(150, 45);
            //Set the Font size of the text
              messageButton.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-font-family: 'Times New Roman';");

        //Logout
          Button logoutButton = new Button("Logout");
            //Set the Dimensions of the Button
              logoutButton.setPrefSize(110, 45);
              logoutButton.setMinSize(110, 45);
              logoutButton.setMaxSize(110, 45);
            //Set the Font size of the text
              logoutButton.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-font-family: 'Times New Roman';");
      //===========================================================================


      //Action-Event Handling
      //===========================================================================
        //New Visit Form      [This will save to:  "PatientSummary.txt"  <-- rename this .txt file]
          newVisitButton.setOnAction(e -> {
            //stuff here
              //code there
              //Call upon the method
              primeStage.setScene(newVisitForm());
              primeStage.show();
          });


        //Messages
          messageButton.setOnAction(e -> {
            //stuff here
              //code there
          });


        //Logout
          logoutButton.setOnAction(e -> {
            //Load the welcome page and display it    [Side Note: deallocate items??]
              primeStage.setScene(welcomePage);
              primeStage.show();
          });
      //===========================================================================


      //Alignment
      //===========================================================================================
        //Vertically align the Buttons/Functionality of the Nurse Portal
          VBox vertical0 = new VBox(20, header0, header1, newVisitButton, messageButton, logoutButton);
            //Alignment
              vertical0.setAlignment(Pos.CENTER);

        //Horizontally align the Vertical alignment of buttons and labels/texts
          HBox horizontal0 = new HBox(vertical0);
            //Alignment
              horizontal0.setAlignment(Pos.CENTER);
            //Set the background color of the scene
              horizontal0.setStyle("-fx-background-color: #3A3A3A;");
      //===========================================================================================


      //Build the Scene
        Scene mainLayout = new Scene(horizontal0, 1024, 768);

      //Display the Scene
        primeStage.setScene(mainLayout);
        primeStage.show();
    }


    //New Visit Form
    private Scene newVisitForm(){
      //Labels, Buttons, TextBoxes, Action-Event Handling, Alignments, Scene
        //Code here...

      //Labels
      //====================================================================
        //Vitals
          Label vitalsLbl = new Label("Vitals:");
            //Set the Dimensions & Font style
              //   vitalsLbl.setPrefSize();

          //Weight
            Label weightLbl = new Label("Weight:");
              //Set the dimensions & font style
                //Code here

          //Height
            Label heightLbl = new Label("Height:");
              //Set the dimensions & font style
                //Code here

          //Feet/Inches
            Label feetInchLbl = new Label("Feet/Inches:");
              //Set the dimensions & font style
                //Code here

          //Body Temperature
            Label bodyTempLbl = new Label("Body Temperature:");
              //Set the dimensions & font style

                //Code here

          //Blood Pressure
            Label bloodPressureLbl = new Label("Blood Pressure:");
              //Set the dimensions & font style
                //Code here


        //Patient Credentials
          Label patientCredsLbl = new Label("Patient Credentials:");
            //Set dimensions & font style
              //Code here...

          //First Name
            Label firstNameLbl = new Label("First Name:");
              //Set the dimensions & font style
                //Code here

          //Last Name
            Label lastNameLbl = new Label("Last Name:");
              //Set the dimensions & font style
                //Code here

          //Date Of Birth
            Label dobLbl = new Label("Date of Birth:");
              //Set the dimensions & font style
                //Code here



        //Patient's Previous History
          Label previousHistoryLbl = new Label("Patient's Previous History:");
            //Set the dimensions & font style
              //Code here...


        //Nurse's Notes
          Label nurseNotesLbl = new Label("Nurse's Notes:");
            //Set the dimension & font style
              //Code here...
      //====================================================================

      //NEW!!!
        //Call upon the method that returns the VBox
        //patientCredsBox();


      //Final Vertical Alignment
        VBox finalLayout = new VBox(patientCredsBox());

      //Build the Scene
        Scene mainLayout = new Scene(finalLayout, 1024,768);
      //Return the Scene
        return mainLayout;
    }

  
  //This will return something that has a dropdown menu that will load all of the 
  //NEW!!!
  //Make a VBox method that returns the "Patient Summary VBox", which is loaded via the String variable in the parameter
    private VBox patientCredsBox(){
      //Labels, Text Boxes{will load data from the DropDown}, DropDown, ActionEvent, Alignment, Return VBox

      //Labels
      //===========================================================================
        //Patient Credentials:
          Label patientCredsLbl = new Label("Patient Credentials:");
            //Set the dimension & Style
              patientCredsLbl.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        //Select Patient  [Displayed next to or above the dropdown menu]
          Label patientSelectLbl = new Label("Select Patient:");
            //Set the dimension & style
              patientSelectLbl.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        //First Name
          Label firstNameLbl = new Label("First Name:");
            //Set the dimension & style
              firstNameLbl.setStyle("-fx-font-size: 20px;");

        //Last Name
          Label lastNameLbl = new Label("Last Name:");
            //Set the dimension & style
              lastNameLbl.setStyle("-fx-font-size: 20px;");

        //Date Of Birth
          Label dobLbl = new Label("Date of Birth:");
            //Set the dimension & style
              dobLbl.setStyle("-fx-font-size: 20px;");

        //(MM / DD / YYYY)
          Label dobAlignLbl = new Label("(MM/DD/YYYY)");
            //Set the dimension & style
              dobAlignLbl.setStyle("-fx-font-size: 18px;");

        //Date of birth Seperators "/"
//          Label dobSep0 = new Label("/");
            //Set the dimension & style
//              dobSep0.setStyle("-fx-font-size: 18px;");

        //Date of birth Seperators "/"
//          Label dobSep1 = new Label("/");
            //Set the dimension & style
//              dobSep1.setStyle("-fx-font-size: 18px;");
      //===========================================================================


      //Text Boxes
      //===========================================================================
        //First Name Text Box
          TextArea firstNameTxt = new TextArea();
            //Set the dimensions
              firstNameTxt.setPrefSize(100, 30);
              firstNameTxt.setMinSize(100, 30);
              firstNameTxt.setMaxSize(100, 30);
            //Set the style of the text box
              firstNameTxt.setStyle("-fx-font-size: 14px;");

        //Last Name Text Box
          TextArea lastNameTxt = new TextArea();
            //Set the dimensions
              lastNameTxt.setPrefSize(100, 30);
              lastNameTxt.setMinSize(100, 30);
              lastNameTxt.setMaxSize(100, 30);
            //Set the style of the text box
              lastNameTxt.setStyle("-fx-font-size: 14px;");

        //Date of Birth Text Box
          TextArea dobTxt = new TextArea();
            //Set the dimensions
              dobTxt.setPrefSize(100, 30);
              dobTxt.setMinSize(100, 30);
              dobTxt.setMaxSize(100, 30);
            //Set the style of the text box
              dobTxt.setStyle("-fx-font-size: 14px;");
      //===========================================================================


      //DropDown Menu
      //===========================================================================
        //Create the dropdown menu
          ComboBox<String> dropDown = new ComboBox<>();
            //Set dimension of the dropdown menu??
              dropDown.setPrefSize(175, 30);
              dropDown.setMinSize(175, 30);
              dropDown.setMaxSize(175, 30);
            //Set the style
              dropDown.setStyle("-fx-font-size: 14px;");


        //Collect all of the patient credentials and place them into the combo box
          try{
            //Open 'PatientAccounts.txt' for reading!!
              //Code here...
              Scanner fileReader = new Scanner(new File("PatientAccounts.txt"));

            //Counter for adding elements to the dropDown menu
              short counter = 0;

            //String array for holding all of the Exam Dates
              String[] allPatients = new String[50];

            //Instantiate the String
              for(short i = 0; i < 50; i++){
                //Add an empty String to the indexed value
                  allPatients[i] = "";
              }

            //Read all of the file's contents
              while(fileReader.hasNextLine()){
                //Place the file being read into a String
                  String line = fileReader.nextLine();

                //Collect all of the patient credentials via this if statement
                if( !line.contains("\t") 
                      && !line.contains("\n") 
                      && !line.contains("Patient Accounts:")
                      && !line.isEmpty()
                ){
                  //DEBUG
                    System.out.println("Line: " + line);

                  //Add the line to the String
                    //Code here...
                    allPatients[counter] = line;

                  //Increment the index/counter
                    counter++;
                }
              }

            //Add the String Array to the ComboBox
              for(short i = 0; i < 50; i++){
                //Add exam dates
                  if(allPatients[i] != ""){
                    //DEBUG
                      //System.out.println("Success!!");

                    //Add the Exam date to the box
                      dropDown.getItems().add(allPatients[i]);
                  }
                //Else, help the garbage collector
                  else{
                    //Set the empty slots to null
                      allPatients[i] = null;
                  }
              }
          }
          catch(IOException e){
            //Do nothing...
          }


        //Load the

      //===========================================================================


      //Action-Event Handling
      //===========================================================================
        //DropDown Menu Selection 
          dropDown.setOnAction(event -> {
            //Get the selected item and make sure that 

          });
      //===========================================================================


      //Alignment
      //===========================================================================
        //Horizontal Boxes
          //First Name
            HBox horizontal0 = new HBox(5, firstNameLbl, firstNameTxt);

          //Last Name
            HBox horizontal1 = new HBox(5, lastNameLbl, lastNameTxt);

          //Date of Birth
            HBox horizontal2 = new HBox(5, dobLbl, dobTxt);


        //3 VBox(s) credSection & then an ecapsulation of (patientCredsLbl, credSection)
        //DropDown 
          VBox dropDownBox = new VBox(5, patientSelectLbl, dropDown);
            //Set the alignment of the VBox
              dropDownBox.setAlignment(Pos.CENTER);
        
        //Credentials Section 
          VBox credSection = new VBox(5, dropDownBox, horizontal0, horizontal1, horizontal2);
            //Set the dimensions, style, & color
              credSection.setPrefSize(400, 400);
              credSection.setMinSize(400, 400);
              credSection.setMaxSize(400, 400);
            //Set the alignment of the VBox
              credSection.setAlignment(Pos.CENTER);

        //Encapsulating VBox that we will return
          VBox mainLayout = new VBox(10, patientCredsLbl, credSection);
            //Set the alignment of the VBox
              mainLayout.setAlignment(Pos.CENTER);
      //===========================================================================

      //Return the VBox
        return mainLayout;
    }




//NEW METHODS THAT NEED TO BE EDITED/FORMED TO WORK ALONGSIDE A DROPDOWN MENU 
//

//USE A HASHMAP TO MAP THE PATIENTS UNIQUE CREDS:    HASHMAP<STRING, STRING>
//WHEN THE USER SELECTES PATIENT CREDS THROUGH THE DROPDOWN MENU (YOU)
/*
      //[DOCTOR WILL INHERIT THIS METHOD WITH NO CHANGES NEEDED TO BE MADE/NECESsARY!!]
      //This method will display/load the Scene for sending & reading messages
      //
      //[This method looks like the patient portal but there is a dropdown menu for 
      //                                  selecting which patients messages .txt file you want to open]
      private Scene messagePage(){
        //Labels, Buttons, Text Box, Action-Event Handling, Scene

        //Labels
        //=====================================================================================================
          //Message Board
            Label messageBrdLbl = new Label("Message Board:");
              //Set the Font & size of the text
                messageBrdLbl.setStyle("-fx-font-size: 34px; -fx-font-weight: bold; -fx-text-fill: white;");
                
          //Message
            Label messageLbl = new Label("Message:");
              //Set the size of the text
                messageLbl.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");

          //Inbox
            Label inboxLbl = new Label("Inbox:");
              //Set the size of the text
                inboxLbl.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");


          //Select Patient [Drop Down Menu]
            Label selectPatientLbl = new Label("Select Patient:");
              //Set the Font and other features
                //selectPatienLbl.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: white;");
        
          //Patient Contact Information
            //Have the Phone Number Displayed in a text box next to this label!!!
            Label contactInfoLbl = new Label("Patient Contact:");
        //=====================================================================================================


        //Buttons
        //=======================================================================
          //Send Message
            Button sendMessage = new Button("Send Message");
              //Set the dimensions of the Button
                sendMessage.setPrefSize(150, 40);
                sendMessage.setMinSize(150, 40);
                sendMessage.setMaxSize(150, 40);
              //Set the Font size of the text
                sendMessage.setStyle("-fx-font-size: 18px;");


          //Delete Message
            Button deleteMessage = new Button("Delete Message");
            //^^This will simply remove the lines of the .txt file after & including "Patient Name:"
              //Set the dimensions of the Button
                deleteMessage.setPrefSize(175, 40);
                deleteMessage.setMinSize(175, 40);
                deleteMessage.setMaxSize(175, 40);
              //Set the Font size of the text
                deleteMessage.setStyle("-fx-font-size: 18px;");


          //Exit
            Button goBack = new Button("Exit");
              //Set the dimensions of the Button
                goBack.setPrefSize(100, 40);
                goBack.setMinSize(100, 40);
                goBack.setMaxSize(100, 40);
              //Set the Font size of the text
                goBack.setStyle("-fx-font-size: 18px;");
        //=======================================================================


        //Text Boxes
        //=======================================================================
          //Message Text Box  {Anything written here will be posted to the board}
            TextArea messageTxt = new TextArea();
              //Set the dimensions of the text box
                messageTxt.setPrefSize(300, 525);
                messageTxt.setMinSize(300, 525);
                messageTxt.setMaxSize(300, 525);
              //Set the Font size of the text
                messageTxt.setStyle("-fx-font-size: 18px;");
              //Set text wrapping 
                messageTxt.setWrapText(true);                
                //[Note]: ^^ any text that exceeeds the width will fall to a new line


          //Inbox Text Box
            TextArea inboxTxt = new TextArea();
              //Set the dimensions of the text box
                inboxTxt.setPrefSize(600, 525);
                inboxTxt.setMinSize(600, 525);
                inboxTxt.setMaxSize(600, 525);
              //Set the Font size of the text
                inboxTxt.setStyle("-fx-font-size: 18px;");
              //Set text wrapping 
                inboxTxt.setWrapText(true);                
                //[Note]: ^^ any text that exceeeds the width will fall to a new line

          //Get the Messages from the unique Patients account
            inboxTxt.setText(getMessages());

          //Phone Number Text Box [Will be next to contactInfoLbl]
            TextArea phoneNumTxt = new TextArea();
              //Set the dimensions of the the text box

        //=======================================================================


        //Action-Event Handling
        //=============================================================================
          //Send Message
            //This will open the "Messages.txt" file for reading & writing
            sendMessage.setOnAction(e -> {
              //Add/Append the message written in "Message: " to the Inbox/Current Conversation              
              //Fill the ComboBox with all of the Visit Dates via: PatientSummary.txt
                try{
                  //Open: <this.fullName>PatientInfo.txt
                    File patientInbox = new File(this.fullName.replace(" ", "") + "Messages.txt");    

                  //Open the File Writer for adding new messages to the file
                    FileWriter fileWriter = new FileWriter(patientInbox, true);
                      //[we set 'true' so that the fileWriter can append to the file]

                  //If the File exists append the new message to the end
                    if(patientInbox.exists() && !messageTxt.getText().isEmpty()){      
                      //Save the message sent to the global variable [so it can be used in deletion]
                      //Empty the global variable used for sending messages
                        messageSent = "[" + this.fullName + "]: " + messageTxt.getText() + "\n\n";
                
                      //Append the new message to the "<FullName>Message.txt"
                        fileWriter.append(messageSent);
                
                      //Empty the text area used for sending messages
                        messageTxt.setText("");

                      //Close the file writer
                        fileWriter.close();
                    }
                  //Else, file does not exist
                    else{
                      //Create the file
                        fileWriter.write("");

                      //Close the File Reader
                        fileWriter.close();
                    }
                }
                catch(IOException n){
                  //File doesn't exits do nothing
                  //Might have to creat a new file???
                }

              //if [<Patient Name>]: does NOT exist, start the first comment [If while-loop finished without finding user]

              //Update the inbox to show the new message added
                inboxTxt.setText(getMessages());
            });


          //Delete Message
            deleteMessage.setOnAction(e -> {
              //Count the total number of messages sent by the user {i.e. count everytime we see: "[fullName]:"}

              //Then reread the file and collect all of the text and stop once we see the last instance of [fullName]:
              //Then use .write() to rewrite all of the text in the <fullName>Messages.txt NOT including the last message sent by the user

              //JUst gonna get my brain spaghetti out !!!
              try{
                //Get the messages via our method...
                  
                  //If the message inbox is not empty...
                  if(getMessages() != "<Inbox Empty>"){
                    //DEBUG
                      //All messages in the .txt file
                      System.out.println("Inbox: \n" + getMessages());
    
                    //DEbug
                      //Print the last message sent/saved in the global variable
                        //System.out.println("Message sent: " + this.messageSent);

                    //Write this into the <this.fullName>Messagest.txt
                    String editedStr = getMessages().replace(this.messageSent, "");
                    
                    //Edit the <this.fullName>Messages.txt to have the new inbox displayed!
                      File editedFile = new File(this.fullName.replaceAll(" ", "") + "Messages.txt");

                    //Open a file writer for writing the new text into the .txt file
                      FileWriter fileWriter0 = new FileWriter(this.fullName.replaceAll(" ", "") + "Messages.txt");

                    //DEBUG STATEMENT
                      //System.out.println("Edited TExt: \n" + editedStr);

                    //If the string we made is not empty, update the .txt file
                      if(this.messageSent != ("[" + this.fullName + "]: \n\n")){
                        //Replace all of the text in the Messages.txt with the latest message deleted
                          fileWriter0.write(editedStr);
        
                        //Place new text into inbox being displayed
                          inboxTxt.setText(editedStr);

                        //CLOSE THE FILE WRITER OMG
                          fileWriter0.close();
                      }
                    
                  }

                //If the inbox is empty display the relevant text
                  if(inboxTxt.getText().isEmpty()){
                    //Set the inbox text
                      inboxTxt.setText("<Inbox Empty>");
                  }
              }
              catch(IOException l){
                //File does not exist.. either do nothing? or create it...
              }
            });


          //Exit
            goBack.setOnAction(e-> {
              //Call upon displayPortal()
                displayPortal();
            });
        //=============================================================================


        //Alignments
        //==========================================================================================
          //Message:
            VBox messageSection = new VBox(5, messageLbl, messageTxt);
            
          //Inbox:
            VBox inboxSection = new VBox(5, inboxLbl, inboxTxt);
          
          //HBox containing the text fields & their resepective labels (background color: lightblue)
            HBox messageBoard = new HBox(10, messageSection, inboxSection); 
              //Set Style, alignment, borders, & rounded edges
                messageBoard.setStyle("-fx-border-color: black; -fx-border-width: 1px;  -fx-background-padding: 10; -fx-background-radius: 10; -fx-background-color: lightblue;");
                messageBoard.setAlignment(Pos.CENTER);        
              //Set the dimensions of the "Message Board"
                messageBoard.setPrefSize(950, 600);
                messageBoard.setMinSize(950, 600);
                messageBoard.setMaxSize(950, 600);


          //Horizontally Align the Buttons/Functionality
            HBox buttonContainer = new HBox(30, sendMessage, deleteMessage, goBack);
              //Set the alignment of the button container
                buttonContainer.setAlignment(Pos.CENTER);
                

          //Vertically align all of the sections {Last VBox}
            VBox finAlign = new VBox(20, messageBrdLbl, messageBoard, buttonContainer);
              //Set the alignment of the VBox
              //Maybe unecessary???
                finAlign.setAlignment(Pos.CENTER);
              //Set the background color of the entire page to gray
                finAlign.setStyle("-fx-background-color: #3A3A3A;");
        //==========================================================================================


        //Build the Scene
          Scene mainLayout = new Scene(finAlign, 1024, 768);
      
        //Return the Scene
          return mainLayout;
      }



  //Getters & Setters
  //-------------------------------------------------------------------------------------------------------
    //Returns all of the text within: <this.fullName>Messages.txt
      private String getMessages(String patientsCreds){
        //Open the  File for reading and read every line and set the inboxTxt to it!!
          try{
            //Collect the Lines into a String variable
              String messageStr = "";

            //Open the file & if it exists post the text to the messageBoard
              File inboxFile = new File(patientsCreds.replaceAll(" ", "") + "Messages.txt");

            //Scanner that will read the file
              Scanner fileReader = new Scanner(inboxFile);

            //Read all of the text in the file and place it into the inbox
              while(fileReader.hasNextLine()){
                //Add the lines to the string
                  messageStr += fileReader.nextLine() + "\n";
              }

            //Close the file reader
              fileReader.close();

            //If the Messagebox is empty set return empty notification
              if(messageStr.isEmpty()){
                //Return the notification
                  return "<Inbox Empty>";
              }

            //Return the string
              return messageStr;
        }
        catch(IOException m){
          //Do nothing...
            return "<Inbox Empty>";
        }
    }
  
  //*/
  //------------------------------------------------------------------------------
}