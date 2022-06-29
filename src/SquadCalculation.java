import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

public class SquadCalculation 
{
	  public void CalcuScoring(ArrayList<Integer> points)
	  {
		  int sum = 0 ;
		  for(int i=0;i<points.size();i++)
		  { 
			 sum+=points.get(i); 
		  }
		  System.out.println(sum);
	  }
	  public String CalcUserBudget(String user_budget , String player_budget)
		{
			double userBudget = Double.parseDouble(user_budget); 
			double budget = userBudget ;
			double playerBudget = Double.parseDouble(player_budget); 
			if(budget>=playerBudget)
			{ 
				budget=budget - playerBudget;
				String totalBudget = String.valueOf(budget);
				return totalBudget ;
			}
			else 
			{
				return "error the budget not enough \n";
			}
		}
}
