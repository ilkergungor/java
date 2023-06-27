package RadioButton;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButton extends JPanel implements ActionListener{

		JLabel label1, label2;
		JRadioButton radio1, radio2, radio3, radio4;
		JRadioButton radio5, radio6;
		JButton button1;
		ButtonGroup group1, group2;						//Aynı grupta olan butonlar için
		
	public RadioButton() {
		
		group1 = new ButtonGroup();
		
		group2 = new ButtonGroup();
		
		button1 = new JButton("Finish");
		add(button1);
		button1.addActionListener(this);
		
		label1 = new JLabel("Please Select a Class!");
		add(label1);
		
		radio1 = new JRadioButton("Class 1");
		add(radio1);
		group1.add(radio1);						//Butonları gruba eklemek için
		
		radio2 = new JRadioButton("Class 2");
		add(radio2);
		group1.add(radio2);
		
		radio3 = new JRadioButton("Class 3");
		add(radio3);
		group1.add(radio3);
		
		radio4 = new JRadioButton("Class 4");
		add(radio4);
		group1.add(radio4);	
		
		//group2  için radio5, radio6 ve label23 kullanılacak
			
		label2 = new JLabel("Please Select a Term.");	//Label'ın görüntü olarak ilk gruptan 
		add(label2);									//sonra olması için aşağıda olmalıdır
		
		radio5 = new JRadioButton("Spring");
		add(radio5);
		group2.add(radio5);
		
		radio6 = new JRadioButton("Fall");
		add(radio6);
		group2.add(radio6);
		}

	public void actionPerformed(ActionEvent e) {

		String s = "Selected Class is: ";
		
		boolean cls = false;		//Sınıf seçilmediyse dönemi seçemesin diye
		
		if(radio1.isSelected()){
			s += radio1.getText();
			cls = true;
		}	
		else if(radio2.isSelected()){
			s += radio2.getText();
			cls = true;
		}
		else if(radio3.isSelected()){
			s += radio3.getText();
			cls = true;
		}
		else if(radio4.isSelected()){
			s += radio4.getText();
			cls = true;
		}
		else {
			s = "Please Select a Class!";
			cls = false;
		}

			if (cls) {				//Sınıf seçildiyse dönemi de seçebilsin diye
				if(radio5.isSelected()){
					s +=  ", term is " + radio5.getText();
				}	
				else if(radio6.isSelected()){
					s += ", term is " + radio6.getText() + ".";
				}
				else {
					s = "Please Select a Term" + ".";
				}
			}	
		JOptionPane.showMessageDialog(this, s);		
	}}
