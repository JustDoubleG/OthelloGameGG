

public class GameV2 {

	//Establish Board
	SBoard testBoard = new SBoard();
			
	//Estalish Players
	Player player1 = new Player("black");
	Player player2 = new Player("white");
	
	//Establish Player Color
			
	//Booleans for thought
	Boolean player1sTurn = true;
	Boolean Victory = false;
	
	public GameV2() {
		this.testBoard = testBoard;
		player1.setColorValue(1);
		player2.setColorValue(2);
		this.player1sTurn = player1sTurn;
		this.Victory = Victory;
	}
	
	public void takeTurn() {
		if(this.player1sTurn == true) {
		this.player1sTurn = false;
		}
		else {
			this.player1sTurn = true;
		}
	}
	
	public Player whoTurn() {
		if(this.player1sTurn == true){
			return player1;
		}
		else {
			return player2;
		}
	}
	
	/*public boolean gameOver() {
		if(possibleMoves(testBoard, player1) == true) {
			
		}
	}*/
	
	
	
	public static void main(String[] args) {
		
		SBoard testBoard = new SBoard();
		Player player1 = new Player("black");
		Player player2 = new Player("white");
		player1.setColorValue(1);
		player2.setColorValue(2);
		/*
		//********************************************* Print Original Board
		testBoard.PrintBoard();
		System.out.println();
		System.out.println();
		
		//*********************************************Print Player1's possible moves
		testBoard.possibleMoves2();
		testBoard.PrintBoard();
		System.out.println();
		System.out.println();
		
		
		//*********************************************
		testBoard.CapturePiece2(2,4);
		testBoard.reset3s();
		//testBoard.takeTurn();
		testBoard.PrintBoard();
		System.out.println();
		System.out.println();
		
		
		testBoard.possibleMoves2();
		testBoard.PrintBoard();
		System.out.println();
		System.out.println();*/
		
		System.out.println(testBoard.p1Turn);
		System.out.println(testBoard.playerTurn().getColor());
		testBoard.takeTurn();
		System.out.println(testBoard.p1Turn);
		System.out.println(testBoard.playerTurn().getColor());
		testBoard.takeTurn();
		System.out.println(testBoard.p1Turn);
		System.out.println(testBoard.playerTurn().getColor());
		testBoard.takeTurn();
		System.out.println(testBoard.p1Turn);
		System.out.println(testBoard.playerTurn().getColor());
		testBoard.takeTurn();
		System.out.println(testBoard.p1Turn);
		System.out.println(testBoard.playerTurn().getColor());
		
		/*
		//********************************************* End Player1's Turn NO 3's
		testBoard.reset3s();
		testBoard.PrintBoard();
		System.out.println();
		System.out.println();
		*/
		/*
		//*********************************************Swtich Turn Player2's Possible Moves
		
		testBoard.takeTurn();
		testBoard.possibleMoves2();
		testBoard.PrintBoard();
		System.out.println();
		System.out.println();
		*/
		/*
		System.out.println(testBoard.p1Turn);
		testBoard.takeTurn();
		System.out.println(testBoard.p1Turn);
		testBoard.takeTurn();
		System.out.println(testBoard.p1Turn);*///illistrate turns
		
		
		
		System.out.println();
		System.out.println();
	
	
	}
}
