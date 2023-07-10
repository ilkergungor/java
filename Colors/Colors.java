import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Colors extends JPanel implements MouseListener{
   
BufferedImage picture;

Color color;

int dimensionx = 1280;
int dimensiony = 700;

String text = "";

    public Colors() {
    
        picture = new BufferedImage(dimensionx, dimensiony,BufferedImage.TYPE_INT_RGB);
        refreshColors();    
   }

    public void changeColor(int x, int y){

        float hue = (x - 0F) / dimensionx;                              // 0 < H / S / B < 1 
        float saturation = (y - 0F) / dimensiony;       
        color = Color.getHSBColor(hue, 1F, 1F);              //F = Float
        System.out.println("Hue: " + hue + "Saturation: " + saturation);
        Graphics2D g = picture.createGraphics();
        g.setColor(color); 
        g.fillRect(0, 0, dimensionx, dimensiony); 
    }

    public void paint(Graphics g) {
       super.paint(g);
       g.drawImage(picture, 30, 30, 1200, 620, null);
       g.drawString(text, 10, 10);     
    }

 public static void main(String[] args){

    JFrame frame = new JFrame();
    Colors panel = new Colors();
    panel.addMouseListener(panel);
    frame.add(panel);
    frame.setSize(1280, 720);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true); 
    }

public void mouseClicked(MouseEvent e) {
    if(e.getButton() == MouseEvent.BUTTON1){
    text = "X: " + e.getX() + "- Y: " + e.getY();
    changeColor(e.getX() , e.getY() );
    repaint();
    }   
    else if (e.getButton() == MouseEvent.BUTTON3){
        refreshColors();
        repaint();
    }
}

public void refreshColors(){
   
    float hue = 0;
    float saturation = 0;

    for(int i = 0; i < dimensionx; i++){
        for(int j = 0; j < dimensiony; j++){
            hue = (i - 0F) / dimensionx;                             
            saturation = (j - 0F) / dimensiony;    
            color = Color.getHSBColor(hue, saturation, 1F);
            picture.setRGB(i, j, color.getRGB());
        }
    }
}

public void mousePressed(MouseEvent e) {}
public void mouseReleased(MouseEvent e) {}
public void mouseEntered(MouseEvent e) {}
public void mouseExited(MouseEvent e) {}
}
