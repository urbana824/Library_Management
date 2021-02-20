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
public class Add_MemberFXMLController implements Initializable {

    @FXML
    private TextField M_ID;
    @FXML
    private TextField Email;
    @FXML
    private TextField M_Name;
    @FXML
    private TextField Phn;
    @FXML
    private TextField M_address;
    @FXML
    private Button CancelAdd_member;
    @FXML
    private Button SaveAddmember;
    @FXML
    private AnchorPane AddMemberInterface;
    
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
     * when Cancel  button is clicked ,it will return to the main menu.
     * @param event actions that will occur when button is pressed
     * @throws IOException
     * 
     */
    @FXML
    private void HandleCancelMember(ActionEvent event) throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("Main_menuFXML.fxml"));
         AddMemberInterface.getChildren().setAll(pane);
        
    }
    
    /**
     * when Add Member  button is clicked ,it will add the member information in the database.
     * @param event actions that will occur when button is pressed
     * @throws SQLException
     * 
     */

    @FXML
    private void HandleSaveMember(ActionEvent event) throws SQLException {
        
        String MID = M_ID.getText();
        String MName = M_Name.getText(); 
        String Contact =Phn.getText();
        String M_Email = Email.getText();
        String Address = M_address.getText();
        
        
        if(MID.equals("") || MName.equals("") || Contact.equals("") || M_Email.equals("") || Address.equals(""))
        {
            JOptionPane.showMessageDialog(null, "No member information given");
        }
         else
            
             try {
                Class.forName("com.mysql.jdbc.Driver");
                
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/login", "root","Urbder899");
                
                pst = (PreparedStatement) con.prepareStatement("INSERT INTO member (Member_Id, Name,Contact_No,Email, Address) VALUES (?,?,?,?,?)");
                
                pst.setString(1, MID);
                pst.setString(2,MName);
                pst.setString(3, Contact);
                pst.setString(4, M_Email);
                pst.setString(5, Address);
                
                
                int status =pst.executeUpdate();
                
                if(status==1)
                {
                
                  JOptionPane.showMessageDialog(null, "Member Added successfully");
                  
                 M_ID.setText("");
                 M_Name.setText("");
                 Phn.setText("");
                 Email.setText("");
                 M_address.setText("");
                 

                 M_ID.requestFocus();
                  
                }
                
                else
               {
                
                 JOptionPane.showMessageDialog(null, "Cannot Add Member");
                 
                }
                    
            } 
            catch (ClassNotFoundException ex) {
                Logger.getLogger(Add_MemberFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
    }
    

