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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Urbana Musharrat Haider,180041110
 */
public class AllMembersFXMLController implements Initializable {

    @FXML
    private TableView<Member> table2;
    @FXML
    private TableColumn<Member, String> MemberID;
    @FXML
    private TableColumn<Member, String> Member_Name;
    @FXML
    private TableColumn<Member, String> Contact;
    @FXML
    private TableColumn<Member, String> Email;
    @FXML
    private TableColumn<Member, String> Add;
    @FXML
    private Button gomain2;
    @FXML
    private Button ViewMember;
    @FXML
    private AnchorPane memtablepane;
    
    private ObservableList<Member>data2;
    
    Connection con2;
    PreparedStatement pst2;

    /**
     * Initializes the controller class
     * @param url the location used to resolve relative paths for the root object, or null if the location is not known
     * @param rb the resources used to localize the root object, or null if the root object was not localized
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    /**
     * when this button is clicked ,it will return to the main menu.
     * @param event actions that will occur when button is pressed
     * @throws IOException
     * 
     */

    @FXML
    private void Backmenu(ActionEvent event) throws IOException{
        
         AnchorPane pane = FXMLLoader.load(getClass().getResource("Main_menuFXML.fxml"));
         memtablepane.getChildren().setAll(pane);
    }
    
    /**
     * when  View button is pressed ,it will show all member information in the database.
     * @param event actions that will occur when button is pressed
     * @throws SQLException
     * 
     */

    @FXML
    private void viewM(ActionEvent event) throws SQLException, ClassNotFoundException {
        
        try {
                Class.forName("com.mysql.jdbc.Driver");
                
                con2 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/login", "root","Urbder899");
                data2=FXCollections.observableArrayList();
              
                
                ResultSet rs2=con2.createStatement().executeQuery("SELECT * FROM member");
                
                while(rs2.next())
                {
                
                  data2.add(new Member(rs2.getString(1), rs2.getString(2), rs2.getString(3), rs2.getString(4), rs2.getString(5)));
                  
                }
                    
            } 
            catch (ClassNotFoundException ex) {
                Logger.getLogger(AllMembersFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                throw ex;
            }
            
        MemberID.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
        Member_Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Contact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        Email.setCellValueFactory(new PropertyValueFactory<>("email"));
        Add.setCellValueFactory(new PropertyValueFactory<>("address"));
        table2.setItems(null);
        table2.setItems(data2);
    }

    
    
}
