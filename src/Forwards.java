import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

public class Forwards extends Squad
{
	   Scanner input= new Scanner(System.in);
	 public void UserForwards(String username) throws Exception
	  {     
	       	String player ;
	       	Path path = FileSystems.getDefault().getPath("Forwards.txt");
			File forward = new File(path.toString());
			int NumOfForward = 3;
			Data data=new Data();
	       	for(int i=0;i<NumOfForward;i++)
	       	{	player = input.next();
	       		String newname = data.check(player,forward);
	       		playersClub(newname,forward,username);
	       		if(Squad.PlayerNum<Squad.PlayerInSameSquad)
	       		{
	       			UserBudget(newname,forward,username);
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
		System.out.println("Add Forwards:");
		myfile.ReadToForwards();
        UserForwards(username);
	}
}
