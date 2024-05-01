package metier.theatre;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Genre implements Serializable{
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long idG;
	
	private String nomG;
	@Temporal( TemporalType.DATE )
	private Date dateCreation;
	
	@OneToMany (mappedBy="genre")
	private List<PieceTheatre> pieces;
	
	public Long getIdG() {
		return idG;
	}
	public void setIdG(Long idG) {
		this.idG = idG;
	}
	public String getNomG() {
		return nomG;
	}
	public void setNomG(String nomG) {
		this.nomG = nomG;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public List<PieceTheatre> getPieces() {
		return pieces;
	}
	public void setPieces(List<PieceTheatre> pieces) {
		this.pieces = pieces;
	}
	public Genre(String nomG, Date dateCreation) {
		super();
		this.nomG = nomG;
		this.dateCreation = dateCreation;
	}
	public Genre() {
		super();
	}
	

}
