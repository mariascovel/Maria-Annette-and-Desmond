import java.io.IOException;
import java.util.Scanner;

/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */
public class MagpieRunner5
{

	/**
	 * Create a Magpie, give it user input, and print its replies.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		Desmond magpie = new Desmond();
		Desmond.readFiles();
		System.out.println ("Hello, let's talk!");
		System.out.println ("What's your name?");
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		System.out.println ("Hi, " + statement + "!\nWait, is "+statement+" really your name?");
		String statement2 = in.nextLine();
		if((statement2.toLowerCase()).contains("no"))
		{
			System.out.println ("I knew it! Come on, what's your real name?");
			String statement3 = in.nextLine();
			Desmond.setName(statement3);
			System.out.println ("Hi, " + statement3 + "!\nHow are you feeling today?");
		}
		else if((statement2.toLowerCase()).contains("yes"))
		{
			System.out.println ("OK! Fantasic");
			Desmond.setName(statement);
			System.out.println ("Hi, " + statement + "!\nHow are you feeling today?");
		}
		else
		{
			System.out.println ("OK, friend!\nHow are you feeling today?");
			Desmond.setName("friend");
		}
	
		
		while (!statement.equals("Bye"))
		{
			statement = in.nextLine();
			System.out.println (magpie.getResponse(statement));
		}
		in.close();
	}

}
