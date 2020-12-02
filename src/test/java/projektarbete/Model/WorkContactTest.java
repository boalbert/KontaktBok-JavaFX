package projektarbete.Model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class WorkContactTest {

    @BeforeAll
    static void beforeAllTest(){
        System.out.println("Starting tests of Getter methods from Class WorkContact");
    }
    @AfterEach
    void afterEachTest(TestInfo testInfo){
        System.out.println(testInfo.getDisplayName() + " done!");
    }
    @Test
    void TestGetCompany() {
        WorkContact workContact = new WorkContact("Jannis", "Mueller","12345",
                "jannis@test.de","Senab","monkey","1223");
        assertFalse(workContact.getCompany().isEmpty());
    }

    @Test
    void TestGetTitle() {
        WorkContact workContact = new WorkContact("Jannis", "Mueller","12345",
                "jannis@test.de","Senab","monkey","1223");
        assertNotEquals("",workContact.getTitle());
    }

    @Test
    void TestGetJobPhoneNumber() {
        WorkContact workContact = new WorkContact("Jannis", "Mueller","12345",
                "jannis@test.de","Senab","monkey","1223");
        assertEquals("1223",workContact.getJobPhoneNumber());
    }

    @AfterAll
    static void afterAllTest() {
        System.out.println("Tests of Getter methods from Class WorkContact finished");
    }
}