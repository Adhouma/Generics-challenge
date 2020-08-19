package com.learnJava;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {

	private String name;
	private ArrayList<T> league = new ArrayList<>();
	
	// Constructor
	public League(String name) {
		this.name = name;
	}
	
	// Methods
	public boolean addTeam(T team) {
		if(this.league.contains(team)) {
			System.out.println(team.getName() + " already in " + this.getName());
			return false;
		} else {
			this.league.add(team);
			return true;
		}
	}
	
	public void showLeagueTable() {
		Collections.sort(league);
		for(T team : league) {
			System.out.println(team.getName() + " " + team.ranking() + " points");
		}
	}

	// Getters
	public String getName() {
		return name;
	}

	public ArrayList<T> getTeams() {
		return league;
	}
	
}
