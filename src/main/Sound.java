package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	Clip clip;
	URL soundurl[] = new URL[30];
	
	public Sound() {
		soundurl[0] = getClass().getResource("/sound/BlueBoyAdventure.wav");
		
		soundurl[1] = getClass().getResource("/sound/coin.wav");
		soundurl[2] = getClass().getResource("/sound/fanfare.wav");
		soundurl[3] = getClass().getResource("/sound/powerup.wav");
		soundurl[4] = getClass().getResource("/sound/unlock.wav");
		soundurl[5] = getClass().getResource("/sound/robloxoof.wav");
		soundurl[6] = getClass().getResource("/sound/drinksfx.wav");
		soundurl[7] = getClass().getResource("/sound/slime_hurt.wav");
		soundurl[8] = getClass().getResource("/sound/swordswing.wav");
	}
	
	public void setFile(int i) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundurl[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void play() {
		clip.start();
	}
	
	public void stop() {
		clip.stop();
	}
	
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
}
