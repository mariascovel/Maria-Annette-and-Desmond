
public class Maria 
{
	String stringReturned;
	public Maria ()
	{
		stringReturned = null;
	}
	public void stringSetter (String statement)
	{
		statement = statement.trim();
		
		for(int i=0; i < findingKeyWords.length; i++)
		{
			if(findKeyword (statement, findingKeyWords[i]) >= 0)
				stringReturned=inspirationalResponses[i];
			else
			{ 
				final int NUMBER_OF_RESPONSES = randomQuestion.length;
				double r = Math.random();
				int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
				stringReturned = randomQuestion[whichResponse];
			}
		}
	}
	private int findKeyword (String statement, String goal) {
		return findKeyword (statement,goal,0);
	}
	private int findKeyword(String statement, String goal, int startPos) {
		
		//  The only change to incorporate the startPos is in the line below
		int psn = statement.toLowerCase().indexOf(goal.toLowerCase(), startPos);

		//  Refinement--make sure the goal isn't part of a word
		while (psn >= 0)
		{
			//  Find the string of length 1 before and after the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = statement.substring (psn - 1, psn).toLowerCase();
			}
			if (psn + goal.length() < statement.length())
			{
				after = statement.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
			}

			//  If before and after aren't letters, we've found the word
			if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
					&& ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
			{
				return psn;
			}

			//  The last position didn't work, so let's find the next, if there is one.
			psn = statement.indexOf(goal.toLowerCase(), psn + 1);

		}

		return -1;
	}
	private String[] findingKeyWords = {
			"party",
			"hangout",
			"love",
			"money",
			"children",
			"beautiful",
			"success"
	};
	private String[] inspirationalResponses = {
			"'A little party never hurt anybody'",
			"'I like to go out if there's a party or go to the movies, but I just like hanging out with my buddies and having a good time. Jean-Luc Bilodeau'",
			"'It’s often just enough to be with someone. I don’t need to touch them. Not even talk. A feeling passes between you both. You’re not alone.' Marilyn Monroe",
			"'Money makes the world go around.",
			"'The greatest gifts you can give your children are the roots of responsibility and the wings of independence.' Denis Waitley",
			"'Beauty is when you can appreciate yourself. When you love yourself, that's when you're most beautiful.' Zoe Kravitz",
			"'Success is not the key to happiness. Happiness is the key to success. If you love what you are doing, you will be successful'"
	};
	private String [] randomQuestion = {
			"'Tell me more.'",
			"'Can you expand?'",
			"'Is this reoccuring?'"
	};
	public String getResponse()
	{
		return stringReturned;
	}
}

