package rdrury.gmit.wordcloud;

import java.util.Comparator;

public class WordCountComparator implements Comparator<Word> {
	
	@Override
	public int compare(Word word0, Word word1) {
		return word0.getFrequency() - word1.getFrequency();
	}
}
