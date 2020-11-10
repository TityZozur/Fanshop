package de.fh_lu.o4spruef.beans;

import java.sql.*;
import java.util.*;

import de.fh_lu.o4spruef.jdbc.PostgresAccess;

public class FanshopBean {

	Vector<Artikel> artikelListe;
	
	public FanshopBean() throws SQLException {
		this.artikelListe = new Vector<Artikel>();
		this.getArtikelFromDB();
	}
	
	public boolean bestellungSpeichern(String kunde, String[] bestArt) throws SQLException{
		Connection dbConn = new PostgresAccess().getConnection();
		String sql = "INSERT INTO BESTELLUNG (KUNDE) VALUES (?)";
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setString(1, kunde);
		prep.executeUpdate();
		
		String sql1 = "INSERT INTO BESTART (ANR, BNR) " +
				      "VALUES (?, IDENTITY_VAL_LOCAL())";
		PreparedStatement prep1 = dbConn.prepareStatement(sql1);

		for (String art : bestArt){
			//int anr = Integer.valueOf(art);
			prep1.setString(1, art);
			prep1.executeUpdate();
		}
		return true;
	}
	
	public String getHTMLFromArtikel(){
		String html = "";
		for(Artikel artikel : artikelListe){
			html += artikel.toKaestchen(); 
		}
		return html;
	}
	
	public void getArtikelFromDB() throws SQLException{
		Connection dbConn = new PostgresAccess().getConnection();
		String sql = "SELECT ANR, ANAME, PREIS " +
					"FROM ARTIKEL";
		ResultSet dbRes = dbConn.createStatement().executeQuery(sql);
		while (dbRes.next()){
			Artikel newArtikel = new Artikel();
			newArtikel.setAnr(dbRes.getInt("ANR"));
			newArtikel.setAname(dbRes.getString("ANAME"));
			newArtikel.setPreis(dbRes.getDouble("PREIS"));
			this.artikelListe.add(newArtikel);
		}
	}

	public Vector<Artikel> getArtikelListe() {
		return artikelListe;
	}

	public void setArtikelListe(Vector<Artikel> artikelListe) {
		this.artikelListe = artikelListe;
	}

	
}
