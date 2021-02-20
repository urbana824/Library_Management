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
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


/**
 * FXML Controller class
 *
 * @author Urbana Musharrat Haider, 180041110
 */
public class Main_menuFXMLController implements Initializable {

    @FXML
    private AnchorPane Main_Menu; 
    @FXML
    private Button addbook;
    @FXML
    private Button addmember;
    @FXML
    private Button allbooks;
    @FXML
    private Button searchmember;
    @FXML
    private Button allmembers;
    @FXML
    private Button issuedbook;
    @FXML
    private Button Logout;
    @FXML
    private Button issuebook;
    @FXML
    private Button returnbook;
    @FXML
    private Button searchbook;
    
    Connection con;
    PreparedStatement pst;
    @FXML
    private Button removebook;
    @FXML
    private Label adduser;

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
     * when this button is pressed, it will go to the add book interface.
     * @param event actions that will occur when button is pressed
     * @throws IOException 
     */
    @FXML
    private void Handle_addbook(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Add_BookFXML.fxml"));
        Main_Menu.getChildren().setAll(pane);
    }
 
     /**
     *when this button is pressed, it will go to the add member interface.
     * @param event actions that will occur when button is pressed
     * @throws IOException 
     */
    @FXML
    private void Handle_addmember(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Add_MemberFXML.fxml"));
        Main_Menu.getChildren().setAll(pane);
    }

     /**
     *when this button is pressed, it will go to the search book interface.
     * @param event actions that will occur when button is pressed
     * @throws IOException 
     */
    @FXML
    private void Handle_searchbook(ActionEvent event) throws IOException {
        
        AnchorPane pane = FXMLLoader.load(getClass().getResource("SearchBook_FXML.fxml"));
        Main_Menu.getChildren().setAll(pane);
    }

     /**
     *when this button is pressed, it will show all of the books.
     * @param event actions that will occur when button is pressed
     * @throws IOException 
     */
    @FXML
    private void Show_allbooks(ActionEvent event) throws IOException, SQLException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AllBooksFXML.fxml"));
        Main_Menu.getChildren().setAll(pane);
        
    }

     /**
     *when this button is pressed, it will go to the search member interface.
     * @param event actions that will occur when button is pressed
     * @throws IOException 
     */
    @FXML
    private void Handle_searchmember(ActionEvent event) throws IOException {
        
       AnchorPane pane = FXMLLoader.load(getClass().getResource("Searchmem_FXML.fxml"));
       Main_Menu.getChildren().setAll(pane); 
        
    }

     /**
     *when this button is pressed, it will show all of the members.
     * @param event actions that will occur when button is pressed
     * @throws IOException 
     */
    @FXML
    private void Show_allmembers(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AllMembersFXML.fxml"));
        Main_Menu.getChildren().setAll(pane);
    }

     /**
     *when this button is pressed, it will show all of the issued books.
     * @param event actions that will occur when button is pressed
     * @throws IOException 
     */
    @FXML
    private void Show_issued(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Issued_FXML.fxml"));
        Main_Menu.getChildren().setAll(pane);
        
    }

     /**
     *when this button is pressed, it will go to the issue book interface.
     * @param event actions that will occur when button is pressed
     * @throws IOException 
     */

    @FXML
    private void Handle_issue(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Issue_FXML.fxml"));
        Main_Menu.getChildren().setAll(pane);
        
    }

     /**
     *when this button is pressed, it will go to the return book interface.
     * @param event actions that will occur when button is pressed
     * @throws IOException 
     */
    @FXML
    private void Handle_return(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("ReturnFXML.fxml"));
        Main_Menu.getChildren().setAll(pane);
    }
    
     /**
     *when this button is pressed, it will logout of the system.
     * @param event actions that will occur when button is pressed
     * @throws IOException 
     */
    @FXML
    private void Handle_Logout(ActionEvent event) throws IOException {
        
        AnchorPane pane = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
        Main_Menu.getChildren().setAll(pane);
    }

     /**
     *when this button is pressed, it will go to the remove book interface.
     * @param event actions that will occur when button is pressed
     * @throws IOException 
     */
    @FXML
    private void Handle_removebook(ActionEvent event) throws IOException {
        
        AnchorPane pane = FXMLLoader.load(getClass().getResource("RemoveBook_FXML.fxml"));
        Main_Menu.getChildren().setAll(pane);
    }
    
}
