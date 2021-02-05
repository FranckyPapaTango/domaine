/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esic.domaine.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author smallwave
 */
@Entity
@Table(name = "stagiaire", catalog = "esic_liferay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stagiaire.findAll", query = "SELECT s FROM Stagiaire s"),
    @NamedQuery(name = "Stagiaire.findByIdStagiaire", query = "SELECT s FROM Stagiaire s WHERE s.idStagiaire = :idStagiaire"),
    @NamedQuery(name = "Stagiaire.findByNomStagiaire", query = "SELECT s FROM Stagiaire s WHERE s.nomStagiaire = :nomStagiaire"),
    @NamedQuery(name = "Stagiaire.findByPrenomStagiaire", query = "SELECT s FROM Stagiaire s WHERE s.prenomStagiaire = :prenomStagiaire"),
    @NamedQuery(name = "Stagiaire.findBySexeStagiaire", query = "SELECT s FROM Stagiaire s WHERE s.sexeStagiaire = :sexeStagiaire"),
    @NamedQuery(name = "Stagiaire.findByEmailStagiaire", query = "SELECT s FROM Stagiaire s WHERE s.emailStagiaire = :emailStagiaire"),
    @NamedQuery(name = "Stagiaire.findByTelephoneStagiaire", query = "SELECT s FROM Stagiaire s WHERE s.telephoneStagiaire = :telephoneStagiaire"),
    @NamedQuery(name = "Stagiaire.findByDateNaissanceStg", query = "SELECT s FROM Stagiaire s WHERE s.dateNaissanceStg = :dateNaissanceStg"),
    @NamedQuery(name = "Stagiaire.findByAdresseStg", query = "SELECT s FROM Stagiaire s WHERE s.adresseStg = :adresseStg"),
    @NamedQuery(name = "Stagiaire.findByCodePostalStg", query = "SELECT s FROM Stagiaire s WHERE s.codePostalStg = :codePostalStg"),
    @NamedQuery(name = "Stagiaire.findByVilleStg", query = "SELECT s FROM Stagiaire s WHERE s.villeStg = :villeStg"),
    @NamedQuery(name = "Stagiaire.findByDateInscription", query = "SELECT s FROM Stagiaire s WHERE s.dateInscription = :dateInscription"),
    @NamedQuery(name = "Stagiaire.findByMotDePasseStg", query = "SELECT s FROM Stagiaire s WHERE s.motDePasseStg = :motDePasseStg")})
public class Stagiaire extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_STAGIAIRE")
    private long idStagiaire;
    @Basic(optional = false)
    @Column(name = "NOM_STAGIAIRE")
    private String nomStagiaire;
    @Basic(optional = false)
    @Column(name = "PRENOM_STAGIAIRE")
    private String prenomStagiaire;
    @Basic(optional = false)
    @Column(name = "SEXE_STAGIAIRE")
    private String sexeStagiaire;
    @Basic(optional = false)
    @Column(name = "EMAIL_STAGIAIRE")
    private String emailStagiaire;
    @Basic(optional = false)
    @Column(name = "TELEPHONE_STAGIAIRE")
    private String telephoneStagiaire;
    @Basic(optional = false)
    @Column(name = "DATE_NAISSANCE_STG")
    @Temporal(TemporalType.DATE)
    private Date dateNaissanceStg;
    @Basic(optional = false)
    @Column(name = "ADRESSE_STG")
    private String adresseStg;
    @Basic(optional = false)
    @Column(name = "CODE_POSTAL_STG")
    private String codePostalStg;
    @Basic(optional = false)
    @Column(name = "VILLE_STG")
    private String villeStg;
    @Basic(optional = false)
    @Column(name = "DATE_INSCRIPTION")
    @Temporal(TemporalType.DATE)
    private Date dateInscription;
    @Basic(optional = false)
    @Column(name = "MOT_DE_PASSE_STG")
    private String motDePasseStg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStagiaire")
    private Collection<Compteur> compteurCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stagiaire")
    private Collection<TjSInscrire> tjSInscrireCollection;

    public Stagiaire() {
    }

    public Stagiaire(long idStagiaire) {
        this.idStagiaire = idStagiaire;
    }

    public Stagiaire(long idStagiaire, String nomStagiaire, String prenomStagiaire, String sexeStagiaire, String emailStagiaire, String telephoneStagiaire, Date dateNaissanceStg, String adresseStg, String codePostalStg, String villeStg, Date dateInscription, String motDePasseStg) {
        this.idStagiaire = idStagiaire;
        this.nomStagiaire = nomStagiaire;
        this.prenomStagiaire = prenomStagiaire;
        this.sexeStagiaire = sexeStagiaire;
        this.emailStagiaire = emailStagiaire;
        this.telephoneStagiaire = telephoneStagiaire;
        this.dateNaissanceStg = dateNaissanceStg;
        this.adresseStg = adresseStg;
        this.codePostalStg = codePostalStg;
        this.villeStg = villeStg;
        this.dateInscription = dateInscription;
        this.motDePasseStg = motDePasseStg;
    }

    public long getIdStagiaire() {
        return idStagiaire;
    }

    public void setIdStagiaire(long idStagiaire) {
        this.idStagiaire = idStagiaire;
    }

    public String getNomStagiaire() {
        return nomStagiaire;
    }

    public void setNomStagiaire(String nomStagiaire) {
        this.nomStagiaire = nomStagiaire;
    }

    public String getPrenomStagiaire() {
        return prenomStagiaire;
    }

    public void setPrenomStagiaire(String prenomStagiaire) {
        this.prenomStagiaire = prenomStagiaire;
    }

    public String getSexeStagiaire() {
        return sexeStagiaire;
    }

    public void setSexeStagiaire(String sexeStagiaire) {
        this.sexeStagiaire = sexeStagiaire;
    }

    public String getEmailStagiaire() {
        return emailStagiaire;
    }

    public void setEmailStagiaire(String emailStagiaire) {
        this.emailStagiaire = emailStagiaire;
    }

    public String getTelephoneStagiaire() {
        return telephoneStagiaire;
    }

    public void setTelephoneStagiaire(String telephoneStagiaire) {
        this.telephoneStagiaire = telephoneStagiaire;
    }

    public Date getDateNaissanceStg() {
        return dateNaissanceStg;
    }

    public void setDateNaissanceStg(Date dateNaissanceStg) {
        this.dateNaissanceStg = dateNaissanceStg;
    }

    public String getAdresseStg() {
        return adresseStg;
    }

    public void setAdresseStg(String adresseStg) {
        this.adresseStg = adresseStg;
    }

    public String getCodePostalStg() {
        return codePostalStg;
    }

    public void setCodePostalStg(String codePostalStg) {
        this.codePostalStg = codePostalStg;
    }

    public String getVilleStg() {
        return villeStg;
    }

    public void setVilleStg(String villeStg) {
        this.villeStg = villeStg;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getMotDePasseStg() {
        return motDePasseStg;
    }

    public void setMotDePasseStg(String motDePasseStg) {
        this.motDePasseStg = motDePasseStg;
    }

    @XmlTransient
    public Collection<Compteur> getCompteurCollection() {
        return compteurCollection;
    }

    public void setCompteurCollection(Collection<Compteur> compteurCollection) {
        this.compteurCollection = compteurCollection;
    }

    @XmlTransient
    public Collection<TjSInscrire> getTjSInscrireCollection() {
        return tjSInscrireCollection;
    }

    public void setTjSInscrireCollection(Collection<TjSInscrire> tjSInscrireCollection) {
        this.tjSInscrireCollection = tjSInscrireCollection;
    }

    

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresseStg == null) ? 0 : adresseStg.hashCode());
		result = prime * result + ((codePostalStg == null) ? 0 : codePostalStg.hashCode());
		result = prime * result + ((compteurCollection == null) ? 0 : compteurCollection.hashCode());
		result = prime * result + ((dateInscription == null) ? 0 : dateInscription.hashCode());
		result = prime * result + ((dateNaissanceStg == null) ? 0 : dateNaissanceStg.hashCode());
		result = prime * result + ((emailStagiaire == null) ? 0 : emailStagiaire.hashCode());
		result = prime * result + (int) (idStagiaire ^ (idStagiaire >>> 32));
		result = prime * result + ((motDePasseStg == null) ? 0 : motDePasseStg.hashCode());
		result = prime * result + ((nomStagiaire == null) ? 0 : nomStagiaire.hashCode());
		result = prime * result + ((prenomStagiaire == null) ? 0 : prenomStagiaire.hashCode());
		result = prime * result + ((sexeStagiaire == null) ? 0 : sexeStagiaire.hashCode());
		result = prime * result + ((telephoneStagiaire == null) ? 0 : telephoneStagiaire.hashCode());
		result = prime * result + ((tjSInscrireCollection == null) ? 0 : tjSInscrireCollection.hashCode());
		result = prime * result + ((villeStg == null) ? 0 : villeStg.hashCode());
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
		Stagiaire other = (Stagiaire) obj;
		if (adresseStg == null) {
			if (other.adresseStg != null)
				return false;
		} else if (!adresseStg.equals(other.adresseStg))
			return false;
		if (codePostalStg == null) {
			if (other.codePostalStg != null)
				return false;
		} else if (!codePostalStg.equals(other.codePostalStg))
			return false;
		if (compteurCollection == null) {
			if (other.compteurCollection != null)
				return false;
		} else if (!compteurCollection.equals(other.compteurCollection))
			return false;
		if (dateInscription == null) {
			if (other.dateInscription != null)
				return false;
		} else if (!dateInscription.equals(other.dateInscription))
			return false;
		if (dateNaissanceStg == null) {
			if (other.dateNaissanceStg != null)
				return false;
		} else if (!dateNaissanceStg.equals(other.dateNaissanceStg))
			return false;
		if (emailStagiaire == null) {
			if (other.emailStagiaire != null)
				return false;
		} else if (!emailStagiaire.equals(other.emailStagiaire))
			return false;
		if (idStagiaire != other.idStagiaire)
			return false;
		if (motDePasseStg == null) {
			if (other.motDePasseStg != null)
				return false;
		} else if (!motDePasseStg.equals(other.motDePasseStg))
			return false;
		if (nomStagiaire == null) {
			if (other.nomStagiaire != null)
				return false;
		} else if (!nomStagiaire.equals(other.nomStagiaire))
			return false;
		if (prenomStagiaire == null) {
			if (other.prenomStagiaire != null)
				return false;
		} else if (!prenomStagiaire.equals(other.prenomStagiaire))
			return false;
		if (sexeStagiaire == null) {
			if (other.sexeStagiaire != null)
				return false;
		} else if (!sexeStagiaire.equals(other.sexeStagiaire))
			return false;
		if (telephoneStagiaire == null) {
			if (other.telephoneStagiaire != null)
				return false;
		} else if (!telephoneStagiaire.equals(other.telephoneStagiaire))
			return false;
		if (tjSInscrireCollection == null) {
			if (other.tjSInscrireCollection != null)
				return false;
		} else if (!tjSInscrireCollection.equals(other.tjSInscrireCollection))
			return false;
		if (villeStg == null) {
			if (other.villeStg != null)
				return false;
		} else if (!villeStg.equals(other.villeStg))
			return false;
		return true;
	}

	@Override
    public String toString() {
        //return "com.esic.module.persistence.model.entities.Stagiaire[ idStagiaire=" + idStagiaire + " ]";
        return "" + idStagiaire;
    }
    
}
