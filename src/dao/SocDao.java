/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Societe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import utils.ConnexionSingleton;

/**
 *
 * @author benha
 */
public class SocDao implements Idao<Societe>{
   private static SocDao instance;
    private Statement st;
    private ResultSet rs;
   
    private SocDao() {
        ConnexionSingleton cs=ConnexionSingleton.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(SocDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static SocDao getInstance(){
        if(instance==null) 
            instance=new SocDao();
        return instance;
    }
    @Override
    public void insert(Societe o) {
        String req="insert into societe (nom_soc,adr_mail_soc,adr_soc,password,nomUtilisateur) values ('"+o.getNom()+"','"+o.getEmail()+"','"+o.getAdresse()+"','"+o.getMdp()+"','"+o.getLogin()+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(AppDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Societe o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Societe> displayAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Societe displayById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<Societe> displaylist() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Societe os) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
