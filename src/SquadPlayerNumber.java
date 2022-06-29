import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

public class SquadPlayerNumber extends SquadRules
{ 
	public static int players =0;
	public Boolean applyRule(String player,File file,String username) throws IOException 
	  {
		UserPlayers(username);
		if(players<16)
			return true;
		return false;
		
	  }
	 public void UserPlayers(String username) throws IOException
	  {     
		    players = 0;
		    Path path = FileSystems.getDefault().getPath(username+".txt");
			File userfile = new File(path.toString());
			FileReader fr = new FileReader(userfile);
		    BufferedReader br = new BufferedReader(fr);
		    String line ;
		    while((line = br.readLine())!= null)
		    { 
		    	players++;
		    }
		    br.close();
		    fr.close();
  }
}
