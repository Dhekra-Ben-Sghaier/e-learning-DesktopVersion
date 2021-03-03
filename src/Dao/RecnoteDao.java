/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entity.Recnote;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.connexion;

/**
 *
 * @author asus
 */
    public class RecnoteDao implements Idao<Recnote>{
    
    private static RecnoteDao instance;
    private Statement st;
    private ResultSet rs;
    
    private RecnoteDao() {
        connexion cs=connexion.getInstance();
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
        String req="insert into reclamation (examen,date,nom_formateur,description) values ('"+o.getExamen()+"','"+o.getDate()+"','"+o.getNom_formateur()+"','"+o.getDescription()+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(RecnoteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   

    @Override
    public void delete(Recnote o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Recnote> displayAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Recnote displayById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Recnote os) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
