package edu.neu.info6205.RankingSystem;

public class Driver {

	public static void main(String[] args) {

		//WinRatePrediction.demo();
		String record = "src/record.csv";
		String team = "src/team.csv";
		String process = "src/process.csv";
		Rank r = new Rank();
		r.LoadRecord(record);
		r.CreateTeam(team);
		r.LoadProcess(process);
		r.runGame();
		r.showResult();
		
	}

}
