package resourceloader;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import tile.Tile;
import tile.TileManager;

public class loader {
	GamePanel gp;
	TileManager tilem;
	public loader(GamePanel gp, TileManager tilem) {
		this.gp = gp;
		this.tilem = tilem;
	}
	
	public void load() {
		//gui
		
		//tiles
		try {
			int size = 16;
			BufferedImage tilesheet = ImageIO.read(getClass().getResourceAsStream("/tiles/tilesset-export.png"));
			resource.TILE.add(tilem.secondsetup(tilesheet.getSubimage(size*0, size*0, size, size), false));
			resource.TILE.add(tilem.secondsetup(tilesheet.getSubimage(size*1, size*0, size, size), false));
			resource.TILE.add(tilem.secondsetup(tilesheet.getSubimage(size*2, size*0, size, size), false));
			resource.TILE.add(tilem.secondsetup(tilesheet.getSubimage(size*3, size*0, size, size), false));
			resource.TILE.add(tilem.secondsetup(tilesheet.getSubimage(size*4, size*0, size, size), false));
			resource.TILE.add(tilem.secondsetup(tilesheet.getSubimage(size*5, size*0, size, size), false));
			resource.TILE.add(tilem.secondsetup(tilesheet.getSubimage(size*6, size*0, size, size), false));
			resource.TILE.add(tilem.secondsetup(tilesheet.getSubimage(size*7, size*0, size, size), false));
			resource.TILE.add(tilem.secondsetup(tilesheet.getSubimage(size*8, size*0, size, size), false));
			
			resource.TILE.add(tilem.secondsetup(tilesheet.getSubimage(size*0, size*1, size, size), false));
			resource.TILE.add(tilem.secondsetup(tilesheet.getSubimage(size*1, size*1, size, size), false));
			resource.TILE.add(tilem.secondsetup(tilesheet.getSubimage(size*2, size*1, size, size), false));
			resource.TILE.add(tilem.secondsetup(tilesheet.getSubimage(size*3, size*1, size, size), false));
			resource.TILE.add(tilem.secondsetup(tilesheet.getSubimage(size*4, size*1, size, size), false));
			resource.TILE.add(tilem.secondsetup(tilesheet.getSubimage(size*5, size*1, size, size), false));
			resource.TILE.add(tilem.secondsetup(tilesheet.getSubimage(size*6, size*1, size, size), false));
			resource.TILE.add(tilem.secondsetup(tilesheet.getSubimage(size*7, size*1, size, size), false));
			resource.TILE.add(tilem.secondsetup(tilesheet.getSubimage(size*8, size*1, size, size), false));
			
			resource.TILE.add(tilem.secondsetup(tilesheet.getSubimage(size*0, size*2, size, size), false));
			resource.TILE.add(tilem.secondsetup(tilesheet.getSubimage(size*1, size*2, size, size), false));
			resource.TILE.add(tilem.secondsetup(tilesheet.getSubimage(size*2, size*2, size, size), false));
			resource.TILE.add(tilem.secondsetup(tilesheet.getSubimage(size*3, size*2, size, size), false));
			resource.TILE.add(tilem.secondsetup(tilesheet.getSubimage(size*4, size*2, size, size), false));
			resource.TILE.add(tilem.secondsetup(tilesheet.getSubimage(size*5, size*2, size, size), false));
			resource.TILE.add(tilem.secondsetup(tilesheet.getSubimage(size*6, size*2, size, size), false));
			resource.TILE.add(tilem.secondsetup(tilesheet.getSubimage(size*7, size*2, size, size), false));
			resource.TILE.add(tilem.secondsetup(tilesheet.getSubimage(size*8, size*2, size, size), false));
		} catch (IOException e) {
			System.out.println("[Loader] : Can't load tiles / file not found");
			e.printStackTrace();
		}
		
		//object
		
		//player
		try {
			//pendeta
			resource.SPRITE.add(resource.PENDETA_L,ImageIO.read(getClass().getResourceAsStream("/player/pendeta_left1.png")));
			resource.SPRITE.add(resource.PENDETA_L_1,ImageIO.read(getClass().getResourceAsStream("/player/pendeta_left2.png")));
			resource.SPRITE.add(resource.PENDETA_L_2,ImageIO.read(getClass().getResourceAsStream("/player/pendeta_left3.png")));
			resource.SPRITE.add(resource.PENDETA_R,ImageIO.read(getClass().getResourceAsStream("/player/pendeta_right1.png")));
			resource.SPRITE.add(resource.PENDETA_R_1,ImageIO.read(getClass().getResourceAsStream("/player/pendeta_right2.png")));
			resource.SPRITE.add(resource.PENDETA_R_2,ImageIO.read(getClass().getResourceAsStream("/player/pendeta_right3.png")));
			//ustadz
			resource.SPRITE.add(resource.USTADZ_L,ImageIO.read(getClass().getResourceAsStream("/player/ustadi_left1.png")));
			resource.SPRITE.add(resource.USTADZ_L_1,ImageIO.read(getClass().getResourceAsStream("/player/ustadi_left2.png")));
			resource.SPRITE.add(resource.USTADZ_L_2,ImageIO.read(getClass().getResourceAsStream("/player/ustadi_left3.png")));
			resource.SPRITE.add(resource.USTADZ_R,ImageIO.read(getClass().getResourceAsStream("/player/ustadi_right1.png")));
			resource.SPRITE.add(resource.USTADZ_R_1,ImageIO.read(getClass().getResourceAsStream("/player/ustadi_right2.png")));
			resource.SPRITE.add(resource.USTADZ_R_2,ImageIO.read(getClass().getResourceAsStream("/player/ustadi_right3.png")));
			//penjaga kuburan
			resource.SPRITE.add(resource.PENJAGAKUBURAN_L,ImageIO.read(getClass().getResourceAsStream("/player/tukanggali_left1.png")));
			resource.SPRITE.add(resource.PENJAGAKUBURAN_L_1,ImageIO.read(getClass().getResourceAsStream("/player/tukanggali_left2.png")));
			resource.SPRITE.add(resource.PENJAGAKUBURAN_L_2,ImageIO.read(getClass().getResourceAsStream("/player/tukanggali_left3.png")));
			resource.SPRITE.add(resource.PENJAGAKUBURAN_R,ImageIO.read(getClass().getResourceAsStream("/player/tukanggali_right1.png")));
			resource.SPRITE.add(resource.PENJAGAKUBURAN_R_1,ImageIO.read(getClass().getResourceAsStream("/player/tukanggali_right2.png")));
			resource.SPRITE.add(resource.PENJAGAKUBURAN_R_2,ImageIO.read(getClass().getResourceAsStream("/player/tukanggali_right3.png")));
			//tukang sate
			resource.SPRITE.add(resource.TUKANGSATE_L,ImageIO.read(getClass().getResourceAsStream("/player/sate_left1.png")));
			resource.SPRITE.add(resource.TUKANGSATE_L_1,ImageIO.read(getClass().getResourceAsStream("/player/sate_left2.png")));
			resource.SPRITE.add(resource.TUKANGSATE_L_2,ImageIO.read(getClass().getResourceAsStream("/player/sate_left3.png")));
			resource.SPRITE.add(resource.TUKANGSATE_R,ImageIO.read(getClass().getResourceAsStream("/player/sate_right1.png")));
			resource.SPRITE.add(resource.TUKANGSATE_R_1,ImageIO.read(getClass().getResourceAsStream("/player/sate_right2.png")));
			resource.SPRITE.add(resource.TUKANGSATE_R_2,ImageIO.read(getClass().getResourceAsStream("/player/sate_right3.png")));
			
		} catch (IOException e) {
			System.out.println("[Loader] : Can't load sprites / file not found");
			e.printStackTrace();
		}
		//attack sfx
		try {
			resource.ATTACK.add(resource.PENJAGAKUBURAN_L_attack_1,ImageIO.read(getClass().getResourceAsStream("/player/tukanggali_left_attack_1.png")));
			resource.ATTACK.add(resource.PENJAGAKUBURAN_L_attack_2,ImageIO.read(getClass().getResourceAsStream("/player/tukanggali_left_attack_2.png")));
			resource.ATTACK.add(resource.PENJAGAKUBURAN_L_attack_3,ImageIO.read(getClass().getResourceAsStream("/player/tukanggali_left_attack_3.png")));
			resource.ATTACK.add(resource.PENJAGAKUBURAN_R_attack_1,ImageIO.read(getClass().getResourceAsStream("/player/tukanggali_right_attack_1.png")));
			resource.ATTACK.add(resource.PENJAGAKUBURAN_R_attack_2,ImageIO.read(getClass().getResourceAsStream("/player/tukanggali_right_attack_2.png")));
			resource.ATTACK.add(resource.PENJAGAKUBURAN_R_attack_3,ImageIO.read(getClass().getResourceAsStream("/player/tukanggali_right_attack_3.png")));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//setan
		
		try {
			resource.SPRITE_GHOST.add(resource.KUNTILANAK_L_1,ImageIO.read(getClass().getResourceAsStream("/monsters/kuntilanak_left1.png")));
			resource.SPRITE_GHOST.add(resource.KUNTILANAK_L_2,ImageIO.read(getClass().getResourceAsStream("/monsters/kuntilanak_left2.png")));
			resource.SPRITE_GHOST.add(resource.KUNTILANAK_R_1,ImageIO.read(getClass().getResourceAsStream("/monsters/kuntilanak_right1.png")));
			resource.SPRITE_GHOST.add(resource.KUNTILANAK_R_2,ImageIO.read(getClass().getResourceAsStream("/monsters/kuntilanak_right2.png")));
			
			resource.SPRITE_GHOST.add(resource.POCONG_1,ImageIO.read(getClass().getResourceAsStream("/monsters/pocong_any1.png")));
			resource.SPRITE_GHOST.add(resource.POCONG_2,ImageIO.read(getClass().getResourceAsStream("/monsters/pocong_any2.png")));
			resource.SPRITE_GHOST.add(resource.POCONG_3,ImageIO.read(getClass().getResourceAsStream("/monsters/pocong_any3.png")));
			resource.SPRITE_GHOST.add(resource.POCONG_4,ImageIO.read(getClass().getResourceAsStream("/monsters/pocong_any4.png")));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
