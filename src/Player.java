public class Player
{

	private int jersey;
	
	private String name;

	private int foul;

	private int onePoint;

	private int twoPoint;

	private int threePoint;


	private Player(){
		this.jersey = 0;
		this.name = "Unknown";
		this.foul = 0;
		this.onePoint = 0;
		this.twoPoint = 0;
		this.threePoint = 0;


	}
	
	public Player(int jersey) throws Exception
	{
		this();
		this.setJersey(jersey);
	}

	public Player(int jersey, String name) throws Exception
	{
		this();
		this.setName(name);
		this.setJersey(jersey);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) throws Exception
	{
		name = name.trim();
		
		if (name.isEmpty())
			throw new Exception("Player name can not be blank.");
			
		this.name = name;
	}

	public int jersey() {
		return this.jersey;
	}

	public void setJersey(int id) throws Exception
	{
		if (id < 0)
			throw new Exception("Jersey ID can not be negative.");
		
		this.jersey = id;
	}

	@Override
    public boolean equals(Object object)
	{
        
        if(!(object instanceof Player))
            return false;
        
        Player other = (Player)object;
        
       	if (this.jersey == other.jersey())
       		return true;
       	else
       		return false;
    }
	
	@Override
	public String toString(){
		return this.jersey + " " + this.name;}

	public int getFouls()
	{
		return this.foul;
	}


	public void foul()
	{
		foul++;
	}


	public int getPoints()
	{
		int totalPoints = this.onePoint + (this.twoPoint * 2) + (this.threePoint * 3);
		return totalPoints;
	}

	public int getOnePoint()
	{
		return this.onePoint;
	}

	public int getTwoPoint()
	{
		return this.twoPoint;
	}

	public int getThreePoint()
	{
		return this.threePoint;
	}

	public void shot(int shotType) throws Exception

	{
		switch (shotType) {
			case 1:
				onePoint++;
				break;

			case 2:
				twoPoint++;
				break;

			case 3:
				threePoint++;
				break;

			default:
				throw new Exception("Invalid shotType: " + shotType);


		}

	}

	public void displayStats()
	{

		System.out.println("#" + jersey+"  "+name+"       Fouls:"+ foul +  "   Points:" + this.getPoints());

	}


}

