package rdrury.gmit.wordcloud;

public class TestRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordCollectorFromFile wcff = new WordCollectorFromFile();
		wcff.getWordsFromFile("processMe.txt");
	}

}
