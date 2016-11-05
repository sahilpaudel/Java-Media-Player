
/*
@ author : Sahil Paudel
*/
import java.io.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;

import javafx.util.*;
import java.util.*;

class SongPlayer
{
	
    static void playMP3(String fileName) throws Exception {
		new javafx.embed.swing.JFXPanel();
		String uriString = new File(fileName).toURI().toString();
		Media m = new Media((uriString));
		MediaPlayer mp = new MediaPlayer(m);

		//when mediaPlayer is ready to play or initialized
		mp.setOnReady(new Runnable() {

        @Override
        public void run(){

            /*System.out.println("Duration: "+m.getDuration().toSeconds());
             display media's metadata
            for (Map.Entry<String, Object> entry : m.getMetadata().entrySet()){
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }*/
			//displaying before play
			System.out.println(new File(fileName).getName());
            // play if you want
			mp.play();
			
			try{
				Thread.sleep((long)m.getDuration().toMillis());
			}catch(InterruptedException e){
				e.printStackTrace();
			}
        }
    });
		
	}
	
	public static void main(String args[])
	{	
		Scanner in = new Scanner(System.in);
		String path_to_music_folder = in.nextLine();
		
		File f = new File(path_to_music_folder);
		File[] list = f.listFiles();
		
		for(File fp : list){
			if(fp.isDirectory()==false ){
				
				try{
					playMP3(f.getAbsolutePath()+"\\"+fp.getName());
										
				}catch(Exception e){
					//if not a media file continue to next file
					continue;
				}
				
			}
			
		}
			
	}
}