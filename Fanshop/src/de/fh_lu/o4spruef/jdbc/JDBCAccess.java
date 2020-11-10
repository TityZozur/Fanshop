package de.fh_lu.o4spruef.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class JDBCAccess {
	
	Connection dbConn;
	String dbURL;
	String dbUser;
	String dbPassword;
	String dbSchema;
	String driverName;
	
	public JDBCAccess(){
		this.setDBParams();
		this.createConnection();
		try {
			this.setSchema();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean testConnection(){
		try {
			this.setSchema();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public Connection getConnection(){
		if(this.testConnection()) return dbConn;
		else{
			this.setDBParams();
			this.createConnection();
			try {
				this.setSchema();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			return dbConn;
		}
		//alternativ: isValid() nehmen
		//und setSchema() macht selbst den try
	}
	public void setSchema() throws SQLException{
		String sqlBefehl = "SET SCHEMA " + this.dbSchema;
		System.out.println(sqlBefehl);
		dbConn.createStatement().execute(sqlBefehl);
		System.out.println("JDBC-Schema gesetzt zu " + this.dbSchema);
	}
	public abstract void setDBParams();
//	{
//		dbURL      = "Postgres:db2://143.93.202.3:50000/OUEBDB";
////		dbURL      = "Postgres:db2://localhost:50000/OUEBDBOM";
//		dbUser     = "USER50";
//		dbPassword = "db2users";
//		dbSchema   = "DABA2";
//		driverName = "com.ibm.db2.jcc.DB2Driver";
//	}
	public void createConnection(){
		try {
			Class.forName(driverName);
			System.out.println("JDBC-Treiber für Postgresql erfolgreich geladen");
			dbConn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
			System.out.println("Postgres-Connection erfolgreich aufgebaut");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
