package service;

import entity.Inscription_certificat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;


public class Inscription_certificatDao implements Idao<Inscription_certificat>{
    
    private static Inscription_certificatDao instance;
    private Statement st;
    private ResultSet rs;
    
    private Inscription_certificatDao() {
        DataSource cs= DataSource.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Inscription_certificatDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Inscription_certificatDao getInstance(){
        if(instance==null) 
            instance=new Inscription_certificatDao();
        return instance;
    }
    
    @Override
    public void insert(Inscription_certificat o) {
        String req = "insert into inscri_certif (nom_utilisateur,nom_certificat,description,domaine) values ('"+o.getNomUtilisateur()+"','"+o.getNom()+"','"+o.getDescription()+"','"+o.getDomaine()+"')"; 
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(Inscription_certificatDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(Inscription_certificat o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription_certificat> displayAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Inscription_certificat displayById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Inscription_certificat os) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<Inscription_certificat> displayAllList() {
        String req="select * from inscri_certif";
        List<Inscription_certificat> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Inscription_certificat f =new Inscription_certificat();
                f.setId(rs.getInt(1));                
                f.setNomUtilisateur(rs.getString("Nom Utilisateur"));
                f.setNom(rs.getString("Nom Certificat"));
                f.setDescription(rs.getString("Description"));
                f.setDomaine(rs.getString("Domaine"));
                
                list.add(f);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Inscription_certificatDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
