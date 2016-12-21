import java.util.*;
import java.io.*; 

public class Desmond 
{
	private static String posArray [];
	private static String negArray[];
	
	private int sentenceCount;
	private int wordCount;
	private int sentenceLength;
	private int avgWordLength;
	
	
	public Desmond (String statement)
	{
		
		
	}
	
	public static int polarizeResponse(String statement)
	{
		
		int pos = positive(statement);
		int neg = negative(statement);
		return pos + neg;
		
	}
	
	public void analyze(String statement)
	{
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
	public void analyzeSentence(String statement)
	{
		int beginPosition = 0;
		int endPosition = statement.indexOf(' ');
		
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
	}
	
	public static int positive(String statement)
	{
		int positive = 0;
		StringTokenizer strTkn = new StringTokenizer(statement, " -.,\n\r\t\b\f–!?:;");	
		int length = strTkn.countTokens();

		while(strTkn.hasMoreTokens())
		{
			String word = strTkn.nextToken();
			boolean contain = false;
			for(int x= 0; x<posArray.length && !contain; x++)
			{
				if(word.toLowerCase().equals(posArray[x].toLowerCase()))
				{
					positive++;
					contain= true;
				}
			}
			
		}
		return positive;	
	}
	
	public static int negative(String statement)
	{
		int negative = 0;
		StringTokenizer strTkn = new StringTokenizer(statement, " -.,\n\r\t\b\f–!?:;");	
		int length = strTkn.countTokens();

		while(strTkn.hasMoreTokens())
		{
			String word = strTkn.nextToken();
			boolean contain = false;
			for(int x= 0; x < negArray.length && !contain; x++)
			{
				if(word.toLowerCase().equals(negArray[x].toLowerCase()))
				{
					negative--;
					contain= true;
				}
			}
			
		}
		return negative;	
	}
	
	public static void positiveFile() throws IOException
	{
		Scanner x = new Scanner(new File("positiveWords.txt"));
		String entireFileText = x.useDelimiter("\\Z").next();
		x.close();
		
		StringTokenizer strTkn = new StringTokenizer(entireFileText, " -.,\n\r\t\b\f–");
		int length = strTkn.countTokens();
		String array [] = new String[length];
		int y=0;
		String posWord = "";

		while(strTkn.hasMoreTokens())
		{
			posWord = strTkn.nextToken();
			array [y] = posWord;
			y++;
			System.out.print(posWord+" ");
		}
		quickSort(array);
		posArray= removeDuplicates(array);
	}
	public static void negativeFile() throws IOException
	{
		Scanner x = new Scanner(new File("negativeWords.txt"));
		String entireFileText = x.useDelimiter("\\Z").next();
		x.close();
		
		StringTokenizer strTkn = new StringTokenizer(entireFileText, " -.,\n\r\t\b\f–");
		int length = strTkn.countTokens();
		String array [] = new String[length];
		int y=0;
		String negWord = "";

		while(strTkn.hasMoreTokens())
		{
			negWord = strTkn.nextToken();
			array [y] = negWord;
			y++;
			System.out.print(negWord+" ");
		}
		quickSort(array);
		negArray= removeDuplicates(array);
	}
	
	public static void readFiles() throws IOException
	{
		positiveFile();
		negativeFile();		
	}
	
	public static void readFiles(String filePath, String [] fileArray) throws IOException
	{
		Scanner x = new Scanner(new File(filePath));
		String entireFileText = x.useDelimiter("\\Z").next();
		x.close();
		
		StringTokenizer strTkn = new StringTokenizer(entireFileText, " -.,\n\r\t\b\f–");
		int length = strTkn.countTokens();
		String array [] = new String[length];
		int y=0;
		String word = "";

		while(strTkn.hasMoreTokens())
		{
			word = strTkn.nextToken();
			array [y] = word;
			y++;
			System.out.print(word+" ");
		}
		quickSort(array);
		fileArray= removeDuplicates(array);
		printArray(fileArray);
		
		
		/*
		FileWriter fw = new FileWriter("C:\\Users\\daska\\Desktop\\positiveWords.txt");
		PrintWriter output= new PrintWriter(fw);
		
		for(int v = 0, posLength = posArray.length; v < posLength ; v++)
		{
			output.print(posArray[v] +" ");
		}
		output.close();
		fw.close();
		*/
		
		
			
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
	public static String[] removeDuplicates(String[] list) //This method takes an input array and returns a new array without duplicates.
	{
		String newList [] = new String [list.length];
		int finalLength= 0;
		for( int x = 0, z = 0; x < list.length ; x++)
		{
			boolean unique = true;
			for( int y = x+1; y<list.length && unique ; y++)
			{
				if(list[x].equalsIgnoreCase(list[y]))
				{
					unique = false;
				}
			}
			if(unique)
			{
				newList [z] = list [x];
				finalLength++;
				z++;
			}
		}
		String finalList [] = new String [finalLength];
		for( int x = 0; x < finalLength ; x++)
		{
			finalList [x] = newList [x];
		}
		
		return finalList;
	}

	public static void quickSort(String [] arr)
	{
		String [] left, right;
		int nleft, nright; // Length of left[] and right[
		String pivot;
		int i, j, k;
		if ( arr.length <= 1 )
		{
		// Array of 1 element is sorted....
		return;
		}
		
		//Select the "pivot"
		pivot = arr[arr.length-1]; // Use last element as pivot
		
		//Find out how many elements are <= and > than pivot
		nleft = nright = 0;
		for ( i = 0; i < arr.length-1; i++ )
		{
			if ( arr[i].compareToIgnoreCase(pivot) <= 0 )
			{
				nleft++;
			}
			else
			{
				nright++;
			}
		}
		//Make the left and right array of the proper size
		left = new String[nleft];
		right = new String[nright];
		
		//Partition array into 2 halves:
		//all values <= pivot to left[ ] array
		//all values > pivot to right[ ] array
		i = 0;
		j = 0;
		for ( k = 0; k < arr.length-1; k++ )
		if ( arr[k].compareToIgnoreCase(pivot) <= 0 )
		{
			left[i++] = arr[k];
		}
		else
		{
			right[j++] = arr[k];
		}
		//Sort each half
		quickSort(left); // Use Quick Sort
		quickSort(right); // Use Quick Sort
		
		//Concatenate the pieces back
		k = 0;
		for ( i = 0; i < left.length; i++ )
		{
			arr[k++] = left[i];
		}
		arr[k++] = pivot;
		for ( j = 0; j < right.length; j++ )
		{
			arr[k++] = right[j];
		}
	}

	public static void printArray(String [] array)
	{
		for(String	x : array)
		{
			System.out.print(x+" ");
		}
		System.out.println();
	}


}