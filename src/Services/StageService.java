/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Database.DataSource;
import Entity.Offre;
import java.sql.Date;
/**
 *
 * @author skander
 */
public class StageService {
    static DataSource ds = DataSource.getInstance();
            
      public void ajouter_Offe_Stage(Stage S) {

        String req = "insert into Stage(Nom_soc,Adr_mail_soc,Adr_soc,Description,Date_pub,Niv_etude,Certificat,Id_stage,Duree,Date_debut) values (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = ds.getConnection().prepareStatement(req);

            ps.setString(1, S.getNom_soc());
            ps.setString(2, S.getAdr_mail_soc());
            ps.setString(3, S.getAdr_soc());
            ps.setString(4, S.getDescription());
            ps.setDate(5, (Date) S.getDate_pub());
            ps.setString(6, S.getNiv_etude());
            ps.setString(7, S.getCertificat());
            ps.setInt(8, S.getId_stage());
            ps.setInt(9, S.getDuree());
            ps.setDate(10, (Date) S.getDate_debut());
            ps.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(StageService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
     public static void updateStage(Stage S) {
        String req = "UPDATE Stage SET Nom_soc=?,Adr_mail_soc=?,Adr_soc=?,Description=?,Date_pub=?, Niv_etude=?, Certificat=?, Duree=?, Date_debut=? WHERE Id_stage =?";
        try {
            PreparedStatement ps = ds.getConnection().prepareStatement(req);
            ps.setString(1, S.getNom_soc());
            ps.setString(2, S.getAdr_mail_soc());
            ps.setString(3, S.getAdr_soc());
            ps.setString(4, S.getDescription());
            ps.setDate(5, (Date) S.getDate_pub());
            ps.setString(6, S.getNiv_etude());
            ps.setString(7, S.getCertificat());
            ps.setInt(8, S.getId_stage());
            ps.setInt(9, S.getDuree());
            ps.setDate(10, (Date) S.getDate_debut());
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
