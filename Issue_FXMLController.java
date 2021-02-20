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
public class Issue_FXMLController implements Initializable {

    @FXML
    private TextField memberid;
    @FXML
    private TextField bookid;
    @FXML
    private Button sub;
    @FXML
    private Button backmenu;
    @FXML
    private AnchorPane issuebook;

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
    
    private void gobackmenu(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Main_menuFXML.fxml"));
        issuebook.getChildren().setAll(pane);
    }
    
    /**
     * when  Submit button is pressed ,it will add information in the issued books table. 
     * @param event actions that will occur when button is pressed
     * @throws SQLException
     * 
     */
    
    @FXML
    private void submit(ActionEvent event) throws SQLException {
        
        String mid = memberid.getText();
        String bid = bookid.getText();
                
        
        
        if(mid.equals("") || bid.equals(""))
        {
            JOptionPane.showMessageDialog(null, "No information given");
        }
         else
            
             try {
                Class.forName("com.mysql.jdbc.Driver");
                
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/login", "root","Urbder899");
                
                pst = (PreparedStatement) con.prepareStatement("INSERT INTO Issued (Member_Id, Book_Id) VALUES (?,?)");
               
                
                pst.setString(1, mid);
                pst.setString(2,bid);
               
                 
                int status =pst.executeUpdate();
                
                
                if(status==1)
                {
                
                  JOptionPane.showMessageDialog(null, "Book Issued successfully");
                  
                 memberid.setText("");
                 bookid.setText("");

                 memberid.requestFocus();
                  
                }
                
                else
               {
                
                 JOptionPane.showMessageDialog(null, "Cannot Issue book");
                 
                }
                    
            } 
            catch (ClassNotFoundException ex) {
                Logger.getLogger(Issue_FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
        
        
    }

    
    

