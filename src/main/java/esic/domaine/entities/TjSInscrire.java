/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esic.domaine.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author smallwave
 */
@Entity
@Table(name = "tj_s_inscrire", catalog = "esic_liferay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TjSInscrire.findAll", query = "SELECT t FROM TjSInscrire t"),
    @NamedQuery(name = "TjSInscrire.findByIdCursus", query = "SELECT t FROM TjSInscrire t WHERE t.tjSInscrirePK.idCursus = :idCursus"),
    @NamedQuery(name = "TjSInscrire.findByIdStagiaire", query = "SELECT t FROM TjSInscrire t WHERE t.tjSInscrirePK.idStagiaire = :idStagiaire"),
    @NamedQuery(name = "TjSInscrire.findByFormule", query = "SELECT t FROM TjSInscrire t WHERE t.formule = :formule"),
    @NamedQuery(name = "TjSInscrire.findByTva", query = "SELECT t FROM TjSInscrire t WHERE t.tva = :tva"),
    @NamedQuery(name = "TjSInscrire.findByDateFacture", query = "SELECT t FROM TjSInscrire t WHERE t.dateFacture = :dateFacture")})
public class TjSInscrire extends AbstractEntity implements Serializable
{
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TjSInscrirePK tjSInscrirePK;
    @Column(name = "FORMULE")
    private String formule;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TVA")
    private BigDecimal tva;
    @Column(name = "DATE_FACTURE")
    @Temporal(TemporalType.DATE)
    private Date dateFacture;
    @JoinColumn(name = "ID_STAGIAIRE", referencedColumnName = "ID_STAGIAIRE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Stagiaire stagiaire;
    @JoinColumn(name = "ID_CURSUS", referencedColumnName = "ID_CURSUS", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cursus cursus;

    public TjSInscrire() {
    }

    public TjSInscrire(TjSInscrirePK tjSInscrirePK) {
        this.tjSInscrirePK = tjSInscrirePK;
    }

    public TjSInscrire(long idCursus, long idStagiaire) {
        this.tjSInscrirePK = new TjSInscrirePK(idCursus, idStagiaire);
    }

    public TjSInscrirePK getTjSInscrirePK() {
        return tjSInscrirePK;
    }

    public void setTjSInscrirePK(TjSInscrirePK tjSInscrirePK) {
        this.tjSInscrirePK = tjSInscrirePK;
    }

    public String getFormule() {
        return formule;
    }

    public void setFormule(String formule) {
        this.formule = formule;
    }

    public BigDecimal getTva() {
        return tva;
    }

    public void setTva(BigDecimal tva) {
        this.tva = tva;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public Stagiaire getStagiaire() {
        return stagiaire;
    }

    public void setStagiaire(Stagiaire stagiaire) {
        this.stagiaire = stagiaire;
    }

    public Cursus getCursus() {
        return cursus;
    }

    public void setCursus(Cursus cursus) {
        this.cursus = cursus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tjSInscrirePK != null ? tjSInscrirePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TjSInscrire)) {
            return false;
        }
        TjSInscrire other = (TjSInscrire) object;
        if ((this.tjSInscrirePK == null && other.tjSInscrirePK != null) || (this.tjSInscrirePK != null && !this.tjSInscrirePK.equals(other.tjSInscrirePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "com.esic.module.persistence.model.entities.TjSInscrire[ tjSInscrirePK=" + tjSInscrirePK + " 
        return stagiaire.getIdStagiaire()+"-"+cursus.getIdCursus();
    }
    
}
