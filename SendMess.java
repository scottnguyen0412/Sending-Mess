package Messages;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SendMess {
		ArrayList<Character> sourceBuffer = new ArrayList<>();
		Queue<Character> desBuffer = new LinkedList<>();
		int maxBuffer = 50; //size of sourceBuffer = desBuffer
		
		int send(String source) //throws Exception
		{
			String destination = "";
			int a; int b = 0;
			int count = 0; //count times buffer
			if(source.length() == 0)
			{
				System.out.println("Empty message!!");
				return 0;
				//throw new Exception ("No input. Error!!");
			}else if(source.length() >250)
			{
				System.out.println("Message have more 250. Too Long!!!!");
				return 0;
				//throw new Exception("Index was outside bound of array");
			}else	
			{
			try
				{
				System.out.println("Number of character in message in a1: "+ source.length());
				System.out.println();
					for( a = 0; a< source.length(); a++) // source is not full
					{
						sourceBuffer.add(source.charAt(a)); //adding to sourceBuffer
						if(a == (source.length()-1) || sourceBuffer.size() == maxBuffer)
						{
							while(sourceBuffer.size() >0)
							{
									desBuffer.offer(sourceBuffer.get(b)); //insert sourceBuffer to desBuffer
									sourceBuffer.remove(b);
									if( a == (source.length() -1) || desBuffer.size() == maxBuffer)
									{
										while(desBuffer.size() >0)
										{
											destination = destination + desBuffer.remove(); //destination
											
										}
										count++; //count buffer from desBuffer to destination 
									}			
							}
						}	
					}
				}
				catch(Exception e)
				{
					System.out.println("Something went wrong "+ e.getMessage()); //get exception
					return 0;
				}	
				System.out.println("\nDestination message a2: " + destination);
	            System.out.println("Number of character in message a2: " + destination.length());   	        
	            return count; //return success	
				}
			}
		public static void main(String[] args) //throws Exception
		{
			SendMess sendMess = new SendMess();
			Scanner sc = new Scanner(System.in);
			System.out.print("Source a1: \n");
			
			String source1 = sc.nextLine();
			double start = System.currentTimeMillis(); //get the system time at starting point
			int count = sendMess.send(source1);
			double finish = System.currentTimeMillis();//get the system time at finish point
			double duration = (finish - start)/sendMess.maxBuffer; // get running time
			double space = sendMess.maxBuffer*2; // space of Ram
			sc.close();
			if(count >0)
			{
				System.out.println("Sent message success");
				System.out.println("Times buffer usage: "+ count +" times");
				System.out.printf("\nTime : %.2f ms", duration);
				System.out.printf("\nSpace: %.1f byte", space);

			}else
			{
				System.out.println("Not Success");
			}	
		}
}
