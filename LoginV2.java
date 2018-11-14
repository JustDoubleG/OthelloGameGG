
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginV2 {
	//dummyplayer will take the info from a player passed to the function to check if the login is correct
	private static PlayerV4 dummyPlayer = new PlayerV4("Username","Password");
	private static String dummyUname, dummyPwd;
	private static int success;
	
	public LoginV2(PlayerV3 dummyPlayer) {
		
	}
	
	public static void main(String[] args){ 
		//UI stuff for Sai and Sho to figure out
		JFrame log = new JFrame("Login");
		log.setSize(200, 200);
		log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		log.getContentPane().setLayout(null);
		
		//Set the label for username text box
		JLabel name = new JLabel("Username: "); 
		name.setLocation(27, 20);
		name.setSize(86, 14); //Temp values for the bounds
		log.getContentPane().add(name);
		
		//Set the label for password text box
		JLabel pwd = new JLabel("Password: "); 
		pwd.setLocation(27, 40);
		pwd.setSize(86, 14); //Temp values for the bounds
		log.getContentPane().add(pwd);
		
		//Set the text field for username
		JTextField uname = new JTextField();
		uname.setLocation(100, 20);
		uname.setSize(86, 14);
		log.getContentPane().add(uname);
		uname.setColumns(10);
		
		//Set the text field for password
		JTextField pswd = new JTextField();
		pswd.setLocation(100, 40);
		pswd.setSize(86, 14);
		log.getContentPane().add(pswd);
		pswd.setColumns(10);
		
		//Create the login button and its function
		JButton login = new JButton("Login");
		
		log.add(login);
		login.setSize(86, 14);
		login.setLocation(60,60);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//After the login button is pushed, get the text (More UI)
				 dummyUname = uname.getText();
				 dummyPwd = pswd.getText();
				//Use the dummy player's login info that is passed to the method to check
				 System.out.println(dummyPlayer.getUsername());
				 System.out.println(dummyPlayer.getPassword());
				 System.out.println(dummyUname);
				 System.out.println(dummyPwd);
				//dummyPlayer.checkInfo(dummyUname, dummyPwd);
				//success = dummyPlayer.getValidity();
				//System.out.println(success);
				if ((dummyPlayer.getUsername()==dummyUname)&&(dummyPlayer.getPassword()==dummyPwd)) {
				    //System.out.println("Login Successful");
				    log.dispose();
				    GameInterfaceV7.main(args);
					//More UI options to show a dialog box saying successful and unsucessful
					//JOptionPane.showMessageDialog(null, "Login Successful", "InfoBox: " + "Success!", JOptionPane.INFORMATION_MESSAGE);
				}else {
					//System.out.println("Login Unsuccessful"); 
					JOptionPane.showMessageDialog(null, "Login Unsuccessful", "InfoBox: " + "Failure", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		log.setSize(600, 600);//Give it a size
	    log.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//Make it go away on close
//	    JPanel panel = new JPanel();//Make a panel
//	    frame.add(panel);//Add it to your frame

	    //JLabel label = new JLabel("Hello StackOverflow!");//Make a label
	    //panel.add(label);//Add it to the panel (which is on the frame)

	    log.setVisible(true);//Show the frame
    //The dummyUname and dummyPwd will be what is inserted in the login UI, but for now, these are just some hardcoded values
	    /*
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
	*/
		}
}
