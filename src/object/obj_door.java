package object;

import entity.Entity;
import main.GamePanel;

public class obj_door extends Entity{
	public obj_door(GamePanel gp) {
		super(gp);
		name = "Door";
		down1 = setup("/objects/door",gp.tileSize,gp.tileSize);
		collision = true;
		
		solidArea.x = 0;
		solidArea.y = 16;
		solidArea.width = 48;
		solidArea.height = 32;
		solidareadefaultx = solidArea.x;
		solidareadefaulty = solidArea.y;
	}
}
