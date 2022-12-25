package entity;


import java.util.Random;



import main.GamePanel;


public class npc_oldman extends Entity {
	
	public npc_oldman(GamePanel gp) {
		super(gp);
		direction = "down";
		speed = 1;
		getImage();
		setDialogue();
		
		solidArea.x = 0;
		solidArea.y = 16;
		solidArea.width = 48;
		solidArea.height = 32;
		solidareadefaultx = solidArea.x;
		solidareadefaulty = solidArea.y;
	}
	
	public void getImage() {
		
		up1 = setup("/npc/oldman_up_1",gp.tileSize,gp.tileSize);
		up2 = setup("/npc/oldman_up_2",gp.tileSize,gp.tileSize);
		down1 = setup("/npc/oldman_down_1",gp.tileSize,gp.tileSize);
		down2 = setup("/npc/oldman_down_2",gp.tileSize,gp.tileSize);
		right1 = setup("/npc/oldman_right_1",gp.tileSize,gp.tileSize);
		right2 = setup("/npc/oldman_right_2",gp.tileSize,gp.tileSize);
		left1 = setup("/npc/oldman_left_1",gp.tileSize,gp.tileSize);
		left2 = setup("/npc/oldman_left_2",gp.tileSize,gp.tileSize);
	}
	
	public void setAction() {
		
		actionlockcounter++;
		
		if(actionlockcounter == 120) {
			Random random = new Random();
			int i = random.nextInt(100)+1; //pick a random number from 1 - 100
			if(i <= 25) {
				direction = "up";
			}
			else if (i>25 && i<=50) {
				direction ="down";
			}
			else if (i>50 && i<=75) {
				direction ="left";
			}
			else if (i>75 && i<=100) {
				direction ="right";
			}
			
			actionlockcounter = 0;
		}
	}
	
	public void setDialogue() {
		dialogues.add("Hello young one...");
		dialogues.add("Let me tell you something of great importance... \nthat im basically rambling right now you could read this \nwhy would you read this");
		dialogues.add("It is imperative that you...");
		dialogues.add("That you go west...");
	}
	
	public void speak() {
		super.speak();
	}
	
}
