/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library_Management;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Urbana Musharrat Haider, 180041110
 */
public class Issued_FXMLController implements Initializable {

    @FXML
    private Button gomain;
    @FXML
    private Button view;
    @FXML
    private TableColumn<Issued, String> MemId;
    @FXML
    private TableColumn<Issued, String> BookId;
    @FXML
    private AnchorPane issstable;
    @FXML
    private TableView<Issued> isstab;
    
    private ObservableList<Issued>data2;
    
    Connection con;
    PreparedStatement pst;

    /**
     * Initializes the controller class
     * @param url the location used to resolve relative paths for the root object, or null if the location is not known
     * @param rb the resources used to localize the root object, or null if the root object was not localized
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    } 
    
    /**
     * when this button is clicked ,it will return to the main menu.
     * @param event actions that will occur when button is pressed
     * @throws IOException
     * 
     */

    @FXML
    private void Backtomainmenu(ActionEvent event) throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("Main_menuFXML.fxml"));
         issstable.getChildren().setAll(pane);
    }
    
    /**
     * when  View button is pressed ,it will show all issued information.
     * @param event actions that will occur when button is pressed
     * @throws SQLException
     * 
     */

    @FXML
    private void viewtable(ActionEvent event) throws SQLException, ClassNotFoundException {
        
        try {
                Class.forName("com.mysql.jdbc.Driver");
                
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/login", "root","Urbder899");
                data2=FXCollections.observableArrayList();
              
                
                ResultSet rs=con.createStatement().executeQuery("SELECT * FROM issued ORDER BY Member_ID");
                
                while(rs.next())
                {
                
                  data2.add(new Issued (rs.getString(1), rs.getString(2)));
                  
                }
                
    
                    
            } 
            catch (ClassNotFoundException ex) {
                Logger.getLogger(Issued_FXMLController.class.getName()).log(Level.SEVERE, null, ex);
                throw ex;
            }
            
        MemId.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
        BookId.setCellValueFactory(new PropertyValueFactory<>("book_id"));
        
        isstab.setItems(null);
        isstab.setItems(data2);
        
        
    }
    }
    

