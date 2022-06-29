import java.io.IOException;

public class FilesUpdate extends Observer
{
	private Events event;
	public void Update(String PlayerName , int point,String position,String File ) throws IOException
	{
		replacePoint(PlayerName,point,File);
		replacePoint(PlayerName,point,position);
	}
	public FilesUpdate(Events event)
	{
		this.event=event;
		this.event.RegisterObserver(this);
	}
}
