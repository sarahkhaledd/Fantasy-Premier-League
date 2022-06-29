import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

public abstract class Observer 
{
	public void Update(String PlayerName , int point,String position,String File) throws IOException{}
	public void replacePoint(String PlayerName , int point , String filename) throws IOException
    {
		ArrayList<String> lines = new ArrayList<String>();
		Path path = FileSystems.getDefault().getPath(filename);
		File week1file = new File(path.toString());
	    FileReader fr = new FileReader(week1file);
	    BufferedReader br = new BufferedReader(fr);
	    String line , PlayerPoint;
	    lines.clear();
	    while((line = br.readLine())!= null)
	    { 
	    	
	    	if(line.contains(PlayerName))
	    	{ 
	    		PlayerPoint = line.split(" ")[3];
	    		int oldPoint = Integer.parseInt(PlayerPoint); 
	    		int newPoint = oldPoint + point;
	    		String totalPoint = String.valueOf(newPoint);
	    		line = line.replace(PlayerPoint, totalPoint);
	    		lines.add(line);
	    		continue ;
	    	}
	        lines.add(line);
	    }
	    
	    PrintWriter writer = new PrintWriter(week1file);
	    for (String str : lines) 
	    {
	        writer.println(str);
	    }
	    writer.close();
	    br.close();
	    fr.close();
	   
    }

}
