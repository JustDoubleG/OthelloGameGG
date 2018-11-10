// Author: Sai Chand Reddy Bussu
// Modified on 11/05/2018
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.MatteBorder;
import javax.swing.Timer;

public class GameInterfaceV6 extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton[][] buttons;
	//private squareboxv[][] board;
	//replace squareboxv with your current square
  //Initialize the timer variables and objects
	static Timer play1timer;
	static Timer play2timer;
	static java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("mm:ss");
	static long defTime = 1200000;
	//testboardv testBoard = new testboardv();
  //replace testboardv with your current version
	public GameInterfaceV6() {//Unknown
		
		initUI();
		this.setVisible(true);
	}

	public GameInterfaceV6(SquareBoxV2[][] board) {//unknown
		this.setBoard(board);
		initUI();
		this.setVisible(true);
	}

	public void initUI() {
		panel = new JPanel();//Overall window
		panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));//White Boarder part of panel
		panel.setBorder(new MatteBorder(15,15,15,15, Color.WHITE)); // boarder color
		GridLayout newGrid = new GridLayout(8,8,2,2);// 8x8 2x2 between squares
		panel.setLayout(newGrid);//.setCenter .setLayoutCenter??
		panel.setBackground(new Color(169,169,169)); //Grey color between white tiles
		
		this.buttons = new JButton[8][8];
		this.board = new SquareBoxV2[8][8];
		
		
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
		setTitle("GG");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

  //Testboard is sean's code, so don't mind the errors
	public void updateButUI() {
		for (int i = 0; i < 8; i++) {//Sean
			for (int j = 0; j < 8; j++) {
				if(testBoard.getValue(i, j) == 0) {
					this.buttons[i][j].setIcon(new ImageIcon("images/icon.png"));
					board[i][j]. setBoxValue(testBoard.getValue(i, j));
				}
				if(testBoard.getValue(i, j) == 1) {
					this.buttons[i][j].setIcon(new ImageIcon("images/BlackCircle.png"));
					board[i][j]. setBoxValue(testBoard.getValue(i, j));
				}
				if(testBoard.getValue(i, j) == 2) {
					this.buttons[i][j].setIcon(new ImageIcon("images/WhiteCircle.png"));
					board[i][j]. setBoxValue(testBoard.getValue(i, j));
				}
				if(testBoard.getValue(i, j) == 3) {
					this.buttons[i][j].setIcon(new ImageIcon("images/Yellow3.png"));
					board[i][j]. setBoxValue(testBoard.getValue(i, j));
				}
			}
		}
	}
	
	public void setBoard(SquareBoxV2[][] board) {
		this.board = board;
	}

	//The code for the actual timer (player 1)
	JLabel time1 = new JLabel(dateFormat.format(new Date(defTime)), JLabel.CENTER);
	//After creating the label, create the actual timer
	play1Timer = new Timer(1000, new ActionListener(){
		//Subtract 1000 milliseconds from the 20 minute(defTime) varible
		long secondSubtract = defTime - 1000;
		public void actionPerformed(ActionEvent e){
			//rewrite the time in the format with one second gone
			play1Timer.setText(dateFormat(new Date(secondSubtract)));
			//Subtract another second
			secondSubtract -= 1000;
		}
	});
	
	//The code for the actual timer (player 2)
	JLabel time2 = new JLabel(dateFormat.format(new Date(defTime)), JLabel.CENTER);
	
	play2Timer = new Timer(1000, new ActionListener(){
		long secondSubtract = defTime - 1000;
		public void actionPerformed(ActionEvent e){
			play2Timer.setText(dateFormat(new Date(secondSubtract)));
			secondSubtract -= 1000;
		}
	});
	
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				if (buttons[i][j] == e.getSource()) {
					
				}
			}
		}
	}

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GameInterfaceV6 q = new GameInterfaceV6();
				
				//updateUI();
			}
		});
		System.out.println();
	}
	
}
