package resource;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import java.io.IOException;


import javax.imageio.ImageIO;

import main.GamePanel;
import objects.ObjectData;
import tile.Tile;

public class Loader {
	 GamePanel gp;
	public void load() {
		
		// GUI
		try {

			Resource.GUI.add(ImageIO.read(getClass().getResourceAsStream("/gui/background_mainmenu.png")));
			Resource.GUI.add(ImageIO.read(getClass().getResourceAsStream("/gui/selectionscreen.png")));
			Resource.GUI.add(ImageIO.read(getClass().getResourceAsStream("/gui/pauseng.png")));
		} catch (IOException e) {
			System.out.println("[Loader] : Can't load gui / file not found");
			e.printStackTrace();
		}
		
		// TILES
		try {
			BufferedImage tileSheet = ImageIO.read(getClass().getResourceAsStream("/tiles/tilesset.png"));
			Resource.TILE.add(new Tile (tileSheet.getSubimage(0, 0, 32, 32), false));
			Resource.TILE.add(new Tile (tileSheet.getSubimage(32, 0, 32, 32), false));
			Resource.TILE.add(new Tile (tileSheet.getSubimage(64, 0, 32, 32), false));
			Resource.TILE.add(new Tile (tileSheet.getSubimage(0, 32, 32, 32), false));
			Resource.TILE.add(new Tile (tileSheet.getSubimage(32, 32, 32, 32), false));
			Resource.TILE.add(new Tile (tileSheet.getSubimage(64, 32, 32, 32), false));
			Resource.TILE.add(new Tile (tileSheet.getSubimage(0, 64, 32, 32), false));
			Resource.TILE.add(new Tile (tileSheet.getSubimage(32, 64, 32, 32), false));
			Resource.TILE.add(new Tile (tileSheet.getSubimage(64, 64, 32, 32), false));
			
			Resource.TILE.add(new Tile (tileSheet.getSubimage(96, 0, 32, 32), false));
			Resource.TILE.add(new Tile (tileSheet.getSubimage(128, 0, 32, 32), false));
			Resource.TILE.add(new Tile (tileSheet.getSubimage(160, 0, 32, 32), false));
			Resource.TILE.add(new Tile (tileSheet.getSubimage(96, 32, 32, 32), false));
			Resource.TILE.add(new Tile (tileSheet.getSubimage(128, 32, 32, 32), false));
			Resource.TILE.add(new Tile (tileSheet.getSubimage(160, 32, 32, 32), false));
			Resource.TILE.add(new Tile (tileSheet.getSubimage(96, 64, 32, 32), false));
			Resource.TILE.add(new Tile (tileSheet.getSubimage(128, 64, 32, 32), false));
			Resource.TILE.add(new Tile (tileSheet.getSubimage(160, 64, 32, 32), false));
			
		} catch (IOException e) {
			System.out.println("[Loader] : Can't load tiles / file not found");
			e.printStackTrace();
		}
		
		// OBJECT
		try {
			Resource.OBJECT.add(new ObjectData(ImageIO.read(getClass().getResourceAsStream("/objects/blank.png")), "blank", 1, 1, false, new Rectangle(0, 0, 64, 64)));
			
			BufferedImage gems = ImageIO.read(getClass().getResourceAsStream("/objects/gems.png"));
			Resource.OBJECT.add(new ObjectData(gems.getSubimage(0, 0, 16, 16), "gems_1", 1, 1, true, new Rectangle(0, 0, 64, 64)));
			Resource.OBJECT.add(new ObjectData(gems.getSubimage(16, 0, 16, 16), "gems_2", 1, 1, true, new Rectangle(0, 0, 64, 64)));
			Resource.OBJECT.add(new ObjectData(gems.getSubimage(32, 0, 16, 16), "gems_10", 1, 1, true, new Rectangle(0, 0, 64, 64)));
			Resource.OBJECT.add(new ObjectData(gems.getSubimage(48, 0, 16, 16), "gems_25", 1, 1, true, new Rectangle(0, 0, 64, 64)));
			Resource.OBJECT.add(new ObjectData(gems.getSubimage(64, 0, 16, 16), "coin", 1, 1, true, new Rectangle(0, 0, 64, 64)));
			
			
			Resource.OBJECT.add(new ObjectData(ImageIO.read(getClass().getResourceAsStream("/objects/tree_1.png")), "tree_1", 3, 5, true, new Rectangle(64, 256, 64, 64)));
			Resource.OBJECT.add(new ObjectData(ImageIO.read(getClass().getResourceAsStream("/objects/tree_2.png")), "tree_2", 6 , 7, true, new Rectangle(64, 256, 64, 64)));
			Resource.OBJECT.add(new ObjectData(ImageIO.read(getClass().getResourceAsStream("/objects/tree_3.png")), "tree_3", 3, 5, true, new Rectangle(64, 256, 64, 64)));

			Resource.OBJECT.add(new ObjectData(ImageIO.read(getClass().getResourceAsStream("/objects/grave.png")), "grave", 2, 3, true, new Rectangle(0, 16, 96, 96)));
			Resource.OBJECT.add(new ObjectData(ImageIO.read(getClass().getResourceAsStream("/objects/satay.png")), "satay", 2, 1, true, new Rectangle(0, 0, 64, 64)));
			Resource.OBJECT.add(new ObjectData(ImageIO.read(getClass().getResourceAsStream("/objects/chest.png")), "chest", 1, 1, true, new Rectangle(0, 0, 64, 64)));
			
			Resource.OBJECT.add(new ObjectData(ImageIO.read(getClass().getResourceAsStream("/objects/fence.png")), "fence", 4, 3, true, new Rectangle(0, 128, 256, 64)));
			Resource.OBJECT.add(new ObjectData(ImageIO.read(getClass().getResourceAsStream("/objects/fenceright.png")), "fence_r", 4, 3, true, new Rectangle(0, 128, 256, 64)));
			Resource.OBJECT.add(new ObjectData(ImageIO.read(getClass().getResourceAsStream("/objects/fenceleft.png")), "fence_l", 4, 3, true, new Rectangle(0, 128, 256, 64)));
			Resource.OBJECT.add(new ObjectData(ImageIO.read(getClass().getResourceAsStream("/objects/fencerl.png")), "fence_rl", 1, 1, true, new Rectangle(0, 0, 6, 16))); 
			
		} catch (IOException e) {
			System.out.println("[Loader] : Can't load objects / file not found");
			e.printStackTrace();
		}
				
		// SPRITE
		try {
			//pendeta
			Resource.SPRITE.add(Resource.PENDETA_L,ImageIO.read(getClass().getResourceAsStream("/player/pendeta_left1.png")));
			Resource.SPRITE.add(Resource.PENDETA_L_1,ImageIO.read(getClass().getResourceAsStream("/player/pendeta_left2.png")));
			Resource.SPRITE.add(Resource.PENDETA_L_2,ImageIO.read(getClass().getResourceAsStream("/player/pendeta_left3.png")));
			Resource.SPRITE.add(Resource.PENDETA_R,ImageIO.read(getClass().getResourceAsStream("/player/pendeta_right1.png")));
			Resource.SPRITE.add(Resource.PENDETA_R_1,ImageIO.read(getClass().getResourceAsStream("/player/pendeta_right2.png")));
			Resource.SPRITE.add(Resource.PENDETA_R_2,ImageIO.read(getClass().getResourceAsStream("/player/pendeta_right3.png")));
			//ustadz
			Resource.SPRITE.add(Resource.USTADZ_L,ImageIO.read(getClass().getResourceAsStream("/player/ustadi_left1.png")));
			Resource.SPRITE.add(Resource.USTADZ_L_1,ImageIO.read(getClass().getResourceAsStream("/player/ustadi_left2.png")));
			Resource.SPRITE.add(Resource.USTADZ_L_2,ImageIO.read(getClass().getResourceAsStream("/player/ustadi_left3.png")));
			Resource.SPRITE.add(Resource.USTADZ_R,ImageIO.read(getClass().getResourceAsStream("/player/ustadi_right1.png")));
			Resource.SPRITE.add(Resource.USTADZ_R_1,ImageIO.read(getClass().getResourceAsStream("/player/ustadi_right2.png")));
			Resource.SPRITE.add(Resource.USTADZ_R_2,ImageIO.read(getClass().getResourceAsStream("/player/ustadi_right3.png")));
			//penjaga kuburan
			Resource.SPRITE.add(Resource.PENJAGAKUBURAN_L,ImageIO.read(getClass().getResourceAsStream("/player/tukanggali_left1.png")));
			Resource.SPRITE.add(Resource.PENJAGAKUBURAN_L_1,ImageIO.read(getClass().getResourceAsStream("/player/tukanggali_left2.png")));
			Resource.SPRITE.add(Resource.PENJAGAKUBURAN_L_2,ImageIO.read(getClass().getResourceAsStream("/player/tukanggali_left3.png")));
			Resource.SPRITE.add(Resource.PENJAGAKUBURAN_R,ImageIO.read(getClass().getResourceAsStream("/player/tukanggali_right1.png")));
			Resource.SPRITE.add(Resource.PENJAGAKUBURAN_R_1,ImageIO.read(getClass().getResourceAsStream("/player/tukanggali_right2.png")));
			Resource.SPRITE.add(Resource.PENJAGAKUBURAN_R_2,ImageIO.read(getClass().getResourceAsStream("/player/tukanggali_right3.png")));
			//tukang sate
			Resource.SPRITE.add(Resource.TUKANGSATE_L,ImageIO.read(getClass().getResourceAsStream("/player/sate_left1.png")));
			Resource.SPRITE.add(Resource.TUKANGSATE_L_1,ImageIO.read(getClass().getResourceAsStream("/player/sate_left2.png")));
			Resource.SPRITE.add(Resource.TUKANGSATE_L_2,ImageIO.read(getClass().getResourceAsStream("/player/sate_left3.png")));
			Resource.SPRITE.add(Resource.TUKANGSATE_R,ImageIO.read(getClass().getResourceAsStream("/player/sate_right1.png")));
			Resource.SPRITE.add(Resource.TUKANGSATE_R_1,ImageIO.read(getClass().getResourceAsStream("/player/sate_right2.png")));
			Resource.SPRITE.add(Resource.TUKANGSATE_R_2,ImageIO.read(getClass().getResourceAsStream("/player/sate_right3.png")));
			
		} catch (IOException e) {
			System.out.println("[Loader] : Can't load sprites / file not found");
			e.printStackTrace();
		}
		
		//SOUND
		Resource.SOUND.add(getClass().getResource("/sound/main_menu.wav"));
		Resource.SOUND.add(getClass().getResource("/sound/bgm.wav"));
		Resource.SOUND.add(getClass().getResource("/sound/powerup.wav"));
		Resource.SOUND.add(getClass().getResource("/sound/coin.wav"));

		//FONT
		try {
		Resource.FONT.add(Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf")) );
		Resource.FONT.add(Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/font/Thorletto.ttf")) );
		}catch (FontFormatException e) {
			e.printStackTrace();
		}catch (IOException e) {
			System.out.println("[Loader] : Can't load sprites / file not found");
			e.printStackTrace();
		} 	
	}
}
