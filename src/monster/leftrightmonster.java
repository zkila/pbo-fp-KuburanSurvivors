package monster;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import entity.Entity;
import main.GamePanel;

public class leftrightmonster extends Entity{

	public leftrightmonster(GamePanel gp) {
		super(gp);
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
					rightleftdir = direction;
				}
				else if (i>75 && i<=100) {
					direction ="right";
					rightleftdir = direction;
				}
				
				actionlockcounter = 0;
			}
		}
	
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		if(worldX + gp.tileSize*2 > gp.player.worldX - gp.player.screenX &&
		   worldX - gp.tileSize*3 < gp.player.worldX + gp.player.screenX &&
		   worldY + gp.tileSize*3 > gp.player.worldY - gp.player.screenY &&
		   worldY - gp.tileSize*3 < gp.player.worldY + gp.player.screenY) {
			
			switch(rightleftdir) {
//			case "up":
//				if(spriteNum == 1) {image = up1;}
//				if(spriteNum == 2) {image = up2;}
//				break;
//			case "down":
//				if(spriteNum == 1) {image = down1;}
//				if(spriteNum == 2) {image = down2;}
//				break;
			case "left":
				if(spriteNum == 1) {image = left1;}
				if(spriteNum == 2) {image = left2;}
				break;
			case "right":
				if(spriteNum == 1) {image = right1;}
				if(spriteNum == 2) {image = right2;}
				break;
			}
			
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
			
//			if(type == 2 && hpbaron) {
			
				
//				hpbarcounter++;
//				if(hpbarcounter>600) {
//					hpbarcounter = 0;
//					hpbaron = false;
//				}
//			}
				
				g2.setColor(healthbar);
				g2.fillRect( screenX+solidareadefaultx, screenY+solidareadefaulty,solidArea.width,solidArea.height);
					
			if(iframe) { changealpha(g2, 0.5f); hpbaron = true; hpbarcounter = 0; }
			if(dying) dyinganim(g2);
			g2.drawImage(image, screenX, screenY, null);
			changealpha(g2, 1f);	
		}
	}
	
}
