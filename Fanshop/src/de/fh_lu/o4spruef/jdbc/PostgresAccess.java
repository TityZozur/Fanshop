package de.fh_lu.o4spruef.jdbc;

public class PostgresAccess extends JDBCAccess {

	public void setDBParams(){
		dbURL  		= "jdbc:postgresql://127.0.0.1:5432/webDB";
		dbUser 		= "postgres";
		dbPassword  = "mydb";
		dbSchema	= "S622691" ;
		driverName = "org.postgresql.Driver";
	}

	public static void main(String[] args) {
		new PostgresAccess();	
	}

}
