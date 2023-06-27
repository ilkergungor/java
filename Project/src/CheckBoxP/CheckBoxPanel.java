package CheckBoxP;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CheckBoxPanel extends JPanel implements ActionListener{

	JCheckBox check1, check2;
	JButton button1;
			
	public CheckBoxPanel()
	{
	check1 = new JCheckBox("BOX 1 ");
	add(check1);
	
	check2 = new JCheckBox("BOX 2");
	add(check2);
	
	button1 = new JButton("Button");
	add(button1);
	button1.addActionListener(this);	
	}

	public void actionPerformed(ActionEvent e) {

		String b = "BOX";	
				
		if(check1.isSelected()) 
		{
			b+= " 1 is selected!";	
		}											
		else  
		{
			b += " 1 is not selected!";	
		}

		if(check2.isSelected()) 
		{
			b+= " BOX 2 is selected!";
		}				
		else  
		{
			b += " BOX 2 is not selected!";
		}
		JOptionPane.showMessageDialog(this, b);		//MessageDialog yeni açılan penceredir
	}}
