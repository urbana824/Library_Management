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
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Onamika Hossain,180041102
 */
public class Add_BookFXMLController implements Initializable {

   
    @FXML
    private TextField B_Id;
     @FXML
    private TextField Btitle;
    @FXML
    private TextField Author;
    @FXML
    private TextField B_Publisher;
    @FXML
    private Button Cancel_addBook;
    @FXML
    private Button Save_addbook;
    @FXML
    private AnchorPane addbookinterface;
    
    
    Connection con;
    PreparedStatement pst;
    //ResultSet rs;
    
   

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
     * when Cancel  button is clicked ,it will return to the main menu.
     * @param event actions that will occur when button is pressed
     * @throws IOException
     * 
     */
     
    @FXML
    private void Handle_cancelAddbook(ActionEvent event) throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("Main_menuFXML.fxml"));
         addbookinterface.getChildren().setAll(pane);
    }
    /**
     * when Add Book  button is clicked ,it will add the book information in the database.
     * @param event actions that will occur when button is pressed
     * @throws SQLException
     * 
     */

    @FXML
    private void Handle_addbook(ActionEvent event) throws SQLException {
        
         String BID = B_Id.getText();
         String B_title = Btitle.getText(); 
         String B_author =Author.getText();
         String Pub = B_Publisher.getText();
         
         
         if(BID.equals("") || B_title.equals("") || B_author.equals("") || Pub.equals(""))
        {
            JOptionPane.showMessageDialog(null, "No book information given");
        }
         else
        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/login", "root","Urbder899");
                
                pst = (PreparedStatement) con.prepareStatement("INSERT INTO books (Book_Id, Book_Title,Book_Author, Book_Publisher) VALUES (?,?,?,?)");
                
                pst.setString(1, BID);
                pst.setString(2,B_title);
                pst.setString(3, B_author);
                pst.setString(4, Pub);
                
                
                int status =pst.executeUpdate();
                
                if(status==1)
                {
                
                  JOptionPane.showMessageDialog(null, "Book Added successfully");
                  
                 B_Id.setText("");
                 Btitle.setText("");
                 Author.setText("");
                 B_Publisher.setText("");

                 B_Id.requestFocus();
                  
                }
                
                else
               {
                
                 JOptionPane.showMessageDialog(null, "Cannot add Book");
                 
                }
                    
            } 
            catch (ClassNotFoundException ex) {
                Logger.getLogger(Add_BookFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
    }
    
}
