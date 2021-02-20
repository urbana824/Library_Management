
package Library_Management;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Urbana
 */
public class Login extends Application{

    @Override
    public void start(Stage stage) throws Exception {
         Parent root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Library_Management_Login");
        stage.setScene(scene);
        stage.show();
        
        
        
    }
    
    public static void main (String[] args){
        launch(args);
    }
    
}
