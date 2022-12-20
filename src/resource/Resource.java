package resource;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;

import objects.ObjectData;
import tile.Tile;

public class Resource {
	
	public static final ArrayList<BufferedImage> GUI = new ArrayList<>();
	public static final ArrayList<Tile> TILE = new ArrayList<>();
	public static final ArrayList<ObjectData> OBJECT = new ArrayList<>();
	public static final ArrayList<BufferedImage> SPRITE = new ArrayList<>();
	public static final ArrayList<BufferedImage> SPRITE_GHOST = new ArrayList<>();
	public static final ArrayList<URL> SOUND = new ArrayList<>();
	public static final ArrayList<Font> FONT = new ArrayList<>();
	
	// GUI
	public static final byte MAINMENU_BG = 0;
	public static final byte SELECTION_SCREEN = 1;
	public static final byte PAUSE_BG = 2;
	
	// TILES
	public static final byte GRASS_TL = 0;
	public static final byte GRASS_TM = 1;
	public static final byte GRASS_TR = 2;
	public static final byte GRASS_ML = 3;
	public static final byte GRASS_MM = 4;
	public static final byte GRASS_MR = 5;
	public static final byte GRASS_DL = 6;
	public static final byte GRASS_DM = 7;
	public static final byte GRASS_DR = 8;
	public static final byte LAND_TL = 9;
	public static final byte LAND_TM = 10;
	public static final byte LAND_TR = 11;
	public static final byte LAND_ML = 12;
	public static final byte LAND_MM = 13;
	public static final byte LAND_MR = 14;
	public static final byte LAND_DL = 15;
	public static final byte LAND_DM = 16;
	public static final byte LAND_DR = 17;
	
	// OBJECT
	public static final byte BLANK = 0;
	public static final byte GEMS_1 = 1;
	public static final byte GEMS_2 = 2;
	public static final byte GEMS_10 = 3;
	public static final byte GEMS_25 = 4;
	public static final byte COIN = 5;
	public static final byte TREE_1 = 6;
	public static final byte TREE_2 = 7;
	public static final byte TREE_3 = 8;
	public static final byte GRAVE = 9;
	public static final byte SATAY = 10;
	public static final byte CHEST = 11;
	public static final byte FENCE = 12;
	public static final byte FENCE_R = 13;
	public static final byte FENCE_L = 14;
	public static final byte FENCE_RL = 15;
	
	// ITEM
	public static final byte TASBIH = 0;
	public static final byte CROSS = 1;
	public static final byte SKEWER = 2;
	public static final byte SHOVEL = 3;
	public static final byte FLOWER = 4;
	public static final byte LANTERN = 5;
	public static final byte PETIS = 6;
	public static final byte PRAY = 7;
	
	// SPRITE
	public static final byte PENDETA_L = 0;
	public static final byte PENDETA_L_1 = 1;
	public static final byte PENDETA_L_2 = 2;
	public static final byte PENDETA_R = 3;
	public static final byte PENDETA_R_1 = 4;
	public static final byte PENDETA_R_2 = 5;
	public static final byte USTADZ_L = 6;
	public static final byte USTADZ_L_1 = 7;
	public static final byte USTADZ_L_2 = 8;
	public static final byte USTADZ_R = 9;
	public static final byte USTADZ_R_1 = 10;
	public static final byte USTADZ_R_2 = 11;
	public static final byte PENJAGAKUBURAN_L = 12;
	public static final byte PENJAGAKUBURAN_L_1 = 13;
	public static final byte PENJAGAKUBURAN_L_2 = 14;
	public static final byte PENJAGAKUBURAN_R = 15;
	public static final byte PENJAGAKUBURAN_R_1 = 16;
	public static final byte PENJAGAKUBURAN_R_2 = 17;
	public static final byte TUKANGSATE_L = 18;
	public static final byte TUKANGSATE_L_1 = 19;
	public static final byte TUKANGSATE_L_2 = 20;
	public static final byte TUKANGSATE_R = 21;
	public static final byte TUKANGSATE_R_1 = 22;
	public static final byte TUKANGSATE_R_2 = 23;
	
	// SOUND
	public static final byte MAINMENU = 0;
	public static final byte MAIN = 1;
	public static final byte COIN_SE = 2;
	public static final byte CHEST_SE = 3;
	public static final byte GEMS_SE = 4;
	
	//FONT
	public static final byte PRESS_START_2P = 0;
	public static final byte Thorletto = 1;
	
}
