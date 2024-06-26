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

  [Patient Visit Form]:
    //Text here...


  [View Patient Records]
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


//NEW IDEA!!
//  This class extends the NursePortal?? since they have somewhat similar functions???
//  [You can overload & overwrite methods]

public class DoctorPortal extends NursePortal{
	//This object contains: 
	//  [Patient Visit Form]    [View Patient Records]  [Messages]  [Logout]

	//Data of the Portals Object/Class
	//-------------------------------------------------------------------------------------------
	  //The same as the nurse portal... they can be accessed and changed via: super???
	//-------------------------------------------------------------------------------------------


	//Constructor (since they are all kinda the same yanno?)
	//-------------------------------------------------------------------------------------------
	  public DoctorPortal(Stage primaryStage, Scene welcomeScene){
		//Call upon the same constructor of the NursePortal (since they act similar)
		  super(primaryStage, welcomeScene);
	  }
	//-------------------------------------------------------------------------------------------


	//Methods
	//-------------------------------------------------------------------------------------------
	  //We will be using the same methods to that of the NursePortal but we will override them
	  //that way we can manipulate aspect of the stuff that we want to or whatever
	  //Display portal that has the same name....
	  

	  //Display the Main Page
	  @Override
	    public void displayPortal(){
		  //Set the Buttons, Labels, Action-Event, etc.  [In the future this may be moved to the constructor?]

		  //Labels
		  //========================================================================

		  //========================================================================


		  //Buttons
		  //========================================================================

		  //========================================================================


		  //Action-Event Handling
		  //========================================================================

		  //========================================================================


		  //Alignment
		  //========================================================================
		  //========================================================================


		  //Set the Scene & Display it
		}


	  //Methods you already have...  (these can be reference within the Action Event buttons you created)
		//	[Messages]
		//	[Logout]
	//-------------------------------------------------------------------------------------------
}