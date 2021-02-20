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
 * @author Urbana Musharrat Haider,180041110
 */
public class ReturnFXMLController implements Initializable {

    @FXML
    private TextField Mid;
    @FXML
    private TextField Bid;
    @FXML
    private Button Cancel;
    @FXML
    private Button returnbook;
    @FXML
    private AnchorPane ret;
    
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
     * when the Cancel button is clicked ,it will return to the main menu.
     * @param event actions that will occur when button is pressed
     * @throws IOException
     * 
     */
    
    @FXML
    private void HandleCancel(ActionEvent event) throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("Main_menuFXML.fxml"));
         ret.getChildren().setAll(pane);
    }

     /**
     * when  Return button is pressed ,it will remove that entry from the Issued table.
     * @param event actions that will occur when button is pressed
     * @throws SQLException
     * @throws ClassNotFoundException
     * 
     */
    @FXML
    private void Handlereturn(ActionEvent event) throws ClassNotFoundException, SQLException {
        
        String mid = Mid.getText();
        String bid = Bid.getText();
        
          if(mid.equals("") || bid.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Member Id or Book Id missing");
        }
       
           else
        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/login", "root","Urbder899");
                
                pst = (PreparedStatement) con.prepareStatement("DELETE FROM Issued where Member_Id= ? and Book_Id= ? ");
                
                pst.setString(1,mid);
                pst.setString(2,bid);
                
                
                int status =pst.executeUpdate();
                
                if(status==1)
                {
                
                  JOptionPane.showMessageDialog(null, "Book Returned successfully");
                  
                 Mid.setText("");
                 Bid.setText("");
                 
                 Mid.requestFocus();
                  
                }
                
                else
               {
                
                 JOptionPane.showMessageDialog(null, "Cannot Return Book");
                 
                }
                    
            } 
            catch (ClassNotFoundException ex) {
                Logger.getLogger(ReturnFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    
}
}