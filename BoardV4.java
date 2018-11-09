package Othello;


public class BoardV4 {
	public static void main() {
		//Board (NUMBERS INPUTTED ARE FOR TEST ALL CASES for WHITE)
		int[][] board = new int[][] {
			{0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 1, 1, 0, 1, 1, 2, 0 },
			{0, 0, 0, 0, 0, 0, 2, 0 },
			{0, 0, 2, 1, 1, 1, 0, 0 },
			{0, 0, 2, 1, 1, 0, 0, 0 },
			{0, 0, 2, 0, 0, 0, 0, 0 },
			{0, 0, 1, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0 },
		};
		
		//test player 1 and 2 TEMPORARY PLAYERS
		Player black1 = new Player("black");
		Player white2 = new Player("white");
	
		black1.setColor(1);
		white2.setColor(2);
		possibleMoves(board, white2);
		//end

		 
	}
	
	//THIS WAS FOR SEAN
	public BoardV4() {
		//Board (NUMBERS INPUTTED ARE FOR TEST ALL CASES for BLACK)
		int[][]logicMatrix = new int[][] {
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
	/*Idea For Counting Possible Moves: change return type to Boolean create 'int possibleMovesCounter = 0;' and 'boolean possibleMovesBool = false;'
	 * then add possibleMovesCounter++; to each if statement in the switch cases in. then after switch statement add: 
	 * 							'if(possibleMovesCounter!=0) {
	 *				 			   possibleMovesBool = true;
	 *					 		}'
	 *	before last break;	then return possibleMovesBool;		 		
	 */
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
			
			
		//BLACK PLAYER
		if(color == 1) {
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {	
				 
				 switch(b[i][j]) {
				 	case 0:
						 break;
						 
					case 1:
						// Checks move down V2
						if( (b[i][j] == color) && (b[i + 1][j] == color1) ){
									int n = 1;
									while(b[i+n][j] != color) {
										if(b[i+n][j] == color1) {
											n++;
										}
										else if(b[i+n][j] == 0){
											b[i+n][j] = 3;
											break;
										}
									}
						}
						
						//Checks move up
						if( (b[i][j] == color ) && (b[i-1][j] == color1) && i >= 2 ){ //Checks move up
								int n = 1;
									while(b[i-n][j] != color && n <= i) {
										if(b[i-n][j] == color1) {
											n++;
										}
										else if(b[i-n][j] == 0){
											b[i-n][j] = 3;
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
								// Checks move down V2
								if( (b[i][j] == color) && (b[i + 1][j] == color1) ){
								
			
											int n = 1;
											while(b[i+n][j] != color) {
												if(b[i+n][j] == color1) {
													n++;
												}
												else if(b[i+n][j] == 0){
													b[i+n][j] = 3;
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
						 					break;
						 				}
						 			
						 			}
						 		}
								break;
							 
						 }
				}
			}
		}
		
		//This is logic for capturing a piece. Couldn't test.
		/*public static void capturePiece() {
		  		if(b[i][j]==3 && b[i+1][j]==color1) {
						int x = 1;
						while(b[i][j]==3 && b[i+1][j]==color1) {
							if(b[i+x][j] == color1) {
								b[i+x][j]= color;
								x++;
								
							}
							else if(b[i+x][j]==color) {
								break;
							}
						}
				}
			}
		 */
		
		//USED TO SHOW ARRAY FOR TESTING
		for( row = 0; row < b.length; row++ ){
		  for(column = 0; column < b[row].length; column++ ){
		    System.out.print(Integer.toString(b[row][column])+"  ");
		    
		  }
		 
		  System.out.print("\n"); 
		} 
		GameInterfaceV4.updateUI(b);
		//END OF TEST STATEMENTS
	
	}
	
}