package EasyWasy;

import java.io.*;

import sun.audio.*;


public class Sound {
	
	private boolean keepBeeping;
	public Sound() {
//		super();
		keepBeeping = true;
		System.out.println("her er jeg i constructor");
	}
	
	public void fireSound() throws InterruptedException{
		System.out.println("her er jeg fireSound()");
		while  {
			System.out.println("her er jeg i while");
			java.awt.Toolkit.getDefaultToolkit().beep();
			Thread.sleep(3000);
		}
	}
	
//	public static void main(String[] args) throws Exception{
//		// open the sound file as a Java input stream
//		String gongFile = "C:\\Users\\Ole\\Downloads\\car-beeping-1.wav";
//		InputStream in = new FileInputStream(gongFile);
//
//		// create an audiostream from the inputstream
//		AudioStream audioStream = new AudioStream(in);
//
//
//		// play the audio clip with the audioplayer class
//		AudioPlayer.player.start(audioStream);
//
//			}
}