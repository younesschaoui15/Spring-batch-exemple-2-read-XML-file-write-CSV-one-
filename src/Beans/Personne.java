package Beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import Adapters.JaxbDateAdapter;

@XmlRootElement(name = "personne")
public class Personne {

	int id;
	String nom;
	Date date_naissance;
	
	public Personne() {	}
	
	public Personne(int id, String nom, Date date_naissance) {
		super();
		this.id = id;
		this.nom = nom;
		this.date_naissance = date_naissance;
	}

	@XmlAttribute(name = "refId")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement(name = "name")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@XmlElement(name = "dob") @XmlJavaTypeAdapter(JaxbDateAdapter.class)
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
		return "Personne > id: "+id+", Nom: "+nom+", Date de naissance : "+getCsvDob();
	}
	
}
