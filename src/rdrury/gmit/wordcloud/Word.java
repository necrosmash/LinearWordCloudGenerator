package rdrury.gmit.wordcloud;

/**
 * Contains a String representing a word, as well as
 * how often it appears.
 * 
 * @author Rob Drury
 */
public class Word implements Comparable<Object>{
	
	private String word;
	private int frequency;
	
	/**
	 * Default constructor sets the String to nothing,
	 * and the frequency to -1.
	 */
	public Word()
	{
		word = "";
		frequency = -1;
	}
	
	/**
	 * Constructor with a String passed in. This String
	 * is used to form a new Word. The frequency is set
	 * to 1 by default here.
	 * 
	 * @param word
	 */
	public Word(String word)
	{
		this.word = word;
		frequency = 1;
	}
	
	/**
	 * Constructor with a String and an integer for
	 * specifying a word and how often it appears.
	 * 
	 * @param word
	 * @param frequency
	 */
	public Word(String word, int frequency)
	{
		this.word = word;
		this.frequency = frequency;
	}
	
	/**
	 * Returns a string that represents a Word (its actual word).
	 * 
	 * @return String
	 */
	public String getWord()
	{
		return this.word;
	}
	
	/**
	 * Returns the frequency that a word appears.
	 * 
	 * @return int
	 */
	public int getFrequency()
	{
		return this.frequency;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Word other = (Word) obj;
		if (word == null) {
			if (other.word != null) {
				return false;
			}
		} else if (!word.equals(other.word)) {
			return false;
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public int compareTo(Object arg0) {
		
		Word w = (Word) arg0;
		
		return w.getFrequency() - this.frequency;
	}
	
	/**
	 * Increments the frequency of a Word.
	 */
	void incrementWordCount()
	{
		frequency++;
	}
}
