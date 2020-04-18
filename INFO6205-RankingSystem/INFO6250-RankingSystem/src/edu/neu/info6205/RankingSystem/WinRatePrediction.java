package edu.neu.info6205.RankingSystem;

import java.util.List;
import java.util.Vector;

public class WinRatePrediction {
	public double winrate;
	public double loserate;
	public double drawrate;
	public static final double e = Math.E;
	
	public double getPH(double x, double n) {
		double l = 1.0;
		if(x != 0.0)
			for(double i = 1.0; i <= x; i+=1.0)
				l = l * i;
		return Math.pow(n, x) * Math.pow(e, -1*n) / l;
	}
	
	public void rateP(List<Integer> num) {
		double sum2 = 0;
		double sum1 = 0;
		double sum0 = 0;
		
		for(Integer i : num)
		{
			if(i == 2)
				sum2 += 1.0;
			else if(i == 1)
				sum1 =+ 1.0;
			else
				sum0 += 1.0;
		}
		
		double mean = (sum2 + sum1 + sum0) / 3;
		double winh = 0.0;
		double drawh = 0.0;
		double loseh = 0.0;
		for(double i = 0.0; i <= sum2; i += 1.0)
		{
			winh += getPH(i, mean);
		}
		for(double i = 0.0; i <= sum1; i += 1.0)
		{
			drawh += getPH(i, mean);
		}
		for(double i = 0.0; i <= sum0; i += 1.0)
		{
			loseh += getPH(i, mean);
		}
		winrate = winh / (winh + drawh + loseh);
		drawrate = drawh / (winh + drawh + loseh);
		loserate = loseh / (winh + drawh + loseh);
	}
	
	public static void demo() {
		int[] a = {2,0,2,0,2,0,2,0,2,0,2,0,2,0,2,0,2,0,1,1,1,1,1,1,1,1,1,1,1,1,1};
		WinRatePrediction w = new WinRatePrediction();
		//w.rateP(a);
		System.out.println(w.winrate);
		System.out.println(w.drawrate);
		System.out.println(w.loserate);
	
	}
}
