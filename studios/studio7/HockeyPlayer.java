package studio7;

public class HockeyPlayer {

	private String playerName;
	private int jerseyNum;
	private int numGoals;
	private int numAssists;
	private int numPoints;
	private int numGamesPlayed;
	private String shootLeftRightBoth;
	private String leftOrRightHanded;
	
	public HockeyPlayer(String playerName, int jerseyNum, 
			int numGoals, int numAssists, int numGamesPlayed,
		String shootLeftRightBoth, String leftOrRightHanded) {
 		this.playerName = playerName;
		this.jerseyNum = jerseyNum;
		this.numGoals = numGoals;
		this.numAssists = numAssists;
		this.numGamesPlayed = numGamesPlayed;		
		this.shootLeftRightBoth = shootLeftRightBoth;
		this.leftOrRightHanded = leftOrRightHanded;	
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public int getJerseyNum() {
		return jerseyNum;
	}

	public void setJerseyNum(int jerseyNum) {
		this.jerseyNum = jerseyNum;
	}

	public int getNumGoals() {
		return numGoals;
	}

	public void setNumGoals(int numGoals) {
		this.numGoals = numGoals;
	}

	public int getNumAssists() {
		return numAssists;
	}

	public void setNumAssists(int numAssists) {
		this.numAssists = numAssists;
	}

	public int getNumPoints() {
		numPoints = numGoals + numAssists;
		return numPoints;
	}

	public void setNumPoints(int numGoals, int numAssists) {
		this.numPoints = numGoals + numAssists;
	}

	public int getNumGamesPlayed() {
		return numGamesPlayed;
	}

	public void setNumGamesPlayed(int numGamesPlayed) {
		this.numGamesPlayed = numGamesPlayed;
	}
	
	public String getShootLeftRightBoth() {
		return shootLeftRightBoth;
	}

	public String getLeftOrRightHanded() {
		return leftOrRightHanded;
	}

	public void recordGameStats(int numGoals, int numAssists) {
		this.numGoals = this.numGoals + numGoals;
		this.numAssists = this.numAssists + numAssists;
	}

}
