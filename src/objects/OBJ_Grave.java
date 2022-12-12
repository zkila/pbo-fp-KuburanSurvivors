package objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Grave extends SuperObject{
	public OBJ_Grave() {
		name = "Grave";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/obj_kuburan.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
