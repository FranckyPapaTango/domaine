/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esic.domaine.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author smallwave
 */
@Embeddable
public class TjSInscrirePK implements Serializable// extends AbstractEntity
{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    
    @Basic(optional = false)
    @Column(name = "ID_CURSUS")
    private long idCursus;
    @Basic(optional = false)
    @Column(name = "ID_STAGIAIRE")
    private long idStagiaire;

    public TjSInscrirePK() {
    }

    public TjSInscrirePK(long idCursus, long idStagiaire) {
        this.idCursus = idCursus;
        this.idStagiaire = idStagiaire;
    }

    public long getIdCursus() {
        return idCursus;
    }

    public void setIdCursus(long idCursus) {
        this.idCursus = idCursus;
    }

    public long getIdStagiaire() {
        return idStagiaire;
    }

    public void setIdStagiaire(long idStagiaire) {
        this.idStagiaire = idStagiaire;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idCursus ^ (idCursus >>> 32));
        result = prime * result + (int) (idStagiaire ^ (idStagiaire >>> 32));
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
        TjSInscrirePK other = (TjSInscrirePK) obj;
        if (idCursus != other.idCursus) {
            return false;
        }
        if (idStagiaire != other.idStagiaire) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "com.esic.module.persistence.model.entities.TjSInscrirePK[ idCursus=" + idCursus + ", idStagiaire=" + idStagiaire + " ]";
    return idStagiaire+"-"+idCursus;
    }

}
