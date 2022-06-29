import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

public class Goalkeeprs extends Squad 
{
	Scanner input= new Scanner(System.in);
	 public void UserGoalKeeprs(String username) throws Exception
	  {     
	       	String player ;
	       	Path path = FileSystems.getDefault().getPath("GoalKeeprs.txt");
			File GoalKeeprs = new File(path.toString());
			int NumOfGoalkeepers = 2;
			Data data=new Data();
			for(int i=0;i<NumOfGoalkeepers;i++)
			{
				player = input.next();
	       		String newname = data.check(player,GoalKeeprs);
	       		playersClub(newname,GoalKeeprs,username);
	       		if(Squad.PlayerNum<Squad.PlayerInSameSquad)
	       		{
	       			UserBudget(newname,GoalKeeprs,username);
	       		}
	       		else 
	       		{
	       			System.out.println("Error you entered the 3 players in the same club");
	       		}
	       		
	       	}
	    
	  }	
	 
	public void add(String username) throws Exception
	{
		Data myfile =new Data() ;
		System.out.println("Add GoalKeeprs:");
		myfile.ReadToGoalKeeprs();
        UserGoalKeeprs(username);
	}
}
