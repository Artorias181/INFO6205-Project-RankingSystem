package edu.neu.info6205.RankingSystem;

public class Team {

	public  String teamName;
	public int totalScore;
	
	public Team(String name, int score) {
		this.teamName = name;
		this.totalScore = score;
	}
	
	public Team(String s) {
		String[] line = s.split(",");
		this.teamName = line[0];
		this.totalScore = Integer.parseInt(line[1]);
	}
	
	public void addscore(int n) {
		totalScore += n;
	}
}
