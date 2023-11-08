package com.mycompany.a3;

import java.io.InputStream;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;

public class BGSound implements Runnable {
    private Media m;

    public BGSound(String fileName) {
        try {
            InputStream is = Display.getInstance().getResourceAsStream(getClass(), "/" + fileName);

            if (is != null) {
                m = MediaManager.createMedia(is, "audio/wav", this);
            } else {
                System.out.println("Audio resource not found: " + fileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error creating media: " + e.getMessage());
         
        }
    }

    public void pause() {
       if (m != null) {
            m.pause();
       }
       
    }

    public void play(boolean b) {
    	  if (b && m != null) {
    	        m.play();
    	    }        
    }

    public void run() {
    	if (m != null) {
            m.setTime(0);
            m.play();
        }
    }
}
