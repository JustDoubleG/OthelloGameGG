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
import javax.swing.Timer;

  
public class GameInterfaceV9 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private static ShoSquareBox[][] buttons;
	private ShoSquareBox[][] board;
	SBoardV8 boardImportant;
	static int row;
	static int column;
	
	public GameInterfaceV9(SBoardV8 b) {//Unknown
		this.boardImportant = b;
		int row;
		int column;
		initUI();
		
		this.setVisible(true);
	}
	public GameInterfaceV9() {//Unknown
		boardImportant = new SBoardV8();
		int row;
		int column;
		initUI();
		
		this.setVisible(true);
	}

	public GameInterfaceV9(ShoSquareBox[][] board) {//unknown
		this.setBoard(board);
		initUI();
		this.setVisible(true);
	}

	public void takeTurn() {

	}
	public void initUI() {
		panel = new JPanel();
		//boardImportant = new SBoardV7();
		int delay = 10000;
		
		panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
		panel.setBorder(new MatteBorder(15,15,15,15, Color.WHITE)); // boarder color
		GridLayout newGrid = new GridLayout(8,8,2,2);
		panel.setLayout(newGrid);
		panel.setBackground(Color.green); //Grey color between white tiles

		this.buttons = new ShoSquareBox[8][8];
		this.board = this.buttons;

		//Create the buttons

		//btRight.setOnAction(e -> ballPane.moveRight());

		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board[i].length; j++) {
				GameInterfaceV9.buttons[i][j] = new ShoSquareBox(" ", i, j, boardImportant.getValue(i, j));
				
				
				GameInterfaceV9.buttons[i][j].addActionListener(this);/*{
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
		panel.setVisible(true);
		add(panel);	
		setTitle("GG");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}

	
public static void updateUI(SBoardV8 logicMatrix) {
	for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8; j++) {
			buttons[i][j].setValue(logicMatrix.getValue(i, j));
		}
	}
}


public void takeFullTurn() {
	switch(this.boardImportant.playerTurn().completionOfTurn) {
		case 0:
			this.boardImportant.CapturePiece2(this.row,this.column);
		case 1:
			this.boardImportant.reset3s();
	
		}
	}
public void setBoard(ShoSquareBox[][] board) {
	this.board = board;
}

public void actionPerformed(ActionEvent e) {
	ShoSquareBox buttonAction = (ShoSquareBox) e.getSource();
	row = buttonAction.getRow();
	column = buttonAction.getColumn();
	System.out.println("Row is "+ buttonAction.getRow());
	System.out.println("column is "+ buttonAction.getColumn());
	
	//while(boardImportant.checkVictory() == false){
		try {
		
			boardImportant.possibleMoves2(boardImportant.playerTurn());
			updateUI(boardImportant);
			/*boardImportant.PrintBoard();
			updateUI(boardImportant);
			System.out.println("");*/
			boardImportant.CapturePiece2(boardImportant.playerTurn(), row, column);
			boardImportant.reset3s();
			boardImportant.PrintBoard();
			updateUI(boardImportant);
			//boardImportant.switchPlayerTurnIndicator();
		
		}
		catch (Error ie){
		
		}
	//}
}

public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
		public void run() {
			GameInterfaceV9 q = new GameInterfaceV9();
			/*System.out.println("The Base Board");
			q.boardImportant.PrintBoard();
			System.out.println("");System.out.println("");
			
			System.out.println("PossibleMoves");
			q.boardImportant.possibleMoves2(q.boardImportant.playerTurn());
			q.updateUI(q.boardImportant);
			q.boardImportant.PrintBoard();
			System.out.println("");System.out.println("");
			
			System.out.println("Interested Method");
			//q.boardImportant.CapturePiece2(q.boardImportant.playerTurn(), buttonAction.getRow(), q.column;
			//q.updateUI(q.boardImportant);
			q.boardImportant.PrintBoard();*/

		}
	});
	System.out.println();
}
}
