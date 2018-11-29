//Modified on November 19, 2018 by Tri Nguyen
//Authors Sai, Sola, and Sean

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.MatteBorder;
import java.awt.*;

  
public class ZGameInterface extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static ZSquareBox[][] buttons;
	private ZSquareBox[][] board;
	ZBoard boardImportant = new ZBoard(ZLogin.Player1Name(), ZLogin.Player2Name());
	static int row;
	static int column;
	int Turn=1;
	
	//Create main panel for the game board
	private static JPanel panel;
	
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
		
	private JLabel Player2L = new JLabel("Player 2: " +boardImportant.getPlayer2().getUsername());
	private JLabel Score2L = new JLabel("Score: " + boardImportant.getPlayer2().getScore());
	private JLabel Color2L = new JLabel("Color: WHITE");
		
	private JLabel TimeL = new JLabel("Time: ");
	private JLabel TurnL = new JLabel("Turn: ");
	//Created a button to indicate whose turn it is
	private JButton IndicatorB = new JButton(" ");
	
	
	public ZGameInterface(ZBoard b) {//Unknown
		this.boardImportant = b;
		int row;
		int column;
		initUI();
		
		this.setVisible(true);
	}
	public ZGameInterface(String p1Name, String p1Pass, String p2Name, String p2Pass) {//Unknown
		this.boardImportant.getPlayer1().setUsername(p1Name);
		this.boardImportant.getPlayer1().setPassword(p1Pass);
		this.boardImportant.getPlayer2().setUsername(p2Name);
		this.boardImportant.getPlayer2().setPassword(p2Name);
		int row;
		int column;
		initUI();
		
		this.setVisible(true);
	}
	public ZGameInterface() {//Unknown
		this.boardImportant = boardImportant;
		int row;
		int column;
		initUI();
		
		this.setVisible(true);
	}

	public ZGameInterface(ZSquareBox[][] board) {//unknown
		this.setBoard(board);
		initUI();
		this.setVisible(true);
	}

	public void initUI() {
		panel = new JPanel();
		int delay = 10000;
		
		//createEmptyBorder(top, left, bottom, right)
		//top: width of top, left: width of left, bottom: width of bottom, right: width of right
		panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); //For the window surrounding the board
		panel.setBorder(new MatteBorder(20,20,20,20, Color.WHITE)); // boarder color
		GridLayout newGrid = new GridLayout(8,8,2,2); //For the entire board
		panel.setLayout(newGrid);
		panel.setBackground(Color.GREEN); //Grey color between white tiles

		this.buttons = new ZSquareBox[8][8];
		this.board = this.buttons;

		//Create the buttons

		//btRight.setOnAction(e -> ballPane.moveRight());

		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board[i].length; j++) {
				ZGameInterface.buttons[i][j] = new ZSquareBox(" ", i, j, boardImportant.getValue(i, j));
				
				
				ZGameInterface.buttons[i][j].addActionListener(this);/*{
					//ActionListener taskPerformer = new ActionListener();{
					public void actionPerformed(ActionEvent e){
						ShoSquareBox buttonAction = (ShoSquareBox) e.getSource();
						
						
						
						System.out.println("Row is "+ buttonAction.getRow());
						System.out.println("column is "+ buttonAction.getColumn());
						//int tempValue = boardImportant.getValue(buttonAction.getRow(),buttonAction.getColumn());
						row = buttonAction.getRow();
						column = buttonAction.getColumn();
					}
					
				});*/
				//new Timer(delay, taskPerformer).start();
				//}
				panel.add(this.buttons[i][j]);
			

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
			Player1P.setBackground(Color.WHITE);
			add(Player2P, BorderLayout.EAST);
			Player2P.setBackground(Color.WHITE);
			add(TimeP, BorderLayout.NORTH);
			TimeP.setBackground(Color.WHITE);
			add(TurnP, BorderLayout.SOUTH);
			TurnP.setBackground(Color.WHITE);
			
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
			
			//This part used later in this class
			/*if(boardImportant.p1Turn == 1) {
			IndicatorB.setBackground(Color.BLACK);
			}
			else{
				IndicatorB.setBackground(Color.WHITE);
			}*/
			
			TurnP.add(TurnL);
			TurnP.add(IndicatorB);
			
			//Set title name and the size of the Othello board
			setTitle("Team GG: Othello");
			setSize(500, 500);
			setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}

	
public static void updateUI(ZBoard logicMatrix) {
	for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8; j++) {
			buttons[i][j].setValue(logicMatrix.getValue(i, j));
		}
	}
	//boardImportant.updateScore();
}


/*public void takeFullTurn() {
	switch(this.boardImportant.playerTurn().completionOfTurn) {
		case 0:
			this.boardImportant.CapturePiece2(this.boardImportant.playerTurn(),this.row,this.column);
			this.boardImportant.PrintBoard();
		case 1:
			this.boardImportant.reset3s();
	
		}
	}*/
public void setBoard(ZSquareBox[][] board) {
	this.board = board;
}

public void actionPerformed(ActionEvent e) {
	ZSquareBox buttonAction = (ZSquareBox) e.getSource();
	row = buttonAction.getRow();
	column = buttonAction.getColumn();
	System.out.println("Row is "+ buttonAction.getRow());
	System.out.println("column is "+ buttonAction.getColumn());
	
	
	//while(boardImportant.checkVictory() == false){
		try {
		
			//boardImportant.possibleMoves2(boardImportant.playerTurn());
			//updateUI(boardImportant);
			/*boardImportant.PrintBoard();
			updateUI(boardImportant);
			System.out.println("");*/
			if(boardImportant.getValue(row,column) == 3) {
				boardImportant.CapturePiece2(boardImportant.playerTurn(), row, column);
				boardImportant.reset3s();
				updateUI(boardImportant);
				boardImportant.updateScore();
				if(boardImportant.getPlayer2().getIsComputer()==true) {
					boardImportant.possibleMoves2();
					boardImportant.ComputerCapturePieces();
					boardImportant.reset3s();
					updateUI(boardImportant);
					boardImportant.updateScore();
				}
				//This is where Sai's turn logic happens.  This might be the place to add switch turns if no possibles moves
				//I'm assuming
				//Reminder: Player 1 = Black: Turn = 2, Player 2 = White: Turn = 1
				if(Turn == 2) {
					IndicatorB.setBackground(Color.BLACK);
					//If Black doesn't have any possible moves or 3s on the board then switch to White
					if(boardImportant.getPlayer1().getHadPossibleMoves() == false && boardImportant.getPlayer2().getHadPossibleMoves() == true /*&& boardImportant.searchMatrix(boardImportant, 3, 3) == false*/) {
						Turn = 1;
						System.out.println("BLACK does not have any possible moves left, SWITCHING to WHITE!");
						JOptionPane.showMessageDialog(null, "Now switching to WHITE!", "SWITCHING TURNS " , JOptionPane.PLAIN_MESSAGE);
					}
					Turn = 1;
					
					}
					else{
						IndicatorB.setBackground(Color.WHITE);
						//If White doesn't have any possible moves or 3s on the board then switch to Black
						if(boardImportant.getPlayer2().getHadPossibleMoves() == false && boardImportant.getPlayer1().getHadPossibleMoves() == true /*&& boardImportant.searchMatrix(boardImportant, 3, 3) == false*/) {
							Turn = 2;
							System.out.println("WHITE does not have any possible moves left, SWITCHING to BLACK!");
							JOptionPane.showMessageDialog(null, "Now switching to BLACK!", "SWITCHING TURNS " , JOptionPane.PLAIN_MESSAGE);
						}
						Turn = 2;
						
					}
//				 JLabel Score1L = new JLabel("Score:  " + boardImportant.getPlayer1().getScore());
//				 Player1P.add(Score1L);
				Score1L.setText("Score:  " + boardImportant.getPlayer1().getScore());
				Score2L.setText("Score:  " + boardImportant.getPlayer2().getScore());
				 
			}
			else {
				System.out.println("Value is not equal to 3");
				JOptionPane.showMessageDialog(null, "Not a Valid Move", "Error " , JOptionPane.ERROR_MESSAGE);
			}
			//boardImportant.PrintBoard();
			//updateUI(boardImportant);
			//boardImportant.reset3s();
			//updateUI(boardImportant);
			boardImportant.PrintBoard();
			boardImportant.possibleMoves2(boardImportant.playerTurn());
			System.out.println();
			boardImportant.PrintBoard();
			updateUI(boardImportant);
			//boardImportant.switchPlayerTurnIndicator();
		
		}
		catch (Error ie){
			updateUI(boardImportant);
		}
		while(boardImportant.checkVictory() == false) {
			
			updateUI(boardImportant);
		}
		
		//If there are no more possible moves
		if(boardImportant.checkVictory() == true) {
			updateUI(boardImportant);
			
			//Victory condition Score > Enemy Score AND there are no empty spaces 0 or possible moves 3 on board
			if(boardImportant.getPlayer1().getScore() > boardImportant.getPlayer2().getScore() && boardImportant.searchMatrix(boardImportant, 3, 3) == false){
				JOptionPane.showMessageDialog(null, "PLAYER 1 WINS", "VICTORY " , JOptionPane.INFORMATION_MESSAGE);
			}
			if(boardImportant.getPlayer1().getScore() < boardImportant.getPlayer2().getScore() && boardImportant.searchMatrix(boardImportant, 3, 3) == false) {
				JOptionPane.showMessageDialog(null, "PLAYER 2 WINS", "VICTORY " , JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		
	//}
}

public static void main(String[] args) {
	
	
	
	SwingUtilities.invokeLater(new Runnable() {
		public void run() {
			ZGameInterface q = new ZGameInterface();
			System.out.println("The Base Board");
			q.boardImportant.PrintBoard();
			System.out.println("");System.out.println("");
			System.out.println("PossibleMoves");
			q.boardImportant.possibleMoves2(q.boardImportant.playerTurn());
			q.updateUI(q.boardImportant);
			q.boardImportant.PrintBoard();
			
			//q.boardImportant.reset3s();
			//q.boardImportant.PrintBoard();
			//System.out.println("");System.out.println("");
			
	//		System.out.println("Interested Method");
			//q.boardImportant.CapturePiece2(q.boardImportant.playerTurn(), buttonAction.getRow(), q.column;
			//q.updateUI(q.boardImportant);
			//q.boardImportant.PrintBoard();
			//System.out.println("Main Loaction");
			//q.boardImportant.PrintBoard();
			//q.takeFullTurn();
		}
	});
	System.out.println();
}
}