package Model;
import Helper.DataBaseConnection;

public class User {
	private int  id;
	String idno, password, type, name;
	DataBaseConnection conn = new DataBaseConnection();
	
	public User(int id, String idno, String password, String type, String name) {
		super();
		this.id = id;
		this.idno = idno;
		this.password = password;
		this.type = type;
		this.name = name;
	}
	public User() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdno() {
		return idno;
	}
	public void setIdno(String idno) {
		this.idno = idno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
