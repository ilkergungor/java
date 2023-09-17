package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import Model.*;
import Helper.*;
import javax.swing.JTable;

public class PatientGui extends JFrame {

	private JPanel contentPane;
	private static Patient patient = new Patient();
	private static Clinic clinic = new Clinic();
	private JTable tableDoctor;
	private DefaultTableModel doctorModel;
	private Object[] doctorData = null;
	private JTable tableWorkHour;
	private WorkHour workHour = new WorkHour();
	private DefaultTableModel workHourModel;
	private Object[] workHourData = null;
	private int selectedDoctorID = 0;
	private String selectedDoctorName = null;
	private JTable tablemyappointments;
	private DefaultTableModel appointmentModel;
	private Object[] appointmentData = null;
	private Appointment appointment = new Appointment();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientGui frame = new PatientGui(patient);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PatientGui(Patient patient) {

		doctorModel = new DefaultTableModel();
		Object[] columnDoctorName = new Object[2];
		columnDoctorName[0] = "ID";
		columnDoctorName[1] = "Name";
		doctorModel.setColumnIdentifiers(columnDoctorName);
		doctorData = new Object[2];

		workHourModel = new DefaultTableModel();
		Object[] columnworkHour = new Object[2];
		columnworkHour[0] = "ID";
		columnworkHour[1] = "Date";
		workHourModel.setColumnIdentifiers(columnworkHour);
		workHourData = new Object[2];

		appointmentModel = new DefaultTableModel();
		Object[] columnAppointment = new Object[3];
		columnAppointment[0] = "ID";
		columnAppointment[1] = "Doctor";
		columnAppointment[2] = "Date";
		appointmentModel.setColumnIdentifiers(columnAppointment);
		appointmentData = new Object[3];
		try {
			for (int i = 0; i < appointment.getPatientList(patient.getId()).size(); i++) {
				appointmentData[0] = appointment.getPatientList(patient.getId()).get(i).getId();
				appointmentData[1] = appointment.getPatientList(patient.getId()).get(i).getDoctorname();
				appointmentData[2] = appointment.getPatientList(patient.getId()).get(i).getAppointmentdate();
				appointmentModel.addRow(appointmentData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		setBackground(new Color(255, 255, 255));
		setResizable(false);
		setTitle("Hospital Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome MR/MRS" + patient.getName());
		lblNewLabel.setBounds(22, 10, 306, 37);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGui lGui = new LoginGui();
				lGui.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(582, 10, 128, 37);
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		contentPane.add(btnNewButton);

		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
		tab.setBounds(0, 52, 736, 511);
		contentPane.add(tab);

		JPanel appointment = new JPanel();
		appointment.setBackground(new Color(255, 255, 255));
		tab.addTab("Appointment", null, appointment, null);
		appointment.setLayout(null);

		JScrollPane scrollDoctor = new JScrollPane();
		scrollDoctor.setBounds(10, 32, 260, 442);
		appointment.add(scrollDoctor);

		tableDoctor = new JTable(doctorModel);
		scrollDoctor.setViewportView(tableDoctor);

		JLabel doctorList = new JLabel("Doctor List");
		doctorList.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		doctorList.setBounds(10, 9, 86, 23);
		appointment.add(doctorList);

		JLabel labelClinic = new JLabel("Polyclinic Name");
		labelClinic.setHorizontalAlignment(SwingConstants.LEFT);
		labelClinic.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
		labelClinic.setBounds(278, 35, 173, 30);
		appointment.add(labelClinic);

		JScrollPane scrollTableWorkHour = new JScrollPane();
		scrollTableWorkHour.setBounds(461, 32, 260, 442);
		appointment.add(scrollTableWorkHour);

		tableWorkHour = new JTable(workHourModel);
		scrollTableWorkHour.setViewportView(tableWorkHour);
		// scrollTableWorkHour.setRowHeaderView(tableWorkHour);
		tableWorkHour.getColumnModel().getColumn(0).setPreferredWidth(5);
		JComboBox selectClinic = new JComboBox();
		selectClinic.setBounds(280, 64, 172, 35);
		selectClinic.addItem("------Select polyclinic------");
		try {
			for (int i = 0; i < clinic.getClinicList().size(); i++) {
				selectClinic.addItem(
						new Item(clinic.getClinicList().get(i).getId(), clinic.getClinicList().get(i).getName()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		selectClinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectClinic.getSelectedIndex() != 0) {
					JComboBox c = (JComboBox) e.getSource();
					Item item = (Item) c.getSelectedItem();
					DefaultTableModel clearModel = (DefaultTableModel) tableDoctor.getModel();
					clearModel.setRowCount(0);
					try {
						for (int i = 0; i < clinic.getClinicDoctorList(item.getKey()).size(); i++) {
							doctorData[0] = clinic.getClinicDoctorList(item.getKey()).get(i).getId();
							doctorData[1] = clinic.getClinicDoctorList(item.getKey()).get(i).getName();
							doctorModel.addRow(doctorData);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				} else {
					DefaultTableModel clearModel = (DefaultTableModel) tableDoctor.getModel();
					clearModel.setRowCount(0);
				}
			}
		});
		appointment.add(selectClinic);

		JLabel selectDoctor = new JLabel("Select Doctor");
		selectDoctor.setHorizontalAlignment(SwingConstants.LEFT);
		selectDoctor.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
		selectDoctor.setBounds(278, 125, 173, 30);
		appointment.add(selectDoctor);

		JButton buttonDoctorSelect = new JButton("Select");
		buttonDoctorSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableDoctor.getSelectedRow();
				if (row >= 0) {
					String value = tableDoctor.getModel().getValueAt(row, 0).toString();
					int id = Integer.parseInt(value);
					DefaultTableModel clearModel = (DefaultTableModel) tableWorkHour.getModel();
					clearModel.setRowCount(0);
					try {
						for (int i = 0; i < workHour.getWorkHourList(id).size(); i++) {
							workHourData[0] = workHour.getWorkHourList(id).get(i).getId();
							workHourData[1] = workHour.getWorkHourList(id).get(i).getWorkdate();
							workHourModel.addRow(workHourData);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					tableWorkHour.setModel(workHourModel);
					selectedDoctorID = id;
					selectedDoctorName = tableDoctor.getModel().getValueAt(row, 1).toString();

				} else {
					Helper.showMessage("Please select a doctor from the list!");
				}
			}
		});
		buttonDoctorSelect.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		buttonDoctorSelect.setBackground(Color.LIGHT_GRAY);
		buttonDoctorSelect.setBounds(278, 154, 173, 39);
		appointment.add(buttonDoctorSelect);

		JLabel doctorList_1 = new JLabel("Appointment");
		doctorList_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		doctorList_1.setBounds(461, 9, 86, 23);
		appointment.add(doctorList_1);

		JButton btnAddAppointment = new JButton("Add Appointment");
		btnAddAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tableWorkHour.getSelectedRow();
				if (selectedRow >= 0) {
					String date = tableWorkHour.getModel().getValueAt(selectedRow, 1).toString();
					try {
						boolean control = patient.addAppointment(selectedDoctorID, patient.getId(), selectedDoctorName,
								patient.getName(), date);
						if (control) {
							Helper.showMessage("success");
							patient.updateWorkHourStatus(selectedDoctorID, date);
							updateWorkHourModel(selectedDoctorID);
							updateAppointmentModel(patient.getId());
						} else {
							Helper.showMessage("error");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else {
					Helper.showMessage("Please input a valid date!");
				}

			}
		});
		btnAddAppointment.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		btnAddAppointment.setBackground(Color.LIGHT_GRAY);
		btnAddAppointment.setBounds(280, 278, 173, 39);
		appointment.add(btnAddAppointment);

		JLabel labelappointment = new JLabel("Appointment");
		labelappointment.setHorizontalAlignment(SwingConstants.LEFT);
		labelappointment.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
		labelappointment.setBounds(280, 249, 173, 30);
		appointment.add(labelappointment);

		JPanel panelappointment = new JPanel();
		tab.addTab("My Appointments", null, panelappointment, null);
		panelappointment.setLayout(null);

		JScrollPane scrollmyappointments = new JScrollPane();
		scrollmyappointments.setBounds(10, 10, 711, 464);
		panelappointment.add(scrollmyappointments);

		tablemyappointments = new JTable(appointmentModel);
		scrollmyappointments.setViewportView(tablemyappointments);
	}

	public void updateWorkHourModel(int doctorid) throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) tableWorkHour.getModel();
		clearModel.setRowCount(0);
		for (int i = 0; i < workHour.getWorkHourList(doctorid).size(); i++) {
			workHourData[0] = workHour.getWorkHourList(doctorid).get(i).getId();
			workHourData[1] = workHour.getWorkHourList(doctorid).get(i).getWorkdate();
			workHourModel.addRow(workHourData);
		}
	}

	public void updateAppointmentModel(int patientid) throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) tableWorkHour.getModel();
		clearModel.setRowCount(0);
		for (int i = 0; i < appointment.getPatientList(patientid).size(); i++) {
			appointmentData[0] = appointment.getPatientList(patientid).get(i).getId();
			appointmentData[1] = appointment.getPatientList(patientid).get(i).getDoctorname();
			appointmentData[2] = appointment.getPatientList(patientid).get(i).getAppointmentdate();
			appointmentModel.addRow(appointmentData);
		}
	}
}
