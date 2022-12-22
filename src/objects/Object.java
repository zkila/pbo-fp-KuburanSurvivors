package objects;

import java.awt.Rectangle;

import resource.Resource;

public class Object {


	public byte objectID;
	public int worldX;
	public int worldY;
	public int width;
	public int height;
	public Rectangle solidArea;
	public boolean collision;
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;
	public ObjectData data;
	
	
//	public Object(byte id, int worldX, int worldY, int width, int height, Rectangle solidArea,boolean collision) {
//		
//		this.objectID = id;
//		this.worldX = worldX;
//		this.worldY = worldY;
//		this.width = width;
//		this.height = height;
//		this.solidArea = solidArea;
//		this.collision = collision;
//	}
	
	public Object(byte id, int worldX, int worldY) {
		this.objectID = id;
		this.worldX = worldX;
		this.worldY = worldY;
		this.data = Resource.OBJECT.get(id);
	}
	
	public byte getID() {
		
		return objectID;
	}
	
//	public void draw(Graphics2D g2, GamePanel gp) {
//		int screenX = worldX - gp.player.worldX + gp.player.screenX;
//		int screenY = worldY - gp.player.worldY + gp.player.screenY;
//		
//		if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
//		   worldX - gp.tileSize*2 < gp.player.worldX + gp.player.screenX &&
//		   worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
//		   worldY - gp.tileSize*2 < gp.player.worldY + gp.player.screenY) {
//				
//			g2.setColor(Color.WHITE);
//			g2.fillRect(screenX, screenY, gp.tileSize, gp.tileSize);
//			g2.drawImage(Resource.OBJECT.get(0).image, screenX, screenY, width*gp.tileSize, height*gp.tileSize, null);
//			
//		}
//	}
}