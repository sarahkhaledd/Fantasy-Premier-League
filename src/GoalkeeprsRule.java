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

public class GoalkeeprsRule extends SquadRules
{
	Scanner input= new Scanner(System.in);
    public static int counterGoalkeeper =0 ;
	Path path = FileSystems.getDefault().getPath("Goalkeeprs.txt");
	File defender = new File(path.toString());
	public Boolean applyRule(String player,File file,String username) throws IOException 
	  {
		try {
			UserGoalkeeper(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(counterGoalkeeper<2)
			return true;
		return false;
	 }
 public void UserGoalkeeper(String username) throws Exception
  {     
	 counterGoalkeeper = 0;
	    Path path = FileSystems.getDefault().getPath(username+".txt");
		File userfile = new File(path.toString());
		FileReader fr = new FileReader(userfile);
	    BufferedReader br = new BufferedReader(fr);
	    String line ,position;
	    ArrayList<String> goalkeeper = new ArrayList<String>();
	    while((line = br.readLine())!= null)
	    { 
	    	goalkeeper.add(line);
	    }
	    for(int i=1;i<goalkeeper.size();i++)
	    {
	    	if(goalkeeper.get(i).contains("goalkeeper"))
	    	{
				counterGoalkeeper++;
			}
	    }
}}