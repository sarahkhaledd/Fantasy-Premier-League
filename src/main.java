import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;
public class main 
{
	public static void main(String[] args) throws Exception 
	{
		UsersAccount users = new UsersAccount();
		Scanner input= new Scanner(System.in);
		Scanner in= new Scanner(System.in);
		while(true)
		{
			System.out.println("1)Sign up as new user");
			System.out.println("2)Login in as existing user");
			System.out.println("3)Add new player");
			System.out.println("4)Add new Squad");
			System.out.println("5)Add Events");
			System.out.println("6)Check Squad score");
			System.out.println("7)Exit");
			System.out.println("-----------------------");
			int choice = in.nextInt(); 
			if(choice==1)  
			{
				UserInfo info = new UserInfo();
				System.out.println("Registration Page");
				System.out.printf("Username: ");
				String username = input.nextLine();
				System.out.printf("Email: ");
				String email = input.nextLine();
				System.out.printf("Password: ");
				String password = input.nextLine();
				System.out.printf("Favourite Team: ");
				String favouriteTeam = input.nextLine();
				info=new UserInfo(username,email,password,favouriteTeam);//100.000
				users.register(info);
			}
			else if(choice==2)
			{
				System.out.println("Login Page");
		    	System.out.println("Please enter username: ");
	    		String username = input.nextLine();
	    		System.out.println("Please enter password: ");
	            String password = input.nextLine();
				users.login(username,password);
			}
			else if(choice==3)
			{
				Player player = new Player();
				System.out.println("enter the name of player : ");
				String playerName = input.next();
				System.out.println("enter the club of player : ");
				String club = input.next();
				System.out.println("enter the nationality of player : ");
				String nationality = input.next();
				System.out.println("which position would you want to add her?");
		        System.out.println("goalkeepers ,\r\n" + 
		        		"defenders \n" + 
		        		"midfielders \n" + 
		        		"forwards");
				System.out.println("enter the position of player : ");
				String position =input.next();
				System.out.println("enter the point of player : ");
				int point =input.nextInt();
				System.out.println("enter the budget of player : ");
				String budget =input.next();
				PlayerInfo playerinfo =new PlayerInfo(playerName,club,nationality,position,point,budget);
				player.AddPlayer(playerinfo);
			}
			else if(choice==4)
			 { 
				System.out.println("Login Page");
		    	System.out.println("Please enter username: ");
	    		String username = input.next();
	    		System.out.println("Please enter password: ");
	            String password =input.next();
	            Data data = new Data();
				if((users.login(username,password)))
				{  
					System.out.println("Defenders.......");
					data.ReadToDefenders();
					System.out.println("--------------------");
					System.out.println("forwards.......");
					data.ReadToForwards();
					System.out.println("---------------------");
					System.out.println("goalkeepers.......");
		            data.ReadToGoalKeeprs();
		            System.out.println("--------------------");
		            System.out.println("Midfielders.......");
		            data.ReadToMidfielders();
		            System.out.println("--------------------");
		            while(true) 
		            {
					System.out.println("enter player name");
					String playername = input.next();
					System.out.println("enter position :");
					String position = input.next();
					SquadRules rule2 = new ClubRule();
					SquadRules rule3 = new TotalPrice();
					SquadRules rule4 = new SquadPlayerNumber();
					if(position.equalsIgnoreCase("defender"))
					{
						Path path = FileSystems.getDefault().getPath("Defenders.txt");
						File defenders = new File(path.toString());
						SquadRules rule1 = new DefendersRule();
						Boolean defenderRule = rule1.applyRule(playername, defenders, username);
						Boolean ClubRule = rule2.applyRule(playername, defenders, username);
						Boolean budgetRule = rule3.applyRule(playername, defenders, username);
				        Boolean squadnumber = rule4.applyRule(playername, defenders, username);
						if(defenderRule&&ClubRule&&budgetRule&&squadnumber)
						{
							data.replaceBudget(playername, defenders, username);
							data.userFile(playername, username, defenders);
						}
						else
						{
							System.out.println("can't add this player");
							if(squadnumber==false)
								break;
						}
							
					 }
					else if(position.equalsIgnoreCase("forward"))
					{
						Path path = FileSystems.getDefault().getPath("Forwards.txt");
						File forward = new File(path.toString());
						SquadRules rule1 = new ForwardRule();
						Boolean defenderRule = rule1.applyRule(playername, forward, username);
						Boolean ClubRule = rule2.applyRule(playername, forward, username);
						Boolean budgetRule = rule3.applyRule(playername, forward, username);
						Boolean squadnumber = rule4.applyRule(playername, forward, username);
					  if(defenderRule&&ClubRule&&budgetRule&&squadnumber)
						{
							data.replaceBudget(playername, forward, username);
							data.userFile(playername, username, forward);
						}
						else
						{
							System.out.println("can't add this player");
							if(squadnumber==false)
								break;
						}
					 }
					else if(position.equalsIgnoreCase("midfielder"))
					{
						Path path = FileSystems.getDefault().getPath("Midfielders.txt");
						File midfielder = new File(path.toString());
						SquadRules rule1 = new MidfielderRule();
						boolean midfilederRule = rule1.applyRule(playername, midfielder, username);
						boolean ClubRule = rule2.applyRule(playername, midfielder, username);
						boolean budgetRule = rule3.applyRule(playername, midfielder, username);
						boolean squadnumber = rule4.applyRule(playername, midfielder, username);
						System.out.println(midfilederRule);
						System.out.println(ClubRule);
						System.out.println(budgetRule);
						System.out.println(squadnumber);
						if(midfilederRule&&ClubRule&&budgetRule&&squadnumber)
						{
							data.replaceBudget(playername, midfielder, username);
							data.userFile(playername, username, midfielder);
						}
						else
						{
							System.out.println("can't add this player");
							if(squadnumber==false)
								break;
						}
					 }
					else if(position.equalsIgnoreCase("goalkeeper"))
					{
						Path path = FileSystems.getDefault().getPath("Goalkeeprs.txt");
						File goalkeeper = new File(path.toString());
						SquadRules rule1 = new GoalkeeprsRule();
						Boolean defenderRule = rule1.applyRule(playername, goalkeeper, username);
						Boolean ClubRule = rule2.applyRule(playername, goalkeeper, username);
						Boolean budgetRule = rule3.applyRule(playername, goalkeeper, username);
						Boolean squadnumber = rule4.applyRule(playername, goalkeeper, username);
						if(defenderRule&&ClubRule&&budgetRule&&squadnumber)
						{
							data.replaceBudget(playername, goalkeeper, username);
							data.userFile(playername, username, goalkeeper);
						}
						else
						{
							System.out.println("can't add this player");
							if(squadnumber==false)
								break;
						}					 
					}
					
					
				    System.out.println("Done :) ");
				}
				}
			 }
			else if(choice==5)
			 {  
				
				Data data = new Data();
				   System.out.println("you're the admin");
				   System.out.println("what's the gameweek want to add the events ? week1 Or week2");
				    String gameweek = input.next();
					data.ReadWeek(gameweek);
					Path week = FileSystems.getDefault().getPath(gameweek+".txt");
					File weekfile = new File(week.toString());
					data.Gameweek(gameweek);
					String fileweek = gameweek+".txt";
					System.out.println("-----------------------------------------------------------------");
					System.out.println("what events would you like to add?");
					System.out.println("1.StartMatch for players"); //1
					System.out.println("2.goal scored by a goalkeeper or defender");
					System.out.println("3.goal scored by a midfielder"); //5
					System.out.println("4.goal scored by a forward"); //4
					System.out.println("5.For each yellow card");//-1
					System.out.println("6.For each red card");//-3
					System.out.println("7.For each goal assist");//3
				    System.out.println("8.For each own goal"); //-2
				    System.out.println("-----------------------------------------------------------------");
					int choicee = input.nextInt();
					System.out.println("what's the name of the player?");
					String PlayerName = input.next();
					System.out.println("what's your player position?");
					String position = input.next();
					if(position.equalsIgnoreCase("Defender"))
					{
						position = "Defenders.txt";
					}
					else if(position.equalsIgnoreCase("Goalkeeper"))
					{
						position = "Goalkeeprs.txt";
					}
					else if(position.equalsIgnoreCase("Forward"))
					{
						position= "Forwards.txt";
					}
					else if(position.equalsIgnoreCase("Midfielder"))
					{
						position = "Midfielders.txt";
					}
					Events assist = new GoalAssistEvent();
					Events startmatch = new StartMatchEvent();
					Events goal1 = new GoalByGoalkeeperAndDefender();
					Events goal2 =new GoalByMid();
					Events goal3 = new GoalByForward();
					Events yellowCard = new YellowCardEvent();
					Events redCard = new RedCardEvent();
					Events owngoal = new OwnGoalEvent();
					Events event = new GoalEvent();
					Observer eventserver = new UserUpdates(event);
					Observer eventobserver1 = new FilesUpdate(event);
					Observer assistobserver = new UserUpdates(assist);
					Observer assistobserver1 = new FilesUpdate(assist); 
					Observer observer; 
				    if(data.checkPlayerName(PlayerName, weekfile))
				    {
						if(choicee==1)
						{  
							observer = new UserUpdates(startmatch);
							observer = new FilesUpdate(startmatch);
							startmatch.ApplyEvents(PlayerName, position, fileweek);
						}
						else if(choicee==2)
						{  
							observer = new UserUpdates(goal1);
							observer = new FilesUpdate(goal1);
							goal1.ApplyEvents(PlayerName, position, fileweek); 
							System.out.println("what's the assist playerName?");
							String assistName = input.next();
							System.out.println("what's your player position?");
							String positionasst = input.next();
							assist.ApplyEvents(assistName, positionasst, fileweek);
							System.out.println("what's the club Name");
							String club = input.next();
							if(club.equalsIgnoreCase("LiverPool"))
							{
								for(int i=0 ; i<data.team2.size();i++)
								{
									event.ApplyEvents(data.team2.get(i),"Defender", fileweek);
									
								}
								for(int i=0 ; i<data.team2.size();i++)
								{
									event.ApplyEvents(data.team2.get(i),"Goalkeeper", fileweek);
								}
								
							}
							else if(club.equalsIgnoreCase("ManCity"))
							{   
								for(int i=0 ; i<data.team1.size();i++)
								{
									event.ApplyEvents(data.team1.get(i),"Defender", fileweek);
								}
								for(int i=0 ; i<data.team1.size();i++)
								{
									event.ApplyEvents(data.team1.get(i), "Goalkeeper", fileweek);
								}
							}
							else if(club.equalsIgnoreCase("AstonVilla"))
							{
								for(int i=0 ; i<data.team2.size();i++)
								{
									event.ApplyEvents(data.team2.get(i),"Defender", fileweek);
								}
								for(int i=0 ; i<data.team2.size();i++)
								{
									event.ApplyEvents(data.team2.get(i), "Goalkeeper", fileweek);
								}
							}
							else if(club.equalsIgnoreCase("Chelsea"))
							{
								for(int i=0 ; i<data.team1.size();i++)
								{
									event.ApplyEvents(data.team1.get(i),"Defender", fileweek);
								}
								for(int i=0 ; i<data.team1.size();i++)
								{
									event.ApplyEvents(data.team1.get(i), "Goalkeeper", fileweek);
								}
							}
						}
						else if(choicee==3) //goal by midfielder
						{
							observer = new UserUpdates(goal2);
							observer = new FilesUpdate(goal2);
							goal2.ApplyEvents(PlayerName, position, fileweek); 
							System.out.println("what's the assist playerName?");
							String assistName = input.next();
							System.out.println("what's your player position?");
							String positionasst = input.next();
							assist.ApplyEvents(PlayerName, positionasst, fileweek);
							System.out.println("what's the club Name");
							String club = input.next();
							if(gameweek.equalsIgnoreCase("week1")&&club.equalsIgnoreCase("LivelPool"))
							{
								for(int i=0 ; i<data.team2.size();i++)
								{
									event.ApplyEvents(data.team2.get(i),"Defender", fileweek);
								}
								for(int i=0 ; i<data.team2.size();i++)
								{
									event.ApplyEvents(data.team2.get(i), "Goalkeeper", fileweek);
								}
							}
							else if(gameweek.equalsIgnoreCase("week1")&&club.equalsIgnoreCase("ManCity"))
							{
								for(int i=0 ; i<data.team1.size();i++)
								{
									event.ApplyEvents(data.team1.get(i),"Defender", fileweek);
								}
								for(int i=0 ; i<data.team1.size();i++)
								{
									event.ApplyEvents(data.team1.get(i), "Goalkeeper", fileweek);
								}
							}
							else if(gameweek.equalsIgnoreCase("week2")&&club.equalsIgnoreCase("AstonVilla"))
							{
								for(int i=0 ; i<data.team2.size();i++)
								{
									event.ApplyEvents(data.team2.get(i),"Defender", fileweek);
								}
								for(int i=0 ; i<data.team2.size();i++)
								{
									event.ApplyEvents(data.team2.get(i), "Goalkeeper", fileweek);
								}
							}
							else if(gameweek.equalsIgnoreCase("week2")&&club.equalsIgnoreCase("Chelsea"))
							{
								for(int i=0 ; i<data.team1.size();i++)
								{
									event.ApplyEvents(data.team1.get(i),"Defender", fileweek);
								}
								for(int i=0 ; i<data.team1.size();i++)
								{
									event.ApplyEvents(data.team1.get(i), "Goalkeeper", fileweek);
								}
							}
						}
						else if(choicee==4) //goal scored by a forward
						{
							observer = new UserUpdates(goal3);
							observer = new FilesUpdate(goal3);
							goal3.ApplyEvents(PlayerName, position, fileweek); 
							System.out.println("what's the assist playerName?");
							String assistName = input.next();
							System.out.println("what's your player position?");
							String positionasst = input.next();
							assist.ApplyEvents(PlayerName, positionasst, fileweek);
							System.out.println("what's the club Name");
							String club = input.next();
							if(gameweek.equalsIgnoreCase("week1")&&club.equalsIgnoreCase("LivelPool"))
							{
								for(int i=0 ; i<data.team2.size();i++)
								{
									event.ApplyEvents(data.team2.get(i), position, fileweek);
								}
							}
							else if(gameweek.equalsIgnoreCase("week1")&&club.equalsIgnoreCase("ManCity"))
							{
								for(int i=0 ; i<data.team1.size();i++)
								{
									event.ApplyEvents(data.team1.get(i), position, fileweek);
								}
							}
							else if(gameweek.equalsIgnoreCase("week2")&&club.equalsIgnoreCase("AstonVilla"))
							{
								for(int i=0 ; i<data.team2.size();i++)
								{
									event.ApplyEvents(data.team2.get(i), position, fileweek);
								}
							}
							else if(gameweek.equalsIgnoreCase("week2")&&club.equalsIgnoreCase("Chelsea"))
							{
								for(int i=0 ; i<data.team1.size();i++)
								{
									event.ApplyEvents(data.team1.get(i), position, fileweek);
								}
							}
						}
						else if(choicee==5) //goal scored by a forward
						{
							observer = new UserUpdates(yellowCard);
							observer = new FilesUpdate(yellowCard);
							yellowCard.ApplyEvents(PlayerName, position, fileweek);	
						}
						else if(choicee==6) //For each penalty save //5
						{
							observer = new UserUpdates(redCard);
							observer = new FilesUpdate(redCard);
							redCard.ApplyEvents(PlayerName, position, fileweek);
						}
						else if(choicee==7)//For each penalty miss //-2
						{
							assist.ApplyEvents(PlayerName, position, fileweek);
						}
						else if(choicee==8) //8.For every 3 shot saves by a goalkeeper1
						{
							observer = new UserUpdates(owngoal);
							observer = new FilesUpdate(owngoal);
							owngoal.ApplyEvents(PlayerName, position, fileweek);
						} 
						
					  System.out.println("SUCCESSFULY....");
				 }
			 }
			else if(choice==6)
			 {  
				Data data = new Data();
				SquadCalculation squad= new SquadCalculation();
				System.out.println("Login Page");
		    	System.out.println("Please enter username: ");
	    		String username = input.next();
	    		System.out.println("Please enter password: ");
	            String password =input.next();
				if((users.login(username,password)))
				{
				 System.out.println("what's the game week 1 or 2 ?...");  
				 int gameweek = input.nextInt();
				 data.Dataweek(username,gameweek);
				 System.out.println("-------------------------");
				 System.out.println("the score of gameweek: ");
			    }
			 }
			else 
				break;
			
		}
		}
	}

