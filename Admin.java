/*
Created - 11/12/18
User - Zechariah roberson
 
This is the admin class, which extends the player class for the game of othello
This is a class that is allowed 
*/
public class Admin extends PlayerV2{
	//A default admin constructor to set the username and password to admin
	Admin(){
		super("Admin");
		this.setPassword("password", "admin");
	}
}
