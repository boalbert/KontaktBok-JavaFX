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

    /**
     * Deletes test .json-file before and after tests is executed
     */
    @BeforeAll
    @AfterAll
    static void before_And_AfterAllTest_DeleteTestFiles() {

        try {
            File deleteTestFile = new File(correctFilePath);
            if (deleteTestFile.delete()) {
                System.out.println(correctFilePath + " has been deleted before/after running tests.");
            } else {
                System.out.println(correctFilePath + " not found, nothing do delete!");
            }

        } catch (NullPointerException e) {
            System.out.println("Caught " + e.toString() + "  - check if file path is correct / not null");
            e.printStackTrace();
        }
    }

    /**
     * Asserts that saving an empty HashMap works correctly.
     * FileNotFoundException and IOException is caught inside method.
     */
    @Test()
    @Order(3)
    void saveHashMapToJson_WithEmptyHashMap_SavesCorrectly() {

        HashMap<String, WorkContact> emptyHashMap = new HashMap<>();

        IoHandling.saveHashMapToJson(emptyHashMap, correctFilePath);

        assertTrue(IoHandling.checkIfFileExists(correctFilePath));

    }

    /**
     * Creates a new HashMap, adds one item and then saves it as .json.
     * Uses checkIfFileExists() to see that .json-file has been created at correct path
     * Uses loadHashMapFromJson() to make sure that the HashMap was not empty
     */
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

    /**
     * Method should always return a HashMap, even if file is not found.
     * FileNotFoundException and IOException is caught in method.
     */
    @Test
    @Order(3)
    void loadHashMapFromJson_NotNull() {
        assertNotNull(IoHandling.loadHashMapFromJson(correctFilePath));
        assertNotNull(IoHandling.loadHashMapFromJson(wrongFilePath));
    }

    /**
     * Asserts that the method returns boolean when file found/not found.
     * Order(4) because Test(2) should save a file to the correct path.
     */
    @Test
    @Order(4)
    void checkIfFileExists() {
        assertTrue(IoHandling.checkIfFileExists(correctFilePath));
        assertFalse(IoHandling.checkIfFileExists(wrongFilePath));
    }
}


