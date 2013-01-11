package rdrury.gmit.wordcloud;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Used to collect words from a text file.
 * 
 * @author Rob Drury
 * @see WordCollector
 */
public class WordCollectorFromURL extends WordCollector {
	
	/**
	 * Default constructor calls default constructor of
	 * the superclass.
	 */
	public WordCollectorFromURL()
	{
		super();
		System.out.println("WordCollectorFromURL default constructor");
	}
	/**
	 * Used to pass in a specific file containing words
	 * that should be ignored when processing lists of words.
	 * 
	 * @param stopwordsFileName
	 */
	public WordCollectorFromURL(String stopwordsFileName)
	{
		super(stopwordsFileName);
		System.out.println("WordCollectorFromURL String constructor");
	}
	/**
	 * Returns a list of the words that have been found 
	 * 
	 * @return List<Word>
	 */
	public List<Word> getFoundWords()
	{
		System.out.println("WordCollectorFromURL getFoundWords");
		return super.getFoundWords();
	}
	
	/**
	 * Obtains a list of words from the specified URL
	 * 
	 * @param URL
	 */
	public void getWordsFromURL(String URL)
	{
		System.out.println("WordCollectorFromURL getWordsFromURL");
		
		Document doc = null;
		
		try {
			doc = Jsoup.connect(URL).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String text = doc.body().text();
		String[] words = text.split(" ");
		
		for (String s : words)
			super.addFoundWord(s);
	}
}
