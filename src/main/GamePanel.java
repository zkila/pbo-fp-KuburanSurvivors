package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import objects.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
	
	//screen setting
	
	final int originalTileSize = 16; // 16 x 16 px tiles
	final int scale = 4;
	
	public final int tileSize = originalTileSize * scale; //48 x 48 px tiles
	public final int maxScreenColumn = 16; //baris
	public final int maxScreenRow = 12; // kolom
	public final int screenWidth = tileSize * maxScreenColumn; // 768 px
	public final int screenHeight = tileSize * maxScreenRow; // 576 px
	
	//World Setting
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;
	
	//FPS
	int FPS = 60;
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	public CollisionChecker colCheck = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this); 
	public Player player = new Player(this, keyH);
	public SuperObject obj[]= new SuperObject[10];

	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.WHITE);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void setupGame() {
		aSetter.setObject();
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
//	public void run() {
//		
//		double drawInterval = 1000000000/FPS;
//		double nextDrawTime = System.nanoTime() + drawInterval;
//		
//		while(gameThread != null) {
//			  
//			  long currentTime = System.nanoTime(); 
//			  System.out.println("current time : " + currentTime);
//			  
//			  //1. Update : update informasi termasuk posisi dari character
//			  update();
//			  //2. Draw : draw the screen with the update information 
//			  repaint();
//			  
//			  
//			  try {
//				  double remainingTime = nextDrawTime - System.nanoTime();
//				  remainingTime /= 1000000;  
//				  
//				  if(remainingTime < 0) {
//					  remainingTime = 0;    
//				  }
//				  
//				  Thread.sleep((long)remainingTime);
//				  
//				  nextDrawTime += drawInterval;
//			  } 
//			  catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
	
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		long timer = 0;
		int drawCounter = 0;
		
		
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >= 1 ) {
				update();
				repaint();
				delta--;
				drawCounter++;
			}
			
			if(timer >= 1000000000) {
				System.out.println("FPS : " + drawCounter);
				drawCounter = 0;
				timer = 0;
			}
		}
	  
	}
	
	public void update() {
		player.update();
		
	}
	  
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		
		tileM.draw(g2);
		
		for(int i = 0; i < obj.length ; i++ ) {
			if (obj[i] != null) obj[i].draw(g2, this);
		}
		player.draw(g2);
		
		g2.dispose();
	}
}
