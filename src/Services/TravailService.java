/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
 import Entity.OffreTravail;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Database.DataSource;

/**
 *
 * @author skander
 */
public class TravailService {
    static DataSource ds = DataSource.getInstance();
            
      public void ajouter_Offe_Travail(OffreTravail S) {

        String req = "insert into offre_travail(Nom_soc,Adr_mail_soc,Adr_soc,Description,Date_pub,Niv_etude,Certificat,Type_contrat) values (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = ds.getConnection().prepareStatement(req);

            ps.setString(1, S.getNom_soc());
            ps.setString(2, S.getAdr_mail_soc());
            ps.setString(3, S.getAdr_soc());
            ps.setString(4, S.getDescription());
            ps.setDate(5, new java.sql.Date(S.getDate_pub().getTime()));
            ps.setString(6, S.getNiv_etude());
            ps.setString(7, S.getCertificat());
            ps.setString(8, S.getType_contrat()); 
            ps.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(TravailService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
