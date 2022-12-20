package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DecimalFormat;

import resource.Resource;

public class UI {
	GamePanel gp;
	Graphics2D g2;
	public int commandNum = 0;
	public int titleScreenState = 0;// 0 for the first screen / 1 for the second screen
	
	public UI(GamePanel gp) {
		this.gp = gp;
	}
	
	public void draw(Graphics2D g2) {		
		this.g2 = g2; 
		
		//title state
		if(gp.gameState ==  gp.titleState) {
			drawTitleScreen();
		}
		
		//play state
		if(gp.gameState == gp.playState) {
			// Do playState stuff later
		}
		//pause state
		if(gp.gameState == gp.pauseState) {
			drawPauseScreen();
		}
	}

	public void drawTitleScreen() {
		
		if (titleScreenState == 0) {
			//background
			g2.drawImage(Resource.GUI.get(0), 0, 0, gp.screenWidth, gp.screenHeight, null);
			
			//menu
			g2.setFont(Resource.FONT.get(1));
			g2.setFont(g2.getFont().deriveFont(Font.BOLD, 28F));
			
			g2.setColor(Color.BLACK);
			String text = "MULAI";
			int x = getXForCenteredText(text);
			int y = gp.tileSize*15/2;
			g2.drawString(text, x+5, y+5);
			g2.setColor(Color.red);
			g2.drawString(text, x, y);
			if(commandNum == 0) {
				g2.setColor(Color.white);
				g2.drawString(text, x, y);
			}
			
			g2.setColor(Color.BLACK);
			text = "PENGATURAN";
			x = getXForCenteredText(text);
			y += gp.tileSize*8/5;
			g2.drawString(text, x+5, y+5);
			g2.setColor(Color.red);
			g2.drawString(text, x, y);
			if(commandNum == 1) {
				g2.setColor(Color.white);
				g2.drawString(text, x, y);
			}
			
			g2.setColor(Color.BLACK);
			text = "KELUAR";
			x = getXForCenteredText(text);
			y += gp.tileSize*8/5;
			g2.drawString(text, x+5, y+5);
			g2.setColor(Color.red);
			g2.drawString(text, x, y);
			if(commandNum == 2) {
				g2.setColor(Color.white);
				g2.drawString(text, x, y);
			}
//			//profil
//			g2.setFont(Resource.FONT.get(0));
//			g2.setFont(g2.getFont().deriveFont(Font.BOLD, 24F));
//			text = "BANGAN";
//			String text1 = "10 Coins";
//			x = gp.tileSize * 4;
//			y = gp.tileSize/8;
//			
//			g2.setColor(Color.GRAY);
//			g2.fillRoundRect(x, y, gp.tileSize*8, gp.tileSize, 90, 90);
//			
//			g2.setColor(Color.black);
//			x += gp.tileSize/2;
//			y += gp.tileSize*3/4;
//			g2.drawString(text, x, y);
//			x += gp.tileSize*4;
//			g2.drawString(text1, x, y);
		}
		else if (titleScreenState == 1) {
			//class selection screen
			g2.drawImage(Resource.GUI.get(1), 0, 0, gp.screenWidth, gp.screenHeight, null);
			
			g2.setFont(Resource.FONT.get(1));
			g2.setFont(g2.getFont().deriveFont(24F));
			
			g2.setColor(Color.BLACK);
			String text = "PENDETA";
			int x = gp.screenWidth*1/5 + 15;
			int y = gp.screenHeight*3/5 + 10;
			g2.drawString(text, x+5, y+5);
			g2.setColor(Color.red);
			g2.drawString(text, x, y);
			if(commandNum == 0) {
				g2.setColor(Color.white);
				g2.drawString(text, x, y);
			}
			
			g2.setColor(Color.BLACK);
			text = "USTADZ";
			x = gp.screenWidth* 3/5 - 15;
			g2.drawString(text, x+5, y+5);
			g2.setColor(Color.red);
			g2.drawString(text, x, y);
			if(commandNum == 1) {
				g2.setColor(Color.white);
				g2.drawString(text, x, y);
			}
			
			g2.setColor(Color.BLACK);
			text =  "Penjaga Kuburan";
			x = gp.screenWidth*1/6 + 15;
			y += gp.tileSize*9/2 - 10;
			g2.drawString(text, x+5, y+5);
			g2.setColor(Color.red);
			g2.drawString(text, x, y);
			if(commandNum == 2) {
				g2.setColor(Color.white);
				g2.drawString(text, x, y);
			}
			
			g2.setColor(Color.BLACK);
			text =  "Kang Sate";
			x = gp.screenWidth*3/5-15;
			g2.drawString(text, x+5, y+5);
			g2.setColor(Color.red);
			g2.drawString(text, x, y);
			if(commandNum == 3) {
				g2.setColor(Color.white);
				g2.drawString(text, x, y);
			}
			
			g2.setFont(g2.getFont().deriveFont(16F));
			g2.setColor(Color.BLACK);
			text = "KEMBALI";
			x = gp.screenWidth *6/7;
			g2.drawString(text, x+5, y+5);
			g2.setColor(Color.red);
			g2.drawString(text, x, y);
			if(commandNum == 4) {
				g2.setColor(Color.white);
				g2.drawString(text, x, y);
			}	
		}
	}

	public void drawPauseScreen() {
		//g2.setColor(Color.white);
		//g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
		g2.setFont(Resource.FONT.get(1));
		g2.setFont(g2.getFont().deriveFont(36F));
		
		String text = "PAUSED";
		
		int x = getXForCenteredText(text);
		int y = gp.screenHeight/2;
		g2.drawString(text, x+5, y+5);
		g2.setColor(Color.red);
		g2.drawString(text, x, y);
		g2.drawString(text, x, y);
		
	}
	
	public int getXForCenteredText(String text) {
		int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth/2 - length/2;
		return x;
	}
	
}
