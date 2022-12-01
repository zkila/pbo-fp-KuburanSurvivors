package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	
	public Player (GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		
		screenX = gp.screenWidth / 2 - (gp.tileSize/2);
		screenY = gp.screenHeight / 2 - (gp.tileSize/2);
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues () {
		
		worldX = gp.tileSize * 24;
		worldY = gp.tileSize * 25;
		speed = 4;
		direction = "right";
	}
	
	public void getPlayerImage(){
		
		try {
			
			left = ImageIO.read(getClass().getResourceAsStream("/player/Tukanggali_left.png"));
			right = ImageIO.read(getClass().getResourceAsStream("/player/Tukanggali_right.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void update() {
		if(keyH.upPressed == true && keyH.rightPressed == true) {
			direction = "right";
			worldY -= speed;
			worldX += speed;
		}
		else if(keyH.upPressed == true && keyH.leftPressed == true) {
			direction = "left";
			worldY -= speed;
			worldX -= speed;
		}
		else if(keyH.downPressed == true && keyH.rightPressed == true) {
			direction = "right";
			worldY += speed;
			worldX += speed;
		}
		else if(keyH.downPressed == true && keyH.leftPressed == true) {
			direction = "left";
			worldY += speed;
			worldX -= speed;
		}
		else if(keyH.upPressed == true) {
			worldY -= speed;
		}
		else if(keyH.downPressed == true) {
			worldY += speed;
		}
		else if(keyH.leftPressed == true) {
			direction = "left";
			worldX -= speed;
		}
		else if(keyH.rightPressed == true) {
			direction = "right";
			worldX += speed;
		}
	}
	
	public void draw (Graphics2D g2) {
//		g2.setColor(Color.white);
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		BufferedImage image = null;
		
		if(direction == "left") {
			image = left;
		}
		else if(direction == "right") {
			image = right;
		}
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
	
	}
}
