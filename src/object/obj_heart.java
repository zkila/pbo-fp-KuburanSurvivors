package object;

import entity.Entity;
import main.GamePanel;

public class obj_heart extends Entity{
	
	public obj_heart(GamePanel gp) {
		super(gp);
		name = "Heart";
		image1 = setup("/objects/heart_full",gp.tileSize,gp.tileSize);
		image2 = setup("/objects/heart_half",gp.tileSize,gp.tileSize);
		image3 = setup("/objects/heart_blank",gp.tileSize,gp.tileSize);
	}
}
