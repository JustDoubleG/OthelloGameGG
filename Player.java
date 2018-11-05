/*
Created - 11/5/18
User - Zechariah roberson
Last Modified - 11/5/18 ZR
 
This is the player class for the game of othello

*/
public class Player {
private int movesTaken, score, color;
private String username;
//Default constructor initializes username and score for a new player
Player(String newUsername){
	this.username = newUsername;
	this.score = 4;
}
//Get the number of moves that have been taken already
public int getMovesTaken() {
	return this.movesTaken;
}
//Add 1 to the number of moves
public void addMoves() {
	this.movesTaken++;
}
//get the username of the player
public String getUsername() {
	return this.username;
}
//Add a certain number of pieces catured to the player's score
public void addScore(int piecesCaptured) {
	this.score += piecesCaptured;
}
//Remove pieces from the player's score
public void subScore(int piecesTaken) {
	this.score -= piecesTaken;
}
//Get the player's current score
public int getScore() {
	return this.score;
}
//Set the player's color on the board to either 1 or 2 
public void setColor(int newColor) {
	if (newColor < 1 || newColor > 2)
		System.out.println("Not a valid color");
	else 
		color = newColor;
}
//Get the player's color in int form
public int getColor() {
	return this.color;
}

}
