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
		magpie.setName(statement);
		System.out.println ("What do you like to do?");
		
		while (!statement.equals("Bye"))
		{
			System.out.println (magpie.getResponse(statement));
			statement = in.nextLine();
		}
	}

}
