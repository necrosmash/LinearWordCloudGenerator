package rdrury.gmit.wordcloud;

import java.util.LinkedList;
import java.util.List;

public class TestRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Make a WordCollectorFromFile
		//WordCollectorFromFile wcff = new WordCollectorFromFile();
		//wcff.getWordsFromFile("processMe.txt");
		
		/*
		// Print the words and their frequency
		List<Word> l = new LinkedList<Word>();
		l = wcff.getFoundWords();
		
		for (Word w : l)
		{
			System.out.println("** NEW WORD **");
			System.out.println("Word: " + w.getWord());
			System.out.println("Frequency: " + w.getFrequency());
		}
		*/
		
		// Make a WordCollectorFromURL
		WordCollectorFromURL wcfu = new WordCollectorFromURL();
		wcfu.getWordsFromURL("http://news.bbc.co.uk");
		
		// Print the words and their frequency
		List<Word> l = new LinkedList<Word>();
		l = wcfu.getFoundWords();

		for (Word w : l)
		{
			System.out.println("** NEW WORD **");
			System.out.println("Word: " + w.getWord());
			System.out.println("Frequency: " + w.getFrequency());
		}
	}
}
