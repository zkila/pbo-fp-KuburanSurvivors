package tile;

import java.awt.Graphics2D;
import java.awt.im.InputContext;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import entity.Player;
import main.GamePanel;
import main.Utility;
import resourceloader.resource;

public class TileManager {
	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		
		tile = new Tile[50];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		//getTileImage();
		//loadMap("/map/worldV2.txt");
		//loadMap("/map/map.txt");
		loadMap("/map/worldwildan2.txt");
		
	}
	
	public void getTileImage() {		
			
		for (int i = 0 ; i<10 ; i++) setup(i,"grass00", false);
		
		setup(10,"grass00",false);
		setup(11,"grass01",false);
		setup(12,"water00",true);
		setup(13,"water01",true);
		setup(14,"water02",true);
		setup(15,"water03",true);
		setup(16,"water04",true);
		setup(17,"water05",true);
		setup(18,"water06",true);
		setup(19,"water07",true);
		setup(20,"water08",true);
		setup(21,"water09",true);
		setup(22,"water10",true);
		setup(23,"water11",true);
		setup(24,"water12",true);
		setup(25,"water13",true);
		setup(26,"road00",false);
		setup(27,"road01",false);
		setup(28,"road02",false);
		setup(29,"road03",false);
		setup(30,"road04",false);
		setup(31,"road05",false);
		setup(32,"road06",false);
		setup(33,"road07",false);
		setup(34,"road08",false);
		setup(35,"road09",false);
		setup(36,"road10",false);
		setup(37,"road11",false);
		setup(38,"road12",false);
		setup(39,"earth",false);
		setup(40,"wall",true);
		setup(41,"tree",true);
		
			
	}
	
	public void setup(int index, String imagepath, boolean collision) {
		Utility tool = new Utility();
		
		try {
			tile[index] = new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imagepath + ".png"));
			tile[index].image = tool.scaleimage(tile[index].image, gp.tileSize, gp.tileSize);
			tile[index].collision = collision;
			} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public Tile secondsetup(BufferedImage image, boolean collision) {
		Utility tool = new Utility();
		Tile tile = new Tile();
		try {
			tile.image = image;
			tile.image = tool.scaleimage(tile.image, gp.tileSize, gp.tileSize);
		} catch (Exception e) {
			// TODO: handle exception
		}
		tile.collision = collision;
		
		return tile;
	}
	
	public void loadMap(String filePath) {
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0, row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				String line = br.readLine();
				while(col < gp.maxWorldCol) {
					String numbers[] = line.split(" ");
					
					int number = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = number;
					col++;
				}
				if(col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		
		int worldCol = 0;
		int worldRow = 0;
	
		
		while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum [worldCol][worldRow];
			
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			if(worldX + gp.tileSize*1 > gp.player.worldX - gp.player.screenX &&
			   worldX - gp.tileSize*3 < gp.player.worldX + gp.player.screenX &&
			   worldY + gp.tileSize*1 > gp.player.worldY - gp.player.screenY &&
			   worldY - gp.tileSize*3 < gp.player.worldY + gp.player.screenY) {
				g2.drawImage(resource.TILE.get(tileNum).image, screenX, screenY, null);
			}
			worldCol++;
		
			if(worldCol == gp.maxWorldCol) {
				worldRow++;
				
				worldCol = 0;
		
			}
		}
	}
}
