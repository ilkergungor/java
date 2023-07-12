import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MovingSquares extends JPanel implements MouseListener, MouseMotionListener{

    static final int NONE_POINT = 0;
    static final int LEFT_UP_POINT = 1;
    static final int RIGHT_UP_POINT = 2;
    static final int RIGHT_DOWN_POINT = 3;
    static final int LEFT_DOWN_POINT = 4; 
    
    String text = "";
    ArrayList<Rectangle> squares;

    Rectangle leftUp, leftDown, rightUp, rightDown;
    int cornerPoint = NONE_POINT;
    int dimensionSquare = 5;

    int cornerClickX = 0;
    int cornerClickY = 0;
    int cornerClickWidth = 0;
    int cornerClickHeight = 0;

    boolean move = false; 

    Rectangle selectedSquare = null;

    Point point1;
    Cursor mouse = Cursor.getDefaultCursor();
    Cursor mouseNE = Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);
    Cursor mouseNW = Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR);
    Cursor mouseMove = Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR);

    double differenceX, differenceY;
    double differenceXcorner, differenceYcorner;

    public static void main (String[] args){

    JFrame frame = new JFrame("Squares");
    MovingSquares panel = new MovingSquares();
    panel.addMouseMotionListener(panel);
    panel.addMouseListener(panel);
    frame.add(panel);
    frame.setSize(1280, 720);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}
    public MovingSquares(){

     squares = new  ArrayList<Rectangle>();
     squares.add(new Rectangle(50, 50, 30, 30));
     squares.add(new Rectangle(100, 100, 30, 30));
     squares.add(new Rectangle(200, 200,30, 30));
     squares.add(new Rectangle(400, 400,30, 30));
     squares.add(new Rectangle(500, 500,30, 30));
    }
   
   public void paint(Graphics g){
    
        super.paint(g);
        //g.drawString(text, 50, 50);
        g.setColor(Color.BLUE);
        Iterator<Rectangle> it = squares.iterator();
        Rectangle r;

        while (it.hasNext()){
        r = it.next();
        if(selectedSquare != null && r.equals(selectedSquare)){
        g.setColor(Color.YELLOW);
        g.fillRect(r.x, r.y, r.width, r.height);
        g.setColor(Color.GREEN);
        }
        else{
        g.fillRect(r.x, r.y, r.width, r.height);
        }
    }

    if(rightUp != null && rightDown != null && leftUp != null && leftDown != null ){

        g.setColor(Color.RED);
        g.fillRect(rightUp.x, rightUp.y, rightUp.width, rightUp.height);
        g.fillRect(rightDown.x, rightDown.y, rightDown.width, rightDown.height);
        g.fillRect(leftUp.x, leftUp.y, leftUp.width, leftUp.height);
        g.fillRect(leftDown.x, leftDown.y, leftDown.width, leftDown.height);
        g.setColor(Color.PINK);
    }
    }

public void mouseDragged(MouseEvent e) {
    if(selectedSquare != null && move){
        
        point1 = (Point)e.getPoint().clone();    
        point1.setLocation((point1.getX() - differenceX), (point1.getY() - differenceY));
       
        selectedSquare.setLocation(point1);
        cornerCalculation();
        repaint();   
    }

    else if(selectedSquare != null && cornerPoint != NONE_POINT){
        if (cornerPoint == RIGHT_DOWN_POINT){
            selectedSquare.setSize((int)(e.getX() -  selectedSquare.getX() - differenceXcorner), (int)(e.getY() -  selectedSquare.getY() - differenceYcorner));
            cornerCalculation();
            repaint();  
        }else if (cornerPoint == RIGHT_UP_POINT){
            selectedSquare.setBounds((int)selectedSquare.getX(), (int)(e.getY() - differenceYcorner + dimensionSquare),
            (int)(e.getX() - selectedSquare.getX() - differenceXcorner), ((int)(cornerClickY - e.getY() + cornerClickHeight)));
            cornerCalculation();
            repaint();
        }else if (cornerPoint == LEFT_UP_POINT){
            selectedSquare.setBounds((int)(e.getX() - differenceXcorner + dimensionSquare), (int)(e.getY() - differenceYcorner + dimensionSquare),
            (int)(cornerClickX - e.getX() + cornerClickWidth), (int)(cornerClickY - e.getY() + cornerClickHeight));
            cornerCalculation();
            repaint();
        }else if (cornerPoint == LEFT_DOWN_POINT){
            selectedSquare.setBounds((int)(e.getX() - differenceXcorner + dimensionSquare), (int)selectedSquare.getY(),
            (int)(cornerClickX - e.getX() + cornerClickWidth), (int)(e.getY() - selectedSquare.getY()));
            cornerCalculation();
            repaint();
        }
    }
}

private void cornerCalculation() {

        leftUp = new Rectangle((int)selectedSquare.getX() - dimensionSquare, (int)selectedSquare.getY() - dimensionSquare, dimensionSquare, dimensionSquare);
        leftDown = new Rectangle((int)selectedSquare.getX() - dimensionSquare, (int)selectedSquare.getY() + (int)selectedSquare.getHeight(), dimensionSquare, dimensionSquare);
        rightUp = new Rectangle((int)selectedSquare.getX() + (int)selectedSquare.getWidth(), (int)selectedSquare.getY() - dimensionSquare, dimensionSquare, dimensionSquare);
        rightDown = new Rectangle((int)selectedSquare.getX() +  (int)selectedSquare.getWidth(), (int)selectedSquare.getY() + (int)selectedSquare.getHeight(), dimensionSquare, dimensionSquare);

        }
public void mouseMoved(MouseEvent e) {

        if( rightDown != null && selectedSquare.contains(e.getPoint())){   
            setCursor(mouseMove);  

        }else if( rightDown != null && rightDown.contains(e.getPoint())){   
            setCursor(mouseNW);  

        }else if(rightUp != null && rightUp.contains(e.getPoint())){
            setCursor(mouseNE);   
          
        }else if(leftUp != null && leftUp.contains(e.getPoint())){
            setCursor(mouseNW);  
            
        }else if(leftDown != null && leftDown.contains(e.getPoint())){
            setCursor(mouseNE);   
             
        }else{
            setCursor(mouse);
        }
        //text = e.toString();
        //repaint();
}

public void mouseClicked(MouseEvent e) {}
public void mousePressed(MouseEvent e) {
       
        Rectangle r;
        move = false;

        if( rightDown != null && rightDown.contains(e.getPoint())){            
            cornerPoint = RIGHT_DOWN_POINT;  
            differenceXcorner = e.getX() - rightDown.getX();
            differenceYcorner = e.getY() - rightDown.getY();
            return;                                                   //If pressed on corner rectangles continues selection; not null
        }else if(rightUp != null && rightUp.contains(e.getPoint())){
            cornerPoint = RIGHT_UP_POINT;
            cornerClickX = e.getX();
            cornerClickY = e.getY();
            cornerClickWidth = (int)selectedSquare.getWidth();
            cornerClickHeight = (int)selectedSquare.getHeight();
            differenceXcorner = e.getX() - rightUp.getX();
            differenceYcorner = e.getY() - rightUp.getY();
            return;
        }else if(leftUp != null && leftUp.contains(e.getPoint())){
            cornerPoint = LEFT_UP_POINT;
            cornerClickX = e.getX();
            cornerClickY = e.getY();
            cornerClickWidth = (int)selectedSquare.getWidth();
            cornerClickHeight = (int)selectedSquare.getHeight();
            differenceXcorner = e.getX() - leftUp.getX();
            differenceYcorner = e.getY() - leftUp.getY();
            return;
        }else if(leftDown != null && leftDown.contains(e.getPoint())){
            cornerPoint = LEFT_DOWN_POINT;
            cornerClickX = e.getX();
            cornerClickY = e.getY();
            cornerClickWidth = (int)selectedSquare.getWidth();
            cornerClickHeight = (int)selectedSquare.getHeight();
            differenceXcorner = e.getX() - leftDown.getX();
            differenceYcorner = e.getY() - leftDown.getY();
            return;
        }

        cornerPoint = NONE_POINT;

         ListIterator<Rectangle> it = squares.listIterator(squares.size());
         
           while (it.hasPrevious()){
                r = it.previous();

            if(r.contains(e.getPoint())){
                
                selectedSquare = r;
                setCursor(mouseMove);
                differenceX = e.getX() - selectedSquare.getX();
                differenceY = e.getY() - selectedSquare.getY();

                cornerCalculation();

                move = true;
                 
                repaint();
                return;
            }
        }

        selectedSquare = null;

        leftUp= null;
        leftDown= null;
        rightUp = null;
        rightDown = null;
        
        repaint();

}
public void mouseReleased(MouseEvent e) {}
public void mouseEntered(MouseEvent e) {}
public void mouseExited(MouseEvent e) {}
}
