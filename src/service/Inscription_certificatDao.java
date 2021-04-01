package service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entity.Inscription_certificat;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.ConnexionSingleton;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;



public class Inscription_certificatDao implements Idao<Inscription_certificat>{
    
    private static Inscription_certificatDao instance;
    private Statement st;
    private ResultSet rs;
    Connection  myConnex;
      
    
    public Inscription_certificatDao() {
        ConnexionSingleton cs= ConnexionSingleton.getInstance();
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
        String req = "insert into inscri_certif (nom_utilisateur,nom_certificat) values ('"+o.getNomUtilisateur()+"','"+o.getNom()+"')"; 
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(Inscription_certificatDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(Inscription_certificat o) {
        String req="delete from inscri_certif where id_inscri="+o.getId();
//        Formation f =displayById(o.getId());
//        
//          if(f!=null)
              try {           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(Inscription_certificatDao.class.getName()).log(Level.SEVERE, null, ex);}
//        }else System.out.println("la formation n'existe pas");
//        }else System.out.println("la formation n'existe pas");
    }

    @Override
    public List<Inscription_certificat> displayAll() {
        String req="select * from inscri_certif";
        ObservableList<Inscription_certificat> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Inscription_certificat f =new Inscription_certificat();
                f.setId(rs.getInt("id_inscri"));
                f.setNomUtilisateur(rs.getString("nom_utilisateur"));
                f.setNom(rs.getString("nom_certificat"));
               
                list.add(f);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Inscription_certificatDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Inscription_certificat displayById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Inscription_certificat os) {
        String qry = "update inscri_certif set nom_utilisateur = '"+os.getNomUtilisateur()+"' , nom_certificat = '"+os.getNom()+"'  WHERE id_inscri = "+os.getId();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Inscription_certificatDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void FacturePdf() throws SQLException,FileNotFoundException,IOException, DocumentException 
    {
        Document doc = new Document();
        String req="select * from inscri_certif";
        
        try {
            rs=st.executeQuery(req);
            PdfWriter.getInstance(doc, new FileOutputStream("d:/Resultat.pdf"));
                    
        doc.open();
        doc.add(new Paragraph("   "));
        doc.add(new Paragraph("  Liste de personnes inscrites à la certification  "));
        doc.add(new Paragraph("   "));
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        PdfPCell cell;
        
        cell = new PdfPCell(new Phrase("id_inscri",FontFactory.getFont("Comic Sans MS",12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Nom Utilisateur",FontFactory.getFont("Comic Sans MS",12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Nom Certificat",FontFactory.getFont("Comic Sans MS",12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        
        
    
        
         while (rs.next()) {  
             
            int ID = rs.getInt("id_inscri");
            String nomUtilisateur =rs.getString("nom_utilisateur");
            String nomCertificat = rs.getString("nom_certificat");
          
            String ID_ = Integer.toString(ID);
               
               cell = new PdfPCell(new Phrase(ID_,FontFactory.getFont("Comic Sans MS",12)));
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setBackgroundColor(BaseColor.GRAY);
               table.addCell(cell);
               
               cell = new PdfPCell(new Phrase(nomUtilisateur,FontFactory.getFont("Comic Sans MS",12)));
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setBackgroundColor(BaseColor.GRAY);
               table.addCell(cell);
               
               cell = new PdfPCell(new Phrase(nomCertificat,FontFactory.getFont("Comic Sans MS",12)));
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setBackgroundColor(BaseColor.GRAY);
               table.addCell(cell);
        
        
               
        }
         
        doc.add(table);
        doc.close();
        Desktop.getDesktop().open(new File ("d:/Resultat.pdf"));

        } 
        
        catch (SQLException ex) {
            Logger.getLogger(Inscription_certificatDao.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

    @Override
    public List<Inscription_certificat> displayAllById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<Inscription_certificat> displaylist() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription_certificat> displayAllByEmail(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Inscription_certificat o, int prix) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
   
        
        
               
              
        
           
        
        
        
 
}
