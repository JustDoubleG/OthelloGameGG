// Author: Sai Chand Reddy Bussu
// Modified on 11/05/2018
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.MatteBorder;

public class GameInterfaceV3 extends JFrame implements ActionListener {
	/**
	 * 
	 */

	static Player player1 = new Player("Black");
	static Player player2 = new Player("White");
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton[][] buttons;
	private SquareBox[][] board;
	
	static int[][]logicMatrix = new int[][] {
		{0, 0, 0, 0, 0, 0, 0, 0 },
		{0, 0, 0, 0, 0, 0, 0, 0 },
		{0, 0, 0, 0, 0, 0, 0, 0 },
		{0, 0, 0, 1, 2, 0, 0, 0 },
		{0, 0, 0, 2, 1, 0, 0, 0 },
		{0, 0, 0, 0, 0, 3, 0, 0 },
		{0, 0, 0, 0, 0, 0, 0, 0 },
		{0, 0, 0, 0, 0, 0, 0, 0 },
	};

	public GameInterfaceV3() {//Unknown
		
		initUI();
		this.setVisible(true);
	}

	public GameInterfaceV3(SquareBox[][] board) {//unknown
		this.setBoard(board);
		initUI();
		this.setVisible(true);
	}

	public void takeTurn() {
		
	}
	public void initUI() {
		panel = new JPanel();
		
		BoardV2 testBoard = new BoardV2();
		
		panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
		panel.setBorder(new MatteBorder(15,15,15,15, Color.WHITE)); // boarder color
		GridLayout newGrid = new GridLayout(8,8,2,2);
		panel.setLayout(newGrid);
		panel.setBackground(new Color(169,169,169)); //Grey color between white tiles
		
		this.buttons = new JButton[8][8];
		this.board = new SquareBox[8][8];
		
		//Create the buttons
		
		//btRight.setOnAction(e -> ballPane.moveRight());
		
		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board[i].length; j++) {
				if (this.board[i][j] != null) {
					this.buttons[i][j] = new JButton(
							this.board[i][j].toString());
					panel.add(this.buttons[i][j]);
				} else {
					this.buttons[i][j] = new JButton(".");
					this.buttons[i][j].setIcon(new ImageIcon("images/icon.png"));
					panel.add(this.buttons[i][j]);
				}
				buttons[i][j].addActionListener(this);
				
			}
			panel.setVisible(true);
		}


		add(panel);
		
		System.out.println(logicMatrix[4][4]);
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(logicMatrix[i][j] == 0) {
					this.buttons[i][j].setIcon(new ImageIcon("images/icon.png"));
				}
				if(logicMatrix[i][j] == 1) {
					this.buttons[i][j].setIcon(new ImageIcon("images/BlackCircle.png"));
				}
				if(logicMatrix[i][j] == 2) {
					this.buttons[i][j].setIcon(new ImageIcon("images/WhiteCircle.png"));
				}
				if(logicMatrix[i][j] == 3) {
					this.buttons[i][j].setIcon(new ImageIcon("images/yellow-circle-md.png"));
				}
			}
		}

		//possibleMoves(logicMatrix, player1);
		
		setTitle("GG");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void updateUI() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(logicMatrix[i][j] == 0) {
					buttons[i][j].setIcon(new ImageIcon("images/icon.png"));
				}
				if(logicMatrix[i][j] == 1) {
					buttons[i][j].setIcon(new ImageIcon("images/BlackCircle.png"));
				}
				if(logicMatrix[i][j] == 2) {
					buttons[i][j].setIcon(new ImageIcon("images/WhiteCircle.png"));
				}
				if(logicMatrix[i][j] == 3) {
					buttons[i][j].setIcon(new ImageIcon("images/YellowCircle1.png"));
				}
			}
		}
	}
	
	public static boolean possibleMoves(int[][] b, Player p) {
		//changed index to match return type
		
		//get Player color
		int possibleMovesCounter=0;
		boolean possibleMovesBool = false;
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
							b[i+2][j] = 3;
						
							System.out.println("down ");
						}
						if( (b[i][j] == color ) && (b[i-1][j] == color1) && (b[i-2][j] == 0) && i >= 2){ //Checks move up
							row = j;
							column = i - 2;
							//Set new possible move up and changes value between
							b[i-2][j] = 3;
							
							System.out.println("up ");
						}
						if( (b[i][j] == color ) && (b[i][j+1] == color1) && (b[i][j+2] == 0)){ //Checks move right
							row = j + 2;
							column = i;
							//Set new possible move right and changes value between
							b[i][j+2] = 3;
							
							System.out.println("right ");
						}
						if( (b[i][j] == color ) && (b[i][j-1] == color1) && (b[i][j-2] == 0) && j >= 2){ //Checks move left
							row = j - 2;
							column = i;
							//Set new possible move left and changes value between
							b[i][j-2] = 3;
							
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
						 			b[i+2][j] = 3;
						 			
						 			System.out.println("down ");
						 			possibleMovesCounter++;
								
						 		}
						 		if( (b[i][j] == color ) && (b[i-1][j] == color1) && (b[i-2][j] == 0) && i >= 2){ //Checks move up
						 			row = j;
						 			column = i - 2;
						 			//Set new possible move up and changes value between
						 			b[i-2][j] = 3;
						 			
						 			System.out.println("up ");
						 			possibleMovesCounter++;
						 		}
						 		if( (b[i][j] == color ) && (b[i][j+1] == color1) && (b[i][j+2] == 0)){ //Checks move right
						 			row = j + 2;
						 			column = i;
						 			//Set new possible move right and changes value between
						 			b[i][j+2] = 3;
						 			
						 			System.out.println("right ");
						 			possibleMovesCounter++;
						 		}
						 		if( (b[i][j] == color ) && (b[i][j-1] == color1) && (b[i][j-2] == 0) && j >= 2){ //Checks move left
						 			row = j - 2;
						 			column = i;
						 			//Set new possible move left and changes value between
						 			b[i][j-2] = 3;
						 			
						 			System.out.println("left ");
						 			possibleMovesCounter++;
						 		}
						 		if(possibleMovesCounter!=0) {
						 			possibleMovesBool = true;
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
		return possibleMovesBool;
	}
	
	
	
	public void setBoard(SquareBox[][] board) {
		this.board = board;
	}

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				if (buttons[i][j] == e.getSource()) {
					
				}
			}
		}
	}

	public static void main(String[] args) {
		
		player1.setColor(1);
		player2.setColor(2);
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GameInterfaceV3 q = new GameInterfaceV3();
				possibleMoves(logicMatrix, player1);
				//updateUI();
			}
		});
		System.out.println();
	}
}