/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Formateur;
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
 * @author benha
 */
public class FormDao implements Idao <Formateur> {
      private static FormDao instance;
    private Statement st;
    private ResultSet rs;
    private String val="null"; 
    private String roleform="formateur";
    private FormDao() {
        ConnexionSingleton cs=ConnexionSingleton.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(AppDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static FormDao getInstance(){
        if(instance==null) 
            instance=new FormDao();
        return instance;
    }
    @Override
    public void insert(Formateur o) {
        String req="insert into personnes (cin,nom,prenom,email,password,nomUtilisateur,centreInteret,domaine,role) values ('"+o.getCin()+"','"+o.getNom()+"','"+o.getPrenom()+"','"+o.getEmail()+"','"+o.getMdp()+"','"+o.getLogin()+"','"+val+"','"+o.getDomaine()+"','"+roleform+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(FormDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Formateur o) {
         String req="delete from personnes where id_user="+o.getId();
        Formateur p=displayById(o.getId());
        
          if(p!=null)
              try {
           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(FormDao.class.getName()).log(Level.SEVERE, null, ex);
        }else System.out.println("n'existe pas");
    }

    @Override
    public List<Formateur> displayAll() {
      String req="select * from personnes where role ='"+roleform+"'";
        ObservableList<Formateur> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Formateur p=new Formateur();
                p.setId(rs.getInt(1));
                p.setCin(rs.getString(2));
                p.setNom(rs.getString(3));
                p.setPrenom(rs.getString(4));
                p.setEmail(rs.getString(5));
                p.setMdp(rs.getString(6));
                p.setLogin(rs.getString(7));
                p.setDomaine(rs.getString("domaine"));

                
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FormDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list; //To change body of generated methods, choose Tools | Templates.
    }
    public List<Formateur> displayAllList() {
        String req="select * from personnes where role ='"+roleform+"'";
        List<Formateur> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
               Formateur p=new Formateur();
            p.setId(rs.getInt(1));
                p.setCin(rs.getString(2));
                p.setNom(rs.getString(3));
                p.setPrenom(rs.getString(4));
                p.setEmail(rs.getString(5));
                p.setMdp(rs.getString(6));
                p.setLogin(rs.getString(7));
                p.setDomaine(rs.getString("domaine"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FormDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Formateur displayById(int id) {
            String req="select * from personnes where id_user ="+id;
        Formateur p=new Formateur();
        try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
                p.setId(rs.getInt(1));
                 p.setCin(rs.getString(2));
                p.setNom(rs.getString(3));
                p.setPrenom(rs.getString(4));
                p.setEmail(rs.getString(5));
                  p.setMdp(rs.getString(6));
                p.setLogin(rs.getString(7));
                p.setDomaine(rs.getString("domaine"));
               
                //}  
        } catch (SQLException ex) {
            Logger.getLogger(FormDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;
    }

   

    @Override
    public ObservableList<Formateur> displaylist() {
        String req="select * from personnes where role ='"+roleform+"'";
        ObservableList<Formateur> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Formateur p=new Formateur();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setEmail(rs.getString("email"));
                p.setMdp(rs.getString("password"));
                p.setLogin(rs.getString("nomUtilisateur"));
                p.setDomaine(rs.getString("domaine"));

                
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FormDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list; //To change body of generated methods, choose Tools | Templates
    }

    @Override
    public boolean update(Formateur os) {
         
        String qry = "UPDATE personnes SET cin = '"+os.getCin()+"', nom = '"+os.getNom()+"', prenom = '"+os.getPrenom()+"', email = '"+os.getEmail()+"', password = '"+os.getMdp()+"', nomUtilisateur = '"+os.getLogin()+"', domaine = '"+os.getDomaine()+"' WHERE id_user = "+os.getId();
         
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FormDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Formateur> displayAllById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Formateur> displayAllByEmail(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
