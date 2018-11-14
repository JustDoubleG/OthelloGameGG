

public class GameV5 {
	GameInterfaceV8 game;
	
	Boolean gameVictory = false;
	
	public GameV5() {
		game = new GameInterfaceV8();
		gameVictory = false;
	}
	
	public void PlayGame() {
		if(this.game.boardImportant.checkVictory() == false) {
			while(this.game.boardImportant.checkVictory() == false){
				this.game.boardImportant.possibleMoves2();
				this.game.updateUI(this.game.boardImportant);
				this.game.boardImportant.CapturePiece2(this.game.row,this.game.column);
				this.game.boardImportant.switchPlayerTurnIndicator();
				this.game.boardImportant.reset3s();
			}
		}
	}
	
	
	public PlayerV5 whoTurnIsIt() {
		if(this.game.boardImportant.p1Turn == 1) {
			return this.game.boardImportant.getPlayer1();
		}
		else {
			return this.game.boardImportant.getPlayer2();
		}
	}
	/*public void PlayGame() {
		while(this.game.boardImportant.checkVictory() == false){
			this.takeTurn(this.whoTurnIsIt());
		}
	}*/
	public void takeTurn(PlayerV4 p) {
		PlayerV4 currentPlayer = p;
		if(currentPlayer.getCompletionOfTurn() == 0) {//if p1Turn = is 1(true) and Player one has not taken a turn
			this.game.boardImportant.possibleMoves2(currentPlayer);
			this.game.updateUI(this.game.boardImportant);
			this.game.boardImportant.CapturePiece2(this.game.row,this.game.column);
			this.game.updateUI(this.game.boardImportant);
				
				/*this.game.boardImportant.reset3s();
				this.game.updateUI(this.game.boardImportant);
				this.game.boardImportant.switchPlayerTurnIndicator();
			}
			else {
				this.game.boardImportant.switchPlayerTurnIndicator();
			}*/
			
		}	
	}
	
	public void UpdateGameUI() {
		this.game.updateUI(this.game.boardImportant);
	}
	
	
	public static void main(String[] args) {
		
		GameV5 game1 = new GameV5();
		//**************************************************************************************************//

		//GameV4 game1 = new GameV4();
		game1.game.boardImportant.PrintBoard();
		System.out.println("The Current Player Value is: " + game1.whoTurnIsIt().getNumberValue());
		System.out.println("Player1 Completion of Turn: " + game1.game.boardImportant.getPlayer1().getCompletionOfTurn());
		
		//game1.game.boardImportant.switchPlayerTurnIndicator();
		//game1.takeTurn(game1.whoTurnIsIt());
		
		game1.game.boardImportant.possibleMoves2(game1.game.boardImportant.getPlayer1());
		game1.game.boardImportant.PrintBoard();
		game1.UpdateGameUI();
		System.out.println("");
		game1.game.boardImportant.CapturePiece2(game1.game.row,game1.game.column);
		game1.game.boardImportant.PrintBoard();
		System.out.println("The Current Player Value is: " + game1.whoTurnIsIt().getNumberValue());
		System.out.println("Player1 Completion of Turn: " + game1.game.boardImportant.getPlayer1().getCompletionOfTurn());
		
		//**************************************************************************************************//
		/*SBoardV7 test = new SBoardV7();
		test.PrintBoard();
		System.out.println();
		test.possibleMoves2(test.whoTurn());
		test.PrintBoard();
		System.out.println();
		test.CapturePiece2(test.whoTurn(),4,2);
		test.PrintBoard();
		System.out.println();*/
		
		/*GameV4 game1 = new GameV4();
		game1.game.boardImportant.PrintBoard();
		System.out.println();
		game1.game.boardImportant.possibleMoves2(game1.whoTurnIsIt());
		game1.UpdateGameUI();
		
		game1.game.boardImportant.CapturePiece2(game1.whoTurnIsIt(),game1.game.row,game1.game.column);
		game1.game.boardImportant.PrintBoard();
		System.out.println();
		
		game1.UpdateGameUI();
		System.out.println("stuff");
		game1.game.boardImportant.reset3s();
		game1.UpdateGameUI();
		game1.game.boardImportant.PrintBoard();
		System.out.println();
		*/
		//**************************************************************************************************//
		/*			DEMONSTRATE PLAYER TURNS
		System.out.println("The Current Player Value is: " + game1.whoTurnIsIt().getNumberValue());
		System.out.println("Player1 Completion of Turn: " + game1.game.boardImportant.getPlayer1().getCompletionOfTurn());
		System.out.println("Player2 Completion of Turn: " + game1.game.boardImportant.getPlayer2().getCompletionOfTurn());
		game1.game.boardImportant.switchPlayerTurnIndicator();
		System.out.println("The Current Player Value is: " + game1.whoTurnIsIt().getNumberValue());
		System.out.println("Player1 Completion of Turn: " + game1.game.boardImportant.getPlayer1().getCompletionOfTurn());
		System.out.println("Player2 Completion of Turn: " + game1.game.boardImportant.getPlayer2().getCompletionOfTurn());
		game1.game.boardImportant.switchPlayerTurnIndicator();
		System.out.println("The Current Player Value is: " + game1.whoTurnIsIt().getNumberValue());
		System.out.println("Player1 Completion of Turn: " + game1.game.boardImportant.getPlayer1().getCompletionOfTurn());
		System.out.println("Player2 Completion of Turn: " + game1.game.boardImportant.getPlayer2().getCompletionOfTurn());
		game1.game.boardImportant.switchPlayerTurnIndicator();
		System.out.println("The Current Player Value is: " + game1.whoTurnIsIt().getNumberValue());
		System.out.println("Player1 Completion of Turn: " + game1.game.boardImportant.getPlayer1().getCompletionOfTurn());
		System.out.println("Player2 Completion of Turn: " + game1.game.boardImportant.getPlayer2().getCompletionOfTurn());
		game1.game.boardImportant.switchPlayerTurnIndicator();*/
		//**************************************************************************************************//
		
		/*if(justASBoard.checkVictory() == false) {
			while(justASBoard.checkVictory() == false){
				
			}
		}
		*/
		
		System.out.println();
		System.out.println();
	
	
	}
}
