public class UserInfo 
{
		public String username;
	    public String email; 
	    public String password; 
	    public String favouriteTeam;
	    public String Userbudget ;
	    public UserInfo()
	    { 
	    	this.username="";
	        this.email="";
	        this.favouriteTeam="";
	        this.password="";
	    }
	    public UserInfo(String username,String email,String password,String favouriteTeam)//100.000
	    { 
	    	this.username=username;
	        this.email=email;
	        this.favouriteTeam=favouriteTeam;
	        this.password=password;
	    }
	    public void setUserName(String username) 
	    {
			this.username = username;
	    }
	    public String getUsername() 
	    {
			return username;
		}public void setUserbudget(String userbudget)
		{
			Userbudget = userbudget;
		}
	    public void setEmail(String email) 
	    {
			this.email = email;
		}
	    public String getEmail() 
	    {
			return email;
		}
	    public String getUserbudget() 
	    {
			return Userbudget;
		}
	    public void setPassword(String password) 
	    {
			this.password = password;
		}
	    public String getPassword() 
	    {
	    	return password;
		}
	    public void setfavouriteTeam(String favouriteTeam) 
	    {
	    	this.favouriteTeam=favouriteTeam;
	    }
	    public String getfavouriteTeam() 
	    {
	        return favouriteTeam;
	    }
}
