public class Player
{

	private int jersey;
	
	private String name;

	private Player(){
		this.jersey = 0;
		this.name = "Unknown";

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
		return this.jersey + " " + this.name;
	}
	
}
