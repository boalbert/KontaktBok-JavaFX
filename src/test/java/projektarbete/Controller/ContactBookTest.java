package projektarbete.Controller;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import projektarbete.Main.MainMenu;

import static org.junit.jupiter.api.Assertions.*;
import static projektarbete.Controller.ContactBook.printContactBook;

import projektarbete.Model.*;

class ContactBookTest {


    @BeforeAll
    static void beforeAllTest() {
        System.out.println("Starting tests");
    }

    @AfterEach
    void afterEachTest(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName() + " done!");
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
    @ValueSource(ints = {1,2,3,5,6,7})
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
    void printContactBookVerifyIfErrorMessageNotShowsIfHashMapIsNotEmpty () {
        assertEquals("Contact List printed", printContactBook());
    }

    @Test
    void printContactBookVerifyIfErrorMessageShowsIfHashMapIsEmpty (){
        //empty HashMap
        MainMenu.workContactHashMap.clear();
        assertEquals("Contact list is empty",printContactBook());
    }

   @Test
    void addWorkContactToContactBookThenVerifyThatContactsPhoneNumberIsInHashMap () {
        ContactBook.addWorkContactToContactBook("Jannis", "Mueller", "1234", "jannis@email.de", "senab", "PK", "123456");
        assertEquals("1234", MainMenu.workContactHashMap.get("Jannis").getPhoneNumber());
        }

    @Test
    void addWorkContactToContactBookThenVerifyThatWrongContactsLastNameIsNotInHashMap () {
        ContactBook.addWorkContactToContactBook("Jannis", "Mueller", "1234", "jannis@email.de", "senab", "PK", "123456");
        assertNotEquals("notTheRightName", MainMenu.workContactHashMap.get("Jannis").getPhoneNumber());
    }
    @AfterAll
    static void afterAllTest() {
        System.out.println("Tests for Class ContactBook finished");
    }

}
