// Author: Sai Chand Reddy Bussu
// Modified on 11/05/2018
package Othello;
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

public class GameInterfaceV4 extends JFrame implements ActionListener {
	static Player player1 = new Player("Black");
	static Player player2 = new Player("White");
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private static JButton[][] buttons;
	private SquareBox[][] board;
	public GameInterfaceV4() {//Unknown
		
		initUI();
		this.setVisible(true);
	}

	public GameInterfaceV4(SquareBox[][] board) {//unknown
		this.setBoard(board);
		initUI();
		this.setVisible(true);
	}

	public void takeTurn() {
		
	}
	public void initUI() {
		panel = new JPanel();
		
		BoardV4 testBoard = new BoardV4();
		
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
					this.buttons[i][j] = new JButton(" ");
					this.buttons[i][j].setIcon(new ImageIcon("images/icon.png"));
					panel.add(this.buttons[i][j]);
				}
				buttons[i][j].addActionListener(this);
				
			}
			panel.setVisible(true);
		}


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
					buttons[i][j].setBackground(Color.black);
				}
				if(logicMatrix[i][j] == 2) {
					buttons[i][j].setBackground(Color.white);
				}
				if(logicMatrix[i][j] == 3) {
					buttons[i][j].setBackground(Color.yellow);
				}
			}
		}
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
				GameInterfaceV4 q = new GameInterfaceV4();
				BoardV4.main();
				
				
			}
		});
		System.out.println();
	}
}