package projektarbete.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import projektarbete.Main.MainMenu;


import java.util.HashMap;

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

    @Test
    void printContactBook() {

    }

    @Test
    void addWorkContactToContactBook () {
        ContactBook.addWorkContactToContactBook("Jannis", "Mueller", "1234", "jannis@email.de", "senab", "PK", "123456");
        assertEquals("1234", MainMenu.workContactHashMap.get("Jannis").getPhoneNumber());

        }
    }