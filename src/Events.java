import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Events //Subject
{   
	Data data =new Data();
    public void ApplyEvents(String playername,String position,String gameweek ) throws IOException {}
    public abstract void notifyall() throws IOException ;
    public abstract void RegisterObserver(Observer o);
}
