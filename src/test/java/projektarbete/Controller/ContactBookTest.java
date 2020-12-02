package projektarbete.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import projektarbete.Main.Main;
import projektarbete.Main.MainMenu;
import projektarbete.Model.Contact;
import projektarbete.Model.WorkContact;

import javax.naming.ldap.Control;

import static org.junit.jupiter.api.Assertions.*;

class ContactBookTest {

    WorkContact wc = new WorkContact("Test","Test","005315","salfsgqekgeqgkq","fsasf","wqerwq","13535136");

    @BeforeEach
    void setUp() {

    }

    @Test
    void searchContact() {
        WorkContact wc = new WorkContact("Test","Test","005315","salfsgqekgeqgkq","fsasf","wqerwq","13535136");
        MainMenu.workContactHashMap.put(wc.getFirstName(),wc);
        assertNotNull(ContactBook.searchContact("Test"));
        assertNull(ContactBook.searchContact("ingensomheterdethär"));
    }

    @Test
    void removeContact() {
        WorkContact wc = new WorkContact("Test","Test","005315","salfsgqekgeqgkq","fsasf","wqerwq","13535136");
        MainMenu.workContactHashMap.put(wc.getFirstName(),wc);
        assertNotNull(MainMenu.workContactHashMap.get(wc.getFirstName()));
        ContactBook.removeContact(wc.getFirstName());
        assertNull(MainMenu.workContactHashMap.get("SkaVaNull"));
        assertTrue(!MainMenu.workContactHashMap.containsKey(wc.getFirstName()));
        assertFalse(MainMenu.workContactHashMap.containsKey(wc.getFirstName()));
    }


    @ParameterizedTest
    @ValueSource (ints = {1,2,3,5,6,7})
    void updateContactBook(int x) {
        String key = "Test";
        WorkContact wc = new WorkContact("Test","Test","005315","salfsgqekgeqgkq","fsasf","wqerwq","13535136");
        MainMenu.workContactHashMap.put(wc.getFirstName(), wc);

        ContactBook.updateContactBook(x,MainMenu.workContactHashMap.get(key).getFirstName(),"Fungerar");
        assertNotEquals(wc == MainMenu.workContactHashMap.get(key), wc.getLastName() == "DetSkaInteVaDetHär");
        // 4  = update - FirstName : Måste vara självständigt eftersom firstName ==  HashMap<Key, WorkContact>()
        ContactBook.updateContactBook(4,key,"Fungerar");
        assertNotEquals(MainMenu.workContactHashMap.get("Fungerar").getFirstName() == "Fungerar",
                        MainMenu.workContactHashMap.get("Fungerar").getFirstName() == key);
    }

    @Test
    void printContactBook() {

    }

    @Test
    void addWorkContactToContactBook() {


    }
}