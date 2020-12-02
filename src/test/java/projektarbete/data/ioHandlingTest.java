package projektarbete.data;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class ioHandlingTest {


    @Test
    void loadHashMapFromJsonWithEmptyJson() {

    }

    @Order(1)
    @Test
    void checkIfFileExists() {
        ioHandling.checkIfFileExists("src/test/java/projektarbete/data/testData.json");

    }

    @Test
    void saveHashMapToJson() {

    }
}