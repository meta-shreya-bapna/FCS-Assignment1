import java.util.*;
import java.lang.*;
import java.util.Scanner;

public class HexCalc {
	
	public static int[] convert(String number1,String number2,int base)
	{
		int[] number=new int[2];
		number[0] =Integer.parseInt(number1,base);
		number[1] =Integer.parseInt(number2,base);
		return(number);
	}
	
	public static String add(String num1,String num2,int base)
	{	int []value= convert(num1,num2,base);
		
		int sum = value[0] + value[1];
		return(Integer.toString(sum, base).toUpperCase());
	}
	
	public static String subtract(String num1,String hex2,int base)
	{
		int []value= convert(num1,hex2,base);
		int subtraction = Math.abs(value[0] - value[1]);
		return(Integer.toString(subtraction, base).toUpperCase());
	}
	
	public static String multiply(String num1,String hex2,int base)
	{
		int []value= convert(num1,hex2,base);
		long product = value[0] * value[1];
		return(Long.toString(product, base).toUpperCase());
	}
	
	public static String divide(String num1,String hex2,int base)
	{
		int []value= convert(num1,hex2,base);
		int quotient = value[0]/ value[1]; 
		return(Integer.toString(quotient, base).toUpperCase());
	}
	
	public static void compare()
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter 2 numbers to compare");
		String hexToCompareValue1 = sc.next().toUpperCase();
		String hexToCompareValue2 =sc.next().toUpperCase();
		System.out.println("Comparing "+ hexToCompareValue1+" and "+ hexToCompareValue2+":");
		int result= hexToCompareValue1.compareTo(hexToCompareValue2);
		
		if(result>0)
			System.out.println(hexToCompareValue1+" is greater than "+hexToCompareValue2);
		else if(result==0)
			System.out.println("Both are equal");
		else
			System.out.println(hexToCompareValue2+" is greater than "+hexToCompareValue1);
		
	}

	public static void main(String[] args) {
		boolean flag=true;
		int choice;
		String result="";
		Scanner sc = new Scanner(System.in);
		
		while(flag==true){
			System.out.println("1.Add, sub, multiply or divide 2 numbers");
			System.out.println("2.Compare 2 numbers");
			System.out.println("3.For conversion");
			System.out.println("4.Exit");
		
			choice= sc.nextInt();
			switch(choice)
			{
			case 1:{
				System.out.println("Enter the base to use");
				int base=sc.nextInt();
				System.out.println("Enter the first number");
				String number1= sc.next();
				System.out.println("Enter the second number");
				String number2= sc.next();
				
				System.out.println("Press 1: add\t 2: sub\t 3: mult\t 4: divide ");
				int operationChoice= sc.nextInt();

				
				switch(operationChoice){
				case 1:
					
					result=add(number1,number2,base);
					break;
				
				
				case 2:
					
					result= subtract(number1,number2,base);
					break;
					
				case 3:
					
					result=multiply(number1,number2,base);
					break;
				
				case 4:
					
					result=divide(number1,number2,base);
					break;
					
				default:
					System.out.println("Invalid input number");
				}
			System.out.println("Result is : "+ result);
			}
			break;
			
			case 2:
				compare();
				break;
				
			case 3:
				
				System.out.println("Enter the number with base to convert");
				String num= sc.next();
				int base1 =sc.nextInt();
				int number =Integer.parseInt(num,base1);
				System.out.println("\nEnter the number to convert the base into");
				int base2=sc.nextInt();
				
				System.out.println("Result is: "+Integer.toString(number, base2).toUpperCase()+"\n");
				break;
				
			case 4:
				
				flag= false;
				break;
				
			default:
				System.out.println("Invalid input");
			}
		}
		sc.close();
	}

}
//example
//input1 ="8AB";
//input2 ="B78";