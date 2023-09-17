package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Helper.DataBaseConnection;

public class Clinic {
	private int id;
	private String name;

	DataBaseConnection conn = new DataBaseConnection();
	Connection con = conn.conDB();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement ps = null;

	public Clinic(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Clinic() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Clinic> getClinicList() throws SQLException {
		ArrayList<Clinic> list = new ArrayList<>();
		Clinic object;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM clinic");
			while (rs.next()) {
				object = new Clinic();
				object.setId(rs.getInt("id"));
				object.setName(rs.getString("name"));
				list.add(object);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public boolean addClinic(String name) throws SQLException{
		String query = "INSERT INTO clinic" + "(name) VALUES" + "(?)";
		boolean key = false;
		Connection con = conn.conDB();
		try {
			st = con.createStatement();
			ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.executeUpdate();
			key = true;
		} catch (SQLException e) {e.printStackTrace();}
		if(key)	return true;
		else return false;
	}
	public boolean deleteClinic(int id) throws SQLException{
		String query = "DELETE FROM clinic WHERE id = ?";
		boolean key = false;
		Connection con = conn.conDB();
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
	public boolean updateClinic(int id, String name) throws SQLException{
		String query = "UPDATE clinic SET name = ? WHERE id = ?";
		boolean key = false;
		Connection con = conn.conDB();
		try {
			st = con.createStatement();
			ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setInt(2, id);
			ps.executeUpdate();
			key = true;
		} catch (SQLException e) {e.printStackTrace();}
		if(key)	return true;
		else return false;
	}
	public Clinic getFetch(int id) {
		Connection con = conn.conDB();
		Clinic c = new Clinic();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM clinic WHERE id =" + id);
			while(rs.next()) {
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
			}
		} catch (SQLException e) {e.printStackTrace();}
		return c;
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
}