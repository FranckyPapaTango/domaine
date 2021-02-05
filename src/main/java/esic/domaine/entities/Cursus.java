/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esic.domaine.entities;

import java.io.Serializable;
import java.text.ParseException;
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
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import esic.domaine.tools.Validateur;

/**
 *
 * @author smallwave
 */
@Entity
@Table(name = "cursus", catalog = "esic_liferay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cursus.findAll", query = "SELECT c FROM Cursus c"),
    @NamedQuery(name = "Cursus.findByIdCursus", query = "SELECT c FROM Cursus c WHERE c.idCursus = :idCursus"),
    @NamedQuery(name = "Cursus.findByLibelleCursus", query = "SELECT c FROM Cursus c WHERE c.libelleCursus = :libelleCursus"),
    @NamedQuery(name = "Cursus.findByAnnee", query = "SELECT c FROM Cursus c WHERE c.annee = :annee"),
    @NamedQuery(name = "Cursus.findByDateDeb", query = "SELECT c FROM Cursus c WHERE c.dateDeb = :dateDeb"),
    @NamedQuery(name = "Cursus.findByDateFin", query = "SELECT c FROM Cursus c WHERE c.dateFin = :dateFin")})
public class Cursus extends AbstractEntity implements Serializable {

    @Column(name = "ANNEE")
    private Integer annee;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CURSUS")
    private long idCursus;
    @Basic(optional = false)
    @Column(name = "LIBELLE_CURSUS")
    private String libelleCursus;
    @Column(name = "DATE_DEB")
    @Temporal(TemporalType.DATE)
    private Date dateDeb;
    @Column(name = "DATE_FIN")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @Basic(optional = false)
    @Lob
    @Column(name = "DETAIL")
    private String detail;
    @Basic(optional = true)
    @Column(name = "PAYPAL_ID")
    private String paypalId;
    @Basic(optional = true)
    @Column(name = "PRIX1")
    private int prix1;
    @Basic(optional = true)
    @Column(name = "PRIX2")
    private int prix2;

    @JoinTable(name = "tj_composer", joinColumns = {
        @JoinColumn(name = "ID_CURSUS", referencedColumnName = "ID_CURSUS")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_MODULE", referencedColumnName = "ID_MODULE")})
    @ManyToMany (cascade = {CascadeType.MERGE ,CascadeType.PERSIST})
    private Collection<Module> moduleCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cursus")
    private Collection<TjSInscrire> tjSInscrireCollection;

    public Cursus() {
    }

    public Cursus(long idCursus) {
        this.idCursus = idCursus;
    }

    public Cursus(String libelleCursus, int annee, Date dateDeb, Date dateFin, String detail,
            Collection<Module> moduleCollection, Collection<TjSInscrire> tjSInscrireCollection) {
        super();
        this.libelleCursus = libelleCursus;
        this.annee = annee;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.detail = detail;
        this.moduleCollection = moduleCollection;
        this.tjSInscrireCollection = tjSInscrireCollection;
    }

    // CONSTRUCTEUR FULL
    public Cursus(String libelleCursus, int annee, Date dateDeb, Date dateFin, String detail, String paypalId, int prix1, int prix2, Collection<Module> moduleCollection, Collection<TjSInscrire> tjSInscrireCollection) {
        this.libelleCursus = libelleCursus;
        this.annee = annee;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.detail = detail;
        this.paypalId = paypalId;
        this.prix1 = prix1;
        this.prix2 = prix2;
        this.moduleCollection = moduleCollection;
        this.tjSInscrireCollection = tjSInscrireCollection;
    }

    public long getIdCursus() {
        return idCursus;
    }

    public void setIdCursus(long idCursus) {
        this.idCursus = idCursus;
    }

    public String getLibelleCursus() {
        return libelleCursus;
    }

    public void setLibelleCursus(String libelleCursus) {
        this.libelleCursus = libelleCursus;
    }

    public Date getDateDeb() {
        return dateDeb;
    }

    public void setDateDeb(Date dateDeb) {
        this.dateDeb = dateDeb;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPaypalId() {
        return paypalId;
    }

    public void setPaypalId(String paypalId) {
        this.paypalId = paypalId;
    }

    public int getPrix1() {
        return prix1;
    }

    public void setPrix1(int prix1) {
        this.prix1 = prix1;
    }

    public int getPrix2() {
        return prix2;
    }

    public void setPrix2(int prix2) {
        this.prix2 = prix2;
    }

    @XmlTransient
    public Collection<Module> getModuleCollection() {
        return moduleCollection;
    }

    public void setModuleCollection(Collection<Module> moduleCollection) {
        this.moduleCollection = moduleCollection;
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
        result = prime * result + annee;
        result = prime * result + ((dateDeb == null) ? 0 : dateDeb.hashCode());
        result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
        result = prime * result + ((detail == null) ? 0 : detail.hashCode());
        result = prime * result + (int) (idCursus ^ (idCursus >>> 32));
        result = prime * result + ((libelleCursus == null) ? 0 : libelleCursus.hashCode());
        result = prime * result + ((moduleCollection == null) ? 0 : moduleCollection.hashCode());
        result = prime * result + ((tjSInscrireCollection == null) ? 0 : tjSInscrireCollection.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Cursus other = (Cursus) obj;
        if (annee != other.annee) {
            return false;
        }
        if (dateDeb == null) {
            if (other.dateDeb != null) {
                return false;
            }
        } else if (!dateDeb.equals(other.dateDeb)) {
            return false;
        }
        if (dateFin == null) {
            if (other.dateFin != null) {
                return false;
            }
        } else if (!dateFin.equals(other.dateFin)) {
            return false;
        }
        if (detail == null) {
            if (other.detail != null) {
                return false;
            }
        } else if (!detail.equals(other.detail)) {
            return false;
        }
        if (idCursus != other.idCursus) {
            return false;
        }
        if (libelleCursus == null) {
            if (other.libelleCursus != null) {
                return false;
            }
        } else if (!libelleCursus.equals(other.libelleCursus)) {
            return false;
        }
        if (moduleCollection == null) {
            if (other.moduleCollection != null) {
                return false;
            }
        } else if (!moduleCollection.equals(other.moduleCollection)) {
            return false;
        }
        if (tjSInscrireCollection == null) {
            if (other.tjSInscrireCollection != null) {
                return false;
            }
        } else if (!tjSInscrireCollection.equals(other.tjSInscrireCollection)) {
            return false;
        }
        return true;
    }

	@Override
    public String toString() {
        return ""+ idCursus ;
    }
//    @Override
//    public String toString() {
//        return "Cursus{" + "libelleCursus=" + libelleCursus + ", annee=" + annee + ", dateDeb=" + dateDeb + ", dateFin=" + dateFin + ", detail=" + detail + ", paypalId=" + paypalId + ", prix1=" + prix1 + ", prix2=" + prix2 + '}';
//    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

}
