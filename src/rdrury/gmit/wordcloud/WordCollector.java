package rdrury.gmit.wordcloud;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public abstract class WordCollector {
	
	List<Word> lStopWords;
	List<Word> lFoundWords;
	
	public WordCollector()
	{
		System.out.println("WordCollector default constructor");
		instantiateWordLists();
		loadStopWords("stopwords.txt");
	}

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	List<Word> getFoundWords() {
		System.out.println("WordCollector getFoundWords");
		return lFoundWords;
	}
	
	List<Word> getStopWords()
	{
		System.out.println("WordCollector getStopWords");
		return lStopWords;
	}
	
	void addFoundWord(String foundWord)
	{
		System.out.println("WordCollector addFoundWord");
		
		//Remove all non-punctuation characters
		//foundWord = foundWord.replaceAll("\\W", "");
		//foundWord = foundWord.replaceAll("\\d", "");
		
		// Remove all non-punctuation characters, except apostrophes
		//foundWord = foundWord.replaceAll("^'&&\\W", "");
		//foundWord = foundWord.replaceAll("\\W&&^'", "");
		
		// Remove all punctuation marks from the BEGINNING of the string
		//foundWord = foundWord.replaceAll("^\\p{Punct}", "");
		
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
		
		//else if (foundWord.equals(" "))
			//System.out.println("OMGOMGOMG");
		
		//else if (foundWord.equals(""))
			//System.out.println("OMG: [" + foundWord + "]");
		
		else if ((!foundWord.equals(" ")) && (!foundWord.equals("")))
		{
			System.out.println("word added: " + foundWord);
			lFoundWords.add(new Word(foundWord));
		}
	}
	
	void incrementWordCount(Word w)
	{
		System.out.println("WordCollector incrementWordCount");
		
		if (lFoundWords.contains(w))
		{
			lFoundWords.get(lFoundWords.indexOf(w)).incrementWordCount();
		}
	}
}
