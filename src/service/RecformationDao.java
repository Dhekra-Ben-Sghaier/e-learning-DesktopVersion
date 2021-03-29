/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Recformation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.connexion;

/**
 *
 * @author asus
 */
  public class RecformationDao implements Idao<Recformation>{
    
    private static RecformationDao instance;
    private Statement st;
    private ResultSet rs;
    
    private RecformationDao() {
        connexion cs=connexion.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(RecformationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static RecformationDao getInstance(){
        if(instance==null) 
            instance=new RecformationDao();
        return instance;
    }

    @Override
    public void insert(Recformation o) {
        String req="insert into recformation (formation,nom_formateur,description) values ('"+o.getFormation()+"','"+o.getNom_formateur()+"','"+o.getDescription()+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(RecformationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   

    @Override
    public void delete(Recformation o) {
         String req="delete from recformation where id_formation="+o.getId_formation();
        Recformation p=displayById(o.getId_formation());
        
          if(p!=null)
              try {
           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(RecformationDao.class.getName()).log(Level.SEVERE, null, ex);
        }else System.out.println("n'existe pas"); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public List<Recformation> displayAll() {
      String req="select * from recformation";
        ObservableList<Recformation> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Recformation p=new Recformation();
                p.setId_formation(rs.getInt(1));
                p.setFormation(rs.getString(2));
                p.setNom_formateur(rs.getString(4));
                p.setDescription(rs.getString(5));

                
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Recformation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list; //To change body of generated methods, choose Tools | Templates.
    }
    public List<Recformation> displayAllList() {
        String req="select * from recformation";
        List<Recformation> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
              Recformation p=new Recformation();
            p.setId_formation(rs.getInt(1));
                p.setFormation(rs.getString(2));
                p.setNom_formateur(rs.getString(4));
                p.setDescription(rs.getString(5));
             
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RecformationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

 
    @Override
    public Recformation displayById(int id) {
        String req="select * from recformation where id_formation ="+id;
        Recformation p=new Recformation();
        try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
                p.setId_formation(rs.getInt(1));
                 p.setFormation(rs.getString(2));
                p.setNom_formateur(rs.getString(4));
                p.setDescription(rs.getString(5));
               
               
                //}  
        } catch (SQLException ex) {
            Logger.getLogger(RecformationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Recformation os) {
        
        String qry = "UPDATE formation SET recformation = '"+os.getFormation()+"', nom_formateur = '"+os.getNom_formateur()+"', description = '"+os.getDescription()+"' WHERE id_formation = "+os.getId_formation();;
         
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RecformationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

  }