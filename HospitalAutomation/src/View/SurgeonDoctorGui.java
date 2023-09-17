package View;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import Helper.Helper;
import Helper.Item;
import Model.Clinic;
import Model.SurgeonDoctor;
import javax.swing.JComboBox;

public class SurgeonDoctorGui extends JFrame {

	static SurgeonDoctor surgeondoctor = new SurgeonDoctor();
	static Clinic clinic = new Clinic();
	private JPanel contentPane;
	private JTextField textFieldname;
	private JPasswordField passwordField;
	private JTextField textFieldID;
	private JTextField textFieldUserID;
	private JTable tabledoctor;
	private DefaultTableModel doctorModel = null;
	private Object[] doctorData = null;
	private DefaultTableModel clinicModel = null;
	private Object[] clinicData = null;
	private JTable tableClinic;
	private JTextField textFieldClinic;
	private JPopupMenu clinicMenu;
	private JTable tableWorker;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SurgeonDoctorGui frame = new SurgeonDoctorGui(surgeondoctor);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public SurgeonDoctorGui(SurgeonDoctor surgeondoctor) throws SQLException {
			
		doctorModel = new DefaultTableModel();
		Object[] columnDoctorName = new Object[4];
		columnDoctorName[0] = "#";
		columnDoctorName[1] = "Name";
		columnDoctorName[2] = "ID No";
		columnDoctorName[3] = "Password";
		doctorModel.setColumnIdentifiers(columnDoctorName);
		doctorData = new Object[4];
		for(int i = 0 ; i < surgeondoctor.getDoctorList().size(); i++) {
			doctorData[0] = surgeondoctor.getDoctorList().get(i).getId();
			doctorData[1] = surgeondoctor.getDoctorList().get(i).getName();
			doctorData[2] = surgeondoctor.getDoctorList().get(i).getIdno();
			doctorData[3] = surgeondoctor.getDoctorList().get(i).getPassword();
			doctorModel.addRow(doctorData);
		}
		clinicModel = new DefaultTableModel();
		Object[] columnClinic = new Object[2];
		columnClinic[0] = "ID";
		columnClinic[1] = "Name";
		clinicModel.setColumnIdentifiers(columnClinic);
		clinicData = new Object[2];
		for(int i = 0; i < clinic.getClinicList().size(); i++) {
			clinicData[0] = clinic.getClinicList().get(i).getId();
			clinicData[1] = clinic.getClinicList().get(i).getName();
			clinicModel.addRow(clinicData);
		}
		DefaultTableModel workerModel = new DefaultTableModel();
		Object[] columnWorker = new Object[2];
		columnWorker[0] = "ID";
		columnWorker[1] = "Full Name";
		workerModel.setColumnIdentifiers(columnWorker);
		Object[] workerData = new Object[2];

		setResizable(false);
		setTitle("Hospital Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome MR/MRS, " + surgeondoctor.getName());
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
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		contentPane.add(btnNewButton);
		
		JTabbedPane managementpane = new JTabbedPane(JTabbedPane.TOP);
		managementpane.setBounds(10, 79, 720, 470);
		contentPane.add(managementpane);
		
		JPanel doctormanagementp = new JPanel();
		doctormanagementp.setBackground(Color.WHITE);
		managementpane.addTab("Management", null, doctormanagementp, null);
		doctormanagementp.setLayout(null);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setBounds(522, 10, 121, 30);
		lblFullName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFullName.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		doctormanagementp.add(lblFullName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(522, 172, 96, 30);
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		doctormanagementp.add(lblPassword);
		
		textFieldname = new JTextField();
		textFieldname.setBounds(522, 52, 162, 30);
		textFieldname.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		textFieldname.setColumns(10);
		doctormanagementp.add(textFieldname);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldname.getText().length() == 0 || passwordField.getText().length() == 0 || textFieldID.getText().length() == 0) {
					Helper.showMessage("fill");
				}else {
					try {
						boolean control = surgeondoctor.addDoctor(textFieldID.getText(), passwordField.getText(), textFieldname.getText());
						if(control)
							Helper.showMessage("success");
							textFieldname.setText(null);
							textFieldID.setText(null);
							passwordField.setText(null);
							updateDoctorModel();
					} catch (SQLException e1) {e1.printStackTrace();}
				}
			}
		});
		btnAdd.setBounds(522, 256, 162, 39);
		btnAdd.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		btnAdd.setBackground(Color.LIGHT_GRAY);
		doctormanagementp.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(522, 385, 162, 39);
		btnDelete.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		btnDelete.setBackground(Color.LIGHT_GRAY);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldUserID.getText().length() == 0) {
					Helper.showMessage("Please select a a doctor to remove from the list!");
				}else {
					if(Helper.confirm("sure")) {
						int selectedID = Integer.parseInt(textFieldUserID.getText());
						try {
							boolean control = surgeondoctor.deleteDoctor(selectedID);
							if(control) {
								Helper.showMessage("success");
								textFieldUserID.setText("null");
								updateDoctorModel();
							}
						} catch (SQLException e1) {e1.printStackTrace();}
					}
				}
			}
		});
		doctormanagementp.add(btnDelete);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(522, 212, 162, 31);
		passwordField.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		doctormanagementp.add(passwordField);
		
		JLabel lblIdNumber_1 = new JLabel("ID Number");
		lblIdNumber_1.setBounds(522, 92, 121, 30);
		lblIdNumber_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdNumber_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		doctormanagementp.add(lblIdNumber_1);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(522, 132, 162, 30);
		textFieldID.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		textFieldID.setColumns(10);
		doctormanagementp.add(textFieldID);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(522, 305, 121, 30);
		lblUserId.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserId.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		doctormanagementp.add(lblUserId);
		
		JScrollPane scrolldoctor = new JScrollPane();
		scrolldoctor.setBounds(10, 20, 502, 404);
		doctormanagementp.add(scrolldoctor);
		
		tabledoctor = new JTable(doctorModel);
		scrolldoctor.setViewportView(tabledoctor);
		
		JPanel clinicpanel = new JPanel();
		clinicpanel.setBackground(new Color(255, 255, 255));
		managementpane.addTab("Polyclinics", null, clinicpanel, null);
		clinicpanel.setLayout(null);
		
		JScrollPane scrollClinic = new JScrollPane();
		scrollClinic.setBounds(10, 10, 269, 423);
		clinicpanel.add(scrollClinic);
		
		clinicMenu = new JPopupMenu();
		JMenuItem updateMenu = new JMenuItem("Update");
		JMenuItem deleteMenu = new JMenuItem("Delete");
		clinicMenu.add(updateMenu);
		clinicMenu.add(deleteMenu);
		
		updateMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int selectedClinicID = Integer.parseInt(tableClinic.getValueAt(tableClinic.getSelectedRow(), 0).toString());
				Clinic selectClinic = clinic.getFetch(selectedClinicID);
				UpdateClinic uc = new UpdateClinic(selectClinic);
				uc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				uc.setVisible(true);
				uc.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						try {
							updateClinicModel();
						} catch (SQLException e1) {e1.printStackTrace();}
					}
				});
			}
		});
		deleteMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Helper.confirm("sure")) {
					int selectedClinicID = Integer.parseInt(tableClinic.getValueAt(tableClinic.getSelectedRow(), 0).toString());
					try {
						if(clinic.deleteClinic(selectedClinicID)) {
							Helper.showMessage("success");
							updateClinicModel();
						}else {
							Helper.showMessage("error");
						}
					} catch (SQLException e1) {e1.printStackTrace();}
				}
				
			}
		});
		tableClinic = new JTable(clinicModel);
		tableClinic.setComponentPopupMenu(clinicMenu);
		tableClinic.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Point point = e.getPoint();
				int selectedRow = tableClinic.rowAtPoint(point);
				tableClinic.setRowSelectionInterval(selectedRow, selectedRow);
			}
		});
		scrollClinic.setViewportView(tableClinic);
		
		JLabel labelClinic = new JLabel("Polyclinic Name");
		labelClinic.setHorizontalAlignment(SwingConstants.LEFT);
		labelClinic.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
		labelClinic.setBounds(289, 10, 173, 30);
		clinicpanel.add(labelClinic);
		
		textFieldClinic = new JTextField();
		textFieldClinic.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		textFieldClinic.setColumns(10);
		textFieldClinic.setBounds(289, 39, 173, 30);
		clinicpanel.add(textFieldClinic);
		
		JButton buttonAddClinic = new JButton("Add");
		buttonAddClinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldClinic.getText().length() == 0) {
					Helper.showMessage("fill");
				}else {
					try {
						if(clinic.addClinic(textFieldClinic.getText())) {
							Helper.showMessage("success");
							textFieldClinic.setText(null);
							updateClinicModel();
						}
					} catch (SQLException e1) {e1.printStackTrace();}
				}
			}
		});
		buttonAddClinic.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		buttonAddClinic.setBackground(Color.LIGHT_GRAY);
		buttonAddClinic.setBounds(289, 92, 173, 39);
		clinicpanel.add(buttonAddClinic);
		
		JScrollPane scrollWorker = new JScrollPane();
		scrollWorker.setBounds(472, 10, 233, 423);
		clinicpanel.add(scrollWorker);
		
		tableWorker = new JTable();
		scrollWorker.setViewportView(tableWorker);
		
		JComboBox selectDoctor = new JComboBox();
		selectDoctor.setBounds(289, 329, 173, 39);
		for(int i = 0; i < surgeondoctor.getDoctorList().size(); i++) {
			selectDoctor.addItem(new Item(surgeondoctor.getDoctorList().get(i).getId(), surgeondoctor.getDoctorList().get(i).getName()));
		}
		selectDoctor.addActionListener(e -> {
			JComboBox c = (JComboBox) e.getSource();
			Item item = (Item) c.getSelectedItem();
			System.out.println(item.getKey() + " : " +  item.getValue());
		});
		clinicpanel.add(selectDoctor);
		
		JButton buttonAddWorker = new JButton("Add");
		buttonAddWorker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tableClinic.getSelectedRow();
				if(selectedRow >= 0) {
					String selectedClinic = tableClinic.getModel().getValueAt(selectedRow, 0).toString();
					int selectedClinicID = Integer.parseInt(selectedClinic);
					Item doctorItem = (Item) selectDoctor.getSelectedItem();
					try {
						boolean control = surgeondoctor.addWorker(doctorItem.getKey(), selectedClinicID);
						if(control) {
							Helper.showMessage("success");
							DefaultTableModel clearModel = (DefaultTableModel) tableWorker.getModel();
							clearModel.setRowCount(0);
							for(int i = 0; i < surgeondoctor.getClinicDoctorList(selectedClinicID).size(); i++) {
								workerData[0] = surgeondoctor.getClinicDoctorList(selectedClinicID).get(i).getId();
								workerData[1] = surgeondoctor.getClinicDoctorList(selectedClinicID).get(i).getName();
								workerModel.addRow(workerData);
							}
							tableWorker.setModel(workerModel);
						}else{
							Helper.showMessage("error");
						}
					} catch (SQLException e1) {e1.printStackTrace();}
				}else {
					Helper.showMessage("Please select a polyclinic!");
				}
			}
		});
		buttonAddWorker.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		buttonAddWorker.setBackground(Color.LIGHT_GRAY);
		buttonAddWorker.setBounds(289, 378, 173, 39);
		clinicpanel.add(buttonAddWorker);
		
		JLabel labelClinic_1 = new JLabel("Polyclinic Name");
		labelClinic_1.setHorizontalAlignment(SwingConstants.LEFT);
		labelClinic_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
		labelClinic_1.setBounds(289, 187, 173, 30);
		clinicpanel.add(labelClinic_1);
		
		JButton buttonWorkerSelect = new JButton("Select");
		buttonWorkerSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tableClinic.getSelectedRow();
				if(selectedRow > 0) {
					String selectedClinic = tableClinic.getModel().getValueAt(selectedRow, 0).toString();
					int selectedClinicID = Integer.parseInt(selectedClinic);
					DefaultTableModel clearModel = (DefaultTableModel) tableWorker.getModel();
					clearModel.setRowCount(0);
					
				try {
						for(int i = 0; i < surgeondoctor.getClinicDoctorList(selectedClinicID).size(); i++) {
							workerData[0] = surgeondoctor.getClinicDoctorList(selectedClinicID).get(i).getId();
							workerData[1] = surgeondoctor.getClinicDoctorList(selectedClinicID).get(i).getName();
							workerModel.addRow(workerData);
						}
				} catch (SQLException e1) {e1.printStackTrace();}
				tableWorker.setModel(workerModel);
				}else {
					Helper.showMessage("Please select a polyclinic!");
				}
			}
		});
		buttonWorkerSelect.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		buttonWorkerSelect.setBackground(Color.LIGHT_GRAY);
		buttonWorkerSelect.setBounds(289, 216, 173, 39);
		clinicpanel.add(buttonWorkerSelect);
		
		tabledoctor.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent e) {
				try {
					textFieldUserID.setText(tabledoctor.getValueAt(tabledoctor.getSelectedRow(), 0).toString());
				} catch (Exception ex) {}
			}
		});
		textFieldUserID = new JTextField();
		textFieldUserID.setBounds(522, 345, 162, 30);
		textFieldUserID.setBackground(new Color(192, 192, 192));
		textFieldUserID.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		textFieldUserID.setColumns(10);
		doctormanagementp.add(textFieldUserID);
				
		tabledoctor.getModel().addTableModelListener(new TableModelListener() {
			public void tableChanged(TableModelEvent e) {
				if(e.getType() == TableModelEvent.UPDATE) {
					int selectID = Integer.parseInt(tabledoctor.getValueAt(tabledoctor.getSelectedRow(), 0).toString());
					String selectName = tabledoctor.getValueAt(tabledoctor.getSelectedRow(), 1).toString();
					String selectIdno = tabledoctor.getValueAt(tabledoctor.getSelectedRow(), 2).toString();
					String selectPassword = tabledoctor.getValueAt(tabledoctor.getSelectedRow(), 3).toString();
					
					try {
						boolean control = surgeondoctor.updateDoctor(selectID, selectIdno, selectPassword, selectName);
					} catch (SQLException e1) {e1.printStackTrace();}
				}
			}
		});
	}
	public void updateDoctorModel() throws SQLException{
		DefaultTableModel clearModel = (DefaultTableModel) tabledoctor.getModel();
		clearModel.setRowCount(0);
		for(int i = 0 ; i < surgeondoctor.getDoctorList().size(); i++) {
			doctorData[0] = surgeondoctor.getDoctorList().get(i).getId();
			doctorData[1] = surgeondoctor.getDoctorList().get(i).getName();
			doctorData[2] = surgeondoctor.getDoctorList().get(i).getIdno();
			doctorData[3] = surgeondoctor.getDoctorList().get(i).getPassword();
			doctorModel.addRow(doctorData);
		}
	}
		public void updateClinicModel() throws SQLException{
			DefaultTableModel clearModel = (DefaultTableModel) tableClinic.getModel();
			clearModel.setRowCount(0);
			for(int i = 0 ; i < clinic.getClinicList().size(); i++) {
				clinicData[0] = clinic.getClinicList().get(i).getId();
				clinicData[1] = clinic.getClinicList().get(i).getName();
				clinicModel.addRow(clinicData);
			}
	}
}
