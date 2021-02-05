/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esic.domaine.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
import javax.persistence.PreRemove;

/**
 *
 * @author smallwave
 */
@Entity
@Table(name = "module", catalog = "esic_liferay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Module.findAll", query = "SELECT m FROM Module m")
    ,
    @NamedQuery(name = "Module.findByIdModule", query = "SELECT m FROM Module m WHERE m.idModule = :idModule")
    ,
    @NamedQuery(name = "Module.findByLibelleModule", query = "SELECT m FROM Module m WHERE m.libelleModule = :libelleModule")
    ,
    @NamedQuery(name = "Module.findByDate", query = "SELECT m FROM Module m WHERE m.dateDansAgenda = :dateDansAgenda")
    ,
    @NamedQuery(name = "Module.findByDuree", query = "SELECT m FROM Module m WHERE m.duree = :duree")})
public class Module extends AbstractEntity implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DUREE")
    private int duree;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MODULE")
    private long idModule;
    @Basic(optional = false)
    @Column(name = "LIBELLE_MODULE")
    private String libelleModule;
    @Column(name = "DATE_DANS_AGENDA")
    @Temporal(TemporalType.DATE)
    private Date dateDansAgenda;
    @Lob
    @Column(name = "DESCRIPTIF_MODULE")
    private String descriptifModule;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "moduleCollection")
    private Collection<Cursus> cursusCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModule")
    private Collection<Cours> coursCollection;

    public Module() {
    }

    public Module(long idModule) {
        this.idModule = idModule;
    }

    public Module(String libelleModule, Date dateDansAgenda, int duree, String descriptifModule,
            Collection<Cursus> cursusCollection, Collection<Cours> coursCollection) {
        super();
        this.libelleModule = libelleModule;
        this.dateDansAgenda = dateDansAgenda;
        this.duree = duree;
        this.descriptifModule = descriptifModule;
        this.cursusCollection = cursusCollection;
        this.coursCollection = coursCollection;
    }

    public long getIdModule() {
        return idModule;
    }

    public void setIdModule(long idModule) {
        this.idModule = idModule;
    }

    public String getLibelleModule() {
        return libelleModule;
    }

    public void setLibelleModule(String libelleModule) {
        this.libelleModule = libelleModule;
    }

    public Date getDateDansAgenda() {
        return dateDansAgenda;
    }

    public void setDateDansAgenda(Date dateDansAgenda) {
        this.dateDansAgenda = dateDansAgenda;
    }

    @XmlTransient
    public Collection<Cursus> getCursusCollection() {
        return cursusCollection;
    }

    public void setCursusCollection(Collection<Cursus> cursusCollection) {
        this.cursusCollection = cursusCollection;
    }

    @XmlTransient
    public Collection<Cours> getCoursCollection() {
        return coursCollection;
    }

    public void setCoursCollection(Collection<Cours> coursCollection) {
        this.coursCollection = coursCollection;
    }

    public String getDescriptifModule() {
        return descriptifModule;
    }

    public void setDescriptifModule(String descriptifModule) {
        this.descriptifModule = descriptifModule;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (this.idModule ^ (this.idModule >>> 32));
        hash = 89 * hash + Objects.hashCode(this.libelleModule);
        hash = 89 * hash + Objects.hashCode(this.dateDansAgenda);
        hash = 89 * hash + this.duree;
        hash = 89 * hash + Objects.hashCode(this.descriptifModule);
        hash = 89 * hash + Objects.hashCode(this.cursusCollection);
        hash = 89 * hash + Objects.hashCode(this.coursCollection);
        return hash;
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
        final Module other = (Module) obj;
        if (this.idModule != other.idModule) {
            return false;
        }
        if (this.duree != other.duree) {
            return false;
        }
        if (!Objects.equals(this.libelleModule, other.libelleModule)) {
            return false;
        }
        if (!Objects.equals(this.descriptifModule, other.descriptifModule)) {
            return false;
        }
        if (!Objects.equals(this.dateDansAgenda, other.dateDansAgenda)) {
            return false;
        }
        if (!Objects.equals(this.cursusCollection, other.cursusCollection)) {
            return false;
        }
        return Objects.equals(this.coursCollection, other.coursCollection);
    }

    @Override
    public String toString() {
       // return "com.esic.module.persistence.model.entities.Module[ idModule=" + idModule + " ]";
        return ""+idModule;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

   @PreRemove
    public void removeModulesFromCursuss() {
        for (Cursus c : this.cursusCollection) {
            c.getModuleCollection().remove(this);
        }
    }

}
