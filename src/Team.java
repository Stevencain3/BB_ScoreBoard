/*
Authors: Hines and Steven
URL: https://github.com/Stevencain3/BB_ScoreBoard.git

This class creates a home and an away team, assigns players to each team. Has error handling for equal jersey
numbers within the same team. However, equal jersey numbers can be created on different teams. The team class
stores each teams collective points and fouls. And displays team statistics.

 */

import java.util.ArrayList;
import java.util.List;

public class Team {

	private String name;
	private List<Player> allPlayers;

	public Team()
	{
		this.name = "Unknown";
		allPlayers = new ArrayList<Player>();
	}
	
	public Team(String name) throws Exception
	{
		this();
		this.setName(name);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) throws Exception
	{
		name = name.trim();

		if (name.isEmpty())
			throw new Exception("Student name can not be blank.");

		this.name = name;
	}
	
	public Player getPlayer(int jersey) throws Exception
	{
		
		int index = this.allPlayers.indexOf(new Player(jersey));
		
		if (index == -1)
			return null;
		else
			return this.allPlayers.get(index);
	}

	public void addPlayer(int jersey, String name) throws Exception
	{
		Player player = this.getPlayer(jersey);

		if (player == null)
		{
			this.allPlayers.add(new Player(jersey, name));
		}
		else
		{
			throw new Exception("Seat: " + jersey + " is already assigned to this course " + player.getName() + "!");
		}
	}

	public int getTeamFouls()
	{
		int totalFouls = 0;
	
		for (int i = 0; i < this.allPlayers.size(); i++)
		{
			totalFouls += this.allPlayers.get(i).getFouls();
		}
		
		return totalFouls;
	}

	public int getTeamPoints()
	{
		int totalPoints = 0;

		for (int i = 0; i < this.allPlayers.size(); i++)
		{
			totalPoints += this.allPlayers.get(i).getPoints();
		}

		return totalPoints;
	}


	public void displayTeamStats()
	{

		System.out.printf(this.name);
		System.out.print(" fouls =" + this.getTeamFouls());
		System.out.print(" points =" + this.getTeamPoints());
	}

	public void displayDetailStats()
	{

		displayTeamStats();

		System.out.println();
		System.out.println(" Jersey    Name     Fouls  1pt 2pt 3pt Total");
		System.out.println("======== =========  =====  === === === =====");

    	for(int i = 0; i < allPlayers.size(); i++)
		{
    		System.out.printf("%4d %11s %6d %5d %3d %3d %4d \n",
    				this.allPlayers.get(i).jersey(),
					this.allPlayers.get(i).getName(),
					this.allPlayers.get(i).getFouls(),
					this.allPlayers.get(i).getOnePoint(),
					this.allPlayers.get(i).getTwoPoint(),
					this.allPlayers.get(i).getThreePoint(),
					this.allPlayers.get(i).getPoints());
		}
    	
    	System.out.println();
	}

	@Override
	public String toString(){
		return this.name;
	}

} 
