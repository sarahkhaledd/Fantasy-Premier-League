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

public class MidfielderRule extends SquadRules
{
	Scanner input= new Scanner(System.in);
	public static int counterMidfielder =0 ;
	Path path = FileSystems.getDefault().getPath("Midfielders.txt");
	File defender = new File(path.toString());
	public Boolean applyRule(String player,File file,String username) throws IOException 
	{
		try 
		{
			UserMidfielder(username);
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(counterMidfielder<5)
			return true;
		return false;
	}
	 public void UserMidfielder(String username) throws Exception
	  {     
		    counterMidfielder = 0;
		    Path path = FileSystems.getDefault().getPath(username+".txt");
			File userfile = new File(path.toString());
			FileReader fr = new FileReader(userfile);
		    BufferedReader br = new BufferedReader(fr);
		    String line ,position;
		    ArrayList<String> midfielder = new ArrayList<String>();
		    while((line = br.readLine())!= null)
		    { 
		    	midfielder.add(line);
		    }
		    for(int i=1;i<midfielder.size();i++)
		    {
		    	if(midfielder.get(i).contains("midfielder"))
		    	{
					counterMidfielder++;
				}
		    }
	  }
}
