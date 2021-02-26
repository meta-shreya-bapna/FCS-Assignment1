import java.util.*;
import java.lang.*;
import java.util.Scanner;

public class HexCalc {
	
	public static void add(int value1,int value2)
	{
		int sum = value1 + value2;
		System.out.println(Integer.toHexString(sum).toUpperCase());
	}
	
	public static void subtract(int value1,int value2)
	{
		int subtraction = Math.abs(value1 - value2);
		System.out.println(Integer.toHexString(subtraction).toUpperCase());
	}
	
	public static void multiply(int value1,int value2)
	{
		long product = value1 * value2;
		System.out.println(Long.toHexString(product).toUpperCase());
	}
	
	public static void divide(int value1,int value2)
	{
		int quotient = value1/ value2;
		int remainder = value1 % value2; 
		System.out.println("Quotient= "+Integer.toHexString(quotient).toUpperCase()+" and "+" remainder= "+ Integer.toHexString(remainder).toUpperCase());
	}
	
	public static void compare()
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter 2 hexadecimals to compare");
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
		int choice,hex1,hex2;
		Scanner sc = new Scanner(System.in);
		
		while(flag==true){
			System.out.println("1.Add, sub, multiply or divide 2 hexadecimal numbers");
			System.out.println("2.Compare 2 hexadecimal numbers");
			System.out.println("3.Decimal number to hexadecimal conversion");
			System.out.println("4.Hexadecimal to decimal conversion");
			System.out.println("5.Exit");
		
			choice= sc.nextInt();
			switch(choice)
			{
			case 1:{
				System.out.println("Enter the first hexa decimal number");
				String number1= sc.next();
				System.out.println("Enter the second hexa decimal number");
				String number2= sc.next();
				System.out.println("Press 1: add\t 2: sub\t 3: mult\t 4: divide ");
				int operationChoice= sc.nextInt();
				hex1 =Integer.parseInt(number1,16);
				hex2 =Integer.parseInt(number2,16);
				
				switch(operationChoice){
				case 1:
					
					add(hex1,hex2);
					break;
				
				
				case 2:
					
					subtract(hex1, hex2);
					break;
					
				case 3:
					
					multiply(hex1,hex2);
					break;
				
				case 4:
					
					divide(hex1,hex2);
					break;
					
				default:
					System.out.println("Invalid input number");
				}
			
			}
			break;
			
			case 2:
				compare();
				break;
				
			case 3:
				int decimalToHex= sc.nextInt();
				System.out.println(Integer.toHexString(decimalToHex).toUpperCase());
				break;
				
			case 4:
				String hexaToDecimal=sc.next();
				int decimal= Integer.parseInt(hexaToDecimal,16);
				System.out.println(decimal);
				break;
				
			case 5:
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