import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Data
{
	File file ;
	Path goalkeepers = FileSystems.getDefault().getPath("GoalKeeprs.txt");
	Path defenders = FileSystems.getDefault().getPath("Defenders.txt");
	Path midfielder = FileSystems.getDefault().getPath("Midfielders.txt");
	Path forward = FileSystems.getDefault().getPath("Forwards.txt");
	Path week1 = FileSystems.getDefault().getPath("week1.txt");
	Path week2 = FileSystems.getDefault().getPath("week2.txt");
	public static ArrayList<String> team1 = new ArrayList<String>();
	public static ArrayList<String> team2 = new ArrayList<String>();
	public void fileWriter(File Playerfile,PlayerInfo info) throws IOException
	{  
		FileWriter fr = new FileWriter(Playerfile, true);
       	BufferedWriter myWriter=new BufferedWriter(fr);
       	myWriter.newLine();
       	myWriter.write(info.getPlayername() + " ");
       	myWriter.write(info.getClub()+ " ");
       	myWriter.write(info.getNationality()+" ");
       	myWriter.write(info.getPoint()+ " ");
       	myWriter.write(info.getBudget());
       	myWriter.close();
        fr.close();
	}
	public void file(File userFile, UserInfo info,String name) throws IOException 
	{ 
			FileWriter fr = new FileWriter(userFile, true);
	       	BufferedWriter myWriter=new BufferedWriter(fr);
	        myWriter.write(name);
	        myWriter.write(" ");
	        myWriter.write(info.getEmail());
	        myWriter.write(" ");
	        myWriter.write(info.getPassword());
	        myWriter.write(" ");
	        myWriter.write(info.getfavouriteTeam());
	        myWriter.newLine();
	        myWriter.close();
	        fr.close();
     }
	public Boolean checkPlayerName(String name,File file) throws IOException
	{
		Scanner input= new Scanner(System.in);
		FileReader out = new FileReader(file);
	    BufferedReader br = new BufferedReader(out);
        boolean isLoginSuccess = false;
        String line , player;
        while ((line = br.readLine()) != null)
       {
            	   player = line.split(" ")[0];
            	   if (player.equals(name)) 
                   { 
                       isLoginSuccess = true;
                       break ;
                   }
       }
        if(!isLoginSuccess)
        {
      	   System.out.println("the name of player not exists , enter again");
      	 br.close();
         out.close();
      	   return false;
        }
        br.close();
        out.close();
        return true ;
	}
	
	public void userFile(String playername , String username,File PlayerFile) throws IOException, Exception
	{
		Path path = FileSystems.getDefault().getPath(username+".txt");
		File userfile = new File(path.toString());
		FileReader out = new FileReader(PlayerFile);
	    BufferedReader br = new BufferedReader(out);
	    FileWriter fr = new FileWriter(userfile, true);
       	BufferedWriter pw=new BufferedWriter(fr);
        String line , player;
        while ((line = br.readLine()) != null)
        {
            	   player = line.split(" ")[0];
            	   if (player.equals(playername)) 
                   {   
            	        pw.write(line);
                       break ;
                   }
        }

        pw.close();
        br.close();
        out.close();
        fr.close();
		
	}
	 
	public void fileReader(File Playerfile) throws IOException
	{      
            BufferedReader br = new BufferedReader(new FileReader(Playerfile));
            String line;
            while ((line = br.readLine()) != null) 
            {
                System.out.println(line);
	        }
            br.close();
    }
	
	public void Gameweek(String gamefile) throws IOException
	{
		Path path = FileSystems.getDefault().getPath(gamefile+".txt");
		File gamefilee = new File(path.toString());
		team1.clear();
		team2.clear();
	   BufferedReader br = new BufferedReader(new FileReader(gamefilee));
	            String line , position , club , playername;
	          if(gamefile.equalsIgnoreCase("week1"))
	          {
	            while ((line = br.readLine()) != null) 
	            {  
	            	position = line.split(" ")[5];
	            	club = line.split(" ")[1];
	            	playername = line.split(" ")[0];
	               if((position.equalsIgnoreCase("defender")||position.equalsIgnoreCase("goalkeeper"))&&club.equalsIgnoreCase("Liverpool"))  
	               {
	            	   team1.add(playername);
	            	  
	               }
	               else if((position.equalsIgnoreCase("defender")||position.equalsIgnoreCase("goalkeeper"))&&club.equalsIgnoreCase("ManCity"))
	               {
	            	   team2.add(playername);
	            	   
	               }
		        }
	          }
	          else if(gamefile.equalsIgnoreCase("week2"))
	          {
	            while ((line = br.readLine()) != null) 
	            {  
	            	position = line.split(" ")[5];
	            	club = line.split(" ")[1];
	            	playername = line.split(" ")[0];
	               if(position.equalsIgnoreCase("defender")||position.equalsIgnoreCase("goalkeeper")&&club.equalsIgnoreCase("AstonVilla"))  
	               {
	            	   team1.add(playername);
	               }
	               else if(position.equalsIgnoreCase("defender")||position.equalsIgnoreCase("goalkeeper")&&club.equalsIgnoreCase("Chelsea "))
	               {
	            	   team2.add(playername);
	               }
		        }
	          }
	          
	          br.close();
	}
	
	/*public void updateUserFile(String PlayerName,int point) throws IOException
	{
		Path path = FileSystems.getDefault().getPath("users.txt");
		File userfile = new File(path.toString());
		FileReader fr = new FileReader(userfile);
	    BufferedReader br = new BufferedReader(fr);
	    String line ,username;
		while((line = br.readLine())!= null)
	    { 
			username = line.split(" ")[0];
			replacePoint(PlayerName,point,username+".txt");
	    }
		br.close();
		fr.close();
		
	}*/
	public void ReadWeek(String gameweek) throws IOException
	{
		Path path = FileSystems.getDefault().getPath(gameweek+".txt");
		File week1file = new File(path.toString());
		fileReader(week1file);
	}
	public void replace(String oldBudget , String fileName,String newLine) throws IOException
    {
		ArrayList<String> lines = new ArrayList<String>();
		Path path = FileSystems.getDefault().getPath(fileName+".txt");
		File Playerfile = new File(path.toString());
	    FileReader fr = new FileReader(Playerfile);
	    BufferedReader br = new BufferedReader(fr);
	    String line;
	    lines.clear();
	    while((line = br.readLine())!= null)
	    {
	    	if (line.contains(oldBudget))
	    	{
	    		line = line.replace(line, newLine);
	    	}
	        lines.add(line);
	    }
	    PrintWriter writer = new PrintWriter(Playerfile);
	    writer.print(lines.get(0)); 
	    writer.close();
		BufferedWriter out=new BufferedWriter(new FileWriter(Playerfile,true));
		out.newLine();
		for(int i=1;i<lines.size();i++)
		{
			//out.newLine();
		    out.write(lines.get(i)+'\n');
		}
		System.out.println("new budget : " + newLine);
		br.close();
		out.close();
		fr.close();
    }
	public void replaceBudget(String name,File filee ,String username) throws IOException  
	{
		Path path = FileSystems.getDefault().getPath(username+".txt");
		Data data = new Data();
		File fileUser = new File(path.toString());
		FileReader out = new FileReader(filee);
	    BufferedReader br = new BufferedReader(out);
        String line , player,budget;
        while ((line = br.readLine()) != null)
	     {
        	 player = line.split(" ")[0];
      	    if (player.equals(name)) 
             { 
                 break ;
             }
	      }  
           budget=line.split(" ")[4];
	       FileReader read = new FileReader(fileUser);
		   BufferedReader buffer = new BufferedReader(read);
		  String userline = buffer.readLine();
		  String user = userline.split(" ")[0]; 
		  String newBudget = null;
		  SquadCalculation squad = new SquadCalculation();
		  newBudget=squad.CalcUserBudget(user,budget);
		  System.out.println(newBudget);
		  if(newBudget=="error the budget not enough \n")
		  { 
		  } else
			try {
				replace(user,username,newBudget);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		  
		 
		  buffer.close();
		  read.close();
		  br.close();
		  out.close();
	}
	public void UserFile(UserInfo info) throws IOException
	{
		Path path = FileSystems.getDefault().getPath(info.getUsername()+".txt");
		File file = new File(path.toString());
		file.createNewFile();
		FileWriter fr = new FileWriter(file, true);
       	BufferedWriter myWriter=new BufferedWriter(fr);
       	myWriter.write("100.0");
       	myWriter.newLine();
       	myWriter.close();
       	fr.close();
	}
	public void Dataweek(String username,int gameweek) throws IOException
	  { 
		  ArrayList<Integer> points = new ArrayList<Integer>();
		  ArrayList<String> userarr = new ArrayList<String>();
		  Path week = FileSystems.getDefault().getPath("week"+gameweek+".txt");
		  File weekfile = new File(week.toString());
		  FileReader fr2 = new FileReader(weekfile);
		  BufferedReader brweek = new BufferedReader(fr2);
		  Path user = FileSystems.getDefault().getPath(username+".txt");
		  File userfile = new File(user.toString());
		  FileReader fr = new FileReader(userfile);
		  BufferedReader bruser = new BufferedReader(fr);  
		  String lineweek ,lineuser ,point ,playername ;
		  points.clear();
		  int arrpoint;
		  SquadCalculation squadscore =new SquadCalculation();    
		 while((lineuser =  bruser.readLine())!=null)
			{ 
					  userarr.add(lineuser);
			}
					   
			  while((lineweek = brweek.readLine())!= null)
			  {
				  point = lineweek.split(" ")[3];
				  arrpoint =Integer.parseInt(point);
				  playername = lineweek.split(" ")[0];
				     for(int i=0;i<userarr.size();i++)
				     { 
						  if(userarr.get(i).contains(playername))
						  { 
							  points.add(arrpoint);
						  }
				    } 
			  }
			  squadscore.CalcuScoring(points);
			  bruser.close();
			  brweek.close();
			  fr.close();
			  fr2.close();
		}
	public void ReadToGoalKeeprs() throws IOException 
	{
		
		file = new File(goalkeepers.toString());
		fileReader(file);
	}
	public void ReadToDefenders() throws IOException
	{  
		file = new File(defenders.toString());
		fileReader(file);
	}
	public void ReadToMidfielders() throws IOException
	{
		file = new File(midfielder.toString());
		fileReader(file);
	}
	public void ReadToForwards() throws IOException
	{
		file = new File(forward.toString());
		fileReader(file);
	}
	
	public void writeToGoalKeeprs(PlayerInfo p) throws IOException 
	{ 
		file = new File(goalkeepers.toString());
		fileWriter(file,p);
	}
	public void writeToDefenders(PlayerInfo p) throws IOException
	{   
		file = new File(defenders.toString());
		fileWriter(file,p);
	}
	public void writeToMidfielders(PlayerInfo p) throws IOException
	{
		file = new File(midfielder.toString());
		fileWriter(file,p);
	}
	public void writeToForwards(PlayerInfo p) throws IOException
	{
		file = new File(forward.toString());
		fileWriter(file,p);
	}
	
}