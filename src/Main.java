/*********************************************************************************************************
	Description:
		This File contains boiler-plate code that will help you out a lot in programming your Group
		Project for CSE-360 this summer
	
	Library/JavaFX Info:
		
		[External JARS/Libraries used]
			- JavaSE-22	{JRE System Library}
			- JavaFX24	{java-sdk-22}			
	
		[Class path]
			- JavaSDK
			
	Etc:
			+ Virtual Machine Argument(s) used to run the .java file in EclipseIDE:
			
				--module-path /path/to/javafx-sdk-22/lib --add-modules javafx.controls,javafx.fxml
				
			[NOTE] Change VM argument(s) via: 'Run Configurations' under 'Run as' in Eclipse
*********************************************************************************************************/



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
import javafx.application.Application;
import javafx.stage.Stage;
	//[Note]: So far these libraries are relevant for Loading the scenes of the program


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
         
        	  
    	  //DEBUG!
    	  System.out.println("Program Done!");
    	  
    }
}


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
