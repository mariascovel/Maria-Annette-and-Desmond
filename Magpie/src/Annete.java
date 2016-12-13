/* Annete Zaslavskaya
 * Mr. Levin
 * Magpie Group Lab 
 * AP Computer Science Java
 * Brooklyn Technical High School
 * 12-10-16
 */
public class Annete {
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		statement = statement.trim();
		String response = " ";
		response = GetInspirationalQuote(statement);
		
		if(response.length() == 0)
			response = getRandomInspirationResponse();
				
		return response;
	}


	/**
	 * Return appropriate inspirational statement from an Array of statements based on the keywords
	 * @param statement is the user statement, assumed to contain keywords
	 * @return the inspiration statement or random statement if doesn't contain keywords
	 */
	private String GetInspirationalQuote(String statement)
	{
		statement = statement.trim();
				
		for(int i=0; i < findingKeyWords.length; i++)
		{
			if(findKeyword (statement, findingKeyWords[i]) >= 0)
				return inspirationalResponses[i];			
		}
		
		return "";
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomInspirationResponse()
	{
		final int NUMBER_OF_RESPONSES = randomResponses.length;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
				
		return "I don't quite understand, but I hope this quote can lighten your mood: "+randomResponses[whichResponse];
	}
	private int findKeyword(String statement, String goal) {
		return findKeyword(statement,goal,0);
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
	// these responses are for when it can't match it to an inspirational quote but knows it belongs to this class. last scenario responses
	private String[] randomResponses = {
			"Happiness is not something you postpone for the future; it is something you design for the present.",
			"It is during our darkest moments that we must focus to see the light.",
			"Health is the greatest gift, contentment the greatest wealth, faithfulness the best relationship.",
			"No act of kindness, no matter how small, is ever wasted.",
			"Perfection is not attainable, but if we chase perfection we can catch excellence.",
			"In order to carry a positive action we must develop here a positive vision.",
			"We must let go of the life we have planned, so as to accept the one that is waiting for us."
	 re};
	private String[] findingKeyWords = {
			"school",
			"sick",
			"fail",
			"money",
			"stress",
			"ugly",
			"homework"
	};
	private String[] inspirationalResponses = {
			"The best preparation for tomorrow is doing your best today.",
			"Our mind is what can control our health and let us be happy.",
			"Believe you can and you’re halfway there.",
			"If opportunity doesn't knock, build a door.",
			"Believe that life is worth living and your belief will help create the fact.",
			"It is important to stay positive because beauty comes from the inside out.",
			"Procrastination is the thief of time, collar him."
	};
}
