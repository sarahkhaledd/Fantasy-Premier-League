import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class ClubRule extends SquadRules  {

	public static int PlayerNum = 0 ;
	public static final int PlayerInSameSquad = 3 ;
	public Boolean applyRule(String player,File file,String username) throws IOException 
	{    
		CountplayersClub(player,file,username);
		if(PlayerNum<PlayerInSameSquad)
		{
			return true;
		}
		return false ;
	}
	public void CountplayersClub(String Playername,File playerFile ,String username) throws IOException
	{
		PlayerNum=0;
		Data data =new Data();
		FileReader out = new FileReader(playerFile);
	    BufferedReader br = new BufferedReader(out);
        String line , player ,club="";
        while ((line = br.readLine()) != null)
       {
        	player = line.split(" ")[0];
      	    if (player.equals(Playername)) 
             { 
      	    	club =line.split(" ")[1];
                 break ;
             }
       } 
           
        playersClub(username,club);
        br.close();
        out.close();
	}

	public void playersClub(String username,String club) throws IOException
	{
		Path path = FileSystems.getDefault().getPath(username+".txt");
		FileReader out = new FileReader(path.toString());
	    BufferedReader br = new BufferedReader(out);
	    String line ;
	    while((line = br.readLine())!= null)
	    {
	    	if (line.contains(club))
	    	{
	    		PlayerNum++;
	    	}
	    }
	    br.close();
	    out.close();
	}
	}

