public class BB_Scoreboard {

	private final static String DOUBLE_LINE = "==================================================";
	private final static String SINGLE_LINE = "--------------------------------------------------";

	Team home;
	Team away;

	public BB_Scoreboard() {
		home = new Team();
		away = new Team();
	}

    private void displayAppHeading() {
    	
		System.out.println(DOUBLE_LINE);
		System.out.println("Welcome to the Basket Ball Stats App");
		System.out.println(DOUBLE_LINE);
		System.out.println();
		
    }

    private void setupTeams() throws Exception {

		String teamName = "Unknown";

		teamName = Input.getLine("Enter the first teams name: ");
		this.home.setName(teamName);
		this.setupPlayers(this.home);

		System.out.println();

		teamName = Input.getLine("Enter the second teams name: ");
		this.away.setName(teamName);
		this.setupPlayers(this.away);
    }
    
    private void setupPlayers(Team team) {
    	String teamName = team.getName();
    	String playerName = null;
    	int jersey = 0;

    	while (true) {
			System.out.println();
			playerName = Input.getLine("Enter " + teamName + " player's name or 'q' to quit: ");
			
			if (playerName.equals("q"))
				return;
			
			try {
				jersey = Input.getIntRange("Enter " + playerName + " Jersey number: ", 0, 55);
				team.addPlayer(jersey, playerName);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Unable to add Player!");
			}
			
    	}
		    	
    }
    
    private void playGame() throws Exception {
    	
    	boolean keepLooping = true;
    	int userInput = 0;
    	
    	System.out.println();
    	System.out.println(DOUBLE_LINE);    	
    	System.out.println("Recording Game Stats!");
    	System.out.println(DOUBLE_LINE);
    	System.out.println();
    	
    	while (keepLooping) {
    		
    		System.out.println(SINGLE_LINE);
    		System.out.println("Main Menu");
    		System.out.println(SINGLE_LINE);
    		
    		System.out.println("0 = End Game");
    		System.out.println("1 = Enter " + home.getName() + " Teams Stats");
    		System.out.println("2 = Enter " + away.getName() + " Teams Stats");
    		System.out.println("3 = Display Game Stats");
    		
    		System.out.println(SINGLE_LINE);
    		userInput = Input.getIntRange("Menu Choice: ", 0, 3);
    		System.out.println(SINGLE_LINE);
    		
    		System.out.println();
    		
    		switch (userInput) {
    		case 0:
    			keepLooping = false;
        		System.out.println();
        		break;
        		
    		case 1:
				this.updateTeamStats(home);
				break;
				
    		case 2:
   				this.updateTeamStats(away);
        		break;
        		
    		case 3:
    			this.displayGameStatus();
    			break;
    			
    		default:
    			System.out.println("Invalid menu choice = " + userInput);
    			
    		} 
    	}

    }
    
    private void updateTeamStats(Team team) throws Exception {

    	int jersey = 0;
    	Player player;
    	
		while (true) {
			jersey = Input.getIntRange("Enter " + team.getName() + "'s Jersey Number or 0 to quit: ", 0, 55);

			if (jersey == 0)
				break;

			player = team.getPlayer(jersey);
			
			if (player == null) {
				System.out.println("Invalid jersey, please try again!");
				continue;
			}
			
			this.updatePlayerStats(player);
			
		}
			
		System.out.println();
		System.out.println(SINGLE_LINE);
		team.displayTeamStats();
		System.out.println(SINGLE_LINE);
		System.out.println();

	}
    
    private void updatePlayerStats(Player player) throws Exception {
    	int status = 0;

		System.out.println();
		
		System.out.println(SINGLE_LINE);
		System.out.println("Enter #" + player.jersey() + " " + player.getName() + " Points");
		System.out.println(SINGLE_LINE);
		
		System.out.println("1 = Foul");
		System.out.println("2 = Free Throw");
		System.out.println("3 = Two Pointer");
		System.out.println("4 = Three Pointer");
		
		System.out.println(SINGLE_LINE);
		status = Input.getIntRange("Enter Status: ", 1, 4);
		System.out.println(SINGLE_LINE);
		
		switch(status) {
			case 1:
				player.foul();
				break;
			case 2:
				player.shot(1);
				break;
			case 3:
				player.shot(2);
				break;
			case 4:
				player.shot(3);
				break;
			default:
				throw new Exception("Invalid player status!");
		}

		player.displayStats();
		System.out.println();
    }
    
    private void updateScoreboard() {

 		home.displayTeamStats();
    	away.displayTeamStats();

    }
	private void displayGameStatus() {

		home.displayDetailStats();
		away.displayDetailStats();

	}


	public static void main(String[] args) throws Exception {

		BB_Scoreboard app = new BB_Scoreboard();
		
		app.displayAppHeading();
		
		try {
			app.setupTeams();
			app.playGame();
			app.updateScoreboard();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Sorry but this program ended with an error. Please contact Steven or Hines plz!");
		}
		
		Input.sc.close();
		
	} 
	
} 
