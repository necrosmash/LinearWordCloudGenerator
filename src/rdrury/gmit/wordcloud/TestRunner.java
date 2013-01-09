package rdrury.gmit.wordcloud;

import java.net.UnknownHostException;
import java.util.Collections;
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
		
		
		// Print the words and their frequency
		//List<Word> l1 = new LinkedList<Word>();
		//l1 = wcff.getFoundWords();
		
		/*
		for (Word w : l1)
		{
			System.out.println("** NEW WORD **");
			System.out.println("Word: " + w.getWord());
			System.out.println("Frequency: " + w.getFrequency());
		}
		*/
		
		// Make a WordCollectorFromURL
		WordCollectorFromURL wcfu = new WordCollectorFromURL();
		
		try {
			wcfu.getWordsFromURL("http://news.bbc.co.uk");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Print the words and their frequency
		List<Word> l2 = new LinkedList<Word>();
		l2 = wcfu.getFoundWords();
		Collections.sort(l2);
		
		for (Word w : l2)
		{
			System.out.println("** NEW WORD **");
			System.out.println("Word: " + w.getWord());
			System.out.println("Frequency: " + w.getFrequency());
		}
	}
}
