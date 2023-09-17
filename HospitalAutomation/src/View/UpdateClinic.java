package View;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Helper.*;
import Model.Clinic;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UpdateClinic extends JFrame {

	private JPanel updateClinic;
	private JTextField textFieldEdit;
	private static Clinic clinic;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateClinic frame = new UpdateClinic(clinic);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public UpdateClinic(Clinic clinic) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 210, 170);
		setResizable(false);
		updateClinic = new JPanel();
		updateClinic.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(updateClinic);
		updateClinic.setLayout(null);

		JLabel labelClinicEdit = new JLabel("Polyclinic Name");
		labelClinicEdit.setHorizontalAlignment(SwingConstants.LEFT);
		labelClinicEdit.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		labelClinicEdit.setBounds(10, 0, 162, 30);
		updateClinic.add(labelClinicEdit);

		textFieldEdit = new JTextField("");
		textFieldEdit.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		textFieldEdit.setColumns(10);
		textFieldEdit.setBounds(10, 40, 176, 30);
		textFieldEdit.setText(clinic.getName());
		updateClinic.add(textFieldEdit);

		JButton buttonClinicEdit = new JButton("Save");
		buttonClinicEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Helper.confirm("sure")) {
					try {
						clinic.updateClinic(clinic.getId(), textFieldEdit.getText());
						Helper.showMessage("success");
						dispose();
					} catch (SQLException e1) {e1.printStackTrace();}
				}
			}
		});
		buttonClinicEdit.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		buttonClinicEdit.setBackground(Color.LIGHT_GRAY);
		buttonClinicEdit.setBounds(10, 80, 176, 40);
		updateClinic.add(buttonClinicEdit);
	}
}