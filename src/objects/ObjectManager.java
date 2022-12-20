package objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import entity.Entity;
import main.GamePanel;
import resource.Resource;

public class ObjectManager{
	GamePanel gp;
	public int mapObjectNum [][];
	public Object[][] map_object;
	
	public ObjectManager(GamePanel gp) {
		this.gp = gp;
		mapObjectNum = new int [gp.maxWorldCol][gp.maxWorldRow];
		map_object = new Object [gp.maxWorldCol][gp.maxWorldRow];
		loadMap("/maps/world_obj.txt");
	}

	private void loadMap(String fileMaps) {
		try {
			
			InputStream is = getClass().getResourceAsStream(fileMaps);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				
				String line = br.readLine();
				
				while(col < gp.maxWorldCol) {
					String numbers[] = line.split(" ");
					
					byte objectID = (byte) Integer.parseInt(numbers[col]);
					     
					mapObjectNum[col][row] = objectID;
					
				//	ObjectData object = Resource.OBJECT.get(objectID);
					//map_object[col][row] = new Object (objectID, col*gp.tileSize, row*gp.tileSize, object.width, object.height, object.solidArea, object.collision);
					//System.out.println(col*gp.tileSize + " " + row*gp.tileSize);
					//System.out.println(map_object[col][row]);
					col++; 
				}
				if (col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();
		}catch(Exception e){
		System.out.println("LoapMap in ObjectManager is ERROR");
		}
		
	}
	
	public void draw (Graphics2D g2) {
		int col = 0;
		int row = 0;
		
		while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
			
			int tileNum = mapObjectNum[col][row];
			
			int worldX = col * gp.tileSize;
			int worldY = row * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			if(worldX + gp.tileSize * Resource.OBJECT.get(tileNum).width > gp.player.worldX - gp.player.screenX &&
			   worldX - gp.tileSize * Resource.OBJECT.get(tileNum).width < gp.player.worldX + gp.player.screenX &&
			   worldY + gp.tileSize * Resource.OBJECT.get(tileNum).height > gp.player.worldY - gp.player.screenY &&
			   worldY - gp.tileSize * Resource.OBJECT.get(tileNum).height < gp.player.worldY + gp.player.screenY &&
			   tileNum != 0) {
				
				//g2.setColor(Color.BLUE);
				
				g2.drawImage(Resource.OBJECT.get(tileNum).image, screenX, screenY, Resource.OBJECT.get(tileNum).width * gp.tileSize , Resource.OBJECT.get(tileNum).height * gp.tileSize, null);
				//g2.fill(Resource.OBJECT.get(tileNum).solidArea);
			}
	
			col++;
			
			if (col == gp.maxWorldCol) {
				col = 0;
				row++;
				
			}
		}
	}
	
	public int checkObject (Entity entity, boolean player) {
		
		int index = 999;
		
		for (int i = 0; i < Resource.OBJECT.size(); i++) {
			for (int j = 0; j < Resource.OBJECT.size(); j++) {
			if(Resource.OBJECT.get(i) != null && Resource.OBJECT.indexOf(Resource.OBJECT.get(i)) != 0) {
				
				//Get entity solid area position
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y = entity.worldY + entity.solidArea.y;
				
				//get the objects solid area position
//				Resource.OBJECT.get(i).solidArea.x = Resource.OBJECT.get(i).worldX + Resource.OBJECT.get(i).solidArea.x;
//				Resource.OBJECT.get(i).solidArea.y = Resource.OBJECT.get(i).worldY + Resource.OBJECT.get(i).solidArea.y;
				
		//		Resource.OBJECT.get(i).solidArea.x = Resource.OBJECT.get(i).worldX + Resource.OBJECT.get(i).solidArea.x;
		//		Resource.OBJECT.get(i).solidArea.y = Resource.OBJECT.get(i).worldY + Resource.OBJECT.get(i).solidArea.y;
				//System.out.println(Resource.OBJECT.get(i).solidArea.x + " " + Resource.OBJECT.get(i).solidArea.y + " " + Resource.OBJECT.get(i).worldX + " " + Resource.OBJECT.get(i).worldY);
				switch(entity.direction) {
				case "up":
					entity.solidArea.y -= entity.speed;
					if(entity.solidArea.intersects(Resource.OBJECT.get(i).solidArea)) {
						if(Resource.OBJECT.get(i).collision == true) {
							entity.collisionOn = true;
						}
						if(player == true) {
							index = i;
						}
						//System.out.println(Resource.OBJECT.get(i).solidArea.x + " " + Resource.OBJECT.get(i).solidArea.y + " " + Resource.OBJECT.get(i).worldX + " " + Resource.OBJECT.get(i).worldY);
						
					}
					break;
				case "down":
					entity.solidArea.y += entity.speed;
					if(entity.solidArea.intersects(Resource.OBJECT.get(i).solidArea)) {
						if(Resource.OBJECT.get(i).collision == true) {
							entity.collisionOn = true;
						}
						if(player == true) {
							index = i;
						}
					}
					break;
				case "left":
					entity.solidArea.x -= entity.speed;
					if(entity.solidArea.intersects(Resource.OBJECT.get(i).solidArea)) {
						if(Resource.OBJECT.get(i).collision == true) {
							entity.collisionOn = true;
						}
						if(player == true) {
							index = i;
						}
					}
					break;
				case "right":
					entity.solidArea.x += entity.speed;
					if(entity.solidArea.intersects(Resource.OBJECT.get(i).solidArea)) {
						if(Resource.OBJECT.get(i).collision == true) {
							entity.collisionOn = true;
						}
						if(player == true) {
							index = i;
						}
					}
					break;
				}
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
		//		Resource.OBJECT.get(i).solidArea.x = Resource.OBJECT.get(i).solidAreaDefaultX;
		//		Resource.OBJECT.get(i).solidArea.y = Resource.OBJECT.get(i).solidAreaDefaultY;
			}
			}
		}
		
		return index;
	}
}