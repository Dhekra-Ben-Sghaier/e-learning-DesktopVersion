/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.OffreStage;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Database.DataSource;
/**
 *
 * @author skander
 */
public class StageService {
    static DataSource ds = DataSource.getInstance();
            
      public void ajouter_Offe_Stage(OffreStage S) {

        String req = "insert into offre_stage(Nom_soc,Adr_mail_soc,Adr_soc,Description,Date_pub,Niv_etude,Certificat,Duree,Date_debut,Date_fin) values (?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = ds.getConnection().prepareStatement(req);

            ps.setString(1, S.getNom_soc());
            ps.setString(2, S.getAdr_mail_soc());
            ps.setString(3, S.getAdr_soc());
            ps.setString(4, S.getDescription());
            ps.setDate(5, new java.sql.Date(S.getDate_pub().getTime()));
            ps.setString(6, S.getNiv_etude());
            ps.setString(7, S.getCertificat());            
            ps.setInt(8, S.getDuree());
            ps.setDate(9, new java.sql.Date(S.getDate_debut().getTime()));
            ps.setDate(10, new java.sql.Date(S.getDate_fin().getTime()));
            ps.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(StageService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
     public static void updateStage(OffreStage S) {
        String req = "UPDATE Stage SET Nom_soc=?,Adr_mail_soc=?,Adr_soc=?,Description=?,Date_pub=?, Niv_etude=?, Certificat=?, Duree=?, Date_debut=?, Date_fin=? WHERE Id_stage =?";
        try {
            PreparedStatement ps = ds.getConnection().prepareStatement(req);
            ps.setString(1, S.getNom_soc());
            ps.setString(2, S.getAdr_mail_soc());
            ps.setString(3, S.getAdr_soc());
            ps.setString(4, S.getDescription());
            //ps.setDate(5, S.getDate_pub());
            ps.setString(6, S.getNiv_etude());
            ps.setString(7, S.getCertificat());
            ps.setInt(8, S.getDuree());
            //ps.setDate(9, S.getDate_debut());
            //ps.setDate(10, S.getDate_fin());
            ps.executeUpdate();

        } catch (SQLException ex) {
        }
    }
      public static void DeletoffreByID(int id) {
        String req = "DELETE  from Stage where  Id_stage =?";
        try {
            PreparedStatement ps = ds.getConnection().prepareStatement(req);

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
        }
      }
    
}
