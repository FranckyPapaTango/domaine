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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cours", catalog = "esic_liferay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cours.findAll", query = "SELECT c FROM Cours c"),
    @NamedQuery(name = "Cours.findByIdCours", query = "SELECT c FROM Cours c WHERE c.idCours = :idCours"),
    @NamedQuery(name = "Cours.findByDateCours", query = "SELECT c FROM Cours c WHERE c.dateCours = :dateCours"),
    @NamedQuery(name = "Cours.findByHeureDeb", query = "SELECT c FROM Cours c WHERE c.heureDeb = :heureDeb"),
    @NamedQuery(name = "Cours.findByHeureFin", query = "SELECT c FROM Cours c WHERE c.heureFin = :heureFin")})
public class Cours extends AbstractEntity implements Serializable 
{

    @Column(name = "JOUR_COURS")
    @Temporal(TemporalType.DATE)
    private Date jourCours;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_COURS")
    private long idCours;
    @Column(name = "DATE_COURS")
    @Temporal(TemporalType.DATE)
    private Date dateCours;
    @Column(name = "HEURE_DEB")
    @Temporal(TemporalType.TIME)
    private Date heureDeb;
    @Column(name = "HEURE_FIN")
    @Temporal(TemporalType.TIME)
    private Date heureFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCours")
    private Collection<Video> videoCollection;
    @Basic(optional = true)
    @JoinColumn(name = "ID_UTILISATEUR", referencedColumnName = "ID_UTILISATEUR")
    @ManyToOne
    private Utilisateur idUtilisateur;
    @JoinColumn(name = "ID_MODULE", referencedColumnName = "ID_MODULE")
    @ManyToOne(optional = false)
    private Module idModule;
    @JoinColumn(name = "ID_SALLE", referencedColumnName = "ID_SALLE")
    @ManyToOne
    private Salle idSalle;

    public Cours() {
    }

    public Cours(long idCours) {
        this.idCours = idCours;
    }

    public Cours(long idCours, Date dateCours, Date heureDeb, Date heureFin) {
        this.idCours = idCours;
        this.dateCours = dateCours;
        this.heureDeb = heureDeb;
        this.heureFin = heureFin;
    }

    public Cours(Module idModule) {
		super();
		this.idModule = idModule;
	}

	public long getIdCours() {
        return idCours;
    }

    public void setIdCours(long idCours) {
        this.idCours = idCours;
    }

    public Date getDateCours() {
        return dateCours;
    }

    public void setDateCours(Date dateCours) {
        this.dateCours = dateCours;
    }

    public Date getHeureDeb() {
        return heureDeb;
    }

    public void setHeureDeb(Date heureDeb) {
        this.heureDeb = heureDeb;
    }

    public Date getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(Date heureFin) {
        this.heureFin = heureFin;
    }

    @XmlTransient
    public Collection<Video> getVideoCollection() {
        return videoCollection;
    }

    public void setVideoCollection(Collection<Video> videoCollection) {
        this.videoCollection = videoCollection;
    }

    public Utilisateur getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Utilisateur idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Module getIdModule() {
        return idModule;
    }

    public void setIdModule(Module idModule) {
        this.idModule = idModule;
    }

    public Salle getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(Salle idSalle) {
        this.idSalle = idSalle;
    }

    

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateCours == null) ? 0 : dateCours.hashCode());
		result = prime * result + ((heureDeb == null) ? 0 : heureDeb.hashCode());
		result = prime * result + ((heureFin == null) ? 0 : heureFin.hashCode());
		result = prime * result + (int) (idCours ^ (idCours >>> 32));
		result = prime * result + ((idModule == null) ? 0 : idModule.hashCode());
		result = prime * result + ((idSalle == null) ? 0 : idSalle.hashCode());
		result = prime * result + ((idUtilisateur == null) ? 0 : idUtilisateur.hashCode());
		result = prime * result + ((videoCollection == null) ? 0 : videoCollection.hashCode());
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
		Cours other = (Cours) obj;
		if (dateCours == null) {
			if (other.dateCours != null)
				return false;
		} else if (!dateCours.equals(other.dateCours))
			return false;
		if (heureDeb == null) {
			if (other.heureDeb != null)
				return false;
		} else if (!heureDeb.equals(other.heureDeb))
			return false;
		if (heureFin == null) {
			if (other.heureFin != null)
				return false;
		} else if (!heureFin.equals(other.heureFin))
			return false;
		if (idCours != other.idCours)
			return false;
		if (idModule == null) {
			if (other.idModule != null)
				return false;
		} else if (!idModule.equals(other.idModule))
			return false;
		if (idSalle == null) {
			if (other.idSalle != null)
				return false;
		} else if (!idSalle.equals(other.idSalle))
			return false;
		if (idUtilisateur == null) {
			if (other.idUtilisateur != null)
				return false;
		} else if (!idUtilisateur.equals(other.idUtilisateur))
			return false;
		if (videoCollection == null) {
			if (other.videoCollection != null)
				return false;
		} else if (!videoCollection.equals(other.videoCollection))
			return false;
		return true;
	}

	@Override
    public String toString() {
        //return "com.esic.module.persistence.model.entities.Cours[ idCours=" + idCours + " ]";
        return "" + idCours;
    }

    public Date getJourCours() {
        return jourCours;
    }

    public void setJourCours(Date jourCours) {
        this.jourCours = jourCours;
    }
    
}
