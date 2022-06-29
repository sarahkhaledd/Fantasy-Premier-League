import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class UserUpdates extends Observer
{
	private Events event ;
	public void Update(String PlayerName , int point,String position,String File) throws IOException
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
	}
	public UserUpdates(Events event)
	{
		this.event=event;
		this.event.RegisterObserver(this);
	}
}
