package TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TextField extends JPanel implements ActionListener{

	JTextField textField1; 
	JButton button1;
	JLabel label1;
	
	public TextField() {
		
	super();
	
	textField1 = new JTextField(20);		//20 karakterlik bir yazı alanı oluşturur
	add(textField1);
	textField1.addActionListener(this);		//Enter tuşuna basıldığında da butona basıldığı gibi yazı yazdırır
	
	button1 = new JButton("Press");			//Press tuşuna basıldığında yazı yazdırır
	add(button1);
	button1.addActionListener(this);
	
	label1 = new JLabel();
	add(label1);
	}

	public static void main(String[] args)
			{		
			JFrame frame = new JFrame("Program");
			TextField panel1 = new TextField();
			frame.add(panel1);
			frame.setSize(400,400);
			frame.setVisible(true);
			}

	public void actionPerformed(ActionEvent e) {
			
//		textField1.requestFocus();												//Enter tuşuna basıldığında da butona basıldığı gibi yazı yazdırır
//		label1.setText(label1.getText()+ " " + textField1.getText());
	
		if(e.getActionCommand().equals("Press")){								//Press tuşuna basıldığında yazı yazdırır
			label1.setText(label1.getText()+ " " + textField1.getText());
			textField1.setText("");}
			}		
	}
	
