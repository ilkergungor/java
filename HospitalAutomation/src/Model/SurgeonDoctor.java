package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SurgeonDoctor extends User{
	Connection con = conn.conDB();
	Statement st  = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	
	public SurgeonDoctor(int id, String idno, String password, String type, String name) {
		super(id, idno, password, type, name);}
	public SurgeonDoctor() {
	}
	public ArrayList<User>getDoctorList() throws SQLException{
		ArrayList<User> list = new ArrayList<>();
		User object;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM user WHERE type = 'doctor'");
			while(rs.next()) {
				object = new User(rs.getInt("id"), rs.getString("idno"), rs.getString ("password"), rs.getString ("type"), rs.getString ("name"));
				list.add(object);
			}
		} catch (SQLException e) {e.printStackTrace();
		}finally {}
		return list;
	}
	public ArrayList<User>getClinicDoctorList(int clinicid) throws SQLException{
		ArrayList<User> list = new ArrayList<>();
		User object;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT u.id, u.idno, u.password, u.type, u.name FROM worker w LEFT JOIN user u ON w.userid = u.id WHERE clinicid = " + clinicid);
			while(rs.next()) {
				object = new User(rs.getInt("u.id"), rs.getString("u.idno"), rs.getString ("u.password"), rs.getString ("u.type"), rs.getString ("u.name"));
				list.add(object);
			}
		} catch (SQLException e) {e.printStackTrace();
		}finally {}
		return list;
	}
	public boolean addDoctor(String idno, String password, String name) throws SQLException{
		String query = "INSERT INTO user" + "(idno, password, name, type) VALUES" + "(? ,?, ?, ?)";
		boolean key = false;
		try {
			st = con.createStatement();
			ps = con.prepareStatement(query);
			ps.setString(1, idno);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, "doctor");
			ps.executeUpdate();
			key = true;
		} catch (SQLException e) {e.printStackTrace();}
		if(key)	return true;
		else return false;
	}
	public boolean deleteDoctor(int id) throws SQLException{
		String query = "DELETE FROM user WHERE id = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			key = true;
		} catch (SQLException e) {e.printStackTrace();}
		if(key)	return true;
		else return false;
	}
	public boolean updateDoctor(int id, String idno, String password, String name) throws SQLException{
		String query = "UPDATE user SET name = ?, idno = ?, password = ? WHERE id = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, idno);
			ps.setString(3, password);
			ps.setInt(4, id);
			ps.executeUpdate();
			key = true;
		} catch (SQLException e) {e.printStackTrace();}
		if(key)	return true;
		else return false;
	}
	public boolean addWorker(int clinicid, int userid) throws SQLException{
		String query = "INSERT INTO worker" + "(clinicid, userid) VALUES" + "(?, ?)";
		boolean key = false;
		int count = 0;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM worker WHERE clinicid=" + clinicid + " AND userid=" + userid);
			while(rs.next()) {
				count++;
			}
			if(count ==0 ) {
			ps = con.prepareStatement(query);
			ps.setInt(1, clinicid);
			ps.setInt(2, userid);
			ps.executeUpdate();
		}
			key = true;
		} catch (Exception e) {e.printStackTrace();}
		if(key)	return true;
		else return false;
	}
}
