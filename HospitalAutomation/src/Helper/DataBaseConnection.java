package Helper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	Connection c = null;
	
	public DataBaseConnection() {
	}
	public Connection conDB() {
		try {
			this.c = DriverManager.getConnection("jdbc:mariadb://localhost:9510/hospital?user=root&password=12345678");
			return c;
		} catch (SQLException e) {e.printStackTrace();}
		return c;
	}
}
