package fr.noixcoop.nuceus.technique;

import java.sql.*;

public class ConnexionBD {
	private static final String dbURL = "jdbc:mysql://localhost/noixcoop" ;
	private static final String user = "noixcoop" ;
	private static final String password = "noixcoop" ;
	private static Connection connexion = null ;
	
	private ConnexionBD() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance() ;
			connexion = DriverManager.getConnection(dbURL,user,password) ;
		}
		catch(Exception e){
			System.out.println(e);
			System.out.println("Erreur BD") ;
		}
	}
	
	public static Connection getConnexion(){
		if(connexion == null){
			new ConnexionBD() ;
		}
		return connexion ;
	}
}