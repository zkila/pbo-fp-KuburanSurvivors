package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

import entity.Entity;
import object.obj_heart;

public class UI {
	
	Graphics2D g2;
	public Font font;
//	BufferedImage keysimage;
	BufferedImage heartfull, hearthalf, heartblank;
	GamePanel gp;
	public boolean messageon = false;
	public String message = "";
	int messagecounter = 0;
	public boolean gamefinished = false;
	double playtime = 0;
	DecimalFormat format = new DecimalFormat("#0.00");
	Color darktheme = new Color(20,20,20,220);
	Color darkthemee = new Color(50,50,50);
	BasicStroke stroke = new BasicStroke(5);
	public String currentdialogue;
	public int commandnum = 0;
	public int titlescreenstate = 0; // 0: first screen, 1: second screen
	
	public UI (GamePanel gp) {
		this.gp = gp;
		
		try {
			InputStream is = getClass().getResourceAsStream("/fonts/x12y16pxMaruMonica.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	//	obj_key key = new obj_key();
	//	keysimage = key.image;
		Entity heart = new obj_heart(gp);
		heartfull = heart.image1;
		hearthalf = heart.image2;
		heartblank = heart.image3;
	}
	
	public void showmessage(String text) {
		this.message = text;
		messageon = true;
	}
	
	public void draw(Graphics2D g2) {
		this.g2 = g2;
		
		g2.setColor(Color.white);
		g2.setFont(font);
		//g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(gp.gamestate == gp.titlestate) {
			drawtitlescreen();
		}
		else if(gp.gamestate == gp.playstate) {
			drawplayerlife();
		}
		else if(gp.gamestate == gp.pausestate) {
			drawplayerlife();
			drawpausescreen();
		}
		else if (gp.gamestate == gp.dialoguestate) {
			drawplayerlife();
			drawdialoguescreen();
		}
		
		
//		if(gamefinished) {
//			g2.setFont(keysfont.deriveFont(50F));
//			FontMetrics metrics1 = g2.getFontMetrics(g2.getFont());
//			g2.setColor(Color.white);
//			g2.drawString("Finished the Game!", (int)(gp.screenWidth - metrics1.stringWidth("Finished the Game!"))/2 , gp.screenHeight/2 - gp.tileSize*3);
//			
//
//			g2.setFont(keysfont.deriveFont(40F));
//			FontMetrics metrics2 = g2.getFontMetrics(g2.getFont());
//			g2.setColor(Color.yellow);
//			g2.drawString("Your time was: " + format.format(playtime), (int)(gp.screenWidth - metrics2.stringWidth("Your time was: " + format.format(playtime)))/2 , gp.screenHeight/2 + gp.tileSize*3);
//		}
//		else {
//			g2.drawImage(keysimage, gp.screenWidth/2-30, 10, 24, 24, null);
//			g2.setColor(Color.white);
//			g2.setFont(keysfont);
//			FontMetrics metrics = g2.getFontMetrics(keysfont);
//			g2.drawString("  = "+gp.player.hasKey, (int)(gp.screenWidth - metrics.stringWidth("  = "))/2, 30);
//			
//			playtime += (double)1/60;
//			
//			g2.setColor(Color.white);
//			g2.setFont(keysfont);
//			g2.drawString("Time : "+(int)playtime, (int)(gp.screenWidth - metrics.stringWidth("Time : "+(int)playtime))/2, gp.screenHeight - 30);
//			
//			if (messageon) {
//				g2.setFont(keysfont);
//				g2.setColor(Color.white);
//				g2.drawString(message, (int)(gp.screenWidth - metrics.stringWidth(message))/2 , 50);
//				messagecounter++;
//				
//				if(messagecounter > 120) {
//					messagecounter = 0;
//					messageon = false;
//				}
//				
//				
//			}
//		}
		
	}
	
	public void drawtitlescreen() {
		
		if(titlescreenstate==0) {
			g2.setFont(font.deriveFont(Font.BOLD,100F));
			String text = "Kuburan Survivors";
			int x = getxforcenteredtext(text);
			int y = gp.tileSize*3;
			
			g2.setColor(darkthemee);
			g2.drawString(text, x+3, y+5);
			g2.setColor(Color.white);
			g2.drawString(text, x, y);
			
			x = gp.screenWidth/2 - (gp.tileSize*2)/2;
			y += gp.tileSize*2;
			g2.drawImage(gp.player.down1, x, y, gp.tileSize*2, gp.tileSize*2, null);
			
			g2.setFont(font.deriveFont(Font.ITALIC,50F));
			
			text = "New Game";
			x = getxforcenteredtext(text);
			y += gp.tileSize*3.5;
			g2.drawString(text, x, y);
			if(commandnum == 0) {
				g2.drawString(">", x-gp.tileSize, y);
			}
			
			text = "Settings";
			x = getxforcenteredtext(text);
			y += gp.tileSize;
			g2.drawString(text, x, y);
			if(commandnum == 1) {
				g2.drawString(">", x-gp.tileSize, y);
			}
			
			text = "Quit";
			x = getxforcenteredtext(text);
			y += gp.tileSize;
			g2.drawString(text, x, y);
			if(commandnum == 2) {
				g2.drawString(">", x-gp.tileSize, y);
			}
		}
		else if (titlescreenstate == 1) {
			
			String text = "Select Your Character";
			g2.setFont(font.deriveFont(Font.BOLD,40F));
			int x = getxforcenteredtext(text);
			int y = gp.tileSize*3;
			
			g2.setColor(Color.white);
			g2.drawString(text, x, y);
			
			g2.setFont(font.deriveFont(Font.PLAIN,40F));
			text = "Pendeta";
			x = getxforcenteredtext(text);
			y += gp.tileSize*3;
			g2.drawString(text, x, y);
			if(commandnum==0) {
				g2.drawString(">", x-gp.tileSize, y);
			}
			
			text = "Ustadz";
			x = getxforcenteredtext(text);
			y += gp.tileSize*1;
			g2.drawString(text, x, y);
			if(commandnum==1) {
				g2.drawString(">", x-gp.tileSize, y);
			}
	
			text = "Penjaga Kuburan";
			x = getxforcenteredtext(text);
			y += gp.tileSize*1;
			g2.drawString(text, x, y);
			if(commandnum==2) {
				g2.drawString(">", x-gp.tileSize, y);
			}
			
			text = "Kang Sate";
			x = getxforcenteredtext(text);
			y += gp.tileSize*1;
			g2.drawString(text, x, y);
			if(commandnum==3) {
				g2.drawString(">", x-gp.tileSize, y);
			}
			
			g2.setFont(font.deriveFont(30F));
			text = "Back";
			x = getxforcenteredtext(text);
			y += gp.tileSize*2;
			g2.drawString(text, x, y);
			if(commandnum==4) {
				g2.drawString(">", x-gp.tileSize, y);
			}
	
		}
		
	}
	
	public void drawplayerlife() {
		int x = gp.player.screenX + gp.tileSize/2;
		int y = gp.player.screenY;
		int length = gp.tileSize*2;
		int width = 10;
		double oneScale = (double)length/gp.player.maxlife;
		double hpbarvalue = oneScale*gp.player.life;
		
		gp.player.changealpha(g2, 0.5f);
		g2.setColor(Color.BLACK);
		g2.fillRect(x-2, y-2, length+4, width+4);
		//g2.fillRoundRect(gp.player.screenX-2, gp.player.screenY - 17, gp.tileSize+4, 10+4,4,4);
		
		gp.player.changealpha(g2, 1f);
		g2.setColor(gp.player.healthbar);
		g2.fillRect(x, y, (int)hpbarvalue, width);
		
		
//		int x = gp.tileSize/2;
//		int y = gp.tileSize/2;
//		int i = 0;
//		//draw maxlife
//		while (i < gp.player.maxlife/2) {
//			g2.drawImage(heartblank, x, y, null);
//			i++;
//			x += gp.tileSize; 
//		}
//		//reset
//		x = gp.tileSize/2;
//		y = gp.tileSize/2;
//		i = 0;
//		//draw current life
//		while (i < gp.player.life) {
//			g2.drawImage(hearthalf, x, y, null);
//			i++;
//			if(i < gp.player.life) g2.drawImage(heartfull, x, y, null);
//			i++;
//			x += gp.tileSize; 
//		}
	}
	
	public void drawpausescreen() {
		String text = "Paused";
		g2.setFont(font.deriveFont(70F));
		int x = getxforcenteredtext(text);
		int y = gp.screenHeight/2;
		g2.drawString(text, x, y);
	}
	
	public void drawdialoguescreen() {
		int x = gp.tileSize*2;	
		int y = gp.tileSize/2; 
		int width = gp.screenWidth-(gp.tileSize*4); 
		int height = gp.tileSize*4;
		g2.setFont(font.deriveFont(30F));
		
		drawsubwindow(x, y, width, height);
		
		x += gp.tileSize-5;
		y += gp.tileSize;
		
		for(String line:currentdialogue.split("\n")) {
			g2.drawString(line, x, y);
			y += 40;
		}
	}
	
	public void drawsubwindow(int x, int y,int width,int height) {
		
		g2.setColor(darktheme);
		g2.fillRoundRect(x, y, width, height, 35, 35);
		
		g2.setColor(Color.white);
		g2.setStroke(stroke);
		g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
	}
	
	public int getxforcenteredtext(String text) {
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth/2 - length/2;
		return x;
	}
}
