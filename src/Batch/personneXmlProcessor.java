package Batch;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import Beans.Etudiant;
import Beans.Personne;

@Service
public class personneXmlProcessor implements ItemProcessor<Personne, Etudiant>{

	public personneXmlProcessor() {	}

	@Override
	public Etudiant process(Personne p) throws Exception 
	{
		Etudiant etudiant = null; 
		LocalDate dob = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(p.getDate_naissance()) );
		long age = ChronoUnit.YEARS.between(dob, LocalDate.now());
		
		if(age < 30)
		{
			etudiant= new Etudiant(p.getId(), p.getNom(), p.getDate_naissance());
			System.out.println(etudiant.toString()+", Age: "+age);
		}
		
		return etudiant;
	}

}
