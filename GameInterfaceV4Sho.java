// Author: Sai Chand Reddy Bussu
// Modified on 11/05/2018
package othello;
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

  
public class GameInterfaceV4Sho extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private static ShoSquareBox[][] buttons;
	private ShoSquareBox[][] board;
	public GameInterfaceV4Sho() {//Unknown

		initUI();
		this.setVisible(true);
	}

	public GameInterfaceV4Sho(ShoSquareBox[][] board) {//unknown
		this.setBoard(board);
		initUI();
		this.setVisible(true);
	}

	public void takeTurn() {

	}
	public void initUI() {
		panel = new JPanel();

		Board testBoard = new Board(this.board);
		SBoardV3 board2 = new SBoardV3();

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
				GameInterfaceV4Sho.buttons[i][j] = new ShoSquareBox(" ", i, j, board2.getValue(i, j));
				GameInterfaceV4Sho.buttons[i][j].addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						ShoSquareBox button = (ShoSquareBox) e.getSource();
						System.out.println("Row is "+ button.getRow());
						System.out.println("column is "+ button.getColumn());
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

public static void updateUI(int[][] logicMatrix) {
	for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8; j++) {
			if(logicMatrix[i][j] == 0) {
				buttons[i][j].setIcon(new ImageIcon("images/icon.png"));
			}
			if(logicMatrix[i][j] == 1) {
				buttons[i][j].setIcon(new ImageIcon("images/blackicon.png"));
			}
			if(logicMatrix[i][j] == 2) {
				buttons[i][j].setIcon(new ImageIcon("images/whiteicon.png"));
			}
			if(logicMatrix[i][j] == 3) {
				buttons[i][j].setBackground(Color.YELLOW);
			}
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
			GameInterfaceV4Sho q = new GameInterfaceV4Sho();
			


		}
	});
	System.out.println();
}
}