package com.learnJava;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>>{

	private String name;
	private int played = 0;
	private int won = 0;
	private int draw = 0;
	private int lost = 0;
	private ArrayList<T> members = new ArrayList<>();

	// Constructor
	public Team(String name) {
		this.name = name;
	}

	// Methods
	public boolean addPlayer(T player) {
		if (this.members.contains(player)) {
			System.out.println(player.getName() + " already picked for " + this.getName() + " team");
			return false;
		} else {
			this.members.add(player);
			System.out.println(player.getName() + " is picked for " + this.getName() + " team");
			return true;
		}
	}

	public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
		if (opponent != null) {
			if (ourScore > theirScore) {
				System.out.println(
						this.getName() + " won VS " + opponent.getName() + " score: " + ourScore + " - " + theirScore);
				this.won++;
				opponent.lost++;
			} else if (ourScore == theirScore) {
				System.out.println(
						this.getName() + " draw VS " + opponent.getName() + " score: " + ourScore + " - " + theirScore);
				this.draw++;
				opponent.draw++;
			} else {
				System.out.println(
						this.getName() + " lost VS " + opponent.getName() + " score: " + ourScore + " - " + theirScore);
				this.lost++;
				opponent.won++;
			}
			this.played++;
			opponent.played++;
		}
	}

	public int ranking() {
		return (this.won * 3) + this.draw;
	}
	
	@Override
	public int compareTo(Team<T> team) {
		if(this.ranking() > team.ranking()) {
			return -1;
		} else if(this.ranking() < team.ranking()) {
			return 1;
		} else {
			return 1;
		}
	}

	// Getters
	public String getName() {
		return name;
	}

	public int getPlayed() {
		return played;
	}

	public int getWon() {
		return won;
	}

	public int getDraw() {
		return draw;
	}

	public int getLost() {
		return lost;
	}

	public ArrayList<T> getMembers() {
		return members;
	}

}
