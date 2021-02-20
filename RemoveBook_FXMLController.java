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
 * @author Morsalina,180041103
 */
public class RemoveBook_FXMLController implements Initializable {

    @FXML
    private AnchorPane Remove;
  
    @FXML
    private Button cancel;
    @FXML
    private Button removebtn;
    
    @FXML
    private TextField bookid;
    
    Connection con;
    PreparedStatement pst;
    


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
    private void HandleCancel(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Main_menuFXML.fxml"));
         Remove.getChildren().setAll(pane);
    }
     /**
     * when  Remove button is pressed ,it will remove the book information from the database.
     * @param event actions that will occur when button is pressed
     * @throws SQLException
     * 
     */
    
    @FXML
    private void HandleRemove(ActionEvent event) throws SQLException {
        
        
         String Bid = bookid.getText();
        
        
          if(Bid.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Enter Book Id");
        }
       
           else
        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/login", "root","Urbder899");
                
                pst = (PreparedStatement) con.prepareStatement("DELETE FROM books where Book_Id= ?");
                
                pst.setString(1,Bid);
          
                
                int status =pst.executeUpdate();
                
                if(status==1)
                {
                
                 JOptionPane.showMessageDialog(null, "Book Removed successfully");
                  
                 bookid.setText("");
                
                 bookid.requestFocus();
                  
                }
                
                else
               {
                
                 JOptionPane.showMessageDialog(null, "Cannot Remove Book");
                 
                }
                    
            } 
            catch (ClassNotFoundException ex) {
                Logger.getLogger(RemoveBook_FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    
}
    }

    
    

