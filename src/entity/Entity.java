package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.Utility;

public class Entity {
	
	public BufferedImage image1, image2, image3;
	public BufferedImage up1, up2, down1, down2, left1, left2, left3, right1, right2, right3;
	public BufferedImage attackup1, attackup2, attackdown1, attackdown2, attackleft1, attackleft2, attackright1, attackright2;
	
	public Rectangle solidArea = new Rectangle(0,0,48,48);
	public int solidareadefaultx, solidareadefaulty;
	public Rectangle hurtbox = new Rectangle(0,0,0,0);
	
	public Color healthbar = new Color(255,0,0);
	
	//state
	public boolean collision;
	public int worldX, worldY;
	public String direction = "down";
	public String rightleftdir = "left";
	public boolean iframe = false;
	public boolean collisionOn;
	public int dialogueindex = 0;
	public int spriteNum = 1;
	public boolean attacking = false;
	public boolean alive = true;
	public boolean dying = false;
	public boolean hpbaron = false;
	
	//counter
	public int iframecounter = 0;
	public int actionlockcounter = 0;
	public int spriteCounter = 0;
	public int dyingcounter = 0;
	public int hpbarcounter = 0;
	
	//attributes
	public int speed;
	public String name;
	public int maxlife, life;
	public int type; //0:player 1:npc 2:monster
	
	ArrayList<String> dialogues = new ArrayList<String>();
	
	public GamePanel gp;
	
	public Entity(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setAction() {
		
	}
	
	public void damageReaction() {
		
	}
	
	public void speak() {
		if(dialogueindex+1 > dialogues.size()) { dialogueindex = 0; }
		else {
			gp.ui.currentdialogue = dialogues.get(dialogueindex);
			dialogueindex++;
		}	
		
		switch(gp.player.direction) {
		case "up": direction = "down"; break;
		case "down": direction = "up"; break;
		case "right": direction = "left"; break;
		case "left": direction = "right"; break;
		}
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
		if(spriteCounter>12) {
			if(spriteNum==1) {
				spriteNum = 2;
			}
			else if (spriteNum == 2) {
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
			
			switch(direction) {
			case "up":
				if(spriteNum == 1) {image = up1;}
				if(spriteNum == 2) {image = up2;}
				break;
			case "down":
				if(spriteNum == 1) {image = down1;}
				if(spriteNum == 2) {image = down2;}
				break;
			case "right":
				if(spriteNum == 1) {image = right1;}
				if(spriteNum == 2) {image = right2;}
				break;
			case "left":
				if(spriteNum == 1) {image = left1;}
				if(spriteNum == 2) {image = left2;}
				break;
			}
			
			
			
			
			if(type == 2 && hpbaron) {
				double oneScale = (double)gp.tileSize/maxlife;
				double hpbarvalue = oneScale*life;
				
				changealpha(g2, 0.5f);
				g2.setColor(Color.BLACK);
				g2.fillRoundRect(screenX-2, screenY - 17, gp.tileSize+4, 10+4,4,4);
				
				changealpha(g2, 1f);
				g2.setColor(healthbar);
				g2.fillRect(screenX+1, screenY - 15+1, (int)hpbarvalue-2, 10-2);
				
				hpbarcounter++;
				if(hpbarcounter>600) {
					hpbarcounter = 0;
					hpbaron = false;
				}
			}
					
			if(iframe) { changealpha(g2, 0.5f); hpbaron = true; hpbarcounter = 0; }
			if(dying) dyinganim(g2);
			g2.drawImage(image, screenX, screenY, null);
			changealpha(g2, 1f);	
		}
	}
	
	public void dyinganim(Graphics2D g2) {
		dyingcounter++;
		int interval = 5;
		
		if(dyingcounter<interval) changealpha(g2, 0f);
		else if(dyingcounter<interval*2 && dyingcounter>=interval) changealpha(g2, 1f);		
		else if(dyingcounter<interval*3 && dyingcounter>=interval*2) changealpha(g2, 0f);		
		else if(dyingcounter<interval*4 && dyingcounter>=interval*3) changealpha(g2, 0.75f);		
		else if(dyingcounter<interval*5 && dyingcounter>=interval*4) changealpha(g2, 0f);		
		else if(dyingcounter<interval*6 && dyingcounter>=interval*5) changealpha(g2, 0.5f);		
		else if(dyingcounter<interval*7 && dyingcounter>=interval*6) changealpha(g2, 0f);
		else if(dyingcounter>=interval*8) {
			dying = false;
			alive = false;
		}
	}
	
	public void changealpha(Graphics2D g2, float f) {
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,f));
	}
	
	public BufferedImage setup(String imagepath, int width, int height) {
		Utility tool = new Utility();
		BufferedImage scaledimage = null;
		
		try {
			scaledimage = ImageIO.read(getClass().getResource(imagepath+".png"));
			scaledimage = tool.scaleimage(scaledimage, width, height);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return scaledimage;
	}
	
	public BufferedImage secondsetup(BufferedImage image, int width, int height) {
		Utility tool = new Utility();
		BufferedImage scaledimage = tool.scaleimage(image, width, height);
		return scaledimage;
	}
	
}
