package monster;

import main.GamePanel;
import resourceloader.resource;

public class mons_pocong extends anydirmonster{

	public mons_pocong(GamePanel gp) {
		super(gp);
		type = 2;
		name = "Pocong";
		speed = 2;
		maxlife = 8;
		life = maxlife;
		
		solidArea.x = 18*gp.scale;
		solidArea.y = 15*gp.scale;
		solidArea.width = (30-18)*gp.scale;
		solidArea.height = (45-15)*gp.scale;
		solidareadefaultx = solidArea.x;
		solidareadefaulty = solidArea.y;
		
		getImage();
	}
	
	public void getImage() {
		up1 = secondsetup(resource.SPRITE_GHOST.get(resource.POCONG_1), gp.tileSize*gp.scale, gp.tileSize*gp.scale);
		up2 = secondsetup(resource.SPRITE_GHOST.get(resource.POCONG_2), gp.tileSize*gp.scale, gp.tileSize*gp.scale);
		up3 = secondsetup(resource.SPRITE_GHOST.get(resource.POCONG_3), gp.tileSize*gp.scale, gp.tileSize*gp.scale);
		up4 = secondsetup(resource.SPRITE_GHOST.get(resource.POCONG_4), gp.tileSize*gp.scale, gp.tileSize*gp.scale);

	}
	
	public void damageReaction() {
		actionlockcounter = 0;
		direction = gp.player.direction;
	}

}
