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
public class Travail extends Offre {
    private int Id_travail;
    private char Type_contrat;

    public Travail() {
    }

    public Travail(int Id_travail, char Type_contrat, int Id_offre, String Nom_soc, String Adr_mail_soc, String Adr_soc, String Description, Date Date_pub, String Niv_etude, String Certificat) {
        super(Id_offre, Nom_soc, Adr_mail_soc, Adr_soc, Description, Date_pub, Niv_etude, Certificat);
        this.Id_travail = Id_travail;
        this.Type_contrat = Type_contrat;
    }

    public int getId_travail() {
        return Id_travail;
    }

    public char getType_contrat() {
        return Type_contrat;
    }

    public void setId_travail(int Id_travail) {
        this.Id_travail = Id_travail;
    }

    public void setType_contrat(char Type_contrat) {
        this.Type_contrat = Type_contrat;
    }
    
}
