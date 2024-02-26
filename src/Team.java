import java.util.ArrayList;
import java.util.List;

public class Team {

	private String name;
	private List<Player> allPlayers;

	public Team() {
		this.name = "Unknown";
		allPlayers = new ArrayList<Player>();
	}
	
	public Team(String name) throws Exception {
		this();
		this.setName(name);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) throws Exception {
		name = name.trim();

		if (name.isEmpty())
			throw new Exception("Student name can not be blank.");

		this.name = name;
	}
	
	public Player getPlayer(int seat) throws Exception {
		
		int index = this.allPlayers.indexOf(new Player(seat));
		
		if (index == -1)
			return null;
		else
			return this.allPlayers.get(index);
	}

	public void addPlayer(int seat, String name) throws Exception {
		Player player = this.getPlayer(seat);

		if (player == null) {
			this.allPlayers.add(new Player(seat, name));
		} else {
			throw new Exception("Seat: " + seat + " is already assigned to this course " + player.getName() + "!");
		}
	}

	public int getTeamFouls() {
		int totalFouls = 0;
	
		for (int i = 0; i < this.allPlayers.size(); i++) {
			totalFouls += this.allPlayers.get(i).getFouls();
		}
		
		return totalFouls;
	}

	public int getTeamPoints() {
		int totalPoints = 0;

		for (int i = 0; i < this.allPlayers.size(); i++) {
			totalPoints += this.allPlayers.get(i).getPoints();
		}

		return totalPoints;
	}


	public void displayTeamStats() {
		System.out.printf(this.name);
		System.out.print(" fouls =" + this.getTeamFouls());
		System.out.print(" points =" + this.getTeamPoints());
	}

	public void displayDetailStats() {

		this.displayTeamStats();
		System.out.println();
		System.out.println("Seat   Name            Absent Excused Late OnTime");
		System.out.println("====== =============== ====== ======= ==== ======");
		
    	for(int i = 0; i < allPlayers.size(); i++) {
    		System.out.printf("%6d %-15s %6d %4d %7d %6d\n",
    				this.allPlayers.get(i).getSeat(),
					this.allPlayers.get(i).getName());
    	}
    	
    	System.out.println();
	}

	@Override
	public String toString(){
		return this.name;
	}

} 
