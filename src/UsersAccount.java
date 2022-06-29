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
public class UsersAccount 
{
		UserInfo info = new UserInfo();
		Scanner input= new Scanner(System.in);
		Path path = FileSystems.getDefault().getPath("users.txt");
		File fileUser = new File(path.toString());
	    public void register(UserInfo info) throws IOException
	    { 
	    	Data data = new Data();
	    	if(RegistrationRule(info.getUsername(),fileUser))
	    	{
		    	data.file(fileUser ,info,info.getUsername());
		    	data.UserFile(info);
	        }
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
	        fr.close();
			return isLoginSuccess;
	    }
	    public Boolean RegistrationRule(String username,File file) throws IOException
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
	                break;
	            }
	        }
	        if(isExsiting)
	         info.setUserName(username); 
	        br.close();
	        out.close();
	        return isExsiting;
		}
}

