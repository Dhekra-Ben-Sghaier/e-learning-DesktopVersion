/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author skander
 */
public class Offre {
    private int Id_offre;
    private String Nom_soc;
    private String Adr_mail_soc;
    private String Adr_soc;
    private String Description;
    private Date Date_pub;
    private String Niv_etude;
    private String Certificat;

    public Offre() {
    }

    public Offre(int Id_offre, String Nom_soc, String Adr_mail_soc, String Adr_soc, String Description, Date Date_pub, String Niv_etude, String Certificat) {
        this.Id_offre = Id_offre;
        this.Nom_soc = Nom_soc;
        this.Adr_mail_soc = Adr_mail_soc;
        this.Adr_soc = Adr_soc;
        this.Description = Description;
        this.Date_pub = Date_pub;
        this.Niv_etude = Niv_etude;
        this.Certificat = Certificat;
    }

    public int getId_offre() {
        return Id_offre;
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

    public void setId_offre(int Id_offre) {
        this.Id_offre = Id_offre;
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

    @Override
    public String toString() {
        return "Offre{" + "Id_offre=" + Id_offre + ", Nom_soc=" + Nom_soc + ", Adr_mail_soc=" + Adr_mail_soc + ", Adr_soc=" + Adr_soc + ", Description=" + Description + ", Date_pub=" + Date_pub + ", Niv_etude=" + Niv_etude + ", Certificat=" + Certificat + '}';
    }
    
}
