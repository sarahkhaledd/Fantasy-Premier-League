public class PlayerInfo 
{
	public String Playername;
	public String club ; 
	public String nationality;
	public String position  ;
	public int point ;
	public String budget ;
	public PlayerInfo() 
	{
		this.Playername="";
		this.club="";
		this.nationality="";
		this.position="";
		this.point=0;
		this.budget="";
    }
	public PlayerInfo(String name,String club ,String nationality ,String position,int point,String bugdet)
    { 
    	this.Playername=name;
        this.club=club;
        this.nationality=nationality;
        this.position=position ; 
        this.point=point;
        this.budget =bugdet;
    }
	public void setBudget(String budget) 
	{
		this.budget = budget;
	}
	public void setPoint(int point) 
	{
		this.point = point;
	}
	public void setPlayername(String playername) 
	{
		this.Playername = playername;
	}
	public void setNationality(String nationality) 
	{
		this.nationality = nationality;
	}
	public void setClub(String club) 
	{
		this.club = club;
	}
	public void setPosition(String position ) 
	{
		this.position= position;
	}
	public String getPlayername() 
	{
		return Playername;
	}
	public String getBudget() 
	{
		return budget;
	}
	public String getNationality() 
	{
		return nationality;
	}
	public String getClub() 
	{
		return club;
	}
	public String getPosition() 
	{
		return position;
	}
	public int getPoint() 
	{
		return point;
	}

}
