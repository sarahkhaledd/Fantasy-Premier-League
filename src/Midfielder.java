import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

public class Midfielder extends Squad
{
	Data myfile =new Data() ;
	Scanner input= new Scanner(System.in);
	 public void UserMidfielders(String username) throws Exception
	  {     
	       	String player ;
	       	Path path = FileSystems.getDefault().getPath("Midfielders.txt");
			File Midfielders = new File(path.toString());
			int NumOfMidfielders = 5;
			Data data = new Data();
			for(int i=0;i<NumOfMidfielders;i++)
			{
	       		player = input.next();
	       		String newname = data.check(player,Midfielders);
	       		playersClub(newname,Midfielders,username);
	       		if(Squad.PlayerNum<Squad.PlayerInSameSquad)
	       		{
	       			UserBudget(newname,Midfielders,username);
	       		}
	       		else 
	       		{
	       			System.out.println("Error you entered the 3 players in the same club");
	       		}
	       		
	       	}
	    
	  }	
	 
	public void add(String username) throws Exception
	{
	
		System.out.println("Add Midfielders:");
		myfile.ReadToMidfielders();
        UserMidfielders(username);
	}
}
