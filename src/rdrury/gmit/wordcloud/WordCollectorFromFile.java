package rdrury.gmit.wordcloud;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class WordCollectorFromFile extends WordCollector {
	
	public WordCollectorFromFile()
	{
		super();
		System.out.println("WordCollectorFromFile default constructor");
	}
	
	public WordCollectorFromFile(String stopwordsFileName)
	{
		super(stopwordsFileName);
		System.out.println("WordCollectorFromFile String constructor");
	}
	
	public List<Word> getFoundWords()
	{
		System.out.println("WordCollectorFromFile getFoundWords");
		return super.getFoundWords();
	}
	
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
