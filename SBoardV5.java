package GG;

public class SBoardV3 {
		private String gameNum;						//The name of the game, ex: Game1
		public int[][] dB;							//The matrix that hold the values that determines the logic behind a game
		public boolean pMove;						//Keeps track if a player has a possible move during a turn.
		public boolean p1Turn = true;				//Attempt to keep track of turns NEEDS A SOLUTION
		private PlayerV3 player1 = new PlayerV3();	//An instance of player
		private PlayerV3 player2 = new PlayerV3();	//An instance of player
		
		//Constructor for current version of board
		public SBoardV3() {
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
		/*                                         THREEs RESET                     	                    */
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
			
			//BLACK PLAYER
			if(num1 == 1) {
				for(int i = 0; i < 8; i++) {
					for(int j = 0; j < 8; j++) {	
						switch(this.getValue(i,j)) {
							case 0:
								break;
									 
							case 1:
								// Checks move down V2
								if ((this.getValue(i,j) == num1) && (this.getValue(i+1, j) == num2) ){
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
								if ((this.getValue(i,j) == num1 ) && (this.getValue(i-1, j) == num2) && i >= 2 ){ //Checks move up
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
			}
						
			//WHITE PLAYER
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
								if((this.getValue(i, j) == num1) && (this.getValue(i+1, j) == num2) ){
									int n = 1;
									while(this.getValue(i+n, j) != num1) {
										if(this.getValue(i+n, j) == num2) {
											n++;
										}
										else if(this.getValue(i+n, j) == 0){
											this.setValue(i+n, j, 3);
											pMove = true;
											break;
										}
									}
								}
								
								//Checks move up
								if((this.getValue(i, j) == num1 ) && (this.getValue(i-1, j) == num2) && i >= 0 ){ //Checks move up
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
			
	        //BLACK PLAYER
	        if (num1 == 1) {
	        	
	                	switch(this.getValue(r, c)) {
					 		case 0:
					 			break;
							case 1:
					 			break;
					 		case 2:
					 			break;
					 			
					 		case 3:
					 			//Captures UP from 3
					 			if(this.getValue(r, c)==3 && this.getValue(r-1, c)==num2) {
					 				int x = 1;
					 				while(this.getValue(r-x, c)==num2) {
					 					if(this.getValue(r-x, c) == num2) {
					 						this.setValue(r-x, c, num1);
					 						this.setValue(r, c, num1);
					 						x++;
					 					}
					 					else if(this.getValue(r-x, c)==num1) {
					 						break;
					 					}
					 				}
					 			}
					 			
					 			//Captures DOWN from 3
					 			if(this.getValue(r, c)==3 && this.getValue(r+1, c)==num2) {
					 				int x = 1;
					 				while(this.getValue(r+x, c)==num2) {
					 					if(this.getValue(r+x, c) == num2) {
					 						this.setValue(r+x, c, num1);
					 						this.setValue(r, c, num1);
					 						x++;
					 					}
					 					else if(this.getValue(r+x, c)==num1) {
					 						break;
					 					}
					 				}
					 			}
					 			
					 			//Captures LEFT from 3
					 			if(this.getValue(r,c)==3 && this.getValue(r, c-1)==num2) {
					 				int x = 1;
					 				while(this.getValue(r, c-x)==num2) {
					 					if(this.getValue(r, c-x) == num2) {
					 						this.setValue(r, c-x, num1);
					 						this.setValue(r, c, num1);
					 						x++;
					 					}
					 					else if(this.getValue(r, c-x)==num1) {
					 						break;
					 					}
					 				}
					 			}
					 			
					 			//Captures RIGHT from 3
					 			if(this.getValue(r, c)==3 && this.getValue(r, c+1)==num2) {
					 				int x = 1;
					 				while(this.getValue(r, c+x)==num2) {
					 					if(this.getValue(r, c+x) == num2) {
					 						this.setValue(r, c+x, num1);
					 						this.setValue(r, c, num1);
					 						x++;
					 					}
					 					else if(this.getValue(r, c+x)==num1) {
					 						break;
					 					}
					 				}
					 			}
					 			
					 			//Captures UP-LEFT from 3
					 			if(this.getValue(r, c)==3 && this.getValue(r-1, c-1)==num2) {
					 				int x = 1;
					 				while(this.getValue(r-x, c-x)==num2) {
					 					if(this.getValue(r-x, c-x) == num2) {
					 						this.setValue(r-x, c-x, num1);
					 						this.setValue(r, c, num1);
					 						x++;
					 					}
					 					else if(this.getValue(r-x, c-x)==num1) {
					 						break;
					 					}
					 				}
					 			}
					 			
					 			//Captures DOWN-RIGHT from 3
					 			if(this.getValue(r, c)==3 && this.getValue(r+1, c+1)==num2) {
					 				int x = 1;
					 				while(this.getValue(r+x, c+x)==num2) {
					 					if(this.getValue(r+x, c+x) == num2) {
					 						this.setValue(r+x, c+x, num1);
					 						this.setValue(r, c, num1);
					 						x++;
					 					}
					 					else if(this.getValue(r+x, c+x)==num1) {
					 						break;
					 					}
					 				}
					 			}
					 			
					 			//Captures UP-RIGHT from 3
					 			if(this.getValue(r, c)==3 && this.getValue(r-1, c+1)==num2) {
					 				int x = 1;
					 				while(this.getValue(r-x, c+x)==num2) {
					 					if(this.getValue(r-x, c+x) == num2) {
					 						this.setValue(r-x, c+x, num1);
					 						this.setValue(r, c, num1);
					 						x++;
					 					}
					 					else if(this.getValue(r-x, c+x)==num1) {
					 						break;
					 					}
					 				}
					 			}
					 			//Captures DOWN-LEFT from 3
					 			if(this.getValue(r, c)==3 && this.getValue(r+1, c-1)==num2) {
					 				int x = 1;
					 				while(this.getValue(r+x, c-x)==num2) {
					 					if(this.getValue(r+x, c-x) == num2) {
					 						this.setValue(r+x, c-x, num1);
					 						this.setValue(r, c, num1);
					 						x++;
					 					}
					 					else if(this.getValue(r+x, c-x)==num1) {
					 						break;
					 					}
					 				}
	                			}
					 			if (this.getValue(r, c) == 3) {
				 					this.setValue(r, c, num1);
				 				}
				 				break;
	                	}
	                }
	        	
	        
	        
	        //WHITE PLAYER
	        if (num1 == 2) {
	           
	                	switch(this.getValue(r, c)) {
					 		case 0:
					 			break;
							case 1:
					 			break;
					 		case 2:
					 			break;
					 			
					 		case 3:
					 			//Captures UP from 3
					 			if(this.getValue(r, c)==3 && this.getValue(r-1, c)==num2) {
					 				int x = 1;
					 				while(this.getValue(r-x, c)==num2) {
					 					if(this.getValue(r-x, c) == num2) {
					 						this.setValue(r-x, c, num1);
					 						this.setValue(r, c, num1);
					 						x++;
					 					}
					 					else if(this.getValue(r-x, c)==num1) {
					 						break;
					 					}
					 				}
					 			}
					 			
					 			//Captures DOWN from 3
					 			if(this.getValue(r, c)==3 && this.getValue(r+1, c)==num2) {
					 				int x = 1;
					 				while(this.getValue(r+x, c)==num2) {
					 					if(this.getValue(r+x, c) == num2) {
					 						this.setValue(r+x, c, num1);
					 						this.setValue(r, c, num1);
					 						x++;
					 					}
					 					else if(this.getValue(r+x, c)==num1) {
					 						break;
					 					}
					 				}
					 			}
					 			
					 			//Captures LEFT from 3
					 			if(this.getValue(r, c)==3 && this.getValue(r, c-1)==num2) {
					 				int x = 1;
					 				while(this.getValue(r, c-x)==num2) {
					 					if(this.getValue(r, c-x) == num2) {
					 						this.setValue(r, c-x, num1);
					 						this.setValue(r, c, num1);
					 						x++;
					 					}
					 					else if(this.getValue(r, c-x)==num1) {
					 						break;
					 					}
					 				}
					 			}
					 			
					 			//Captures RIGHT from 3
					 			if(this.getValue(r, c)==3 && this.getValue(r, c+1)==num2) {
					 				int x = 1;
					 				while(this.getValue(r, c+x)==num2) {
					 					if(this.getValue(r, c+x) == num2) {
					 						this.setValue(r, c+x, num1);
					 						this.setValue(r, c, num1);
					 						x++;
					 					}
					 					else if(this.getValue(r, c+x)==num1) {
					 						break;
					 					}
					 				}
					 			}
					 			
					 			//Captures UP-LEFT from 3
					 			if(this.getValue(r, c)==3 && this.getValue(r-1, c-1)==num2) {
					 				int x = 1;
					 				while(this.getValue(r-x, c-x)==num2) {
					 					if(this.getValue(r-x, c-x) == num2) {
					 						this.setValue(r-x, c-x, num1);
					 						this.setValue(r, c, num1);
					 						x++;
					 					}
					 					else if(this.getValue(r-x, c-x)==num1) {
					 						break;
					 					}
					 				}
					 			}
					 			
					 			//Captures DOWN-RIGHT from 3
					 			if(this.getValue(r, c)==3 && this.getValue(r+1, c+1)==num2) {
					 				int x = 1;
					 				while(this.getValue(r+x, c+x)==num2) {
					 					if(this.getValue(r+x, c+x) == num2) {
					 						this.setValue(r+x, c+x, num1);
					 						this.setValue(r, c, num1);
					 						x++;
					 					}
					 					else if(this.getValue(r+x, c+x)==num1) {
					 						break;
					 					}
					 				}
					 			}
					 			
					 			//Captures UP-RIGHT from 3
					 			if(this.getValue(r, c)==3 && this.getValue(r-1, c+1)==num2) {
					 				int x = 1;
					 				while(this.getValue(r-x, c+x)==num2) {
					 					if(this.getValue(r-x, c+x) == num2) {
					 						this.setValue(r-x, c+x, num1);
					 						this.setValue(r, c, num1);
					 						x++;
					 					}
					 					else if(this.getValue(r-x, c+x)==num1) {
					 						break;
					 					}
					 				}
					 			}
					 			
					 			//Captures DOWN-LEFT from 3
					 			if(this.getValue(r, c)==3 && this.getValue(r+1, c-1)==num2) {
					 				
					 				int x = 1;
					 				while(this.getValue(r+x, c-x)==num2) {
					 					if(this.getValue(r+x, c-x) == num2) {
					 						this.setValue(r+x, c-x, num1);
					 						this.setValue(r, c, num1);
					 						x++;
					 					}
					 					else if(this.getValue(r+x, c-x)==num1) {
					 						break;
					 					}
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
