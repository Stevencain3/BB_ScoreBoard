public class Main {
    public static void main(String[] args) throws Exception
    {
        try
        {

/*
            Player p1 = new Player(1,"Steven");
            Player p2 = new Player(2, "Hines");
            System.out.println(p1);
            System.out.println(p2);
            p1.foul();
            System.out.println(p1.getFouls());
            System.out.println(p1.getPoints());
           p1.shot(1);
            p1.shot(2);
*/
            Team T1=new Team("T1");
            T1.addPlayer(3, "Steven");
           Player p1 = T1.getPlayer(3);
            p1.shot(3);

            Team T2=new Team("T2");
            T2.addPlayer(1, "Hines");
            Player p2 = T2.getPlayer(1);
            p2.shot(2);
            p2.foul();


            T1.displayDetailStats();


            T2.displayDetailStats();





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