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
	
	public Player(int seat) throws Exception
	{
		this();
		this.setSeat(seat);
	}

	public Player(int seat, String name) throws Exception
	{
		this();
		this.setName(name);
		this.setSeat(seat);
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

	public int getSeat() {
		return this.jersey;
	}

	public void setSeat(int id) throws Exception
	{
		if (id < 0)
			throw new Exception("Student ID can not be negative.");
		
		this.jersey = id;
	}

	@Override
    public boolean equals(Object object)
	{
        
        if(!(object instanceof Player))
            return false;
        
        Player other = (Player)object;
        
       	if (this.jersey == other.getSeat())
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
		return onePoint;
	}

	public int getTwoPoint()
	{
		return twoPoint;
	}

	public int getThreePoint()
	{
		return threePoint;
	}


}

