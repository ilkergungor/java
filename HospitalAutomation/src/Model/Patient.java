package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Helper.Helper;

public class Patient extends User{
	Connection con = conn.conDB();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	
	public Patient(int id, String idno, String password, String type, String name) {
		super(id, idno, password, type, name);
	}
	public Patient() {}
	public boolean register(String idno, String password, String name) throws SQLException {
		int key = 0;
		boolean duplicate = false;
		String query = "INSERT INTO user" + "(idno, password, name, type) VALUES" + "(?, ?, ?, ?)";

		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM user WHERE idno = '" + idno + "'");
			while (rs.next()) {
				duplicate = true;
				Helper.showMessage("This ID No is already registered!");
				break;
			}
			if (!duplicate) {
				ps = con.prepareStatement(query);
				ps.setString(1, idno);
				ps.setString(2, password);
				ps.setString(3, name);
				ps.setString(4, "patient");
				ps.executeUpdate();
				key = 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (key == 1)
			return true;
		else
			return false;
	}
	public boolean addAppointment(int doctorid, int patientid, String doctorname, String patientname, String appointmentdate) throws SQLException {
		int key = 0;
		String query = "INSERT INTO appointment" + "(doctorid, doctorname,patientid, patientname, appointmentdate) VALUES" + "(?, ?, ?, ?, ?)";

		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, doctorid);
			ps.setString(2, doctorname);
			ps.setInt(3, patientid);
			ps.setString(4, patientname);
			ps.setString(5, appointmentdate);
			ps.executeUpdate();
			key = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (key == 1)
			return true;
		else
			return false;
	}
	public boolean updateWorkHourStatus(int doctorid, String workdate) throws SQLException {
		int key = 0;
		String query = "UPDATE workhour SET status = ? WHERE doctorid = ? AND workdate = ?";

		try {
			ps = con.prepareStatement(query);
			ps.setString(1, "p");
			ps.setInt(2, doctorid);
			ps.setString(3, workdate);
			ps.executeUpdate();
			key = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (key == 1)
			return true;
		else
			return false;
	}
}
