package rdrury.gmit.wordcloud;

public class ImageGenerator {
	
	WordCollector wordCollector;
	
	public ImageGenerator(WordCollector wordCollector)
	{
		this.wordCollector = wordCollector;
	}
	
	public void setWordCollector(WordCollector wordCollector)
	{
		this.wordCollector = wordCollector;
	}
}
