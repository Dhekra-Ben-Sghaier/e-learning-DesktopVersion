/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import controller.SendMail;
import entity.Formation;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import utils.DataSource;

/**
 *
 * @author Asus
 */
public class FormationDao implements Idao<Formation>{
    
    private static FormationDao instance;
    private Statement st;
    private ResultSet rs;

    
    private FormationDao() {
        DataSource cs= DataSource.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(FormationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static FormationDao getInstance(){
        if(instance==null) 
            instance=new FormationDao();
        return instance;
    }
    

    
    @Override
    public void insert(Formation o) {
        
        String urlImage = o.getPathImg().length()>0?o.getPathImg():"C:\\\\xampp\\\\htdocs\\\\img\\\\default.jpg";
        String req = "insert into formation (id,titre,description,prix,difficulte,cours,Image) values ('"+o.getId()+"','"+o.getTitle()+"','"+o.getDescription()
                +"','"+o.getPrix()+"','"+o.getDifficulte()+"', LOAD_FILE('"+o.getPath()+"'),'"+urlImage+"')";
        
        
        System.out.println(req);
        try {
            st.executeUpdate(req);
            Alert alertInf = new Alert(Alert.AlertType.INFORMATION);
            alertInf.setTitle("Information Dialog");
            alertInf.setHeaderText(null);
            alertInf.setContentText("Formation insérée avec succés!");
            alertInf.show();
                        
            TrayNotification tray =new TrayNotification();
            tray.setTitle("Succès");
            tray.setMessage("Formation ajoutée avec succès !");
            tray.setAnimationType(AnimationType.POPUP);
            tray.setNotificationType(NotificationType.INFORMATION);
          
            tray.showAndWait();
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("id deja utilisé!");
            alert.show();
            

        }
    }
    
//    public int verif(int id){
//        int v = 0;
//        String req="select from formation where id="+id;
//        try {
//            
//            v = st.executeUpdate(req);
//            
//            System.out.println("icciiii"+v);
// 
//        } catch (SQLException ex) {
//            
//        }
//        
//        return v;
//    
//        }
//    
    
    public void delete(Formation o) {
        String req="delete from formation where id="+o.getId();
//        Formation f =displayById(o.getId());
//        
//          if(f!=null)
              try {
           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(FormationDao.class.getName()).log(Level.SEVERE, null, ex);}
//        }else System.out.println("la formation n'existe pas");
    }

    @Override
    public List<Formation> displayAll() {
        String req="select * from formation";
        ObservableList<Formation> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Formation f =new Formation();
                f.setId(rs.getInt("id"));
                f.setTitle(rs.getString("titre"));
                f.setDescription(rs.getString("description"));
                f.setPrix(rs.getFloat("prix"));
                f.setDifficulte(rs.getString("difficulte"));
                f.setCertifier(rs.getBoolean("certificat"));
                f.setPath(req);
                list.add(f);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FormationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public List<Formation> display() {
        String req="select id,titre,description,prix,Image from formation";
        ObservableList<Formation> list=FXCollections.observableArrayList();       
        System.out.println(req);
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Formation f =new Formation();
                f.setId(rs.getInt("id"));
                f.setTitle(rs.getString("titre"));
                f.setDescription(rs.getString("description"));
                f.setPrix(rs.getFloat("prix"));
                f.setPathImg(rs.getString("Image"));
                
                list.add(f);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FormationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public void insertAchat(int idUser, int id){
        System.out.println(id);
        System.out.println(idUser);
        String req = "insert into achat (id_user, id) values ("+idUser+","+id+")";
        
        System.out.println("achat inseré");
        System.out.println(req);
                try {
            st.executeUpdate(req);
            SendMail.sendMail("dhekra.bensghaier@esprit.tn", "", "Paiement de la formation a été effectué avec succès! \n Vous pouvez commencer maintenant votre formation.");
                    
            TrayNotification tray =new TrayNotification();
            tray.setTitle("Succès");
            tray.setMessage("Paiement effectué avec succès !");
            tray.setAnimationType(AnimationType.POPUP);
            tray.setNotificationType(NotificationType.INFORMATION);
          
            tray.showAndWait();
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("vous avez déjà payé pour cette formation!");
            alert.show();
        }
        
    }

    
    @Override
    public List<Formation> displayAllById(int id) {
        ObservableList<Formation> list=FXCollections.observableArrayList();  
        String req="SELECT * from formation f , achat a WHERE f.id = a.id AND a.id_user = 1";
        
        
        try {
            
            rs=st.executeQuery(req);
            while(rs.next()){
                Formation f =new Formation();
                f.setId(rs.getInt("id"));
                f.setTitle(rs.getString("titre"));
                f.setDescription(rs.getString("description"));
                f.setPrix(rs.getFloat("prix"));
                f.setDifficulte(rs.getString("difficulte"));
                f.setCertifier(rs.getBoolean("certificat"));
                f.setPath(req);
                list.add(f);
            }    
        } catch (SQLException ex) {
            Logger.getLogger(FormationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    
    public Formation affFormation(int id){
        String req = "SELECT * from formation f WHERE f.id ="+id; 
        Formation f =new Formation();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                f.setTitle(rs.getString("titre"));
                f.setDescription(rs.getString("description"));
                f.setDifficulte(rs.getString("difficulte"));
  
                try {
			
		InputStream input = null; 	
		File theFile = new File("Cours "+ rs.getString("titre")+".pdf");
                FileOutputStream output = new FileOutputStream(theFile);
                input = rs.getBinaryStream("cours");
		System.out.println("Reading cours from database...");
		System.out.println(req);
		byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					output.write(buffer);
				}
				
				System.out.println("\nSaved to file: " + theFile.getAbsolutePath());
				
				System.out.println("\nCompleted successfully!");				


		} catch (Exception exc) {
			exc.printStackTrace();
		}
                f.setPath(req);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FormationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
        
    }
    
    
    @Override
    public boolean update(Formation f) {
        String qry = "UPDATE formation SET titre = '"+f.getTitle()+"' , description = '"+f.getDescription()+"', prix = "+f.getPrix()+" , difficulte = '"+f.getDifficulte()+"' , cours = '"+f.getPath()+"' WHERE id = "+f.getId();
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FormationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    

    
}
