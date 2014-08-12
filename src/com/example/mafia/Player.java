package com.example.mafia;

public class Player {

	private String name;
	private int votes;

	public String getName() {
		return name;
	}

	public int getVotes() {
		return votes;
	}
	
	public Player(String name){
		this.name = name;
		this.votes = 0;
	}
	
	public Player() {
		
	}

	public void addVote(){
		votes++;
	}

	

}
