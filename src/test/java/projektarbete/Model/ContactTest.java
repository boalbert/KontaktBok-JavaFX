package projektarbete.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {


//    firstName;
//    lastName;
//    phoneNumber;
//    email;
    @BeforeAll
    static void beforeAllTest() {
        System.out.println("Testing getters");
    }
    @AfterEach
    void afterEachTest(TestInfo testInfo){
        System.out.println(testInfo.getDisplayName() + " done!");
    }
    @Test
    void getFirstName() {
        Contact Contact = new WorkContact("Joakim", "Liden","123",
                "joakim@test.se","Vrör","montör","123");
        assertFalse(Contact.getFirstName().isEmpty());
    }

    @Test
    void getLastName() {
        Contact Contact = new WorkContact("Joakim", "Liden","123",
                "joakim@test.se","Vrör","montör","123");
        assertFalse(Contact.getFirstName().isEmpty());
    }

    @Test
    void getPhoneNumber() {
        Contact Contact = new WorkContact("Joakim", "Liden","123",
                "joakim@test.se","Vrör","montör","123");
        assertFalse(Contact.getFirstName().isEmpty());
    }

    @Test
    void getEmail() {
        Contact Contact = new WorkContact("Joakim", "Liden","123",
                "joakim@test.se","Vrör","montör","123");
        assertFalse(Contact.getFirstName().isEmpty());
    }
}