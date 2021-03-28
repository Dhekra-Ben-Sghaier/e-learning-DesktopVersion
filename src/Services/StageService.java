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
import Entity.Postuler_stage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author skander
 */
public class StageService {
    static DataSource ds = DataSource.getInstance();
    
            
      public void ajouter_Offe_Stage(OffreStage S) {

        String req = "insert into offre_stage(Nom_soc,Adr_mail_soc,Adr_soc,Description,Date_pub,Niv_etude,Certificat,Duree,Date_debut,Date_fin,Id_societe,Titre) values (?,?,?,?,?,?,?,?,?,?,?,?)";

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
            ps.setInt(11, S.getId_societe());
            ps.setString(12, S.getTitre());
            ps.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(StageService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void valider_Offe_Stage(OffreStage S) {

        String req = "insert into offre_stage_valide(Id_Stage,Nom_soc,Adr_mail_soc,Adr_soc,Description,Date_pub,Niv_etude,Certificat,Duree,Date_debut,Date_fin,Id_societe,Titre) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = ds.getConnection().prepareStatement(req);
            ps.setInt(1, S.getId_Stage());
            ps.setString(2, S.getNom_soc());
            ps.setString(3, S.getAdr_mail_soc());
            ps.setString(4, S.getAdr_soc());
            ps.setString(5, S.getDescription());
            ps.setDate(6, new java.sql.Date(S.getDate_pub().getTime()));
            ps.setString(7, S.getNiv_etude());
            ps.setString(8, S.getCertificat());            
            ps.setInt(9, S.getDuree());
            ps.setDate(10, new java.sql.Date(S.getDate_debut().getTime()));
            ps.setDate(11, new java.sql.Date(S.getDate_fin().getTime()));
            ps.setInt(12, S.getId_societe());
            ps.setString(13, S.getTitre());
            ps.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(StageService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void ajouter_Postuler_Stage(Postuler_stage S) {

        String req = "insert into postuler_stage(Id_Stage,Id_Societe) values (?,?)";

        try {
            PreparedStatement ps = ds.getConnection().prepareStatement(req);
            
            ps.setInt(1, S.getId_Stage());
            ps.setInt(2, S.getId_user());
            ps.executeUpdate();
            
        }catch (SQLException ex) {
            Logger.getLogger(StageService.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
      
     public static void updateStage(OffreStage S) {      
        String req = "UPDATE offre_stage_valide SET Nom_soc=?,Adr_mail_soc=?,Adr_soc=?,Description=?,Date_pub=?, Niv_etude=?, Certificat=?, Duree=?, Date_debut=?, Date_fin=?, Titre=? WHERE Id_Stage =?";
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
            ps.setString(11, S.getTitre());
            ps.setInt(12, S.getId_Stage());
            ps.executeUpdate();

        } catch (SQLException ex) {
        }
    }
      public static void DeletoffreByID(int id) {
        String req = "DELETE  from offre_stage where  Id_Stage =?";
        try {
            PreparedStatement ps = ds.getConnection().prepareStatement(req);

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
        }
      }
      public static void DeletoffreByID_valide(int id) {
        String req = "DELETE  from offre_stage_valide where  Id_Stage =?";
        try {
            PreparedStatement ps = ds.getConnection().prepareStatement(req);

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
        }
      }

/*public List<OffreStage>  selectstage()
    {
        List<OffreStage> list =new ArrayList<>() ; 
    String req ; 
        req = "SELECT *  FROM offre_stage ";
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req);
             ResultSet result =ste.executeQuery() ; 
            while (result.next()){
            list.add(new OffreStage(result.getInt("Id_Stage"),
                                    result.getString("Nom_soc"),
                                    result.getString("Adr_mail_soc"), 
                                    result.getString("Adr_soc"), 
                                    result.getString("Description"),
                                    result.getDate("Date_pub"), 
                                    result.getString("Niv_etude"),
                                    result.getString("Certificat"), 
                                    result.getInt("Duree"),
                                    result.getDate("Date_debut"),
                                    result.getDate("Date_fin"),
                                    result.getInt("Id_Societe"),
                                    result.getString("Titre"))
                                    
            ); 
            }
            
        } catch (SQLException ex) {
            
        }
    return list ; 
      }*/
}
