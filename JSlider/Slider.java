import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.FontUIResource;

public class Slider implements ChangeListener, MouseWheelListener{
    JFrame f;
    JPanel p;
    JLabel l;
    JSlider s;

    public Slider() {
        f = new JFrame ("Slider");
        p = new JPanel();
        l = new JLabel();
        s = new JSlider(0, 100, 50);

        s.setPreferredSize(new DimensionUIResource(450, 200));

        s.setPaintTicks(true);
        s.setMinorTickSpacing(10);
        s.setPaintTrack(true);
        s.setMajorTickSpacing(20);
        s.setPaintLabels(true);
        s.setFont(new FontUIResource("MV Boli", FontUIResource.BOLD, 15));
        s.setOrientation(SwingConstants.VERTICAL);

        l.setFont(new FontUIResource("MV Bol"i", FontUIResource.BOLD, 30));

        s.addMouseWheelListener(this);
        s.addChangeListener(this);

        p.add(s);
        p.add(l);
        f.add(p);

        f.setSize(250, 300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void stateChanged(ChangeEvent e) {
        l.setText("\u00B0C" + s.getValue());
    }
    public void mouseWheelMoved(MouseWheelEvent e) {
        int notches = e.getWheelRotation();
        if (notches < 0) {
            s.setValue(s.getValue() + 1);
        } else {
            s.setValue(s.getValue() - 1);
        }
    }
}
