package View;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import Helper.*;
import Model.Doctor;
import Model.Patient;
import Model.SurgeonDoctor;

public class LoginGui extends JFrame {
	private JTextField patientIDText;
	private JTextField doctorIDTxt;
	private JPasswordField doctorpasswordtextfield;
	private JPasswordField patientpasswordtextfield;
	private DataBaseConnection connection = new DataBaseConnection();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGui frame = new LoginGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public LoginGui() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("HOSPITAL");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel(
				new ImageIcon("C:\\Users\\lkrgn\\eclipse-workspace\\HospitalAutomation\\src\\health.png"));
		lblNewLabel.setBounds(273, 10, 45, 45);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Welcome to Hospital Management System!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lblNewLabel_1.setBounds(95, 65, 414, 39);
		getContentPane().add(lblNewLabel_1);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 10));
		tabbedPane.setBounds(10, 113, 564, 336);
		getContentPane().add(tabbedPane);

		JPanel patientLogin = new JPanel();
		patientLogin.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Patient Login", null, patientLogin, null);
		patientLogin.setLayout(null);

		JLabel patientIDlbl = new JLabel("ID Number:");
		patientIDlbl.setBounds(47, 74, 121, 30);
		patientIDlbl.setHorizontalAlignment(SwingConstants.CENTER);
		patientIDlbl.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		patientLogin.add(patientIDlbl);

		JLabel patientPasswordlbl = new JLabel("Password:");
		patientPasswordlbl.setHorizontalAlignment(SwingConstants.CENTER);
		patientPasswordlbl.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		patientPasswordlbl.setBounds(47, 144, 121, 30);
		patientLogin.add(patientPasswordlbl);

		patientIDText = new JTextField();
		patientIDText.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		patientIDText.setBounds(195, 74, 325, 30);
		patientLogin.add(patientIDText);
		patientIDText.setColumns(10);

		JButton signinbutton = new JButton("SIGN IN");
		signinbutton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		signinbutton.setBounds(47, 205, 213, 53);
		patientLogin.add(signinbutton);
		signinbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (patientIDText.getText().length() == 0 || patientpasswordtextfield.getText().length() == 0) {
					Helper.showMessage("fill");
				} else {
					boolean key = true;
					try {
						Connection con = connection.conDB();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM user");
						
						while (rs.next()) {
							if (patientIDText.getText().equals(rs.getString("idno"))
									&& patientpasswordtextfield.getText().equals(rs.getString("password"))) {
								if (rs.getString("type").equals("patient")) {
									Patient p = new Patient();
									p.setId(rs.getInt("id"));
									p.setPassword("password");
									p.setIdno(rs.getString("idno"));
									p.setName(rs.getString("name"));
									p.setType(rs.getString("type"));
									PatientGui pGui = new PatientGui(p);
									pGui.setVisible(true);
									dispose();
									key = false;
								}
							}
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					if (key) {
						Helper.showMessage("Invalid ID or password!");
					}
				}
			}
		});

		JButton signupbutton = new JButton("SIGN UP");
		signupbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterGui rGui = new RegisterGui();
				rGui.setVisible(true);
				dispose();
			}
		});
		signupbutton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		signupbutton.setBounds(307, 205, 213, 53);
		patientLogin.add(signupbutton);

		patientpasswordtextfield = new JPasswordField();
		patientpasswordtextfield.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		patientpasswordtextfield.setBounds(195, 143, 325, 31);
		patientLogin.add(patientpasswordtextfield);

		JPanel doctorLogin = new JPanel();
		doctorLogin.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Doctor Login", null, doctorLogin, null);
		doctorLogin.setLayout(null);

		doctorIDTxt = new JTextField();
		doctorIDTxt.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		doctorIDTxt.setColumns(10);
		doctorIDTxt.setBounds(180, 55, 325, 30);
		doctorLogin.add(doctorIDTxt);

		JLabel doctorPasswordlbl = new JLabel("Password:");
		doctorPasswordlbl.setHorizontalAlignment(SwingConstants.CENTER);
		doctorPasswordlbl.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		doctorPasswordlbl.setBounds(32, 125, 121, 30);
		doctorLogin.add(doctorPasswordlbl);

		JLabel doctorIDlbl = new JLabel("ID Number:");
		doctorIDlbl.setHorizontalAlignment(SwingConstants.CENTER);
		doctorIDlbl.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		doctorIDlbl.setBounds(32, 55, 121, 30);
		doctorLogin.add(doctorIDlbl);

		JButton doctorsigninbutton = new JButton("SIGN IN");
		doctorsigninbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (doctorIDTxt.getText().length() == 0 || doctorpasswordtextfield.getText().length() == 0) {
					Helper.showMessage("fill");
				} else {
					try {
						Connection con = connection.conDB();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM user");
						while (rs.next()) {
							if (doctorIDTxt.getText().equals(rs.getString("idno"))
									&& doctorpasswordtextfield.getText().equals(rs.getString("password"))) {
								if (rs.getString("type").equals("surgeondoctor")) {
									SurgeonDoctor sd = new SurgeonDoctor();
									sd.setId(rs.getInt("id"));
									sd.setPassword("password");
									sd.setIdno(rs.getString("idno"));
									sd.setName(rs.getString("name"));
									sd.setType(rs.getString("type"));
									SurgeonDoctorGui sdGui = new SurgeonDoctorGui(sd);
									sdGui.setVisible(true);
									dispose();
								}
								if (rs.getString("type").equals("doctor")) {
									Doctor d = new Doctor();
									d.setId(rs.getInt("id"));
									d.setPassword("password");
									d.setIdno(rs.getString("idno"));
									d.setName(rs.getString("name"));
									d.setType(rs.getString("type"));
									DoctorGui dGui = new DoctorGui(d);
									dGui.setVisible(true);
									dispose();

								}
							}
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		doctorsigninbutton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		doctorsigninbutton.setBounds(52, 206, 213, 53);
		doctorLogin.add(doctorsigninbutton);

		doctorpasswordtextfield = new JPasswordField();
		doctorpasswordtextfield.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		doctorpasswordtextfield.setBounds(180, 124, 325, 31);
		doctorLogin.add(doctorpasswordtextfield);
	}
}
