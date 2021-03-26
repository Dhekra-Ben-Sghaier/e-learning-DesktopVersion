/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author skander
 */
public class OffreStage {
    private int Id_Stage;
    private String Nom_soc;
    private String Adr_mail_soc;
    private String Adr_soc;
    private String Description;
    private Date Date_pub;
    private String Niv_etude;
    private String Certificat;
    private int Duree;
    private Date Date_debut;
    private Date Date_fin;
    private int Id_societe;
    private String Titre;

    public OffreStage() {
    }

    public OffreStage(int Id_Stage, String Nom_soc, String Adr_mail_soc, String Adr_soc, String Description, Date Date_pub, String Niv_etude, String Certificat, int Duree, Date Date_debut, Date Date_fin, int Id_societe, String Titre) {
        this.Id_Stage = Id_Stage;
        this.Nom_soc = Nom_soc;
        this.Adr_mail_soc = Adr_mail_soc;
        this.Adr_soc = Adr_soc;
        this.Description = Description;
        this.Date_pub = Date_pub;
        this.Niv_etude = Niv_etude;
        this.Certificat = Certificat;
        this.Duree = Duree;
        this.Date_debut = Date_debut;
        this.Date_fin = Date_fin;
        this.Id_societe=Id_societe;
        this.Titre=Titre;
    }

    public OffreStage(String Nom_soc, String Adr_mail_soc, String Adr_soc, String Description, Date Date_pub, String Niv_etude, String Certificat, int Duree, Date Date_debut, Date Date_fin, int Id_societe, String Titre) {
        this.Nom_soc = Nom_soc;
        this.Adr_mail_soc = Adr_mail_soc;
        this.Adr_soc = Adr_soc;
        this.Description = Description;
        this.Date_pub = Date_pub;
        this.Niv_etude = Niv_etude;
        this.Certificat = Certificat;
        this.Duree = Duree;
        this.Date_debut = Date_debut;
        this.Date_fin = Date_fin;
        this.Id_societe = Id_societe;
        this.Titre =Titre;
    }

    public int getId_Stage() {
        return Id_Stage;
    }

    public String getNom_soc() {
        return Nom_soc;
    }

    public String getAdr_mail_soc() {
        return Adr_mail_soc;
    }

    public String getAdr_soc() {
        return Adr_soc;
    }

    public String getDescription() {
        return Description;
    }

    public Date getDate_pub() {
        return Date_pub;
    }

    public String getNiv_etude() {
        return Niv_etude;
    }

    public String getCertificat() {
        return Certificat;
    }

    public int getDuree() {
        return Duree;
    }

    public Date getDate_debut() {
        return Date_debut;
    }

    public Date getDate_fin() {
        return Date_fin;
    }

    public int getId_societe() {
        return Id_societe;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public void setId_societe(int Id_societe) {
        this.Id_societe = Id_societe;
    }
    

    public void setId_Stage(int Id_Stage) {
        this.Id_Stage = Id_Stage;
    }

    public void setNom_soc(String Nom_soc) {
        this.Nom_soc = Nom_soc;
    }

    public void setAdr_mail_soc(String Adr_mail_soc) {
        this.Adr_mail_soc = Adr_mail_soc;
    }

    public void setAdr_soc(String Adr_soc) {
        this.Adr_soc = Adr_soc;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setDate_pub(Date Date_pub) {
        this.Date_pub = Date_pub;
    }

    public void setNiv_etude(String Niv_etude) {
        this.Niv_etude = Niv_etude;
    }

    public void setCertificat(String Certificat) {
        this.Certificat = Certificat;
    }

    public void setDuree(int Duree) {
        this.Duree = Duree;
    }

    public void setDate_debut(Date Date_debut) {
        this.Date_debut = Date_debut;
    }

    public void setDate_fin(Date Date_fin) {
        this.Date_fin = Date_fin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final OffreStage other = (OffreStage) obj;
        if (this.Id_Stage != other.Id_Stage) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OffreStage{" + "Id_Stage=" + Id_Stage + ", Nom_soc=" + Nom_soc + ", Adr_mail_soc=" + Adr_mail_soc + ", Adr_soc=" + Adr_soc + ", Description=" + Description + ", Date_pub=" + Date_pub + ", Niv_etude=" + Niv_etude + ", Certificat=" + Certificat + ", Duree=" + Duree + ", Date_debut=" + Date_debut + ", Date_fin=" + Date_fin + '}';
    }
    
    
}
