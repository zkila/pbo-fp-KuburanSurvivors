package object;


import entity.Entity;
import main.GamePanel;

public class obj_boots extends Entity {
	public obj_boots(GamePanel gp) {
		super(gp);
		name = "Boots";
		down1 = setup("/objects/boots",gp.tileSize,gp.tileSize);
	}
}
