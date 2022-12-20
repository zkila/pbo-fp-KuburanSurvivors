package main;

import entity.Entity;
import resource.Resource;

public class CollisionChecker {
	
	GamePanel gp;
	
	public CollisionChecker (GamePanel gp) {
		this.gp = gp;
	}
	
//	public void checkTile(Entity entity) {
//		int entityLeftWorldX = entity.worldX + entity.solidArea.x;
//		int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
//		int entityTopWorldY = entity.worldY + entity.solidArea.y;
//		int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
//		
//		int entityLeftCol = entityLeftWorldX / gp.tileSize;
//		int entityRightCol = entityRightWorldX / gp.tileSize;
//		int entityTopRow = entityTopWorldY / gp.tileSize;
//		int entityBottomRow = entityBottomWorldY / gp.tileSize;
//		
//		int tileNum1, tileNum2;
//		
//		switch(entity.direction) {
//		case "up":
//			entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
//			tileNum1 = gp.objectM.mapTileNum[entityLeftCol][entityTopRow];
//			tileNum2 = gp.objectM.mapTileNum[entityRightCol][entityTopRow];
//			if(gp.objectM.tile.get(tileNum1).collision == true || gp.objectM.tile.get(tileNum2).collision == true) {
//				entity.collisionOn = true;
//			}
//			break;
//		case "down":
//			entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
//			tileNum1 = gp.objectM.mapTileNum[entityLeftCol][entityBottomRow];
//			tileNum2 = gp.objectM.mapTileNum[entityRightCol][entityBottomRow];
//			if(gp.objectM.tile.get(tileNum1).collision == true || gp.objectM.tile.get(tileNum2).collision == true) {
//				entity.collisionOn = true;
//			}
//			break;
//		case "left":
//			entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
//			tileNum1 = gp.objectM.mapTileNum[entityLeftCol][entityTopRow];
//			tileNum2 = gp.objectM.mapTileNum[entityLeftCol][entityBottomRow];
//			if(gp.objectM.tile.get(tileNum1).collision == true || gp.objectM.tile.get(tileNum2).collision == true) {
//				entity.collisionOn = true;
//			}
//			break;
//		case "right":
//			entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
//			tileNum1 = gp.objectM.mapTileNum[entityRightCol][entityTopRow];
//			tileNum2 = gp.objectM.mapTileNum[entityRightCol][entityBottomRow];
//			if(gp.objectM.tile.get(tileNum1).collision == true || gp.objectM.tile.get(tileNum2).collision == true) {
//				entity.collisionOn = true;
//			}
//			break;
//		}
//	}
	
//	public void checkObject(Entity entity) {
//	int entityLeftWorldX = entity.worldX + entity.solidArea.x;
//	int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
//	int entityTopWorldY = entity.worldY + entity.solidArea.y;
//	int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
//	
//	int entityLeftCol = entityLeftWorldX / gp.tileSize;
//	int entityRightCol = entityRightWorldX / gp.tileSize;
//	int entityTopRow = entityTopWorldY / gp.tileSize;
//	int entityBottomRow = entityBottomWorldY / gp.tileSize;
//	
//	int tileNum1, tileNum2;
//	
//	switch(entity.direction) {
//	case "up":
//		entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
//		tileNum1 = gp.objectM.mapTileNum[entityLeftCol][entityTopRow];
//		tileNum2 = gp.objectM.mapTileNum[entityRightCol][entityTopRow];
//		if(Resource.OBJECT.get(tileNum1).collision == true || Resource.OBJECT.get(tileNum2).collision == true) {
//			entity.collisionOn = true;
//		}
//		break;
//	case "down":
//		entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
//		tileNum1 = gp.objectM.mapTileNum[entityLeftCol][entityBottomRow];
//		tileNum2 = gp.objectM.mapTileNum[entityRightCol][entityBottomRow];
//		if(Resource.OBJECT.get(tileNum1).collision == true || Resource.OBJECT.get(tileNum2).collision == true) {
//			entity.collisionOn = true;
//		}
//		break;
//	case "left":
//		entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
//		tileNum1 = gp.objectM.mapTileNum[entityLeftCol][entityTopRow];
//		tileNum2 = gp.objectM.mapTileNum[entityLeftCol][entityBottomRow];
//		if(Resource.OBJECT.get(tileNum1).collision == true || Resource.OBJECT.get(tileNum2).collision == true) {
//			entity.collisionOn = true;
//		}
//		break;
//	case "right":
//		entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
//		tileNum1 = gp.objectM.mapTileNum[entityRightCol][entityTopRow];
//		tileNum2 = gp.objectM.mapTileNum[entityRightCol][entityBottomRow];
//		if(Resource.OBJECT.get(tileNum1).collision == true || Resource.OBJECT.get(tileNum2).collision == true) {
//			entity.collisionOn = true;
//		}
//		break;
//	}
//}
	
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
				
				//Resource.OBJECT.get(i).solidArea.x = map_object.worldX + Resource.OBJECT.get(i).solidArea.x;
			//	Resource.OBJECT.get(i).solidArea.y = Resource.OBJECT.get(i).worldY + Resource.OBJECT.get(i).solidArea.y;
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
			//	Resource.OBJECT.get(i).solidArea.x = Resource.OBJECT.get(i).solidAreaDefaultX;
			//	Resource.OBJECT.get(i).solidArea.y = Resource.OBJECT.get(i).solidAreaDefaultY;
			}
			}
		}
		
		return index;
	}
	
//	public int checkObject (Entity entity, boolean player) {
//		
//		int index = 999;
//		
//		for (int i = 0; i < Resource.OBJECT.size(); i++) {
//			if(Resource.OBJECT.get(i) != null && Resource.OBJECT.indexOf(Resource.OBJECT.get(i)) != 0) {
//				
//				//Get entity solid area position
//				entity.solidArea.x = entity.worldX + entity.solidArea.x;
//				entity.solidArea.y = entity.worldY + entity.solidArea.y;
//				
//				//get the objects solid area position
//				Resource.OBJECT.get(i).solidArea.x = Resource.OBJECT.get(i).worldX + Resource.OBJECT.get(i).solidArea.x;
//				Resource.OBJECT.get(i).solidArea.y = Resource.OBJECT.get(i).worldY + Resource.OBJECT.get(i).solidArea.y;
//				//System.out.println(Resource.OBJECT.get(i).solidArea.x + " " + Resource.OBJECT.get(i).solidArea.y + " " + Resource.OBJECT.get(i).worldX + " " + Resource.OBJECT.get(i).worldY);
//				switch(entity.direction) {
//				case "up":
//					entity.solidArea.y -= entity.speed;
//					if(entity.solidArea.intersects(Resource.OBJECT.get(i).solidArea)) {
//						if(Resource.OBJECT.get(i).collision == true) {
//							entity.collisionOn = true;
//						}
//						if(player == true) {
//							index = i;
//						}
//						//System.out.println(Resource.OBJECT.get(i).solidArea.x + " " + Resource.OBJECT.get(i).solidArea.y + " " + Resource.OBJECT.get(i).worldX + " " + Resource.OBJECT.get(i).worldY);
//						
//					}
//					break;
//				case "down":
//					entity.solidArea.y += entity.speed;
//					if(entity.solidArea.intersects(Resource.OBJECT.get(i).solidArea)) {
//						if(Resource.OBJECT.get(i).collision == true) {
//							entity.collisionOn = true;
//						}
//						if(player == true) {
//							index = i;
//						}
//					}
//					break;
//				case "left":
//					entity.solidArea.x -= entity.speed;
//					if(entity.solidArea.intersects(Resource.OBJECT.get(i).solidArea)) {
//						if(Resource.OBJECT.get(i).collision == true) {
//							entity.collisionOn = true;
//						}
//						if(player == true) {
//							index = i;
//						}
//					}
//					break;
//				case "right":
//					entity.solidArea.x += entity.speed;
//					if(entity.solidArea.intersects(Resource.OBJECT.get(i).solidArea)) {
//						if(Resource.OBJECT.get(i).collision == true) {
//							entity.collisionOn = true;
//						}
//						if(player == true) {
//							index = i;
//						}
//					}
//					break;
//				}
//				entity.solidArea.x = entity.solidAreaDefaultX;
//				entity.solidArea.y = entity.solidAreaDefaultY;
//				Resource.OBJECT.get(i).solidArea.x = Resource.OBJECT.get(i).solidAreaDefaultX;
//				Resource.OBJECT.get(i).solidArea.y = Resource.OBJECT.get(i).solidAreaDefaultY;
//			}
//			
//		}
//		
//		return index;
//	}
}
