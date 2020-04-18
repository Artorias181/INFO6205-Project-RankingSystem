# INFO6205-Project-RankingSystem
This project predicts the win rate of any two teams in the EPL game based on the Poisson distribution, and simulates the unfinished game in 2020 due to the epidemic according to the win rate.
# Please refer to the PDF document for details.

The csv file needed by the program is stored in the src folder:
  # record.csv : 
        The first two columns are the team names, and from the third column are the historical records of the two teams, where "2" indicates the victory of team 1 (first column) (corresponding to the defeat of team 2), and "1" indicates two goals Team draw, "0" means team 1 (first column) failed (corresponding to team 2 win).
  # team.csv : 
        The first column is the team name and the second column is the points (win get 3 points, draw get 1 point, lose get 0 points)
  # process.csv : 
        This file contains two team names for each simulation game in each line.
        
  # The result will show the ranking of all participating teams in the simulation competition (from top to bottom).
