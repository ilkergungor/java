package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Helper.DataBaseConnection;

public class WorkHour {

	private int id, doctorid;
	private String doctorname, workdate, status;

	DataBaseConnection conn = new DataBaseConnection();
	Connection con = conn.conDB();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement ps = null;

	public WorkHour(int id, int doctorid, String doctorname, String workdate, String status) {
		this.id = id;
		this.doctorid = doctorid;
		this.doctorname = doctorname;
		this.workdate = workdate;
		this.status = status;
	}
	public WorkHour() {}
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public int getDoctorid() {return doctorid;}
	public void setDoctorid(int doctorid) {this.doctorid = doctorid;}
	public String getDoctorname() {return doctorname;}
	public void setDoctorname(String doctorname) {this.doctorname = doctorname;}
	public String getWorkdate() {return workdate;}
	public void setWorkdate(String workdate) {this.workdate = workdate;}
	public String getStatus() {return status;}
	public void setStatus(String status) {this.status = status;}
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
			}} catch (SQLException e) {e.printStackTrace();} finally {}return list;}}