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
public class Stage extends Offre{
    private int Id_stage;
    private int Duree;
    private Date Date_debut;
    private Date Date_fin;

    public Stage() {
    }

    public Stage(int Id_stage, int Duree, Date Date_debut, Date Date_fin, int Id_offre, String Nom_soc, String Adr_mail_soc, String Adr_soc, String Description, Date Date_pub, String Niv_etude, String Certificat) {
        super(Id_offre, Nom_soc, Adr_mail_soc, Adr_soc, Description, Date_pub, Niv_etude, Certificat);
        this.Id_stage = Id_stage;
        this.Duree = Duree;
        this.Date_debut = Date_debut;
        this.Date_fin = Date_fin;
    }

    public void setId_stage(int Id_stage) {
        this.Id_stage = Id_stage;
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

    public int getId_stage() {
        return Id_stage;
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

    @Override
    public String toString() {
        return "Stage{" + "Id_stage=" + Id_stage + ", Duree=" + Duree + ", Date_debut=" + Date_debut + ", Date_fin=" + Date_fin + '}';
    }

   
    
    
}
