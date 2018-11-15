//Modified on November 14, 2018 by Tri Nguyen
//Authors Sai, Sola, and Sean
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.MatteBorder;

import java.awt.*;

  
public class GameInterfaceV7 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	SBoardV7 boardImportant = new SBoardV7();
	
	//Create main panel for board
	private JPanel panel;
	
	//Create panels for players, time, and turn
	//GridLayout(row, columns)
	//FlowLayout() displays thing on a row from left to right
	private JPanel Player1P = new JPanel(new GridLayout(20,0));
	private JPanel Player2P = new JPanel(new GridLayout(20,0));
	private JPanel TimeP = new JPanel(new FlowLayout());
	private JPanel TurnP = new JPanel(new FlowLayout());
	
	//Create JLabels
	private JLabel Player1L = new JLabel("Player 1: " + boardImportant.getPlayer1().getUsername());
	private JLabel Score1L = new JLabel("Score: " + boardImportant.getPlayer1().getScore());
	private JLabel Color1L = new JLabel("Color: BLACK");
	
	private JLabel Player2L = new JLabel("Player 2: " + boardImportant.getPlayer2().getUsername());
	private JLabel Score2L = new JLabel("Score: " + boardImportant.getPlayer2().getScore());
	private JLabel Color2L = new JLabel("Color: WHITE");
	
	private JLabel TimeL = new JLabel("Time: ");
	private JLabel TurnL = new JLabel("Turn: ");
	//Created a button to indicate whose turn it is
	private JButton IndicatorB = new JButton("GO!");
	

	
	
	private static ShoSquareBox[][] buttons;
	private ShoSquareBox[][] board;
	int row;
	int column;
	
	public GameInterfaceV7(SBoardV7 b) {//Unknown
		this.boardImportant = b;
		int row;
		int column;
		initUI();
		
		this.setVisible(true);
	}
	public GameInterfaceV7() {//Unknown
		boardImportant = new SBoardV7();
		initUI();
		
		this.setVisible(true);
	}

	public GameInterfaceV7(ShoSquareBox[][] board) {//unknown
		this.setBoard(board);
		initUI();
		this.setVisible(true);
	}

	public void takeTurn() {

	}
	
	//Where we create the board
	public void initUI() {
		panel = new JPanel();
		
		//createEmptyBorder(top, left, bottom, right)
		//top: width of top, left: width of left, bottom: width of bottom, right: width of right
		panel.setBorder(BorderFactory.createEmptyBorder(200,500,200,500)); //For the window surrounding the board
		panel.setBorder(new MatteBorder(200,500,200,500, Color.WHITE)); // boarder color
		GridLayout newGrid = new GridLayout(8,8,2,2); //For the entire board
		panel.setLayout(newGrid);
		panel.setBackground(Color.green); //Grey color between white tiles

		this.buttons = new ShoSquareBox[8][8];
		this.board = this.buttons;

		//Create the buttons

		//btRight.setOnAction(e -> ballPane.moveRight());

		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board[i].length; j++) {
				GameInterfaceV7.buttons[i][j] = new ShoSquareBox(" ", i, j, boardImportant.getValue(i, j));
				GameInterfaceV7.buttons[i][j].addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						//ShoSquareBox buttonAction = (ShoSquareBox) e.getSource();
						/*System.out.println("Row is "+ buttonAction.getRow());
						System.out.println("column is "+ buttonAction.getColumn());*/
						//int tempValue = boardImportant.getValue(buttonAction.getRow(),buttonAction.getColumn());
						//row = buttonAction.getRow();
						//column = buttonAction.getColumn();
						/*if(tempValue == 3) {
							board2.CapturePiece2(buttonAction.getRow(),buttonAction.getColumn());
						}
						else {
							System.out.println("There was an error");
						}*/
					}
				});
				panel.add(this.buttons[i][j]);
			}

		}
		
		//This is where you add the panels
		panel.setVisible(true);
		Player1P.setVisible(true);
		Player2P.setVisible(true);
		TimeP.setVisible(true);
		TurnP.setVisible(true);
		
		//Set the direction of the non game board panels
		setLayout(new BorderLayout());
		add(panel);
		add(Player1P, BorderLayout.WEST);
		add(Player2P, BorderLayout.EAST);
		add(TimeP, BorderLayout.NORTH);
		add(TurnP, BorderLayout.SOUTH);
		
		//setPreferredSize (width, height) for Time and Turn
		//setPreferredSize(width, height: doesn't change) for Player1 and Player2
		
		Player1P.setPreferredSize(new Dimension(150, 0));
		Player2P.setPreferredSize(new Dimension(150, 0));
		TimeP.setPreferredSize(new Dimension(100, 50));
		TurnP.setPreferredSize(new Dimension(100, 50));
		
		//Adding the JLabel to their respective JPanel
		Player1P.add(Player1L);
		Player1P.add(Score1L);
		Player1P.add(Color1L);
		
		Player2P.add(Player2L);
		Player2P.add(Score2L);
		Player2P.add(Color2L);
		
		TimeP.add(TimeL);
		
		if(boardImportant.p1Turn == 1) {
		IndicatorB.setBackground(Color.BLACK);
		}
		else{
			IndicatorB.setBackground(Color.WHITE);
		}
		
		TurnP.add(TurnL);
		TurnP.add(IndicatorB);
		
		//Set title name and the size of the Othello board
		setTitle("Team GG: Othello");
		setSize(500, 500);
		setLocationRelativeTo(null);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

public static void updateUI(SBoardV7 logicMatrix) {
	for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8; j++) {
			buttons[i][j].setValue(logicMatrix.getValue(i, j));
		}
	}
}



public void setBoard(ShoSquareBox[][] board) {
	this.board = board;
}

public void actionPerformed(ActionEvent e) {
	ShoSquareBox buttonAction = (ShoSquareBox) e.getSource();
	boardImportant.switchPlayerTurnIndicator();
}

public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
		public void run() {
			GameInterfaceV7 q = new GameInterfaceV7();
			


		}
	});
	System.out.println();
}
}