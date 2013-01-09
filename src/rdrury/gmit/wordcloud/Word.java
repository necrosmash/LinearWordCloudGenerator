package rdrury.gmit.wordcloud;

public class Word implements Comparable<Object>{
	
	private String word;
	private int frequency;
	
	public Word()
	{
		word = "";
		frequency = -1;
	}
	
	public Word(String word)
	{
		this.word = word;
		frequency = 1;
	}
	
	public Word(String word, int frequency)
	{
		this.word = word;
		this.frequency = frequency;
	}
	
	public String getWord()
	{
		return this.word;
	}
	
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
	
	void incrementWordCount()
	{
		frequency++;
	}

	@Override
	public int compareTo(Object arg0) {
		
		Word w = (Word) arg0;
		
		//return this.frequency - w.getFrequency();
		return w.getFrequency() - this.frequency;
	}
}
