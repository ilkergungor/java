package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Doctor extends User {
	Connection con = conn.conDB();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement ps = null;

	public Doctor(int id, String idno, String password, String type, String name) {
		super(id, idno, password, type, name);
	}

	public Doctor() {
	}

	public boolean addWorkHour(int doctorid, String doctorname, String workdate) throws SQLException {
		int key = 0;
		int count = 0;
		String query = "INSERT INTO workhour" + "(doctorid, doctorname, workdate) VALUES" + "(?, ?, ?)";

		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT *FROM workhour WHERE status = 'a' AND doctorid = " + doctorid
					+ " AND workdate ='" + workdate + "'");
			while (rs.next()) {
				count++;
				break;
			}
			if (count == 0) {
				ps = con.prepareStatement(query);
				ps.setInt(1, doctorid);
				ps.setString(2, doctorname);
				ps.setString(3, workdate);
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

	public ArrayList<WorkHour> getWorkHourList(int doctorid) throws SQLException {
		ArrayList<WorkHour> list = new ArrayList<>();
		WorkHour object;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM workhour WHERE status = 'a' AND doctorid = " + doctorid);
			while (rs.next()) {
				object = new WorkHour();
				object.setId(rs.getInt("id"));
				object.setDoctorid(rs.getInt("doctorid"));
				object.setDoctorname(rs.getString("doctorname"));
				object.setStatus(rs.getString("status"));
				object.setWorkdate(rs.getString("workdate"));
				list.add(object);
			}
		} catch (SQLException e) {e.printStackTrace();} finally {}
		return list;
	}

	public boolean deleteWorkHour(int id) throws SQLException {
		String query = "DELETE FROM workhour WHERE id = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			key = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (key)
			return true;
		else
			return false;
	}
}
