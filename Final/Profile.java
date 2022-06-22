package Final;
//mark cozart 06/19/2022
//final partner arthur umerov
public class Profile 
{
	private String name;
	private String status;
	public AList<Profile> friends;
  
	//constructors
	public Profile()
	{
		this.name = "Humphrey Hughes";
		this.status = "Online";
		this.friends = new AList<>();
	}
		
	public Profile(String name) 
	{
		this.name = name;
		this.status = "Online";
		this.friends = new AList<>();
	}
	
	
	//Getters & Setters
	
	public String getName() 
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getStatus()
	{ 
	return status; 
	}
  
	public void setOnlineStatus()
	{
	this.status = "Online";
	}
	  
	public void setOfflineStatus()
	{
	this.status = "Offline";
	}
	  
	public void setBusyStatus()
	{
	this.status = "Busy";
	}
  //end getters and setters
	
	
	
	public AList<Profile>getFriends()
	{
		return friends;
	}
	
	
	public String addFriend(Profile friendToAdd) 
	{
		String succesful="";
		
		boolean alreadyFriend=false;
		
		for(int i=0;i<friends.getLength();i++)
			{
			if(friendToAdd==friends.getEntry(i))
				succesful="user is already on your friends list";
		
			alreadyFriend=true;
			}
		
		if(!alreadyFriend) 
		{
			friends.add(friendToAdd);
				
			succesful="successfully added friend";
		}
				
				
			return succesful;
	}
	

	public boolean removeFriend(Profile friendToRemove)
	{
		boolean successful=false;
		
		for(int i=1;i<=friends.getLength();i++)
		{
			
			if(friends.getEntry(i)==friendToRemove) 
			{
				friends.remove(i);
				
				successful=true;
			}
			
		}
		
		return successful;
			
	}//end remove friend
	
}//end profile