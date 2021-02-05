/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esic.domaine.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;
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
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author smallwave
 */
@Entity
@Table(name = "utilisateur", catalog = "esic_liferay", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u"),
    @NamedQuery(name = "Utilisateur.findByIdUtilisateur", query = "SELECT u FROM Utilisateur u WHERE u.idUtilisateur = :idUtilisateur"),
    @NamedQuery(name = "Utilisateur.findByFonction", query = "SELECT u FROM Utilisateur u WHERE u.fonction = :fonction"),
    @NamedQuery(name = "Utilisateur.findBySexe", query = "SELECT u FROM Utilisateur u WHERE u.sexe = :sexe"),
    @NamedQuery(name = "Utilisateur.findByNomUtilisateur", query = "SELECT u FROM Utilisateur u WHERE u.nomUtilisateur = :nomUtilisateur"),
    @NamedQuery(name = "Utilisateur.findByPrenomUtilisateur", query = "SELECT u FROM Utilisateur u WHERE u.prenomUtilisateur = :prenomUtilisateur"),
    @NamedQuery(name = "Utilisateur.findByIsActive", query = "SELECT u FROM Utilisateur u WHERE u.isActive = :isActive"),
    @NamedQuery(name = "Utilisateur.findByEmail", query = "SELECT u FROM Utilisateur u WHERE u.email = :email"),
    @NamedQuery(name = "Utilisateur.findByTelephone", query = "SELECT u FROM Utilisateur u WHERE u.telephone = :telephone"),
    @NamedQuery(name = "Utilisateur.findByAdresse", query = "SELECT u FROM Utilisateur u WHERE u.adresse = :adresse"),
    @NamedQuery(name = "Utilisateur.findByCodePostal", query = "SELECT u FROM Utilisateur u WHERE u.codePostal = :codePostal"),
    @NamedQuery(name = "Utilisateur.findByVille", query = "SELECT u FROM Utilisateur u WHERE u.ville = :ville"),
    @NamedQuery(name = "Utilisateur.findByMotDePasse", query = "SELECT u FROM Utilisateur u WHERE u.motDePasse = :motDePasse")})
public class Utilisateur extends AbstractEntity implements Serializable{

    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_UTILISATEUR")
    private long idUtilisateur;
    @Basic(optional = false)
    @Column(name = "FONCTION")
    private String fonction;
    @Basic(optional = false)
    @Column(name = "SEXE")
    private String sexe;
    @Basic(optional = false)
    @Column(name = "NOM_UTILISATEUR")
    private String nomUtilisateur;
    @Basic(optional = false)
    @Column(name = "PRENOM_UTILISATEUR")
    private String prenomUtilisateur;
    @Column(name = "IS_ACTIVE")
    private Boolean isActive;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "TELEPHONE")
    private String telephone;
    @Basic(optional = false)
    @Column(name = "ADRESSE")
    private String adresse;
    @Basic(optional = false)
    @Column(name = "CODE_POSTAL")
    private String codePostal;
    @Basic(optional = false)
    @Column(name = "VILLE")
    private String ville;
    @Basic(optional = false)
    @Column(name = "MOT_DE_PASSE")
    private String motDePasse;
    @OneToMany(mappedBy = "idUtilisateur")
    private Collection<Cours> coursCollection;

    public Utilisateur() {
    }

    public Utilisateur(long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Utilisateur(long idUtilisateur, String fonction, String sexe, String nomUtilisateur, String prenomUtilisateur, boolean isActive, String email, String telephone, String adresse, String codePostal, String ville, String motDePasse) {
        this.idUtilisateur = idUtilisateur;
        this.fonction = fonction;
        this.sexe = sexe;
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.isActive = isActive;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.motDePasse = motDePasse;
    }

    public long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
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
        int hash = 7;
        hash = 89 * hash + (int) (this.idUtilisateur ^ (this.idUtilisateur >>> 32));
        hash = 89 * hash + Objects.hashCode(this.nomUtilisateur);
        hash = 89 * hash + Objects.hashCode(this.prenomUtilisateur);
        hash = 89 * hash + Objects.hashCode(this.motDePasse);
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
        final Utilisateur other = (Utilisateur) obj;
        if (this.idUtilisateur != other.idUtilisateur) {
            return false;
        }
        if (!Objects.equals(this.nomUtilisateur, other.nomUtilisateur)) {
            return false;
        }
        if (!Objects.equals(this.prenomUtilisateur, other.prenomUtilisateur)) {
            return false;
        }
        if (!Objects.equals(this.motDePasse, other.motDePasse)) {
            return false;
        }
        return true;
    }

    



	@Override
    public String toString() {
        //return "com.esic.module.persistence.model.entities.Utilisateur[ idUtilisateur=" + idUtilisateur + " ]";
        return "" + idUtilisateur ;
    }



   @PreRemove
    public void removeUtilisateursFromCourss() {
       for (Cours c : this.coursCollection) {
            c.setIdUtilisateur(null);//<=manyToOne different to ManyToMany !!!
         }
    }
   
    
}
