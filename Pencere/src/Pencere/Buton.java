package Pencere;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Buton extends JPanel implements ActionListener{

	JButton button1, button2;
	JLabel label1;
	
	public Buton()
	{
	super();
	
	button1 = new JButton("Arttır");
	add(button1);
	
	button1.addActionListener(this);		//Buton  class'ı kendisi Action Listener olduğu için
	
	button2 = new JButton("Azalt");
	add(button2);
	
	button2.addActionListener(this);
	
	label1 = new JLabel("0");	
	add(label1);	
	}
	
	public static void main(String[] args)
			{		
			JFrame frame = new JFrame("Program Adı");
			Buton panel1 = new Buton();
			frame.add(panel1);
			frame.setSize(200, 200);
			frame.setVisible(true);
			}

	public void actionPerformed(ActionEvent e) {
			
		if(e.getActionCommand().equals("Arttır"))
		{
			int a = Integer.parseInt(label1.getText());				//Integer.parseInt int'i String'e çevirir			
			System.out.println(a);			
			a = a + 1;
			label1.setText("" + a);
		}
		else if (e.getActionCommand().equals("Azalt"))
		{
			int a = Integer.parseInt(label1.getText());
			System.out.println(a);			
			a = a - 1;	
			label1.setText(""	+ a);
		}}}
