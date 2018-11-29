

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ZLogin {
	//dummyplayer will take the info from a player passed to the function to check if the login is correct
		private static ZPlayer dummyPlayer1 = new ZPlayer("Username","Password");
		private static ZPlayer dummyPlayer2 = new ZPlayer("Username2","Password2");
		private  static String dummyUname, dummyPwd,dummyUname2,dummyPwd2;
		private static int success, compPlay;
		
		public ZLogin() {
			JFrame log = new JFrame("Login");
			//log.setSize(200, 200);
			log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			log.getContentPane().setLayout(null);
			
			
			
			//Set the label for username text box
			JLabel name = new JLabel("Username: "); 
			name.setLocation(27, 20);
			name.setSize(100, 25); //Temp values for the bounds
			log.getContentPane().add(name);
			
			//Set the label for password text box
			JLabel pwd = new JLabel("Password: "); 
			pwd.setLocation(27, 40);
			pwd.setSize(100, 25); //Temp values for the bounds
			log.getContentPane().add(pwd);
			
			JLabel player1 = new JLabel("Player 1");
			player1.setLocation(100,1);
			player1.setSize(100,25);
			log.getContentPane().add(player1);
			
			JLabel player2 = new JLabel("Player 2");
			player2.setLocation(250,1);
			player2.setSize(100,25);
			log.getContentPane().add(player2);
			
			JLabel adminLabel = new JLabel("Admin");
			adminLabel.setLocation(500, 1);
			adminLabel.setSize(100, 25);
			log.getContentPane().add(adminLabel);
			
			//Set the text field for username
			JTextField uname = new JTextField();
			uname.setLocation(100, 20);
			uname.setSize(100, 25);
			log.getContentPane().add(uname);
			uname.setColumns(10);
			
			//Set the text field for password
			JTextField pswd = new JTextField();
			pswd.setLocation(100, 40);
			pswd.setSize(100, 25);
			log.getContentPane().add(pswd);
			pswd.setColumns(10);
			
			JTextField uname2 = new JTextField();
			uname2.setLocation(250,20);
			uname2.setSize(100,25);
			log.getContentPane().add(uname2);
			uname2.setColumns(10);
			
			JTextField pswd2 = new JTextField();
			pswd2.setLocation(250,40);
			pswd2.setSize(100,25);
			log.getContentPane().add(pswd2);
			pswd2.setColumns(10);
			
			JTextField adminUname = new JTextField();
			adminUname.setLocation(500, 20);
			adminUname.setSize(100,25);
			log.getContentPane().add(adminUname);
			adminUname.setColumns(10);
			
			JTextField adminPswd = new JTextField();
			adminPswd.setLocation(500, 40);
			adminPswd.setSize(100, 25);
			log.getContentPane().add(adminPswd);
			adminPswd.setColumns(10);
			
			
			JButton guest = new JButton("Guest");
			
			
			
			JButton playVsComputer = new JButton("Player 1 Vs. Computer");

			JButton register = new JButton("Register");
			register.setLocation(300, 360);
			register.setSize(100, 25);
			log.getContentPane().add(register);
			
			JButton viewRecords = new JButton("View Records");
			viewRecords.setLocation(250, 400);
			viewRecords.setSize(200,25);
			log.getContentPane().add(viewRecords);
			
			JButton adminLogin = new JButton("Admin Login");
			adminLogin.setLocation(500,80);
			adminLogin.setSize(150, 25);
			log.add(adminLogin);

			log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			log.getContentPane().setLayout(null);
			log.setVisible(true);

			
			
			
			log.add(playVsComputer);
			playVsComputer.setSize(200, 25);
			playVsComputer.setLocation(100, 120);
			
			register.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Register r = new Register();
					log.dispose();
				}
			});
			
			adminLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//need to add log in requirements i.e. username password etc
					AdminPage a = new AdminPage();
					log.dispose();
					
				}
			});
			
			viewRecords.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ViewRecordsUI v = new ViewRecordsUI();
					log.dispose();
				}
			});
			
			playVsComputer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					
					
					
					 compPlay = 1;
					
					 dummyUname = uname.getText();
					 dummyPwd = pswd.getText();
					 
					 dummyUname2 = "Computer";
					 dummyPwd2 = "Computer";
					 
					 ZGameInterface game = new ZGameInterface(dummyUname, dummyPwd, dummyUname2,  dummyPwd2);
					log.dispose();
					//Use the dummy player's login info that is passed to the method to check
					 System.out.println(dummyPlayer1.getUsername());
					System.out.println(dummyPlayer1.getPassword());
					 System.out.println(dummyUname);
					 System.out.println(dummyPwd);
					//dummyPlayer.checkInfo(dummyUname, dummyPwd);
					//success = dummyPlayer.getValidity();
					//System.out.println(success);
					if ((dummyPlayer1.getUsername().equals(dummyUname))&&(dummyPlayer1.getPassword().equals(dummyPwd))) {
					    //System.out.println("Login Successful");
					    log.dispose();
					    //ZGameInterface.main(args);
						//More UI options to show a dialog box saying successful and unsucessful
						//JOptionPane.showMessageDialog(null, "Login Successful", "InfoBox: " + "Success!", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Login Unsuccessful", "InfoBox: " + "Failure", JOptionPane.ERROR_MESSAGE);
					
				}
				}
			});
			
			log.add(guest);
			guest.setSize(100, 25);
			guest.setLocation(100,160);
			guest.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						compPlay=0;
						dummyUname="Guest";
						dummyPwd = "Guest";
						dummyUname2 = "Computer";
						dummyPwd2 = "Computer";
						 
						ZGameInterface game = new ZGameInterface(dummyUname, dummyPwd, dummyUname2,  dummyPwd2);
						log.dispose();
					   // ZGameInterface.main(args);
				}
			});
			log.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			//Create the login button and its function
			JButton login = new JButton("Login and Play");
			
			log.add(login);
			login.setSize(250, 25);
			login.setLocation(100,80);
			log.setSize(800, 500);//Give it a size
		    log.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//Make it go away on close	    
		    log.setVisible(true);//Show the frame
			login.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					compPlay = 0;
					//After the login button is pushed, get the text (More UI)
					 dummyUname = uname.getText();
					 dummyPwd = pswd.getText();
					 
					 dummyUname2 = uname2.getText();
					 dummyPwd2 = pswd2.getText();
					try { 
					 if (Database.validatePlayer(dummyUname,dummyPwd) && Database.validatePlayer(dummyUname2, dummyPwd2)) {
						 JOptionPane.showMessageDialog(null, "success","success",JOptionPane.PLAIN_MESSAGE);
						 ZGameInterface game = new ZGameInterface(dummyUname, dummyPwd, dummyUname2,  dummyPwd2);
						 log.dispose();
					 } else if((!Database.validatePlayer(dummyUname,dummyPwd) && !Database.validatePlayer(dummyUname2, dummyPwd2))){
						 JOptionPane.showMessageDialog(null, "both players username or passwords are incorrect","error",JOptionPane.PLAIN_MESSAGE);

					 } 
					 else if(!Database.validatePlayer(dummyUname2, dummyPwd2)) {
						 JOptionPane.showMessageDialog(null, "player2 username or password incorrect","error",JOptionPane.PLAIN_MESSAGE);
					 } else if(!Database.validatePlayer(dummyUname,dummyPwd)){
						 JOptionPane.showMessageDialog(null, "player1 username or password incorrect","error",JOptionPane.PLAIN_MESSAGE);

					 }
					} catch(Exception e){
						System.out.println("Error worked");
					}
					
					
					
					//Use the dummy player's login info that is passed to the method to check
					 System.out.println(dummyPlayer1.getUsername());
					System.out.println(dummyPlayer1.getPassword());
					 System.out.println(dummyUname);
					 System.out.println(dummyPwd);
					
					//dummyPlayer.checkInfo(dummyUname, dummyPwd);
					//success = dummyPlayer.getValidity();
					//System.out.println(success);
					/*if ((dummyPlayer1.getUsername().equals(dummyUname))&&(dummyPlayer1.getPassword().equals(dummyPwd))) {
					    //System.out.println("Login Successful");
					    log.dispose();
					    
						//More UI options to show a dialog box saying successful and unsucessful
						//JOptionPane.showMessageDialog(null, "Login Successful", "InfoBox: " + "Success!", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Login Unsuccessful", "InfoBox: " + "Failure", JOptionPane.ERROR_MESSAGE);
					}*/
				}
			});
			
		}
		
		public static void main(String[] args){ 
			ZLogin z = new ZLogin();
		    }
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

		public static String Player1Name() {
			return dummyUname;
		}
	
		public static String Player2Name() {
			if(compPlay == 1)
				return "Computer";
			else 
				return dummyUname2;
		}
		//public static void 
		
	}
