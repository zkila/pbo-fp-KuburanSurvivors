package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import objects.Object;
import objects.ObjectManager;
import resource.Loader;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
	
	//load file
	Loader loader = new Loader();
	
	//screen setting
	final int originalTileSize = 16; // 16 x 16 px tiles
	final int scale = 4;
	
	public final int tileSize = originalTileSize * scale; //64 x 64 px tiles
	public final int maxScreenColumn = 16; //baris
	public final int maxScreenRow = 12; // kolom
	public final int screenWidth = tileSize * maxScreenColumn; // 1024 px
	public final int screenHeight = tileSize * maxScreenRow; // 768 px
	
	//World Setting
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;
	
	//FPS
	int FPS = 60;
	
	//system
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler(this);
	Sound sound = new Sound();
	Sound se = new Sound();
	//public CollisionChecker colCheck = new CollisionChecker(this);
	
	public ObjectManager objectM = new ObjectManager(this);
	//public AssetSetter aSetter = new AssetSetter(this); 
	public UI ui = new UI(this);
	Thread gameThread;
	
	//entity and object
	public Player player = new Player(this, keyH);
	//public Object obj[]= new Object[10];

	//Game State
	public int gameState;
	public final int titleState = 0;
	public final int playState = 1;  
	public final int pauseState = 2;
	
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		this.loader.load();
	}
	
	public void setupGame() {
		//aSetter.setObject();
		playSound(0); 
		gameState = titleState;
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
				//System.out.println("FPS : " + drawCounter);
				drawCounter = 0;
				timer = 0;
			}
		}
	  
	}
	
	public void update() {
		if(gameState == playState) {
			player.update();
		}
				
		if(gameState == pauseState) {
			//nothing happen
		}
		
		
	}
	  
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		//title screen
		if(gameState == titleState) {
			ui.draw(g2);
		}
		else {
			//tile
			tileM.draw(g2);
			
			//object
			objectM.draw(g2);
			
//			for(int i = 0; i < obj.length ; i++ ) {
//				if (obj[i] != null) {
//					obj[i].draw(g2, this);
//				}
//			}
			
			//player
			player.draw(g2);
			
			//UI
			ui.draw(g2);
		}
		
		
		g2.dispose();
	}
	
	public void playSound(int i) {
		
		sound.setFile(i);
		sound.play();
		sound.loop();
	}
	
	public void stopSound() {
		sound.stop();
	}
	
	public void playSE(int i) {
		se.setFile(i);
		se.play();
	}
}
