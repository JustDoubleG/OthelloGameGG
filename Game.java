/*
 * Database.Java
 * Sola Adekunle
 * Game.java
 * November 28, 2018
 */
public class Game {
	private String player1;
	private String player2;
	private String victor;
	private int p1Score;
	private int p2Score;
	
	public Game(ZBoard board) {
		this.setP1Score(board.getPlayer1().getScore());
		this.setP2Score(board.getPlayer2().getScore());
		this.setPlayer1(board.getPlayer1().getUsername());
		this.setPlayer2(board.getPlayer2().getUsername());
		this.setVictor(board.winner);
	}
	
	public Game(String player1, String player2, String victor, int p1Score, int p2Score) {
		super();
		this.player1 = player1;
		this.player2 = player2;
		this.victor = victor;
		this.p1Score = p1Score;
		this.p2Score = p2Score;
	}

	public String getPlayer1() {
		return player1;
	}
	public void setPlayer1(String player1) {
		this.player1 = player1;
	}
	public String getPlayer2() {
		return player2;
	}
	public void setPlayer2(String player2) {
		this.player2 = player2;
	}
	public String getVictor() {
		return victor;
	}
	public void setVictor(String victor) {
		this.victor = victor;
	}
	public int getP1Score() {
		return p1Score;
	}
	public void setP1Score(int p1Score) {
		this.p1Score = p1Score;
	}
	public int getP2Score() {
		return p2Score;
	}
	public void setP2Score(int p2Score) {
		this.p2Score = p2Score;
	}
}
