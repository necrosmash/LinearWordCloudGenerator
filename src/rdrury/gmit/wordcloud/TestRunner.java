package rdrury.gmit.wordcloud;

public class TestRunner {
	
	String URL = "http://news.bbc.co.uk";
	String textFile = "processMe.txt";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		makeImageFromURL();
		//makeImageFromFile();
		}

	private static void makeImageFromFile() {
		WordCollectorFromFile wcff = new WordCollectorFromFile();
		wcff.getWordsFromFile("processMe.txt");
		
		generateImage(wcff);
	}

	private static void makeImageFromURL() {
		WordCollectorFromURL wcfu = new WordCollectorFromURL();
		
		try {
			wcfu.getWordsFromURL("http://news.bbc.co.uk");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		generateImage(wcfu);
	}
	
	private static void generateImage(WordCollector wc)
	{
		ImageGenerator ig = new ImageGenerator(wc);
		ig.generateImage(30, 150, 15);
	}
}
