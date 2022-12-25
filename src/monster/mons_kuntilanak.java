package monster;

import main.GamePanel;
import resourceloader.resource;

public class mons_kuntilanak extends leftrightmonster {
	int timer=0;
	boolean speedbuffed = false;
	public mons_kuntilanak (GamePanel gp) {
		super(gp);
		type = 2;
		name = "Kuntilanak";
		speed = 1;
		maxlife = 4;
		life = maxlife;
		
		solidArea.x = 16*gp.scale;
		solidArea.y = 21*gp.scale;
		solidArea.width = (31-16)*gp.scale;
		solidArea.height = (44-21)*gp.scale;
		solidareadefaultx = solidArea.x;
		solidareadefaulty = solidArea.y;
		
		getImage();
	}
	
	public void getImage() {
		left1 = secondsetup(resource.SPRITE_GHOST.get(resource.KUNTILANAK_L_1), gp.tileSize*gp.scale, gp.tileSize*gp.scale);
		left2 = secondsetup(resource.SPRITE_GHOST.get(resource.KUNTILANAK_L_2), gp.tileSize*gp.scale, gp.tileSize*gp.scale);
		right1 = secondsetup(resource.SPRITE_GHOST.get(resource.KUNTILANAK_R_1), gp.tileSize*gp.scale, gp.tileSize*gp.scale);
		right2 = secondsetup(resource.SPRITE_GHOST.get(resource.KUNTILANAK_R_2), gp.tileSize*gp.scale, gp.tileSize*gp.scale);
		
//		left1 = resource.SPRITE_GHOST.get(resource.KUNTILANAK_L_1);
//		left2 = resource.SPRITE_GHOST.get(resource.KUNTILANAK_L_2);
//		right1 = resource.SPRITE_GHOST.get(resource.KUNTILANAK_R_1);
//		right2 = resource.SPRITE_GHOST.get(resource.KUNTILANAK_R_2);
	}
	
	public void damageReaction() {
		actionlockcounter = 0;
		direction = gp.player.direction;
		speedbuffed = true;
		switch(gp.player.direction) {
		case "up":
			direction = "down";
			break;
		case "down":
			direction = "up";
			break;
		case "left":
			direction = "right";
			rightleftdir = "right";
			break;
		case "right":
			direction = "left";
			rightleftdir = "left";
			break;
		}
	}
	
	public void update() {
		setAction();
		speedbuffcheck();
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
	
	public void speedbuffcheck() {
		if(speedbuffed) {
			speed = 2;
			timer++;
			if(timer > 60) {
				speed = 1;
				timer = 0;
				speedbuffed = false;
			}
		}
	}
}
