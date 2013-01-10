package rdrury.gmit.wordcloud;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;

public class ImageGenerator {
	
	WordCollector wordCollector;
	BufferedImage image;
	
	public ImageGenerator(WordCollector wordCollector)
	{
		this.wordCollector = wordCollector;
	}
	
	public void generateImage(int numberOfWords, int maxFontSize, int sizeMultiplier)
	{
		image = new BufferedImage(1000, 3000, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.BLACK);
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
			
			currentWordFontSize = determineFontSize(currentWord, maxFontSize, sizeMultiplier);
			System.out.println("||| currentWordFontSize: " + currentWordFontSize);
			
			currentFont = new Font(Font.SANS_SERIF, Font.BOLD, currentWordFontSize);
			graphics.setFont(currentFont);
			
			currentFontMetrics = graphics.getFontMetrics(currentFont);
			
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
		
		graphics.dispose();
		
		try {
			ImageIO.write(image, "png", new File("image.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * This was a failed attempt at having the
	 * final image generated be a different size
	 * depending on the words that it consisted of.
	 *
	private BufferedImage resizeImage(BufferedImage img, int newWidth, int newHeight)
	{
		int currentW = img.getWidth();
		int currentH = img.getHeight();
		
		BufferedImage newImage =  new BufferedImage(newWidth, newHeight, img.getType());
		
		Graphics g = newImage.createGraphics();
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		
		g.drawImage(img, 0, 0, newWidth, newHeight, 0, 0, currentW, currentH, null);
		
		g.dispose();
		
		return newImage;
	}
	*/

	private int determineFontSize(Word currentWord, int maxFontSize, int sizeMultiplier)
	{
		if ((currentWord.getFrequency() * sizeMultiplier) > maxFontSize)
		{
			System.out.println("||| RETURNING MAX FONT SIZE: " + maxFontSize);
			return maxFontSize;
		}
		
		else
		{
			System.out.println("||| RETURNING CALCULATED FONT SIZE: " + currentWord.getFrequency() * sizeMultiplier);
			return currentWord.getFrequency() * sizeMultiplier;
		}
	}

	public List<Word> getWords()
	{
		return wordCollector.getFoundWords();
	}
}
