package othello;
//Author: Sai Chand Reddy Bussu
//Modified on 11/05/2018
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
	
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton[][] buttons;
	private SquareBox[][] board;
	
	static int[][]logicMatrix = new int[][] {
		{1, 0, 0, 0, 0, 0, 0, 0 },
		{0, 2, 0, 1, 0, 0, 0, 0 },
		{0, 0, 2, 0, 2, 0, 0, 0 },
		{0, 0, 0, 1, 2, 0, 0, 0 },
		{0, 0, 0, 2, 1, 2, 0, 0 },
		{0, 0, 0, 0, 0, 1, 0, 0 },
		{0, 0, 0, 0, 1, 0, 0, 0 },
		{0, 0, 0, 0, 0, 2, 1, 1 },
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
			}
		}

		
		
		setTitle("GG");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
		 Player player1 = new Player("Black");
		 Player player2 = new Player("White");
		
		player1.setColor(1);
		player2.setColor(2);
		
		boolean isPossible1 = BoardV2.possibleMoves(logicMatrix, player1);
		boolean isPossible2 = BoardV2.possibleMoves(logicMatrix, player2);
		
		/*if(turn == 1)
			continue; //If the turn is the starting turn, everything should be in order
		else 		    //If the turn is anything else, then run through these steps
			if(currentColor == 1)
				currentColor++; //If the currentColor is black, make it white
			else 	
				currentColor--; //If the currentColor is white, make it black
			if(currentColor == 1) //Assuming player1 is playing with the black pieces, 
				if(isPossible1 = false) //if p1 has no possible moves, then change the currentColor to black
						currentColor = 2;
				else
					if(isPossible2 = false) //if p2 has no possible moves, then change the currentColor to white
						currentColor = 1;
				//End game logic
		if(isPossible1 = false && isPossible2 = false)
			//End game
		*/
		//Try to figure out how to implement 
		
		int turn = 1, currentColor = 1; // Sets the turn to initial value of zero and currentColor to black to start the game
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GameInterfaceV3 q = new GameInterfaceV3();
			}
		});
		System.out.println();
	}
}
