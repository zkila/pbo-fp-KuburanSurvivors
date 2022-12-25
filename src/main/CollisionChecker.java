package main;

import java.util.ArrayList;
import java.util.List;

import entity.Entity;
import resourceloader.resource;

public class CollisionChecker {
	GamePanel gp;
	
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Entity entity) {
		int entityleftworldx = entity.worldX + entity.solidArea.x;
		int entityrightworldx = entity.worldX + entity.solidArea.x + entity.solidArea.width;
		int entitytopworldy = entity.worldY + entity.solidArea.y;
		int entitybottomworldy = entity.worldY + entity.solidArea.y + entity.solidArea.height;
		
		int entityleftcol = entityleftworldx / gp.tileSize;
		int entityrightcol = entityrightworldx / gp.tileSize;
		int entitytoprow = entitytopworldy / gp.tileSize;
		int entitybottomrow = entitybottomworldy / gp.tileSize;
		
		int tilenum1, tilenum2;
		
		switch(entity.direction) {
		case "up":
			entitytoprow = (entitytopworldy - entity.speed) / gp.tileSize;
			tilenum1 = gp.tileManager.mapTileNum[entityleftcol][entitytoprow];
			tilenum2 = gp.tileManager.mapTileNum[entityrightcol][entitytoprow];
			if(resource.TILE.get(tilenum1).collision == true || resource.TILE.get(tilenum2).collision == true) {
				entity.collisionOn = true;
			}
			break;
		case "down":
			entitybottomrow = (entitybottomworldy + entity.speed) / gp.tileSize;
			tilenum1 = gp.tileManager.mapTileNum[entityleftcol][entitybottomrow];
			tilenum2 = gp.tileManager.mapTileNum[entityrightcol][entitybottomrow];
			if(resource.TILE.get(tilenum1).collision  == true || resource.TILE.get(tilenum2).collision == true) {
				entity.collisionOn = true;
			}
			break;
		case "left":
			entityleftcol = (entityleftworldx - entity.speed) / gp.tileSize;
			tilenum1 = gp.tileManager.mapTileNum[entityleftcol][entitytoprow];
			tilenum2 = gp.tileManager.mapTileNum[entityleftcol][entitybottomrow];
			if(resource.TILE.get(tilenum1).collision  == true || resource.TILE.get(tilenum2).collision == true) {
				entity.collisionOn = true;
			}
			break;
		case "right":
			entityrightcol = (entityrightworldx + entity.speed) / gp.tileSize;
			tilenum1 = gp.tileManager.mapTileNum[entityrightcol][entitytoprow];
			tilenum2 = gp.tileManager.mapTileNum[entityrightcol][entitybottomrow];
			if(resource.TILE.get(tilenum1).collision  == true || resource.TILE.get(tilenum2).collision == true) {
				entity.collisionOn = true;
			}
			break;
		}
	}
	
	public int checkObject(Entity entity, boolean player) {
		int index = 999;
		
		for(int i = 0 ; i<gp.obj.size() ; i++) {
			if(gp.obj.get(i) != null) {
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y = entity.worldY + entity.solidArea.y;
				
				gp.obj.get(i).solidArea.x = gp.obj.get(i).worldX + gp.obj.get(i).solidArea.x;
				gp.obj.get(i).solidArea.y = gp.obj.get(i).worldY + gp.obj.get(i).solidArea.y;
				
				switch (entity.direction) {
				case "up":
					entity.solidArea.y -= entity.speed;				
					break;
				case "down":
					entity.solidArea.y += entity.speed;
					break;
				case "left":
					entity.solidArea.x -= entity.speed;
					break;
				case "right":
					entity.solidArea.x += entity.speed;
					break;
				}
				
				if (entity.solidArea.intersects(gp.obj.get(i).solidArea)) {
					System.out.println("up collision");
					if(gp.obj.get(i).collision) {
						entity.collisionOn = true;
					}
					if(player) {
						System.out.println("item is "+gp.obj.get(i).name);
						index = i;
					}
				}
				
				entity.solidArea.x = entity.solidareadefaultx;
				entity.solidArea.y = entity.solidareadefaulty;
				gp.obj.get(i).solidArea.x = gp.obj.get(i).solidareadefaultx;
				gp.obj.get(i).solidArea.y = gp.obj.get(i).solidareadefaulty;
			}
		}
		
		return index;
	}
	
	public int checkEntity(Entity entity, ArrayList<Entity> target) {
	int index = 999;
		
		for(int i = 0 ; i<target.size() ; i++) {
			if(target.get(i) != null) {
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y = entity.worldY + entity.solidArea.y;
				
				target.get(i).solidArea.x = target.get(i).worldX + target.get(i).solidArea.x;
				target.get(i).solidArea.y = target.get(i).worldY + target.get(i).solidArea.y;
				
				switch (entity.direction) {
				case "up": entity.solidArea.y -= entity.speed; break;
				case "down": entity.solidArea.y += entity.speed; break;
				case "left": entity.solidArea.x -= entity.speed; break;
				case "right": entity.solidArea.x += entity.speed; break;
				}
				
				if (entity.solidArea.intersects(target.get(i).solidArea)) {
					if(target.get(i)!=entity) {
						entity.collisionOn = true;
						index = i;
					}
				}
				
				entity.solidArea.x = entity.solidareadefaultx;
				entity.solidArea.y = entity.solidareadefaulty;
				target.get(i).solidArea.x = target.get(i).solidareadefaultx;
				target.get(i).solidArea.y = target.get(i).solidareadefaulty;
			}
		}
		
		return index;
	}
	
	public boolean checkPlayer(Entity entity) {
		
		boolean contactplayer = false;
		
		entity.solidArea.x = entity.worldX + entity.solidArea.x;
		entity.solidArea.y = entity.worldY + entity.solidArea.y;
		
		gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
		gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
		
		switch (entity.direction) {
		case "up": entity.solidArea.y -= entity.speed; break;
		case "down": entity.solidArea.y += entity.speed; break;
		case "left": entity.solidArea.x -= entity.speed; break;
		case "right": entity.solidArea.x += entity.speed; break;
		}
		if (entity.solidArea.intersects(gp.player.solidArea)) {
			entity.collisionOn = true;
			contactplayer = true;
		}
		entity.solidArea.x = entity.solidareadefaultx;
		entity.solidArea.y = entity.solidareadefaulty;
		gp.player.solidArea.x = gp.player.solidareadefaultx;
		gp.player.solidArea.y = gp.player.solidareadefaulty;
		
		return contactplayer;
	}
}
