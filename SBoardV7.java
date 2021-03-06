public class SBoardV7 {
	private String gameNum;						//The name of the game, ex: Game1
	public int[][] dB;							//The matrix that hold the values that determines the logic behind a game
	public boolean pMove;						//Keeps track if a player has a possible move during a turn.
	public boolean p1Turn = true;				//Attempt to keep track of turns NEEDS A SOLUTION
	private PlayerV3 player1 = new PlayerV3();	//An instance of player
	private PlayerV3 player2 = new PlayerV3();	//An instance of player
	
	//Constructor for current version of board
	public SBoardV7() {
		//Declare the variables used in an instance of the game
		gameNum = "one";
		pMove = false;
		p1Turn = true;
		player1 = new PlayerV3();
		player2 = new PlayerV3();
		player1.setNumberValue(1);
		player2.setNumberValue(2);
		player1.setMyTurn(true);
		dB= new int[][] {
			{0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 2, 2, 2, 1, 0, 0 },
			{0, 2, 0, 0, 0, 0, 0, 0 },
			{0, 2, 0, 1, 2, 0, 0, 0 },
			{0, 2, 0, 2, 1, 0, 0, 0 },
			{0, 1, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0 },
		};
	}
	
	
	//**************************************************************************************************//
	public String getName() {//Return the variable gameNum 
		return this.gameNum;
	}
	
	
	//**************************************************************************************************//
	public int[][] getMatrix(){//Return the variable dB 
		return this.dB;
	}
	
	
	//**************************************************************************************************//
	public boolean getPossibleMovesBoolean() {//Return the variable pMove 
		return this.pMove;
	}
	
	
	//**************************************************************************************************//
	public void setPossibleMovesBoolean(Boolean b) {//Set the variable pMove
		this.pMove = b;
	}
	
	
	//**************************************************************************************************//
	public boolean getPlayerTurn() {//if p1Turn = true p1s move else p2s
		return this.p1Turn;
	}
	
	
	//**************************************************************************************************//
	public void setPlayerTurn(boolean b) {//Set value of p1Turn
		this.p1Turn = b;
	}
	
	
	//**************************************************************************************************//
	public int getValue(int row, int column) {//Get value of a cell from given row and column
		int value = this.dB[row][column];
		return value;
	}
	
	
	//**************************************************************************************************//
	public void setValue(int row, int column, int v) {//Set value of a cell from given row and column
		this.dB[row][column] = v;
	}
	
	
	//**************************************************************************************************//
	public void takeTurn() {
		if(this.pMove == true){
			if(this.p1Turn == true) {
				this.p1Turn = false;
				this.player1.myTurn = false;
				this.player2.myTurn = true;
				}
				else {
					this.p1Turn = true;
					this.player1.myTurn = true;
					this.player2.myTurn = false;
				}
		}
	}
	
	
	//**************************************************************************************************//
	/*                                         THREE's RESET                     	                    */
	//**************************************************************************************************//
	public void reset3s() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(this.getValue(i, j) == 3){
					this.setValue(i, j, 0);
				}
			}
		}
	}
	
	
	//**************************************************************************************************//
	/*                                         PLAYER TURN                                              */
	//**************************************************************************************************//
	public PlayerV3 playerTurn() {
		if(this.p1Turn == true) {
			return player1;
		}
		else {
			return player2;
		}
	}
	
	public PlayerV3 whoTurn() {
		if(this.p1Turn == true){
			return player1;
		}
		else {
			return player2;
		}
	}
	
	
	//**************************************************************************************************//
	/*                                         PRINT BOARD                                              */
	//**************************************************************************************************//
	public void PrintBoard() {
		int counter = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print("  " + this.getValue(i,j) );
				counter ++;
				if(counter%8 == 0) {
					System.out.println();
				}
			}
		}
	}
	
	public Boolean isValidPosition(int row, int column) {
		return (row >= 0 && row <=7 && column >=0 && column<=7);
	}
	
	//**************************************************************************************************//
	/*                                         POSSIBLE MOVES                                           */
	//**************************************************************************************************//
	public void possibleMoves2() {
		//get Player color
		int num1 = this.playerTurn().getNumberValue();
		int num2;
		if(num1 == 1) {
			num2 = 2;
		}
		else {
			num2 = 1;
		}
		
		boolean pMoves = false;
		int column = 0;
		int row = 0;
		
		//Checks all directions
		for(int r = 0; r < 8; r++) {
			for(int c = 0; c < 8; c++) {
				//Up
				if (this.getValue(r, c) == num1 && this.isValidPosition(r - 1, c) && this.getValue(r - 1, c) == num2) {
					int x = 1;
					while (this.getValue(r - x, c) == num2) {
						x++;
					}
					if (this.getValue(r - x, c) == 0) {
						this.setValue(r - x, c, 3);
					}
				}
				
				//Down
				if (this.getValue(r, c) == num1 && this.isValidPosition(r + 1, c) && this.getValue(r + 1, c) == num2) {
					int x = 1;
					while (this.getValue(r + x, c) == num2) {
						x++;
					}
					if (this.getValue(r + x, c) == 0) {
						this.setValue(r + x, c, 3);
					}
				}
				
				//Left
				if (this.getValue(r, c) == num1 && this.isValidPosition(r, c - 1) && this.getValue(r, c - 1) == num2) {
					int x = 1;
					while (this.getValue(r, c - x) == num2) {
						x++;
					}
					if (this.getValue(r, c - x) == 0) {
						this.setValue(r, c - x, 3);
					}
				}
				
				//Right
				if (this.getValue(r, c) == num1 && this.isValidPosition(r, c + 1) && this.getValue(r, c + 1) == num2) {
					int x = 1;
					while (this.getValue(r, c + x) == num2) {
						x++;
					}
					if (this.getValue(r, c + x) == 0) {
						this.setValue(r, c + x, 3);
					}
				}
				
				//Up - Left
				if (this.getValue(r, c) == num1 && this.isValidPosition(r - 1, c - 1) && this.getValue(r - 1, c - 1) == num2) {
					int x = 1;
					while (this.getValue(r - x, c - x) == num2) {
						x++;
					}
					if (this.getValue(r - x, c - x) == 0) {
						this.setValue(r - x, c - x, 3);
					}
				}
				
				//Up - Right
				if (this.getValue(r, c) == num1 && this.isValidPosition(r - 1, c + 1) && this.getValue(r - 1, c + 1) == num2) {
					int x = 1;
					while (this.getValue(r - x, c + x) == num2) {
						x++;
					}
					if (this.getValue(r - x, c + x) == 0) {
						this.setValue(r - x, c + x, 3);
					}
				}
				
				//Down - Left
				if (this.getValue(r, c) == num1 && this.isValidPosition(r + 1, c - 1) && this.getValue(r + 1, c - 1) == num2) {
					int x = 1;
					while (this.getValue(r + x, c - x) == num2) {
						x++;
					}
					if (this.getValue(r + x, c - x) == 0) {
						this.setValue(r + x, c - x, 3);
					}
				}
				
				//Down - Right
				if (this.getValue(r, c) == num1 && this.isValidPosition(r + 1, c + 1) && this.getValue(r + 1, c + 1) == num2) {
					int x = 1;
					while (this.getValue(r + x, c + x) == num2) {
						x++;
					}
					if (this.getValue(r + x, c + x) == 0) {
						this.setValue(r + x, c + x, 3);
					}
				}
				
			} //end second for loop
		} //end first for loop
	} //end possiblemoves2
	
	public void possibleMoves2(PlayerV4 p) {
		//get Player color
		int num1 = p.getNumberValue();
		int num2;
		if(num1 == 1) {
			num2 = 2;
		}
		else {
			num2 = 1;
		}
		
		boolean pMoves = false;
		int column = 0;
		int row = 0;
		
		//Checks all directions
		for(int r = 0; r < 8; r++) {
			for(int c = 0; c < 8; c++) {
				//Up
				if (this.getValue(r, c) == num1 && this.isValidPosition(r - 1, c) && this.getValue(r - 1, c) == num2) {
					int x = 1;
					while (this.getValue(r - x, c) == num2) {
						x++;
					}
					if (this.getValue(r - x, c) == 0) {
						this.setValue(r - x, c, 3);
					}
				}
				
				//Down
				if (this.getValue(r, c) == num1 && this.isValidPosition(r + 1, c) && this.getValue(r + 1, c) == num2) {
					int x = 1;
					while (this.getValue(r + x, c) == num2) {
						x++;
					}
					if (this.getValue(r + x, c) == 0) {
						this.setValue(r + x, c, 3);
					}
				}
				
				//Left
				if (this.getValue(r, c) == num1 && this.isValidPosition(r, c - 1) && this.getValue(r, c - 1) == num2) {
					int x = 1;
					while (this.getValue(r, c - x) == num2) {
						x++;
					}
					if (this.getValue(r, c - x) == 0) {
						this.setValue(r, c - x, 3);
					}
				}
				
				//Right
				if (this.getValue(r, c) == num1 && this.isValidPosition(r, c + 1) && this.getValue(r, c + 1) == num2) {
					int x = 1;
					while (this.getValue(r, c + x) == num2) {
						x++;
					}
					if (this.getValue(r, c + x) == 0) {
						this.setValue(r, c + x, 3);
					}
				}
				
				//Up - Left
				if (this.getValue(r, c) == num1 && this.isValidPosition(r - 1, c - 1) && this.getValue(r - 1, c - 1) == num2) {
					int x = 1;
					while (this.getValue(r - x, c - x) == num2) {
						x++;
					}
					if (this.getValue(r - x, c - x) == 0) {
						this.setValue(r - x, c - x, 3);
					}
				}
				
				//Up - Right
				if (this.getValue(r, c) == num1 && this.isValidPosition(r - 1, c + 1) && this.getValue(r - 1, c + 1) == num2) {
					int x = 1;
					while (this.getValue(r - x, c + x) == num2) {
						x++;
					}
					if (this.getValue(r - x, c + x) == 0) {
						this.setValue(r - x, c + x, 3);
					}
				}
				
				//Down - Left
				if (this.getValue(r, c) == num1 && this.isValidPosition(r + 1, c - 1) && this.getValue(r + 1, c - 1) == num2) {
					int x = 1;
					while (this.getValue(r + x, c - x) == num2) {
						x++;
					}
					if (this.getValue(r + x, c - x) == 0) {
						this.setValue(r + x, c - x, 3);
					}
				}
				
				//Down - Right
				if (this.getValue(r, c) == num1 && this.isValidPosition(r + 1, c + 1) && this.getValue(r + 1, c + 1) == num2) {
					int x = 1;
					while (this.getValue(r + x, c + x) == num2) {
						x++;
					}
					if (this.getValue(r + x, c + x) == 0) {
						this.setValue(r + x, c + x, 3);
					}
				}
				
			} //end second for loop
		} //end first for loop
	} //end possiblemoves2

	//**************************************************************************************************//
	/*                                         CAPTURE PIECE                                            */
	//**************************************************************************************************//
	public void CapturePiece2(int r, int c) {
		int num1 = this.playerTurn().getNumberValue();
		int num2;
		if(num1 == 1) {
			num2 = 2;
		}
		else {
			num2 = 1;
		}
		
		boolean pMoves = false;
		int column = c;
		int row = r;
		
		if (this.getValue(r, c) == 3) {
			//Up from 3
			if (this.isValidPosition(r - 1, c) && this.getValue(r - 1, c) == num2) {
				int x = 1;
				while (this.getValue(r - x,  c) == num2) {
					x++;
				}
				if (this.getValue(r - x,  c) == num1) {
					x = 1;
					while (this.getValue(r - x, c) == num2) {
						this.setValue(r - x,  c, num1);
						x++;
					}
				}
			}
			
			//Down from 3
			if (this.isValidPosition(r + 1, c) && this.getValue(r + 1, c) == num2) {
				int x = 1;
				while (this.getValue(r + x,  c) == num2) {
					x++;
				}
				if (this.getValue(r + x,  c) == num1) {
					x = 1;
					while (this.getValue(r + x, c) == num2) {
						this.setValue(r + x,  c, num1);
						x++;
					}
				}
			}
			
			//Left from 3
			if (this.isValidPosition(r, c - 1) && this.getValue(r, c - 1) == num2) {
				int x = 1;
				while (this.getValue(r,  c - x) == num2) {
					x++;
				}
				if (this.getValue(r,  c - x) == num1) {
					x = 1;
					while (this.getValue(r, c - x) == num2) {
						this.setValue(r,  c - x, num1);
						x++;
					}
				}
			}
			
			//Right from 3
			if (this.isValidPosition(r, c + 1) && this.getValue(r, c + 1) == num2) {
				int x = 1;
				while (this.getValue(r,  c + x) == num2) {
					x++;
				}
				if (this.getValue(r,  c + x) == num1) {
					x = 1;
					while (this.getValue(r, c + x) == num2) {
						this.setValue(r,  c + x, num1);
						x++;
					}
				}
			}
			
			//Up-Left from 3
			if (this.isValidPosition(r - 1, c - 1) && this.getValue(r - 1, c - 1) == num2) {
				int x = 1;
				while (this.getValue(r - x,  c - x) == num2) {
					x++;
				}
				if (this.getValue(r - x,  c - x) == num1) {
					x = 1;
					while (this.getValue(r - x, c - x) == num2) {
						this.setValue(r - x,  c - x, num1);
						x++;
					}
				}
			}
			
			//Up-Right from 3
			if (this.isValidPosition(r - 1, c + 1) && this.getValue(r - 1, c + 1) == num2) {
				int x = 1;
				while (this.getValue(r - x,  c + x) == num2) {
					x++;
				}
				if (this.getValue(r - x,  c + x) == num1) {
					x = 1;
					while (this.getValue(r - x, c + x) == num2) {
						this.setValue(r - x,  c + x, num1);
						x++;
					}
				}
			}
			
			//Down-Left from 3
			if (this.isValidPosition(r + 1, c - 1) && this.getValue(r + 1, c - 1) == num2) {
				int x = 1;
				while (this.getValue(r + x,  c - x) == num2) {
					x++;
				}
				if (this.getValue(r + x,  c - x) == num1) {
					x = 1;
					while (this.getValue(r + x, c - x) == num2) {
						this.setValue(r + x,  c - x, num1);
						x++;
					}
				}
			}
			
			//Down-Right from 3
			if (this.isValidPosition(r + 1, c + 1) && this.getValue(r + 1, c + 1) == num2) {
				int x = 1;
				while (this.getValue(r + x,  c + x) == num2) {
					x++;
				}
				if (this.getValue(r + x,  c + x) == num1) {
					x = 1;
					while (this.getValue(r + x, c + x) == num2) {
						this.setValue(r + x,  c + x, num1);
						x++;
					}
				}
			}
			
			//changes the value to whatever num1 is
			if (this.getValue(r, c) == 3) {
				this.setValue(r, c, num1);
			}
		} //Beginning if that starts capturing
	}
	
	public void CapturePiece2(PlayerV4 p, int r, int c) {
		int num1 = p.getNumberValue();
		int num2;
		if(num1 == 1) {
			num2 = 2;
		}
		else {
			num2 = 1;
		}
		
		boolean pMoves = false;
		int column = c;
		int row = r;
		
		if (this.getValue(r, c) == 3) {
			//Up from 3
			if (this.isValidPosition(r - 1, c) && this.getValue(r - 1, c) == num2) {
				int x = 1;
				while (this.getValue(r - x,  c) == num2) {
					x++;
				}
				if (this.getValue(r - x,  c) == num1) {
					x = 1;
					while (this.getValue(r - x, c) == num2) {
						this.setValue(r - x,  c, num1);
						x++;
					}
				}
			}
			
			//Down from 3
			if (this.isValidPosition(r + 1, c) && this.getValue(r + 1, c) == num2) {
				int x = 1;
				while (this.getValue(r + x,  c) == num2) {
					x++;
				}
				if (this.getValue(r + x,  c) == num1) {
					x = 1;
					while (this.getValue(r + x, c) == num2) {
						this.setValue(r + x,  c, num1);
						x++;
					}
				}
			}
			
			//Left from 3
			if (this.isValidPosition(r, c - 1) && this.getValue(r, c - 1) == num2) {
				int x = 1;
				while (this.getValue(r,  c - x) == num2) {
					x++;
				}
				if (this.getValue(r,  c - x) == num1) {
					x = 1;
					while (this.getValue(r, c - x) == num2) {
						this.setValue(r,  c - x, num1);
						x++;
					}
				}
			}
			
			//Right from 3
			if (this.isValidPosition(r, c + 1) && this.getValue(r, c + 1) == num2) {
				int x = 1;
				while (this.getValue(r,  c + x) == num2) {
					x++;
				}
				if (this.getValue(r,  c + x) == num1) {
					x = 1;
					while (this.getValue(r, c + x) == num2) {
						this.setValue(r,  c + x, num1);
						x++;
					}
				}
			}
			
			//Up-Left from 3
			if (this.isValidPosition(r - 1, c - 1) && this.getValue(r - 1, c - 1) == num2) {
				int x = 1;
				while (this.getValue(r - x,  c - x) == num2) {
					x++;
				}
				if (this.getValue(r - x,  c - x) == num1) {
					x = 1;
					while (this.getValue(r - x, c - x) == num2) {
						this.setValue(r - x,  c - x, num1);
						x++;
					}
				}
			}
			
			//Up-Right from 3
			if (this.isValidPosition(r - 1, c + 1) && this.getValue(r - 1, c + 1) == num2) {
				int x = 1;
				while (this.getValue(r - x,  c + x) == num2) {
					x++;
				}
				if (this.getValue(r - x,  c + x) == num1) {
					x = 1;
					while (this.getValue(r - x, c + x) == num2) {
						this.setValue(r - x,  c + x, num1);
						x++;
					}
				}
			}
			
			//Down-Left from 3
			if (this.isValidPosition(r + 1, c - 1) && this.getValue(r + 1, c - 1) == num2) {
				int x = 1;
				while (this.getValue(r + x,  c - x) == num2) {
					x++;
				}
				if (this.getValue(r + x,  c - x) == num1) {
					x = 1;
					while (this.getValue(r + x, c - x) == num2) {
						this.setValue(r + x,  c - x, num1);
						x++;
					}
				}
			}
			
			//Down-Right from 3
			if (this.isValidPosition(r + 1, c + 1) && this.getValue(r + 1, c + 1) == num2) {
				int x = 1;
				while (this.getValue(r + x,  c + x) == num2) {
					x++;
				}
				if (this.getValue(r + x,  c + x) == num1) {
					x = 1;
					while (this.getValue(r + x, c + x) == num2) {
						this.setValue(r + x,  c + x, num1);
						x++;
					}
				}
			}
			
			//changes the value to whatever num1 is
			if (this.getValue(r, c) == 3) {
				this.setValue(r, c, num1);
			}
		} //Beginning if that starts capturing
	}
}