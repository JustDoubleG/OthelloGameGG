
public class PlayerV5 {
	private int movesTaken, score, numberValue;
	private String username;
	private String password;
	boolean hadPossibleMoves;
	int completionOfTurn;
	
	
	//Default constructor initializes username and score for a new player
	PlayerV5(String newUsername){
		this.username = newUsername;
		this.password = "";
		this.score = 2;
		this.movesTaken = 0;
		this.hadPossibleMoves = false;
		this.numberValue = 0;
		this.completionOfTurn = 0;
	}
	PlayerV5(String name, String pass){
		this.username = name;
		this.password = pass;
		this.score = 2;
		this.movesTaken = 0;
		this.hadPossibleMoves = false;
		this.numberValue = 0;
		this.completionOfTurn = 0;
	}
	PlayerV5(){
		this.username = "TempName";
		this.password = "";
		this.score = 2;
		this.movesTaken = 0;
		hadPossibleMoves = false;
		numberValue = 0;
		completionOfTurn = 0;
	}
	//**************************************************************************************************//
	public void setCompletionOfTurn(int i) {
		this.completionOfTurn = i;
	}
		
	public int getCompletionOfTurn() {
		return this.completionOfTurn;
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
	public boolean getHadPossibleMoves() {
		return this.hadPossibleMoves;
	}
	public void setHadPossibleMoves(boolean my) {
		this.hadPossibleMoves = my;
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
	public int setPassword(String oldPassword, String newPassword) {
		if(oldPassword == this.password) {
			this.password = newPassword;
			return 1;//Return 1 so that the program knows it is successful
		}
		else 
			return 0;//Return 0 so that the program knows it is unsuccessful
	}
	
	/*public void checkInfo(String uName, String Pwd) {
		if (uName == this.username) {
			if(Pwd == this.password) {
				this.valid = 1;
				return;
			}
		}else {
			return;
		}
	}
	public int getValidity(){
		return this.valid;
	}*/
	
}