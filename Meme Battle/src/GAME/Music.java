package GAME;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music {
	public void play(){
		String FilePath="G:\\Java World!\\Meme Battle\\source material\\Music";
		try{
			File file = new File(FilePath+"\\松田彬人 - わるだくみ [高质量].wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);  
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			while(true)
			clip.loop(Clip.LOOP_CONTINUOUSLY);//循环播放 其他 可用方法有start()和stop()
			//Thread.sleep(10000);//无法循环播放，由sleep内的时间决定了
			} catch (UnsupportedAudioFileException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        } catch (LineUnavailableException e) {  
	            e.printStackTrace();  
	        }
	}
}
