package easy;

/**
 * @author Brandon Soledad
 * 
 * Algorithms Practice
 * 
 * There's an algorithms tournament taking place in which teams of programmers compete against each other to solve
 * algorithmic problems as fast as possible. Teams compete in a round robin, where each team faces off agaisnt all other teams.
 * Only two teams compete aginst each other at a time, and for each competition, one team is designated to the home team, while the
 * other team is the away team. In each competition there's always one winner and one loserk there are no ties. A team receives 3 points
 * if it wins and 0 points if it loses. The winner of the tournament is the team that receives the most amount of points.
 * 
 * Given an array of pairs representing the teams that have competed against each other and an array containing the results of each
 * competition, write a function that returns the winner of the tournament. The input arrays are named "competitions" and "results",
 * respectively. The "competitions" array has elements in the form of [homeTeam, awayTeam], where each team is a string of at most
 * 30 characters representing the name of team. The "results" array contains information about the winner of each corresponding competition 
 * in the "competitions" array. Specifically, "results[i]" denotes the winner of the "competitions[i]", where a 1 in the "results"
 * array means that the home team in the corresponding competition won and a 0 means that the away team won.
 * 
 * It's guaranteed that exactly oen team will win the tournament and that each team will compete against all other teams exactly once.
 * It's also guaanteed that the tournament will always have at least two teams.
 */

import java.util.*;

public class TournamentWinner {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> competitions = new ArrayList<ArrayList<String>>();
        ArrayList<String> competition1 = new ArrayList<String>(Arrays.asList("HTML", "C#"));
        ArrayList<String> competition2 = new ArrayList<String>(Arrays.asList("C#", "Python"));
        ArrayList<String> competition3 = new ArrayList<String>(Arrays.asList("Python", "HTML"));
        competitions.add(competition1);
        competitions.add(competition2);
        competitions.add(competition3);
        ArrayList<Integer> results = new ArrayList<Integer>(Arrays.asList(0, 0, 1));
        String expected = "Python";
        var actual = tournamentWinner(competitions, results);
        System.out.println(actual + " " + (expected == actual));
    }
    // Time O(n) Space:O(k) where n is the number of competitions and k is the number of teams
    public static String tournamentWinner(
      ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
    	HashMap<String, Integer> teamScore = new HashMap<String, Integer>();
			String best = "";
			teamScore.put(best,0);
		
			for(int i = 0; i < competitions.size(); i++){
				ArrayList<String> currentTeams = competitions.get(i);
				int result = results.get(i);
				String homeTeam = currentTeams.get(0);
				String awayTeam = currentTeams.get(1);
				String winner = (result == 1) ? homeTeam : awayTeam;
				if(!teamScore.containsKey(winner)) {
					teamScore.put(winner, 0);
				}
				teamScore.put(winner, teamScore.get(winner) + 3);
				if(teamScore.get(winner) > teamScore.get(best)){
					best = winner;
				}
			}	
    return best;
  }
}
