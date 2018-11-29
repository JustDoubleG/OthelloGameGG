import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

//Author: Sai Chand Reddy Bussu
//Modified on 11/05/2018
public class ZSquareBox extends JButton 
{
	private int row;
	private int column;
	private int boxValue;

	public ZSquareBox(String string, int row, int column, int value) {
		super(string);
		this.row = row; this.column = column;
		this.setValue(value);
		this.setBackground(Color.GREEN.darker());
	}
	
	public void updateIcon() {
		switch(this.boxValue) {
		case 0:
			this.setIcon(null);
			//this.setIcon(new ImageIcon("images/greenicon.png"));
			//this.setBackground(Color.GREEN);
			break;
		case 1:
			this.setIcon(new ImageIcon("images/blackicon.png"));
			break;
		case 2:
			this.setIcon(new ImageIcon("images/whiteicon.png"));
			break;
		case 3:
			this.setIcon(new ImageIcon("images/yellowicon.png"));
			break;
		}
	}
	
	public void setValue(int value) {
		this.boxValue = value;
		this.updateIcon();
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getColumn() {
		return this.column;
	}
  /*
  protected String pieceName;
 
  public SquareBox(String pieceName)
  {
      this.pieceName = pieceName;
  }
 
  public String toString()
  {
      return pieceName;
  }
  */
}