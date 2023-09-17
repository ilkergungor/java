package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import Helper.*;
import Model.*;

public class RegisterGui extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldID;
	private JPasswordField passwordField;
	private Patient patient = new Patient();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterGui frame = new RegisterGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RegisterGui() {
		setBackground(new Color(255, 255, 255));
		setTitle("Registration");
		setResizable(false);
		setEnabled(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 304, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelRegister = new JLabel("Full Name");
		labelRegister.setHorizontalAlignment(SwingConstants.LEFT);
		labelRegister.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
		labelRegister.setBounds(10, 10, 120, 30);
		contentPane.add(labelRegister);

		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
		textFieldName.setColumns(10);
		textFieldName.setBounds(10, 40, 270, 30);
		contentPane.add(textFieldName);

		JLabel labelRegisterID = new JLabel("ID Number");
		labelRegisterID.setHorizontalAlignment(SwingConstants.LEFT);
		labelRegisterID.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
		labelRegisterID.setBounds(10, 75, 120, 30);
		contentPane.add(labelRegisterID);

		textFieldID = new JTextField();
		textFieldID.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
		textFieldID.setColumns(10);
		textFieldID.setBounds(10, 105, 270, 30);
		contentPane.add(textFieldID);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
		lblPassword.setBounds(10, 140, 120, 30);
		contentPane.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
		passwordField.setBounds(10, 170, 270, 30);
		contentPane.add(passwordField);

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldID.getText().length() == 0 || passwordField.getText().length() == 0 || textFieldName.getText().length() == 0) {
					Helper.showMessage("fill");
				} else {
					try {
						boolean control = patient.register(textFieldID.getText(), passwordField.getText(), textFieldName.getText());
						if(control) {
							Helper.showMessage("success");
							LoginGui login = new LoginGui();
							login.setVisible(true);
							dispose();
						}else {
							Helper.showMessage("error");
						}
					} catch (SQLException e1) {e1.printStackTrace();}
				}
			}
		});
		btnRegister.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		btnRegister.setBackground(Color.LIGHT_GRAY);
		btnRegister.setBounds(10, 220, 270, 30);
		contentPane.add(btnRegister);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGui login = new LoginGui();
				login.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.setBounds(10, 260, 270, 30);
		contentPane.add(btnBack);

	}
}
