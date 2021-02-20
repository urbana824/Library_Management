/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library_Management;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Morsalina, 180041103
 */
public class Searchmem_FXMLController implements Initializable {

    @FXML
    private TextField memid;
    @FXML
    private Button search;
    @FXML
    private Label Name;
    @FXML
    private Label Contact;
    @FXML
    private Label Email;
    @FXML
    private Label Address;
    @FXML
    private Button cancel;
    @FXML
    private AnchorPane searchmem;

    
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
    private void cancel(ActionEvent event) throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("Main_menuFXML.fxml"));
         searchmem.getChildren().setAll(pane);
    }

    
     /**
     * when  Search button is pressed ,it will show the searched member information.
     * @param event actions that will occur when button is pressed
     * @throws SQLException
     * @throws ClassNotFoundException
     * 
     */
    @FXML
    private void searchmember(ActionEvent event)throws ClassNotFoundException, SQLException {
        
          String  Mid = memid.getText();
        
        if(Mid.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Enter Member Id");
        }
         else
        {
         try {
              Class.forName("com.mysql.jdbc.Driver");
                
                con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/login", "root","Urbder899");
             
                   
             pst = con.prepareStatement("Select * from member where Member_Id = ?");
             
             pst.setString(1, Mid);
             ResultSet rs = pst.executeQuery();
 
             if(rs.next()==true)
             {
                
                 String name= rs.getString(2);
                 Name.setText(name);
                 String Cont = rs.getString(3);
                 Contact.setText(Cont);
                 String email = rs.getString(4);
                 Email.setText(email);
                 String Add = rs.getString(5);
                 Address.setText(Add);
                 
             } 
             
             else
             {
                              JOptionPane.showMessageDialog(null, "Member not found");

             }
            
            }
         
         catch (ClassNotFoundException | SQLException ex) 
         {
                    ex.printStackTrace();
         }
    }
    
}
}