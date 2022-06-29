import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class ForwardRule extends SquadRules
{
	Scanner input= new Scanner(System.in);
    public static int counterForward =0 ;
	Path path = FileSystems.getDefault().getPath("Forwards.txt");
	File defender = new File(path.toString());
	public Boolean applyRule(String player,File file,String username) throws IOException 
	  {
		try {
			UserForwards(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(counterForward<3)
			return true;
		return false;
	 }
 public void UserForwards(String username) throws Exception
  {     
	 counterForward = 0;
	    Path path = FileSystems.getDefault().getPath(username+".txt");
		File userfile = new File(path.toString());
		FileReader fr = new FileReader(userfile);
	    BufferedReader br = new BufferedReader(fr);
	    String line ,position;
	    ArrayList<String> forward = new ArrayList<String>();
		    while((line = br.readLine())!= null)
		    { 
		    	forward.add(line);
		    }
		    for(int i=1;i<forward.size();i++)
		    {
		    	if(forward.get(i).contains("forward"))
		    	{
		    	counterForward++;
		    	}
		    }
		    
}}