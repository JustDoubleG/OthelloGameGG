
public class PlayerV3 {
	private int movesTaken, score, numberValue;
	private String username;
	private String password;
	boolean myTurn;
	
	
	//Default constructor initializes username and score for a new player
	PlayerV3(String newUsername){
		this.username = newUsername;
		this.password = "";
		this.score = 2;
		this.movesTaken = 0;
		this.myTurn = false;
		this.numberValue = 0;
	}
	PlayerV3(String name, String pass){
		this.username = name;
		this.password = pass;
		this.score = 2;
		this.movesTaken = 0;
		this.myTurn = false;
		this.numberValue = 0;
	}
	PlayerV3(){
		this.username = "TempName";
		this.password = "";
		this.score = 2;
		this.movesTaken = 0;
		myTurn = false;
		numberValue = 0;
	}
	//**************************************************************************************************//
	//GET AND SET USERNAME
	public String getUsername() {
		return this.username;
	}
	//**************************************************************************************************//
	//GET AND SET PASSWORD
	
	//**************************************************************************************************//
	//GET AND SET SCORE
	public int getScore() {
		return this.score;
	}
	public void setScore(int s) {
		this.score = s;
	}
	//**************************************************************************************************//
	//GET AND SET MOVES TAKEN
	public int getMovesTaken() {
		return this.movesTaken;
	}
	public void setMoves(int num) {
		this.movesTaken = num;
	}
	//**************************************************************************************************//
	//GET AND SET MYTURN
	public boolean getMyTurn() {
		return this.myTurn;
	}
	public void setMyTurn(boolean my) {
		this.myTurn = my;
	}
	//**************************************************************************************************//
	//GET AND SET NUMBERVALUE
	public int getNumberValue() {
		return this.numberValue;
	}
	public void setNumberValue(int v) {
		if (v < 1 || v > 2)
			System.out.println("Not a valid color");
		else 
			numberValue = v;
	}
	//**************************************************************************************************//
}