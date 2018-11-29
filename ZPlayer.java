public class ZPlayer {
	private int score; 
	private int numberValue;
	private String username;
	private String password;
	boolean hadPossibleMoves;
	int completionOfTurn;
	boolean isComputer;
	
	
	//Default constructor initializes username and score for a new player
	ZPlayer(String newUsername){
		this.username = newUsername;
		this.password = "";
		this.score = 2;
		this.hadPossibleMoves = false;
		this.numberValue = 0;
		this.completionOfTurn = 0;
		this.isComputer = false;
	}
	ZPlayer(String name, String pass){
		this.username = name;
		this.password = pass;
		this.score = 2;
		this.hadPossibleMoves = false;
		this.numberValue = 0;
		this.completionOfTurn = 0;
		this.isComputer = false;
	}
	ZPlayer(){
		this.username = "TempName";
		this.password = "";
		this.score = 2;
		hadPossibleMoves = false;
		numberValue = 0;
		completionOfTurn = 0;
		this.isComputer = false;
	}
	//**************************************************************************************************//
	//GET AND SET SCORE			Made by: Sean
	//Edited by:					Description: Manipulate Player.score
	public int getScore() {		//Get Score
		return this.score;
	}
	public void setScore(int s) {//Set Score
		this.score = s;
	}
	//**************************************************************************************************//
	//GET AND SET NumberValue	Made by: Zach
	//Edited by:Sean				Description:Get and Set the NumberValue (determines White or Black)
	public int getNumberValue() {//Get NV
		return this.numberValue;
	}
	public void setNumberValue(int v) {//Set NV
		if (v < 1 || v > 2)
			System.out.println("Not a valid color");
		else 
			numberValue = v;
	}
	//**************************************************************************************************//
	//GET AND SET UserName		Made by: Zach
	//Edited by:Sean				Description:Get and Set the UserName
	public String getUsername() {//Get Username
		return this.username;
	}
	public void setUsername(String u) {//SetUserName
		this.username = u;
	}
	//**************************************************************************************************//
	//GET AND SET UserName		Made by: Zach
	//Edited by:Sean				Description:Get and Set the password
	public String getPassword() {//Get Password
		return this.password;
	}
	public void setPassword(String p) {//Set Password
		this.password = p;
	}
	public int setPassword(String oldPassword, String newPassword) {
		if(oldPassword == this.password) {
			this.password = newPassword;
			return 1;//Return 1 so that the program knows it is successful
		}
		else 
			return 0;//Return 0 so that the program knows it is unsuccessful
	}
	//**************************************************************************************************//
	//GET AND SET possibleMoves	Made by: Sean
	//Edited by:					Description:Get and Set the possibleMoves
	//HadPossibleMoves = false means don't have any 3s for that player
	//HadPossibleMoves = true means they do have 3s for that player
	public boolean getHadPossibleMoves() {
		return this.hadPossibleMoves;
	}
	public void setHadPossibleMoves(boolean my) {
		this.hadPossibleMoves = my;
	}
	//**************************************************************************************************//
	//GET AND SET competionOfTurnes	Made by: Sean
	//Edited by:						Description:Get and Set the completionOfTurns
	public void setCompletionOfTurn(int i) {
		this.completionOfTurn = i;
	}
		
	public int getCompletionOfTurn() {
		return this.completionOfTurn;
	}
	//**************************************************************************************************//
	//GET AND SET SCORE			Made by: Sean
	//Edited by:					Description: Manipulate isComputer
	public boolean getIsComputer() {
		if(this.username == "Computer") {
			this.isComputer = true;
		}
		else {
			this.isComputer = false;
		}
		return this.isComputer;
	}
	public void setIsComputer() {
		this.isComputer = true;
		//this.username = "Computer";
		
	}
	//**************************************************************************************************//
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