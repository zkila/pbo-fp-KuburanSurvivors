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

public class TileManager {

	GamePanel gp;
	//public Tile[] tile;
	public ArrayList<Tile> tile;
	public int mapTileNum [][];
	
	public TileManager (GamePanel gp) {
		this.gp = gp;
		
		tile = new ArrayList<>();
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage ();
		loadMap("/maps/world3.txt");
	}
	
	public void getTileImage() {
		
		try {

//			tile[0] = new Tile();
//			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
//			
//			tile[1] = new Tile();
//			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
//			
//			tile[2] = new Tile();
//			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
//			tile[2].collision = true;
//			
//			tile[3] = new Tile();
//			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
//			
//			tile[4] = new Tile();
//			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tiles_kuburan.png"));
//			tile[4].collision = true;
			
			BufferedImage tileSheet = ImageIO.read(getClass().getResourceAsStream("/tiles/tilesset.png"));
			tile.add(new Tile (tileSheet.getSubimage(0, 0, 32, 32), false));
			tile.add(new Tile (tileSheet.getSubimage(32, 0, 32, 32), false));
			tile.add(new Tile (tileSheet.getSubimage(64, 0, 32, 32), false));
			tile.add(new Tile (tileSheet.getSubimage(0, 32, 32, 32), false));
			tile.add(new Tile (tileSheet.getSubimage(32, 32, 32, 32), false));
			tile.add(new Tile (tileSheet.getSubimage(64, 32, 32, 32), false));
			tile.add(new Tile (tileSheet.getSubimage(0, 64, 32, 32), false));
			tile.add(new Tile (tileSheet.getSubimage(32, 64, 32, 32), false));
			tile.add(new Tile (tileSheet.getSubimage(64, 64, 32, 32), false));
			
			tile.add(new Tile (tileSheet.getSubimage(96, 0, 32, 32), false));
			tile.add(new Tile (tileSheet.getSubimage(128, 0, 32, 32), false));
			tile.add(new Tile (tileSheet.getSubimage(160, 0, 32, 32), false));
			tile.add(new Tile (tileSheet.getSubimage(96, 32, 32, 32), false));
			tile.add(new Tile (tileSheet.getSubimage(128, 32, 32, 32), false));
			tile.add(new Tile (tileSheet.getSubimage(160, 32, 32, 32), false));
			tile.add(new Tile (tileSheet.getSubimage(96, 64, 32, 32), false));
			tile.add(new Tile (tileSheet.getSubimage(128, 64, 32, 32), false));
			tile.add(new Tile (tileSheet.getSubimage(160, 64, 32, 32), false));
			
		}catch (IOException e){
			e.printStackTrace();
		}
		
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
				
				g2.drawImage(tile.get(tileNum).image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			}

			col++;
			
			if (col == gp.maxWorldCol) {
				col = 0;
				row++;
				
			}
		}
		
		
	}
}
