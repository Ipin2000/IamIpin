package Business;

import Entity.Doctor;

import javax.print.Doc;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator
{
    private final static Pattern DOB_PATTERN = Pattern.compile("((?:0?[0-9])|(?:[1-2][0-9])|(?:3[0-1]))/((?:0?[1-9])|(?:1[0-2]))/(\\d{4})");
    private final static Pattern MOBILE_PATTERN = Pattern.compile("^\\(\\d{3}\\)-\\d{3}-\\d{4}");
    private final static Pattern EMAIL_PATTERN = Pattern.compile("^\\S+@\\S+\\.\\S+$");

    private final static String DATE_FORMAT = "dd/MM/yyyy";

    public static boolean isValidPhoneNumber(String phoneNumber)
    {
        return MOBILE_PATTERN.matcher(phoneNumber).matches();
    }

    public static boolean isValidEmail(String email)
    {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean isValidDateOfBirth(String dob)
    {
        return DOB_PATTERN.matcher(dob).matches() && isDateValid(dob) && getDobDetails(dob)[0] > 1990;
    }

    public static boolean isValidName(String name){
        return name.length() < 50;
    }
    public static boolean isValidSpec(String spec){
        return spec.length() <255;
    }
    public static boolean isValidAvail(int availCode){
        return Math.max(0,availCode) == Math.min(3,availCode);
    }


    public static int[] getDobDetails(String dob)
    {
        Matcher matcher = DOB_PATTERN.matcher(dob);
        matcher.matches();
        return new int[]{Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(1))};
    }

    private static boolean isDateValid(String date)
    {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

}
