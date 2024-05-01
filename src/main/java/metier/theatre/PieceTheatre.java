package metier.theatre;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pieceth")
public class PieceTheatre implements Serializable {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long CODE;
	
    private String AUTEUR;
    
    private String NOM;
   
    private Genre genre;
    
    

	public PieceTheatre(String aUTEUR, String nOM, Genre genre) {
		super();
		AUTEUR = aUTEUR;
		NOM = nOM;
		this.genre = genre;
	}

	public Long getCODE() {
		return CODE;
	}

	public void setCODE(Long cODE) {
		CODE = cODE;
	}

	public String getAUTEUR() {
		return AUTEUR;
	}

	public void setAUTEUR(String aUTEUR) {
		AUTEUR = aUTEUR;
	}

	public String getNOM() {
		return NOM;
	}

	public void setNOM(String nOM) {
		NOM = nOM;
	}

	public PieceTheatre(Long cODE, String aUTEUR, String nOM) {
		super();
		CODE = cODE;
		AUTEUR = aUTEUR;
		NOM = nOM;
	}

	public PieceTheatre(String aUTEUR, String nOM) {
		super();
		AUTEUR = aUTEUR;
		NOM = nOM;
	}

	public PieceTheatre() {
		super();
	}

	@Override
	public String toString() {
		return "PieceTheatre [CODE=" + CODE + ", AUTEUR=" + AUTEUR + ", NOM=" + NOM + "]";
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
    
	
    
}