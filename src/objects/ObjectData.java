package objects;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class ObjectData {
	public BufferedImage image;
	public int width;
	public int height;
	public Rectangle solidArea;
	public boolean collision;
	public String name;
	
	public ObjectData(BufferedImage image, String name, int width, int height, boolean collision, Rectangle solidArea) {
		this.image = image;
		this.width = width;
		this.height = height;
		this.name = name;
		this.collision = collision;
		this.solidArea = solidArea;
	}
	
	public BufferedImage getImage() {
		
		return image;
	}
}
