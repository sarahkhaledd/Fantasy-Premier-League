import java.io.IOException;
import java.util.Scanner;

public class Player 
{
	
	public void AddPlayer(PlayerInfo p) throws IOException 
	{  
		Data file =new Data();
	    String pi = p.position;
         switch(pi)
        { 
         case "goalkeepers" : 
        	 file.writeToGoalKeeprs(p);
        	 break;
         case "defenders" :
        	file.writeToDefenders(p);
        	break;
         case "midfielders" :
        	 file.writeToMidfielders(p);
        	 break;
         case "forwards" :
        	 file.writeToForwards(p);
        	 break;
         default : 
        	 System.out.println("Wrong input");
        }
     }

}
