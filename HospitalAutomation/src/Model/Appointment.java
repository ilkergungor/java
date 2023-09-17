package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DataBaseConnection;

public class Appointment extends User {
	private int id, doctorid, patientid;

	private String doctorname, patientname, appointmentdate;

	public Appointment(int id, String idno, String password, String type, String name, int doctorid,
		int patientid, String doctorname, String patientname, String appointmentdate) {
		super();
		this.doctorid = doctorid;
		this.patientid = patientid;
		this.doctorname = doctorname;
		this.patientname = patientname;
		this.appointmentdate = appointmentdate;
	}

	DataBaseConnection conn = new DataBaseConnection();
	Connection con = conn.conDB();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement ps = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}

	public int getPatientid() {
		return patientid;
	}

	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public String getAppointmentdate() {
		return appointmentdate;
	}

	public void setAppointmentdate(String appointmentdate) {
		this.appointmentdate = appointmentdate;
	}

	public Appointment() {
	}
	public ArrayList<Appointment> getPatientList(int patientid) throws SQLException {
		ArrayList<Appointment> list = new ArrayList<>();
		Appointment object;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM appointment WHERE patientid = " + patientid);
			while (rs.next()) {
				object = new Appointment();
				object.setId(rs.getInt("id"));
				object.setDoctorid(rs.getInt("doctorid"));
				object.setDoctorname(rs.getString("doctorname"));
				object.setPatientid(rs.getInt("patientid"));
				object.setPatientname(rs.getString("patientname"));
				object.setAppointmentdate(rs.getString("appointmentdate"));
				list.add(object);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<Appointment> getDoctorList(int doctorid) throws SQLException {
		ArrayList<Appointment> list = new ArrayList<>();
		Appointment object;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM appointment WHERE doctorid = " + doctorid);
			while (rs.next()) {
				object = new Appointment();
				object.setId(rs.getInt("id"));
				object.setDoctorid(rs.getInt("doctorid"));
				object.setDoctorname(rs.getString("doctorname"));
				object.setPatientid(rs.getInt("patientid"));
				object.setPatientname(rs.getString("patientname"));
				object.setAppointmentdate(rs.getString("appointmentdate"));
				list.add(object);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			st.close();
			rs.close();
			con.close();
		}
		return list;
	}
}
