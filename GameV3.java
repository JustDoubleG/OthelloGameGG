

public class GameV3 {

	//Establish Board
	SBoardV3 testBoard = new SBoardV3();
			
	//Estalish Players
	PlayerV3 player1 = new PlayerV3("black");
	PlayerV3 player2 = new PlayerV3("white");
	
	//Establish Player Color
			
	//Booleans for thought
	Boolean player1sTurn = true;
	Boolean Victory = false;
	
	public GameV3() {
		this.testBoard = testBoard;
		player1.setNumberValue(1);
		player2.setNumberValue(2);
		this.player1sTurn = player1sTurn;
		this.Victory = Victory;
	}
	
	
	
	
	
	/*public boolean gameOver() {
		if(possibleMoves(testBoard, player1) == true) {
			
		}
	}*/
	
	
	
	public static void main(String[] args) {
		
		SBoardV3 testBoard = new SBoardV3();
		
		
		
		//********************************************* Print Original Board
		System.out.println("THE BASE BOARD: ROUND 1");
		testBoard.PrintBoard();
		System.out.println(testBoard.playerTurn().getNumberValue());
		System.out.println();
		System.out.println();
		testBoard.possibleMoves2();
		System.out.println("POSSIBLE MOVES: ROUND 1");
		testBoard.PrintBoard();
		System.out.println("Player Number: " + testBoard.playerTurn().getNumberValue());
		System.out.println("P1Turn: " + testBoard.p1Turn);
		System.out.println();
		System.out.println();
		//testBoard.CapturePiece2(2,4);
		testBoard.reset3s();
		System.out.println("RESET 3'S: ROUND 1");
		testBoard.PrintBoard();
		System.out.println("Player Number: " +testBoard.playerTurn().getNumberValue());
		System.out.println("P1Turn: " + testBoard.p1Turn);		
		System.out.println();
		System.out.println();
		testBoard.takeTurn();
		System.out.println("AFTER TURN 1: ROUND 2");
		testBoard.PrintBoard();
		System.out.println("Player Number: " +testBoard.playerTurn().getNumberValue());
		System.out.println("P1Turn: " + testBoard.p1Turn);		
		System.out.println();
		System.out.println();
		testBoard.possibleMoves2();
		System.out.println("POSSIBLE MOVES: ROUND 2");
		testBoard.PrintBoard();
		System.out.println("Player Number: " +testBoard.playerTurn().getNumberValue());
		System.out.println("P1Turn: " + testBoard.p1Turn);
		/*
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
		
		/*System.out.println(testBoard.p1Turn);
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
		*/
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
