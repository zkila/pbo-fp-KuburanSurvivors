package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import main.GamePanel;

public class Entity {
	
	GamePanel gp;
	public int worldX, worldY;
	public int speed;
	
	public ArrayList<BufferedImage> sprite;
	public String direction;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
	public Rectangle solidArea;
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collisionOn = false;
	
	//character status
	public int maxLife;
	public int life;
	
	public Entity (GamePanel gp) {
		this.gp = gp;
	}
}
