package projektarbete.Controller;

import org.junit.jupiter.api.*;
import projektarbete.Main.MainMenu;


import static org.junit.jupiter.api.Assertions.*;

class ContactBookTest {


    @BeforeAll
    static void beforeAllTest() {
        System.out.println("Starting tests of Getter methods from Class WorkContact");
    }

    @AfterEach
    void afterEachTest(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName() + " done!");
    }

    @Test
    void searchContact() {
    }

    @Test
    void removeContact() {
    }

    @Test
    void updateContactBook() {

    }

    @Test
    void TestPrintContactBook (){
        assertEquals("Contact list is empty",ContactBook.printContactBook());
    }

    @RepeatedTest(5)
    void addWorkContactToContactBook () {
        ContactBook.addWorkContactToContactBook("Jannis", "Mueller", "1234", "jannis@email.de", "senab", "PK", "123456");
        assertEquals("1234", MainMenu.workContactHashMap.get("Jannis").getPhoneNumber());

        }

    @AfterAll
    static void afterAllTest() {
        System.out.println("Tests of Getter methods from Class WorkContact finished");
    }

    }
