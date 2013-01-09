package rdrury.gmit.wordcloud;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WordCollectorFromURL extends WordCollector {
	
	public WordCollectorFromURL()
	{
		super();
		System.out.println("WordCollectorFromURL default constructor");
	}
	
	public WordCollectorFromURL(String stopwordsFileName)
	{
		super(stopwordsFileName);
		System.out.println("WordCollectorFromURL String constructor");
	}
	
	public List<Word> getFoundWords()
	{
		System.out.println("WordCollectorFromURL getFoundWords");
		return super.getFoundWords();
	}
	
	public void getWordsFromURL(String URL)
	{
		System.out.println("WordCollectorFromURL getWordsFromURL");
		
		Document doc = null;
		
		try {
			doc = Jsoup.connect(URL).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String text = doc.body().text();
		String[] words = text.split(" ");
		
		for (String s : words)
			super.addFoundWord(s);
	}
}
