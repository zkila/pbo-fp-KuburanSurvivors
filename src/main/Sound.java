package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import resource.Resource;

public class Sound {
	Clip clip;
	
	public void setFile(int i) {
		
		try {
			AudioInputStream ai = AudioSystem.getAudioInputStream(Resource.SOUND.get(i));
			clip = AudioSystem.getClip();
			clip.open(ai);
		}catch(Exception e) {
			
		}
	}
	
	public void play() {
		
		clip.start();
	}
	
	public void loop() {
		clip.loop(clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop() {
		clip.stop();
	}
}

