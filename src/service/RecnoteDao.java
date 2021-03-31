/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Recnote;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.ConnexionSingleton;

/**
 *
 * @author asus
 */
    public class RecnoteDao implements Idao<Recnote>{
    
    private static RecnoteDao instance;
    private Statement st;
    private ResultSet rs;
    
    private RecnoteDao() {
        ConnexionSingleton cs=ConnexionSingleton.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(RecnoteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static RecnoteDao getInstance(){
        if(instance==null) 
            instance=new RecnoteDao();
        return instance;
    }

    @Override
    public void insert(Recnote o) {
        String req="insert into reclamation (adressem,examen,date,nom_formateur,description) values ('"+o.getAdressem()+"','"+o.getExamen()+"','"+o.getDate()+"','"+o.getNom_formateur()+"','"+o.getDescription()+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(RecnoteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   

    @Override
    public void delete(Recnote o) {
         String req="delete from reclamation where id_reclamation="+o.getId_reclamation();
        Recnote p=displayById(o.getId_reclamation());
        
          if(p!=null)
              try {
           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(RecnoteDao.class.getName()).log(Level.SEVERE, null, ex);
        }else System.out.println("n'existe pas"); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public List<Recnote> displayAll() {
      String req="select * from reclamation";
        ObservableList<Recnote> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Recnote p=new Recnote();
                p.setId_reclamation(rs.getInt("id_reclamation"));
                p.setAdressem(rs.getString("adressem"));
                p.setExamen(rs.getString("examen"));
                p.setDate(rs.getString("date"));
                p.setNom_formateur(rs.getString("nom_formateur"));
                p.setDescription(rs.getString("description"));

                
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Recnote.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list; //To change body of generated methods, choose Tools | Templates.
    }
    public List<Recnote> displayAllList() {
        String req="select * from reclamation";
        List<Recnote> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
              Recnote p=new Recnote();
            p.setId_reclamation(rs.getInt("id_reclamation"));
            p.setAdressem(rs.getString("adressem"));
                p.setExamen(rs.getString("examen"));
                p.setDate(rs.getString("date"));
                p.setNom_formateur(rs.getString("nom_formateur"));
                p.setDescription(rs.getString("description"));
             
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RecnoteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

 
    @Override
    public Recnote displayById(int id) {
        String req="select * from reclamation where id_reclamation ="+id;
        Recnote p=new Recnote();
        try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
                p.setId_reclamation(rs.getInt("id_reclamation"));
                p.setAdressem(rs.getString("adressem"));
                 p.setExamen(rs.getString("examen"));
                p.setDate(rs.getString("date"));
                p.setNom_formateur(rs.getString("nom_formateur"));
                p.setDescription(rs.getString("description"));
               
               
                //}  
        } catch (SQLException ex) {
            Logger.getLogger(RecnoteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Recnote os) {
        
        String qry = "UPDATE reclamation SET examen = '"+os.getExamen()+"', date = '"+os.getDate()+"', nom_formateur = '"+os.getNom_formateur()+"', description = '"+os.getDescription()+"' WHERE id_reclamation = "+os.getId_reclamation();;
         
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RecnoteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Recnote> displayAllById(int id) {
        ObservableList<Recnote> list=FXCollections.observableArrayList();  
        String req="SELECT * from reclamation  WHERE id_reclamation="+id;
        
        
        try {
            
            rs=st.executeQuery(req);
            while(rs.next()){
                Recnote p =new Recnote();
                p.setId_reclamation(rs.getInt("id_reclamation"));
                p.setAdressem(rs.getString("adressem"));
                 p.setExamen(rs.getString("examen"));
                p.setDate(rs.getString("date"));
                p.setNom_formateur(rs.getString("nom_formateur"));
                p.setDescription(rs.getString("description"));
               
                list.add(p);
            }    
        } catch (SQLException ex) {
            Logger.getLogger(FormationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    @Override
    public List<Recnote> displayAllByEmail(String email) {
        ObservableList<Recnote> list=FXCollections.observableArrayList();  
        String req="SELECT * from reclamation  WHERE adressem='"+email+"'";
        
        
        try {
            
            rs=st.executeQuery(req);
            while(rs.next()){
                Recnote p =new Recnote();
                p.setId_reclamation(rs.getInt("id_reclamation"));
                p.setAdressem(rs.getString("adressem"));
                 p.setExamen(rs.getString("examen"));
                p.setDate(rs.getString("date"));
                p.setNom_formateur(rs.getString("nom_formateur"));
                p.setDescription(rs.getString("description"));
               
                list.add(p);
            }    
        } catch (SQLException ex) {
            Logger.getLogger(FormationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public ObservableList<Recnote> displaylist() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    }

    
