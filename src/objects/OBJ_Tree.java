package objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Tree extends SuperObject {
	
	public OBJ_Tree(){
		name = "Tree";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/obj_pohon.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}

}
