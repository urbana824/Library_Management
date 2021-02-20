/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library_Management;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author HP
 */
public class Issued {

    private final SimpleStringProperty mem_id;
    private final SimpleStringProperty book_id;
    
    
    
    public Issued(String mid,String bid)
   {
   this.mem_id = new SimpleStringProperty(mid);
   this.book_id = new SimpleStringProperty(bid);
   
   }

        public String getMem_id() {
            return mem_id.get();
        }
        public String getBook_id(){
            return book_id.get();
        } 
     
   }
    

