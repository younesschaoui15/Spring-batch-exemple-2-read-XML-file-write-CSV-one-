package Beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

public class Etudiant {

	@Id
	int id;
	String nom;
	Date date_naissance;
	
	public Etudiant() {	}
	
	public Etudiant(int id, String nom, Date date_naissance) {
		super();
		this.id = id;
		this.nom = nom;
		this.date_naissance = date_naissance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public String getCsvDob() 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(getDate_naissance());
	}
	
	@Override
	public String toString() {
		return "Etudiant > id: "+id+", Nom: "+nom+", Date de naissance : "+getCsvDob();
	}
	
}
