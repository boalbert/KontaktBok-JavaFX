package projektarbete.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import projektarbete.Model.WorkContact;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class IoHandling {

    public static final String filepath = "src/main/java/projektarbete/data/workcontacs.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * @param filepath to .json file
     * @return true if file found / false if file not found
     */
    public static boolean checkIfFileExists(String filepath) {
        System.out.println("Searching for .json-file...");

        Path path = Paths.get(filepath);

        if (Files.exists(path) && Files.isRegularFile(path)) {
            System.out.println(".json-file was found.");
            return true;

        } else {
            System.out.println(".json-file not found, will be created on exit.");
            return false;
        }
    }


    /**
     * Executes when we start the program.
     * * If file is empty -> Return an empty HashMap
     * * If file not found -> Return an empty HashMap
     *
     * @return HashMap populated from .json-file.
     */
    public static HashMap<String, WorkContact> loadHashMapFromJson(String filepath) {

        if (checkIfFileExists(filepath)) {
            Type typeHashMap = new TypeToken<HashMap<String, WorkContact>>() {
            }.getType();

            try (FileReader fileReader = new FileReader(filepath)) {

                HashMap<String, WorkContact> loadedWorkContacts = gson.fromJson(fileReader, typeHashMap);

                if (loadedWorkContacts == null) {
                    System.out.println(".json-file was empty, returning an empty HashMap.");
                    loadedWorkContacts = new HashMap<>();
                } else {
                    System.out.println(".json-file was not empty. Returning populated HashMap.");
                }

                return loadedWorkContacts;

            } catch (FileNotFoundException e) {
                System.out.println("Failed to open file: " + e.toString());
                System.out.println("Double check filepath parameter: " + filepath);
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Failed to read file: " + e.toString());
                e.printStackTrace();
            }

        } else {
            System.out.println("Could not find file at: " + filepath);
            System.out.println("Starting from scratch with an empty HashMap");
        }
        return new HashMap<>();
    }


    /**
     * Executes when we exit the program.
     *
     * @param saveHashMap to .json file
     */
    public static void saveHashMapToJson(HashMap<String, WorkContact> saveHashMap, String filepath) {

        try (FileWriter fileWriter = new FileWriter(filepath)) {
            gson.toJson(saveHashMap, fileWriter);
            System.out.println("Writing updated HashMap to .json at " + filepath);

        } catch (FileNotFoundException e) {
            System.out.println("Caught exception: " + e.toString());
            System.out.println("Double check filepath parameter: " + filepath);
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("Caught exception: " + e.toString());
            System.out.println("Failed to write to file at: " + filepath);
            e.printStackTrace();
        }
    }
}
