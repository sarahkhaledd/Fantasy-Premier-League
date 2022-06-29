import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
public abstract class Squad 
{
	public void add(String info) throws IOException, Exception {}
	public static int PlayerNum = 0 ;
	public static final int PlayerInSameSquad = 3 ;
	Data data = new Data();
	
	//--------------------------------------RULESS--------------------------------------------------------
	/* The total value of your initial squad must not exceed £100 million.
	 * You can select up to 3 players from a single Premier League team.
	 */
	public void UserBudget(String name,File filee ,String username) throws Exception //RULE 1
	{   
		Path path = FileSystems.getDefault().getPath(username+".txt");
		File fileUser = new File(path.toString());
		FileReader out = new FileReader(filee);
	    BufferedReader br = new BufferedReader(out);
        String line , player,budget;
        while ((line = br.readLine()) != null)
	       {
	            	   player = line.split(" ")[0];
	            	   if (player.equals(name)) 
	                   { 
	                       break ;
	                   }
	       }  
        budget=line.split(" ")[4];
	       FileReader read = new FileReader(fileUser);
		   BufferedReader buffer = new BufferedReader(read);
		  String userline = buffer.readLine();
		  String user = userline.split(" ")[0];  
		  String newBudget = null;
		  SquadCalculation squad = new SquadCalculation();
		  newBudget=squad.CalcUserBudget(user,budget);
		  if(newBudget=="error the budget not enough \n")
		  {
			 System.out.println("error the budget not enough");
		  }
		  else
		  {
			  data.replace(user,username,newBudget);
			  data.userFile(name, username, filee);
		  }
		  buffer.close();
		  br.close();
		  out.close();
	}
	public void playersClub(String Playername,File playerFile ,String username) throws IOException
	{
		FileReader out = new FileReader(playerFile);
	    BufferedReader br = new BufferedReader(out);
        String line , player;
        while ((line = br.readLine()) != null)
       {
            	   player = line.split(" ")[0];
            	   if (player.equals(Playername)) 
                   { 
                       break ;
                   }
       } 
            String Club =line.split(" ")[1]; 
            CountplayersClub(username,Club);
        br.close();
        out.close();
	}
	
	public void CountplayersClub(String username,String club) throws IOException
	{
		PlayerNum=0;
		Path path = FileSystems.getDefault().getPath(username+".txt");
		File userFile = new File(path.toString());
		FileReader fr = new FileReader(userFile);
	    BufferedReader br = new BufferedReader(fr);
	    String line;
	    while((line = br.readLine())!= null)
	    {
	    	if (line.contains(club))
	    	{
	    		PlayerNum++;
	    	}
	    }
	    br.close();
	    fr.close();
	}
 }