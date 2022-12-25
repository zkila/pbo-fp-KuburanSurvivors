package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
	public boolean up, down, left, right, enter;
	GamePanel gp;
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(gp.gamestate == gp.titlestate) {
			if(gp.ui.titlescreenstate == 0) {
				
				if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
					gp.ui.commandnum--;
					if(gp.ui.commandnum<0) {
						gp.ui.commandnum = 2;
					}
				}
				if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
					gp.ui.commandnum++;
					if(gp.ui.commandnum>2) {
						gp.ui.commandnum = 0;
					}
				}
				if(code == KeyEvent.VK_ENTER) {
					if(gp.ui.commandnum==0) {
						gp.ui.titlescreenstate = 1; //enter into character selection
					}
					else if(gp.ui.commandnum==1) {
						//settings, not yet implemented
					}
					else if(gp.ui.commandnum==2) {
						System.exit(0); //quit
					}
				}
			}
			else if (gp.ui.titlescreenstate == 1) {
				if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
					gp.ui.commandnum--;
					if(gp.ui.commandnum<0) {
						gp.ui.commandnum = 4;
					}
				}
				if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
					gp.ui.commandnum++;
					if(gp.ui.commandnum>4) {
						gp.ui.commandnum = 0;
					}
				}
				if(code == KeyEvent.VK_ENTER) {
					if(gp.ui.commandnum == 0 || gp.ui.commandnum==1 || gp.ui.commandnum==2 || gp.ui.commandnum==3 ) {
						if(gp.ui.commandnum==0) { gp.player.characternum = 0; } //select pendeta asset 
						else if(gp.ui.commandnum==1) { gp.player.characternum = 6; } //select pendeta asset 
						else if(gp.ui.commandnum==2) { gp.player.characternum = 12; } //select pendeta asset 
						else if(gp.ui.commandnum==3) { gp.player.characternum = 18; } //select pendeta asset 
						gp.gamestate = gp.playstate; //enter into game
					//	gp.playbgm(0);
					}
					else if(gp.ui.commandnum==4) {
						gp.ui.titlescreenstate = 0; //back
					}
				}
			}
		
		}
		
		else if(gp.gamestate == gp.playstate) {
			//if(code == KeyEvent.VK_H) {gp.player.life--;}
			if(code == KeyEvent.VK_W) {up = true;}
			if(code == KeyEvent.VK_A) {left = true;}
			if(code == KeyEvent.VK_S) {down = true;}
			if(code == KeyEvent.VK_D) {right = true;}
			if(code == KeyEvent.VK_TAB) {
				if (gp.checkdrawtime) gp.checkdrawtime = false;
				else if (!gp.checkdrawtime) gp.checkdrawtime = true;
			}
			if(code == KeyEvent.VK_ESCAPE) {gp.gamestate = gp.pausestate;}
			if(code == KeyEvent.VK_ENTER) {enter = true;}
			if(code == KeyEvent.VK_T) {gp.player.worldX+=5*gp.tileSize;}
		}
		
		else if (gp.gamestate == gp.pausestate) {
			if(code == KeyEvent.VK_ESCAPE) gp.gamestate = gp.playstate;
			if(code == KeyEvent.VK_R) {
				gp.gamestate = gp.titlestate;
				gp.ui.titlescreenstate = 0;
		//		gp.music.stop();
			}
		}
		
		else if(gp.gamestate == gp.dialoguestate) {
			if(code == KeyEvent.VK_ESCAPE) gp.gamestate = gp.playstate;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {up = false;}
		if(code == KeyEvent.VK_A) {left = false;}
		if(code == KeyEvent.VK_S) {down = false;}
		if(code == KeyEvent.VK_D) {right = false;}

	}

}
