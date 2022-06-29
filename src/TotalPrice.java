import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class TotalPrice extends SquadRules 
{
	public Boolean applyRule(String player,File file,String username) throws IOException 
	{
		if(UserBudget(player,file,username))
			return true;
		return false;
	}
	public Boolean UserBudget(String name,File filee ,String username) throws IOException //RULE 1
	{   
		Path path = FileSystems.getDefault().getPath(username+".txt");
		Data data = new Data();
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
		  double userbudget = Double.parseDouble(user);
		  double budgetplayer = Double.parseDouble(budget);
		  if(userbudget > budgetplayer)
		  {
			  return true;
		  }
		  
		  
		  buffer.close();
		  br.close();
		  out.close();
		  return false;
	}

}
