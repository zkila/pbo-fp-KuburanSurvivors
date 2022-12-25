package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import main.Utility;
import resourceloader.resource;

public class Player extends Entity{
	
	KeyHandler keyH;
//	public int hasKey = 0;
	int poweruptimer = 0;
	boolean poweredup = false;
	public int characternum = 0; //0-5 is pendeta, 6-11 is ustadz, 12-17 is tukang kubur, 18-23 is kang sate
	public int attacknum = 0; //0-5 is tukang kubur
	
	public final int screenX, screenY;
	
	public Player(GamePanel gp, KeyHandler KeyH) {
		super(gp);
		this.keyH = KeyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize*3/2);
		screenY = gp.screenHeight/2 - (gp.tileSize*3/2);
		
		solidArea = new Rectangle(18*gp.scale,15*gp.scale,(32-18)*gp.scale,(45-15)*gp.scale);
		solidareadefaultx = solidArea.x;
		solidareadefaulty = solidArea.y;
		
		hurtbox.height = (35-3)*gp.scale;
		hurtbox.width = (67-12)*gp.scale;
		
//		getPlayerImage();
//		getPlayerAttackImage();
		setDefaultValues();
	}
	
	public void setDefaultValues() {
		worldX = 23*gp.tileSize;
		worldY = 23*gp.tileSize;
		speed = 4;
		direction = "left";
		
		maxlife = 6;
		life = maxlife;
	}
	
	public void getPlayerImage() {
	
//		up1 = setup("/player/boy_up_1",gp.tileSize,gp.tileSize);
//		up2 = setup("/player/boy_up_2",gp.tileSize,gp.tileSize);
//		down1 = setup("/player/boy_down_1",gp.tileSize,gp.tileSize);
//		down2 = setup("/player/boy_down_2",gp.tileSize,gp.tileSize);

		left1 = secondsetup(resource.SPRITE.get(characternum), gp.tileSize*gp.scale, gp.tileSize*gp.scale);
		left2 = secondsetup(resource.SPRITE.get(characternum+1), gp.tileSize*gp.scale, gp.tileSize*gp.scale);
		left3 = secondsetup(resource.SPRITE.get(characternum+2), gp.tileSize*gp.scale, gp.tileSize*gp.scale);
		right1 = secondsetup(resource.SPRITE.get(3+characternum), gp.tileSize*gp.scale, gp.tileSize*gp.scale);
		right2 = secondsetup(resource.SPRITE.get(3+characternum+1), gp.tileSize*gp.scale, gp.tileSize*gp.scale);
		right3 = secondsetup(resource.SPRITE.get(3+characternum+2), gp.tileSize*gp.scale, gp.tileSize*gp.scale);	
		
	}
	
	public void getPlayerAttackImage() {
//		attackup1 = setup("/player/boy_attack_up_1",gp.tileSize,gp.tileSize*2);
//		attackup2 = setup("/player/boy_attack_up_2",gp.tileSize,gp.tileSize*2);
//		attackdown1 = setup("/player/boy_attack_down_1",gp.tileSize,gp.tileSize*2);
//		attackdown2 = setup("/player/boy_attack_down_2",gp.tileSize,gp.tileSize*2);
		
		attackleft1 = secondsetup(resource.SPRITE.get(attacknum), gp.tileSize*gp.scale*2, gp.tileSize*gp.scale);
		attackleft2 = secondsetup(resource.SPRITE.get(attacknum+1), gp.tileSize*gp.scale*2, gp.tileSize*gp.scale);
		attackright1 = secondsetup(resource.SPRITE.get(3+attacknum), gp.tileSize*gp.scale*2, gp.tileSize*gp.scale);
		attackright2 = secondsetup(resource.SPRITE.get(3+attacknum+1), gp.tileSize*gp.scale*2, gp.tileSize*gp.scale);
	}
	
	public void update() {
		if(attacking) {
			attack();
		}
		
		else if (keyH.up || keyH.down || keyH.left || keyH.right || keyH.enter) {
			if(keyH.up && !keyH.down) {
				direction = "up";
			}
			if(keyH.down && !keyH.up) {
				direction = "down";			
			}
			if(keyH.right && !keyH.left) {
				direction = "right";
				rightleftdir = direction;
			}
			if(keyH.left && !keyH.right) {
				direction = "left";
				rightleftdir = direction;
			}
			
			collisionOn = false;
			gp.cChecker.checkTile(this);
			int objIndex = gp.cChecker.checkObject(this, true);
			pickupobjects(objIndex);
			int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
			interactnpc(npcIndex);
			int monsIndex = gp.cChecker.checkEntity(this, gp.mons);
			contactmons(monsIndex);
			ispoweredup();
			gp.ehandler.checkevent();
			
			if (collisionOn == false && !gp.keyH.enter) {
				if(keyH.up && !keyH.down) {
					worldY -= speed;
				}
				if(keyH.down && !keyH.up) {
					worldY += speed;			
				}
				if(keyH.right && !keyH.left) {
					worldX += speed;
				}
				if(keyH.left && !keyH.right) {
					worldX -= speed;
				}
			}
			
			gp.keyH.enter = false;
			
			spriteCounter++;
			if(spriteCounter>12) {
				if(spriteNum==1) {
					spriteNum = 2;
				}
				else if (spriteNum == 2) {
					spriteNum = 3;
				}
				else if (spriteNum == 3) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}
		
		//iframe counter
		if(iframe) {
			iframecounter++;
			if(iframecounter>60) {
				iframe = false;
				iframecounter = 0;
			}
		}
		
	}
	
	public void attack() {
		
		int currentworldx = worldX;
		int currentworldy = worldY;
		int solidareawidth = solidArea.width;
		int solidareaheight = solidArea.height;
		
		switch (direction) {
		case "up": worldY -= hurtbox.height; break;
		case "down": worldY += hurtbox.height; break;
		case "left": worldX -= hurtbox.width; break;
		case "right": worldX += hurtbox.width; break;
		}
		
		solidArea.width = hurtbox.width;
		solidArea.height = hurtbox.height;
		
		int monsterIndex = gp.cChecker.checkEntity(this, gp.mons);
		damagemonster(monsterIndex);
		
		worldX = currentworldx;
		worldY = currentworldy;
		solidArea.width = solidareawidth;
		solidArea.height = solidareaheight;
		
		
		spriteCounter++;
		if(spriteCounter <= 5) {
			spriteNum = 1;
		}
		else if(spriteCounter > 5 && spriteCounter <= 15) {
			spriteNum = 2;
		}
		else if (spriteCounter > 15 && spriteCounter <= 25) {
			spriteNum = 3;
		}
		else if(spriteCounter > 25) {
			spriteNum = 1;
			spriteCounter = 0;
			attacking = false;
		}
	}
	
	public void ispoweredup() {
		if (poweredup) {
			poweruptimer++;
			gp.ui.showmessage("sped up for "+poweruptimer/60+"s");
			if(poweruptimer > 120) {
				poweredup = false;
				poweruptimer = 0;
				speed -= 2;
			}
		}
	}

	public void pickupobjects(int i) {
		if(i != 999) {
			
//			switch(gp.obj.get(i).name) {
//			case "Key":
//				gp.obj.remove(i);
//				hasKey++;
//				gp.playsfx(1);
//				gp.ui.showmessage("got a key");
//				break;
//			case "Door":
//				if(hasKey>0) {
//					gp.obj.remove(i);
//					hasKey--;
//					gp.playsfx(4);
//					gp.ui.showmessage("opened the door");
//				}
//				else gp.ui.showmessage("need a key man");
//				break;
//			case "Boots":
//				gp.obj.remove(i);
//				gp.playsfx(3);
//				poweredup = true;
//				speed += 2;
//				break;
//			case "Chest":
//				gp.ui.gamefinished = true;
//				gp.music.stop();
//				gp.playsfx(2);
//				break;
//			}
		}
	}
	
	public void interactnpc(int i) {
		if(gp.keyH.enter) {
			if(i != 999) {
				gp.gamestate = gp.dialoguestate;
				gp.npc.get(i).speak();
			}
			else {
				attacking = true;
				gp.playsfx(8);
			}
		}
	}
	
	public void contactmons(int i) {
		if(i!=999) {
			if(!iframe) {
				life--;
				gp.playsfx(5);
				iframe = true;
			}
		}
	}
	
	public void damagemonster(int i) {
		if(i!=999) {
			System.out.println("hit a slime");
			if(!gp.mons.get(i).iframe) {
				gp.mons.get(i).life--;
				gp.mons.get(i).damageReaction();
				gp.mons.get(i).iframe = true;
				gp.playsfx(7);
				
				if(gp.mons.get(i).life<=0) gp.mons.get(i).dying = true;	
			}
		}
		else System.out.println("miss");
	}
	
	public void draw(Graphics2D g2) {
//		g2.setColor(Color.white);
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
//		int tempscreenx = screenX-gp.tileSize;
//		int tempscreeny = screenY-gp.tileSize;
		
		int tempscreenx = screenX;
		int tempscreeny = screenY;
		
		BufferedImage image = null;
		
		switch(rightleftdir) {
//		case "up":
//			if(attacking) {
//				tempscreeny = screenY-gp.tileSize;
//				if(spriteNum == 1) {image = attackup1;}
//				if(spriteNum == 2) {image = attackup2;}
//			}
//			else {
//				if(spriteNum == 1) {image = up1;}
//				if(spriteNum == 2) {image = up2;}
//			}
//			break;
//		case "down":
//			if(attacking) {
//				if(spriteNum == 1) {image = attackdown1;}
//				if(spriteNum == 2) {image = attackdown2;}
//			}
//			else {
//				if(spriteNum == 1) {image = down1;}
//				if(spriteNum == 2) {image = down2;}
//			}
//			break;
		case "left":
			if(attacking) {
				tempscreenx = screenX-gp.tileSize*3;
//				if(spriteNum == 1) {image = attackleft1;}
//				if(spriteNum == 2) {image = attackleft2;}
				if(spriteNum == 1) { image = secondsetup(resource.ATTACK.get(attacknum), gp.tileSize*gp.scale*2, gp.tileSize*gp.scale); }
				if(spriteNum == 2) { image = secondsetup(resource.ATTACK.get(attacknum+1), gp.tileSize*gp.scale*2, gp.tileSize*gp.scale); }
				if(spriteNum == 3) { image = secondsetup(resource.ATTACK.get(attacknum+2), gp.tileSize*gp.scale*2, gp.tileSize*gp.scale); }
			}
			else {
//				if(spriteNum == 1) {image = left1;}
//				if(spriteNum == 2) {image = left2;}
//				if(spriteNum == 3) {image = left3;}
				if(spriteNum == 1) { image = secondsetup(resource.SPRITE.get(characternum), gp.tileSize*gp.scale, gp.tileSize*gp.scale); }
				if(spriteNum == 2) { image = secondsetup(resource.SPRITE.get(characternum+1), gp.tileSize*gp.scale, gp.tileSize*gp.scale); }
				if(spriteNum == 3) { image = secondsetup(resource.SPRITE.get(characternum+2), gp.tileSize*gp.scale, gp.tileSize*gp.scale); }
			}
			break;
		case "right":
			if(attacking) {
//				if(spriteNum == 1) {image = attackright1;}
//				if(spriteNum == 2) {image = attackright2;}
				if(spriteNum == 1) { image = secondsetup(resource.ATTACK.get(3+attacknum), gp.tileSize*gp.scale*2, gp.tileSize*gp.scale); }
				if(spriteNum == 2) { image = secondsetup(resource.ATTACK.get(3+attacknum+1), gp.tileSize*gp.scale*2, gp.tileSize*gp.scale); }
				if(spriteNum == 3) { image = secondsetup(resource.ATTACK.get(3+attacknum+2), gp.tileSize*gp.scale*2, gp.tileSize*gp.scale); }
			}
			else {
//				if(spriteNum == 1) {image = right1;}
//				if(spriteNum == 2) {image = right2;}
//				if(spriteNum == 3) {image = right3;}
				if(spriteNum == 1) { image = secondsetup(resource.SPRITE.get(3+characternum), gp.tileSize*gp.scale, gp.tileSize*gp.scale); }
				if(spriteNum == 2) { image = secondsetup(resource.SPRITE.get(3+characternum+1), gp.tileSize*gp.scale, gp.tileSize*gp.scale); }
				if(spriteNum == 3) { image = secondsetup(resource.SPRITE.get(3+characternum+2), gp.tileSize*gp.scale, gp.tileSize*gp.scale); }
			}
			break;
		}
		
//		g2.setColor(healthbar);
//		g2.fillRect( worldX+solidArea.x, worldY+solidArea.y,solidArea.width,solidArea.height);
		
//		if(attacking) { g2.fillRect(tempscreenx, tempscreeny, hurtbox.width, hurtbox.height); }
		
		if(iframe) {
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.3F));
			
		}
		
		g2.drawImage(image, tempscreenx, tempscreeny, null);
		
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1F));
		
	}
}
