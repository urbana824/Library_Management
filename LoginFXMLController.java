/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library_Management;

import java.sql.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Urbana Musharrat Haider,180041110
 */
public class LoginFXMLController implements Initializable {

    @FXML
    private AnchorPane background;
    @FXML
    private VBox back_image;
    @FXML
    private Label Loginpage;
    @FXML
    private Label username;
    @FXML
    private Label password;
    @FXML
    private TextField usernametxt;
    @FXML
    private TextField passtxt;
    @FXML
    private Button submitButton;
    @FXML
    private Label Lib_Management;
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
   
   

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
     * when this button is clicked ,it will login to the main menu.
     * @param event actions that will occur when button is pressed
     * @throws IOException
     * @throws SQLException
     * 
     */
    @FXML
    private void HandlesubmitButton(ActionEvent event) throws SQLException, IOException {
        
        String uname = usernametxt.getText();
        String pass = passtxt.getText();
        
        if(uname.equals("") || pass.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Username or Password blank");
        }
        
        else
        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/login", "root","Urbder899");
                
                pst = (PreparedStatement) con.prepareStatement("select * from loginfo where BINARY Username=? and Password=?");
                
                pst.setString(1, uname);
                pst.setString(2, pass);
                
                rs =pst.executeQuery();
                
                if(rs.next())
                {
                
                  JOptionPane.showMessageDialog(null, "Login Successful");
                  
                  AnchorPane pane = FXMLLoader.load(getClass().getResource("Main_menuFXML.fxml"));
                  background.getChildren().setAll(pane);
                  
                }
                
                else
               {
                
                 JOptionPane.showMessageDialog(null, "Login Failed");
                 
                  usernametxt.setText("");
                  passtxt.setText("");
                  usernametxt.requestFocus();
                }
                    
            } 
            catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
            
        
    }
    
}
