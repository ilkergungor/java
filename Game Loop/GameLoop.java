import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JFrame;
import javafx.geometry.Insets;

    public class GameLoop extends JFrame implements MouseListener, MouseMotionListener{

        int framedimensionX = 1280;
        int framedimensionY = 720;

        int x= 10;
        int y = 10;

        java.awt.Insets interior;

        BufferedImage imageBuffer;

        int aimFPS = 60;
        boolean gameContinue = true;

        PhysicsEngine pe = new PhysicsEngine();
        int amountOfBalls = 10;
        
        boolean temporaryCircle = false;
        int temporaryCircleX = 0;
        int temporaryCircleY = 0;
        int temporaryCircleW = 0;
        int temporaryCircleH = 0;

    public static void main(String[] args) {

        GameLoop game = new GameLoop();
        game.loop();      
    }

    long fpsWriteTime = 0;
    int recentFps = 0;

    private void loop() {

        start();

        long previousLoopStartTime = System.nanoTime();
        long aimLoopTime = 1000000000 / aimFPS;

        while(gameContinue){

            long loopStartTime = System.nanoTime();
            long loopTime = loopStartTime - previousLoopStartTime;
            previousLoopStartTime = loopStartTime;

            double timeVariable = (double)loopTime / (double)aimLoopTime;

            recentFps++;
            fpsWriteTime = fpsWriteTime + loopTime;

            if(fpsWriteTime >= 1000000000){
                System.out.println("FPS: " + recentFps);
                fpsWriteTime = 0;
                recentFps = 0;
            }

            refreshGameLogic(timeVariable);

            refreshGameGraphic();

            long restTime = aimLoopTime - (System.nanoTime() - loopStartTime);  //nanosecond

            try {
                Thread.sleep((restTime)/ 1000000);                              //millisecond
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    private void refreshGameGraphic() {

        Graphics frameGraphic = getGraphics();
        Graphics bufferGraphic =  imageBuffer.getGraphics();

        bufferGraphic.setColor(Color.WHITE);
        bufferGraphic.fillRect(0, 0, framedimensionX, framedimensionY);

        bufferGraphic.setColor(Color.BLACK);        
        pe.drawScreen(bufferGraphic);

        if(temporaryCircle){
            bufferGraphic.setColor(Color.RED);
            bufferGraphic.drawOval(temporaryCircleX, temporaryCircleY, temporaryCircleW, temporaryCircleH);
            bufferGraphic.setColor(Color.BLACK);                
        }
                
        frameGraphic.drawImage(imageBuffer, interior.left, interior.top, this);
        
    }
    private void refreshGameLogic(double timeVariable) {
            pe.refresh(timeVariable);            
    } 
    private void start() {

        setTitle("First Loop");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        interior = getInsets();

        setSize(interior.left + framedimensionX + interior.right, interior.top + framedimensionY + interior.bottom);  
                    
        imageBuffer = new BufferedImage(framedimensionX, framedimensionY, BufferedImage.TYPE_INT_RGB);

        for(int i = 0; i < amountOfBalls; i++){
            double dimension = Math.random() * 29 + 1; 

            pe.addItem(new Ball(Math.random() * 1000, Math.random() * 500, Math.random() * 10, -Math.random() * 40,
                                dimension, dimension, dimension));
        }
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    public void mouseClicked(MouseEvent e) {     
        if(e.getButton() ==MouseEvent.BUTTON1){
            double dimension = Math.random() * 29 + 1; 

            pe.addItem(new Ball(e.getX() - dimension / 2, e.getY() - dimension / 2,
                    0, 0, dimension, dimension, dimension));
        }
    }

        double clickX = 0;
        double clickY = 0;
      
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            clickX = e.getX();
            clickY = e.getY();
            temporaryCircleX = e.getX();
            temporaryCircleY = e.getY();
            temporaryCircleW = 0;
            temporaryCircleH = 0;
            temporaryCircle = true;
        }
    }
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){

             double dimensionX = Math.abs(clickX - e.getX());       //Absolut Value
             double dimensionY = Math.abs(clickY - e.getY());
             double mass = Math.max(dimensionX, dimensionY);        //Compare both and choose bigger one

            pe.addItem(new Ball(e.getX(), e.getY(), 0, 0, dimensionX, dimensionY, mass));
                    temporaryCircle = false;
        }
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {
            temporaryCircleW = Math.abs(temporaryCircleW - e.getX());
            temporaryCircleH = Math.abs(temporaryCircleH - e.getY());
    }
    public void mouseMoved(MouseEvent e) {}  
}
