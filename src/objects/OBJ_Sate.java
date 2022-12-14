package objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Sate extends SuperObject{
	public OBJ_Sate() {
		name = "Sate";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/obj_sate.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
