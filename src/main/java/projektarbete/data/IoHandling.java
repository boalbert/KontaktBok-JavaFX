package projektarbete.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import projektarbete.Model.WorkContact;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class IoHandling {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     *
     * @param filepath to .json file
     * @return true if file found / false if file not found
     */
    public static boolean checkIfFileExists(String filepath) {
        System.out.println("Searching for .json-file...");

        Path path = Paths.get(filepath);

        if (Files.exists(path)) {

            if (Files.isRegularFile(path)) {
                System.out.println(".json-file was found.");
                return true;
            }

        } else {
            System.out.println(".json-file not found, will be created on exit.");
            return false;
        }

        return false;
    }


    /**
     * Executes when we start the program.
     * @return HashMap populated from .json-file.
     */
    public static HashMap<String, WorkContact> loadHashMapFromJson(String filepath) {

        if (checkIfFileExists(filepath)) {
            Type typeHashMap = new TypeToken<HashMap<String, WorkContact>>() {
            }.getType();


            try (FileReader fileReader = new FileReader(filepath)) {

                // Load HashMap from FileReader via Gson, we use Type parameter to specify what data we're loading
                HashMap<String, WorkContact> loadedWorkContacts = gson.fromJson(fileReader, typeHashMap);

                if (null == loadedWorkContacts) {
                    System.out.println(".json-file was empty, returning an empty HashMap.");
                    loadedWorkContacts = new HashMap<>();
                } else {
                    System.out.println(".json-file was not empty. Returning populated HashMap.");

                }

                return loadedWorkContacts;

            } catch (IOException e) {
                System.out.println("File was not found... throwing IOException");
                e.printStackTrace();
            }

        } else {
            System.out.println("Starting from scratch with an empty HashMap");
        }
        return new HashMap<>();
    }


    /**
     * Executes when we exit the program.
     * @param saveHashMap to .json file
     */
    public static void saveHashMapToJson(HashMap<String, WorkContact> saveHashMap, String filepath) {

        try (FileWriter fileWriter = new FileWriter(filepath)) {
            gson.toJson(saveHashMap, fileWriter);
            System.out.println("Writing updated HashMap to .json.");

        } catch (IOException e) {
            System.out.println("Writing to .json failed.");
            e.printStackTrace();
        }

    }
}
