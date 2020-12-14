package projektarbete.Controller;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
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
        assertNotNull(MainMenu.workContactHashMap);
        assertNotNull(ContactBook.searchContact("Test"));
        assertNull(ContactBook.searchContact("ingensomheterdethär"));
        assertEquals("Test" == wc.getFirstName(), wc.getFirstName() == MainMenu.workContactHashMap.get(wc.getFirstName()).getFirstName());
    }

    @Test
    void removeContact() {
        WorkContact wc = new WorkContact("Test","Test","005315","salfsgqekgeqgkq","fsasf","wqerwq","13535136");
        MainMenu.workContactHashMap.put(wc.getFirstName(),wc);
        assertNotNull(MainMenu.workContactHashMap.get(wc.getFirstName()));
        ContactBook.removeContact(wc.getFirstName());
        assertNull(MainMenu.workContactHashMap.get(wc.getFirstName()));
        assertTrue(!MainMenu.workContactHashMap.containsKey(wc.getFirstName()));
        assertFalse(MainMenu.workContactHashMap.containsKey(wc.getFirstName()));
    }


    @ParameterizedTest
    @ValueSource(ints = {1,2,3,5,6,7})
    void updateContactBook(int x) {
        String key = "Test";
        WorkContact wc = new WorkContact("Test","Kanot","005315","salfsgqekgeqgkq","fsasf","wqerwq","13535136");
        MainMenu.workContactHashMap.put(wc.getFirstName(), wc);

        ContactBook.updateContactBook(x,MainMenu.workContactHashMap.get(key).getFirstName(),"Fungerar");
        assertNotEquals(wc == MainMenu.workContactHashMap.get(key), wc.getLastName() == "FungerarInte");
        // 4  = update - FirstName : Måste vara självständigt eftersom firstName ==  HashMap<Key, WorkContact>()
        ContactBook.updateContactBook(4,key,"Fungerar");
        assertNotEquals(MainMenu.workContactHashMap.get("Fungerar").getFirstName() == "Fungerar",
                        MainMenu.workContactHashMap.get("Fungerar").getFirstName() == key);
    }

    /**
     * tests if error message is not thrown when hashmap is not empty.instead
     * it should throw the message "Contact List printed"
     */
    @Test
    void printContactBookVerifyIfErrorMessageNotShowsIfHashMapIsNotEmpty () {
        assertEquals("Contact List printed", printContactBook());
    }

    /**
     * tests if error message is thrown when hashmap is empty
     */
    @Test
    void printContactBookVerifyIfErrorMessageShowsIfHashMapIsEmpty (){
        //empty HashMap
        MainMenu.workContactHashMap.clear();
        assertEquals("Contact list is empty",printContactBook());
    }

    /**
     * tests if llegalArgumentException is thrown when first name is null
     * @throws Exception
     */
    @Test
    void testFirstNameIsNullWhenAddWorkContactToContactBook() throws Exception {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ContactBook.addWorkContactToContactBook(null, "Mueller", "1234", "jannis@email.de", "senab", "PK", "123456");
            }
        });
    }

    /**
     * Test if an added contact finds in hashmap by checking if phone number is the same
     * @throws Exception
     */
   @Test
    void addWorkContactToContactBookThenVerifyThatContactsPhoneNumberIsInHashMap () throws Exception {
        ContactBook.addWorkContactToContactBook("Jannis", "Mueller", "1234", "jannis@email.de", "senab", "PK", "123456");
        assertEquals("1234", MainMenu.workContactHashMap.get("Jannis").getPhoneNumber());
        }

    /**
     * Test if a wrong Name is not to be found in hashmap
     * @throws Exception
     */
    @Test
    void addWorkContactToContactBookThenVerifyThatWrongContactsLastNameIsNotInHashMap () throws Exception{
        ContactBook.addWorkContactToContactBook("Jannis", "Mueller", "1234", "jannis@email.de", "senab", "PK", "123456");
        assertNotEquals("notTheRightName", MainMenu.workContactHashMap.get("Jannis").getPhoneNumber());
    }
    @AfterAll
    static void afterAllTest() {
        System.out.println("Tests for Class ContactBook finished");
    }

}
