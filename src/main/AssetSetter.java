package main;

import objects.OBJ_Chest;
import objects.OBJ_Door;
import objects.OBJ_Key;
import objects.OBJ_Tree;

public class AssetSetter {
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		gp.obj[0] = new OBJ_Key();
		gp.obj[0].worldX = 0*gp.tileSize;
		gp.obj[0].worldY = 0*gp.tileSize;
		
		gp.obj[1] = new OBJ_Key();
		gp.obj[1].worldX = 11*gp.tileSize;
		gp.obj[1].worldY = 10*gp.tileSize;
		
		gp.obj[2] = new OBJ_Chest();
		gp.obj[2].worldX = 12*gp.tileSize;
		gp.obj[2].worldY = 10*gp.tileSize;
		
		gp.obj[3] = new OBJ_Chest();
		gp.obj[3].worldX = 25*gp.tileSize;
		gp.obj[3].worldY = 22*gp.tileSize;
		
		gp.obj[4] = new OBJ_Door();
		gp.obj[4].worldX = 11*gp.tileSize;
		gp.obj[4].worldY = 11*gp.tileSize;
	
		gp.obj[5] = new OBJ_Tree();
		gp.obj[5].worldX = 1*gp.tileSize;
		gp.obj[5].worldY = 1*gp.tileSize;
		
		
	}
}
