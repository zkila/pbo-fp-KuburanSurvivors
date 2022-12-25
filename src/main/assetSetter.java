package main;

import entity.npc_oldman;
import monster.mons_greenslime;
import monster.mons_kuntilanak;
import monster.mons_pocong;
import object.obj_boots;
import object.obj_chest;
import object.obj_door;
import object.obj_key;

public class assetSetter {
	
	GamePanel gp;
	
	public assetSetter(GamePanel gp) {
		this.gp = gp;
		
	}
	
	public void setobject () {
//		gp.obj.add(new obj_key());
//		gp.obj.get(0).worldX = 23 * gp.tileSize;
//		gp.obj.get(0).worldY = 7 * gp.tileSize;
//		
//		gp.obj.add(new obj_key());
//		gp.obj.get(1).worldX = 23 * gp.tileSize;
//		gp.obj.get(1).worldY = 40 * gp.tileSize;
//		
//		gp.obj.add(new obj_door());
//		gp.obj.get(2).worldX = 12 * gp.tileSize;
//		gp.obj.get(2).worldY = 22 * gp.tileSize;
//		
//		gp.obj.add(new obj_door());
//		gp.obj.get(3).worldX = 10 * gp.tileSize;
//		gp.obj.get(3).worldY = 11 * gp.tileSize;
//		
//		gp.obj.add(new obj_chest());
//		gp.obj.get(4).worldX = 23 * gp.tileSize;
//		gp.obj.get(4).worldY = 6 * gp.tileSize;
//		
//		gp.obj.add(new obj_chest());
//		gp.obj.get(5).worldX = 10 * gp.tileSize;
//		gp.obj.get(5).worldY = 7 * gp.tileSize;
//		
//		gp.obj.add(new obj_boots());
//		gp.obj.get(6).worldX = 37 * gp.tileSize;
//		gp.obj.get(6).worldY = 42 * gp.tileSize;
		
//		gp.obj.add(new obj_door(gp));
//		gp.obj.get(0).worldX = 21 * gp.tileSize;
//		gp.obj.get(0).worldY = 22 * gp.tileSize;
//		
//		gp.obj.add(new obj_door(gp));
//		gp.obj.get(1).worldX = 23 * gp.tileSize;
//		gp.obj.get(1).worldY = 25 * gp.tileSize;
	}
	
	public void setnpc() {
		gp.npc.add(new npc_oldman(gp));
		gp.npc.get(0).worldX = gp.tileSize * 21;
		gp.npc.get(0).worldY = gp.tileSize * 21;
	}
	
	public void setmons() {
//		gp.mons.add(new mons_greenslime(gp));
//		gp.mons.get(0).worldX = gp.tileSize * 23;
//		gp.mons.get(0).worldY = gp.tileSize * 36;
//		
//		gp.mons.add(new mons_greenslime(gp));
//		gp.mons.get(1).worldX = gp.tileSize * 25;
//		gp.mons.get(1).worldY = gp.tileSize * 35;
		
		gp.mons.add(new mons_kuntilanak(gp));
		gp.mons.get(0).worldX = gp.tileSize * 23;
		gp.mons.get(0).worldY = gp.tileSize * 36;
		
		gp.mons.add(new mons_kuntilanak(gp));
		gp.mons.get(1).worldX = gp.tileSize * 25;
		gp.mons.get(1).worldY = gp.tileSize * 35;
		
		gp.mons.add(new mons_pocong(gp));
		gp.mons.get(2).worldX = gp.tileSize * 22;
		gp.mons.get(2).worldY = gp.tileSize * 35;
		
		gp.mons.add(new mons_pocong(gp));
		gp.mons.get(3).worldX = gp.tileSize * 20;
		gp.mons.get(3).worldY = gp.tileSize * 35;
		
		gp.mons.add(new mons_pocong(gp));
		gp.mons.get(4).worldX = gp.tileSize * 18;
		gp.mons.get(4).worldY = gp.tileSize * 35;
	}
}
