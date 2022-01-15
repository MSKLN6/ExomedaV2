package be.fiiw.exomeda;

import java.util.TimerTask;

/**
 *
 * @author u0143348
 */
public class GameLoop extends TimerTask {

    private ExomedaFXMLController controller;
    
    public static int DELTA_TIME = 2; // time in ms between ticks. 33 for ~30FPS, 16 for ~60FPS 
    
    public GameLoop(ExomedaFXMLController controller) {
        this.controller = controller;
    }
    
    @Override
    public void run() {
        this.controller.update();
    }
}
