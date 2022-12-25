package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import tile.TileManager;

public class Utility {
	
	
	public BufferedImage scaleimage(BufferedImage og, int width, int height) {
		BufferedImage scaledimage = new BufferedImage(width, height, og.getType());
		Graphics2D g2 = scaledimage.createGraphics();
		g2.drawImage(og, 0, 0, width, height, null);
		g2.dispose();
		
		return scaledimage;
	}
}
