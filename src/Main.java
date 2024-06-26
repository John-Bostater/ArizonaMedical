/*********************************************************************************************************
[Contributors]:
  - John Bostater
    
  - Tristan Andrade

  - Austin Mayhew

  - Ryan Clark

  - Juan Rosas Jr.


[Description]:
  //Text here describing the whole program


[Library/JavaFX Info]:
  
  [External JARS/Libraries used]
    - JavaSE-22.0.1 {JRE System Library}
    - JavaFX22	    {java-sdk-22.0.1}			

  [Class path]
    - JavaSDK

      
[Etc]:
  + [Running Program in Terminal]

    //Compile/Build Object
      javac --module-path "/path/to/javafx-sdk-22.0.1/lib" --add-modules javafx.controls,javafx.fxml Main.java

    //Run the executable
      java --module-path "/path/to/javafx-sdk-22.0.1/lib" --add-modules javafx.controls,javafx.fxml Main


  + Virtual Machine Argument(s) [For running in EclipseIDE]:
  
    --module-path /path/to/javafx-sdk-22/lib --add-modules javafx.controls,javafx.fxml
    
  [NOTE] Change VM argument(s) via: 'Run Configurations' under 'Run as' in Eclipse
*********************************************************************************************************/


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


/*[Side Notes]
 *	This is the boiler-plate code for your CSSE-360 SU24 Project "Arizona Medical"
 * 
 *  [Programming Notes]:	
 *  	- Make "Start page" be in "Main" / the driver
 *  
 *  	- For your Objects/Classes use inheritance when possible! 
 *  
 *  	- Use data types such as public and private to protect data!
 * 
 *  
 *  	- Load patient Names & DOB from a .txt document and put said patients data into a
 *  	  String[] Array named 'allPatients' (Set DEFAULT_CAPACITY to 5 patients?)
 *  	  This string array 'allPatients' will be used in our CheckBox (dropdown menu) 
 *  
*/


//Relevant JavaFX imports for our GUI
//------------------------------------
import javafx.application.Application;
import javafx.stage.Stage;
//------------------------------------


//Driver of program: "Arizona Medical"
public class Main extends Application{
	//Driver for our 'hw1' Class/Object
  public static void main(String[] args) {
      launch(args);
  }

  //Sets up the GUI, along with the event handling & functionality of the program
  public void start(Stage primaryStage) {
    //Program Loop: 
    //-------------------------------------------------------------------------------------------------------
    //Title of the program
        primaryStage.setTitle("Arizona Medical");
    
      //Load the Welcome Page of the program and continue from there...
        //We pass primaryStage into the Portal Object to be used within the Object 
        //for seemless page transitions as well as displaying our GUI
        Portals driver = new Portals(primaryStage);
        
      //Call upon the public method to run the program
      driver.runProgram();      
    //-------------------------------------------------------------------------------------------------------
  }
}