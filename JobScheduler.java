import java.util.*;

public class JobScheduler {
	
	static void calcTurnAroundTime(int process[][],int waitingTime[],int turnAroundTime[])
	{
		int i;
		for(i=0;i<4;i++)
		{
			turnAroundTime[i]= process[i][1]+waitingTime[i];
		}
	}
	
	static void calcCompletionTime(int process[][], int completionTime[], int turnAroundTime[])
	{
		int i;
		for(i=0;i<4;i++)
		{
			completionTime[i]=turnAroundTime[i]+process[i][0];
		}
	}
	
	static void calcWaitingTime(int process[][],int waitingTime[], int gant)
	{
		int i;
		for(i=0;i<4;i++)
		{
			if(gant - process[i][0]<=0)
			{
				waitingTime[i]=0;
				gant= process[i][0]+process[i][1];
			}
			else
			{
				waitingTime[i]=gant-process[i][0];
			}
		}
	}
	
	static void calcMaxWaitingTime(int process[][],int waitingTime[], int gant)
	{
		calcWaitingTime(process, waitingTime, gant);
		int maxWaitingTime =0, i;
		for(i=0;i<4;i++)
		{
			if(maxWaitingTime<waitingTime[i]){
				maxWaitingTime=waitingTime[i];
			}
		}
		System.out.println("\n MAXIMUM Waiting Time is : " + maxWaitingTime);
		
	}
	
	static void calcaverageWaitingTime(int process[][],int waitingTime[],int gant)
	{
		calcWaitingTime(process, waitingTime, gant);
		int i,totalWaitingTime=0;
		
		for(i=0;i<4;i++){
			totalWaitingTime+=waitingTime[i];
		}
		
		System.out.println("\nThe Average Waiting Time is: "+ totalWaitingTime/4);
	}
	
	public static void main(String[] args)
	{
		int processes[] ={1,2,3,4};
		int totalProcessCount= processes.length;
		int [][]timesAtAndBt ={{0,10},{6,10},{60,10},{110,5}};
		int []waitingTime= new int[totalProcessCount];
		int []turnAroundTime=new int[totalProcessCount];
		int []completionTime= new int[totalProcessCount];
		
		String more;
		int i,choice,gant=0;
		Scanner sc= new Scanner(System.in);
		do
		{
			System.out.println("\n 1: Waiting Time "+"\n 2: Completion Time" +"\n 3: Turn Around Time "+"\n 4: Maximum Waiting Time"+"\n 5: Average Waiting Time");
			choice =sc.nextInt();
			
			switch(choice)
			{
			case 1: 
				calcWaitingTime(timesAtAndBt,waitingTime, gant);
				int processNo;
				System.out.println("\n Process"+"\t Waiting Time");
				for(i=0; i<4;i++)
				{
					processNo=i+1;
					System.out.println("  " +processNo+"\t\t" + waitingTime[i]);
				}
				break;
			
			case 2:
				calcTurnAroundTime(timesAtAndBt, waitingTime, turnAroundTime);
				calcCompletionTime(timesAtAndBt, completionTime, turnAroundTime);
				int procNo;
				System.out.println("\n Process"+"\t Completion Time");
				for(i=0;i<4;i++)
				{
					procNo=i+1;
					System.out.println("  " +procNo+"\t\t" + completionTime[i]);
				}
				break;
			
			case 3:
				calcTurnAroundTime(timesAtAndBt, waitingTime, turnAroundTime);
				int processNum;
				System.out.println("\n Process"+"\t Turn Around Time");
				for(i=0;i<4;i++)
				{
					processNum=i+1;
					System.out.println("  " +processNum+"\t\t" + turnAroundTime[i]);
				}
				break;
			
			case 4: 
				calcaverageWaitingTime(timesAtAndBt, waitingTime, gant);
				break;
			
			case 5: 
				calcMaxWaitingTime(timesAtAndBt, waitingTime, gant);
				break;
			
			default:
				System.out.println("\n Invalid Input: ");
			}
			
			System.out.println("Want to enter More ?(Y/N) : ");
			more = sc.next();
		}while(more.equals("Y")|| more.equals("y"));
		sc.close();
	}

}
