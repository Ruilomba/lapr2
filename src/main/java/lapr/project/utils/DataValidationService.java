package lapr.project.utils;

import java.util.regex.*;

/**
 *
 * @author inesmartins
 */
public class DataValidationService {
    
    public static boolean emailIsValid(String email) {
        Pattern validEmailAddressPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher m = validEmailAddressPattern.matcher(email);
        return m.matches();
    }
    
}
