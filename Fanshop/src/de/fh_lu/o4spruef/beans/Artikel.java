package de.fh_lu.o4spruef.beans;

public class Artikel {
	int anr;
	String aname;
	double preis;

	public String toKaestchen(){
		String html = 
				"<input type='checkbox' name='artikel' value='" +
				this.getAnr() +
				"' />" +
				this.getAname() +
				", EUR " +
				this.getPreis() +
				" <img src='../img/" +
				this.getAnr() +
				".jpg' /><br />\n";
		System.out.println(html);
		return html;
	}
	public int getAnr() {
		return anr;
	}
	public void setAnr(int anr) {
		this.anr = anr;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public double getPreis() {
		return preis;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}
	
}
