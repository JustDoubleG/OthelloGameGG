import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class AdminPage {

	public AdminPage() {
		
		JFrame adminPage = new JFrame("Set Parameters");
		adminPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminPage.getContentPane().setLayout(null);
		adminPage.setSize(800, 500);
		adminPage.setVisible(true);
		
		
		
	}
	
	public static void main(String[] args) {
		AdminPage a = new AdminPage();
	}
	
}
