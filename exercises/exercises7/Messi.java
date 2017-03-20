package exercises7;

public class Messi {

	private String oppositeTeam;
	private int numGoals;
	private int totalNumGoals;
	private boolean recordBroken;
	private int totalRecords;
	
	public Messi(String oppositeTeam, int numGoals, boolean recordBroken, int totalRecords) {
		this.oppositeTeam = oppositeTeam;
		this.numGoals = numGoals;
		this.recordBroken = recordBroken;
		this.totalRecords = totalRecords;
		
	}
	
	public String getOppositeTeam() {
		return this.oppositeTeam;
	}
	
	public void setOppositeTeam(String oppositeTeam) {
		this.oppositeTeam = oppositeTeam;
	}
	
	public int getNumGoals() {
		return this.numGoals;
	}
	
	public void setNumGoals(int numGoals) {
		this.numGoals = numGoals; 
	}
	
	public int getTotalNumGoals() {
		return totalNumGoals;
	}

	public void setTotalNumGoals(int totalNumGoals) {
		this.totalNumGoals = this.numGoals + totalNumGoals;
	}
	
	public boolean isRecordBroken() {
		return recordBroken;
	}

	public void setRecordBroken(boolean recordBroken) {
		this.recordBroken = recordBroken;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public static void main(String[] args) {

		Messi match1 = new Messi("Real Madrid", 4, true, 34);
		Messi match2 = new Messi("Atletico Madrid", 3, true, 35);
		if(match1.isRecordBroken()) {
			match1.setTotalRecords(match1.totalRecords+1);
		}

		if(match2.isRecordBroken()) {
			match2.setTotalRecords(match2.totalRecords+1);
		}
		
		match1.setTotalNumGoals(411);
		System.out.println("Messi scored " +match1.getNumGoals()+
				" in Barcelona vs " +match1.getOppositeTeam()+
				". \n He has now scored " +match1.getTotalNumGoals()+
				" in total with " +match1.getTotalRecords()+ 
				" records in his name.\n");
		
		match2.setTotalNumGoals(match1.getTotalNumGoals());
		System.out.println("Messi scored " +match2.getNumGoals()+
				" in Barcelona vs " +match2.getOppositeTeam()+
				".\n He has now scored " +match2.getTotalNumGoals()+
				" in total with " +match2.getTotalRecords()+ 
				" records in his name.");		
	}

}
