package object;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class obj_key extends Entity {
	public obj_key(GamePanel gp) {
		super(gp);
		name = "Key";
		down1 = setup("/objects/key.png",gp.tileSize,gp.tileSize);
	}
}
