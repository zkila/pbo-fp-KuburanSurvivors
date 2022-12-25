package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import resourceloader.loader;
import tile.TileManager;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable{
	
	// screen settings
	final int originalTileSize = 16; //16x16 tile size
	public final int scale = 3;
	
	public final int tileSize = originalTileSize * scale; // 48x48 tile
	public final int maxScreenCol = 20;
	public final int maxScreenRow = 16;
	public final int screenWidth = tileSize * maxScreenCol; // 768px
	public final int screenHeight = tileSize * maxScreenRow; // 576px
	
	public final int maxWorldCol = 250;
	public final int maxWorldRow = 250;
	public final int worldWidth = tileSize * maxScreenCol;
	public final int worldHeigth = tileSize * maxScreenRow;
	
	int fps = 60;
	
	public KeyHandler keyH = new KeyHandler(this);
	Thread gameThread;
	public Player player = new Player(this, keyH);
	TileManager tileManager = new TileManager(this);
	public CollisionChecker cChecker = new CollisionChecker(this);
	
	public ArrayList<Entity> obj = new ArrayList<Entity>();
	public ArrayList<Entity> npc = new ArrayList<Entity>();
	public ArrayList<Entity> mons = new ArrayList<Entity>();
	
	public ArrayList<Entity> entitylist = new ArrayList<>();
	
	public TileManager tilem = new TileManager(this);
	public assetSetter setter = new assetSetter(this);
	public Sound music = new Sound(), sfx = new Sound();
	public UI ui = new UI(this);
	public EventHandler ehandler = new EventHandler(this);
	public loader loader = new loader(this,tilem);
	
	public boolean checkdrawtime = false;
	
	public int gamestate;
	public final int titlestate = 0,  playstate = 1, pausestate = 2, dialoguestate = 3;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void setupGame() {
		loader.load();
		setter.setobject();
		setter.setnpc();
		setter.setmons();
		//playbgm(0);
		gamestate = titlestate;
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	
public void run() {
		
		double drawInterval = 1000000000/fps;
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
		if(gamestate == playstate) {
			player.update();
			
			for(int i = 0;i < npc.size(); i++) {
				if(npc.get(i) != null)
					npc.get(i).update();
			}
			for(int i = 0;i < mons.size(); i++) {
				if(mons.get(i) != null) {
					if(mons.get(i).alive && !mons.get(i).dying) {
						mons.get(i).update();
					}
					if(!mons.get(i).alive){
						mons.remove(i);
					}
				}
			}
		}
		else if (gamestate == pausestate) {
			
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		long drawstart = 0, drawend = 0, passed = 0;
		
		if(checkdrawtime) drawstart = System.nanoTime();
		
		if(gamestate == titlestate) {
			ui.draw(g2);
		}
		
		else {
			tileManager.draw(g2);
			
			entitylist.add(player);
			
			for(int i = 0; i<npc.size(); i++) {
				if(npc.get(i)!=null) entitylist.add(npc.get(i));
			}
			
			for(int i = 0; i<mons.size(); i++) {
				if(mons.get(i)!=null) {
					entitylist.add(mons.get(i));
				}
			}
			
			for(int i = 0; i<obj.size(); i++) {
				if(obj.get(i)!=null) entitylist.add(obj.get(i));
			}
			
			Collections.sort(entitylist, new Comparator<Entity>() {

				public int compare(Entity e1, Entity e2) {
					int result = Integer.compare(e1.worldY, e2.worldY);
					return result;
				}
			});		
			
			for(int i = 0; i<entitylist.size(); i++) {
				entitylist.get(i).draw(g2);
			}
			entitylist.clear();
			ui.draw(g2);
		}
	
		if (checkdrawtime) {
			drawend = System.nanoTime();
			passed = drawend - drawstart;
			System.out.println("time passed = "+passed);
		}
		g2.dispose();
	}
	
	public void playbgm(int i) {
		music.setFile(i);
		music.play();
		music.loop();
	}
	
	public void stopbgm(int i) {
		music.stop();
	}
	
	public void playsfx(int i) {
		sfx.setFile(i);
		sfx.play();
	}
}
