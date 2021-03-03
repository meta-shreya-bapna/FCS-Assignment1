import java.util.*;

public class JobScheduler {
	
	static void calcTurnAroundTime(int process[][],int waitingTime[],int turnAroundTime[],int totalProcess)
	{
		int i;
		for(i=0;i<totalProcess;i++)
		{
			turnAroundTime[i]= process[i][1]+waitingTime[i];
		}
	}
	
	static void calcCompletionTime(int process[][], int completionTime[], int turnAroundTime[], int totalProcess)
	{
		int i;
		for(i=0;i<totalProcess;i++)
		{
			completionTime[i]=turnAroundTime[i]+process[i][0];
		}
	}
	
	static void calcWaitingTime(int process[][],int waitingTime[], int gant,int totalProcess)
	{
		int i;
		for(i=0;i<totalProcess;i++)
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
	
	static void calcMaxWaitingTime(int process[][],int waitingTime[], int gant, int totalProcess)
	{
		calcWaitingTime(process, waitingTime, gant,totalProcess);
		int maxWaitingTime =0, i;
		for(i=0;i<totalProcess;i++)
		{
			if(maxWaitingTime<waitingTime[i]){
				maxWaitingTime=waitingTime[i];
			}
		}
		System.out.println("\nThe Maximum Waiting Time is : " + maxWaitingTime);
		
	}
	
	static void calcaverageWaitingTime(int process[][],int waitingTime[],int gant, int totalProcess)
	{
		calcWaitingTime(process, waitingTime, gant,totalProcess);
		int i,totalWaitingTime=0;
		
		for(i=0;i<totalProcess;i++){
			totalWaitingTime+=waitingTime[i];
		}
		
		System.out.println("\nThe Average Waiting Time is: "+ totalWaitingTime/totalProcess);
	}
	
	public static void main(String[] args)
	{
		
		
		//int [][]timesAtAndBt ={{0,10},{6,20},{60,10},{110,5}};
		int i,j;
		int gant=0;
		int totalProcessCount =0;
		int noOfTimes=2;
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter the number of Process: ");
		totalProcessCount = sc.nextInt();
		int [][]timesAtAndBt = new int[totalProcessCount][noOfTimes];
		//input of jobs
		int []waitingTime= new int[totalProcessCount];
		int []turnAroundTime=new int[totalProcessCount];
		int []completionTime= new int[totalProcessCount];
		for(i=0; i < totalProcessCount; i++){
			System.out.println("Input for process " + (i+1));
			for( j = 0; j < noOfTimes ; j++){				
				timesAtAndBt[i][j] = sc.nextInt();
			}
		}
		
		calcWaitingTime(timesAtAndBt,waitingTime, gant,totalProcessCount);
		calcTurnAroundTime(timesAtAndBt, waitingTime, turnAroundTime,totalProcessCount);
		calcCompletionTime(timesAtAndBt, completionTime, turnAroundTime,totalProcessCount);
		
        
        System.out.println("\n Process"+"\t Completion Time"+"\t Waiting Time"+"\t Turn Around Time");
		
        for(i=0; i<totalProcessCount;i++)
		{
			j=i+1;
			System.out.println("  " +j+"\t\t" + completionTime[i]+"\t\t\t" + waitingTime[i]+"\t\t\t" + turnAroundTime[i]);
		}
		calcaverageWaitingTime(timesAtAndBt, waitingTime, gant,totalProcessCount);
		calcMaxWaitingTime(timesAtAndBt, waitingTime, gant,totalProcessCount);
		
}
}