package projektarbete.data;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class IoHandlingTest {


    @Test
    void loadHashMapFromJsonWithEmptyJson() {

    }

    @Order(1)
    @Test
    void checkIfFileExists() {
        IoHandling.checkIfFileExists("src/test/java/projektarbete/data/testData.json");

    }

    @Test
    void saveHashMapToJson() {

    }
}