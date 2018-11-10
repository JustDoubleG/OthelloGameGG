package project;

public class Board {
	public static void main(String[] args) {
		//Board (NUMBERS INPUTTED ARE FOR TEST ALL CASES for WHITE)
		int[][] board = new int[][] {
			{0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 2, 0, 0, 0, 0 },
			{0, 0, 0, 1, 0, 0, 0, 0 },
			{0, 0, 0, 1, 0, 0, 0, 0 },
			{0, 0, 0, 1, 0, 0, 0, 0 },
			{0, 0, 0, 3, 1, 1, 2, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0 },
		};
		
		//test player 1 and 2 TEMPORARY PLAYERS
		Player black1 = new Player("black");
		Player white2 = new Player("white");
	
		black1.setColor(1);
		white2.setColor(2);
		//possibleMoves(board, white2);
		CapturePiece(board, white2);
		//end
	}
	
	
	//THIS WAS FOR SEAN
	public Board() {
		//Board (NUMBERS INPUTTED ARE FOR TEST ALL CASES for BLACK)
		int[][] logicMatrix = new int[][] {
			{0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 2, 2, 0, 2, 2, 1, 0 },
			{0, 0, 1, 0, 0, 0, 1, 0 },
			{0, 0, 1, 2, 2, 2, 0, 0 },
			{0, 0, 1, 2, 2, 0, 0, 0 },
			{0, 0, 1, 0, 0, 0, 0, 0 },
			{0, 0, 2, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0 },
		};
	}
	//END FOR SEAN
	
	//This checks all directions for valid moves for each player White or Black
	public static void possibleMoves(int[][] b, Player p) {
		//get Player color 
		int color = p.getColor();
		int color1;
		if(color == 1)
			 color1 = 2;
		else 
			 color1 = 1;		
		
		int column = 0;
		int row = 0;
		
		//Possible Move Counter
		//int possibleMovesCounter = 0;
		//boolean possibleMovesBool = false;
			
			
		//BLACK PLAYER
		if(color == 1) {
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {	
					switch(b[i][j]) {
				 	case 0:
						 break;
						 
					case 1:
						// Checks move down
						if( (b[i][j] == color) && (b[i + 1][j] == color1) ){
									int n = 1;
									while(b[i+n][j] != color) {
										if(b[i+n][j] == color1) {
											n++;
										}
										else if(b[i+n][j] == 0){
											b[i+n][j] = 3;
											//possibleMovesCounter++;
											break;
										}
									}
						}
						
						//Checks move up
						if( (b[i][j] == color ) && (b[i-1][j] == color1) && i >= 2 ) {
								int n = 1;
									while(b[i-n][j] != color && n <= i) {
										if(b[i-n][j] == color1) {
											n++;
										}
										else if(b[i-n][j] == 0){
											b[i-n][j] = 3;
											//possibleMovesCounter++;
											break;
										}
								
									}		
						}
						
						//Checks moves right
						if ((b[i][j] == color) && (b[i][j + 1] == color1)){
							int n = 1;
							while(b[i][j+n] != color) {
								if(b[i][j+n] == color1) {
									n++;
								}
								else if(b[i][j+n] == 0){
									b[i][j+n] = 3;
									//possibleMovesCounter++;
									break;
									}
						
						
							}
						}
						
						//Checks move left
						if((b[i][j] == color) && (b[i][j-1] == color1)) {
							int n = 1;
							while(b[i][j-n] != color) {
								if(b[i][j-n] == color1) {
									n++;
								}
								else if(b[i][j-n] == 0){
									b[i][j-n] = 3;
									//possibleMovesCounter++;
									break;
								}
						
							}
						}
						
						//checks down-right diagonal
						if(b[i][j] == color && b[i+1][j+1]==color1) {
				 			int n=1;
				 			while(b[i+n][j+n]!=color) {
				 				if (b[i+n][j+n]==color1){
				 					n++;
				 				}
				 				else if(b[i+n][j+n]==0) {
				 					b[i+n][j+n] = 3;
				 					//possibleMovesCounter++;
				 					break;
				 				}
				 			}
				 			
						}
						
						 //checks down-left diagonal
						if(b[i+1][j-1]==color1 && b[i][j]==color) {
				 			int n=1;
				 			while(b[i+n][j-n]!=color) {
				 				if (b[i+n][j-n]==color1){
				 					n++;
				 				}
				 				else if(b[i+n][j-n]==0) {
				 					b[i+n][j-n] = 3;
				 					//possibleMovesCounter++;
				 					break;
				 				}
				 			}
				 		}
						
						//checks up-right diagonal
						if(b[i-1][j+1]==color1 && b[i][j]==color) {
				 			int n=1;
				 			while(b[i-n][j+n]!=color) {
				 				if (b[i-n][j+n]==color1){
				 					n++;
				 				}
				 				else if(b[i-n][j+n]==0) {
				 					b[i-n][j+n] = 3;
				 					//possibleMovesCounter++;
				 					break;
				 				}
				 			}
				 		}
						
						//checks up-left diagonal
						if(b[i-1][j-1]==color1 && b[i][j]==color) {
				 			int n=1;
				 			while(b[i-n][j-n]!=color) {
				 				if (b[i-n][j-n]==color1){
				 					n++;
				 				}
				 				else if(b[i-n][j-n]==0) {
				 					b[i-n][j-n] = 3;
				 					//possibleMovesCounter++;
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
		if(color == 2) {
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
					switch(b[i][j]) {
						case 0:
						 	break;
						 		
						case 1:
						 	break;
						 
						case 2: 
							// Checks move down
							if( (b[i][j] == color) && (b[i + 1][j] == color1) ){
									int n = 1;
									while(b[i+n][j] != color) {
										if(b[i+n][j] == color1) {
											n++;
										}
										else if(b[i+n][j] == 0){
											b[i+n][j] = 3;
											//possibleMovesCounter++;
											break;
										}
									}
							}
								
							//Checks move up
							if( (b[i][j] == color ) && (b[i-1][j] == color1) && i >= 0 ){ //Checks move up
									int n = 1;
									while(b[i-n][j] != color) {
										if(b[i-n][j] == color1) {
											n++;
										}
										else if(b[i-n][j] == 0){
											b[i-n][j] = 3;
											//possibleMovesCounter++;
											break;
										}
									}
							}
								
								
							//Checks moves right
							if ((b[i][j] == color) && (b[i][j + 1] == color1)){
								int n = 1;
								while(b[i][j+n] != color) {
									if(b[i][j+n] == color1) {
										n++;
									}
									else if(b[i][j+n] == 0){
										b[i][j+n] = 3;
										//possibleMovesCounter++;
										break;
									}
								}
							}
								
							//Checks move left
							if((b[i][j] == color) && (b[i][j-1] == color1)) {
								int n = 1;
								while(b[i][j-n] != color) {
									if(b[i][j-n] == color1) {
										n++;
									}
									else if(b[i][j-n] == 0){
										b[i][j-n] = 3;
										//possibleMovesCounter++;
										break;
									}
								}
							}
								
							//checks down-right diagonal
							if(b[i][j] == color && b[i+1][j+1]==color1) {
						 		int n=1;
						 		while(b[i+n][j+n]!=color) {
						 			if (b[i+n][j+n]==color1){
						 				n++;
						 			}
						 			else if(b[i+n][j+n]==0) {
						 				b[i+n][j+n] = 3;
						 				//possibleMovesCounter++;
						 				break;
						 			}
						 		}
							}
								
							//checks down-left diagonal
							if(b[i+1][j-1]==color1 && b[i][j]==color) {
						 		int n=1;
						 		while(b[i+n][j-n]!=color) {
						 			if (b[i+n][j-n]==color1){
						 				n++;
						 			}
						 			else if(b[i+n][j-n]==0) {
						 				b[i+n][j-n] = 3;
						 				//possibleMovesCounter++;
						 				break;
						 			}
						 		}
						 	}
								
							//checks up-right diagonal
							if(b[i-1][j+1]==color1 && b[i][j]==color) {
						 		int n=1;
						 		while(b[i-n][j+n]!=color) {
						 			if (b[i-n][j+n]==color1){
						 				n++;
						 			}
						 			else if(b[i-n][j+n]==0) {
						 				b[i-n][j+n] = 3;
						 				//possibleMovesCounter++;
						 				break;
						 			}
						 		}
							}
							
							//checks up-left diagonal
							if(b[i-1][j-1]==color1 && b[i][j]==color) {
						 		int n=1;
						 		while(b[i-n][j-n]!=color) {
						 			if (b[i-n][j-n]==color1){
						 				n++;
						 			}
						 			else if(b[i-n][j-n]==0) {
						 				b[i-n][j-n] = 3;
						 				//possibleMovesCounter++;
						 				break;
						 			}
						 		}
						 	}
							break; 
					}
				}
			}
		}
	
		//USED TO SHOW ARRAY FOR TESTING
		for( row = 0; row < b.length; row++ ){
		  for(column = 0; column < b[row].length; column++ ){
		    System.out.print(Integer.toString(b[row][column])+"  ");
		  }
		  System.out.print("\n"); 
		}
		System.out.print("\n");
		//END OF TEST STATEMENTS
	}
	
	public static void CapturePiece(int[][] board, Player player) {
		//Get player color
        int color1 = player.getColor();
        int color2;
        if (color1 == 1)
        	color2 = 2;
        else 
            color2 = 1;
        int column = 0;
        int row = 0;
        //end get player color

        //BLACK PLAYER
        if (color1 == 1) {
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; j++) {
                	switch(board[i][j]) {
				 		case 0:
				 			break;
						 
				 		case 1:
				 			break;
				 			
				 		case 2:
				 			break;
				 			
				 		case 3:
				 			//Captures UP from 3
				 			if(board[i][j]==3 && board[i-1][j]==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board[i-x][j]==color2) {
				 					if(board[i-x][j] == color2) {
				 						board[i-x][j]= color1;
				 						x++;
				 					}
				 					else if(board[i-x][j]==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures DOWN from 3
				 			if(board[i][j]==3 && board[i+1][j]==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board[i+x][j]==color2) {
				 					if(board[i+x][j] == color2) {
				 						board[i+x][j]= color1;
				 						x++;
				 					}
				 					else if(board[i+x][j]==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures LEFT from 3
				 			if(board[i][j]==3 && board[i][j-1]==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board[i][j-x]==color2) {
				 					if(board[i][j-x] == color2) {
				 						board[i][j-x]= color1;
				 						x++;
				 					}
				 					else if(board[i][j-x]==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures RIGHT from 3
				 			if(board[i][j]==3 && board[i][j+1]==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board[i][j+x]==color2) {
				 					if(board[i][j+x] == color2) {
				 						board[i][j+x]= color1;
				 						x++;
				 					}
				 					else if(board[i][j+x]==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures UP-LEFT from 3
				 			if(board[i][j]==3 && board[i-1][j-1]==color2) {
				 				board[i][j]=color1;
				 				int x = 1;
				 				while(board[i-x][j-x]==color2) {
				 					if(board[i-x][j-x] == color2) {
				 						board[i-x][j-x]= color1;
				 						x++;
				 					}
				 					else if(board[i-x][j-x]==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures DOWN-RIGHT from 3
				 			if(board[i][j]==3 && board[i+1][j+1]==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board[i+x][j+x]==color2) {
				 					if(board[i+x][j+x] == color2) {
				 						board[i+x][j+x]= color1;
				 						x++;
				 					}
				 					else if(board[i+x][j+x]==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures UP-RIGHT from 3
				 			if(board[i][j]==3 && board[i-1][j+1]==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board[i-x][j+x]==color2) {
				 					if(board[i-x][j+x] == color2) {
				 						board[i-x][j+x]= color1;
				 						x++;
				 					}
				 					else if(board[i-x][j+x]==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures DOWN-LEFT from 3
				 			if(board[i][j]==3 && board[i+1][j-1]==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board[i+x][j-x]==color2) {
				 					if(board[i+x][j-x] == color2) {
				 						board[i+x][j-x]= color1;
				 						x++;
				 					}
				 					else if(board[i+x][j-x]==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			break;
                	}
                }
            }
        }
        
        //WHITE PLAYER
        if (color1 == 2) {
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; j++) {
                	switch(board[i][j]) {
				 		case 0:
				 			break;
						 
				 		case 1:
				 			break;
				 			
				 		case 2:
				 			break;
				 			
				 		case 3:
				 			//Captures UP from 3
				 			if(board[i][j]==3 && board[i-1][j]==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board[i-x][j]==color2) {
				 					if(board[i-x][j] == color2) {
				 						board[i-x][j]= color1;
				 						x++;
				 					}
				 					else if(board[i-x][j]==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures DOWN from 3
				 			if(board[i][j]==3 && board[i+1][j]==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board[i+x][j]==color2) {
				 					if(board[i+x][j] == color2) {
				 						board[i+x][j]= color1;
				 						x++;
				 					}
				 					else if(board[i+x][j]==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures LEFT from 3
				 			if(board[i][j]==3 && board[i][j-1]==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board[i][j-x]==color2) {
				 					if(board[i][j-x] == color2) {
				 						board[i][j-x]= color1;
				 						x++;
				 					}
				 					else if(board[i][j-x]==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures RIGHT from 3
				 			if(board[i][j]==3 && board[i][j+1]==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board[i][j+x]==color2) {
				 					if(board[i][j+x] == color2) {
				 						board[i][j+x]= color1;
				 						x++;
				 					}
				 					else if(board[i][j+x]==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures UP-LEFT from 3
				 			if(board[i][j]==3 && board[i-1][j-1]==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board[i-x][j-x]==color2) {
				 					if(board[i-x][j-x] == color2) {
				 						board[i-x][j-x]= color1;
				 						x++;
				 					}
				 					else if(board[i-x][j-x]==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures DOWN-RIGHT from 3
				 			if(board[i][j]==3 && board[i+1][j+1]==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board[i+x][j+x]==color2) {
				 					if(board[i+x][j+x] == color2) {
				 						board[i+x][j+x]= color1;
				 						x++;
				 					}
				 					else if(board[i+x][j+x]==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures UP-RIGHT from 3
				 			if(board[i][j]==3 && board[i-1][j+1]==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board[i-x][j+x]==color2) {
				 					if(board[i-x][j+x] == color2) {
				 						board[i-x][j+x]= color1;
				 						x++;
				 					}
				 					else if(board[i-x][j+x]==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures DOWN-LEFT from 3
				 			if(board[i][j]==3 && board[i+1][j-1]==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board[i+x][j-x]==color2) {
				 					if(board[i+x][j-x] == color2) {
				 						board[i+x][j-x]= color1;
				 						x++;
				 					}
				 					else if(board[i+x][j-x]==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			if (board[i][j] == 3) {
				 				board[i][j] = color1;
				 			}
				 			break;
                	}
                }
            }
        }
        
        //Test array for capturing piece
        for( row = 0; row < board.length; row++ ){
              for(column = 0; column < board[row].length; column++ ){
            	  System.out.print(Integer.toString(board[row][column])+"  ");
              }
              System.out.print("\n"); 
        }
        System.out.print("\n");
        //end test array
	}
}
