package projektarbete.data;

import org.junit.jupiter.api.*;
import projektarbete.Model.WorkContact;
import java.io.File;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)

class IoHandlingTest {

    static String correctFilePath = "src/test/java/projektarbete/data/testData.json";
    static String wrongFilePath = "src/test/java/projektarbete/data/wrongFilePath.json";

    @BeforeAll
    static void beforeAllTest_DeleteTestFiles() {

        File deleteTestFile = new File(correctFilePath);
        if (deleteTestFile.delete()) {
            System.out.println(correctFilePath + " has been deleted before running tests.");
        } else {
            System.out.println(correctFilePath + " not found, nothing do delete!");
        }

    }

    @AfterAll
    static void AfterAllTest_DeleteTestFiles() {

        File f = new File(correctFilePath);
        if (f.delete()) {
            System.out.println(correctFilePath + " has been deleted after running tests.");
        } else {
            System.out.println(correctFilePath + " not found, nothing do delete!");
        }

    }

    @Test()
    @Order(2)
    void saveHashMapToJson_WithEmptyHashMap_SavesCorrectly() {

        HashMap<String, WorkContact> emptyHashMap = new HashMap<>();

        IoHandling.saveHashMapToJson(emptyHashMap, correctFilePath);

        assertTrue(IoHandling.checkIfFileExists(correctFilePath));

    }

    @Test
    @Order(1)
    void saveHasMapToJson_WithPopulatedHashMap_SavesCorrectly() {
        HashMap<String, WorkContact> populatedHashMap = new HashMap<>();
        WorkContact workContact = new WorkContact("Firstname", "Lastname", "Phone", "Email", "Company", "Title", "JobPhone");
        populatedHashMap.put("Key", workContact);

        IoHandling.saveHashMapToJson(populatedHashMap, correctFilePath);

        assertTrue(IoHandling.checkIfFileExists(correctFilePath));
        assertFalse(IoHandling.loadHashMapFromJson(correctFilePath).isEmpty());

    }

}