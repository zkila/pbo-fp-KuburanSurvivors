package entity;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import resource.Resource;

public class Player extends Entity{
	
	KeyHandler keyH;
	int imageID;
	public int imageNum;
	
	public final int screenX;
	public final int screenY;
	//int hasChest = 0;
	
	public ArrayList<Object[][]> objects;
	
	public Player (GamePanel gp, KeyHandler keyH) {
		super(gp);
		
		this.keyH = keyH;
		
		screenX = gp.screenWidth / 2 - (gp.tileSize);
		screenY = gp.screenHeight / 2 - (gp.tileSize);
		
		solidArea = new Rectangle();
		solidArea.x = gp.tileSize - 16;
		solidArea.y = gp.tileSize*3/2;
		
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		solidArea.width = gp.tileSize*8/5;
		solidArea.height = gp.tileSize*3/2;
		
		setDefaultValues();
	}
	
	public void setDefaultValues () {
		worldX = gp.tileSize * 24;
		worldY = gp.tileSize * 24;
		speed = 4;
		direction = "right";
		
		//player status
		maxLife = 86;
		life = maxLife;
	}
	

	public void update() {
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
		gp.objectM.checkObject(this, true);
		//collisionOn = false;
		//gp.colCheck.checkObject(this);	
		//check object collisiion
		//int objIndex = 
				//gp.colCheck.checkObject(this, true);
		//pickUpObject(objIndex);
		
		if(spriteCounter > 10) {
			if(spriteNum == 1) {
				spriteNum = 2;
			}
			else if(spriteNum == 2) {
				spriteNum = 3;
			}
			else if(spriteNum == 3) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
		
		
	}
	
//	public void pickUpObject(int i) {
//		if(i != 999) {
//			String objectName =  gp.obj[i].name;
//			
//			switch(objectName) {
//			case "Chest":
//			 	//do something
//				gp.playSE(2);
//				gp.obj[i] = null;
//				break;
//			case "Sate":
//				//increasing health bar
//				gp.playSE(1);
//				gp.obj[i] = null;
//				break;
//			}
//		}
//	}
	
	
	public void draw (Graphics2D g2) {
//		g2.setColor(Color.white);
//		g2.fillRect(screenX, screenY, gp.tileSize*2, gp.tileSize*2);
		//g2.setColor(Color.red);
		//g2.fillRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);
		
		//BufferedImage image = null;
		
		
		if(direction == "left") {
			imageID = 0 + imageNum;
		}
		else if(direction == "right") {
			imageID = 3 + imageNum;
		}
		
		//image =  sprite.get(imageID + spriteNum - 1);
		
		g2.drawImage(Resource.SPRITE.get(imageID + spriteNum - 1), screenX, screenY, gp.tileSize*3, gp.tileSize*3, null);
		
		g2.setColor(Color.RED);
		g2.fillRect(screenX + gp.tileSize*3/4, screenY + 8, life, 8);
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(3));
		g2.drawRect(screenX + gp.tileSize*3/4 -1, screenY + 7, 102, 10);
	}
	
//	public void objectCollision () {
//		for(int i = 0; i < objects.get(currentReg).length; i++) {
//			for(int j = 0; j < region.getCurrentRegionObject()[0].length; j++) {
//				if(region.getCurrentRegionObject()[i][j].getID() != 0)
//					player.handleCollisionWithObject(region.getCurrentRegionObject()[i][j], region);
//			}
//	}
}
