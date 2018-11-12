import javax.swing.*;

public class login {
	//dummyplayer will take the info from a player passed to the function to check if the login is correct
	PlayerV2 dummyPlayer = new PlayerV2();
	
	public static void main(String[] args){
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
				//After the login button is pushed, get the text
				String.name = uname.getText();
				String.pwd = pswd.getText();
				//Use the dummy player's login info that is passed to the method to check
				//if()
			}
		});
	}
}
