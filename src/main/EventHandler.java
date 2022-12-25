package main;

import java.awt.Rectangle;

public class EventHandler {
	GamePanel gp;
	EventBox eventbox[][];
	
	int prevx,prevy;
	boolean cantouchevent = true;
	
	public EventHandler(GamePanel gp) {
		this.gp = gp;
		
		eventbox = new EventBox[gp.maxWorldCol][gp.maxWorldRow];
		int col = 0, row = 0;
		
		while(col<gp.maxWorldCol && row<gp.maxWorldRow) {
			eventbox[col][row] = new EventBox();
			eventbox[col][row].x = 23;
			eventbox[col][row].y = 23;
			eventbox[col][row].width = 2;
			eventbox[col][row].height = 2;
			eventbox[col][row].eventboxdefx = eventbox[col][row].x;
			eventbox[col][row].eventboxdefy = eventbox[col][row].y;
			
			col++;
			if(col == gp.maxWorldCol) {
				col = 0;
				row++;
			}
		}	
	}
	
	public void checkevent() {
		int xdistance = Math.abs(gp.player.worldX - prevx);
		int ydistance = Math.abs(gp.player.worldY - prevy);
		int distance = Math.max(xdistance, ydistance);
		if(distance > gp.tileSize) cantouchevent = true;
		
		if(cantouchevent) {
			if(hit(26,16,"right")) {damagepit(26,16,gp.dialoguestate);}
			if(hit(23,12,"up")) {healpool(23,12,gp.dialoguestate);}
		}
	}
	
	public boolean hit(int col, int row, String requireddirection) {
		boolean hit = false;
		
		gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
		gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
		
		eventbox[col][row].x = col*gp.tileSize + eventbox[col][row].x;
		eventbox[col][row].y = row*gp.tileSize +eventbox[col][row].y;
		
		if(gp.player.solidArea.intersects(eventbox[col][row]) && !eventbox[col][row].eventdone) {
			if(gp.player.direction.contentEquals(requireddirection) || requireddirection.contentEquals("any")) {
				hit = true;
				//System.out.println("hit has happened");
				prevx = gp.player.worldX;
				prevy = gp.player.worldY;
			}
		}
		gp.player.solidArea.x = gp.player.solidareadefaultx;
		gp.player.solidArea.y = gp.player.solidareadefaulty;
		eventbox[col][row].x = eventbox[col][row].eventboxdefx;
		eventbox[col][row].y = eventbox[col][row].eventboxdefy;
		
		return hit;
	}
	
	public void damagepit(int col, int row, int gamestate) {
		gp.gamestate = gamestate;
		gp.ui.currentdialogue = "you fell.\ninto a pit.";
		gp.player.life-=2;
		gp.playsfx(5);
	//	eventbox[col][row].eventdone = true;
		cantouchevent = false;
	}
	
	public void healpool(int col, int row, int gamestate) {
		if(gp.keyH.enter) {
			gp.gamestate = gamestate;
			gp.ui.currentdialogue = "healed by the pool";
			gp.player.life = gp.player.maxlife;
			gp.playsfx(6);
	//		eventbox[col][row].eventdone = true;
		}
	}
}
