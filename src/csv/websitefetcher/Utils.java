package csv.websitefetcher;

import java.util.ArrayList;
import java.util.List;

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
}
