package projektarbete.Model;

import org.junit.jupiter.api.*;

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
        System.out.println(testInfo.getDisplayName() + " OK!");
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
        assertEquals("Liden", Contact.getLastName());
    }

    @Test
    void getPhoneNumber() {
        Contact Contact = new WorkContact("Joakim", "Liden","123",
                "joakim@test.se","Vrör","montör","123");
        assertNotEquals("000", Contact.getPhoneNumber());
    }

    @Test
    void getEmail() {
        Contact Contact = new WorkContact("Joakim", "Liden","123",
                "joakim@test.se","Vrör","montör","123");
        assertEquals("joakim@test.se", Contact.getEmail());
    }

    @AfterAll
    static void afterAllTest() {
        System.out.println("All tests finished");
    }
}