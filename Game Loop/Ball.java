import java.awt.Graphics;

public class Ball extends PhysicalItem {

public Ball(double x, double y, double vx, double vy, double w, double h, double m) {
    super(x, y, vx, vy, w, h, m);
}
    public  void drawScreen(Graphics g) {
        g.drawOval((int)x, (int)y, (int)w, (int)h);
    }
}