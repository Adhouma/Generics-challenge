package com.learnJava;

public abstract class Player {

	private String name;
	private int number;
	
	// Constructor
	public Player(String name, int number) {
		this.name = name;
		this.number = number;
	}

	// Getters
	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}
	
}
