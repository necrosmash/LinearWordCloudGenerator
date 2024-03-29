package rdrury.gmit.wordcloud;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//import java.util.regex.Pattern;
//import java.util.regex.PatternSyntaxException;

/**
 * Abstract superclass used for classes that read
 * words from different sources 
 * 
 * @author Rob Drury
 */
public abstract class WordCollector {
	
	private List<Word> lStopWords;
	private List<Word> lFoundWords;
	
	/**
	 * Default constructor uses "stopwords.txt" as the
	 * location of the words to ignore when reading lists of words.
	 */
	public WordCollector()
	{
		System.out.println("WordCollector default constructor");
		instantiateWordLists();
		loadStopWords("stopwords.txt");
	}
	
	/**
	 * Constructor that is passed the filename containing a list
	 * of words that should be ignored when analysing lists of words.
	 * 
	 * @param stopwordsFileName
	 */
	public WordCollector(String stopwordsFileName)
	{
		System.out.println("WordCollector String constructor");
		instantiateWordLists();
		loadStopWords(stopwordsFileName);
	}
	
	private void instantiateWordLists()
	{
		System.out.println("WordCollector instantiateWordLists");
		lStopWords = new LinkedList<Word>();
		lFoundWords = new LinkedList<Word>();
	}
	
	private void loadStopWords(String filename)
	{
		System.out.println("WordCollector loadStopWords");
		String currentLine;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			
			while ((currentLine = br.readLine()) != null)
			{
				lStopWords.add(new Word(currentLine.toUpperCase()));
			}
			
			if (br != null)
				br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns a (sorted) list of the words
	 * that have currently been found.
	 * 
	 * @return List<Word>
	 */
	List<Word> getFoundWords() {
		System.out.println("WordCollector getFoundWords");
		
		// Sort words by their frequency
		Collections.sort(lFoundWords);
		return lFoundWords;
	}
	
	/**
	 * Returns a list of the words that
	 * are ignored when analysing lists of words.
	 * 
	 * @return List<Word>
	 */
	List<Word> getStopWords()
	{
		System.out.println("WordCollector getStopWords");
		return lStopWords;
	}
	
	/**
	 * Adds a found word to the list of found words if
	 * it is not a common word, null, or a single space.
	 * 
	 * It also increments the count of the word if the
	 * word passed in already exists in the list.
	 * 
	 * @param foundWord
	 */
	void addFoundWord(String foundWord)
	{
		System.out.println("WordCollector addFoundWord");
		
		//Remove all non-punctuation characters
		//foundWord = foundWord.replaceAll("\\W", "");
		
		// Remove all digits
		//foundWord = foundWord.replaceAll("\\d", "");
		
		foundWord = foundWord.toUpperCase();
		
		if (getStopWords().contains(new Word(foundWord)))
		{
			System.out.println("not including common word: " + foundWord);
		}
		
		else if (getFoundWords().contains(new Word(foundWord)))
		{
			System.out.println("found duplicate word: " + foundWord);
			incrementWordCount(new Word(foundWord));
		}
		
		else if ((!foundWord.equals(" ")) && (!foundWord.equals("")))
		{
			System.out.println("word added: " + foundWord);
			lFoundWords.add(new Word(foundWord));
		}
	}
	
	/**
	 * Increments the count of the
	 * passed word.
	 * 
	 * @param w
	 */
	void incrementWordCount(Word w)
	{
		System.out.println("WordCollector incrementWordCount");
		
		if (lFoundWords.contains(w))
		{
			lFoundWords.get(lFoundWords.indexOf(w)).incrementWordCount();
		}
	}
}
