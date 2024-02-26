public class Main {
    public static void main(String[] args) throws Exception
    {
        try
        {
            Player p1 = new Player(1);
            Player p2 = new Player(2, "Hines");
            System.out.println(p1);
            System.out.println(p2);
            p1.foul();
            System.out.println(p1.getFouls());
            System.out.println(p1.getPoints());
           p1.shot(1);
            p1.shot(2);


            p1.displayStats();







            if(p1.equals(p2))
            {
                System.out.println("True");
            }
            else
            {
                System.out.println("False");
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }



    }
}