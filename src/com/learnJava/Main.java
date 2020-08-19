package com.learnJava;

public class Main {
	/**
	 * Create a generic class to implement a league table for a sport.
	 * The class should allow teams to be added to the list, and store a list of teams that belong to the league.
	 * 
	 * Your class should have a method to print out the teams in order,
	 * with the team at the top of the league printed first.
	 * 
	 * Only teams of the same sport should be added to any particular instance of the league class 
	 * (the program should fail to compile) if an attempt is made to add an incompatible team.
	 */
	public static void main(String[] args) {
		// NBA Team
		System.out.println("/*--- NBA Team ---*/");
		BasketballPlayer lebron = new BasketballPlayer("LeBron James", 23);
		BasketballPlayer curry = new BasketballPlayer("Stephen Curry", 30);
		BasketballPlayer kobe = new BasketballPlayer("Kobe Bryant", 24);
		
		Team<BasketballPlayer> nba = new Team<>("NBA");
		nba.addPlayer(lebron);
		nba.addPlayer(curry);
		nba.addPlayer(kobe);
		
		// FC Barcelone Team
		System.out.println("/*--- FC Barcelone Team ---*/");
		FootballPlayer messi = new FootballPlayer("Lionel Messi", 10);
		FootballPlayer iniesta = new FootballPlayer("Andrés Iniesta", 8);
		FootballPlayer stegen = new FootballPlayer("Marc-André ter Stegen", 1);
		
		Team<FootballPlayer> barcelone = new Team<>("FC Barcelone");
		barcelone.addPlayer(messi);
		barcelone.addPlayer(iniesta);
		barcelone.addPlayer(stegen);
		
		/**
		 * Error
		 * The method addPlayer(FootballPlayer) in the type Team<FootballPlayer> 
		 * is not applicable for the arguments (BasketballPlayer)
		 * 
		 * => Lebron is not a Footbal player
		 * barcelone.addPlayer(lebron);
		 */
		
		// Real Madrid Team
		System.out.println("/*--- Real MAdrid Team ---*/");
		FootballPlayer benzema = new FootballPlayer("Karim Benzema", 9);
		FootballPlayer modric = new FootballPlayer("Luka Modrić", 10);
		FootballPlayer courtois = new FootballPlayer("Thibaut Courtois", 13);
		
		Team<FootballPlayer> madrid = new Team<>("Real Madrid");
		madrid.addPlayer(benzema);
		madrid.addPlayer(modric);
		madrid.addPlayer(courtois);
		
		/**
		 * Error
		 * The method addPlayer(FootballPlayer) in the type Team<FootballPlayer> 
		 * is not applicable for the arguments (BasketballPlayer)
		 * 
		 * => kobe is not a Football player
		 * madrid.addPlayer(kobe);
		 */
		
		// Match results
		System.out.println("/*--- Match result ---*/");
		madrid.matchResult(barcelone, 2, 0);
		barcelone.matchResult(madrid, 0, 0);
		madrid.matchResult(barcelone, 0, 1);
		madrid.matchResult(barcelone, 0, 3);
		barcelone.matchResult(madrid, 1, 1);
		barcelone.matchResult(madrid, 5, 1);
		
		// Ranking
		System.out.println("/*--- Ranking ---*/");
		System.out.println(barcelone.getName() + " " + barcelone.ranking() + " points");
		System.out.println(madrid.getName() + " " + madrid.ranking() + " points");
		
		// League
		League<Team<FootballPlayer>> liga = new League<>("Liga BBVA");
		liga.addTeam(barcelone);
		liga.addTeam(madrid);
		/**
		 * The method addTeam(Team<FootballPlayer>) in the type League<Team<FootballPlayer>> 
		 * is not applicable for the arguments (Team<BasketballPlayer>)
		 * 
		 * => NBA is not a Footbal team
		 * liga.addTeam(nba);
		 */
		liga.showLeagueTable();
	}

}
