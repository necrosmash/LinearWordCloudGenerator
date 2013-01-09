package rdrury.gmit.wordcloud;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public abstract class WordCollector {
	
	//File fStopWords;
	List<Word> lStopWords;
	List<Word> lFoundWords;
	
	public WordCollector()
	{
		System.out.println("WordCollector default constructor");
		instantiateWordLists();
		loadStopWords("stopwords.txt");
	}

	public WordCollector(String filename)
	{
		System.out.println("WordCollector String constructor");
		instantiateWordLists();
		loadStopWords(filename);
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
				lStopWords.add(new Word(currentLine));
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
		lFoundWords.add(new Word(foundWord, 1));
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
