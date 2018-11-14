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

  
public class GameInterfaceV7 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private static ShoSquareBox[][] buttons;
	private ShoSquareBox[][] board;
	SBoardV6 boardImportant;
	int row;
	int column;
	
	public GameInterfaceV7(SBoardV6 b) {//Unknown
		this.boardImportant = b;
		int row;
		int column;
		initUI();
		
		this.setVisible(true);
	}
	public GameInterfaceV7() {//Unknown
		boardImportant = new SBoardV6();
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
	public void initUI() {
		panel = new JPanel();
		

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
				GameInterfaceV7.buttons[i][j] = new ShoSquareBox(" ", i, j, boardImportant.getValue(i, j));
				GameInterfaceV7.buttons[i][j].addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						ShoSquareBox buttonAction = (ShoSquareBox) e.getSource();
						System.out.println("Row is "+ buttonAction.getRow());
						System.out.println("column is "+ buttonAction.getColumn());
						//int tempValue = boardImportant.getValue(buttonAction.getRow(),buttonAction.getColumn());
						row = buttonAction.getRow();
						column = buttonAction.getColumn();
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
		panel.setVisible(true);
		add(panel);	
		setTitle("GG");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

public static void updateUI(SBoardV6 logicMatrix) {
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
