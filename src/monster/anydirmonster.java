package monster;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import entity.Entity;
import main.GamePanel;

public class anydirmonster extends Entity{
	
	BufferedImage up3,up4,down3,down4,left3,left4,right3,right4;
	
	public anydirmonster(GamePanel gp) {
		super(gp);
	}
	
	public void update() {
		setAction();
		collisionOn = false;
		gp.cChecker.checkTile(this);
		gp.cChecker.checkObject(this, false);
		gp.cChecker.checkEntity(this, gp.npc);
		gp.cChecker.checkEntity(this, gp.mons);
		boolean contactplayer = gp.cChecker.checkPlayer(this);
		
		//if monster attack player
		
		if(this.type == 2 && contactplayer) {
			if(!gp.player.iframe) {
				gp.player.life--;
				gp.player.iframe = true;
				gp.playsfx(5);
			}
		}
		
		if (collisionOn == false) {
			switch (direction) {
			case "up":
				worldY -= speed;
				break;
			case "down":
				worldY += speed;		
				break;
			case "right":
				worldX += speed;
				break;
			case "left":
				worldX -= speed;
				break;
			}
		}
		
		spriteCounter++;
		if(spriteCounter>18) {
			if(spriteNum==1) {
				spriteNum = 2;
			}
			else if (spriteNum == 2) {
				spriteNum = 3;
			}
			else if (spriteNum == 3) {
				spriteNum = 4;
			}
			else if (spriteNum == 4) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
		
		if(iframe) {
			iframecounter++;
			if(iframecounter>30) {
				iframe = false;
				iframecounter = 0;
			}
		}
	}
	
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		if(worldX + gp.tileSize*2 > gp.player.worldX - gp.player.screenX &&
		   worldX - gp.tileSize*3 < gp.player.worldX + gp.player.screenX &&
		   worldY + gp.tileSize*2 > gp.player.worldY - gp.player.screenY &&
		   worldY - gp.tileSize*3 < gp.player.worldY + gp.player.screenY) {
			
				if(spriteNum == 1) {image = up1;}
				if(spriteNum == 2) {image = up2;}
				if(spriteNum == 3) {image = up3;}
				if(spriteNum == 4) {image = up4;}
		}
			
			
			
			
//			if(type == 2 && hpbaron) {
			int x = screenX + gp.tileSize;
			int y = screenY;
			int length = gp.tileSize;
			int width = 10;
			double oneScale = (double)length/maxlife;
			double hpbarvalue = oneScale*life;
			
			gp.player.changealpha(g2, 0.5f);
			g2.setColor(Color.BLACK);
			g2.fillRect(x-2, y-2, length+4, width+4);
			//g2.fillRoundRect(gp.player.screenX-2, gp.player.screenY - 17, gp.tileSize+4, 10+4,4,4);
			
			gp.player.changealpha(g2, 1f);
			g2.setColor(gp.player.healthbar);
			g2.fillRect(x, y, (int)hpbarvalue, width);
					
//				hpbarcounter++;
//				if(hpbarcounter>600) {
//					hpbarcounter = 0;
//					hpbaron = false;
//				}
//			}
					
			if(iframe) { changealpha(g2, 0.5f); hpbaron = true; hpbarcounter = 0; }
			if(dying) dyinganim(g2);
			g2.drawImage(image, screenX, screenY, null);
			changealpha(g2, 1f);	
	}
	
	
	public void setAction() {
	actionlockcounter++;
		
		if(actionlockcounter == 120) {
			Random random = new Random();
			int i = random.nextInt(100)+1; //pick a random number from 1 - 100
			if(i <= 25) {
				direction = "up";
			}
			else if (i>25 && i<=50) {
				direction ="down";
			}
			else if (i>50 && i<=75) {
				direction ="left";
			}
			else if (i>75 && i<=100) {
				direction ="right";
			}
			
			actionlockcounter = 0;
		}
	}
	
	
}
