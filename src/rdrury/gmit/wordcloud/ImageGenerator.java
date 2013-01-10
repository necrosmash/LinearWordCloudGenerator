package rdrury.gmit.wordcloud;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageGenerator {
	
	WordCollector wordCollector;
	
	public ImageGenerator(WordCollector wordCollector)
	{
		this.wordCollector = wordCollector;
	}
	
	public void generateImage(int numberOfWords)
	{
		//int longestString = 0;
		//int 
		
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 62);
		BufferedImage image = new BufferedImage(2000, 2000, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics graphics = image.getGraphics();
		
		FontMetrics fm = graphics.getFontMetrics(font);
		
		Rectangle2D r = fm.getStringBounds("Object oriented design", graphics);
		System.out.println("Height: " + r.getHeight() + "\nWidth: " + r.getWidth());
		
		graphics.setColor(Color.red);
		graphics.setFont(font);
		
		int y = 500;
		
		graphics.drawString("Object oriented design", 0, y);
		graphics.drawString("Height: " + r.getHeight(), 0, y+100);
		graphics.drawString("Width: " + r.getWidth(), 0, y+200);
		
		/*
		for (Word w : wordCollector.getFoundWords())
		{
			graphics.drawString(w.getWord(), 0, y);
			y+=100;
		}
		*/
		graphics.dispose();
		try {
			ImageIO.write(image, "png", new File("image.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
