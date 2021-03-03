/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esic.domaine.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author smallwave
 */
@Entity
@Table(name = "video", catalog = "esic_liferay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Video.findAll", query = "SELECT v FROM Video v"),
    @NamedQuery(name = "Video.findByIdVideo", query = "SELECT v FROM Video v WHERE v.idVideo = :idVideo"),
    @NamedQuery(name = "Video.findByLien", query = "SELECT v FROM Video v WHERE v.lien = :lien")})
@NamedNativeQueries({
    @NamedNativeQuery(name = "Video.findByKeyWord",
    query = "SELECT * FROM Video WHERE lien LIKE CONCAT('%',:search,'%')",
    resultClass = Video.class)
})
public class Video extends AbstractEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_VIDEO")
    private long idVideo;
    @Basic(optional = false)
    @Column(name = "LIEN")
    private String lien;
    @JoinColumn(name = "ID_COURS", referencedColumnName = "ID_COURS")
    @ManyToOne(optional = false)
    private Cours idCours;

    public Video() {
    }

    public Video(long idVideo) {
        this.idVideo = idVideo;
    }

    public Video(long idVideo, String lien) {
        this.idVideo = idVideo;
        this.lien = lien;
    }
      
    
    public Video(String lien, Cours idCours) {
		super();
		this.lien = lien;
		this.idCours = idCours;
	}

	public Video(String lien) {
        this.lien = lien;
    }

    public long getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(long idVideo) {
        this.idVideo = idVideo;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public Cours getIdCours() {
        return idCours;
    }

    public void setIdCours(Cours idCours) {
        this.idCours = idCours;
    }

    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCours == null) ? 0 : idCours.hashCode());
		result = prime * result + (int) (idVideo ^ (idVideo >>> 32));
		result = prime * result + ((lien == null) ? 0 : lien.hashCode());
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
		Video other = (Video) obj;
		if (idCours == null) {
			if (other.idCours != null)
				return false;
		} else if (!idCours.equals(other.idCours))
			return false;
		if (idVideo != other.idVideo)
			return false;
		if (lien == null) {
			if (other.lien != null)
				return false;
		} else if (!lien.equals(other.lien))
			return false;
		return true;
	}

	@Override
    public String toString() {
        //return "com.esic.module.persistence.model.entities.Video[ idVideo=" + idVideo + " ]";
        return ""+idVideo;
    }
    
}
