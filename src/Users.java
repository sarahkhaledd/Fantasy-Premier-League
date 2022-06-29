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
//budget = 100.000
//loginFile
class Users implements check
{ 
	UserInfo info = new UserInfo();
	Scanner input= new Scanner(System.in);
	Path path = FileSystems.getDefault().getPath("users.txt");
	File fileUser = new File(path.toString());
	public String check(String username,File file) throws IOException
	{
         FileReader out = new FileReader(file);
        BufferedReader br = new BufferedReader(out);
        String line,user;
        boolean isExsiting = true;
        while ((line = br.readLine()) != null) 
        {
            user = line.split(" ")[0];
            if (user.equals(username)) 
            {  
            	isExsiting =false;
                System.out.println("Error, please enter another username, username already taken! ");
                username = input.next(); 
                check(username,file);
                break;
            }
        }
        if(isExsiting)
         info.setUserName(username); 
        br.close();
        return info.username;
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
	}
    public void register(UserInfo info) throws IOException
    {
    	String z = check(info.getUsername(),fileUser);
    	Data data = new Data();
    	data.file(fileUser ,info,z);
    	UserFile(info);
    }
    public boolean login(String username, String password) throws IOException
    {
    	FileReader fr = new FileReader(fileUser);
        BufferedReader br = new BufferedReader(fr);
        String line, user, pass;
        
        boolean isLoginSuccess = false;
        while ((line = br.readLine()) != null) 
        {
            user = line.split(" ")[0];
            pass = line.split(" ")[2];
            if (user.equals(username) && pass.equals(password)) 
            {
                isLoginSuccess = true;
                System.out.println("Login successfully ");   
                break;
            }
        }
        if (!isLoginSuccess)
        System.out.println("Login failed");
        info.setUserName(username);
        br.close();
		return isLoginSuccess;
    }
}