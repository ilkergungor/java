import javax.swing.JFrame;

public class Frame extends JFrame{

    public Frame() {

        this.add(new Panel());
        this.setTitle("Snake");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocation(null);
    }
}
