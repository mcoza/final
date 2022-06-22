package Final;

//mark cozart 06/19/2022

//final partner arthur umerov

import java.util.Iterator;
import java.util.Scanner;


public class Driver {
	
	private static DirectedGraph<Profile> userGraph = new DirectedGraph<>();
	
	
	public static void main(String[] args) 
	{		
        System.out.println("Welcome to Social Disaster.");
        interactWithUser();
	}  // end main
	
	
	
	public static void display(Profile userProfile)
    {
      
		QueueInterface<Profile> dfs = userGraph.getBreadthFirstTraversal(userProfile);
		printQueue(dfs);
    } // end display
	
	
	
	
	public static void printQueue(QueueInterface<Profile> q)
	{
	    while (!q.isEmpty())
	        printProfile(q.dequeue());
	        
	     System.out.println("--------------------")   ;
	} // end printQueue 
	
	
	
	
	public static void printProfile(Profile userProfile)
    {
        System.out.println("Name: " + userProfile.getName());
        System.out.println("Status: " + userProfile.getStatus());
        System.out.println("Friends: " + userProfile.getFriends().getLength()+" "+ userProfile.getFriends().toString());

    }//end print profile
	
	
	public static void displayStartMenu()
	{
	
		System.out.print("\nChoose from these options:\n\n"
		
				+ "1. Create Profile\n"
				+ "2. Exit Social Disaster\n"
				+ "Enter Choice: ");
				
	}//end Display Start menu
	
	
	
	public static void displayMenu(Profile userProfile) 
	{
		System.out.println("\nUser Profile");
		printProfile(userProfile);
		
		System.out.print("\nChoose from the options:\n"				
	
				+"1. Edit Profile\n"
				+ "2. Search for a profile\n"
				+ "3. Add or Remove friends\n"
				+ "4. Exit\n"
				
				+ "Enter Choice: ");
			
	}//end display menu
	
	
	public static void editProfile(Profile userProfile) 
	{
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		
		boolean askAgain=true;	
		while(askAgain)
		{					
			System.out.print("\nTo Edit your Profile; Choose from these options:\n\n"
				
				+ "1. Change Profile Name\n"
				+ "2. Change "+ userProfile.getStatus() + " status\n"
				+ "3. Back\n"							
				+ "Enter  Choice: ");
		
			int answer=sc.nextInt();
			
			if (answer==1) 
			{
			System.out.println("\nEnter your Name: "+sc.nextLine());   	
	    	String newName=sc.nextLine();
	    	userProfile.setName(newName);
			}
			
			
			else if(answer==2) 
			{
				boolean askStatus = true;
                while(askStatus)
                {
                    System.out.println("\nEnter 1 to set status as Online.");
                    System.out.println("Enter 2 to set status as Offline.");
                    System.out.println("Enter 3 to set status as Busy.");
                    System.out.println("Enter 0 to go back.");
                    
                    int newStatus = sc.nextInt();
                 
                    switch(newStatus)
                    {
                    case 1:
                        userProfile.setOnlineStatus();
                        System.out.println("Confirmed status has been changed to: "+userProfile.getName());
                        break;
                    case 2:
                        userProfile.setOfflineStatus();
                        System.out.println("Confirmed status has been changed to: "+userProfile.getName());
                        break;
                    case 3:
                        userProfile.setBusyStatus();
                        System.out.println("Confirmed status has been changed to: "+userProfile.getName());
                        break;
                    case 0:
                        askStatus = false; 
                        break;
                    }//end switch
                    
                }//end while
				
			}//end else if
			
			else if (answer==3)break;
			
		}//end while
		
	}//end edit profile
	
	
	public static void populateList(Profile userProfile)
	{
		
		Profile Batman= 	  new Profile("Batman");
		Profile SpiderMan=    new Profile("SpiderMan");
		Profile Hulk=		  new Profile("Hulk");
		Profile IronMan= 	  new Profile("IronMan");
		Profile SuperMan= 	  new Profile("SuperMan");
		Profile Flash= 	 	  new Profile("Flash");
		Profile JohnnyDepp=   new Profile("JohnnyDepp");
		Profile ScarletWitch= new Profile("ScarletWitch");
		
	
		userGraph.addVertex(Batman);
		userGraph.addVertex(SpiderMan);
		userGraph.addVertex(Hulk);
		userGraph.addVertex(IronMan);
		userGraph.addVertex(SuperMan);
		userGraph.addVertex(Flash);
		userGraph.addVertex(JohnnyDepp);
		userGraph.addVertex(ScarletWitch);
		
		
		userGraph.addEdge(userProfile, Batman);
		userGraph.addEdge(Batman, SpiderMan);
		userGraph.addEdge(SpiderMan, Hulk);
		userGraph.addEdge(Hulk,IronMan);		
		userGraph.addEdge(IronMan, SuperMan);
		userGraph.addEdge(SuperMan,Flash);		
		userGraph.addEdge(Flash, JohnnyDepp);
		userGraph.addEdge(JohnnyDepp, ScarletWitch);
		userGraph.addEdge(ScarletWitch, userProfile);
		
	
		
		
		Hulk.addFriend(Batman);
		Batman.addFriend(SpiderMan);
		SpiderMan.addFriend(Hulk);
		
	}// end populate list

	
	public static void friendEdit(Profile userProfile)
	{
		Scanner sc = new Scanner(System.in);
         
         String name;
        
       int ans= -1;
         while(ans!=0) 
         {       
        	 System.out.println("\nEnter 1 to add friend.");
             System.out.println("Enter 2 to remove friend.");
             System.out.println("Enter 0 to go back.");
              ans = sc.nextInt();
             
        	 switch(ans)
        	 {
 			
 				case 1:
 					searchProfiles(userProfile);
 					
 					System.out.println ("Enter the person you'd like to add: ");
 					sc.nextLine();
 					name=sc.nextLine();
 			
 					System.out.println (addFriend(userProfile,name));
 				
 					break;
 				
 				case 2:
 					System.out.println ("enter name of person youd like to remove");
 					sc.nextLine();
 					name=sc.nextLine();
 					
 					System.out.println(removeFriend(userProfile,name));
 					break;
        
 		
        	}
         }
	
   }
	
	
	
	public static String removeFriend(Profile userProfile,String name) 
	{
		
		String state= "error";
			
		Profile foundUser= findUser(userProfile, name);
		
		
		if(foundUser!=null) 
			{
			
			boolean successful=	userProfile.removeFriend(foundUser);
			
				if(successful==true)
					state="Successfully removed friend";
				
				else
					state="This user is not on your friends list";
			}
		
			else 
			{
				state="This user does not exist";			
			}
			
		return state;
		
	}//end remove friend
	
	public static String addFriend(Profile userProfile,String name) 
	{
		
		String successful;
		
		
		Profile foundUser= findUser(userProfile, name);
			if(foundUser==userProfile)
			{
				System.out.println();
				
				successful="user is already on your friends list";
			}
				
				
			else if(foundUser!=null) 
			{
			
				
			successful=userProfile.addFriend(foundUser);;
					
			}
					
					
			else
			{
			successful="profile does not exist.";
			}				
		
			
		return successful;
	}//end add friend
	
	public static void searchProfiles(Profile userProfile) {
		
		System.out.println("\nFriends within Network\n");
		
		display(userProfile);
		System.out.println("______________________________");
		
	}//end search profiles
	
	
	public static  Profile findUser(Profile userProfile, String name)
    {
		Profile out=null;
        QueueInterface<Profile> userQueue = userGraph.getDepthFirstTraversal(userProfile);
        while (!userQueue.isEmpty())
        {
            Profile front = userQueue.dequeue();
            if(front.getName().toUpperCase().equals(name.toUpperCase()))
               out=front;
            
            
        }
        return out;
    }//end findUser
	
	
	
	public static void interactWithUser()
    {
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

        boolean numbersNotOneOrTwo = true;
        while(numbersNotOneOrTwo)
        {
            displayStartMenu();

            int ans = sc.nextInt();
           
            if (ans == 1)
            {             
                numbersNotOneOrTwo = false;
            }
            
            else if (ans == 2)
            {
                System.out.println("Thank you for being a disaster");
                System.exit(0);
            }
            else
            {
                System.out.println("\nTry Again ");
                System.out.println("____________________________ ");
            }//end if
            
        }//end while

       
       // DictionaryInterface<String, Profile> userList = new HashedDictionary<>();
     
        //creating profile
    	System.out.println("\nEnter your Name: "+sc.nextLine());   	
    	String userName=sc.nextLine();
    	Profile userProfile= new Profile(userName);
    	
    	userGraph.addVertex(userProfile);
    	
    	populateList(userProfile);
    	
    	int action=-1;
    	
    	while(action!=4)
    	{
    	
    		displayMenu(userProfile);
        
    		action=sc.nextInt();
    	
    	
    		switch(action) 
    		{
    		
    		case -1:
    			System.out.println("error");
    			break;
    		case 1:
    			editProfile(userProfile);
    			break;
    		case 2:
    			searchProfiles(userProfile);
    			break;
    		case 3:
    			friendEdit( userProfile);
    			break;
    		
    		}//end switch 		
    		
    	}//end while
    	System.out.println("thank you");
     
    }//end interactWithUser
	
}//end driver
