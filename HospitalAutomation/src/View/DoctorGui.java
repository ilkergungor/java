package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Model.Doctor;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.chrono.MinguoDate;
import java.awt.event.ActionEvent;
import Helper.*;

public class DoctorGui extends JFrame {

	private JPanel contentPane;
	private static Doctor doctor = new Doctor();
	private JTable tableWorkHour;
	private DefaultTableModel workHourModel;
	private Object[] workHourData = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorGui frame = new DoctorGui(doctor);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DoctorGui(Doctor doctor) throws SQLException {

		workHourModel = new DefaultTableModel();
		Object[] columnWorkHour = new Object[2];
		columnWorkHour[0] = "ID";
		columnWorkHour[1] = "Date";
		workHourModel.setColumnIdentifiers(columnWorkHour);
		workHourData = new Object[2];
		for (int i = 0; i < doctor.getWorkHourList(doctor.getId()).size(); i++) {
			workHourData[0] = doctor.getWorkHourList(doctor.getId()).get(i).getId();
			workHourData[1] = doctor.getWorkHourList(doctor.getId()).get(i).getWorkdate();
			workHourModel.addRow(workHourData);
		}

		setResizable(false);
		setTitle("Hospital Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome MR/MRS " + doctor.getName());
		lblNewLabel.setBounds(10, 10, 306, 37);
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
		btnNewButton.setBounds(570, 10, 128, 37);
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		contentPane.add(btnNewButton);

		JTabbedPane doctorPane = new JTabbedPane(JTabbedPane.TOP);
		doctorPane.setBounds(10, 83, 720, 470);
		contentPane.add(doctorPane);

		JPanel workHours = new JPanel();
		workHours.setBackground(new Color(255, 255, 255));
		doctorPane.addTab("Work Hours", null, workHours, null);
		workHours.setLayout(null);

		JDateChooser selectDate = new JDateChooser();
		selectDate.setBounds(10, 10, 140, 25);
		selectDate.getSpinner().setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		workHours.add(selectDate);

		JComboBox selectTime = new JComboBox();
		selectTime.setBounds(160, 10, 60, 25);
		selectTime.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		selectTime.setModel(new DefaultComboBoxModel(new String[] { "09:00", "09:30", "10:00", "10:30", "11:00",
				"11:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30" }));
		workHours.add(selectTime);

		JButton buttonWorkHour = new JButton("Add");
		buttonWorkHour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date = "";
				try {
					date = sdf.format(selectDate.getDate());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				if (date.length() == 0) {
					Helper.showMessage("Please enter a valid date!");
				} else {
					String time = " " + selectTime.getSelectedItem().toString() + ":00";
					String selectedDate = date + time;
					try {
						boolean control = doctor.addWorkHour(doctor.getId(), doctor.getName(), selectedDate);
						if (control) {
							Helper.showMessage("success");
							updateWorkHourModel(doctor);
						} else
							Helper.showMessage("error");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		buttonWorkHour.setBounds(230, 10, 128, 25);
		buttonWorkHour.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 12));
		buttonWorkHour.setBackground(Color.LIGHT_GRAY);
		workHours.add(buttonWorkHour);

		JScrollPane scrollWorkHour = new JScrollPane();
		scrollWorkHour.setBounds(0, 45, 715, 398);
		workHours.add(scrollWorkHour);

		tableWorkHour = new JTable(workHourModel);
		scrollWorkHour.setViewportView(tableWorkHour);

		JButton buttonDeleteWorkHour = new JButton("Delete");
		buttonDeleteWorkHour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tableWorkHour.getSelectedRow();
				if (selectedRow >= 0) {
					String rowValue = tableWorkHour.getModel().getValueAt(selectedRow, 0).toString();
					int selectedID = Integer.parseInt(rowValue);
					boolean control;
					try {
						control = doctor.deleteWorkHour(selectedID);
						if (control) {
							Helper.showMessage("success");
							updateWorkHourModel(doctor);
						} else {
							Helper.showMessage("error");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else {
					Helper.showMessage("Please select a valid date!");
				}
			}
		});
		buttonDeleteWorkHour.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 12));
		buttonDeleteWorkHour.setBackground(Color.LIGHT_GRAY);
		buttonDeleteWorkHour.setBounds(577, 10, 128, 25);
		workHours.add(buttonDeleteWorkHour);
	}

	public void updateWorkHourModel(Doctor doctor) throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) tableWorkHour.getModel();
		clearModel.setRowCount(0);
		for (int i = 0; i < doctor.getWorkHourList(doctor.getId()).size(); i++) {
			workHourData[0] = doctor.getWorkHourList(doctor.getId()).get(i).getId();
			workHourData[1] = doctor.getWorkHourList(doctor.getId()).get(i).getWorkdate();
			workHourModel.addRow(workHourData);
		}
	}
}
