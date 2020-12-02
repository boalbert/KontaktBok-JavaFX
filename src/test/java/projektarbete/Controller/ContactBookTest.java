package projektarbete.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import projektarbete.Main.MainMenu;


import static org.junit.jupiter.api.Assertions.*;

class ContactBookTest {


    @BeforeEach
    void setUp() {
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

    @RepeatedTest(5)
    void addWorkContactToContactBook () {
        ContactBook.addWorkContactToContactBook("Jannis", "Mueller", "1234", "jannis@email.de", "senab", "PK", "123456");
        assertEquals("1234", MainMenu.workContactHashMap.get("Jannis").getPhoneNumber());

        }
    }