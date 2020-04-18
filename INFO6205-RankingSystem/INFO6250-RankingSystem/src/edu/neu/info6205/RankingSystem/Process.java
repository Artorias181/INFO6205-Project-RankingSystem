package edu.neu.info6205.RankingSystem;

public class Process {

	public String team1;
	public String team2;
	
	public Process(String s) {
		String[] line = s.split(",");
		team1 = line[0];
		team2 = line[1];
	}
}
