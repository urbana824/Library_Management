
package Library_Management;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Urbana Musharrat Haider,180041110
 */
public class Book {
    private final SimpleStringProperty book_id;
    private final SimpleStringProperty book_title;
    private final SimpleStringProperty author;
    private final SimpleStringProperty publisher;
    
    
    
    public Book(String id,String title, String thor,String pub)
   {
   this.book_id = new SimpleStringProperty(id);
   this.book_title = new SimpleStringProperty(title);
   this.author= new SimpleStringProperty(thor);
   this.publisher = new SimpleStringProperty(pub);
   }

        public String getBook_id() {
            return book_id.get();
        }
        public String getBook_title(){
            return book_title.get();
        }

        public String getAuthor() {
            return author.get();
        }

        public String getPublisher() {
            return publisher.get();
        }
     
     
   }
  
  

    

