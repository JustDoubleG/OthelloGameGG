package project;

import java.io.*;
import java.util.*;

/*
 * Updated Board Version 2
 * Detects all vertical and horizontal moves, and can change the values in between 2 numbers in a range of 3: X y X (changes y).
 * Needs to change more than 1 value: X y y y y X. All y's need changing.
 * Needs to have diagonal.
 * Needs to be connected with UI.
 */

public class Board {
	public static void main(String[] args) {
		int[][] board = new int[][] {
			{0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 1, 2, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 1, 2, 0, 0, 0 },
			{0, 0, 0, 2, 1, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0 },
		};
		
		//test
		Player black1 = new Player("black"); //added
		Player white2 = new Player("white");
		//
		black1.setColor(1); //added
		white2.setColor(2);
		possibleMoves(board, black1);//added
		//end test

		 
	}
	
	public Board() {
		int[][]logicMatrix = new int[][] {
			{0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 1, 2, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 1, 2, 0, 0, 0 },
			{0, 0, 0, 2, 1, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0 },
		};
	}
	
	public static void possibleMoves(int[][] b, Player p) {
		//changed index to match return type
		
		//get Player color 
		int color = p.getColor();
		int color1;
		if(color == 1)
			 color1 = 2;
		else 
			 color1 = 1;		
		
		int column = 0;
		int row = 0;
			
			
		//changed if statements 
		if(color == 1) {
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {	
				 
				 switch(b[i][j]) {
				 
				 	case 0:
						 break;
						 
					case 1:
						if( (b[i][j] == color ) && (b[i+1][j] == color1) && (b[i+2][j] == 0)){ //Checks move down
							row = j;
							column = i + 2;
							//Set new possible move down and changes value between
							b[i+2][j] = 5;
							b[i+1][j] = color;
						
							System.out.println("down ");
						}
						if( (b[i][j] == color ) && (b[i-1][j] == color1) && (b[i-2][j] == 0) && i >= 2){ //Checks move up
							row = j;
							column = i - 2;
							//Set new possible move up and changes value between
							b[i-2][j] = 6;
							b[i-1][j] = color;
							
							System.out.println("up ");
						}
						if( (b[i][j] == color ) && (b[i][j+1] == color1) && (b[i][j+2] == 0)){ //Checks move right
							row = j + 2;
							column = i;
							//Set new possible move right and changes value between
							b[i][j+2] = 7;
							b[i][j+1] = color;
							
							System.out.println("right ");
						}
						if( (b[i][j] == color ) && (b[i][j-1] == color1) && (b[i][j-2] == 0) && j >= 2){ //Checks move left
							row = j - 2;
							column = i;
							//Set new possible move left and changes value between
							b[i][j-2] = 8;
							b[i][j-1] = color;
							
							System.out.println("left ");
						}
						break;
					 
					case 2: 
						break;
				 }
				}
			}	 
		}
		
		if(color == 2) {
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
					
						 switch(b[i][j]) {
						 
						 	case 0:
						 		break;
						 		
						 	case 1:
						 		break;
						 
						 	case 2: 
						 		if( (b[i][j] == color ) && (b[i+1][j] == color1) && (b[i+2][j] == 0)){ //Checks move down
						 			row = j;
						 			column = i + 2;
						 			//Set new possible move down and changes value between
						 			b[i+2][j] = 5;
						 			b[i+1][j] = color;
						 			
						 			System.out.println("down ");
						 			
								
						 		}
						 		if( (b[i][j] == color ) && (b[i-1][j] == color1) && (b[i-2][j] == 0) && i >= 2){ //Checks move up
						 			row = j;
						 			column = i - 2;
						 			//Set new possible move up and changes value between
						 			b[i-2][j] = 6;
						 			b[i-1][j] = color;
						 			
						 			System.out.println("up ");
						 		}
						 		if( (b[i][j] == color ) && (b[i][j+1] == color1) && (b[i][j+2] == 0)){ //Checks move right
						 			row = j + 2;
						 			column = i;
						 			//Set new possible move right and changes value between
						 			b[i][j+2] = 7;
						 			b[i][j+1] = color;
						 			
						 			System.out.println("right ");
						 		}
						 		if( (b[i][j] == color ) && (b[i][j-1] == color1) && (b[i][j-2] == 0) && j >= 2){ //Checks move left
						 			row = j - 2;
						 			column = i;
						 			//Set new possible move left and changes value between
						 			b[i][j-2] = 8;
						 			b[i][j-1] = color;
						 			
						 			System.out.println("left ");
						 		}
						 		break;
						 }
				}
			}
		}
		
		//System.out.println("done "); 
		for( row = 0; row < b.length; row++ ){
		  for(column = 0; column < b[row].length; column++ ){
		    System.out.print(Integer.toString(b[row][column])+"  ");
		  }
		  System.out.print("\n"); 
		}
		//This is where the print loop ends
	}
}