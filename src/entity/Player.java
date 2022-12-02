package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	int imageID;
	
	public final int screenX;
	public final int screenY;
	
	public Player (GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		
		screenX = gp.screenWidth / 2 - (gp.tileSize);
		screenY = gp.screenHeight / 2 - (gp.tileSize);
		
		solidArea = new Rectangle();
		solidArea.x = gp.tileSize/2;
		solidArea.y = gp.tileSize;
		solidArea.width = gp.tileSize;
		solidArea.height = gp.tileSize;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues () {
		
		worldX = gp.tileSize * 24;
		worldY = gp.tileSize * 24;
		speed = 4;
		direction = "right";
	}
	
	public void getPlayerImage(){
		
		try {
			sprite = new ArrayList<>();
			sprite.add(ImageIO.read(getClass().getResourceAsStream("/player/Tukanggali_left.png")));
			sprite.add(ImageIO.read(getClass().getResourceAsStream("/player/Tukanggali_left_1.png")));
			sprite.add(ImageIO.read(getClass().getResourceAsStream("/player/Tukanggali_right.png")));
			sprite.add(ImageIO.read(getClass().getResourceAsStream("/player/Tukanggali_right_1.png")));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void update() {
		
		collisionOn = false;
		gp.colCheck.checkTile(this);
		
		if(keyH.upPressed == true && keyH.rightPressed == true) {
			direction = "right";
			if (collisionOn == false) {
				worldY -= speed;
				worldX += speed;
			}
			spriteCounter++;
		}
		else if(keyH.upPressed == true && keyH.leftPressed == true) {
			direction = "left";
			if (collisionOn == false) {
				worldY -= speed;
				worldX -= speed;
			}
			spriteCounter++;
			
		}
		else if(keyH.downPressed == true && keyH.rightPressed == true) {
			direction = "right";
			if (collisionOn == false) {
				worldY += speed;
				worldX += speed;
			}
			spriteCounter++;
		}
		else if(keyH.downPressed == true && keyH.leftPressed == true) {
			direction = "left";
			if (collisionOn == false) {
				worldY += speed;
				worldX -= speed;
			}
			spriteCounter++;
		}
		else if(keyH.upPressed == true) {
			direction = "up";
			if (collisionOn == false) {
				worldY -= speed;
			}
			spriteCounter++;
		}
		else if(keyH.downPressed == true) {
			direction = "down";
			if (collisionOn == false) {
				worldY += speed;
			}
			spriteCounter++;
		}
		else if(keyH.leftPressed == true) {
			direction = "left";
			if (collisionOn == false) {
				worldX -= speed;
			}
			spriteCounter++;
		}
		else if(keyH.rightPressed == true) {
			direction = "right";
			if (collisionOn == false) {
				worldX += speed;
			}
			spriteCounter++;
		}
		
		if(spriteCounter > 10) {
			if(spriteNum == 1) {
				spriteNum = 2;
			}
			else if(spriteNum == 2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
	}
	
	public void draw (Graphics2D g2) {
//		g2.setColor(Color.white);
//		g2.fillRect(screenX, screenY, gp.tileSize*2, gp.tileSize*2);
//		g2.setColor(Color.red);
//		g2.fillRect(screenX + solidArea.x, screenY + solidArea.y, gp.tileSize, gp.tileSize);
		
		BufferedImage image = null;
		
		
		if(direction == "left") {
			imageID = 0;
		}
		else if(direction == "right") {
			imageID = 2;
		}
		
		image =  sprite.get(imageID + spriteNum - 1);
		
		g2.drawImage(image, screenX, screenY, gp.tileSize*2, gp.tileSize*2, null);
	
	}
}
