//author Ryall Edwards


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Register {
	
	public Register() {
		
	JFrame register = new JFrame("Register");
	register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	register.getContentPane().setLayout(null);
	register.setSize(800, 500);
	register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	register.getContentPane().setLayout(null);
	register.setVisible(true);
	
	JLabel name = new JLabel("Username: ");
	name.setLocation(27, 20);
	name.setSize(100, 25); //Temp values for the bounds
	register.getContentPane().add(name);
	
	JLabel pwd = new JLabel("Password: ");
	pwd.setLocation(27, 40);
	pwd.setSize(100, 25); //Temp values for the bounds
	register.getContentPane().add(pwd);
	
	JTextField uname = new JTextField();
	uname.setLocation(100, 20);
	uname.setSize(100, 25);
	register.getContentPane().add(uname);
	uname.setColumns(10);
	
	JTextField pswd = new JTextField();
	pswd.setLocation(100, 40);
	pswd.setSize(100, 25);
	register.getContentPane().add(pswd);
	pswd.setColumns(10);
	
	JButton regButton = new JButton("Register");
	register.add(regButton);
	regButton.setSize(100, 25);
	regButton.setLocation(100,80);
	regButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String username = uname.getText();
			String password = pswd.getText();
			ZPlayer newPlayer = new ZPlayer(username, password);
			try {
			Database.addPlayer(newPlayer);
			} catch (IOException e) {
				System.out.println("Unable to add player");
			}
			ZLogin login = new ZLogin();
			register.dispose();
			
		}
	});
	
	
	
	}
	
	public static void main(String[] args) {
		Register r = new Register();
	}
}