

public class GameV4 {
	GameInterfaceV7 game;
	
	Boolean gameVictory = false;
	
	public GameV4() {
		game = new GameInterfaceV7();
		gameVictory = false;
	}
	
	public void PlayGame() {
		if(this.game.boardImportant.checkVictory() == false) {
			while(this.game.boardImportant.getVictory() == false){
				this.game.boardImportant.possibleMoves2();
				this.game.updateUI(this.game.boardImportant);
				this.game.boardImportant.CapturePiece2(this.game.row,this.game.column);
				this.game.boardImportant.takeTurn();
				this.game.boardImportant.reset3s();
			
			}
		}
	}
	
	
	
	
	
	/*public boolean gameOver() {
		if(possibleMoves(testBoard, player1) == true) {
			
		}
	}*/
	
	
	
	public static void main(String[] args) {
		
		/*GameInterfaceV4Sho gi = new GameInterfaceV4Sho();
		System.out.println("Board Inside of GameInterface");
		gi.boardImportant.PrintBoard();*/
		
		GameV4 game1 = new GameV4();
		game1.PlayGame();
		
		
		System.out.println();
		System.out.println();
	
	
	}
}
