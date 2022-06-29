import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

public class SquadScore 
{
	ArrayList<Integer> points = new ArrayList<Integer>();
	ArrayList<String> userarr = new ArrayList<String>();
	ArrayList<String> weekarr = new ArrayList<String>();
	  public void UserSquadScore(String username,int gameweek) throws IOException
	  {
		  
		  Path week = FileSystems.getDefault().getPath("week"+gameweek+".txt");
		  File weekfile = new File(week.toString());
		  FileReader fr2 = new FileReader(weekfile);
		  BufferedReader brweek = new BufferedReader(fr2);
		  Path user = FileSystems.getDefault().getPath(username+".txt");
		  File userfile = new File(user.toString());
		  FileReader fr = new FileReader(userfile);
		  BufferedReader bruser = new BufferedReader(fr);  
		  String lineweek ,lineuser,playeruser ,point ,playername ;
		  int arrpoint;
		  boolean x =true;
		  
			  while((lineweek = brweek.readLine())!= null)
			  {
				  /*point = lineweek.split(" ")[3];
				  arrpoint =Integer.parseInt(point);
				  playername = lineweek.split(" ")[0];*/
				  weekarr.add(lineweek);
			  }
			  while((lineuser = bruser.readLine())!= null) 
			  {
				  playeruser = lineuser.split(" ")[0];
				  userarr.add(lineuser);
			  } 
			 
		      
			  
			  CalcuScoring(weekarr,userarr);
		  
		 /* brweek.close();
		  bruser.close();*/
	  }
	  public void CalcuScoring(ArrayList<String> weekarr,ArrayList<String> userarr)
	  {
		  char[] week = weekarr.toString().toCharArray();
		  char[] user = userarr.toString().toCharArray();
		  String str=weekarr.toString().replaceAll(" ", "");
		  char[] chars = str.substring(1, str.length()-1).replaceAll(",", "").toCharArray();
		  ArrayList<Character> chars2 = new ArrayList<Character>();
		  for(int i=0 ;i<weekarr.size();i++)
		  { 
			  
		  }
		  /*for(char i : week)
		  {
			 System.out.println(chars[i]);
		  }
		  int sum = 0 ;
		  for(int i=0;i<points.size();i++)
		  { 
			 sum+=points.get(i); 
		  }
	   System.out.println("the score of gameweek: "+sum);*/
	  }
}
