/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esic.domaine.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author smallwave
 */
@Entity
@Table(name = "compteur", catalog = "esic_liferay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compteur.findAll", query = "SELECT c FROM Compteur c"),
    @NamedQuery(name = "Compteur.findByIdCompteur", query = "SELECT c FROM Compteur c WHERE c.idCompteur = :idCompteur"),
    @NamedQuery(name = "Compteur.findByTempsCompteur", query = "SELECT c FROM Compteur c WHERE c.tempsCompteur = :tempsCompteur"),
    @NamedQuery(name = "Compteur.findByCours", query = "SELECT c FROM Compteur c WHERE c.cours = :cours")})
public class Compteur extends AbstractEntity implements Serializable 
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_COMPTEUR")
    private long idCompteur;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "TEMPS_COMPTEUR")
    private BigDecimal tempsCompteur;
    @Column(name = "COURS")
    private String cours;
    @JoinColumn(name = "ID_STAGIAIRE", referencedColumnName = "ID_STAGIAIRE")
    @ManyToOne(optional = false)
    private Stagiaire idStagiaire;

    public Compteur() {
    }

    public Compteur(long idCompteur) {
        this.idCompteur = idCompteur;
    }

    public Compteur(long idCompteur, BigDecimal tempsCompteur, String cours) {
        this.idCompteur = idCompteur;
        this.tempsCompteur = tempsCompteur;
        this.cours = cours;
    }

    public long getIdCompteur() {
        return idCompteur;
    }

   

    public BigDecimal getTempsCompteur() {
        return tempsCompteur;
    }

    public void setTempsCompteur(BigDecimal tempsCompteur) {
        this.tempsCompteur = tempsCompteur;
    }

    public String getCours() {
        return cours;
    }

    public void setCours(String cours) {
        this.cours = cours;
    }

    public Stagiaire getIdStagiaire() {
        return idStagiaire;
    }

    public void setIdStagiaire(Stagiaire idStagiaire) {
        this.idStagiaire = idStagiaire;
    }

 


    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cours == null) ? 0 : cours.hashCode());
		result = prime * result + (int) (idCompteur ^ (idCompteur >>> 32));
		result = prime * result + ((idStagiaire == null) ? 0 : idStagiaire.hashCode());
		result = prime * result + ((tempsCompteur == null) ? 0 : tempsCompteur.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compteur other = (Compteur) obj;
		if (cours == null) {
			if (other.cours != null)
				return false;
		} else if (!cours.equals(other.cours))
			return false;
		if (idCompteur != other.idCompteur)
			return false;
		if (idStagiaire == null) {
			if (other.idStagiaire != null)
				return false;
		} else if (!idStagiaire.equals(other.idStagiaire))
			return false;
		if (tempsCompteur == null) {
			if (other.tempsCompteur != null)
				return false;
		} else if (!tempsCompteur.equals(other.tempsCompteur))
			return false;
		return true;
	}

	public void setIdCompteur(long idCompteur) {
		this.idCompteur = idCompteur;
	}

	@Override
    public String toString() {
        return "com.esic.module.persistence.model.entities.Compteur[ idCompteur=" + idCompteur + " ]";
    }
    
}
