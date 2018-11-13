import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class login {
	//dummyplayer will take the info from a player passed to the function to check if the login is correct
	private static PlayerV3 dummyPlayer = new PlayerV3("Username","Password");
	private static String dummyUname = "Username", dummyPwd= "Password";
	private static int success;
	
	public login(PlayerV3 dummyPlayer) {
		
	}
	
	public static void main(String[] args){ 
		/*UI stuff for Sai and Sho to figure out
		JFrame log = new JFrame("Login");
		log.setBounds(200, 200, 200, 200);
		log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		log.getContentPane().setLayout(null);
		
		//Set the label for username text box
		JLabel name = new JLabel("Username: "); 
		name.setBounds(100, 100, 100, 100); //Temp values for the bounds
		log.getContentPane().add(name);
		
		//Set the label for password text box
		JLabel pwd = new JLabel("Password: "); 
		pwd.setBounds(100, 150, 150, 100); //Temp values for the bounds
		log.getContentPane().add(name);
		
		//Set the text field for username
		JTextField uname = new JTextField();
		uname.setBounds(150, 100, 100, 100);
		log.getContentPane().add(uname);
		uname.setColumns(10);
		
		//Set the text field for password
		JTextField pswd = new JTextField();
		pswd.setBounds(150, 150, 150, 100);
		log.getContentPane().add(pswd);
		pswd.setColumns(10);
		
		//Create the login button and its function
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//After the login button is pushed, get the text (More UI)
				//String.name = uname.getText();
				//String.pwd = pswd.getText();
				//Use the dummy player's login info that is passed to the method to check
				success = dummyPlayer.checkInfo(dummyUname, dummyPwd); 
				if (success == 1) {
				    System.out.println("Login Successful"); 
					//More UI options to show a dialog box saying successful and unsucessful
					//JOptionPane.showMessageDialog(null, "Login Successful", "InfoBox: " + "Success!", JOptionPane.INFORMATION_MESSAGE);
				}else {
					System.out.println("Login Unsuccessful"); 
					//JOptionPane.showMessageDialog(null, "Login Unsuccessful", "InfoBox: " + "Failure", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		*/
    //The dummyUname and dummyPwd will be what is inserted in the login UI, but for now, these are just some hardcoded values
		dummyPlayer.checkInfo(dummyUname, dummyPwd);
		success = dummyPlayer.getValidity();
		System.out.println(success);
		if (success == 1) {
		    System.out.println("Login Successful"); 
			//More UI options to show a dialog box saying successful and unsucessful
			//JOptionPane.showMessageDialog(null, "Login Successful", "InfoBox: " + "Success!", JOptionPane.INFORMATION_MESSAGE);
		}else {
			System.out.println("Login Unsuccessful"); 
			//JOptionPane.showMessageDialog(null, "Login Unsuccessful", "InfoBox: " + "Failure", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
