/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esic.domaine.entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author smallwave
 */
@Entity
@Table(name = "salle", catalog = "esic_liferay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salle.findAll", query = "SELECT s FROM Salle s"),
    @NamedQuery(name = "Salle.findByIdSalle", query = "SELECT s FROM Salle s WHERE s.idSalle = :idSalle"),
    @NamedQuery(name = "Salle.findByLibelleSalle", query = "SELECT s FROM Salle s WHERE s.libelleSalle = :libelleSalle"),
    @NamedQuery(name = "Salle.findByNombrePlaces", query = "SELECT s FROM Salle s WHERE s.nombrePlaces = :nombrePlaces")})
public class Salle extends AbstractEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SALLE")
    private long idSalle;
    @Basic(optional = false)
    @Column(name = "LIBELLE_SALLE")
    private String libelleSalle;
    @Column(name = "NOMBRE_PLACES")
    private Integer nombrePlaces;
    @OneToMany(mappedBy = "idSalle")
    private Collection<Cours> coursCollection;

    public Salle() {
    }

    public Salle(long idSalle) {
        this.idSalle = idSalle;
    }

    public Salle(long idSalle, String libelleSalle) {
        this.idSalle = idSalle;
        this.libelleSalle = libelleSalle;
    }

    public long getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(long idSalle) {
        this.idSalle = idSalle;
    }

    public String getLibelleSalle() {
        return libelleSalle;
    }

    public void setLibelleSalle(String libelleSalle) {
        this.libelleSalle = libelleSalle;
    }

    public Integer getNombrePlaces() {
        return nombrePlaces;
    }

    public void setNombrePlaces(Integer nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }

    @XmlTransient
    public Collection<Cours> getCoursCollection() {
        return coursCollection;
    }

    public void setCoursCollection(Collection<Cours> coursCollection) {
        this.coursCollection = coursCollection;
    }

    

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coursCollection == null) ? 0 : coursCollection.hashCode());
		result = prime * result + (int) (idSalle ^ (idSalle >>> 32));
		result = prime * result + ((libelleSalle == null) ? 0 : libelleSalle.hashCode());
		result = prime * result + ((nombrePlaces == null) ? 0 : nombrePlaces.hashCode());
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
		Salle other = (Salle) obj;
		if (coursCollection == null) {
			if (other.coursCollection != null)
				return false;
		} else if (!coursCollection.equals(other.coursCollection))
			return false;
		if (idSalle != other.idSalle)
			return false;
		if (libelleSalle == null) {
			if (other.libelleSalle != null)
				return false;
		} else if (!libelleSalle.equals(other.libelleSalle))
			return false;
		if (nombrePlaces == null) {
			if (other.nombrePlaces != null)
				return false;
		} else if (!nombrePlaces.equals(other.nombrePlaces))
			return false;
		return true;
	}

	@Override
    public String toString() {
        //return "com.esic.module.persistence.model.entities.Salle[ idSalle=" + idSalle + " ]";
        return "" + idSalle;
    }
    
}
