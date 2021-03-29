/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
 import Entite.OffreTravail;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Database.DataSource;
import Entite.OffreStage;
import Entite.Postuler_stage;
import Entite.Postuler_travail;
import static service.StageService.ds;

/**
 *
 * @author skander
 */
public class TravailService {
    static DataSource ds = DataSource.getInstance();
            
      public void ajouter_Offe_Travail(OffreTravail S) {

        String req = "insert into offre_travail(Nom_soc,Adr_mail_soc,Adr_soc,Description,Date_pub,Niv_etude,Certificat,Type_contrat,Id_societe,Titre) values (?,?,?,?,?,?,?,?,?,?)";

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
            ps.setInt(9, S.getId_societe());
            ps.setString(10, S.getTitre());
            ps.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(TravailService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void valider_Offe_Travail(OffreTravail S) {

        String req = "insert into offre_travail_valide(Id_travail,Nom_soc,Adr_mail_soc,Adr_soc,Description,Date_pub,Niv_etude,Certificat,Type_contrat,Id_societe,Titre) values (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = ds.getConnection().prepareStatement(req);
            ps.setInt(1, S.getId_Travail());
            ps.setString(2, S.getNom_soc());
            ps.setString(3, S.getAdr_mail_soc());
            ps.setString(4, S.getAdr_soc());
            ps.setString(5, S.getDescription());
            ps.setDate(6, new java.sql.Date(S.getDate_pub().getTime()));
            ps.setString(7, S.getNiv_etude());
            ps.setString(8, S.getCertificat());            
            ps.setString(9, S.getType_contrat());
            ps.setInt(10, S.getId_societe());
            ps.setString(11, S.getTitre());
            ps.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(StageService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void ajouter_Postuler_Travail(Postuler_travail S) {

        String req = "insert into postuler_travail(Id_travail,Id_Societe) values (?,?)";

        try {
            PreparedStatement ps = ds.getConnection().prepareStatement(req);
            
            ps.setInt(1, S.getId_Travail());
            ps.setInt(2, S.getId_user());
            ps.executeUpdate();
            
        }catch (SQLException ex) {
            Logger.getLogger(TravailService.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
      public static void updateTravail(OffreTravail S) {      
        String req = "UPDATE offre_travail_valide SET Nom_soc=?,Adr_mail_soc=?,Adr_soc=?,Description=?,Date_pub=?, Niv_etude=?, Certificat=?, Type_contrat=?, Titre=? WHERE Id_travail=?";
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
            ps.setString(9, S.getTitre());
            ps.setInt(10, S.getId_Travail());
            ps.executeUpdate();

        } catch (SQLException ex) {
        }
    }
      public static void DeletoffreByID(int id) {
        String req = "DELETE  from offre_travail where  Id_travail  =?";
        try {
            PreparedStatement ps = ds.getConnection().prepareStatement(req);

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
        }
      }
       public static void DeletoffreByID_valide(int id) {
        String req = "DELETE  from offre_travail_valide where  Id_travail  =?";
        try {
            PreparedStatement ps = ds.getConnection().prepareStatement(req);

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
        }
      }
   
}
