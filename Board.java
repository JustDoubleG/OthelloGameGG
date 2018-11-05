
public class Board {
	public static void main(String[] args) {
	int[][] board = new int[][] {
		{0, 0, 0, 0, 0, 0, 0, 0 },
		{0, 0, 0, 0, 0, 0, 0, 0 },
		{0, 0, 0, 0, 0, 0, 0, 0 },
		{0, 0, 0, 1, 2, 0, 0, 0 },
		{0, 0, 0, 2, 1, 0, 0, 0 },
		{0, 0, 0, 0, 0, 0, 0, 0 },
		{0, 0, 0, 0, 0, 0, 0, 0 },
		{0, 0, 0, 0, 0, 0, 0, 0 },
	};
	
	public static int[] possibleMoves(int[][] b, Player p1){
		//get Player color 
		int color = p1.getColor();
		int indexXArray[];
		int indexYArray[];
		int counterN = 0;
		boolean isOne = true;
		 for(int i = 0; i < 8; i++) {
			 for(int j = 0; j < 8; i++) {
				 if( (b[i][j] == color ) && (b[i+1][j] != color) && (b[i+2][j] ==0)){ //Checks downwards
					 indexXArray[counterN] = i+2;
					 indexYArray[counterN] = j;
					 counterN+=1;
				 }
				 if( (b[i][j] == color ) && (b[i-1][j] != color) && (b[i-2][j] ==0)){ //Checks upwards
					 indexXArray[counterN] = i-2;
					 indexYArray[counterN] = j;
					 counterN+=1;
				 }
				 if( (b[i][j] == color ) && (b[i][j+1] != color) && (b[i][j+2] ==0)){ //Checks upwards
					 indexXArray[counterN] = i;
					 indexYArray[counterN] = j+2;
					 counterN+=1;
				 }
				 if( (b[i][j] == color ) && (b[i][j-1] != color) && (b[i][j-2] ==0)){ //Checks upwards
					 indexXArray[counterN] = i;
					 indexYArray[counterN] = j-2;
					 counterN+=1;
				 }
		 }
			 
	 }
	for(int t = 0; t <= counterN; t++) {
		return indexXArray[t];
		return indexyArray[t];
	}
	
	
	System.out.println(board[4][4]);
	 
	}
}
}