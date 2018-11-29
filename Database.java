/*
 * Database.Java
 * Sola Adekunle
 * Database.java
 * November 28, 2018
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
	private static String playerfile = "players.txt";
	private static String adminFile = "admins.txt";
	private static String gamesFile = "games.txt";
	
	public static void init () {
		File pFile = new File(playerfile);
		File aFile = new File(adminFile);
		File gFile = new File(gamesFile);
		pFile.delete();
		aFile.delete();
		gFile.delete();
	}
	
	public static void addPlayer(ZPlayer player) throws IOException { 
		if (! Database.playerExists(player.getUsername())) {
			File outputFile = new File(playerfile);
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true));
			bw.write(player.getUsername()); bw.newLine();
			bw.write(player.getPassword()); bw.newLine();
			bw.close(); 
		}
	}

	public static boolean validatePlayer(String username, String password) throws ClassNotFoundException, IOException {
		String un, pw = null;
		FileReader reader = new FileReader(playerfile);
		BufferedReader bufferedReader = new BufferedReader(reader);
		while (true) {
			un = bufferedReader.readLine().trim();
			if (un == null)
				return false;
			pw = bufferedReader.readLine().trim();
			if (username.equals(un)) {
				return password.equals(pw);
			}
		}
	}
	
	public static boolean validateAdmin (String username, String password) throws IOException {
		 File file = new File(adminFile); 
		 String adminUsername = null, adminPassword = null;
		 BufferedReader br = new BufferedReader(new FileReader(file));
		 
		 username = br.readLine();
		 password = br.readLine();
		 
		 return (username.equals(adminUsername) && password.equals(adminPassword));
	}
	
	private static boolean playerExists (String username) throws IOException {
		File file = new File(playerfile);
		if (!file.exists()) 
			return false;
		
		String un, pw = null;
		FileReader reader = new FileReader(playerfile);
		BufferedReader bufferedReader = new BufferedReader(reader);
		while (true) {
			un = bufferedReader.readLine();
			if (un == null) 
				return false;
			pw = bufferedReader.readLine().trim();
			if (username.equals(un)) {
				return true;
			}
		}
	}
	
	public static void addGame(Game aGame) throws IOException {
		File outputFile = new File(gamesFile);
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true));
		bw.write(aGame.getPlayer1());  bw.newLine();
		bw.write(aGame.getPlayer2());  bw.newLine();
		bw.write(aGame.getP1Score());  bw.newLine();
		bw.write(aGame.getP2Score());  bw.newLine();
		bw.write(aGame.getVictor());  bw.newLine();
		bw.close(); 
	}
	
	public static ArrayList<Game> getGames() throws FileNotFoundException {
		ArrayList<Game> games = new ArrayList<Game> ();
		File file = new File(gamesFile); 
	    Scanner sc = new Scanner(file);
	    String player1, player2, victor;
	    int score1, score2;
	    while(sc.hasNext()) {
	    	player1 = sc.next();
	    	player2 = sc.next();
	    	score1 = sc.nextInt();
	    	score2 = sc.nextInt();
	    	victor = sc.next();
	    	Game aGame =  new Game(player1, player2, victor, score1, score2);
	    	games.add(aGame);
	    }
	    
		return games; 	
	}
	
	public static void main (String[] args) {
		Database.init();
		ZPlayer p = new ZPlayer("foo", "bar");
		ZPlayer p2 = new ZPlayer("test", "bar");
		try {
			Database.addPlayer(p);
			Database.addPlayer(p2);
			Database.addPlayer(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(Database.validatePlayer("test", "foo"));
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
