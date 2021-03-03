/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Apprenant;
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
public class AppDao implements Idao<Apprenant> {
    private static AppDao instance;
    private Statement st;
    private ResultSet rs;
    private String val="null"; 
    private String roleapp="apprenant";
    private AppDao() {
        ConnexionSingleton cs=ConnexionSingleton.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(AppDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static AppDao getInstance(){
        if(instance==null) 
            instance=new AppDao();
        return instance;
    }
    @Override
    public void insert(Apprenant o) {
        String req="insert into personnes (cin,nom,prenom,email,password,nomUtilisateur,centreInteret,domaine,role) values ('"+o.getCin()+"','"+o.getNom()+"','"+o.getPrenom()+"','"+o.getEmail()+"','"+o.getMdp()+"','"+o.getLogin()+"','"+o.getCd()+"','"+val+"','"+roleapp+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(AppDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Apprenant o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Apprenant> displayAll() {
      String req="select * from personnes";
        ObservableList<Apprenant> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Apprenant p=new Apprenant();
                p.setId(rs.getInt(1));
                p.setCin(rs.getString(2));
                p.setNom(rs.getString(3));
                p.setPrenom(rs.getString(4));
                p.setEmail(rs.getString(5));
                p.setMdp(rs.getString(6));
                p.setLogin(rs.getString(7));
                p.setCd(rs.getString(8));

                
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AppDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list; //To change body of generated methods, choose Tools | Templates.
    }
    public List<Apprenant> displayAllList() {
        String req="select * from personnes";
        List<Apprenant> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Apprenant p=new Apprenant();
            p.setId(rs.getInt(1));
                p.setCin(rs.getString(2));
                p.setNom(rs.getString(3));
                p.setPrenom(rs.getString(4));
                p.setEmail(rs.getString(5));
                p.setMdp(rs.getString(6));
                p.setLogin(rs.getString(7));
                p.setCd(rs.getString(8));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AppDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Apprenant displayById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Apprenant os) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<Apprenant> displaylist() {
        String req="select * from personnes";
        ObservableList<Apprenant> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Apprenant p=new Apprenant();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setEmail(rs.getString("email"));
                p.setMdp(rs.getString("password"));
                p.setLogin(rs.getString("nomUtilisateur"));
                p.setCd(rs.getString("centreInteret"));

                
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AppDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list; //To change body of generated methods, choose Tools | Templates
    }
    
}
