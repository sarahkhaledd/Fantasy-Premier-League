import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class DefendersRule extends SquadRules 
{ 
	Scanner input= new Scanner(System.in);
	public static int counterDefender =0 ;
	Path path = FileSystems.getDefault().getPath("Defenders.txt");
	File defender = new File(path.toString());
	public Boolean applyRule(String player,File file,String username) throws IOException 
	  {
		try {
			UserDefenders(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(counterDefender<5)
			return true;
		return false;
	  }
	 public void UserDefenders(String username) throws Exception
	  {     
		   counterDefender = 0;
		    Path path = FileSystems.getDefault().getPath(username+".txt");
			File userfile = new File(path.toString());
			FileReader fr = new FileReader(userfile);
		    BufferedReader br = new BufferedReader(fr);
		    String line ,position;
		    ArrayList<String> defenders = new ArrayList<String>();
		    while((line = br.readLine())!= null)
		    { 
		    	defenders.add(line);
		    }
		    for(int i=1;i<defenders.size();i++)
		    {
		    	if(defenders.get(i).contains("defender"))
		    	{
		    		counterDefender++;
		    	}
		    }
	  }	
	 
	
}
