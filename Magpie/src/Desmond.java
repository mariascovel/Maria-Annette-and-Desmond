
public class Desmond 
{
	
	public static void main(String[] args) throws IOException
	{
		//positive();
		negative();
		Scanner input = new Scanner(System.in);
		String statement = input.nextLine();
		input.close();
		polarizeResponse(statement);
		analyze(statement);

	
	}
	
	public static void polarizeResponse(String statement)
	{
		StringTokenizer words = new StringTokenizer(statement, " ,.!?");
		int numWords = words.countTokens();
		System.out.println(numWords);
		String [] wordsArray = new String [numWords];
		int sentiment = 0;
		int x = 0;
		while (words.hasMoreTokens())
		{
			wordsArray[x] = words.nextToken();
			System.out.println(wordsArray[x]);
			sentiment += polarize(wordsArray[x]);
			x++;
		}
	}
	
	public static void analyze(String statement)
	{
		int sentenceCount = 0;
		int beginPosition = 0;
		int endPosition = 0;
		
		while(endPosition < statement.length())
		{
			char letter = statement.charAt(endPosition);
			if (letter =='!')
			{
				sentenceCount++;
				String sentence = statement.substring(beginPosition, endPosition+1);
				System.out.println(sentence);
				beginPosition = endPosition+1;
			}
		
			else if (letter =='?')
			{
				sentenceCount++;
				String sentence = statement.substring(beginPosition, endPosition+1);
				System.out.println(sentence);
				beginPosition = endPosition+1;
			}
		
			else if (letter =='.')
			{
				sentenceCount++;
				String sentence = statement.substring(beginPosition, endPosition+1);
				System.out.println(sentence);
				beginPosition = endPosition+1;
			}
			endPosition++;
        }
		
		if (beginPosition < statement.length())
		{
			sentenceCount++;
			String sentence = statement.substring(beginPosition, statement.length());
			System.out.println(sentence);
		}
		
	}
	public static void analyzeSentence(String statement)
	{
		int wordCount = 0;
		int sentenceLength = 0;
		int beginPosition = 0;
		int endPosition = statement.indexOf(' ');
		int avgWordLength = 0;
		
		while (endPosition != -1)
		{
			
			if (endPosition > beginPosition)
			{
				wordCount++;
				String word = statement.substring(beginPosition, endPosition);
				sentenceLength += word.length();
			}
				
			beginPosition = endPosition + 1;
            endPosition = statement.indexOf(' ', beginPosition);
        }
			
		if (beginPosition < statement.length())
		{
		   wordCount++;
		   String word = statement.substring(beginPosition, statement.length());
		   sentenceLength += word.length();
		}
		
		avgWordLength = sentenceLength / wordCount;
		if (wordCount > 0)
		{
			System.out.println("Word count: " + wordCount);
			System.out.println("Sentence length: " + sentenceLength);
			System.out.println("Average word length: " + avgWordLength);
		}
	}
	
	public static void response(String statement)
	{
			
	}
	
	public static void statement(String statement)
	{
			
	}
	
	public static void exclamtion(String statement)
	{
			
	}
	
	public static void question(String statement)
	{
		
	}
	public static int polarize(String statement)
	{
		
		return 0;	
	}
	public static void positive() throws IOException
	{
		File file = new File("E://text.txt");
		Scanner input = new Scanner(file);
		int  wordCount = 0;
		while(input.hasNext())
		{
			wordCount++;
			input.next();
		}
		input.close();
		Scanner input2 = new Scanner(file);
		String[] array = new String[wordCount];
		int x = 0;
		input2.delimiter();
		while(input2.hasNext())
		{
			array[x]=input2.next();
			x++;
		}
		input.close();
		printArray(array);
	}
	public static void negative() throws IOException
	{
		List<String> arrayList = new ArrayList<>();
		File file = new File("E://text.txt");
		Scanner negative = new Scanner(file);
		negative.reset();
		while(negative.hasNext())
		{
			arrayList.add(negative.next());
		}
		negative.close();
		printList(arrayList);
		
	}
	public static void printArray(String [] array)
	{
		for(String	x : array)
		{
			System.out.println(x);
		}
	}
	public static void printList(List<String> list)
	{
		for(String	x : list)
		{
			System.out.println(x);
		}
	}
	

}
