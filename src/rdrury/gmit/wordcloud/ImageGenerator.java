package rdrury.gmit.wordcloud;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

public class ImageGenerator {
	
	WordCollector wordCollector;
	BufferedImage disposableImage;
	
	public ImageGenerator(WordCollector wordCollector)
	{
		this.wordCollector = wordCollector;
	}
	
	public void generateImage(int numberOfWords, int maxFontSize)
	{
		disposableImage = new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics graphics = disposableImage.getGraphics();
		//graphics.
		FontMetrics currentFontMetrics;
		Font currentFont;
		Rectangle2D currentWordRec;
		int wordMapWidth = 0;
		int currentWordFontSize = 0;
		int wordMapHeight = 0;
		int wordCounter = 0;
		Word currentWord;
		
		Iterator<Word> iterator = getWords().iterator();
		
		while (iterator.hasNext() && wordCounter < numberOfWords)
		{
			currentWord = iterator.next();
			
			System.out.println("||| CURRENT WORD: " + currentWord.getWord());
			System.out.println("||| FREQUENCY: " + currentWord.getFrequency());
			
			currentWordFontSize = determineFontSize(currentWord, maxFontSize);
			System.out.println("||| currentWordFontSize: " + currentWordFontSize);
			
			currentFont = new Font(Font.SANS_SERIF, Font.BOLD, currentWordFontSize);
			graphics.setFont(currentFont);
			
			currentFontMetrics = graphics.getFontMetrics(currentFont);
			//graphics = disposableImage.getGraphics();
			
			currentWordRec = currentFontMetrics.getStringBounds(currentWord.getWord(), graphics);
			
			wordMapHeight += currentWordRec.getHeight();
			System.out.println("||| New wordMapHeight: " + wordMapHeight);
			
			if (wordMapWidth < currentWordRec.getWidth())
			{
				wordMapWidth = (int) currentWordRec.getWidth();
				System.out.println("||| New wordMapWidth: " + wordMapWidth);
			}
			
			graphics.drawString(currentWord.getWord(), 0, wordMapHeight);
			wordCounter++;
		}
		
		/*
		//Font font = new Font(Font.SANS_SERIF, Font.BOLD, 62);
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 100);
		BufferedImage image = new BufferedImage(2000, 2000, BufferedImage.TYPE_4BYTE_ABGR);
		//BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR);
		
		Graphics graphics = image.getGraphics();
		
		FontMetrics fm = graphics.getFontMetrics(font);
		
		Rectangle2D r = fm.getStringBounds("Object oriented design", graphics);
		System.out.println("Height: " + r.getHeight() + "\nWidth: " + r.getWidth());
		
		graphics.setColor(Color.red);
		graphics.setFont(font);
		
		
		graphics.drawString("Object oriented design", 0, 100);
		*/
		//int y = 500;
		
		//graphics.drawString("Object oriented design", 0, y);
		//graphics.drawString("Height: " + r.getHeight(), 0, y+100);
		//graphics.drawString("Width: " + r.getWidth(), 0, y+200);
		
		/*
		for (Word w : wordCollector.getFoundWords())
		{
			graphics.drawString(w.getWord(), 0, y);
			y+=100;
		}
		*/
		
		graphics.dispose();
		
		try {
			ImageIO.write(disposableImage, "png", new File("image.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	private int determineFontSize(Word currentWord, int maxFontSize)
	{
		//disposableImage
		if ((currentWord.getFrequency() * 10) > maxFontSize)
		{
			System.out.println("||| RETURNING MAX FONT SIZE: " + maxFontSize);
			return maxFontSize;
		}
		
		else
		{
			System.out.println("||| RETURNING CALCULATED FONT SIZE: " + currentWord.getFrequency() * 10);
			return currentWord.getFrequency() * 10;
		}
	}

	public List<Word> getWords()
	{
		return wordCollector.getFoundWords();
	}
}
