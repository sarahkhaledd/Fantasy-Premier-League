import java.io.IOException;
import java.util.ArrayList;

public class OwnGoalEvent extends Events
{
	int point;
	String player ,file,Position ; 
	 private ArrayList<Observer> observers = new ArrayList<Observer>();
	public void ApplyEvents(String playername, String position,String File) throws IOException 
	{
	    point = -2 ; 
	    player = playername ; 
	    file=File;
	    Position = position;
	    notifyall();
	}
	public void notifyall() throws IOException
    {
    	for (Observer observer : this.observers) 
        {
    		observer.Update(player,point,file,Position);
        }
    	
    }
	@Override
	public void RegisterObserver(Observer o) 
	{
		observers.add(o);
	}

}

