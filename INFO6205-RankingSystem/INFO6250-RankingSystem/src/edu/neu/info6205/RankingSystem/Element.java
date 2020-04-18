package edu.neu.info6205.RankingSystem;

import java.util.List;
import java.util.Vector;

public class Element {

	public String fteam;
	public String lteam;
	public double fteamWinrate;
	public double lteamWinrate;
	public double drawrate;
	public List<Integer> frecord;
	
	public WinRatePrediction w;
	
	public Element(String s) {
		String[] line = s.split(",");
		fteam = line[0];
		lteam = line[1];
		frecord = new Vector<>();
		for(int i = 2; i < line.length; i++)
			frecord.add(Integer.parseInt(line[i]));
		fteamWinrate = 0.0;
		lteamWinrate = 0.0;
		drawrate = 0.0;
		w = new WinRatePrediction();
	}
	
	public void predictRate() {
		w.rateP(frecord);
		fteamWinrate = w.winrate;
		lteamWinrate = w.loserate;
		drawrate = w.drawrate;
	}
	
}
