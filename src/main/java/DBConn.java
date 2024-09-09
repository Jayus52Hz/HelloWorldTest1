import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	private final String serverName = "localhost";
	private final String dbName = "";
	private final String portNumber = "1433";
	private final String instance = "";
	private final String userID = "";
	private final String password = "";

	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + "\\" + instance + ":" + portNumber + ";databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
	}
	public Connection getConnectionW() throws Exception {
		String url = 
		"jdbc:sqlserver://" + serverName + "\\" + instance + ":" + 
		portNumber + ";integratedSecurity=true;databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
		url = 
		"jdbc:sqlserver://" + serverName + ":" + portNumber + 
		";integratedSecurity=true;databaseName=" + dbName;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 return DriverManager.getConnection(url);
		}
	public static void main(String[] args) {
		try {
		System.out.println(new DBConn().getConnectionW());
		} catch (Exception e) {
		e.printStackTrace();
		}
		}


}
