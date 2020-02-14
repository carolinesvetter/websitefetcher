package csv.websitefetcher;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Utils {

    public static <T> List<T> removeDuplicatesFromList(List<T> list) {
        List<T> newList = new ArrayList<T>();
        for (T element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }

        return newList;
    }


    public static List<File> getAllFiles(final File folder) {
        List<File> files = new ArrayList<>();
        for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            if (fileEntry.isDirectory()) {
                getAllFiles(fileEntry);
            } else {
                files.add(fileEntry);
            }
        }
        return files;
    }
}
