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
	
	public void generateImage()
	{
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
	}
}
