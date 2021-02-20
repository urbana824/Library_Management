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
public class SearchBook_FXMLController implements Initializable {

    @FXML
    private Button Search;
    @FXML
    private Button cancel;
    @FXML
    private Label bookid;
    @FXML
    private Label author;
    @FXML
    private Label pub;
    @FXML
    private AnchorPane searchbook;
    @FXML
    private TextField Bookname;

    
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
    private void HanndleCancel(ActionEvent event) throws IOException {
        
         AnchorPane pane = FXMLLoader.load(getClass().getResource("Main_menuFXML.fxml"));
         searchbook.getChildren().setAll(pane);
    }
    
     /**
     * when  Search button is pressed ,it will show the searched book information.
     * @param event actions that will occur when button is pressed
     * @throws SQLException
     * @throws ClassNotFoundException
     * 
     */
    @FXML
    private void HandleSearch(ActionEvent event)  throws ClassNotFoundException, SQLException{
        
        
         String  Bname = Bookname.getText();
        
        if(Bname.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Enter Book Name");
        }
         else
        {
         try {
              Class.forName("com.mysql.jdbc.Driver");
                
                con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/login", "root","Urbder899");
             
                   
             pst = con.prepareStatement("Select * from books where Book_Title = ?");
             
             pst.setString(1, Bname );
             ResultSet rs = pst.executeQuery();
 
             if(rs.next()==true)
             {
                
                 String bid= rs.getString(1);
                 bookid.setText(bid);
                 String aut = rs.getString(3);
                 author.setText(aut);
                 String publisher = rs.getString(4);
                 pub.setText(publisher);
                
                 
             }  
             
             else 
             {
                   JOptionPane.showMessageDialog(null, "Book not available");

             }
                 
            
            }
         
         catch (ClassNotFoundException | SQLException ex) 
         {
                    ex.printStackTrace();
         }
    }
    }

   
    
}
