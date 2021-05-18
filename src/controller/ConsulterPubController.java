/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import service.PubDao;
import entity.Pub;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javafx.collections.transformation.SortedList;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static sun.nio.cs.Surrogate.is;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ConsulterPubController implements Initializable {
 @FXML
    private Button supprimer;
    @FXML
    private TableColumn<Pub, String> nomp;
    @FXML
    private TableColumn<Pub, String> emailp;
    @FXML
    private TableColumn<Pub, String> domainep;
    ObservableList<Pub>  PubList = FXCollections.observableArrayList();
    private ListDetPub listdata = new ListDetPub();
    
    
       @FXML
    private TableColumn<Pub, Integer> idp ;
    @FXML
    private TableColumn<Pub, String> prenomp;
    
    @FXML
    private TableView<Pub> pubview;
    @FXML
    private Button modification;
    @FXML
    private TextField txt_search;
    @FXML
    private Button actualiser;
    @FXML
    private TableColumn<Pub, String> affichagep;
    @FXML
    private TableColumn<Pub, Integer> prixp;
    @FXML
    private BarChart<String, Integer> barChart;
    @FXML
    private Button loadChart;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private TableColumn<Pub, String> lienp;
    
   private void load(){
        listdata = new ListDetPub();
        idp.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomp.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomp.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        emailp.setCellValueFactory(new PropertyValueFactory<>("email"));
        domainep.setCellValueFactory(new PropertyValueFactory<>("domaine"));
        affichagep.setCellValueFactory(new PropertyValueFactory<>("Affichage"));
        prixp.setCellValueFactory(new PropertyValueFactory<>("Prix"));
        lienp.setCellValueFactory(new PropertyValueFactory<>("lien"));
  
        pubview.setItems(listdata.getPub());
        pubview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadChart.setOnAction(event -> {    
            XYChart.Series<String,Integer> series = new XYChart.Series<>();
            
         try {
        Connection conn;
        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/esprit","root","");
        String req=" select * from publicite ";
        Statement st = conn.createStatement();
        ResultSet rs =st.executeQuery(req);
        while(rs.next()) {
        series.getData().add(new XYChart.Data<>(rs.getString(6), rs.getInt(8)));
        
        }
        
        barChart.getData().add(series);
        barChart.setTitle("Somme des prix par rapport aux affichages");
       
        
    } catch (SQLException ex) {
         Logger.getLogger(ConsulterPubController.class.getName()).log(Level.SEVERE, null, ex);
}
         
        });
        
//        ObservableList<PieChart.Data>data=FXCollections.observableArrayList();
// Connection conn;
//        try {
//                
//               
//       conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/esprit","root","");
//               String req=" select * from publicité GROUP BY Affichage";
//              Statement st = conn.createStatement();
//            ResultSet rs =st.executeQuery(req);
 //while(rs.next()) {
//                   String d=(rs.getString(6));
//                   System.out.println("d "+d);
//                   System.out.println("rs:  "+rs.toString());
//                   System.out.println("getInt : "+rs.getInt(8));
//                   
//                data.add(new PieChart.Data(d,rs.getInt(8)));
//               
//                
//               }
 //    } catch (SQLException ex) {
   //      Logger.getLogger(ConsulterPubController.class.getName()).log(Level.SEVERE, null, ex);
//     }
//        piechart1.setTitle("Statistique des annonceurs");
//        piechart1.setLegendSide(Side.LEFT);
//        piechart1.setData(data);
         load();
        // TODO
        //aff liste pub
      pubview.setItems(listdata.getPub());
      
       idp.setCellValueFactory(cell -> cell.
                getValue().getIdProperty().asObject());
       nomp.setCellValueFactory(cell -> cell.
                getValue().getNomProperty());
        prenomp.setCellValueFactory(cell -> cell.
                getValue().getPrenomProperty());
        emailp.setCellValueFactory(cell -> cell.
                getValue().getEmailProperty());
         domainep.setCellValueFactory(cell -> cell.
                getValue().getDomaineProperty());
         affichagep.setCellValueFactory(cell -> cell.
                getValue().getAffichageProperty());
         
         prixp.setCellValueFactory(cell -> cell.
               getValue().getPrixProperty().asObject());
         lienp.setCellValueFactory(cell -> cell.
                getValue().getLienProperty());
       
        
    
    
         //suprimer
            supprimer.setOnAction(event -> {
            
   Pub p = pubview.getSelectionModel().getSelectedItem();
          PubDao fo =PubDao.getInstance().getInstance();
          fo.delete(p);
//          pubview.getItems().removeAll(pubview.getSelectionModel().getSelectedItem());
           pubview.getSelectionModel().getSelectedItems().forEach(this.PubList::remove);
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Publicité supprimée!");
        alert.show();
        
   
        });
         PubList.addAll(listdata.getPub());
         FilteredList<Pub> filtereddata= new FilteredList<>(PubList, b->true);
         txt_search.textProperty().addListener((observable, oldValue, newValue) -> { 
            txt_search.textProperty().addListener((observables, oldVal, newVal) -> {
               filtereddata.setPredicate((Pub publ) -> {
                   if (newVal == null || newVal.isEmpty()){
                   return true; }
                   String lowerCaseFilter = newValue.toLowerCase();
                   if (publ.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches nom.
	        }  else if (publ.getPrenom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches nom.
		}  else if (publ.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches nom.
		}  else if (publ.getDomaine().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches nom.
                
                                        
		} else if ((""+publ.getPrix()).contains(lowerCaseFilter)) {
                    
					return true; // Filter matches nom.
                
                                        } 
                
                else  
				    	 return false;
               
               });
                      
            
            });
            
                     
         });
         SortedList<Pub> sortedData = new SortedList<>(filtereddata);
         sortedData.comparatorProperty().bind(pubview.comparatorProperty());
         pubview.setItems(sortedData);
         
    }
    

    @FXML
    private void modification(javafx.event.ActionEvent event) {
        Pub f = pubview.getSelectionModel().getSelectedItem();
        PubDao fo =PubDao.getInstance();

          
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/modif.fxml"));
            Parent parent = (Parent)loader.load();            
               ModifController x = loader.<ModifController>getController();
            x.setPubli(f);
            
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ConsulterPubController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @FXML
    private void actualiser(javafx.event.ActionEvent event) {
         load();
    }

    
    
    
}
    

    
    


   
           
           
           
   
     
       

    
    

