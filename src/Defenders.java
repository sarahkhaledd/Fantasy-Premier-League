import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

public class Defenders extends Squad
{ 
	Scanner input= new Scanner(System.in);
	 public void UserDefenders(String username) throws Exception
	  {     
	       	String player ;
	    	Path path = FileSystems.getDefault().getPath("Defenders.txt");
			File defender = new File(path.toString());
			int NumbOfDefenders = 5 ;
			Data data=new Data();
	         for(int i =0;i<NumbOfDefenders;i++)
	         {
	        	 player = input.next();
	       		String newname = data.check(player,defender);
	       		playersClub(newname,defender,username);
	       		if(Squad.PlayerNum<Squad.PlayerInSameSquad)
	       		{
	       			UserBudget(newname,defender,username);
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
		System.out.println("Add defenders:");
		myfile.ReadToDefenders();
        UserDefenders(username);
	}
}
