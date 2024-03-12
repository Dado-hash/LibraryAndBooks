import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LibraryPersistence {
    private static final String FILENAME = "library.json";
    private static final Gson gson = new Gson();

    public static void saveLibrary(Library library) {
        try (Writer writer = new FileWriter(FILENAME)) {
            gson.toJson(library.getCatalog(), writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Library loadLibrary() {
        List<Book> catalog = new ArrayList<>();
        try (Reader reader = new FileReader(FILENAME)) {
            Type listType = new TypeToken<ArrayList<Book>>(){}.getType();
            catalog = gson.fromJson(reader, listType);
        } catch (FileNotFoundException e) {
            System.err.println("Library file not found or not yet created. Generating a new library.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Library("My Library", "123 Main St", catalog);
    }
}
