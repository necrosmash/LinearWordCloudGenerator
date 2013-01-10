package rdrury.gmit.wordcloud;

import java.net.UnknownHostException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class TestRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Make a WordCollectorFromFile
		WordCollectorFromFile wcff = new WordCollectorFromFile();
		wcff.getWordsFromFile("processMe.txt");
		
		//WordCollectorFromURL wcfu = new WordCollectorFromURL();
		/*
		try {
			wcfu.getWordsFromURL("http://news.bbc.co.uk");
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		
		//ImageGenerator ig = new ImageGenerator(wcfu);
		ImageGenerator ig = new ImageGenerator(wcff);
		ig.generateImage(5, 100);
		
		
		/*
		// Print the words and their frequency
		List<Word> l1 = new LinkedList<Word>();
		l1 = wcff.getFoundWords();
		
		
		for (Word w : l1)
		{
			System.out.println("** NEW WORD **");
			System.out.println("Word: " + w.getWord());
			System.out.println("Frequency: " + w.getFrequency());
		}
		*/
		
		// Make a WordCollectorFromURL
		
		/*
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
		*/
		
		/*
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 62);
		BufferedImage image = new BufferedImage(669, 78, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics graphics = image.getGraphics();
		
		FontMetrics fm = graphics.getFontMetrics(font);
		
		Rectangle2D r = fm.getStringBounds("Object oriented design", graphics);
		System.out.println("Height: " + r.getHeight() + "\nWidth: " + r.getWidth());
		
		graphics.setColor(Color.red);
		graphics.setFont(font);
		graphics.drawString("Object oriented design", 0, 68);
		
		graphics.dispose();
		try {
			ImageIO.write(image, "png", new File("image.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		/*
		graphics.setColor(Color.red);
		graphics.setFont(font);
		graphics.drawString("Object oriented design", 0, 100);

		font = new Font(Font.SANS_SERIF, Font.ITALIC, 42);
		graphics.setFont(font);
		graphics.setColor(Color.yellow);
		graphics.drawString("Software Development", 10, 150);

		font = new Font(Font.MONOSPACED, Font.PLAIN, 22);
		graphics.setFont(font);
		graphics.setColor(Color.blue);
		graphics.drawString("Software Development 2012 Assignment", 40, 180);

		graphics.dispose();
		try {
			ImageIO.write(image, "png", new File("image.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/	
		}
}
