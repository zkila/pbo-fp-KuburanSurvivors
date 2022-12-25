package object;

import entity.Entity;
import main.GamePanel;

public class obj_chest extends Entity{
	public obj_chest(GamePanel gp) {
		super(gp);
		name = "Chest";
		down1 = setup("/objects/chest",gp.tileSize,gp.tileSize);
	}
}
