package tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.imageio.ImageIO;


import main.GamePanel;
import resource.Resource;

public class TileManager {

	GamePanel gp;
	//public Tile[] tile;
	//public ArrayList<Tile> tile;
	public int mapTileNum [][];
	
	public TileManager (GamePanel gp) {
		this.gp = gp;
		
		//tile = new ArrayList<>();
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		//getTileImage ();
		loadMap("/maps/world.txt");
	}
	
	public void loadMap(String fileMaps) {
		try {
			
			InputStream is = getClass().getResourceAsStream(fileMaps);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				
				String line = br.readLine();
				
				while(col < gp.maxWorldCol) {
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}
				if (col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();
		}catch(Exception e){
			
		}
	}
	
	public void draw (Graphics2D g2) {
		int col = 0;
		int row = 0;
		
		while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[col][row];
			
			int worldX = col * gp.tileSize;
			int worldY = row * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
			   worldX - gp.tileSize*2 < gp.player.worldX + gp.player.screenX &&
			   worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
			   worldY - gp.tileSize*2 < gp.player.worldY + gp.player.screenY) {
				
				g2.drawImage(Resource.TILE.get(tileNum).image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			}

			col++;
			
			if (col == gp.maxWorldCol) {
				col = 0;
				row++;
				
			}
		}
		
		
	}
}
