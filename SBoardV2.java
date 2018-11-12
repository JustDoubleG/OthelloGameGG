//********************************************************************************************//
//********************************************************************************************//
//**This is a version of Board that allows methods to be used on Board.
//**LIST OF VARIABLES: gameNum, dB, pMove, p1Turn, player1, player2
//**LIST OF METHODS(DESCRIPTIONS NEXT TO METHODS IN CODE)

//********************************************************************************************//
//********************************************************************************************//
public class SBoardV2 {
	private String gameNum;						//The name of the game, ex: Game1
	public int[][] dB;							//The matrix that hold the values that determines the logic behind a game
	public static boolean pMove;					//Keeps track if a player has a possible move during a turn.
	public boolean p1Turn = true;				//Attempt to keep track of turns NEEDS A SOLUTION
	private Player player1 = new Player();		//An instance of player
	private Player player2 = new Player();		//An instance of player
	
	public SBoardV2() {//Constructor for current version of board
		//Declare the variables used in an instance of the game
		gameNum = "one";
		pMove = false;
		p1Turn = true;
		player1 = new Player();
		player2 = new Player();
		player1.setColorValue(1);
		player2.setColorValue(2);
		dB= new int[][] {
			{0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 1, 2, 0, 0, 0 },
			{0, 0, 0, 2, 1, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0 },
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
		if(this.p1Turn == true) {
		this.p1Turn = false;
		}
		else {
			this.p1Turn = true;
		}
	}
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
	public Player playerTurn() {
		if(this.p1Turn == true) {
			return player1;
		}
		else {
			return player2;
		}
	}
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
	//**************************************************************************************************//
	public void possibleMoves2() {
		//get Player color 
		int num1 = this.playerTurn().getColor();
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
		//BLACK PLAYER
				if(num1 == 1) {
					for(int i = 0; i < 8; i++) {
						for(int j = 0; j < 8; j++) {	
						 switch(this.getValue(i,j)) {
						 	case 0:
								 break;
							case 1:
								// Checks move down V2
								if( (this.getValue(i,j) == num1) && (this.getValue(i+1, j) == num2) ){
											int n = 1;
											while(this.getValue(i+n,j) != num1) {
												if(this.getValue(i+n, j) == num2) {
													n++;
												}
												else if(this.getValue(i+n, j) == 0){
													this.setValue(i+n,j,3);
													pMove = true;
													break;
												}
											}
								}
								//Checks move up
								if( (this.getValue(i,j) == num1 ) && (this.getValue(i-1, j) == num2) && i >= 2 ){ //Checks move up
										int n = 1;
											while(this.getValue(i-n, j) != num1 && n <= i) {
												if(this.getValue(i-n, j) == num2) {
													n++;
												}
												else if(this.getValue(i-n, j) == 0){
													this.setValue(i-n, j, 3);
													pMove = true;
													break;
												}
											}		
								}
								//Checks moves right
								if ((this.getValue(i, j) == num1) && (this.getValue(i, j+1) == num2)){
									int n = 1;
									while(this.getValue(i, j+n) != num1) {
										if(this.getValue(i, j+n) == num2) {
											n++;
										}
										else if(this.getValue(i, j+n) == 0){
											this.setValue(i, j+n, 3);;
											pMove = true;
											break;
											}
									}
								}
								//Checks move left
								if((this.getValue(i, j) == num1) && (this.getValue(i, j-1) == num2)) {
									int n = 1;
									while(this.getValue(i, j-n) != num1) {
										if(this.getValue(i, j-n) == num2) {
											n++;
										}
										else if(this.getValue(i, j-n) == 0){
											this.setValue(i, j-n, 3);
											pMove = true;
											break;
										}
									}
								}
								//checks down-right diagonal
								if(this.getValue(i, j) == num1 && this.getValue(i+1, j+1)==num2) {
						 			int n=1;
						 			while(this.getValue(i+n, j+n)!=num1) {
						 				if (this.getValue(i+n, j+n)==num2){
						 					n++;
						 				}
						 				else if(this.getValue(i+n, j+n)==0) {
						 					this.setValue(i+n, j+n, 3);
						 					pMove = true;
						 					break;
						 				}
						 			}
								}
								 //checks down-left diagonal
								if(this.getValue(i+1, j-1)==num2 && this.getValue(i, j)==num1) {
						 			int n=1;
						 			while(this.getValue(i+n, j-n)!=num1) {
						 				if (this.getValue(i+n, j-n)==num2){
						 					n++;
						 				}
						 				else if(this.getValue(i+n, j-n)==0) {
						 					this.setValue(i+n, j-n, 3);;
						 					pMove = true;
						 					break;
						 				}
						 			
						 			}
						 		}
								//checks up-right diagonal
								if(this.getValue(i-1, j+1)==num2 && this.getValue(i, j)==num1) {
						 			int n=1;
						 			while(this.getValue(i-n, j+n)!=num1) {
						 				if (this.getValue(i-n, j+n)==num2){
						 					n++;
						 				}
						 				else if(this.getValue(i-n, j+n)==0) {
						 					this.setValue(i-n, j+n, 3);
						 					pMove = true;
						 					break;
						 				}
						 			}
								}
								//checks up-left diagonal
								if(this.getValue(i-1, j-1)==num2 && this.getValue(i, j)==num1) {
						 			int n=1;
						 			while(this.getValue(i-n, j-n)!=num1) {
						 				if (this.getValue(i-n, j-n)==num2){
						 					n++;
						 				}
						 				else if(this.getValue(i-n, j-n)==0) {
						 					this.setValue(i-n, j-n, 3);;
						 					pMove = true;
						 					break;
						 				}
						 			}
						 		}
								break;
							case 2: 
								break;
						 }
						}
					}	 
					if(num1 == 2) {
						for(int i = 0; i < 8; i++) {
							for(int j = 0; j < 8; j++) {
									 switch(this.getValue(i, j)) {
									 	case 0:
									 		break;
									 	case 1:
									 		break;
									 	case 2: 
											// Checks move down V2
											if( (this.getValue(i, j) == num1) && (this.getValue(i+1, j) == num2) ){
														int n = 1;
														while(this.getValue(i+n, j) != num1) {
															if(this.getValue(i+n, j) == num2) {
																n++;
															}
															else if(this.getValue(i+n, j) == 0){
																this.setValue(i+n, j, 3);;
																pMove = true;
																break;
															}
														}
											}
											//Checks move up
											if( (this.getValue(i, j) == num1 ) && (this.getValue(i-1, j) == num2) && i >= 0 ){ //Checks move up
													int n = 1;
														while(this.getValue(i-n, j) != num1) {
															if(this.getValue(i-n, j) == num2) {
																n++;
															}
															else if(this.getValue(i-n, j) == 0){
																this.setValue(i-n, j, 3);
																pMove = true;
																break;
																}
												}
											}
											//Checks moves right
											if ((this.getValue(i, j) == num1) && (this.getValue(i, j+1) == num2)){
												int n = 1;
												while(this.getValue(i, j+n) != num1) {
													if(this.getValue(i, j+n) == num2) {
														n++;
													}
													else if(this.getValue(i, j+n) == 0){
														this.setValue(i, j+n, 3);
														pMove = true;
														break;
													}
												}
											}
											//Checks move left
											if((this.getValue(i, j) == num1) && (this.getValue(i, j-1) == num2)) {
												int n = 1;
												while(this.getValue(i, j-n) != num1) {
													if(this.getValue(i, j-n) == num2) {
														n++;
													}
													else if(this.getValue(i, j-n) == 0){
														this.setValue(i, j-n, 3);
														pMove = true;
														break;
														}}
											}
											//checks down-right diagonal
											if(this.getValue(i, j) == num1 && this.getValue(i+1, j+1)==num2) {
									 			int n=1;
									 			while(this.getValue(i+n, j+n)!=num1) {
									 				if (this.getValue(i+n, j+n)==num2){
									 					n++;
									 				}
									 				else if(this.getValue(i+n, j+n)==0) {
									 					this.setValue(i+n, j+n, 3);
									 					pMove = true;
									 					break;
									 				}
									 			}	
											}
											 //checks down-left diagonal
											if(this.getValue(i+1, j-1)==num2 && this.getValue(i, j)==num1) {
									 			int n=1;
									 			while(this.getValue(i+n, j-n)!=num1) {
									 				if (this.getValue(i+n, j-n)==num2){
									 					n++;
									 				}
									 				else if(this.getValue(i+n, j-n)==0) {
									 					this.setValue(i+n, j-n, 3);
									 					pMove = true;
									 					break;
									 				}
									 			}
									 		}
											//checks up-right diagonal
											if(this.getValue(i-1, j+1)==num2 && this.getValue(i, j)==num1) {
									 			int n=1;
									 			while(this.getValue(i-n, j+n)!=num1) {
									 				if (this.getValue(i-n, j+n)==num2){
									 					n++;
									 				}
									 				else if(this.getValue(i-n, j+n)==0) {
									 					this.setValue(i-n, j+n, 3);
									 					pMove = true;
									 					break;
									 				}
									 			}
									 		}
											//checks up-left diagonal
											if(this.getValue(i-1, j-1)==num2 && this.getValue(i, j)==num1) {
									 			int n=1;
									 			while(this.getValue(i-n, j-n)!=num1) {
									 				if (this.getValue(i-n, j-n)==num2){
									 					n++;
									 				}
									 				else if(this.getValue(i-n, j-n)==0) {
									 					this.setValue(i-n, j-n, 3);
									 					pMove = true;
									 					break;
									 				}
									 			
									 			}
									 		}
											break;
									 }
								}
							}
						}
				}
			}
	//**************************************************************************************************//
	public void CapturePiece2(int r, int c) {
		int num1 = this.playerTurn().getColor();
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
        //BLACK PLAYER
        if (num1 == 1) {
            for(int i = r; i < 8; i++) {
                for(int j = c; j < 8; j++) {
                	switch(this.getValue(i, j)) {
				 		case 0:
				 			break;
						case 1:
				 			break;
				 		case 2:
				 			break;
				 		case 3:
				 			//Captures UP from 3
				 			if(this.getValue(i, j)==3 && this.getValue(i-1, j)==num2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(this.getValue(i-x, j)==num2) {
				 					if(this.getValue(i-x, j) == num2) {
				 						this.setValue(i-x, j, num1);
				 						this.setValue(r, c, num1);
				 						x++;
				 					}
				 					else if(this.getValue(i-x, j)==num1) {
				 						break;
				 					}
				 				}
				 			}
				 			//Captures DOWN from 3
				 			if(this.getValue(i, j)==3 && this.getValue(i+1, j)==num2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(this.getValue(i+x, j)==num2) {
				 					if(this.getValue(i+x, j) == num2) {
				 						this.setValue(i+x, j, num1);
				 						this.setValue(r, c, num1);
				 						x++;
				 					}
				 					else if(this.getValue(i+x, j)==num1) {
				 						break;
				 					}
				 				}
				 			}
				 			//Captures LEFT from 3
				 			if(this.getValue(i,j)==3 && this.getValue(i, j-1)==num2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(this.getValue(i, j-x)==num2) {
				 					if(this.getValue(i, j-x) == num2) {
				 						this.setValue(i, j-x, num1);
				 						this.setValue(r, c, num1);
				 						x++;
				 					}
				 					else if(this.getValue(i, j-x)==num1) {
				 						break;
				 					}
				 				}
				 			}
				 			//Captures RIGHT from 3
				 			if(this.getValue(i, j)==3 && this.getValue(i, j+1)==num2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(this.getValue(i, j+x)==num2) {
				 					if(this.getValue(i, j+x) == num2) {
				 						this.setValue(i, j+x, num1);
				 						this.setValue(r, c, num1);
				 						x++;
				 					}
				 					else if(this.getValue(i, j+x)==num1) {
				 						break;
				 					}
				 				}
				 			}
				 			//Captures UP-LEFT from 3
				 			if(this.getValue(i, j)==3 && this.getValue(i-1, j-1)==num2) {
				 				//This part was NOT commented out, not sure if intentional or not.  
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(this.getValue(i-x, j-x)==num2) {
				 					if(this.getValue(i-x, j-x) == num2) {
				 						this.setValue(i-x, j-x, num1);
				 						this.setValue(r, c, num1);
				 						x++;
				 					}
				 					else if(this.getValue(i-x, j-x)==num1) {
				 						break;
				 					}
				 				}
				 			}
				 			//Captures DOWN-RIGHT from 3
				 			if(this.getValue(i, j)==3 && this.getValue(i+1, j+1)==num2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(this.getValue(i+x, j+x)==num2) {
				 					if(this.getValue(i+x, j+x) == num2) {
				 						this.setValue(i+x, j+x, num1);
				 						this.setValue(r, c, num1);
				 						x++;
				 					}
				 					else if(this.getValue(i+x, j+x)==num1) {
				 						break;
				 					}
				 				}
				 			}
				 			//Captures UP-RIGHT from 3
				 			if(this.getValue(i, j)==3 && this.getValue(i-1, j+1)==num2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(this.getValue(i-x, j+x)==num2) {
				 					if(this.getValue(i-x, j+x) == num2) {
				 						this.setValue(i-x, j+x, num1);
				 						this.setValue(r, c, num1);
				 						x++;
				 					}
				 					else if(this.getValue(i-x, j+x)==num1) {
				 						break;
				 					}
				 				}
				 			}
				 			//Captures DOWN-LEFT from 3
				 			if(this.getValue(i, j)==3 && this.getValue(i+1, j-1)==num2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(this.getValue(i+x, j-x)==num2) {
				 					if(this.getValue(i+x, j-x) == num2) {
				 						this.setValue(i+x, j-x, num1);
				 						this.setValue(r, c, num1);
				 						x++;
				 					}
				 					else if(this.getValue(i+x, j-x)==num1) {
				 						break;
				 					}
				 				}
				 			if (this.getValue(r, c) == 3) {
					 			this.setValue(r, c, num1);
				 			}
				 			break;
                			}
                }
            }
        }
        //WHITE PLAYER
        if (num1 == 2) {
            for(int i = r; i < 8; i++) {
                for(int j = c; j < 8; j++) {
                	switch(this.getValue(i, j)) {
				 		case 0:
				 			break;
						case 1:
				 			break;
				 		case 2:
				 			break;
				 		case 3:
				 			//Captures UP from 3
				 			if(this.getValue(i, j)==3 && this.getValue(i-1, j)==num2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(this.getValue(i-x, j)==num2) {
				 					if(this.getValue(i-x, j) == num2) {
				 						this.setValue(i-x, j, num1);
				 						this.setValue(r, c, num1);
				 						x++;
				 					}
				 					else if(this.getValue(i-x, j)==num1) {
				 						break;
				 					}
				 				}
				 			}
				 			//Captures DOWN from 3
				 			if(this.getValue(i, j)==3 && this.getValue(i+1, j)==num2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(this.getValue(i+x, j)==num2) {
				 					if(this.getValue(i+x, j) == num2) {
				 						this.setValue(i+x, j, num1);
				 						this.setValue(r, c, num1);
				 						x++;
				 					}
				 					else if(this.getValue(i+x, j)==num1) {
				 						break;
				 					}
				 				}
				 			}
				 			//Captures LEFT from 3
				 			if(this.getValue(i, j)==3 && this.getValue(i, j-1)==num2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(this.getValue(i, j-x)==num2) {
				 					if(this.getValue(i, j-x) == num2) {
				 						this.setValue(i, j-x, num1);
				 						this.setValue(r, c, num1);
				 						x++;
				 					}
				 					else if(this.getValue(i, j-x)==num1) {
				 						break;
				 					}
				 				}
				 			}
				 			//Captures RIGHT from 3
				 			if(this.getValue(i, j)==3 && this.getValue(i, j+1)==num2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(this.getValue(i, j+x)==num2) {
				 					if(this.getValue(i, j+x) == num2) {
				 						this.setValue(i, j+x, num1);
				 						this.setValue(r, c, num1);
				 						x++;
				 					}
				 					else if(this.getValue(i, j+x)==num1) {
				 						break;
				 					}
				 				}
				 			}
				 			//Captures UP-LEFT from 3
				 			if(this.getValue(i, j)==3 && this.getValue(i-1, j-1)==num2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(this.getValue(i-x, j-x)==num2) {
				 					if(this.getValue(i-x, j-x) == num2) {
				 						this.setValue(i-x, j-x, num1);
				 						this.setValue(r, c, num1);
				 						x++;
				 					}
				 					else if(this.getValue(i-x, j-x)==num1) {
				 						break;
				 					}
				 				}
				 			}
				 		 //Captures DOWN-RIGHT from 3
				 			if(this.getValue(i, j)==3 && this.getValue(i+1, j+1)==num2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(this.getValue(i+x, j+x)==num2) {
				 					if(this.getValue(i+x, j+x) == num2) {
				 						this.setValue(i+x, j+x, num1);
				 						this.setValue(r, c, num1);
				 						x++;
				 					}
				 					else if(this.getValue(i+x, j+x)==num1) {
				 						break;
				 					}
				 				}
				 			}
				 			//Captures UP-RIGHT from 3
				 			if(this.getValue(i, j)==3 && this.getValue(i-1, j+1)==num2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(this.getValue(i-x, j+x)==num2) {
				 					if(this.getValue(i-x, j+x) == num2) {
				 						this.setValue(i-x, j+x, num1);
				 						this.setValue(r, c, num1);
				 						x++;
				 					}
				 					else if(this.getValue(i-x, j+x)==num1) {
				 						break;
				 					}
				 				}
				 			}
				 			//Captures DOWN-LEFT from 3
				 			if(this.getValue(i, j)==3 && this.getValue(i+1, j-1)==num2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(this.getValue(i+x, j-x)==num2) {
				 					if(this.getValue(i+x, j-x) == num2) {
				 						this.setValue(i+x, j-x, num1);
				 						this.setValue(r, c, num1);
				 						x++;
				 					}
				 					else if(this.getValue(i+x, j-x)==num1) {
				 						break;
				 					}
				 				}
				 			}
				 			if (this.getValue(r, c) == 3) {
				 				this.setValue(r, c, num1);
				 			}
				 			}
				 			break;
                	}
                }
            }
        }
            }
	//**************************************************************************************************//
	
	//**************************************************************************************************//
		
}	

	
//deleted a }