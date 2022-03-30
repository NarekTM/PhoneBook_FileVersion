package validator;

import java.util.regex.Pattern;

public class Validator {
    public static final Pattern NAME_PATTERN = Pattern.compile("(.*){1,50}$");
    public static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile(
            "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
            + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
            + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$");
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean isValidChoice(String choice) {
        return true;
    }

    public static boolean isValidContactName(String contactName) {
        return true;
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return true;
    }

    public static boolean isValidEmail(String email) {
        return true;
    }

    public static boolean isValidCompanyName(String companyName) {
        return true;
    }
}
