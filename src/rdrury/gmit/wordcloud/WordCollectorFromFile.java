package rdrury.gmit.wordcloud;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Used to collector words from a file.
 * 
 * @author Rob Drury
 * @see WordCollector
 */
public class WordCollectorFromFile extends WordCollector {
	
	/**
	 * Default constructor calls superclass default constructor. 
	 */
	public WordCollectorFromFile()
	{
		super();
		System.out.println("WordCollectorFromFile default constructor");
	}
	
	/**
	 * Used to pass in a specific file containing words
	 * that should be ignored when processing lists of words.
	 * 
	 * @param stopwordsFileName
	 */
	public WordCollectorFromFile(String stopwordsFileName)
	{
		super(stopwordsFileName);
		System.out.println("WordCollectorFromFile String constructor");
	}
	
	/**
	 *  Returns a list of the words that have been found 
	 */
	public List<Word> getFoundWords()
	{
		System.out.println("WordCollectorFromFile getFoundWords");
		return super.getFoundWords();
	}
	
	/**
	 * Obtains a list of words from the specified file
	 * 
	 * @param filename
	 */
	public void getWordsFromFile(String filename)
	{
		System.out.println("WordCollectorFromFile getWordsFromFile");
		
		String currentWord;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			
			while ((currentWord = br.readLine()) != null)
				super.addFoundWord(currentWord);
			
			if (br != null)
				br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
