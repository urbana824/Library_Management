
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author Urbana Musharrat Haider,180041110
 */
public class AllBooksFXMLController implements Initializable {

    @FXML
    private TableView<Book> table;
    @FXML
    private TableColumn<Book, String> BookID;
    @FXML
    private TableColumn<Book, String> BookTitle;
    @FXML
    private TableColumn<Book, String> Author;
    @FXML
    private TableColumn<Book, String> Publisher;
    @FXML
    private Button gomain;
    @FXML
    private AnchorPane tablepane;
    private ObservableList<Book>data;
   
    Connection con;
    PreparedStatement pst;
    //ResultSet rs;
    @FXML
    private Button view;

    /**
     * Initializes the controller class
     * @param url the location used to resolve relative paths for the root object, or null if the location is not known
     * @param rb the resources used to localize the root object, or null if the root object was not localized
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //initCol();
    } 
    
     /**
     * when this button is clicked ,it will return to the main menu.
     * @param event actions that will occur when button is pressed
     * @throws IOException
     * 
     */

    @FXML
    private void Backtomainmenu(ActionEvent event) throws IOException {
        
         AnchorPane pane = FXMLLoader.load(getClass().getResource("Main_menuFXML.fxml"));
         tablepane.getChildren().setAll(pane);
    }

   
    /**
     * when  View button is pressed ,it will show all book information in the database.
     * @param event actions that will occur when button is pressed
     * @throws SQLException
     * 
     */

    @FXML
    private void viewtable(ActionEvent event) throws SQLException, ClassNotFoundException {
        try {
                Class.forName("com.mysql.jdbc.Driver");
                
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/login", "root","Urbder899");
                data=FXCollections.observableArrayList();
              
                
                ResultSet rs=con.createStatement().executeQuery("SELECT * FROM books");
                
                while(rs.next())
                {
                
                  data.add(new Book (rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                  
                }
                
    
                    
            } 
            catch (ClassNotFoundException ex) {
                Logger.getLogger(AllBooksFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                throw ex;
            }
            
        BookID.setCellValueFactory(new PropertyValueFactory<>("book_id"));
        BookTitle.setCellValueFactory(new PropertyValueFactory<>("book_title"));
        Author.setCellValueFactory(new PropertyValueFactory<>("author"));
        Publisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        table.setItems(null);
        table.setItems(data);
        
        
    }

   
}
    

