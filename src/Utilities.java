/**
 * Created by matias on 7/15/16.
 */
public class Utilities {
    public static String adapt(String s, int size) {
        String r = s;
        if (s.length() > size) {
            r = s.substring(0, size);
        }
        else {
            for (int i = s.length(); i < size; i++) {
                r = r + " ";
            }
        }
        return r;
    }
}
