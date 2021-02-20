
package Library_Management;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Urbana Musharrat Haider, 180041110
 */
public class Member {
    
    
    private final SimpleStringProperty mem_id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty contact;
    private final SimpleStringProperty email;
    private final SimpleStringProperty address;
    
    
    public Member(String mid,String mname, String phn,String eid, String add )
   {
   this.mem_id = new SimpleStringProperty(mid);
   this.name = new SimpleStringProperty(mname);
   this.contact= new SimpleStringProperty(phn);
   this.email = new SimpleStringProperty(eid);
   this.address = new SimpleStringProperty(add);  
   }

   
   
 public String getMem_id() {
            return mem_id.get();
        }
        public String getName(){
            return name.get();
        }

        public String getContact() {
            return contact.get();
        }

        public String getEmail() {
            return email.get();
        }
        
        public String getAddress() {
            return address.get();
        }
    
    
}
