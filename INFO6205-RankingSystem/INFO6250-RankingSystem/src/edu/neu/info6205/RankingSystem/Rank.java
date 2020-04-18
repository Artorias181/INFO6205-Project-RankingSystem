package edu.neu.info6205.RankingSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

public class Rank implements Comparator<Team>{
	public List<Element> record = new Vector<>();;
	public List<Team> game = new Vector<>();
	public List<Process> process = new Vector<>();
	
	public void LoadRecord(String recordpath) {
		File IRfile = new File(recordpath);
		
		if(IRfile.exists())
		{
			if(IRfile.length() != 0)
			{
				FileReader IRfr = null;
				try {
					IRfr = new FileReader(IRfile);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				BufferedReader IRbr = new BufferedReader(IRfr);
				String rline;
				try {
					while ((rline = IRbr.readLine()) != null) {
						Element e = new Element(rline);
						record.add(e);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					IRbr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					IRfr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else
				System.out.println("Empty recordfile!!!");
		}
		else
			System.out.println("Recordfile doesn't exist!!!");
	}
	
	public void CreateTeam(String teampath) {
       File IRfile = new File(teampath);
		
		if(IRfile.exists())
		{
			if(IRfile.length() != 0)
			{
				FileReader IRfr = null;
				try {
					IRfr = new FileReader(IRfile);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				BufferedReader IRbr = new BufferedReader(IRfr);
				String rline;
				try {
					while ((rline = IRbr.readLine()) != null) {
						Team t = new Team(rline);
						game.add(t);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					IRbr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					IRfr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else
				System.out.println("Empty teamfile!!!");
		}
		else
			System.out.println("Teamfile doesn't exist!!!");
	}
	
	public void LoadProcess(String processpath) {
        File IRfile = new File(processpath);
		
		if(IRfile.exists())
		{
			if(IRfile.length() != 0)
			{
				FileReader IRfr = null;
				try {
					IRfr = new FileReader(IRfile);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				BufferedReader IRbr = new BufferedReader(IRfr);
				String rline;
				try {
					while ((rline = IRbr.readLine()) != null) {
						Process p = new Process(rline);
						process.add(p);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					IRbr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					IRfr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else
				System.out.println("Empty processfile!!!");
		}
		else
			System.out.println("Processfile doesn't exist!!!");
	}
	
	public double ThreeValueCompair(double d1, double d2, double d3) {
		double max = d1 > d2 ? d1 : d2;
		max = max > d3 ? max : d3;
		return max;
	}
	
	public void runGame() {
		for(Process p : process)
		{
			for(Element e : record)
			{
				if(p.team1.equals(e.fteam)&&(p.team2.equals(e.lteam)))
				{
					e.predictRate();
					double max = this.ThreeValueCompair(e.fteamWinrate, e.lteamWinrate, e.drawrate);
					if(max == e.fteamWinrate)
					{
						for(Team t : game)
						{
							if(t.teamName.equals(e.fteam))
								t.addscore(3);
							if(t.teamName.equals(e.lteam))
								t.addscore(0);
						}
					}
					else if(max == e.lteamWinrate)
					{
						for(Team t : game)
						{
							if(t.teamName.equals(e.fteam))
								t.addscore(0);
							if(t.teamName.equals(e.lteam))
								t.addscore(3);
						}
					}
					else
					{
						for(Team t : game)
						{
							if(t.teamName.equals(e.fteam))
								t.addscore(1);
							if(t.teamName.equals(e.lteam))
								t.addscore(1);
						}
					}
				}
			}
		}
	}
	public void showResult() {
		Collections.sort(game, new Rank());
		int i = 1;
		for(Team t : game)
		{
			System.out.println(i + ". " + t.teamName + ", " + t.totalScore);
			i += 1;
		}
	}

	@Override
	public int compare(Team o1, Team o2) {
		return o2.totalScore < o1.totalScore ? -1 : o1.totalScore == o2.totalScore ? 0 : 1;
	}
	
}
