package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;

public class mons_greenslime extends Entity{

	public mons_greenslime(GamePanel gp) {
		super(gp);
		type = 2;
		name = "Green Slime";
		speed = 1;
		maxlife = 20;
		life = maxlife;
		
		solidArea.x = 3;
		solidArea.y = 18;
		solidArea.width = 42;
		solidArea.height = 30;
		solidareadefaultx = solidArea.x;
		solidareadefaulty = solidArea.y;
		
		getImage();
	}
	
	public void getImage() {
		up1 = setup("/monsters/greenslime_down_1",gp.tileSize,gp.tileSize);
		up2 = setup("/monsters/greenslime_down_2",gp.tileSize,gp.tileSize);
		down1 = setup("/monsters/greenslime_down_1",gp.tileSize,gp.tileSize);
		down2 = setup("/monsters/greenslime_down_2",gp.tileSize,gp.tileSize);
		right1 = setup("/monsters/greenslime_down_1",gp.tileSize,gp.tileSize);
		right2 = setup("/monsters/greenslime_down_2",gp.tileSize,gp.tileSize);
		left1 = setup("/monsters/greenslime_down_1",gp.tileSize,gp.tileSize);
		left2 = setup("/monsters/greenslime_down_2",gp.tileSize,gp.tileSize);
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
	
	public void damageReaction() {
		actionlockcounter = 0;
		direction = gp.player.direction;
	}
}
